package com.duokan.reader.domain.account;

import android.view.View;
import android.view.View.OnClickListener;

class ag implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C0420b f2355a;
    /* renamed from: b */
    final /* synthetic */ ad f2356b;

    ag(ad adVar, C0420b c0420b) {
        this.f2356b = adVar;
        this.f2355a = c0420b;
    }

    public void onClick(View view) {
        this.f2356b.dismiss();
        C0709k.m3476a().m3509d(this.f2355a);
    }
}
