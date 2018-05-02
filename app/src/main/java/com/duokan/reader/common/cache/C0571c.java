package com.duokan.reader.common.cache;

import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import com.duokan.core.sys.C0358f;

/* renamed from: com.duokan.reader.common.cache.c */
public class C0571c extends C0358f {
    /* renamed from: a */
    private final RectF f1878a;
    /* renamed from: b */
    private final float f1879b;
    /* renamed from: c */
    private final int f1880c = Integer.MAX_VALUE;

    public C0571c(String str, String str2, Rect rect, float f) {
        super(str, str2);
        this.f1878a = new RectF(rect);
        this.f1879b = f;
    }

    /* renamed from: b */
    public RectF m2570b() {
        return this.f1878a;
    }

    /* renamed from: c */
    public float m2571c() {
        return this.f1879b;
    }

    /* renamed from: a */
    public int mo775a(C0358f c0358f) {
        C0571c c0571c = (C0571c) c0358f;
        RectF rectF = new RectF(this.f1878a);
        RectF rectF2 = new RectF(c0571c.f1878a);
        if (!TextUtils.equals(m1022a(), c0358f.m1022a())) {
            return 0;
        }
        if (Float.compare(this.f1879b, c0571c.f1879b) == 0 && rectF.contains(rectF2)) {
            return Integer.MAX_VALUE;
        }
        if (!rectF.intersect(rectF2)) {
            return 0;
        }
        return (int) Math.floor((((double) (Math.min(this.f1879b, c0571c.f1879b) / Math.max(this.f1879b, c0571c.f1879b))) * (((double) (rectF.width() * rectF.height())) / ((double) (rectF2.width() * rectF2.height())))) * 2.147483647E9d);
    }
}
