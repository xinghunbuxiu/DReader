package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;
import com.duokan.core.ui.AnimUtils;
import com.duokan.p023b.C0243e;
import com.duokan.reader.domain.document.ac;

public class jw extends FrameLayout implements jx {
    /* renamed from: a */
    private final ac f10475a;
    /* renamed from: b */
    private final int f10476b = AnimUtils.m1932b(getContext(), 2.0f);
    /* renamed from: c */
    private final Drawable f10477c = getResources().getDrawable(C0243e.general__shared__jindu_02);
    /* renamed from: d */
    private final Drawable f10478d = getResources().getDrawable(C0243e.general__shared__jindu_01);

    public jw(Context context, ac acVar) {
        super(context);
        this.f10475a = acVar;
        setWillNotDraw(false);
    }

    /* renamed from: a */
    public void mo2402a(int i, int i2) {
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        this.f10475a.mo1388c().setBounds(0, 0, getWidth(), getHeight());
        this.f10475a.mo1388c().draw(canvas);
        m14509a(canvas);
    }

    /* renamed from: a */
    private void m14509a(Canvas canvas) {
        if (this.f10475a.mo1389d() >= 2) {
            int intrinsicWidth = this.f10477c.getIntrinsicWidth();
            int intrinsicHeight = this.f10477c.getIntrinsicHeight();
            int height = getHeight() - intrinsicHeight;
            int width = (getWidth() - ((this.f10475a.mo1389d() * intrinsicWidth) + (this.f10476b * (this.f10475a.mo1389d() - 1)))) / 2;
            int i = 0;
            while (i < this.f10475a.mo1389d()) {
                Drawable drawable = i == this.f10475a.mo1381a() ? this.f10478d : this.f10477c;
                drawable.setBounds(width, height, width + intrinsicWidth, height + intrinsicHeight);
                drawable.draw(canvas);
                width += this.f10476b + intrinsicWidth;
                i++;
            }
        }
    }
}
