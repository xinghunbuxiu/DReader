package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.MiGuestAccount;

class hs implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ fz f8671a;

    hs(fz fzVar) {
        this.f8671a = fzVar;
    }

    public void onClick(View view) {
        C0709k.m3476a().m3497a(MiGuestAccount.class, new ht(this));
    }
}
