package com.duokan.reader.ui.reading;

import android.graphics.Point;
import com.duokan.reader.domain.document.C0897d;

class aex {
    /* renamed from: a */
    public afc[] f9604a;
    /* renamed from: b */
    public C0897d f9605b;
    /* renamed from: c */
    public final Point f9606c;
    /* renamed from: d */
    public final Point f9607d;

    private aex() {
        this.f9604a = null;
        this.f9605b = null;
        this.f9606c = new Point();
        this.f9607d = new Point();
    }

    /* renamed from: a */
    public int m13480a() {
        int i = 0;
        int i2 = 0;
        while (i < this.f9604a.length && !this.f9604a[i].f9622b.mo1190c(this.f9605b)) {
            i2 = i;
            i++;
        }
        return i2;
    }

    /* renamed from: b */
    public afc m13481b() {
        return this.f9604a[m13480a()];
    }

    /* renamed from: c */
    public afc m13482c() {
        return this.f9604a[0];
    }

    /* renamed from: d */
    public afc m13483d() {
        return this.f9604a[this.f9604a.length - 1];
    }
}
