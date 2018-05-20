package com.duokan.core.ui;

import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.view.ViewGroup;

public class fv extends ev {
    /* renamed from: a */
    final /* synthetic */ fr f1275a;

    public fv(fr frVar, ViewGroup viewGroup) {
        this.f1275a = frVar;
        super(viewGroup);
    }

    /* renamed from: a */
    protected void mo492a(Canvas canvas) {
        this.f1275a.dkWebView.m2139a(canvas);
    }

    /* renamed from: a */
    protected void mo491a(int i, int i2) {
        int i3 = 0;
        int max = Math.max(0, this.f1275a.dkWebView.getHorizontalScrollRange() - this.f1275a.dkWebView.getWidth());
        int max2 = Math.max(0, this.f1275a.dkWebView.getVerticalScrollRange() - this.f1275a.dkWebView.getHeight());
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
        if (!(this.f1275a.dkWebView.getScrollX() == i && this.f1275a.dkWebView.getScrollY() == i2)) {
            this.f1275a.dkWebView.scrollTo(i, i2);
        }
        if (VERSION.SDK_INT < 21) {
            i3 = ae();
            max2 = af();
            if (i3 > 0) {
                float width = ((float) (this.f1275a.dkWebView.getWidth() + i3)) / ((float) this.f1275a.dkWebView.getWidth());
                if (getViewportBounds().left > am()) {
                    this.f1275a.dkWebView.setTranslationX(((float) (getViewportBounds().left - am())) - (((float) i3) / 2.0f));
                } else {
                    this.f1275a.dkWebView.setTranslationX(((float) i3) / 2.0f);
                }
                this.f1275a.dkWebView.setScaleX(width);
            } else {
                this.f1275a.dkWebView.setTranslationX(0.0f);
                this.f1275a.dkWebView.setScaleX(1.0f);
            }
            if (max2 > 0) {
                float height = ((float) (this.f1275a.dkWebView.getHeight() + max2)) / ((float) this.f1275a.dkWebView.getHeight());
                if (getViewportBounds().top > an()) {
                    this.f1275a.dkWebView.setTranslationY(((float) (getViewportBounds().top - an())) - (((float) max2) / 2.0f));
                } else {
                    this.f1275a.dkWebView.setTranslationY(((float) max2) / 2.0f);
                }
                this.f1275a.dkWebView.setScaleY(height);
                return;
            }
            this.f1275a.dkWebView.setTranslationY(0.0f);
            this.f1275a.dkWebView.setScaleY(1.0f);
        }
    }

    /* renamed from: b */
    public void mo529b(Canvas canvas) {
        if (VERSION.SDK_INT < 21) {
            mo492a(canvas);
        } else {
            super.mo529b(canvas);
        }
    }
}
