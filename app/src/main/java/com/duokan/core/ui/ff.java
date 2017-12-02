package com.duokan.core.ui;

import android.view.MotionEvent;
import android.view.View;

import com.duokan.core.ui.Scrollable.ScrollState;

class ff extends er {
    final /* synthetic */ ev a;
    private final q c = new q();
    private final dt d = new dt();

    public ff(ev evVar) {
        this.a = evVar;
        this.c.a(0.0f);
        this.d.a(0);
    }

    protected void a(View view, boolean z) {
        boolean z2;
        boolean z3 = false;
        q qVar = this.c;
        if (z || !this.c.c()) {
            z2 = true;
        } else {
            z2 = false;
        }
        qVar.b(view, z2);
        dt dtVar = this.d;
        if (z || !this.d.c()) {
            z3 = true;
        }
        dtVar.b(view, z3);
        this.d.b(this.a.ab());
    }

    protected void c(View view, MotionEvent motionEvent, boolean z, es esVar) {
        a(view, motionEvent, z, esVar);
    }

    protected void a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        if (motionEvent.getPointerCount() <= 1 || this.a.s != ScrollState.IDLE) {
            if (motionEvent.getActionMasked() == 0) {
                if (this.a.s != ScrollState.DRAG && this.a.s != ScrollState.SEEK && this.a.G && this.a.f()) {
                    int g = this.a.aA();
                    int h = this.a.aB();
                    if (g == 1 && this.a.L.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                        this.a.t = true;
                    } else if (h == 1 && this.a.I.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                        this.a.u = true;
                    }
                }
                if (this.a.t || this.a.u) {
                    this.d.a(0);
                    this.d.b(0.0f);
                    this.d.c(360.0f);
                    this.a.a(ScrollState.SEEK);
                    this.a.f(true);
                    c(true);
                    this.a.ac();
                } else if (this.a.s == ScrollState.SMOOTH) {
                    b(false);
                    return;
                } else if (this.a.s == ScrollState.IDLE || !this.a.x) {
                    this.d.a(this.a.aa());
                } else {
                    ScrollState e = this.a.s;
                    this.a.a(ScrollState.DRAG);
                    this.a.a(e, motionEvent.getX(), motionEvent.getY());
                    this.a.b(0.0f, 0.0f);
                    this.a.f(true);
                    c(true);
                }
            }
            if (c() && !e()) {
                this.d.b(view, motionEvent, z, new fg(this));
            }
            if (c() && !e()) {
                this.c.b(view, motionEvent, z, new fh(this));
            }
            if (motionEvent.getActionMasked() == 1) {
                this.a.f(false);
                if (this.a.s == ScrollState.SEEK) {
                    this.a.a(ScrollState.IDLE);
                    this.a.ad();
                    return;
                } else if (this.a.s == ScrollState.DRAG) {
                    this.a.a(ScrollState.FLING);
                    this.a.a(motionEvent.getX(), motionEvent.getY(), 0.0f, 0.0f, new fj(this), null);
                    this.a.b(ScrollState.FLING, motionEvent.getX(), motionEvent.getY());
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        b(false);
    }
}
