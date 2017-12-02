package com.duokan.reader.ui.bookshelf;

import com.duokan.core.app.e;
import com.duokan.reader.common.webservices.duokan.p;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.bookshelf.kp;
import com.duokan.reader.ui.general.web.StorePageController;

class ig implements Runnable {
    final /* synthetic */ ic a;

    ig(ic icVar) {
        this.a = icVar;
    }

    public void run() {
        this.a.requestDetach();
        kp.a().a(new ab(i.f().b(PersonalAccount.class)));
        e storePageController = new StorePageController(this.a.getContext());
        storePageController.loadUrl(p.i().K());
        this.a.s.showPopup(storePageController);
    }
}
