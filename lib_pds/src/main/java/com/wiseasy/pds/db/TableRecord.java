package com.wiseasy.pds.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author hugo
 * @date 2022/6/16
 */
public class TableRecord {

    /**
     * table name
     */
    public static String TABLE_NAME = "record";

    /**
     * 字段名称：type
     */
    public static String TYPE_COLUMN = "type";

    /**
     * 字段名称：content
     */
    public static String CONTENT_COLUMN = "content";

    /**
     * record type
     */
    public static int RECORD_TYPE_COMPLETE_TRANSACTION = 1;
    public static int RECORD_TYPE_CLOSE_TRANSACTION = 2;
    public static int RECORD_TYPE_SETTLEMENT = 3;
    public static int RECORD_TYPE_LOG = 4;


    /**
     * insert data
     *
     * @param type
     * @param content
     */
    public static void insert(SQLiteDatabase db, int type, String content) {
        db.beginTransaction();
        if (!query(db, type).isEmpty()) {
            addUpdate(db, type, content);
        } else {
            ContentValues values = new ContentValues();
            values.put(TableRecord.TYPE_COLUMN, type);
            JSONArray array = new JSONArray();
            array.add(JSONObject.parseObject(content));
            values.put(TableRecord.CONTENT_COLUMN, array.toJSONString());
            db.insert(TableRecord.TABLE_NAME, null, values);
        }
        db.setTransactionSuccessful();
        db.endTransaction();
    }

    /**
     * update db
     *
     * @param db
     * @param type
     * @param content
     */
    public static void addUpdate(SQLiteDatabase db, int type, String content) {
        JSONArray array = query(db, type);
        array.add(JSONObject.parseObject(content));
        ContentValues values = new ContentValues();
        values.put(TableRecord.CONTENT_COLUMN, array.toJSONString());
        db.update(TableRecord.TABLE_NAME, values, "type=?", new String[]{type + ""});
    }

    /**
     * update db
     *
     * @param db
     * @param type
     * @param content
     */
    public static void update(SQLiteDatabase db, int type, String content) {
        ContentValues values = new ContentValues();
        values.put(TableRecord.CONTENT_COLUMN, content);
        db.update(TableRecord.TABLE_NAME, values, "type=?", new String[]{type + ""});
    }

    /**
     * query
     *
     * @param type
     */
    public static JSONArray query(SQLiteDatabase db, int type) {
        JSONArray array = new JSONArray();
        if (!isTableIsExist(db, TableRecord.TABLE_NAME)) {
            return array;
        }
        Cursor cursor = db.query(TableRecord.TABLE_NAME, new String[]{TableRecord.TYPE_COLUMN, TableRecord.CONTENT_COLUMN}, "type=?", new String[]{type + ""}, null, null, null);
        if (null != cursor) {
            if (cursor.moveToFirst()) {
                Log.e("query", cursor.getString(1));
                array = JSONArray.parseArray(cursor.getString(1));
            }
        } else {
            Log.e("query", "cursor is null");
        }
        return array;
    }

    /**
     * query database table is exists
     *
     * @param db
     * @param tableName
     * @return
     */
    private static boolean isTableIsExist(SQLiteDatabase db, String tableName) {
        boolean result = false;
        if (tableName == null) {
            return false;
        }
        Cursor cursor;
        try {
            String sql = "select count(*) as c from sqlite_master where type ='table' and name ='" + tableName.trim() + "' ";
            cursor = db.rawQuery(sql, null);
            if (cursor.moveToNext()) {
                int count = cursor.getInt(0);
                if (count > 0) {
                    result = true;
                }
            }
        } catch (Exception ignored) {
        }
        return result;
    }
}
