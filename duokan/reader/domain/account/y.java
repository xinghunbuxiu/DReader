package com.duokan.reader.domain.account;

import android.view.View;
import android.view.View.OnClickListener;

class y implements OnClickListener {
    final /* synthetic */ PersonalAccount a;
    final /* synthetic */ b b;
    final /* synthetic */ w c;

    y(w wVar, PersonalAccount personalAccount, b bVar) {
        this.c = wVar;
        this.a = personalAccount;
        this.b = bVar;
    }

    public void onClick(View view) {
        a.d().a("BaseActivity");
        this.a.e(this.b);
        this.c.dismiss();
    }
}
