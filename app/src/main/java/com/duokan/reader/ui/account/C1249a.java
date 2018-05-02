package com.duokan.reader.ui.account;

import android.accounts.Account;
import android.text.Html;
import com.duokan.core.app.IFeature;
import com.duokan.p024c.C0258j;
import com.duokan.reader.DkApp;
import com.duokan.reader.common.p036b.C0538a;
import com.duokan.reader.common.p036b.C0542e;
import com.duokan.reader.common.webservices.duokan.C0643q;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.MiAccount;
import com.duokan.reader.domain.account.bd;
import com.duokan.reader.ui.general.C1329do;
import com.duokan.reader.ui.general.dn;
import com.duokan.reader.ui.general.eu;

/* renamed from: com.duokan.reader.ui.account.a */
public class C1249a extends eu {
    /* renamed from: a */
    private dn f5773a = new C1250b(this);

    public C1249a(IFeature mFeature) {
        super(mFeature);
        m8849a(C0258j.personal__miaccount_change_nickname_view__title);
        m8852b(20);
        m8851a(((MiAccount) C0709k.m3476a().m3502b(MiAccount.class)).mo848r().f2405e.f5458a.mNickName);
        m8850a(this.f5773a);
    }

    /* renamed from: a */
    private void m8855a(String str, C1329do c1329do) {
        bd r = ((MiAccount) C0709k.m3476a().m3502b(MiAccount.class)).mo848r();
        String obj = Html.fromHtml(str).toString();
        if (obj.equals(r.f2405e.f5458a.mNickName)) {
            c1329do.mo1780a();
            return;
        }
        C0538a a = C0542e.m2411a(DkApp.get().getApplicationContext());
        Account i = a.m2409i();
        if (i != null) {
            a.m2391a(i, "passportapi", null, DkApp.get().getTopActivity(), new C1251c(this, obj, c1329do));
        }
    }

    /* renamed from: a */
    private void m8856a(String str, String str2, C1329do c1329do) {
        new C1252d(this, C0643q.f2173a, C0542e.m2411a(DkApp.get().getApplicationContext()), str, c1329do, str2).open();
    }
}
