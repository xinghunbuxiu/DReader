package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.ViewGroup;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.ui.general.db;
import com.duokan.reader.ui.general.gb;
import com.duokan.reader.ui.general.gc;

public class fv extends db {
    /* renamed from: a */
    final /* synthetic */ fs f10188a;

    protected fv(fs fsVar) {
        this.f10188a = fsVar;
    }

    /* renamed from: a */
    public boolean mo2320a(gc gcVar) {
        return this.f10188a.f10174b.mo1241h(((gs) gcVar).mo2331g());
    }

    /* renamed from: b */
    public boolean mo2322b(gc gcVar) {
        return this.f10188a.f10174b.mo1243i(((gs) gcVar).mo2331g());
    }

    /* renamed from: a */
    protected gc mo2319a(gb gbVar, View view, ViewGroup viewGroup) {
        gx a;
        if (view == null) {
            a = mo2393a();
            a.setStatusColor(this.f10188a.f10183k);
            this.f10188a.getDocument().m5906a(new fw(this, a));
        } else {
            a = (gx) view;
        }
        gc fyVar = new fy(this.f10188a, (fx) gbVar, m14145a((fx) gbVar), a);
        a.setPage(fyVar);
        viewGroup.setClipChildren(false);
        return fyVar;
    }

    /* renamed from: a */
    protected gx mo2393a() {
        return new gx(this.f10188a.getContext(), this.f10188a);
    }

    /* renamed from: a */
    protected as m14145a(fx fxVar) {
        return this.f10188a.f10174b.m5898a(fxVar.m14152a());
    }
}
