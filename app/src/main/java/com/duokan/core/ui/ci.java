package com.duokan.core.ui;

import org.apache.http.HttpStatus;

class ci {
    /* renamed from: a */
    private static float f1070a = ((float) (Math.log(0.75d) / Math.log(0.9d)));
    /* renamed from: b */
    private static float f1071b = 800.0f;
    /* renamed from: c */
    private static float f1072c = 0.4f;
    /* renamed from: d */
    private static float f1073d = (1.0f - f1072c);
    /* renamed from: e */
    private static final float[] f1074e = new float[HttpStatus.SC_SWITCHING_PROTOCOLS];
    /* renamed from: f */
    private static float f1075f = 8.0f;
    /* renamed from: g */
    private static float f1076g;

    static {
        float f = 0.0f;
        int i = 0;
        while (i <= 100) {
            float f2;
            float f3 = ((float) i) / 100.0f;
            float f4 = 1.0f;
            float f5 = f;
            while (true) {
                f = ((f4 - f5) / 2.0f) + f5;
                f2 = (3.0f * f) * (1.0f - f);
                float f6 = ((((1.0f - f) * f1072c) + (f1073d * f)) * f2) + ((f * f) * f);
                if (((double) Math.abs(f6 - f3)) < 1.0E-5d) {
                    break;
                } else if (f6 > f3) {
                    f4 = f;
                } else {
                    f5 = f;
                }
            }
            f1074e[i] = ((f * f) * f) + f2;
            i++;
            f = f5;
        }
        f1074e[100] = 1.0f;
        f1076g = 1.0f;
        f1076g = 1.0f / m1762a(1.0f);
    }

    /* renamed from: a */
    static float m1762a(float f) {
        float f2 = f1075f * f;
        if (f2 < 1.0f) {
            f2 -= 1.0f - ((float) Math.exp((double) (-f2)));
        } else {
            f2 = ((1.0f - ((float) Math.exp((double) (1.0f - f2)))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return f2 * f1076g;
    }
}
