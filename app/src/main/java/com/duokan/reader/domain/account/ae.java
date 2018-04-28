package com.duokan.reader.domain.account;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.domain.statistics.dailystats.C1167a;

class ae implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C0420b f2351a;
    /* renamed from: b */
    final /* synthetic */ ad f2352b;

    ae(ad adVar, C0420b c0420b) {
        this.f2352b = adVar;
        this.f2351a = c0420b;
    }

    public void onClick(View view) {
        C1167a.m8671d().m8677a("a");
        this.f2352b.dismiss();
        C0709k.m3476a().m3492a(this.f2351a);
    }
}
