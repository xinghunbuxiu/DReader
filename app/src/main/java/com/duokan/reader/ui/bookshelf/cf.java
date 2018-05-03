package com.duokan.reader.ui.bookshelf;

import android.graphics.PointF;
import android.view.View;
import com.duokan.core.ui.bw;
import com.duokan.core.ui.AnimUtils;
import java.util.Iterator;

class cf implements bw {
    /* renamed from: a */
    final /* synthetic */ ce f6268a;

    cf(ce ceVar) {
        this.f6268a = ceVar;
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    /* renamed from: a */
    public void mo521a(View view, PointF pointF) {
        if (!this.f6268a.f6255g && !this.f6268a.f6265q && !this.f6268a.f6264p) {
            dn b;
            ce ceVar = this.f6268a;
            if (this.f6268a.f6250a.f6197h != null) {
                b = this.f6268a.f6250a.f6197h;
            } else {
                b = this.f6268a.f6250a.f6191b;
            }
            ceVar.f6258j = b;
            PointF pointF2 = (PointF) AnimUtils.f1197f.addAnimation();
            pointF2.x = (float) ((int) pointF.x);
            pointF2.y = (float) ((int) pointF.y);
            AnimUtils.m1953d(pointF2, view);
            int a = this.f6268a.m9353a(pointF2, false);
            AnimUtils.f1197f.clearAnimation(pointF2);
            if (a >= 0) {
                de a2 = this.f6268a.m9381c(a);
                if (a2.m9119g()) {
                    this.f6268a.m1617c(true);
                    this.f6268a.f6259k = this.f6268a.m9375b(a);
                    this.f6268a.f6262n = a;
                    this.f6268a.f6261m = this.f6268a.f6258j.getContentScrollY();
                    this.f6268a.f6255g = true;
                    this.f6268a.f6260l = a2.m9120h();
                    this.f6268a.f6256h = new cs(this.f6268a.f6250a, this.f6268a.f6250a.getContext(), a2);
                    this.f6268a.f6250a.f6196g.mo2550b(this.f6268a.f6256h);
                    this.f6268a.f6264p = true;
                    a2.setItemStatus(DragItemStatus.Draged);
                    Iterator it = this.f6268a.f6250a.f6195f.iterator();
                    while (it.hasNext()) {
                        ((da) it.next()).mo1630c();
                    }
                    this.f6268a.f6258j.mo1668a(this.f6268a.f6259k, true);
                    return;
                }
                this.f6268a.f6258j = null;
                return;
            }
            this.f6268a.f6258j = null;
        }
    }
}
