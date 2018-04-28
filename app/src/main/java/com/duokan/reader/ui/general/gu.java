package com.duokan.reader.ui.general;

import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.ui.C0374a;
import com.duokan.core.ui.dv;
import com.duokan.p023b.C0243e;
import com.umeng.analytics.pro.C2295j;

class gu extends gy {
    /* renamed from: a */
    final /* synthetic */ gs f7305a;
    /* renamed from: c */
    private final C0374a f7306c = new C0374a(getContext());

    public gu(gs gsVar, IFeature mFeature, ActivatedController c0303e, int i, int i2) {
        this.f7305a = gsVar;
        super(gsVar, mFeature, c0303e);
        this.f7306c.setIndicator(C0243e.general__shared__balloon_indicator);
        this.f7306c.setBackgroundResource(C0243e.general__shared__balloon_background);
        this.f7306c.setIndicatorMargin(dv.m1932b(getContext(), 5.0f));
        this.f7306c.addView(m10733b());
        LayoutParams marginLayoutParams = new MarginLayoutParams(-2, -2);
        switch (i) {
            case 3:
                this.f7306c.setGravity(5);
                marginLayoutParams.rightMargin = i2;
                break;
            case 5:
                this.f7306c.setGravity(3);
                marginLayoutParams.leftMargin = i2;
                break;
            case C2295j.f14321a /*48*/:
                this.f7306c.setGravity(80);
                marginLayoutParams.bottomMargin = i2;
                break;
            case 80:
                this.f7306c.setGravity(48);
                marginLayoutParams.topMargin = i2;
                break;
            default:
                this.f7306c.setGravity(17);
                marginLayoutParams.bottomMargin = i2;
                marginLayoutParams.rightMargin = i2;
                marginLayoutParams.topMargin = i2;
                marginLayoutParams.leftMargin = i2;
                break;
        }
        this.f7306c.setLayoutParams(marginLayoutParams);
        this.f7306c.setClickable(true);
        this.f7306c.setEnabled(false);
        setContentView(this.f7306c);
        addSubController(m10732a());
        activate(m10732a());
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        this.f7306c.removeAllViews();
    }
}
