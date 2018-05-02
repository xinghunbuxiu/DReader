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
import com.duokan.core.ui.C0379c;
import com.duokan.reader.common.bitmap.BitmapsRecycler.RecycleReason;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.duokan.reader.common.bitmap.a */
public class C0544a {
    /* renamed from: a */
    static final /* synthetic */ boolean f1808a;
    /* renamed from: b */
    private static final LinkedList<BitmapsRecycler> f1809b = new LinkedList();

    static {
        boolean z;
        if (C0544a.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        f1808a = z;
    }

    private C0544a() {
    }

    /* renamed from: a */
    public static int m2425a(int i, int i2, Config config) {
        return (i * i2) * C0544a.m2426a(config);
    }

    /* renamed from: a */
    public static int m2427a(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return (bitmap.getWidth() * bitmap.getHeight()) * C0544a.m2426a(bitmap.getConfig());
    }

    /* renamed from: a */
    public static int m2426a(Config config) {
        switch (C0548d.f1817a[config.ordinal()]) {
            case 1:
                return 1;
            case 2:
            case 3:
                return 2;
            case 4:
                return 4;
            default:
                if (f1808a) {
                    return 4;
                }
                throw new AssertionError();
        }
    }

    @TargetApi(14)
    /* renamed from: a */
    public static int m2428a(Canvas canvas) {
        if (VERSION.SDK_INT >= 14) {
            return canvas.getMaximumBitmapWidth();
        }
        return 2048;
    }

    @TargetApi(14)
    /* renamed from: b */
    public static int m2442b(Canvas canvas) {
        if (VERSION.SDK_INT >= 14) {
            return canvas.getMaximumBitmapHeight();
        }
        return 2048;
    }

    /* renamed from: a */
    public static void m2441a(BitmapsRecycler bitmapsRecycler) {
        synchronized (f1809b) {
            if (!f1809b.contains(bitmapsRecycler)) {
                f1809b.add(bitmapsRecycler);
            }
        }
    }

    /* renamed from: a */
    public static Bitmap m2438a(View view) {
        view.clearFocus();
        view.setPressed(false);
        Bitmap a = C0379c.m1749a(view.getWidth(), view.getHeight(), Config.ARGB_8888);
        view.draw(new Canvas(a));
        return a;
    }

    /* renamed from: b */
    public static Bitmap m2444b(int i, int i2, Config config) {
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
        return C0544a.m2447c(max, max2, config);
    }

    /* renamed from: c */
    public static Bitmap m2447c(int i, int i2, Config config) {
        return C0544a.m2432a(null, new C0546b(i, i2, config), null);
    }

    /* renamed from: b */
    public static Bitmap m2446b(Bitmap bitmap) {
        return C0544a.m2432a(null, new C0549e(bitmap), null);
    }

    /* renamed from: a */
    public static Bitmap m2439a(InputStream inputStream, Options options) {
        return C0544a.m2433a(null, inputStream, options);
    }

    /* renamed from: a */
    public static Bitmap m2433a(Context context, InputStream inputStream, Options options) {
        return C0544a.m2432a(context, new C0550f(inputStream, options), options);
    }

    /* renamed from: a */
    public static Bitmap m2430a(Context context, int i) {
        return C0544a.m2431a(context, i, null);
    }

    /* renamed from: a */
    public static Bitmap m2431a(Context context, int i, Options options) {
        return C0544a.m2432a(context, new C0551g(context, i, options), options);
    }

    /* renamed from: a */
    public static Bitmap m2435a(Context context, String str, int i, int i2) {
        return C0544a.m2432a(context, new C0552h(context, str, i, i2), null);
    }

    /* renamed from: c */
    private static Bitmap m2448c(Context context, String str, int i, int i2) {
        int i3 = 1;
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i4 = options.outWidth;
        int i5 = options.outHeight;
        while (true) {
            if (i4 > i || i5 > i2) {
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

    /* renamed from: a */
    public static Bitmap m2434a(Context context, String str) {
        return C0544a.m2432a(context, new C0553i(str), null);
    }

    /* renamed from: a */
    public static Bitmap m2436a(Context context, byte[] bArr, int i, int i2) {
        return C0544a.m2437a(context, bArr, i, i2, null);
    }

    /* renamed from: a */
    public static Bitmap m2437a(Context context, byte[] bArr, int i, int i2, Options options) {
        return C0544a.m2432a(context, new C0547c(options, bArr, i, i2), options);
    }

    /* renamed from: a */
    private static Bitmap m2432a(Context context, C0545j c0545j, Options options) {
        try {
            Bitmap a = c0545j.mo752a();
            if ((options != null && options.inJustDecodeBounds) || a != null || context == null) {
                return a;
            }
            if (((float) C0544a.m2429a(context)) / ((float) C0544a.m2443b(context)) > 0.9f) {
                C0544a.m2440a(RecycleReason.OutOfMemory);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                }
            }
            return c0545j.mo752a();
        } catch (OutOfMemoryError e2) {
            C0544a.m2440a(RecycleReason.OutOfMemory);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e3) {
            }
            return c0545j.mo752a();
        }
    }

    /* renamed from: a */
    private static long m2429a(Context context) {
        return ((long) ((ActivityManager) context.getSystemService("activity")).getProcessMemoryInfo(new int[]{Process.myPid()})[0].dalvikPss) * 1024;
    }

    @TargetApi(11)
    /* renamed from: b */
    private static long m2443b(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        return ((long) (VERSION.SDK_INT >= 11 ? activityManager.getLargeMemoryClass() : activityManager.getMemoryClass())) * 1048576;
    }

    /* renamed from: a */
    public static void m2440a(RecycleReason recycleReason) {
        LinkedList linkedList;
        synchronized (f1809b) {
            linkedList = new LinkedList(f1809b);
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((BitmapsRecycler) it.next()).mo1802a(recycleReason);
        }
        System.gc();
    }
}
