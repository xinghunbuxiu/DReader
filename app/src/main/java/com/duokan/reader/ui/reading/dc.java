package com.duokan.reader.ui.reading;

import android.graphics.Point;
import android.graphics.PointF;
import android.view.View;

import com.duokan.core.ui.er;
import com.duokan.core.ui.i;

class dc implements i {
    final /* synthetic */ cy a;

    dc(cy cyVar) {
        this.a = cyVar;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void a(er erVar, View view, PointF pointF, int i) {
        if (Float.compare(this.a.a.d.getFrameScale(), 1.0f) > 0) {
            this.a.a.d.a(new Point(this.a.a.d.getWidth() / 2, this.a.a.d.getHeight() / 2), 1.0f, true);
            this.a.d(true);
            this.a.b(false);
        } else if (this.a.h.contains((int) pointF.x, (int) pointF.y)) {
            this.a.a.requestShowMenu();
            this.a.d(true);
            this.a.b(false);
        } else {
            co coVar;
            boolean z;
            if (pointF.x < ((float) this.a.h.left)) {
                if (!this.a.a.a.aL() && this.a.a.q()) {
                    this.a.a.a(this.a.a.a.V() == SlideShowEffect.SIMPLE);
                    this.a.d(true);
                } else if (this.a.a.a.aL() && this.a.a.p()) {
                    coVar = this.a.a;
                    if (this.a.a.a.V() == SlideShowEffect.SIMPLE) {
                        z = true;
                    } else {
                        z = false;
                    }
                    coVar.b(z);
                    this.a.d(true);
                }
            } else if (pointF.x > ((float) this.a.h.right)) {
                if (this.a.a.p()) {
                    coVar = this.a.a;
                    if (this.a.a.a.V() == SlideShowEffect.SIMPLE) {
                        z = true;
                    } else {
                        z = false;
                    }
                    coVar.b(z);
                    this.a.d(true);
                }
            } else if (pointF.y < ((float) this.a.h.top)) {
                if (this.a.a.q()) {
                    coVar = this.a.a;
                    if (this.a.a.a.V() == SlideShowEffect.SIMPLE) {
                        z = true;
                    } else {
                        z = false;
                    }
                    coVar.a(z);
                    this.a.d(true);
                }
            } else if (pointF.y > ((float) this.a.h.bottom) && this.a.a.p()) {
                coVar = this.a.a;
                if (this.a.a.a.V() == SlideShowEffect.SIMPLE) {
                    z = true;
                } else {
                    z = false;
                }
                coVar.b(z);
                this.a.d(true);
            }
            this.a.b(false);
        }
    }
}
