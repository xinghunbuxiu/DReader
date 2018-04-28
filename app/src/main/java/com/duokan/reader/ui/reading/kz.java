package com.duokan.reader.ui.reading;

import android.content.Context;
import com.duokan.core.app.AppContext;
import com.duokan.reader.domain.document.au;

public class kz extends gd {
    /* renamed from: b */
    private final su f10541b = ((su) AppContext.getAppContext(getContext()).queryFeature(su.class));
    /* renamed from: c */
    private final au f10542c;
    /* renamed from: d */
    private final la f10543d;

    public kz(Context context, au auVar) {
        super(context);
        this.f10542c = auVar;
        this.f10543d = new la(this, context);
        m14203a(this.f10543d, null);
    }

    /* renamed from: i */
    public float mo2421i() {
        return this.f10543d.m14608a();
    }

    /* renamed from: e */
    public void mo2335e() {
        super.mo2335e();
        this.f10543d.m14609a(true);
    }

    /* renamed from: f */
    public void mo2412f() {
        super.mo2412f();
        this.f10543d.m14609a(false);
    }
}
