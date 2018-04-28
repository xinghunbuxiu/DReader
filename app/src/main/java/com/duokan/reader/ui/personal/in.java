package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.p024c.C0258j;
import com.duokan.reader.common.C0543b;

class in implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ ij f8737a;

    in(ij ijVar) {
        this.f8737a = ijVar;
    }

    public void onClick(View view) {
        String format;
        if (this.f8737a.f8719c.mo1910f() == 0.0d) {
            format = String.format(this.f8737a.getString(C0258j.personal__experience_view__share_template_ranking_low), new Object[]{Long.valueOf(this.f8737a.f8719c.mo1906b()), C0543b.m2421a(this.f8737a.f8719c.mo1907c())});
        } else if (this.f8737a.f8719c.mo1911g() <= 0) {
            format = String.format(this.f8737a.getString(C0258j.f421x6ae6c7e8), new Object[]{C0543b.m2420a(this.f8737a.f8719c.mo1910f()), Long.valueOf(this.f8737a.f8719c.mo1906b()), C0543b.m2421a(this.f8737a.f8719c.mo1907c())});
        } else {
            format = String.format(this.f8737a.getString(C0258j.personal__experience_view__share_template), new Object[]{C0543b.m2420a(this.f8737a.f8719c.mo1910f()), Long.valueOf(this.f8737a.f8719c.mo1906b()), C0543b.m2421a(this.f8737a.f8719c.mo1907c()), C0543b.m2421a(this.f8737a.f8719c.mo1911g() / 30)});
        }
        this.f8737a.f8718a.m8871a(this.f8737a.getContext(), format, this.f8737a.m12006d());
    }
}
