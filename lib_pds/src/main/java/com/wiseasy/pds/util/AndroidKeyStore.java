package com.wiseasy.pds.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.security.keystore.KeyProperties;
import android.security.keystore.KeyProtection;

import com.wiseasy.pds.sign.Base64;
import com.wiseasy.pds.sign.Sha256;

import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.util.Random;

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
    private static final String ALG = "AES/ECB/PKCS5Padding";
    public static String mac_key = "";
    public static String data_key = "";
    private static SharedPreferences sharedPreferences;
    private static final String ALLOWED_CHARACTERS = "0123456789qwertyuiopasdfghjklzxcvbnm";
    public static String BASE_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA2m4nkQKyQAxJc8VVsz/L6qVbtDWRTBolUK8Dwhi9wH6aygA6363PVNEPM8eRI5W19ssCyfdtNFy6DRAureoYV053ETPUefEA5bHDOQnjbb9PuNEfT651v8cqwEaTptaxj2zujsWI8Ad3R50EyQHsskQWms/gv2aB36XUM4vyOIk4P1f3dxtqigH0YROEYiuwFFqsyJuNSjJzNbCmfgqlQv/+pE/pOV9MIQe0CAdD26JF10QpSssEwKgvKvnXPUynVu09cjSEipev5cLJSApKSDZxrRjSFBXrh6nzg8JK05ehkI8wdsryRUneh0PGN0PgYLP/wjKiqlgTJaItxnb/JQIDAQAB";

    public static void init(Context context) {
        sharedPreferences = context.getSharedPreferences(keyStoreType, 0);
        if ("".equals(sharedPreferences.getString(MAC_ALIAS, ""))) {
            createKeyStoreEntry(MAC_ALIAS);
        } else {
            mac_key = sharedPreferences.getString(MAC_ALIAS, "");
        }

        if ("".equals(sharedPreferences.getString(DATA_ALIAS, ""))) {
            createKeyStoreEntry(DATA_ALIAS);
        } else {
            data_key = sharedPreferences.getString(DATA_ALIAS, "");
        }
    }

    private static String getRandomString(final int sizeOfRandomString) {
        final Random random = new Random();
        final StringBuilder sb = new StringBuilder(sizeOfRandomString);
        for (int i = 0; i < sizeOfRandomString; i++) {
            sb.append(ALLOWED_CHARACTERS.charAt(random.nextInt(ALLOWED_CHARACTERS.length())));
        }
        return sb.toString();
    }

    private static boolean hasKey(String alias) throws Exception {
        KeyStore keyStore = KeyStore.getInstance(keyStoreType);
        keyStore.load(null);
        return keyStore.containsAlias(alias);
    }


    private static void createKeyStoreEntry(String alias) {
        String key = getRandomString(32);
        if (alias.equals(MAC_ALIAS)) {
            mac_key = key;
        } else {
            data_key = key;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(alias, key);
        edit.commit();
    }

    public static String doMacEncrypt(String planText, String alias) {
        String mainKey = sharedPreferences.getString(alias, "");
        if ("".equals(mainKey)) {
            return null;
        }
        String text = planText + mainKey;
        return Sha256.getSHA256(text);
    }

    /**
     * AES加密
     *
     * @param planText 待加密内容
     * @return
     */
    public static byte[] doEncrypt(String planText, String alias) {
        try {
            String mainKey = sharedPreferences.getString(alias, "");
            if ("".equals(mainKey)) {
                return null;
            }
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(256, new SecureRandom(Base64.decode(mainKey)));
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            byte[] byteContent = planText.getBytes("utf-8");
            cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
            byte[] result = cipher.doFinal(byteContent);
            return result; // 加密
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 解密
     *
     * @param content  待解密内容
     * @param password 解密密钥
     * @return
     */
    public static byte[] decrypt(byte[] content, String password) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance(ALG);
            kgen.init(128, new SecureRandom(password.getBytes("utf-8")));
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, ALG);
            Cipher cipher = Cipher.getInstance(ALG);// 创建密码器
            cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
            byte[] result = cipher.doFinal(content);
            return result; // 加密
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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
