package com.duokan.reader.ui.personal;

import com.duokan.core.app.ActivatedController;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.ui.general.ik;
import com.duokan.reader.ui.general.web.StorePageController;
import com.duokan.reader.ui.store.bv;
import java.util.concurrent.Callable;

class gr implements Callable<ActivatedController> {
    /* renamed from: a */
    final /* synthetic */ gq f8619a;

    gr(gq gqVar) {
        this.f8619a = gqVar;
    }

    public /* synthetic */ Object call() {
        return m11937a();
    }

    /* renamed from: a */
    public ActivatedController m11937a() {
        if (!((PersonalAccount) C0709k.m3476a().m3502b(PersonalAccount.class)).mo845p()) {
            return bv.m15360c(this.f8619a.f8618a.getContext());
        }
        ActivatedController ikVar = new ik(this.f8619a.f8618a.getContext());
        StorePageController storePageController = (StorePageController) bv.m15360c(this.f8619a.f8618a.getContext());
        StorePageController storePageController2 = (StorePageController) bv.m15358b(this.f8619a.f8618a.getContext());
        storePageController.setHasTitle(false);
        storePageController2.setHasTitle(false);
        ikVar.m10793a(storePageController, this.f8619a.f8618a.getContext().getString(C0258j.general__shared__favourite));
        ikVar.m10793a(storePageController2, this.f8619a.f8618a.getContext().getString(C0258j.general__shared__recommend));
        return ikVar;
    }
}
