package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.MyContextWrapper;
import com.duokan.reader.common.webservices.duokan.p;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.bookshelf.kp;
import com.duokan.reader.ui.general.web.StorePageController;

class k implements OnClickListener {
    final /* synthetic */ g a;

    k(g gVar) {
        this.a = gVar;
    }

    public void onClick(View view) {
        kp.a().a(new ab(i.f().b(PersonalAccount.class)));
        ActivatedController storePageController = new StorePageController(MyContextWrapper.getFeature(this.a.getContext()));
        storePageController.loadUrl(p.i().K());
        this.a.a.showPopup(storePageController);
    }
}
