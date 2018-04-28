package com.duokan.core.ui;

import android.view.MotionEvent;
import android.view.View;
import com.duokan.core.ui.Scrollable.ScrollState;

class ff extends er {
    /* renamed from: a */
    final /* synthetic */ ev f1249a;
    /* renamed from: c */
    private final C0392q f1250c = new C0392q();
    /* renamed from: d */
    private final dt f1251d = new dt();

    public ff(ev evVar) {
        this.f1249a = evVar;
        this.f1250c.m2168a(0.0f);
        this.f1251d.m1882a(0);
    }

    /* renamed from: a */
    protected void mo511a(View view, boolean z) {
        boolean z2;
        boolean z3 = false;
        C0392q c0392q = this.f1250c;
        if (z || !this.f1250c.m1618c()) {
            z2 = true;
        } else {
            z2 = false;
        }
        c0392q.m1612b(view, z2);
        dt dtVar = this.f1251d;
        if (z || !this.f1251d.m1618c()) {
            z3 = true;
        }
        dtVar.m1612b(view, z3);
        this.f1251d.m1886b(this.f1249a.ab());
    }

    /* renamed from: c */
    protected void mo526c(View view, MotionEvent motionEvent, boolean z, es esVar) {
        mo510a(view, motionEvent, z, esVar);
    }

    /* renamed from: a */
    protected void mo510a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        if (motionEvent.getPointerCount() <= 1 || this.f1249a.f952s != ScrollState.IDLE) {
            if (motionEvent.getActionMasked() == 0) {
                if (this.f1249a.f952s != ScrollState.DRAG && this.f1249a.f952s != ScrollState.SEEK && this.f1249a.f927G && this.f1249a.m1546f()) {
                    int g = this.f1249a.aA();
                    int h = this.f1249a.aB();
                    if (g == 1 && this.f1249a.f932L.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                        this.f1249a.f953t = true;
                    } else if (h == 1 && this.f1249a.f929I.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                        this.f1249a.f954u = true;
                    }
                }
                if (this.f1249a.f953t || this.f1249a.f954u) {
                    this.f1251d.m1882a(0);
                    this.f1251d.m1885b(0.0f);
                    this.f1251d.m1887c(360.0f);
                    this.f1249a.m1416a(ScrollState.SEEK);
                    this.f1249a.m1432f(true);
                    m1617c(true);
                    this.f1249a.ac();
                } else if (this.f1249a.f952s == ScrollState.SMOOTH) {
                    m1613b(false);
                    return;
                } else if (this.f1249a.f952s == ScrollState.IDLE || !this.f1249a.f957x) {
                    this.f1251d.m1882a(this.f1249a.aa());
                } else {
                    ScrollState e = this.f1249a.f952s;
                    this.f1249a.m1416a(ScrollState.DRAG);
                    this.f1249a.mo1760a(e, motionEvent.getX(), motionEvent.getY());
                    this.f1249a.m1510b(0.0f, 0.0f);
                    this.f1249a.m1432f(true);
                    m1617c(true);
                }
            }
            if (m1618c() && !m1623e()) {
                this.f1251d.m1611b(view, motionEvent, z, new fg(this));
            }
            if (m1618c() && !m1623e()) {
                this.f1250c.m1611b(view, motionEvent, z, new fh(this));
            }
            if (motionEvent.getActionMasked() == 1) {
                this.f1249a.m1432f(false);
                if (this.f1249a.f952s == ScrollState.SEEK) {
                    this.f1249a.m1416a(ScrollState.IDLE);
                    this.f1249a.ad();
                    return;
                } else if (this.f1249a.f952s == ScrollState.DRAG) {
                    this.f1249a.m1416a(ScrollState.FLING);
                    this.f1249a.mo1768a(motionEvent.getX(), motionEvent.getY(), 0.0f, 0.0f, new fj(this), null);
                    this.f1249a.mo1761b(ScrollState.FLING, motionEvent.getX(), motionEvent.getY());
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        m1613b(false);
    }
}
