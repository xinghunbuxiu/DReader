package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.account.AccountType;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.MiAccount;
import com.duokan.reader.ui.general.ap;
import com.duokan.reader.ui.personal.eu;

class km implements as {
    /* renamed from: a */
    final /* synthetic */ ci f8106a;

    km(ci ciVar) {
        this.f8106a = ciVar;
    }

    /* renamed from: a */
    public void mo1831a() {
        eu euVar = new eu(this.f8106a.f7581b.getActivity());
        if (!euVar.m11786a()) {
            euVar.m11787b();
        } else if (C0709k.m3476a().m3501b() != AccountType.XIAO_MI) {
            ap apVar = new ap(this.f8106a.f7581b.getContext());
            apVar.setPrompt(C0258j.store__mi_live__need_mi_account);
            apVar.setOkLabelResid(C0258j.store__mi_live__login_mi_account);
            apVar.setCancelLabel(C0258j.general__shared__cancel);
            apVar.open(new kn(this, euVar));
        } else {
            euVar.m11785a(C0709k.m3476a().m3502b(MiAccount.class));
        }
    }
}
