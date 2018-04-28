package com.duokan.reader.ui.personal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;

public class nl {
    /* renamed from: e */
    private static boolean f8993e = false;
    /* renamed from: f */
    private static nl f8994f;
    /* renamed from: a */
    private long f8995a = 0;
    /* renamed from: b */
    private long f8996b = 0;
    /* renamed from: c */
    private long f8997c = 0;
    /* renamed from: d */
    private double[] f8998d;
    /* renamed from: g */
    private final String f8999g = "readTime";
    /* renamed from: h */
    private long f9000h = 0;
    /* renamed from: i */
    private double f9001i = 0.0d;

    private nl() {
    }

    /* renamed from: a */
    public static synchronized nl m12344a() {
        nl nlVar;
        synchronized (nl.class) {
            if (f8994f == null) {
                f8994f = new nl();
            }
            nlVar = f8994f;
        }
        return nlVar;
    }

    /* renamed from: a */
    public void m12346a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("setting", 0);
        if (sharedPreferences.getBoolean("isfirst", true)) {
            Editor edit = sharedPreferences.edit();
            edit.putLong("day", System.currentTimeMillis());
            edit.putBoolean("isfirst", false);
            edit.apply();
        }
        this.f8997c = sharedPreferences.getLong("pageCount", 0);
        this.f8996b = (System.currentTimeMillis() - sharedPreferences.getLong("day", System.currentTimeMillis())) / 86400000;
        this.f9000h = sharedPreferences.getLong("readTime", 0);
        this.f8995a = sharedPreferences.getLong("readedCount", 0);
        this.f8998d = m12345a(sharedPreferences.getString("TimeDistribution", ""));
        f8993e = true;
    }

    /* renamed from: b */
    public void m12347b(Context context) {
        if (!f8993e) {
            m12346a(context);
        }
        this.f8995a++;
    }

    /* renamed from: a */
    private double[] m12345a(String str) {
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
