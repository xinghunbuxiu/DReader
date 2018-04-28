package com.duokan.reader.ui.personal;

import com.duokan.p024c.C0258j;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.ui.general.be;

class bb implements C0666x {
    /* renamed from: a */
    final /* synthetic */ ba f8304a;

    bb(ba baVar) {
        this.f8304a = baVar;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        if (C0559f.m2476b().m2486e()) {
            new af(this.f8304a.f8303a.getContext(), c0672a, this.f8304a.f8303a).show();
        } else {
            be.m10286a(this.f8304a.f8303a.getContext(), C0258j.general__shared__network_error, 0).show();
        }
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
        be.m10286a(this.f8304a.f8303a.getContext(), C0258j.personal__create_feedback_view__no_account, 0).show();
    }
}
