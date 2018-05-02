package com.duokan.reader.ui.account;

import android.accounts.Account;
import android.text.Html;

import com.duokan.c.j;
import com.duokan.core.app.IFeature;
import com.duokan.reader.DkApp;
import com.duokan.reader.common.b.a;
import com.duokan.reader.common.b.e;
import com.duokan.reader.domain.account.MiAccount;
import com.duokan.reader.domain.account.bh;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.ui.general.dn;
import com.duokan.reader.ui.general.ew;

do;

public class m extends ew {
    private dn a = new n(this);

    public m(IFeature featrue) {
        super(featrue);
        a(j.personal__miaccount_change_nickname_view__title);
        b(20);
        a(((MiAccount) i.f().b(MiAccount.class)).o().e.a.mNickName);
        a(this.a);
    }

    private void a(String str, do doVar) {
        bh o = ((MiAccount) i.f().b(MiAccount.class)).o();
        String obj = Html.fromHtml(str).toString();
        if (obj.equals(o.e.a.mNickName)) {
            doVar.a();
            return;
        }
        a a = e.a(DkApp.get().getApplicationContext());
        Account i = a.i();
        if (i != null) {
            a.a(i, "passportapi", null, DkApp.get().getTopActivity(), new o(this, obj, doVar));
        }
    }

    private void a(String str, String str2, do doVar) {
        new p(this, e.a(DkApp.get().getApplicationContext()), str, doVar, str2).open();
    }
}
