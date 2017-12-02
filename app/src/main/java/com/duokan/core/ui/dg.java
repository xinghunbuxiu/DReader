package com.duokan.core.ui;

import android.widget.FrameLayout.LayoutParams;

import java.util.Iterator;
import java.util.LinkedList;

class dg extends dh {
    private final dd a;
    private final LinkedList b = new LinkedList();

    public dg(dd ddVar) {
        super();
        this.a = ddVar;
    }

    public boolean a(boolean z) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            cv cvVar = (cv) it.next();
            if (cvVar.j.b()) {
                z = ((Boolean) cvVar.j.a()).booleanValue();
            }
        }
        return z;
    }

    public boolean b(boolean z) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            cv cvVar = (cv) it.next();
            if (cvVar.k.b()) {
                z = ((Boolean) cvVar.k.a()).booleanValue();
            }
        }
        return z;
    }

    public boolean a() {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            if (((cv) it.next()).n) {
                return true;
            }
        }
        return false;
    }

    public int b() {
        return this.b.size();
    }

    public cv a(int i) {
        return (cv) this.b.get(i);
    }

    public void a(cv cvVar) {
        if (!this.b.contains(cvVar)) {
            this.b.add(cvVar);
            this.a.addView(cvVar.h, new LayoutParams(-1, -1));
            this.a.setVisibility(0);
        }
    }

    public void b(cv cvVar) {
        if (this.b.contains(cvVar)) {
            this.a.removeView(cvVar.h);
            this.b.remove(cvVar);
            if (this.b.size() < 1) {
                this.a.setVisibility(8);
            }
        }
    }

    public void c() {
        this.a.invalidate();
    }
}
