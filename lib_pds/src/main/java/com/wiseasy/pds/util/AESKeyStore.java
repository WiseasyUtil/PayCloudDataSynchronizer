package com.wiseasy.pds.util;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyProperties;

import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;


/**
 * @author hugo
 * @date 2022/11/1
 * 基于android秘钥库系统KeyStore
 */
public class AESKeyStore {

    private final static String alias = "AESKeyStore";
    private final static String keyStoreType = "AndroidKeyStore";
    //AES/ECB 模式长数据不安全，可以使用CBC/CFB
    private final static String CIPHER_ALGORITHM_AES = "AES/ECB/PKCS7Padding";

    public static void init() {
        boolean hasKey = hasKey();
        if (!hasKey) {
            generateAesKey();
        }
    }

    private static boolean hasKey() {
        KeyStore keyStore = null;
        try {
            keyStore = KeyStore.getInstance(keyStoreType);
            keyStore.load(null);
            return keyStore.containsAlias(alias);
        } catch (KeyStoreException | CertificateException | IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return false;
    }


    /**
     * 加密
     */
    public static String encrypt(String data) {
        SecretKey secretKey = getAesSecretKey();
        if (secretKey != null) {
            Cipher cipher = null;
            try {
                cipher = Cipher.getInstance(CIPHER_ALGORITHM_AES);
                cipher.init(Cipher.ENCRYPT_MODE, secretKey);
                byte[] result = cipher.doFinal(data.getBytes());
                return Base64.encodeToString(result);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (NoSuchPaddingException e) {
                e.printStackTrace();
            } catch (IllegalBlockSizeException e) {
                e.printStackTrace();
            } catch (BadPaddingException e) {
                e.printStackTrace();
            } catch (InvalidKeyException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    /**
     * 解密
     */
    public static String decrypt(String data) {
        SecretKey secretKey = getAesSecretKey();
        if (secretKey != null) {
            Cipher cipher = null;
            try {
                cipher = Cipher.getInstance(CIPHER_ALGORITHM_AES);
                cipher.init(Cipher.DECRYPT_MODE, secretKey);
                byte[] result = cipher.doFinal(Base64.decode(data));
                return new String(result);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (NoSuchPaddingException e) {
                e.printStackTrace();
            } catch (IllegalBlockSizeException e) {
                e.printStackTrace();
            } catch (BadPaddingException e) {
                e.printStackTrace();
            } catch (InvalidKeyException e) {
                e.printStackTrace();
            }
        }
        return data;
    }


    private static void generateAesKey() {
        KeyGenerator keyGenerator = null;
        try {
            keyGenerator = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, keyStoreType);
            KeyGenParameterSpec keyGenParameterSpec = null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                keyGenParameterSpec = new KeyGenParameterSpec.Builder(
                        alias,
                        KeyProperties.PURPOSE_ENCRYPT | KeyProperties.PURPOSE_DECRYPT
                )
                        .setBlockModes(KeyProperties.BLOCK_MODE_ECB)
                        .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_PKCS7)
                        .setKeySize(256)
                        .setRandomizedEncryptionRequired(false)
                        .build();
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                keyGenerator.init(keyGenParameterSpec);
            }
            keyGenerator.generateKey();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
    }


    private static SecretKey getAesSecretKey() {
        KeyStore keyStore = null;
        try {
            keyStore = KeyStore.getInstance(keyStoreType);
            keyStore.load(null);
            return (SecretKey) keyStore.getKey(alias, null);
        } catch (KeyStoreException | CertificateException | IOException | NoSuchAlgorithmException | UnrecoverableKeyException e) {
            e.printStackTrace();
        }
        return null;
    }
}