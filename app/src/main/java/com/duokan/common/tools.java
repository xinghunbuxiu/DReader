package com.duokan.common;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

import java.text.DecimalFormat;

public class tools {
    public static String getByteSize(long bytes) {
        return getByteSize(bytes, "0.00K");
    }

    public static String getByteSize(long bytes, String defaut) {
        if (bytes == 0) {
            return defaut;
        }
        String str2;
        DecimalFormat decimalFormat = new DecimalFormat("0.##");
        float f = ((float) bytes) / 1024.0f;
        String str3 = "";
        if (f > 1048576.0f) {
            str2 = decimalFormat.format((double) (f / 1048576.0f)).toString() + "G";
        } else if (f > 1024.0f) {
            str2 = decimalFormat.format((double) (f / 1024.0f)).toString() + "M";
        } else {
            str2 = decimalFormat.format((double) f).toString() + "K";
        }
        return str2;
    }

    public static String substringwerCase(String str) {
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf == -1 || lastIndexOf >= str.length() - 1) {
            return "";
        }
        return str.substring(lastIndexOf + 1).toLowerCase();
    }

    public static String substringToEnd(String str) {
        int lastIndexOf = str.lastIndexOf(".");
        return (lastIndexOf == -1 || lastIndexOf >= str.length() - 1) ? str : str.substring(0, lastIndexOf);
    }

    public static int dip2px(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public static String getHeight(String str) {
        int lastIndexOf = str.lastIndexOf("/");
        int lastIndexOf2 = str.lastIndexOf(".");
        if (lastIndexOf == -1 || lastIndexOf2 == -1 || lastIndexOf2 <= lastIndexOf) {
            return str;
        }
        return str.substring(lastIndexOf + 1, lastIndexOf2);
    }

    public static String substring(String str) {
        int begin = str.lastIndexOf("/") + 1;
        int end = str.lastIndexOf(".");
        if (end == -1 || end <= begin) {
            return "";
        }
        return str.substring(begin, end);
    }

    public static boolean isHasNet(Context context) {
        if (!ConnectivityManager.isNetworkTypeValid(ConnectivityManager.TYPE_WIFI)) {
            return false;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (isWifi(connectivityManager)) {
            return true;
        }
        if (isConnected(connectivityManager)) {
            return true;
        }
        return false;
    }

    public static boolean isWifi(ConnectivityManager connectivityManager) {
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == State.CONNECTED) {
            return true;
        }
        return false;
    }

    public static boolean isConnected(ConnectivityManager connectivityManager) {
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.getState() == State.CONNECTED) {
            return true;
        }
        return false;
    }

    public static int getWidth(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int getHeight(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static void getLayoutType(View view) {
        if (VERSION.SDK_INT > 10) {
            try {
                View.class.getMethod("setLayerType", new Class[]{Integer.TYPE, Paint.class}).invoke(view, new Object[]{Integer.valueOf(1), null});
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 根据url 跳转
     *
     * @param context
     * @param url
     */
    public static void startActivity(Context context, String url) {
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
        } catch (Exception e) {
        }
    }
}
