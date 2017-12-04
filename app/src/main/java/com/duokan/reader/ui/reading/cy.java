package com.duokan.reader.ui.reading;

import android.graphics.Point;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;

import com.duokan.core.ui.UTools;
import com.duokan.core.ui.cd;
import com.duokan.core.ui.dt;
import com.duokan.core.ui.er;
import com.duokan.core.ui.es;
import com.duokan.core.ui.g;
import com.duokan.core.ui.q;

public class cy extends er {
    final /* synthetic */ co a;
    private final cd c = new cd();
    private final q d = new q();
    private final dt e = new dt();
    private final g f = new g(1);
    private final g g = new g(2);
    private final Rect h = new Rect();
    private boolean i = false;
    private boolean j = false;

    public cy(co coVar) {
        this.a = coVar;
    }

    protected void a(View view, boolean z) {
        boolean z2 = true;
        cd cdVar = this.c;
        boolean z3 = z || !this.c.c();
        cdVar.b(view, z3);
        this.c.a(0.01f);
        this.c.a(UTools.getScaledPagingTouchSlop(view.getContext()));
        q qVar = this.d;
        if (z || !this.d.c()) {
            z3 = true;
        } else {
            z3 = false;
        }
        qVar.b(view, z3);
        this.d.a((float) a(view, 30));
        dt dtVar = this.e;
        if (z || !this.e.c()) {
            z3 = true;
        } else {
            z3 = false;
        }
        dtVar.b(view, z3);
        this.e.a(b(view));
        g gVar = this.f;
        if (z || !this.f.c()) {
            z3 = true;
        } else {
            z3 = false;
        }
        gVar.b(view, z3);
        g gVar2 = this.g;
        if (!z && this.g.c()) {
            z2 = false;
        }
        gVar2.b(view, z2);
        this.i = false;
        this.j = false;
        DisplayMetrics displayMetrics = this.a.getResources().getDisplayMetrics();
        this.h.set(displayMetrics.widthPixels / 4, displayMetrics.heightPixels / 4, view.getRight() - (displayMetrics.widthPixels / 4), view.getBottom() - (displayMetrics.heightPixels / 4));
    }

    protected void a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        boolean z2 = true;
        if (this.a.a.w().f()) {
            if (motionEvent.getAction() == 0 && Float.compare(this.a.d.getFrameScale(), 1.0f) >= 0) {
                this.a.d.a(0, 0, false);
            }
            if (c() && !e() && this.c.c()) {
                this.c.b(view, motionEvent, z, new cz(this));
            }
            if (c() && !e() && this.e.c()) {
                this.e.b(view, motionEvent, z, new da(this, motionEvent));
            }
            if (c() && !e() && this.d.c()) {
                this.d.b(view, motionEvent, z, new db(this));
            }
            if (c() && !e() && this.f.c()) {
                this.f.b(view, motionEvent, z, new dc(this));
            }
            if (c() && !e() && this.g.c()) {
                this.g.b(view, motionEvent, z, new dd(this));
            }
            if (motionEvent.getAction() == 1) {
                if (Float.compare(this.a.d.getFrameScale(), 1.0f) < 0) {
                    this.a.d.a(new Point(this.a.d.getWidth() / 2, this.a.d.getHeight() / 2), 1.0f, true);
                } else if (this.i) {
                    this.a.d.a();
                }
            }
            e(this.g.f());
            if (!(c() && (this.c.c() || this.d.c() || this.f.c() || this.g.c()))) {
                z2 = false;
            }
            b(z2);
        }
    }
}
