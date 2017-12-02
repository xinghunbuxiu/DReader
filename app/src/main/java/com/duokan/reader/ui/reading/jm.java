package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;

import com.duokan.b.e;
import com.duokan.core.ui.dv;
import com.duokan.reader.domain.document.ac;

public class jm extends FrameLayout implements jn {
    private final ac a;
    private final int b = dv.b(getContext(), 2.0f);
    private final Drawable c = getResources().getDrawable(e.general__shared__jindu_02);
    private final Drawable d = getResources().getDrawable(e.general__shared__jindu_01);

    public jm(Context context, ac acVar) {
        super(context);
        this.a = acVar;
        setWillNotDraw(false);
    }

    public void a(int i, int i2) {
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        this.a.c().setBounds(0, 0, getWidth(), getHeight());
        this.a.c().draw(canvas);
        a(canvas);
    }

    private void a(Canvas canvas) {
        if (this.a.d() >= 2) {
            int intrinsicWidth = this.c.getIntrinsicWidth();
            int intrinsicHeight = this.c.getIntrinsicHeight();
            int height = getHeight() - intrinsicHeight;
            int width = (getWidth() - ((this.a.d() * intrinsicWidth) + (this.b * (this.a.d() - 1)))) / 2;
            int i = 0;
            while (i < this.a.d()) {
                Drawable drawable = i == this.a.a() ? this.d : this.c;
                drawable.setBounds(width, height, width + intrinsicWidth, height + intrinsicHeight);
                drawable.draw(canvas);
                width += this.b + intrinsicWidth;
                i++;
            }
        }
    }
}
