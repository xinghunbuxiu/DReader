package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.i;

class fw implements OnClickListener {
    final /* synthetic */ fl a;

    fw(fl flVar) {
        this.a = flVar;
    }

    public void onClick(View view) {
        this.a.a("reading_info");
        if (((PersonalAccount) i.f().b(PersonalAccount.class)).r()) {
            this.a.c(false, new fy(this));
        } else {
            this.a.b(false, new fx(this));
        }
    }
}
