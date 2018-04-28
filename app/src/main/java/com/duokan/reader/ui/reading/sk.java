package com.duokan.reader.ui.reading;

import com.duokan.core.app.ag;
import com.duokan.core.app.ah;
import com.duokan.p024c.C0258j;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.ui.general.be;

class sk implements ah {
    /* renamed from: a */
    final /* synthetic */ si f10941a;

    sk(si siVar) {
        this.f10941a = siVar;
    }

    /* renamed from: a */
    public void mo1562a(ag agVar) {
        if (C0559f.m2476b().m2486e()) {
            new hg(this.f10941a.f9358c.getContext()).show();
        } else {
            be.m10286a(this.f10941a.f9358c.getContext(), C0258j.general__shared__network_error, 0).show();
        }
    }

    /* renamed from: b */
    public void mo1567b(ag agVar) {
    }

    /* renamed from: c */
    public void mo1565c(ag agVar) {
    }
}
