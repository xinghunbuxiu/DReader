package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.core.app.ActivatedController;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.ui.general.web.StorePageController;

class ik implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ ie f6614a;

    ik(ie ieVar) {
        this.f6614a = ieVar;
    }

    public void onClick(View view) {
        ActivatedController createWebPage = StorePageController.createWebPage(this.f6614a.getContext());
        createWebPage.loadUrl(C0641o.m2934i().m2937A());
        this.f6614a.f6599k.pushHalfPageSmoothly(createWebPage, null);
    }
}
