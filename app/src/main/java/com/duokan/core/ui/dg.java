package com.duokan.core.ui;

import android.widget.FrameLayout.LayoutParams;
import java.util.Iterator;
import java.util.LinkedList;

class dg extends dh {
    
    private final dd f1141a;
    
    private final LinkedList<cv> f1142b = new LinkedList();

    public dg(dd ddVar) {
        super();
        this.f1141a = ddVar;
    }

    
    public boolean m1811a(boolean z) {
        Iterator it = this.f1142b.iterator();
        while (it.hasNext()) {
            cv cvVar = (cv) it.next();
            if (cvVar.f1102j.m861b()) {
                z = ((Boolean) cvVar.f1102j.m858a()).booleanValue();
            }
        }
        return z;
    }

    
    public boolean m1814b(boolean z) {
        Iterator it = this.f1142b.iterator();
        while (it.hasNext()) {
            cv cvVar = (cv) it.next();
            if (cvVar.f1103k.m861b()) {
                z = ((Boolean) cvVar.f1103k.m858a()).booleanValue();
            }
        }
        return z;
    }

    
    public boolean m1810a() {
        Iterator it = this.f1142b.iterator();
        while (it.hasNext()) {
            if (((cv) it.next()).f1106n) {
                return true;
            }
        }
        return false;
    }

    
    public int m1812b() {
        return this.f1142b.size();
    }

    
    public cv m1808a(int i) {
        return (cv) this.f1142b.get(i);
    }

    
    public void m1809a(cv cvVar) {
        if (!this.f1142b.contains(cvVar)) {
            this.f1142b.add(cvVar);
            this.f1141a.addView(cvVar.f1100h, new LayoutParams(-1, -1));
            this.f1141a.setVisibility(0);
        }
    }

    
    public void m1813b(cv cvVar) {
        if (this.f1142b.contains(cvVar)) {
            this.f1141a.removeView(cvVar.f1100h);
            this.f1142b.remove(cvVar);
            if (this.f1142b.size() < 1) {
                this.f1141a.setVisibility(8);
            }
        }
    }

    
    public void m1815c() {
        this.f1141a.invalidate();
    }
}
