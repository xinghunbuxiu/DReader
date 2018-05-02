package com.duokan.reader.domain.plugins.dict;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.p023b.C0247i;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.domain.downloadcenter.C1016b;
import com.duokan.reader.ui.general.be;

/* renamed from: com.duokan.reader.domain.plugins.dict.c */
class C1108c implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ String f5389a;
    /* renamed from: b */
    final /* synthetic */ C1106a f5390b;

    C1108c(C1106a c1106a, String str) {
        this.f5390b = c1106a;
        this.f5389a = str;
    }

    public void onClick(View view) {
        if (C0559f.m2476b().m2486e()) {
            C1016b.m7857p().m7879b(C1016b.m7857p().m7877b(this.f5389a));
        } else {
            be.m10287a(this.f5390b.f5386a.getContext(), this.f5390b.f5386a.getContext().getString(C0247i.report_no_network_error), 0).show();
        }
    }
}
