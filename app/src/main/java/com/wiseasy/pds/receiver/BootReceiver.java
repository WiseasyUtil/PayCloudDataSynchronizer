package com.chinafintech.hotel.helper.receiver;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * @author pupan
 */
public class BootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, Intent intent) {
        Log.e("开机启动", "收到广播");
        if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {
            startApp(context);
        }
    }

    private void startApp(Context context) {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        ComponentName cn = new ComponentName("com.chinafintech.hotel.helper", "com.chinafintech.hotel.helper.lanucher.Launcher");
        intent.setComponent(cn);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
