package com.duokan.reader.domain.plugins.dict;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.p023b.C0247i;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.ui.general.be;

/* renamed from: com.duokan.reader.domain.plugins.dict.f */
class C1111f implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C1114i f5395a;
    /* renamed from: b */
    final /* synthetic */ C1106a f5396b;

    C1111f(C1106a c1106a, C1114i c1114i) {
        this.f5396b = c1106a;
        this.f5395a = c1114i;
    }

    public void onClick(View view) {
        if (C0559f.m2476b().m2486e()) {
            this.f5396b.m8396a(this.f5395a);
            view.setClickable(false);
            return;
        }
        be.m10287a(this.f5396b.f5386a.getContext(), this.f5396b.f5386a.getContext().getString(C0247i.report_no_network_error), 0).show();
    }
}
