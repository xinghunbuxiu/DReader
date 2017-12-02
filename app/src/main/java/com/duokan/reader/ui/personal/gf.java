package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.i;

class gf implements OnClickListener {
    final /* synthetic */ fl a;

    gf(fl flVar) {
        this.a = flVar;
    }

    public void onClick(View view) {
        this.a.a("notes");
        if (((PersonalAccount) i.f().b(PersonalAccount.class)).p()) {
            this.a.c(false, new gh(this));
        } else {
            this.a.b(false, new gg(this));
        }
    }
}
