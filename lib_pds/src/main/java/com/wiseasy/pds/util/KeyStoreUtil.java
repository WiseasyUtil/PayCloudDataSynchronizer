package com.wiseasy.pds.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.wiseasy.pds.security.AESEncrypt;
import com.wiseasy.pds.security.Sha256;

import java.security.SecureRandom;

/**
 * Created by Android Studio.
 * User: pupan
 * Date: 11/7/2022
 * Time: 8:47 AM
 *
 * @author pupan
 */
public class KeyStoreUtil {
    public static String MAC_ALIAS = "mac_alias";
    public static String DATA_ALIAS = "data_alias";
    private static String keyStoreType = "AndroidKeyStore";
    public static String mac_key = "";
    public static String data_key = "";
    private static SharedPreferences sharedPreferences;
    private static final String ALLOWED_CHARACTERS = "0123456789qwertyuiopasdfghjklzxcvbnm";

    public static void init(Context context) {
        sharedPreferences = context.getSharedPreferences(keyStoreType, 0);
        AESKeyStore.init();
        if ("".equals(sharedPreferences.getString(MAC_ALIAS, ""))) {
            createKeyStoreEntry(MAC_ALIAS);
        } else {
            try {
                mac_key = AESKeyStore.decrypt(sharedPreferences.getString(MAC_ALIAS, ""));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if ("".equals(sharedPreferences.getString(DATA_ALIAS, ""))) {
            createKeyStoreEntry(DATA_ALIAS);
        } else {
            try {
                data_key = AESKeyStore.decrypt(sharedPreferences.getString(DATA_ALIAS, ""));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void removeAllKey() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(MAC_ALIAS);
        editor.remove(DATA_ALIAS);
        editor.clear();
        editor.commit();
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
        String key = null;
        try {
            String random = getRandomString(32);
            key = AESKeyStore.encrypt(random);
            if (alias.equals(MAC_ALIAS)) {
                mac_key = random;
            } else {
                data_key = random;
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(alias, key);
            edit.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String doMacEncrypt(String planText, String alias) {
        String mainKey;
        try {
            mainKey = AESKeyStore.decrypt(sharedPreferences.getString(alias, ""));
            if ("".equals(mainKey)) {
                return null;
            }
            String share256 = Sha256.getSHA256(planText);
            String mac = AESEncrypt.encrypt(share256, mainKey);
            return mac;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * AES加密
     *
     * @param planText 待加密内容
     * @return
     */
    public static String doEncrypt(String planText) {
        try {
            String dataKey = AESKeyStore.decrypt(sharedPreferences.getString(DATA_ALIAS, ""));
            if ("".equals(dataKey)) {
                return null;
            }
            return AESEncrypt.encrypt(planText, dataKey);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * AES加密
     *
     * @param planText 待加密内容
     * @return
     */
    public static String doDecrypt(String planText) {
        try {
            String dataKey = AESKeyStore.decrypt(sharedPreferences.getString(DATA_ALIAS, ""));
            if ("".equals(dataKey)) {
                return null;
            }
            return AESEncrypt.decrypt(planText, dataKey);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
