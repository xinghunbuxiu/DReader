package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.MiAccount;

class hq implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ fz f8669a;

    hq(fz fzVar) {
        this.f8669a = fzVar;
    }

    public void onClick(View view) {
        C0709k.m3476a().m3497a(MiAccount.class, new hr(this));
    }
}
