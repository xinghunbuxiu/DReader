package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;

class ae extends gz {
    /* renamed from: a */
    final /* synthetic */ View f6089a;
    /* renamed from: b */
    final /* synthetic */ C1290g f6090b;

    ae(C1290g c1290g, Context context, View view) {
        this.f6090b = c1290g;
        this.f6089a = view;
        super(context);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m1264f(getVerticalThumbMarginLeft(), this.f6089a.getHeight() + getVerticalThumbMarginTop(), getVerticalThumbMarginRight(), getVerticalThumbMarginBottom());
    }

    /* renamed from: a */
    protected void mo1622a(MotionEvent motionEvent) {
        super.mo1622a(motionEvent);
        if (this.f6090b.f6489i.getVisibility() == 8) {
            this.f6090b.f6486f.setMinScrollY(0);
            this.f6090b.f6496p = false;
            return;
        }
        int i = this.f6090b.f6486f.getViewportBounds().top;
        if (i > this.f6090b.f6489i.getHeight()) {
            this.f6090b.f6486f.setMinScrollY(this.f6090b.f6489i.getHeight());
        } else if (motionEvent.getActionMasked() == 0) {
            boolean z;
            C1290g c1290g = this.f6090b;
            if (i == this.f6090b.f6489i.getHeight()) {
                z = true;
            } else {
                z = false;
            }
            c1290g.f6496p = z;
            this.f6090b.f6486f.setMinScrollY(0);
        }
    }

    /* renamed from: a */
    protected void mo1621a(PointF pointF) {
        super.mo1621a(pointF);
        if (this.f6090b.f6489i.getVisibility() != 8 && this.f6090b.f6486f.getViewportBounds().top < this.f6090b.f6489i.getHeight() && pointF.y > 0.0f) {
            pointF.y /= 2.5f;
        }
    }
}
