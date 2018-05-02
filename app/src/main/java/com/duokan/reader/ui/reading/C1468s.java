package com.duokan.reader.ui.reading;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.duokan.core.app.AppContext;
import com.duokan.core.ui.C0394t;
import com.duokan.reader.domain.bookshelf.C0798a;
import com.duokan.reader.domain.bookshelf.ea;
import com.duokan.reader.domain.bookshelf.eb;
import com.duokan.reader.domain.document.C0897d;

/* renamed from: com.duokan.reader.ui.reading.s */
public class C1468s {
    /* renamed from: a */
    private final yw f10924a;
    /* renamed from: b */
    private Rect[] f10925b;
    /* renamed from: c */
    private ea f10926c;
    /* renamed from: d */
    private C0394t f10927d;
    /* renamed from: e */
    private final su f10928e;

    public C1468s(Activity activity, su suVar, adi adi) {
        this.f10928e = suVar;
        this.f10924a = new yw(AppContext.getAppContext((Context) activity), new C1469t(this, adi));
        this.f10927d = new C1470u(this, activity);
        this.f10927d.setContentView(this.f10924a.getContentView());
        this.f10924a.getContentView().setOnClickListener(new C1471v(this));
    }

    /* renamed from: a */
    public void m14966a(C0798a c0798a, View view) {
        this.f10928e.aU();
        this.f10926c = (ea) c0798a;
        this.f10925b = this.f10928e.mo2107b(this.f10928e.getDocument().mo1216a((C0897d) c0798a.m3726d(), (C0897d) c0798a.m3728e()));
        this.f10924a.m15218a(eb.m4386a().m4391c(this.f10926c.m4385n()));
        this.f10924a.mo2520a(this.f10926c.m3729f(), false, new C1472w(this));
    }
}
