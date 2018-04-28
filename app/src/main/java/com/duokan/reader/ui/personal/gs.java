package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.PersonalAccount;

class gs implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ fz f8620a;

    gs(fz fzVar) {
        this.f8620a = fzVar;
    }

    public void onClick(View view) {
        this.f8620a.m11853a("notes");
        if (((PersonalAccount) C0709k.m3476a().m3502b(PersonalAccount.class)).mo844o()) {
            this.f8620a.m11869c(false, new gu(this));
        } else {
            this.f8620a.m11862b(false, new gt(this));
        }
    }
}
