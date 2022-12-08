package com.wiseasy.pds.location;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;

import androidx.core.app.ActivityCompat;

/**
 * Created by Android Studio.
 * User: pupan
 * Date: 11/29/2022
 * Time: 4:16 PM
 *
 * @author pupan
 */
public class WiseLocation {
    /**
     * 检查权限
     *
     * @return
     */
    public static boolean checkPermission(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
                    && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;
        } else {
            return true;
        }
    }


    /**
     * 通过GPS获取定位信息
     */
    public static Address getGPSLocation(Context context) {
        if (!checkPermission(context)) {
            return null;
        }
        Location gps = LocationUtils.getGPSLocation(context);
        if (gps == null) {
            //设置定位监听，因为GPS定位，第一次进来可能获取不到，通过设置监听，可以在有效的时间范围内获取定位信息
            LocationUtils.addLocationListener(context, LocationManager.GPS_PROVIDER, location -> LocationUtils.unRegisterListener(context));
            return null;
        } else {
            return LocationUtils.getAddress(context, gps);
        }
    }

    /**
     * 通过网络等获取定位信息
     */
    public static Address getNetworkLocation(Context context) {
        Location net = LocationUtils.getNetWorkLocation(context);
        if (net == null) {
            return null;
        } else {
            return LocationUtils.getAddress(context, net);
        }
    }

    /**
     * 采用最好的方式获取定位信息
     */
    public static Address getBestLocation(Context context) {
        Criteria c = new Criteria();//Criteria类是设置定位的标准信息（系统会根据你的要求，匹配最适合你的定位供应商），一个定位的辅助信息的类
        c.setPowerRequirement(Criteria.POWER_LOW);//设置低耗电
        c.setAltitudeRequired(false);//设置需要海拔
        c.setBearingAccuracy(Criteria.ACCURACY_COARSE);//设置COARSE精度标准
        c.setAccuracy(Criteria.ACCURACY_LOW);//设置低精度

        c.setBearingRequired(false);//取消导向
        c.setCostAllowed(false);//成本
        c.setPowerRequirement(Criteria.POWER_LOW);//功耗
        //... Criteria 还有其他属性，就不一一介绍了
        Location best = LocationUtils.getBestLocation(context, c);
        if (best == null) {
            return null;
        } else {
            return LocationUtils.getAddress(context, best);
        }
    }
}
