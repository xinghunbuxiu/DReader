package com.duokan.reader.ui.general;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;

import com.duokan.core.ui.cd;
import com.duokan.core.ui.UTools;
import com.duokan.core.ui.er;
import com.duokan.core.ui.es;
import com.duokan.core.ui.g;

public class gk extends er {
    final /* synthetic */ PagesView a;
    private final cd c = new cd();
    private final g d = new g(2);
    private PointF e = null;

    protected gk(PagesView pagesView) {
        this.a = pagesView;
    }

    protected void a(View view, boolean z) {
        boolean z2 = false;
        cd cdVar = this.c;
        boolean z3 = z || !this.c.c();
        cdVar.b(view, z3);
        g gVar = this.d;
        if (z || !this.d.c()) {
            z2 = true;
        }
        gVar.b(view, z2);
        this.c.a(0.01f);
        this.c.a(UTools.getScaledPagingTouchSlop(view.getContext()));
        this.e = null;
    }

    protected void a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        boolean z2 = true;
        this.c.b(view, motionEvent, z, new gl(this));
        this.d.b(view, motionEvent, z, new gm(this));
        if (this.e != null && motionEvent.getActionMasked() == 1) {
            if (Float.compare(this.a.getZoomFactor(), 1.0f) < 0) {
                this.a.b((int) this.e.x, (int) this.e.y, 1.0f);
            } else if (Float.compare(this.a.getZoomFactor(), 3.0f) > 0) {
                this.a.b((int) this.e.x, (int) this.e.y, 3.0f);
            }
        }
        e(this.d.f());
        if (!(this.c.c() || this.d.c())) {
            z2 = false;
        }
        b(z2);
    }
}
