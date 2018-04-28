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

class pi extends LinearLayout {
    /* renamed from: a */
    final /* synthetic */ pg f10782a;
    /* renamed from: b */
    private final int f10783b;
    /* renamed from: c */
    private final int f10784c;
    /* renamed from: d */
    private final Bitmap f10785d;
    /* renamed from: e */
    private final Rect f10786e;
    /* renamed from: f */
    private final Rect f10787f;
    /* renamed from: g */
    private final View f10788g;
    /* renamed from: h */
    private final View f10789h;
    /* renamed from: i */
    private final di f10790i;
    /* renamed from: j */
    private final di f10791j;

    public pi(pg pgVar, Context context) {
        Rect a;
        this.f10782a = pgVar;
        super(context);
        setClipChildren(false);
        this.f10783b = pgVar.f10779a.mo1396k().mo1402b();
        this.f10784c = pgVar.f10779a.mo1396k().mo1403c();
        this.f10785d = pgVar.f10779a.mo1421d();
        this.f10786e = pgVar.f10779a.mo1419c() ? pgVar.f10779a.mo1418a() : new Rect(0, 0, pgVar.f10779a.mo1418a().left, this.f10784c);
        if (pgVar.f10779a.c_()) {
            a = pgVar.f10779a.mo1418a();
        } else {
            a = new Rect(pgVar.f10779a.mo1418a().right, 0, this.f10783b, this.f10784c);
        }
        this.f10787f = a;
        this.f10788g = new pj(this, context, pgVar);
        this.f10789h = new pk(this, context, pgVar);
        this.f10790i = new di(context);
        this.f10790i.addView(this.f10788g, new dn(-2, -2, 17));
        this.f10791j = new di(context);
        this.f10791j.addView(this.f10789h, new dn(-2, -2, 17));
        addView(this.f10790i, new LayoutParams(-2, -2));
        addView(this.f10791j, new LayoutParams(-2, -2));
        setOrientation(0);
        dl dlVar = new dl();
        dlVar.m1852a(1.0f, 0.5f);
        dl dlVar2 = new dl();
        dlVar2.m1852a(0.0f, 0.5f);
        if (pgVar.f10779a.mo1419c()) {
            dlVar.m1857c(-90.0f);
        } else {
            dlVar2.m1857c(90.0f);
        }
        this.f10790i.m1830a(this.f10788g, dlVar);
        this.f10791j.m1830a(this.f10789h, dlVar2);
    }

    /* renamed from: a */
    public void m14910a() {
        if (this.f10782a.f10779a.mo1419c()) {
            dl dlVar = new dl();
            dlVar.m1852a(1.0f, 0.5f);
            dlVar.m1857c(0.0f);
            this.f10790i.m1831a(this.f10788g, dlVar, (int) HttpStatus.SC_MULTIPLE_CHOICES);
            return;
        }
        dlVar = new dl();
        dlVar.m1852a(0.0f, 0.5f);
        dlVar.m1857c(0.0f);
        this.f10791j.m1831a(this.f10789h, dlVar, (int) HttpStatus.SC_MULTIPLE_CHOICES);
    }

    /* renamed from: b */
    public void m14911b() {
        if (this.f10782a.f10779a.mo1419c()) {
            dl dlVar = new dl();
            dlVar.m1852a(1.0f, 0.5f);
            dlVar.m1857c(-90.0f);
            this.f10790i.m1831a(this.f10788g, dlVar, (int) HttpStatus.SC_MULTIPLE_CHOICES);
            return;
        }
        dlVar = new dl();
        dlVar.m1852a(0.0f, 0.5f);
        dlVar.m1857c(90.0f);
        this.f10791j.m1831a(this.f10789h, dlVar, (int) HttpStatus.SC_MULTIPLE_CHOICES);
    }
}
