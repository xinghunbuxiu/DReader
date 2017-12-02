package com.duokan.reader.domain.account;

import android.view.View;
import android.view.View.OnClickListener;

class z implements OnClickListener {
    final /* synthetic */ PersonalAccount a;
    final /* synthetic */ b b;
    final /* synthetic */ w c;

    z(w wVar, PersonalAccount personalAccount, b bVar) {
        this.c = wVar;
        this.a = personalAccount;
        this.b = bVar;
    }

    public void onClick(View view) {
        this.c.dismiss();
        this.a.g(this.b);
    }
}
