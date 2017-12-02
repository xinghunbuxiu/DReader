package com.duokan.reader.ui.personal;

import com.duokan.c.j;
import com.duokan.core.app.e;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.ui.general.ja;
import com.duokan.reader.ui.general.web.StorePageController;
import com.duokan.reader.ui.store.bv;

import java.util.concurrent.Callable;

class ge implements Callable {
    final /* synthetic */ gd a;

    ge(gd gdVar) {
        this.a = gdVar;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public e a() {
        if (!((PersonalAccount) i.f().b(PersonalAccount.class)).q()) {
            return bv.c(this.a.a.getContext());
        }
        e jaVar = new ja(this.a.a.getContext());
        StorePageController storePageController = (StorePageController) bv.c(this.a.a.getContext());
        StorePageController storePageController2 = (StorePageController) bv.b(this.a.a.getContext());
        storePageController.setHasTitle(false);
        storePageController2.setHasTitle(false);
        jaVar.a(storePageController, this.a.a.getContext().getString(j.general__shared__favourite));
        jaVar.a(storePageController2, this.a.a.getContext().getString(j.general__shared__recommend));
        return jaVar;
    }
}
