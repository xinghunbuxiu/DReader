package com.duokan.core.ui;

import org.apache.http.HttpStatus;

class ci {
    private static float a = ((float) (Math.log(0.75d) / Math.log(0.9d)));
    private static float b = 800.0f;
    private static float c = 0.4f;
    private static float d = (1.0f - c);
    private static final float[] e = new float[HttpStatus.SC_SWITCHING_PROTOCOLS];
    private static float f = 8.0f;
    private static float g;

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
                float f6 = ((((1.0f - f) * c) + (d * f)) * f2) + ((f * f) * f);
                if (((double) Math.abs(f6 - f3)) < 1.0E-5d) {
                    break;
                } else if (f6 > f3) {
                    f4 = f;
                } else {
                    f5 = f;
                }
            }
            e[i] = ((f * f) * f) + f2;
            i++;
            f = f5;
        }
        e[100] = 1.0f;
        g = 1.0f;
        g = 1.0f / a(1.0f);
    }

    static float a(float f) {
        float f2 = f * f;
        if (f2 < 1.0f) {
            f2 -= 1.0f - ((float) Math.exp((double) (-f2)));
        } else {
            f2 = ((1.0f - ((float) Math.exp((double) (1.0f - f2)))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return f2 * g;
    }
}
