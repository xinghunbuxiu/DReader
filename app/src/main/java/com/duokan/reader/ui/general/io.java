package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.duokan.core.ui.dv;

public class io extends Drawable {
    /* renamed from: a */
    private final Context f7389a;
    /* renamed from: b */
    private final Paint f7390b = new Paint();
    /* renamed from: c */
    private String f7391c = "";
    /* renamed from: d */
    private int f7392d = 51;

    public io(Context context) {
        this.f7389a = context;
    }

    /* renamed from: a */
    public void m10799a(String str) {
        this.f7391c = str;
        invalidateSelf();
    }

    /* renamed from: a */
    public Paint m10797a() {
        return this.f7390b;
    }

    /* renamed from: a */
    public void m10798a(int i) {
        this.f7392d = i;
        invalidateSelf();
    }

    public void draw(Canvas canvas) {
        if (!TextUtils.isEmpty(this.f7391c)) {
            dv.m1913a(canvas, this.f7391c, getBounds(), this.f7392d, this.f7390b);
        }
    }

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i) {
        this.f7390b.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f7390b.setColorFilter(colorFilter);
    }
}
