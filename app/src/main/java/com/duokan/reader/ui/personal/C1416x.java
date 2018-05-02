package com.duokan.reader.ui.personal;

import android.view.LayoutInflater;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ui.general.hu;

/* renamed from: com.duokan.reader.ui.personal.x */
public class C1416x extends nm {
    /* renamed from: a */
    static final /* synthetic */ boolean f9054a = (!C1416x.class.desiredAssertionStatus());
    /* renamed from: c */
    private final hu f9055c;
    /* renamed from: d */
    private final ku f9056d = new ku(getContext());
    /* renamed from: e */
    private final dm f9057e;

    public C1416x(IFeature mFeature) {
        super(mFeature, true);
        addSubController(this.f9056d);
        this.f9057e = new dm(getContext());
        addSubController(this.f9057e);
        this.f9055c = new C1417y(this, getContext());
        this.f9055c.m10760a(getString(C0258j.surfing__shared__purchased), this.f9056d.getContentView());
        this.f9055c.m10760a(getString(C0258j.surfing__shared__cloud), this.f9057e.getContentView());
        LayoutInflater.from(getContext()).inflate(C0256h.surfing__surfing_base_view__back, this.f9055c.getLeftLayout(), true).setOnClickListener(new C1418z(this));
        this.f9055c.setOnCurrentPageChangedListener(new aa(this));
        setContentView(this.f9055c);
    }

    /* renamed from: a */
    private ActivatedController m12391a(int i) {
        switch (i) {
            case 0:
                return this.f9056d;
            case 1:
                return this.f9057e;
            default:
                if (f9054a) {
                    return this.f9056d;
                }
                throw new AssertionError();
        }
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            this.f9055c.m10761a(0);
            activate(this.f9056d);
        }
    }
}
