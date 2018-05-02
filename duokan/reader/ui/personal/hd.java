package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.domain.account.MiAccount;
import com.duokan.reader.domain.account.i;

class hd implements OnClickListener {
    final /* synthetic */ fl a;

    hd(fl flVar) {
        this.a = flVar;
    }

    public void onClick(View view) {
        i.f().a(MiAccount.class, new he(this));
    }
}
