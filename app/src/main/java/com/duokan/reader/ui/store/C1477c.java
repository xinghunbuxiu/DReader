package com.duokan.reader.ui.store;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.domain.account.C0709k;

/* renamed from: com.duokan.reader.ui.store.c */
class C1477c implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C1475a f11387a;

    C1477c(C1475a c1475a) {
        this.f11387a = c1475a;
    }

    public void onClick(View view) {
        this.f11387a.requestDetach();
        C0709k.m3476a().m3495a(new C1491d(this));
    }
}
