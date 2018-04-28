package com.duokan.reader.ui.reading;

import com.duokan.core.app.IFeature;
import com.duokan.core.ui.dv;

public class yw extends ze {
    public yw(IFeature mFeature, zw zwVar) {
        super(mFeature, zwVar);
    }

    /* renamed from: a */
    public void m15218a(int i) {
        this.C = i;
    }

    /* renamed from: a */
    public void mo2520a(String str, boolean z, ady ady) {
        super.mo2520a(str, z, ady);
        this.d.setVisibility(0);
        this.z.m10809a(this.s);
        this.z.m10809a(this.q);
        this.z.m10809a(this.i);
        this.z.m10809a(this.t);
        this.z.m10809a(this.j);
        this.z.m10809a(this.r);
        if (m15215g()) {
            this.z.m10809a(this.h);
        }
        for (int i = 0; i < this.z.getToolCount(); i++) {
            this.z.m10807a(i).setPadding(0, 0, dv.m1932b(getContext(), 20.0f), 0);
        }
        this.z.m10808a(dv.m1932b(getContext(), 10.0f), 0, dv.m1932b(getContext(), 10.0f), 0);
        this.d.addView(this.z);
    }
}
