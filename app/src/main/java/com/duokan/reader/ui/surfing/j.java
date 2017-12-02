package com.duokan.reader.ui.surfing;

import com.duokan.core.sys.t;
import com.duokan.reader.DkApp;
import com.duokan.reader.domain.account.MiAccount;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.i;

class j implements Runnable {
    final /* synthetic */ f a;

    j(f fVar) {
        this.a = fVar;
    }

    public void run() {
        if (DkApp.get().getAutoLogin()) {
            MiAccount miAccount = (MiAccount) i.f().b(MiAccount.class);
            if (MiAccount.a(this.a.getContext()) && (miAccount == null || miAccount.i())) {
                ((PersonalAccount) i.f().b(PersonalAccount.class)).a(new k(this));
                return;
            }
        }
        a();
    }

    private void a() {
        t.a(new l(this), 2000);
    }
}
