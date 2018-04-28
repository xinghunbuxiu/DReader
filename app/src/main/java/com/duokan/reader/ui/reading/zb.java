package com.duokan.reader.ui.reading;

import com.duokan.core.app.IFeature;

class zb extends ze {
    /* renamed from: E */
    private final zw f11261E;

    public zb(IFeature mFeature, zw zwVar) {
        super(mFeature, zwVar);
        this.f11261E = zwVar;
        this.o.setOnLongClickListener(new zc(this));
        this.o.setOnClickListener(new zd(this));
    }

    /* renamed from: a */
    public void m15228a(int i) {
        this.C = i;
    }

    /* renamed from: a */
    public void mo2520a(String str, boolean z, ady ady) {
        super.mo2520a(str, z, ady);
        if (m15215g()) {
            this.d.setVisibility(0);
            this.d.addView(this.o);
            this.d.addView(this.j);
            this.d.addView(this.r);
            this.d.addView(this.h);
            this.d.addView(this.i);
            return;
        }
        this.d.setVisibility(0);
        this.d.addView(this.o);
        this.d.addView(this.j);
        this.d.addView(this.r);
        this.d.addView(this.i);
    }
}
