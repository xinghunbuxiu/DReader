package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.duokan.core.ui.dv;
import com.duokan.p023b.C0243e;

public class er extends Drawable {
    /* renamed from: a */
    private final Paint f7165a = new Paint();
    /* renamed from: b */
    private final Drawable f7166b;
    /* renamed from: c */
    private String f7167c = "";

    public er(Context context) {
        this.f7165a.setColor(-1);
        this.f7165a.setFakeBoldText(true);
        this.f7165a.setTextSize((float) dv.m1932b(context, 10.0f));
        this.f7165a.setAntiAlias(true);
        this.f7165a.setSubpixelText(true);
        this.f7166b = context.getResources().getDrawable(C0243e.general__shared__message_bubble);
    }

    /* renamed from: a */
    public void m10570a(String str) {
        this.f7167c = str;
        invalidateSelf();
    }

    /* renamed from: a */
    public int m10569a() {
        Rect rect = (Rect) dv.f1198g.addAnimation();
        this.f7166b.getPadding(rect);
        float measureText = (this.f7165a.measureText(this.f7167c) + ((float) rect.left)) + ((float) rect.right);
        dv.f1198g.clearAnimation(rect);
        return Math.max(getIntrinsicWidth(), ((int) Math.ceil((double) (measureText / ((float) getIntrinsicWidth())))) * getIntrinsicWidth());
    }

    public void draw(Canvas canvas) {
        if (!TextUtils.isEmpty(this.f7167c)) {
            Rect bounds = getBounds();
            this.f7166b.setBounds(bounds);
            this.f7166b.draw(canvas);
            dv.m1913a(canvas, this.f7167c, bounds, 17, this.f7165a);
        }
    }

    public int getIntrinsicWidth() {
        return Math.round((float) this.f7166b.getIntrinsicWidth());
    }

    public int getIntrinsicHeight() {
        return Math.round((float) this.f7166b.getIntrinsicHeight());
    }

    public int getOpacity() {
        return 0;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
