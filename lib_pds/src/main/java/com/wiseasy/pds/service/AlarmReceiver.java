package com.wiseasy.pds.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Android Studio.
 * User: pupan
 * Date: 2022/6/30
 * Time: 16:15
 */
class AlarmReceiver extends BroadcastReceiver {
    public static  String ALARM_EVENT = "com.wiseasy.pds.service.AlarmReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        UploadService.start(context);
    }
}
