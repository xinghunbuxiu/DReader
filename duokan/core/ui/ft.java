package com.duokan.core.ui;

import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.view.ViewGroup;

public class ft extends ev {
    final /* synthetic */ fr a;

    public ft(fr frVar, ViewGroup viewGroup) {
        this.a = frVar;
        super(viewGroup);
    }

    protected void a(Canvas canvas) {
        this.a.a.a(canvas);
    }

    protected void a(int i, int i2) {
        int i3 = 0;
        int max = Math.max(0, this.a.a.getHorizontalScrollRange() - this.a.a.getWidth());
        int max2 = Math.max(0, this.a.a.getVerticalScrollRange() - this.a.a.getHeight());
        if (i < 0) {
            max = i;
            i = 0;
        } else if (i > max) {
            int i4 = max;
            max = i - max;
            i = i4;
        } else {
            max = 0;
        }
        if (i2 < 0) {
            i3 = i2;
            i2 = 0;
        } else if (i2 > max2) {
            i3 = i2 - max2;
            i2 = max2;
        }
        if (!(super.getScrollX() == max && super.getScrollY() == i3)) {
            super.scrollTo(max, i3);
        }
        if (!(this.a.a.getScrollX() == i && this.a.a.getScrollY() == i2)) {
            this.a.a.scrollTo(i, i2);
        }
        if (VERSION.SDK_INT < 21) {
            i3 = ae();
            max2 = af();
            if (i3 > 0) {
                float width = ((float) (this.a.a.getWidth() + i3)) / ((float) this.a.a.getWidth());
                if (getViewportBounds().left > am()) {
                    this.a.a.setTranslationX(((float) (getViewportBounds().left - am())) - (((float) i3) / 2.0f));
                } else {
                    this.a.a.setTranslationX(((float) i3) / 2.0f);
                }
                this.a.a.setScaleX(width);
            } else {
                this.a.a.setTranslationX(0.0f);
                this.a.a.setScaleX(1.0f);
            }
            if (max2 > 0) {
                float height = ((float) (this.a.a.getHeight() + max2)) / ((float) this.a.a.getHeight());
                if (getViewportBounds().top > an()) {
                    this.a.a.setTranslationY(((float) (getViewportBounds().top - an())) - (((float) max2) / 2.0f));
                } else {
                    this.a.a.setTranslationY(((float) max2) / 2.0f);
                }
                this.a.a.setScaleY(height);
                return;
            }
            this.a.a.setTranslationY(0.0f);
            this.a.a.setScaleY(1.0f);
        }
    }

    public void b(Canvas canvas) {
        if (VERSION.SDK_INT < 21) {
            a(canvas);
        } else {
            super.b(canvas);
        }
    }
}
