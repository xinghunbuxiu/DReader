package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;

import com.duokan.core.ui.dv;

public class je extends Drawable {
    private final Context a;
    private final Paint b = new Paint();
    private String c = "";
    private int d = 51;

    public je(Context context) {
        this.a = context;
    }

    public void a(String str) {
        this.c = str;
        invalidateSelf();
    }

    public Paint a() {
        return this.b;
    }

    public void a(int i) {
        this.d = i;
        invalidateSelf();
    }

    public void draw(Canvas canvas) {
        if (!TextUtils.isEmpty(this.c)) {
            dv.a(canvas, this.c, getBounds(), this.d, this.b);
        }
    }

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i) {
        this.b.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.b.setColorFilter(colorFilter);
    }
}
