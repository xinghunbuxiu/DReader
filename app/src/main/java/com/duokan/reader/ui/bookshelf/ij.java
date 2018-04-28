package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.core.app.ActivatedController;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.ui.general.web.StorePageController;

class ij implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ ie f6613a;

    ij(ie ieVar) {
        this.f6613a = ieVar;
    }

    public void onClick(View view) {
        ActivatedController createWebPage = StorePageController.createWebPage(this.f6613a.getContext());
        createWebPage.loadUrl(C0641o.m2934i().m2938B());
        this.f6613a.f6599k.pushHalfPageSmoothly(createWebPage, null);
    }
}
