package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;

import com.duokan.b.e;
import com.duokan.core.ui.dv;

public class et extends Drawable {
    private final Paint a = new Paint();
    private final Drawable b;
    private String c = "";

    public et(Context context) {
        this.a.setColor(-1);
        this.a.setFakeBoldText(true);
        this.a.setTextSize((float) dv.b(context, 10.0f));
        this.a.setAntiAlias(true);
        this.a.setSubpixelText(true);
        this.b = context.getResources().getDrawable(e.general__shared__message_bubble);
    }

    public void a(String str) {
        this.c = str;
        invalidateSelf();
    }

    public int a() {
        Rect rect = (Rect) dv.g.a();
        this.b.getPadding(rect);
        float measureText = (this.a.measureText(this.c) + ((float) rect.left)) + ((float) rect.right);
        dv.g.a(rect);
        return Math.max(getIntrinsicWidth(), ((int) Math.ceil((double) (measureText / ((float) getIntrinsicWidth())))) * getIntrinsicWidth());
    }

    public void draw(Canvas canvas) {
        if (!TextUtils.isEmpty(this.c)) {
            Rect bounds = getBounds();
            this.b.setBounds(bounds);
            this.b.draw(canvas);
            dv.a(canvas, this.c, bounds, 17, this.a);
        }
    }

    public int getIntrinsicWidth() {
        return Math.round((float) this.b.getIntrinsicWidth());
    }

    public int getIntrinsicHeight() {
        return Math.round((float) this.b.getIntrinsicHeight());
    }

    public int getOpacity() {
        return 0;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
