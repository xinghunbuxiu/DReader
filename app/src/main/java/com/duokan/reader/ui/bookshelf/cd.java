package com.duokan.reader.ui.bookshelf;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;

import com.duokan.core.sys.t;
import com.duokan.core.ui.au;
import com.duokan.core.ui.dv;
import com.duokan.reader.domain.bookshelf.an;

class cd implements au {
    final /* synthetic */ bz a;

    cd(bz bzVar) {
        this.a = bzVar;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void a(View view, PointF pointF, int i) {
        boolean z = true;
        if (this.a.g && !this.a.q) {
            PointF c = this.a.h.c();
            boolean g = this.a.g(false);
            if (g) {
                z = g;
            } else {
                Rect rect = (Rect) dv.g.a();
                RectF rectF = (RectF) dv.h.a();
                this.a.a(rect);
                this.a.h.a(rectF);
                if (rectF.centerY() < ((float) rect.top) && this.a.i() && !this.a.m()) {
                    this.a.a(this.a.k);
                } else if (rectF.centerY() > ((float) rect.bottom) && this.a.i() && !this.a.m()) {
                    this.a.a(this.a.k);
                } else if (rectF.top < ((float) rect.top) && !this.a.j.c_()) {
                    this.a.o = new cm(this.a, ((int) (rectF.top - ((float) rect.top))) / 2);
                    t.a(this.a.o);
                } else if (rectF.bottom <= ((float) rect.bottom) || this.a.j.d_()) {
                    z = g;
                } else {
                    this.a.o = new cm(this.a, ((int) (rectF.bottom - ((float) rect.bottom))) / 2);
                    t.a(this.a.o);
                }
                dv.g.a(rect);
                dv.h.a(rectF);
            }
            if (!z) {
                int a = this.a.a(c);
                an b = this.a.b(a);
                if (a >= 0 && b != this.a.k && !this.a.l() && !this.a.j() && !this.a.m()) {
                    this.a.a(a);
                }
            }
        }
    }
}
