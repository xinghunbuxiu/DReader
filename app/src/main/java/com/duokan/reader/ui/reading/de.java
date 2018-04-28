package com.duokan.reader.ui.reading;

import android.graphics.Point;
import android.graphics.PointF;
import android.view.View;
import com.duokan.core.ui.C0385i;
import com.duokan.core.ui.er;

class de implements C0385i {
    /* renamed from: a */
    final /* synthetic */ da f9988a;

    de(da daVar) {
        this.f9988a = daVar;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    /* renamed from: a */
    public void mo1788a(er erVar, View view, PointF pointF, int i) {
        if (Float.compare(this.f9988a.f9975a.f9952d.getFrameScale(), 1.0f) > 0) {
            this.f9988a.f9975a.f9952d.m13308a(new Point(this.f9988a.f9975a.f9952d.getWidth() / 2, this.f9988a.f9975a.f9952d.getHeight() / 2), 1.0f, true);
            this.f9988a.m1620d(true);
            this.f9988a.m1613b(false);
        } else if (this.f9988a.f9981h.contains((int) pointF.x, (int) pointF.y)) {
            this.f9988a.f9975a.requestShowMenu();
            this.f9988a.m1620d(true);
            this.f9988a.m1613b(false);
        } else {
            cq cqVar;
            boolean z;
            if (pointF.x < ((float) this.f9988a.f9981h.left)) {
                if (!this.f9988a.f9975a.f9949a.aL() && this.f9988a.f9975a.m13862q()) {
                    this.f9988a.f9975a.m13868a(this.f9988a.f9975a.f9949a.mo2005V() == SlideShowEffect.SIMPLE);
                    this.f9988a.m1620d(true);
                } else if (this.f9988a.f9975a.f9949a.aL() && this.f9988a.f9975a.m13861p()) {
                    cqVar = this.f9988a.f9975a;
                    if (this.f9988a.f9975a.f9949a.mo2005V() == SlideShowEffect.SIMPLE) {
                        z = true;
                    } else {
                        z = false;
                    }
                    cqVar.m13871b(z);
                    this.f9988a.m1620d(true);
                }
            } else if (pointF.x > ((float) this.f9988a.f9981h.right)) {
                if (this.f9988a.f9975a.m13861p()) {
                    cqVar = this.f9988a.f9975a;
                    if (this.f9988a.f9975a.f9949a.mo2005V() == SlideShowEffect.SIMPLE) {
                        z = true;
                    } else {
                        z = false;
                    }
                    cqVar.m13871b(z);
                    this.f9988a.m1620d(true);
                }
            } else if (pointF.y < ((float) this.f9988a.f9981h.top)) {
                if (this.f9988a.f9975a.m13862q()) {
                    cqVar = this.f9988a.f9975a;
                    if (this.f9988a.f9975a.f9949a.mo2005V() == SlideShowEffect.SIMPLE) {
                        z = true;
                    } else {
                        z = false;
                    }
                    cqVar.m13868a(z);
                    this.f9988a.m1620d(true);
                }
            } else if (pointF.y > ((float) this.f9988a.f9981h.bottom) && this.f9988a.f9975a.m13861p()) {
                cqVar = this.f9988a.f9975a;
                if (this.f9988a.f9975a.f9949a.mo2005V() == SlideShowEffect.SIMPLE) {
                    z = true;
                } else {
                    z = false;
                }
                cqVar.m13871b(z);
                this.f9988a.m1620d(true);
            }
            this.f9988a.m1613b(false);
        }
    }
}
