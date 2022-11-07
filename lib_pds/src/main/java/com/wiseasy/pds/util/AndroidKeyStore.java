package com.wiseasy.pds.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.security.keystore.KeyProperties;
import android.security.keystore.KeyProtection;

import com.wiseasy.pds.sign.Base64;

import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by Android Studio.
 * User: pupan
 * Date: 11/7/2022
 * Time: 8:47 AM
 *
 * @author pupan
 */
public class AndroidKeyStore {
    public static String MAC_ALIAS = "mac_alias";
    public static String DATA_ALIAS = "data_alias";
    private static String keyStoreType = "AndroidKeyStore";
    public static String mac_key = "";
    public static String data_key = "";
    private static SharedPreferences sharedPreferences;
    public static String BASE_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA2m4nkQKyQAxJc8VVsz/L6qVbtDWRTBolUK8Dwhi9wH6aygA6363PVNEPM8eRI5W19ssCyfdtNFy6DRAureoYV053ETPUefEA5bHDOQnjbb9PuNEfT651v8cqwEaTptaxj2zujsWI8Ad3R50EyQHsskQWms/gv2aB36XUM4vyOIk4P1f3dxtqigH0YROEYiuwFFqsyJuNSjJzNbCmfgqlQv/+pE/pOV9MIQe0CAdD26JF10QpSssEwKgvKvnXPUynVu09cjSEipev5cLJSApKSDZxrRjSFBXrh6nzg8JK05ehkI8wdsryRUneh0PGN0PgYLP/wjKiqlgTJaItxnb/JQIDAQAB";

    public static void init(Context context) throws Exception {
        sharedPreferences = context.getSharedPreferences(keyStoreType, 0);
        if (!hasKey(MAC_ALIAS) || "".equals(sharedPreferences.getString(MAC_ALIAS, ""))) {
            createKeyStoreEntry(MAC_ALIAS);
        } else {
            mac_key = sharedPreferences.getString(MAC_ALIAS, "");
        }

        if (!hasKey(DATA_ALIAS) || "".equals(sharedPreferences.getString(MAC_ALIAS, ""))) {
            createKeyStoreEntry(DATA_ALIAS);
        } else {
            data_key = sharedPreferences.getString(DATA_ALIAS, "");
        }
    }

    private static boolean hasKey(String alias) throws Exception {
        KeyStore keyStore = KeyStore.getInstance(keyStoreType);
        keyStore.load(null);
        return keyStore.containsAlias(alias);
    }


    private static void createKeyStoreEntry(String alias) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES);
            keyGenerator.init(256);
            SecretKey secretKey = keyGenerator.generateKey();
            if (alias.equals(MAC_ALIAS)) {
                mac_key = new String(Base64.encode(secretKey.getEncoded()));
            } else {
                data_key = new String(Base64.encode(secretKey.getEncoded()));
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(alias, new String(Base64.encode(secretKey.getEncoded())));
            edit.commit();
            SecretKeySpec signingKey = new SecretKeySpec(secretKey.getEncoded(), secretKey.getAlgorithm());
            KeyStore ks = KeyStore.getInstance(keyStoreType);
            ks.load(null);
            KeyStore.SecretKeyEntry entry = new KeyStore.SecretKeyEntry(signingKey);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                ks.setEntry(alias, entry, new KeyProtection.Builder(KeyProperties.PURPOSE_ENCRYPT | KeyProperties.PURPOSE_DECRYPT).setBlockModes(KeyProperties.BLOCK_MODE_GCM)
                        .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE).build());
            }
        } catch (NoSuchAlgorithmException | KeyStoreException e) {
            throw new AssertionError(e);
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String doEncrypt(byte[] raw, byte[] clear) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(clear);
        return new String(Base64.encode(encrypted));
    }

    private static String doDecrypt(byte[] raw, byte[] encrypted) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        byte[] decrypted = cipher.doFinal(encrypted);
        return new String(Base64.encode(decrypted));
    }

    /**
     * 加密
     *
     * @param data  要加密的数据
     * @param alias KeyStore中的别名
     */
    public static String encrypt(byte[] data, String alias) {
        try {
            //取出密钥
            KeyStore keyStore = KeyStore.getInstance(keyStoreType);
            keyStore.load(null);
            KeyStore.SecretKeyEntry entry = (KeyStore.SecretKeyEntry) keyStore.getEntry(alias, null);
            SecretKey secretKey = entry.getSecretKey();
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return new String(Base64.encode(cipher.doFinal(data)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解密
     *
     * @param data  要解密的数据
     * @param alias KeyStore中的别名
     */
    public static String decryptAES(byte[] data, String alias) {
        try {
            //取出密钥
            KeyStore keyStore = KeyStore.getInstance(keyStoreType);
            keyStore.load(null);
            KeyStore.SecretKeyEntry entry = (KeyStore.SecretKeyEntry) keyStore.getEntry(alias, null);
            SecretKey secretKey = entry.getSecretKey();
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(Base64.encode(cipher.doFinal(data)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
