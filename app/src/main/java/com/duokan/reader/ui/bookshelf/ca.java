package com.duokan.reader.ui.bookshelf;

import android.graphics.PointF;
import android.view.View;

import com.duokan.core.ui.bw;
import com.duokan.core.ui.dv;

import java.util.Iterator;

class ca implements bw {
    final /* synthetic */ bz a;

    ca(bz bzVar) {
        this.a = bzVar;
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void a(View view, PointF pointF) {
        if (!this.a.g && !this.a.q && !this.a.p) {
            dg b;
            bz bzVar = this.a;
            if (this.a.a.h != null) {
                b = this.a.a.h;
            } else {
                b = this.a.a.b;
            }
            bzVar.j = b;
            PointF pointF2 = (PointF) dv.f.a();
            pointF2.x = (float) ((int) pointF.x);
            pointF2.y = (float) ((int) pointF.y);
            dv.d(pointF2, view);
            int a = this.a.a(pointF2, false);
            dv.f.a(pointF2);
            if (a >= 0) {
                cz a2 = this.a.c(a);
                if (a2.g()) {
                    this.a.c(true);
                    this.a.k = this.a.b(a);
                    this.a.n = a;
                    this.a.m = this.a.j.getContentScrollY();
                    this.a.g = true;
                    this.a.l = a2.h();
                    this.a.h = new cn(this.a.a, this.a.a.getContext(), a2);
                    this.a.a.g.b(this.a.h);
                    this.a.p = true;
                    a2.setItemStatus(DragItemStatus.Draged);
                    Iterator it = this.a.a.f.iterator();
                    while (it.hasNext()) {
                        ((cv) it.next()).c();
                    }
                    this.a.j.a(this.a.k, true);
                    return;
                }
                this.a.j = null;
                return;
            }
            this.a.j = null;
        }
    }
}
