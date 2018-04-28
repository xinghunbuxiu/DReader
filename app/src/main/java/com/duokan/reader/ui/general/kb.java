package com.duokan.reader.ui.general;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class kb {
    /* renamed from: a */
    public final Bitmap f7509a;
    /* renamed from: b */
    public final int f7510b;
    /* renamed from: c */
    public int f7511c;
    /* renamed from: d */
    public int f7512d;
    /* renamed from: e */
    public int f7513e;
    /* renamed from: f */
    public final Rect f7514f = new Rect();
    /* renamed from: g */
    public final Canvas f7515g;
    /* renamed from: h */
    public kb f7516h;
    /* renamed from: i */
    public kb f7517i;
    /* renamed from: j */
    public boolean f7518j;
    /* renamed from: k */
    public final Rect f7519k = new Rect();
    /* renamed from: l */
    public final Rect f7520l = new Rect();
    /* renamed from: m */
    final /* synthetic */ ka f7521m;

    public kb(ka kaVar, Bitmap bitmap, int i, int i2, int i3, int i4) {
        this.f7521m = kaVar;
        this.f7509a = bitmap;
        this.f7510b = i;
        this.f7511c = i2;
        this.f7512d = i3;
        this.f7513e = i4;
        this.f7515g = new Canvas(bitmap);
        this.f7515g.save();
        this.f7514f.left = 0;
        this.f7514f.top = this.f7511c;
        this.f7514f.right = kaVar.f7499c;
        this.f7514f.bottom = this.f7511c + i3;
        this.f7515g.clipRect(this.f7514f);
        this.f7516h = null;
        this.f7517i = null;
        this.f7518j = false;
        this.f7519k.left = 0;
        this.f7519k.top = 0;
        this.f7519k.right = 0;
        this.f7519k.bottom = 0;
        this.f7520l.left = 0;
        this.f7520l.top = this.f7511c;
        this.f7520l.right = 0;
        this.f7520l.bottom = this.f7511c;
    }

    /* renamed from: a */
    public kb m10920a() {
        this.f7512d /= 2;
        this.f7513e--;
        kb kbVar = new kb(this.f7521m, this.f7509a, this.f7510b, this.f7511c + this.f7512d, this.f7512d, this.f7513e);
        this.f7515g.restore();
        this.f7515g.save();
        this.f7514f.left = 0;
        this.f7514f.top = this.f7511c;
        this.f7514f.right = this.f7521m.f7499c;
        this.f7514f.bottom = this.f7511c + this.f7512d;
        this.f7515g.clipRect(this.f7514f);
        if (this.f7517i != null) {
            this.f7517i.f7516h = kbVar;
        }
        kbVar.f7517i = this.f7517i;
        this.f7517i = kbVar;
        kbVar.f7516h = this;
        return kbVar;
    }

    /* renamed from: a */
    public boolean m10921a(kb kbVar) {
        boolean z = true;
        if (this.f7513e != kbVar.f7513e || this.f7518j || kbVar.f7518j) {
            return false;
        }
        if (this.f7517i == kbVar) {
            if ((this.f7511c / this.f7521m.f7500d) % this.f7521m.f7506j[this.f7513e] != 0) {
                z = false;
            }
            return z;
        } else if (this.f7516h != kbVar) {
            return false;
        } else {
            if ((kbVar.f7511c / this.f7521m.f7500d) % this.f7521m.f7506j[kbVar.f7513e] != 0) {
                z = false;
            }
            return z;
        }
    }

    /* renamed from: b */
    public kb m10922b(kb kbVar) {
        if (this.f7517i != kbVar) {
            return kbVar.m10922b(this);
        }
        this.f7512d *= 2;
        this.f7513e++;
        this.f7515g.restore();
        this.f7515g.save();
        this.f7514f.left = 0;
        this.f7514f.top = this.f7511c;
        this.f7514f.right = this.f7521m.f7499c;
        this.f7514f.bottom = this.f7511c + this.f7512d;
        this.f7515g.clipRect(this.f7514f);
        this.f7517i = kbVar.f7517i;
        if (kbVar.f7517i == null) {
            return this;
        }
        kbVar.f7517i.f7516h = this;
        return this;
    }
}
