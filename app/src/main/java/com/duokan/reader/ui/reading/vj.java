package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.p023b.C0247i;

class vj implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ vd f11059a;

    vj(vd vdVar) {
        this.f11059a = vdVar;
    }

    public void onClick(View view) {
        this.f11059a.f11043a.mo2040a(1, 0);
        if (!this.f11059a.f11043a.l_()) {
            this.f11059a.f11043a.mo2180v().prompt(this.f11059a.getString(C0247i.reading__shared__reach_max_size));
        }
        this.f11059a.m15032c();
    }
}
