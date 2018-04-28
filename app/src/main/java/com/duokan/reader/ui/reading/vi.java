package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.p023b.C0247i;

class vi implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ vd f11058a;

    vi(vd vdVar) {
        this.f11058a = vdVar;
    }

    public void onClick(View view) {
        this.f11058a.f11043a.mo2040a(1, 0);
        if (!this.f11058a.f11043a.mo2163l()) {
            this.f11058a.f11043a.mo2180v().prompt(this.f11058a.getString(C0247i.reading__shared__reach_min_size));
        }
        this.f11058a.m15032c();
    }
}
