package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.core.app.e;
import com.duokan.reader.common.webservices.duokan.p;
import com.duokan.reader.ui.general.web.StorePageController;

class ft implements OnClickListener {
    final /* synthetic */ fl a;

    ft(fl flVar) {
        this.a = flVar;
    }

    public void onClick(View view) {
        e storePageController = new StorePageController(this.a.getContext());
        storePageController.loadUrl(p.i().D());
        this.a.a.showPopup(storePageController);
    }
}
