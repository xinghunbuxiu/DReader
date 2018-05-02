package com.duokan.reader.common.bitmap;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.os.Process;
import android.view.View;

import com.duokan.core.ui.c;
import com.duokan.reader.common.bitmap.BitmapsRecycler.RecycleReason;

import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;

public class a {
    static final /* synthetic */ boolean a;
    private static final LinkedList b = new LinkedList();

    static {
        boolean z;
        if (a.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        a = z;
    }

    private a() {
    }

    public static int a(int i, int i2, Config config) {
        return (i * i2) * a(config);
    }

    public static int a(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return (bitmap.getWidth() * bitmap.getHeight()) * a(bitmap.getConfig());
    }

    public static int a(Config config) {
        switch (d.a[config.ordinal()]) {
            case 1:
                return 1;
            case 2:
            case 3:
                return 2;
            case 4:
                return 4;
            default:
                if (a) {
                    return 4;
                }
                throw new AssertionError();
        }
    }

    @TargetApi(14)
    public static int a(Canvas canvas) {
        if (VERSION.SDK_INT >= 14) {
            return canvas.getMaximumBitmapWidth();
        }
        return 2048;
    }

    @TargetApi(14)
    public static int b(Canvas canvas) {
        if (VERSION.SDK_INT >= 14) {
            return canvas.getMaximumBitmapHeight();
        }
        return 2048;
    }

    public static void a(BitmapsRecycler bitmapsRecycler) {
        synchronized (b) {
            if (!b.contains(bitmapsRecycler)) {
                b.add(bitmapsRecycler);
            }
        }
    }

    public static Bitmap a(View view) {
        view.clearFocus();
        view.setPressed(false);
        Bitmap a = c.a(view.getWidth(), view.getHeight(), Config.ARGB_8888);
        view.draw(new Canvas(a));
        return a;
    }

    public static Bitmap b(int i, int i2, Config config) {
        int max = Math.max(i, 1);
        int max2 = Math.max(i2, 1);
        int i3 = 0;
        while (true) {
            try {
                break;
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
                try {
                    System.gc();
                    Thread.sleep((long) ((i3 + 1) * 50));
                } catch (InterruptedException e2) {
                }
                i3++;
            }
        }
        return c(max, max2, config);
    }

    public static Bitmap c(int i, int i2, Config config) {
        return a(null, new b(i, i2, config), null);
    }

    public static Bitmap b(Bitmap bitmap) {
        return a(null, new e(bitmap), null);
    }

    public static Bitmap a(InputStream inputStream, Options options) {
        return a(null, inputStream, options);
    }

    public static Bitmap a(Context context, InputStream inputStream, Options options) {
        return a(context, new f(inputStream, options), options);
    }

    public static Bitmap a(Context context, int i) {
        return a(context, i, null);
    }

    public static Bitmap a(Context context, int i, Options options) {
        return a(context, new g(context, i, options), options);
    }

    public static Bitmap a(Context context, String str, int i, int i2) {
        return a(context, new h(context, str, i, i2), null);
    }

    private static Bitmap c(Context context, String str, int i, int i2) {
        int i3 = 1;
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i4 = options.outWidth;
        int i5 = options.outHeight;
        while (true) {
            if (i4 > i || r0 > i2) {
                i3++;
                i4 = options.outWidth / i3;
                i5 = options.outHeight / i3;
            } else {
                options.inSampleSize = i3;
                options.inJustDecodeBounds = false;
                options.inPreferredConfig = Config.RGB_565;
                return BitmapFactory.decodeFile(str, options);
            }
        }
    }

    public static Bitmap a(Context context, String str) {
        return a(context, new i(str), null);
    }

    public static Bitmap a(Context context, byte[] bArr, int i, int i2) {
        return a(context, bArr, i, i2, null);
    }

    public static Bitmap a(Context context, byte[] bArr, int i, int i2, Options options) {
        return a(context, new c(options, bArr, i, i2), options);
    }

    private static Bitmap a(Context context, j jVar, Options options) {
        try {
            Bitmap a = jVar.a();
            if ((options != null && options.inJustDecodeBounds) || a != null || context == null) {
                return a;
            }
            if (((float) a(context)) / ((float) b(context)) > 0.9f) {
                a(RecycleReason.OutOfMemory);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                }
            }
            return jVar.a();
        } catch (OutOfMemoryError e2) {
            a(RecycleReason.OutOfMemory);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e3) {
            }
            return jVar.a();
        }
    }

    private static long a(Context context) {
        return ((long) ((ActivityManager) context.getSystemService("activity")).getProcessMemoryInfo(new int[]{Process.myPid()})[0].dalvikPss) * 1024;
    }

    @TargetApi(11)
    private static long b(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        return ((long) (VERSION.SDK_INT >= 11 ? activityManager.getLargeMemoryClass() : activityManager.getMemoryClass())) * 1048576;
    }

    public static void a(RecycleReason recycleReason) {
        LinkedList linkedList;
        synchronized (b) {
            linkedList = new LinkedList(b);
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((BitmapsRecycler) it.next()).a(recycleReason);
        }
        System.gc();
    }
}
