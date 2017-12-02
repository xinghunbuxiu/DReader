package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import com.duokan.core.ui.di;
import com.duokan.core.ui.dl;
import com.duokan.core.ui.dn;

import org.apache.http.HttpStatus;

class oy extends LinearLayout {
    final /* synthetic */ ow a;
    private final int b;
    private final int c;
    private final Bitmap d;
    private final Rect e;
    private final Rect f;
    private final View g;
    private final View h;
    private final di i;
    private final di j;

    public oy(ow owVar, Context context) {
        Rect a;
        this.a = owVar;
        super(context);
        setClipChildren(false);
        this.b = owVar.a.k().b();
        this.c = owVar.a.k().c();
        this.d = owVar.a.d();
        this.e = owVar.a.c() ? owVar.a.a() : new Rect(0, 0, owVar.a.a().left, this.c);
        if (owVar.a.b_()) {
            a = owVar.a.a();
        } else {
            a = new Rect(owVar.a.a().right, 0, this.b, this.c);
        }
        this.f = a;
        this.g = new oz(this, context, owVar);
        this.h = new pa(this, context, owVar);
        this.i = new di(context);
        this.i.addView(this.g, new dn(-2, -2, 17));
        this.j = new di(context);
        this.j.addView(this.h, new dn(-2, -2, 17));
        addView(this.i, new LayoutParams(-2, -2));
        addView(this.j, new LayoutParams(-2, -2));
        setOrientation(0);
        dl dlVar = new dl();
        dlVar.a(1.0f, 0.5f);
        dl dlVar2 = new dl();
        dlVar2.a(0.0f, 0.5f);
        if (owVar.a.c()) {
            dlVar.c(-90.0f);
        } else {
            dlVar2.c(90.0f);
        }
        this.i.a(this.g, dlVar);
        this.j.a(this.h, dlVar2);
    }

    public void a() {
        if (this.a.a.c()) {
            dl dlVar = new dl();
            dlVar.a(1.0f, 0.5f);
            dlVar.c(0.0f);
            this.i.a(this.g, dlVar, (int) HttpStatus.SC_MULTIPLE_CHOICES);
            return;
        }
        dlVar = new dl();
        dlVar.a(0.0f, 0.5f);
        dlVar.c(0.0f);
        this.j.a(this.h, dlVar, (int) HttpStatus.SC_MULTIPLE_CHOICES);
    }

    public void b() {
        if (this.a.a.c()) {
            dl dlVar = new dl();
            dlVar.a(1.0f, 0.5f);
            dlVar.c(-90.0f);
            this.i.a(this.g, dlVar, (int) HttpStatus.SC_MULTIPLE_CHOICES);
            return;
        }
        dlVar = new dl();
        dlVar.a(0.0f, 0.5f);
        dlVar.c(90.0f);
        this.j.a(this.h, dlVar, (int) HttpStatus.SC_MULTIPLE_CHOICES);
    }
}
