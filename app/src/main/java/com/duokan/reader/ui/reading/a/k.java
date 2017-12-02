package com.duokan.reader.ui.reading.a;

import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;

import com.duokan.core.ui.er;
import com.duokan.core.ui.i;
import com.duokan.reader.ui.reading.PageAnimationMode;
import com.duokan.reader.ui.reading.g;

class k implements i {
    final /* synthetic */ j a;

    k(j jVar) {
        this.a = jVar;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void a(er erVar, View view, PointF pointF, int i) {
        Rect bj = this.a.a.bj();
        this.a.c.set((float) bj.left, (float) bj.top, (float) (view.getWidth() - bj.right), (float) (view.getHeight() - bj.bottom));
        if (this.a.c.contains(pointF.x, pointF.y)) {
            this.a.b(false);
            return;
        }
        if (this.a.a.bf()) {
            g bg = this.a.a.bg();
            if (bg != null && bg.a().contains((int) pointF.x, (int) pointF.y)) {
                bg.b();
                this.a.b(false);
                return;
            }
        }
        if (this.a.a.U() == PageAnimationMode.VSCROLL) {
            if (pointF.y < this.a.c.top) {
                this.a.a.a(pointF, null, null);
                this.a.d(true);
            } else if (pointF.y > this.a.c.bottom) {
                this.a.a.b(pointF, null, null);
                this.a.d(true);
            }
        } else if (this.a.a.al()) {
            if (pointF.x < this.a.c.left) {
                this.a.a.b(pointF, null, null);
                this.a.d(true);
            } else if (pointF.x > this.a.c.right) {
                if (!this.a.a.aL()) {
                    this.a.a.a(pointF, null, null);
                    this.a.d(true);
                } else if (this.a.a.aL()) {
                    this.a.a.b(pointF, null, null);
                    this.a.d(true);
                }
            } else if (pointF.y < this.a.c.top) {
                this.a.a.a(pointF, null, null);
                this.a.d(true);
            } else if (pointF.y > this.a.c.bottom) {
                this.a.a.b(pointF, null, null);
                this.a.d(true);
            }
        } else if (pointF.x < this.a.c.left) {
            if (!this.a.a.aL()) {
                this.a.a.a(pointF, null, null);
                this.a.d(true);
            } else if (this.a.a.aL()) {
                this.a.a.b(pointF, null, null);
                this.a.d(true);
            }
        } else if (pointF.x > this.a.c.right) {
            this.a.a.b(pointF, null, null);
            this.a.d(true);
        } else if (pointF.y < this.a.c.top) {
            this.a.a.a(pointF, null, null);
            this.a.d(true);
        } else if (pointF.y > this.a.c.bottom) {
            this.a.a.b(pointF, null, null);
            this.a.d(true);
        }
        this.a.b(false);
    }
}
