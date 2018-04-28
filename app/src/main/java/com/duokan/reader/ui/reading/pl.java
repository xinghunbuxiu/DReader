package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Point;

public class pl extends gd {
    /* renamed from: b */
    final /* synthetic */ pg f10796b;

    public pl(pg pgVar, Context context) {
        this.f10796b = pgVar;
        super(context);
    }

    /* renamed from: g */
    public void mo2413g() {
        m14207b(true);
        this.f10796b.f10780b.m14910a();
    }

    /* renamed from: f */
    public void mo2412f() {
        super.mo2412f();
        this.f10796b.f10780b.m14911b();
        this.f10796b.mo2406k();
    }

    /* renamed from: e */
    public void mo2335e() {
        super.mo2335e();
        this.f10796b.mo2407l();
    }

    protected float getContentStaticScale() {
        return ((float) this.f10796b.f10779a.mo1390e()) / ((float) this.f10796b.f10779a.mo1397l().width());
    }

    protected Point getContentStaticCenter() {
        return new Point(this.f10796b.f10779a.mo1397l().centerX(), this.f10796b.f10779a.mo1397l().centerY());
    }
}
