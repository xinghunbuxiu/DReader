package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.domain.account.MiGuestAccount;
import com.duokan.reader.domain.account.i;

class hf implements OnClickListener {
    final /* synthetic */ fl a;

    hf(fl flVar) {
        this.a = flVar;
    }

    public void onClick(View view) {
        i.f().a(MiGuestAccount.class, new hg(this));
    }
}
