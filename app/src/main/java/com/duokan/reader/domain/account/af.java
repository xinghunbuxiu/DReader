package com.duokan.reader.domain.account;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.domain.statistics.dailystats.C1167a;

class af implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C0420b f2353a;
    /* renamed from: b */
    final /* synthetic */ ad f2354b;

    af(ad adVar, C0420b c0420b) {
        this.f2354b = adVar;
        this.f2353a = c0420b;
    }

    public void onClick(View view) {
        C1167a.m8671d().m8677a("m");
        C0709k.m3476a().m3504b(this.f2353a);
        this.f2354b.dismiss();
    }
}
