package com.duokan.reader.ui.account;

import com.duokan.core.sys.as;
import com.duokan.reader.domain.account.AccountType;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.UserAccount;
import com.duokan.reader.domain.account.i;

class k implements as {
    final /* synthetic */ i a;

    k(i iVar) {
        this.a = iVar;
    }

    public void a() {
        if (!this.a.a.mFinished) {
            this.a.a.mFinished = true;
            if (this.a.a.mLoginListener != null) {
                this.a.a.mLoginListener.a(this.a.a.mAccount, "");
            }
            if (this.a.a.mAccount != null && (this.a.a.mAccount instanceof UserAccount)) {
                ((UserAccount) this.a.a.mAccount).u();
            }
            PersonalAccount personalAccount = (PersonalAccount) i.f().b(PersonalAccount.class);
            if (i.f().a().equals(AccountType.XIAO_MI)) {
                i.f().a(new l(this, personalAccount));
            } else {
                personalAccount.e(null);
            }
        }
    }
}
