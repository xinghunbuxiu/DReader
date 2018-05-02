package com.duokan.core.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

import com.duokan.core.sys.AIdleOperation;

public abstract class c {
    public static Bitmap a(int i, int i2, Config config) {
        return b(i, i2, config);
    }

    private static Bitmap b(int i, int i2, Config config) {
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
                AIdleOperation.sleep(200);
            } catch (Throwable th) {
            }
        }
        return null;
    }
}
