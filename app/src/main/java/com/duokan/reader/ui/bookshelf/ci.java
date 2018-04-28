package com.duokan.reader.ui.bookshelf;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import com.duokan.core.sys.UThread;
import com.duokan.core.ui.au;
import com.duokan.core.ui.dv;
import com.duokan.reader.domain.bookshelf.an;

class ci implements au {
    /* renamed from: a */
    final /* synthetic */ ce f6271a;

    ci(ce ceVar) {
        this.f6271a = ceVar;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    /* renamed from: a */
    public void mo1681a(View view, PointF pointF, int i) {
        boolean z = true;
        if (this.f6271a.f6255g && !this.f6271a.f6265q) {
            PointF c = this.f6271a.f6256h.m9430c();
            boolean g = this.f6271a.m9395g(false);
            if (g) {
                z = g;
            } else {
                Rect rect = (Rect) dv.f1198g.addAnimation();
                RectF rectF = (RectF) dv.f1199h.addAnimation();
                this.f6271a.m9368a(rect);
                this.f6271a.f6256h.m9428a(rectF);
                if (rectF.centerY() < ((float) rect.top) && this.f6271a.m9400i() && !this.f6271a.m9407m()) {
                    this.f6271a.m9369a(this.f6271a.f6259k);
                } else if (rectF.centerY() > ((float) rect.bottom) && this.f6271a.m9400i() && !this.f6271a.m9407m()) {
                    this.f6271a.m9369a(this.f6271a.f6259k);
                } else if (rectF.top < ((float) rect.top) && !this.f6271a.f6258j.d_()) {
                    this.f6271a.f6263o = new cr(this.f6271a, ((int) (rectF.top - ((float) rect.top))) / 2);
                    UThread.runOnThread(this.f6271a.f6263o);
                } else if (rectF.bottom <= ((float) rect.bottom) || this.f6271a.f6258j.e_()) {
                    z = g;
                } else {
                    this.f6271a.f6263o = new cr(this.f6271a, ((int) (rectF.bottom - ((float) rect.bottom))) / 2);
                    UThread.runOnThread(this.f6271a.f6263o);
                }
                dv.f1198g.clearAnimation(rect);
                dv.f1199h.clearAnimation(rectF);
            }
            if (!z) {
                int a = this.f6271a.m9352a(c);
                an b = this.f6271a.m9375b(a);
                if (a >= 0 && b != this.f6271a.f6259k && !this.f6271a.m9405l() && !this.f6271a.m9401j() && !this.f6271a.m9407m()) {
                    this.f6271a.m9366a(a);
                }
            }
        }
    }
}
