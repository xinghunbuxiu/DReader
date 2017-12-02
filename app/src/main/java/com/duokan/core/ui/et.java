package com.duokan.core.ui;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

import java.util.Iterator;
import java.util.LinkedList;

public class et implements OnTouchListener {
    static final /* synthetic */ boolean a = (!et.class.desiredAssertionStatus());
    private final LinkedList b = new LinkedList();
    private es c = null;
    private er d = null;
    private boolean e = true;
    private boolean f = false;
    private eu g = null;

    public void a(boolean z) {
        this.e = z;
    }

    public void a(es esVar) {
        this.c = esVar;
    }

    public er[] a(Class... clsArr) {
        LinkedList linkedList = new LinkedList();
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            er erVar = (er) it.next();
            for (Class isInstance : clsArr) {
                if (isInstance.isInstance(erVar)) {
                    linkedList.add(erVar);
                }
            }
        }
        return (er[]) linkedList.toArray(new er[0]);
    }

    public void a(er erVar) {
        if (a || erVar != null) {
            this.b.addFirst(erVar);
            return;
        }
        throw new AssertionError();
    }

    public void a(View view) {
        d(view);
        this.f = false;
        this.g = null;
        this.d = null;
    }

    public void b(View view) {
        view.setOnTouchListener(this);
    }

    public er a() {
        return this.d;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return a(view, motionEvent, false, false);
    }

    public boolean a(View view, MotionEvent motionEvent) {
        return a(view, motionEvent, false, true);
    }

    private boolean a(View view, MotionEvent motionEvent, boolean z, boolean z2) {
        boolean z3 = false;
        if (this.e) {
            if (motionEvent.getActionMasked() == 0) {
                if (this.g != null) {
                    this.g.run();
                    if (!(a || this.g == null)) {
                        throw new AssertionError();
                    }
                }
                c(view);
                if (this.c != null) {
                    this.c.onTouchDown(view, new PointF(motionEvent.getX(), motionEvent.getY()));
                }
            } else if (motionEvent.getActionMasked() == 3) {
                if (this.c != null) {
                    this.c.onTouchCancel(view, new PointF(motionEvent.getX(), motionEvent.getY()));
                }
                a(view);
            } else if (motionEvent.getActionMasked() == 1 && this.f && this.g == null) {
                this.g = new eu(this, view, motionEvent, z2);
                view.postDelayed(this.g, (long) dv.d());
            }
            this.f = false;
            z3 = a(view, motionEvent, z, z2, this.c);
            if (motionEvent.getAction() == 1) {
                if (this.c != null) {
                    this.c.onTouchUp(view, new PointF(motionEvent.getX(), motionEvent.getY()));
                }
                c(view);
            }
        } else {
            a(view);
        }
        return z3;
    }

    private boolean a(View view, MotionEvent motionEvent, boolean z, boolean z2, es esVar) {
        er erVar;
        boolean z3;
        Object obj = null;
        Object obj2 = null;
        if (this.d != null) {
            if (!this.d.b()) {
                this.d = null;
            } else if (this.d.d()) {
                Object obj3;
                Object obj4;
                erVar = this.d;
                erVar.a(view, motionEvent, z, z2, esVar);
                this.f = erVar.f();
                if (erVar.c()) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (erVar.e()) {
                    obj4 = 1;
                } else {
                    obj4 = null;
                }
                if (!erVar.d()) {
                    this.d = null;
                    c(view);
                }
                if (z2) {
                    return true;
                }
                return (obj3 == null && obj4 == null) ? false : true;
            } else {
                this.d = null;
            }
        }
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            erVar = (er) it.next();
            if (!a && erVar == null) {
                throw new AssertionError();
            } else if (erVar.b()) {
                if (erVar.c()) {
                    erVar.a(view, motionEvent, z, z2, esVar);
                    this.f |= erVar.f();
                }
                if (erVar.c()) {
                    obj = 1;
                }
                if (erVar.e()) {
                    obj2 = 1;
                }
                if (erVar.d()) {
                    this.d = erVar;
                    a(view, this.d);
                    z3 = true;
                    break;
                } else if (erVar.e()) {
                    z3 = false;
                    break;
                }
            }
        }
        z3 = false;
        if (z2) {
            return z3;
        }
        if (obj == null && r7 == null) {
            return false;
        }
        return true;
    }

    private void c(View view) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            er erVar = (er) it.next();
            erVar.b(view, !erVar.c());
        }
    }

    private void d(View view) {
        a(view, null);
    }

    private void a(View view, er erVar) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            er erVar2 = (er) it.next();
            if (erVar2 != erVar) {
                erVar2.b(view, true);
            }
        }
    }
}
