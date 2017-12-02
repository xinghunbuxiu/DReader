package com.duokan.reader.ui.personal;

import com.duokan.c.j;
import com.duokan.reader.common.c.f;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.u;
import com.duokan.reader.ui.general.be;

class bi implements u {
    final /* synthetic */ bh a;

    bi(bh bhVar) {
        this.a = bhVar;
    }

    public void onQueryAccountOk(a aVar) {
        if (f.b().e()) {
            new am(this.a.a.getContext(), aVar, this.a.a).show();
        } else {
            be.a(this.a.a.getContext(), j.general__shared__network_error, 0).show();
        }
    }

    public void onQueryAccountError(a aVar, String str) {
        be.a(this.a.a.getContext(), j.personal__create_feedback_view__no_account, 0).show();
    }
}
