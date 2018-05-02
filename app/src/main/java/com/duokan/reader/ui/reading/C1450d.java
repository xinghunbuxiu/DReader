package com.duokan.reader.ui.reading;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.domain.ad.C0748e;
import com.duokan.reader.domain.ad.C0750g;
import com.duokan.reader.ui.general.ji;

/* renamed from: com.duokan.reader.ui.reading.d */
class C1450d implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ View f9971a;
    /* renamed from: b */
    final /* synthetic */ C0748e f9972b;
    /* renamed from: c */
    final /* synthetic */ Context f9973c;
    /* renamed from: d */
    final /* synthetic */ C1446a f9974d;

    C1450d(C1446a c1446a, View view, C0748e c0748e, Context context) {
        this.f9974d = c1446a;
        this.f9971a = view;
        this.f9972b = c0748e;
        this.f9973c = context;
    }

    public void onClick(View view) {
        if (C1446a.m12752d(this.f9971a)) {
            C0750g.m3561a().m3588b(this.f9972b);
            synchronized (this.f9974d) {
                C1446a.m12743a(this.f9974d);
            }
            ji jiVar = new ji(this.f9973c);
            jiVar.m10873a(true);
            jiVar.m10874b();
            jiVar.m10872a(this.f9972b.f2521f);
            jiVar.show();
        }
    }
}
