package com.duokan.reader.ui.reading;

import android.os.SystemClock;
import com.duokan.core.sys.UThread;

class afb implements Runnable {
    /* renamed from: a */
    public final int f9617a;
    /* renamed from: b */
    public long f9618b = 0;
    /* renamed from: c */
    public long f9619c = 0;
    /* renamed from: d */
    final /* synthetic */ adz f9620d;

    public afb(adz adz, int i) {
        this.f9620d = adz;
        this.f9617a = i;
        this.f9618b = SystemClock.uptimeMillis() + ((long) i);
    }

    /* renamed from: a */
    public int m13487a() {
        int i;
        if (this.f9619c != 0) {
            i = (int) (this.f9618b - this.f9619c);
        } else {
            i = (int) (this.f9618b - SystemClock.uptimeMillis());
        }
        return Math.max(0, i);
    }

    /* renamed from: b */
    public void m13488b() {
        if (this.f9620d.f9550j != null) {
            this.f9620d.f9550j.m13489c();
        }
        this.f9620d.f9550j = this;
        UThread.postAtTime(this, this.f9618b);
    }

    /* renamed from: c */
    public void m13489c() {
        UThread.removeCallbacks(this);
        if (this.f9620d.f9550j == this) {
            this.f9620d.f9550j = null;
        }
    }

    /* renamed from: d */
    public void m13490d() {
        if (this.f9619c == 0) {
            this.f9619c = SystemClock.uptimeMillis();
            UThread.removeCallbacks(this);
        }
    }

    /* renamed from: e */
    public void m13491e() {
        if (this.f9619c != 0) {
            this.f9618b += SystemClock.uptimeMillis() - this.f9619c;
            this.f9619c = 0;
            if (this.f9620d.f9550j == this) {
                UThread.postAtTime(this, this.f9618b);
            }
        }
    }

    public void run() {
        if (this.f9620d.f9550j == this) {
            this.f9620d.f9550j = null;
            this.f9620d.m13446b();
        }
    }
}
