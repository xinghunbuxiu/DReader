package com.duokan.reader.common.cache;

import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;

import com.duokan.core.sys.f;

public class c extends f {
    private final RectF a;
    private final float b;
    private final int c = Integer.MAX_VALUE;

    public c(String str, String str2, Rect rect, float f) {
        super(str, str2);
        this.a = new RectF(rect);
        this.b = f;
    }

    public RectF b() {
        return this.a;
    }

    public float c() {
        return this.b;
    }

    public int a(f fVar) {
        c cVar = (c) fVar;
        RectF rectF = new RectF(this.a);
        RectF rectF2 = new RectF(cVar.a);
        if (!TextUtils.equals(a(), fVar.a())) {
            return 0;
        }
        if (Float.compare(this.b, cVar.b) == 0 && rectF.contains(rectF2)) {
            return Integer.MAX_VALUE;
        }
        if (!rectF.intersect(rectF2)) {
            return 0;
        }
        return (int) Math.floor((((double) (Math.min(this.b, cVar.b) / Math.max(this.b, cVar.b))) * (((double) (rectF.width() * rectF.height())) / ((double) (rectF2.width() * rectF2.height())))) * 2.147483647E9d);
    }
}
