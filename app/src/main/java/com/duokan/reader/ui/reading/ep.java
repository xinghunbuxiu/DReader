package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.p023b.C0247i;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.domain.p044b.C0781b;
import com.duokan.reader.ui.general.be;

class ep implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ eo f10096a;

    ep(eo eoVar) {
        this.f10096a = eoVar;
    }

    public void onClick(View view) {
        if (!C0559f.m2476b().m2486e()) {
            be.m10287a(this.f10096a.getContext(), this.f10096a.getContext().getString(C0247i.report_no_network_error), 0).show();
        } else if (C0781b.m3667b().m3690c().f2665e) {
            this.f10096a.m14009d();
        } else {
            this.f10096a.m14010e();
        }
    }
}
