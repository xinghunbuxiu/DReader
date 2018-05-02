package com.duokan.reader.ui.personal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;

public class mx {
    private static boolean e = false;
    private static mx f;
    private long a = 0;
    private long b = 0;
    private long c = 0;
    private double[] d;
    private final String g = "readTime";
    private long h = 0;
    private double i = 0.0d;

    private mx() {
    }

    public static synchronized mx a() {
        mx mxVar;
        synchronized (mx.class) {
            if (f == null) {
                f = new mx();
            }
            mxVar = f;
        }
        return mxVar;
    }

    public void a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("setting", 0);
        if (sharedPreferences.getBoolean("isfirst", true)) {
            Editor edit = sharedPreferences.edit();
            edit.putLong("day", System.currentTimeMillis());
            edit.putBoolean("isfirst", false);
            edit.apply();
        }
        this.c = sharedPreferences.getLong("pageCount", 0);
        this.b = (System.currentTimeMillis() - sharedPreferences.getLong("day", System.currentTimeMillis())) / 86400000;
        this.h = sharedPreferences.getLong("readTime", 0);
        this.a = sharedPreferences.getLong("readedCount", 0);
        this.d = a(sharedPreferences.getString("TimeDistribution", ""));
        e = true;
    }

    public void b(Context context) {
        if (!e) {
            a(context);
        }
        this.a++;
    }

    private double[] a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d};
        }
        String[] split = str.split(",");
        double[] dArr = new double[split.length];
        for (int i = 0; i < split.length; i++) {
            dArr[i] = Double.valueOf(split[i]).doubleValue();
        }
        return dArr;
    }
}
