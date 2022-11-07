package com.wiseasy.pds.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.wiseasy.pds.sign.Sha256;

import java.security.SecureRandom;
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

    public static void removeAllKey() {
        SharedPreferences.Editor editer = sharedPreferences.edit();
        editer.remove(MAC_ALIAS);
        editer.remove(DATA_ALIAS);
        editer.clear();
        editer.commit();
    }

    private static String getRandomString(final int sizeOfRandomString) {
        final SecureRandom random = new SecureRandom();
        final StringBuilder sb = new StringBuilder(sizeOfRandomString);
        for (int i = 0; i < sizeOfRandomString; i++) {
            sb.append(ALLOWED_CHARACTERS.charAt(random.nextInt(ALLOWED_CHARACTERS.length())));
        }
        return sb.toString();
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
    public static String doEncrypt(String planText) {
        try {
            String dataKey = sharedPreferences.getString(data_key, "");
            if ("".equals(dataKey)) {
                return null;
            }
            return AESEncrypt.encrypt(planText, dataKey);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
