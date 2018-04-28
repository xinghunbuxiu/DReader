package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.PersonalAccount;

class gj implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ fz f8611a;

    gj(fz fzVar) {
        this.f8611a = fzVar;
    }

    public void onClick(View view) {
        this.f8611a.m11853a("reading_info");
        if (((PersonalAccount) C0709k.m3476a().m3502b(PersonalAccount.class)).mo846q()) {
            this.f8611a.m11869c(false, new gl(this));
        } else {
            this.f8611a.m11862b(false, new gk(this));
        }
    }
}
