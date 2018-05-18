package com.duokan.core.ui;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import java.util.Iterator;
import java.util.LinkedList;

public class et implements OnTouchListener {
    
    static final  boolean f1222a = (!et.class.desiredAssertionStatus());
    
    private final LinkedList<er> f1223b = new LinkedList();
    
    private es f1224c = null;
    
    private er f1225d = null;
    
    private boolean f1226e = true;
    
    private boolean f1227f = false;
    
    private eu f1228g = null;

    
    public void m2043a(boolean z) {
        this.f1226e = z;
    }

    
    public void m2042a(es esVar) {
        this.f1224c = esVar;
    }

    
    public er[] m2045a(Class<?>... clsArr) {
        LinkedList linkedList = new LinkedList();
        Iterator it = this.f1223b.iterator();
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

    
    public void m2041a(er erVar) {
        if (f1222a || erVar != null) {
            this.f1223b.addFirst(erVar);
            return;
        }
        throw new AssertionError();
    }

    
    public void m2040a(View view) {
        m2038d(view);
        this.f1227f = false;
        this.f1228g = null;
        this.f1225d = null;
    }

    
    public void m2046b(View view) {
        view.setOnTouchListener(this);
    }

    
    public er m2039a() {
        return this.f1225d;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return m2033a(view, motionEvent, false, false);
    }

    
    public boolean m2044a(View view, MotionEvent motionEvent) {
        return m2033a(view, motionEvent, false, true);
    }

    
    private boolean m2033a(View view, MotionEvent motionEvent, boolean z, boolean z2) {
        boolean z3 = false;
        if (this.f1226e) {
            if (motionEvent.getActionMasked() == 0) {
                if (this.f1228g != null) {
                    this.f1228g.run();
                    if (!(f1222a || this.f1228g == null)) {
                        throw new AssertionError();
                    }
                }
                m2037c(view);
                if (this.f1224c != null) {
                    this.f1224c.onTouchDown(view, new PointF(motionEvent.getX(), motionEvent.getY()));
                }
            } else if (motionEvent.getActionMasked() == 3) {
                if (this.f1224c != null) {
                    this.f1224c.onTouchCancel(view, new PointF(motionEvent.getX(), motionEvent.getY()));
                }
                m2040a(view);
            } else if (motionEvent.getActionMasked() == 1 && this.f1227f && this.f1228g == null) {
                this.f1228g = new eu(this, view, motionEvent, z2);
                view.postDelayed(this.f1228g, (long) AnimUtils.getDoubleTapTimeout());
            }
            this.f1227f = false;
            z3 = m2034a(view, motionEvent, z, z2, this.f1224c);
            if (motionEvent.getAction() == 1) {
                if (this.f1224c != null) {
                    this.f1224c.onTouchUp(view, new PointF(motionEvent.getX(), motionEvent.getY()));
                }
                m2037c(view);
            }
        } else {
            m2040a(view);
        }
        return z3;
    }

    
    private boolean m2034a(View view, MotionEvent motionEvent, boolean z, boolean z2, es esVar) {
        boolean z3;
        Object obj = null;
        Object obj2 = null;
        if (this.f1225d != null) {
            if (!this.f1225d.m1614b()) {
                this.f1225d = null;
            } else if (this.f1225d.m1621d()) {
                er erVar;
                Object obj3;
                Object obj4;
                erVar = this.f1225d;
                erVar.m1605a(view, motionEvent, z, z2, esVar);
                this.f1227f = erVar.m1624f();
                if (erVar.m1618c()) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (erVar.m1623e()) {
                    obj4 = 1;
                } else {
                    obj4 = null;
                }
                if (!erVar.m1621d()) {
                    this.f1225d = null;
                    m2037c(view);
                }
                if (z2) {
                    return true;
                }
                return (obj3 == null && obj4 == null) ? false : true;
            } else {
                this.f1225d = null;
            }
        }
        Iterator it = this.f1223b.iterator();
        while (it.hasNext()) {
            erVar = (er) it.next();
            if (!f1222a && erVar == null) {
                throw new AssertionError();
            } else if (erVar.m1614b()) {
                if (erVar.m1618c()) {
                    erVar.m1605a(view, motionEvent, z, z2, esVar);
                    this.f1227f |= erVar.m1624f();
                }
                if (erVar.m1618c()) {
                    obj = 1;
                }
                if (erVar.m1623e()) {
                    obj2 = 1;
                }
                if (erVar.m1621d()) {
                    this.f1225d = erVar;
                    m2032a(view, this.f1225d);
                    z3 = true;
                    break;
                } else if (erVar.m1623e()) {
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

    
    private void m2037c(View view) {
        Iterator it = this.f1223b.iterator();
        while (it.hasNext()) {
            er erVar = (er) it.next();
            erVar.m1612b(view, !erVar.m1618c());
        }
    }

    
    private void m2038d(View view) {
        m2032a(view, null);
    }

    
    private void m2032a(View view, er erVar) {
        Iterator it = this.f1223b.iterator();
        while (it.hasNext()) {
            er erVar2 = (er) it.next();
            if (erVar2 != erVar) {
                erVar2.m1612b(view, true);
            }
        }
    }
}
