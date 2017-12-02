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

public class i {
    public static String a(long j) {
        return a(j, "0.00K");
    }

    public static String a(long j, String str) {
        if (j == 0) {
            return str;
        }
        String str2;
        DecimalFormat decimalFormat = new DecimalFormat("0.##");
        float f = ((float) j) / 1024.0f;
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

    public static String a(String str) {
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf == -1 || lastIndexOf >= str.length() - 1) {
            return "";
        }
        return str.substring(lastIndexOf + 1).toLowerCase();
    }

    public static String b(String str) {
        int lastIndexOf = str.lastIndexOf(".");
        return (lastIndexOf == -1 || lastIndexOf >= str.length() - 1) ? str : str.substring(0, lastIndexOf);
    }

    public static int a(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public static String c(String str) {
        int lastIndexOf = str.lastIndexOf("/");
        int lastIndexOf2 = str.lastIndexOf(".");
        if (lastIndexOf == -1 || lastIndexOf2 == -1 || lastIndexOf2 <= lastIndexOf) {
            return str;
        }
        return str.substring(lastIndexOf + 1, lastIndexOf2);
    }

    public static String d(String str) {
        int lastIndexOf = str.lastIndexOf("/") + 1;
        int lastIndexOf2 = str.lastIndexOf(".");
        if (lastIndexOf2 == -1 || lastIndexOf2 <= lastIndexOf) {
            return "";
        }
        return str.substring(lastIndexOf, lastIndexOf2);
    }

    public static boolean a(Context context) {
        if (!ConnectivityManager.isNetworkTypeValid(1)) {
            return false;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (a(connectivityManager)) {
            return true;
        }
        if (b(connectivityManager)) {
            return true;
        }
        return false;
    }

    public static boolean a(ConnectivityManager connectivityManager) {
        if (connectivityManager.getNetworkInfo(1).getState() == State.CONNECTED) {
            return true;
        }
        return false;
    }

    public static boolean b(ConnectivityManager connectivityManager) {
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.getState() == State.CONNECTED) {
            return true;
        }
        return false;
    }

    public static int b(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int c(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static void a(View view) {
        if (VERSION.SDK_INT > 10) {
            try {
                View.class.getMethod("setLayerType", new Class[]{Integer.TYPE, Paint.class}).invoke(view, new Object[]{Integer.valueOf(1), null});
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void a(Context context, String str) {
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (Exception e) {
        }
    }
}
