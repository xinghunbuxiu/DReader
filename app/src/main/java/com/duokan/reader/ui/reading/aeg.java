package com.duokan.reader.ui.reading;

import android.graphics.Point;

import com.duokan.reader.domain.document.d;

class aeg {
    public ael[] a;
    public d b;
    public final Point c;
    public final Point d;

    private aeg() {
        this.a = null;
        this.b = null;
        this.c = new Point();
        this.d = new Point();
    }

    public int a() {
        int i = 0;
        int i2 = 0;
        while (i < this.a.length && !this.a[i].b.c(this.b)) {
            i2 = i;
            i++;
        }
        return i2;
    }

    public ael b() {
        return this.a[a()];
    }

    public ael c() {
        return this.a[0];
    }

    public ael d() {
        return this.a[this.a.length - 1];
    }
}
