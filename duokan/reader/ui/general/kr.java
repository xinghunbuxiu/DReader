package com.duokan.reader.ui.general;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class kr {
    public final Bitmap a;
    public final int b;
    public int c;
    public int d;
    public int e;
    public final Rect f = new Rect();
    public final Canvas g;
    public kr h;
    public kr i;
    public boolean j;
    public final Rect k = new Rect();
    public final Rect l = new Rect();
    final /* synthetic */ kq m;

    public kr(kq kqVar, Bitmap bitmap, int i, int i2, int i3, int i4) {
        this.m = kqVar;
        this.a = bitmap;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.g = new Canvas(bitmap);
        this.g.save();
        this.f.left = 0;
        this.f.top = this.c;
        this.f.right = kqVar.c;
        this.f.bottom = this.c + i3;
        this.g.clipRect(this.f);
        this.h = null;
        this.i = null;
        this.j = false;
        this.k.left = 0;
        this.k.top = 0;
        this.k.right = 0;
        this.k.bottom = 0;
        this.l.left = 0;
        this.l.top = this.c;
        this.l.right = 0;
        this.l.bottom = this.c;
    }

    public kr a() {
        this.d /= 2;
        this.e--;
        kr krVar = new kr(this.m, this.a, this.b, this.c + this.d, this.d, this.e);
        this.g.restore();
        this.g.save();
        this.f.left = 0;
        this.f.top = this.c;
        this.f.right = this.m.c;
        this.f.bottom = this.c + this.d;
        this.g.clipRect(this.f);
        if (this.i != null) {
            this.i.h = krVar;
        }
        krVar.i = this.i;
        this.i = krVar;
        krVar.h = this;
        return krVar;
    }

    public boolean a(kr krVar) {
        boolean z = true;
        if (this.e != krVar.e || this.j || krVar.j) {
            return false;
        }
        if (this.i == krVar) {
            if ((this.c / this.m.d) % this.m.j[this.e] != 0) {
                z = false;
            }
            return z;
        } else if (this.h != krVar) {
            return false;
        } else {
            if ((krVar.c / this.m.d) % this.m.j[krVar.e] != 0) {
                z = false;
            }
            return z;
        }
    }

    public kr b(kr krVar) {
        if (this.i != krVar) {
            return krVar.b(this);
        }
        this.d *= 2;
        this.e++;
        this.g.restore();
        this.g.save();
        this.f.left = 0;
        this.f.top = this.c;
        this.f.right = this.m.c;
        this.f.bottom = this.c + this.d;
        this.g.clipRect(this.f);
        this.i = krVar.i;
        if (krVar.i == null) {
            return this;
        }
        krVar.i.h = this;
        return this;
    }
}
