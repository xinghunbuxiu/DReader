package com.duokan.core.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.duokan.core.sys.UIdleHandler;

/* renamed from: com.duokan.core.ui.c */
public abstract class C0379c {
    /* renamed from: a */
    public static Bitmap m1749a(int i, int i2, Config config) {
        return C0379c.m1750b(i, i2, config);
    }

    /* renamed from: b */
    private static Bitmap m1750b(int i, int i2, Config config) {
        int max = Math.max(1, i);
        int max2 = Math.max(1, i2);
        int i3 = 0;
        while (i3 < 2) {
            try {
                Bitmap createBitmap = Bitmap.createBitmap(max, max2, config);
                if (createBitmap != null) {
                    return createBitmap;
                }
                i3++;
            } catch (OutOfMemoryError e) {
                System.gc();
                UIdleHandler.sleep(200);
            } catch (Throwable th) {
            }
        }
        return null;
    }
}
