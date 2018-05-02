package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Point;

public class pb extends fy {
    final /* synthetic */ ow b;

    public pb(ow owVar, Context context) {
        this.b = owVar;
        super(context);
    }

    public void g() {
        b(true);
        this.b.b.a();
    }

    public void f() {
        super.f();
        this.b.b.b();
        this.b.k();
    }

    public void e() {
        super.e();
        this.b.l();
    }

    protected float getContentStaticScale() {
        return ((float) this.b.a.e()) / ((float) this.b.a.l().width());
    }

    protected Point getContentStaticCenter() {
        return new Point(this.b.a.l().centerX(), this.b.a.l().centerY());
    }
}
