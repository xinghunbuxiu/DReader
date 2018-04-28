package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.core.app.ActivatedController;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.ui.general.web.StorePageController;

class il implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ ie f6615a;

    il(ie ieVar) {
        this.f6615a = ieVar;
    }

    public void onClick(View view) {
        ActivatedController createWebPage = StorePageController.createWebPage(this.f6615a.getContext());
        createWebPage.loadUrl(C0641o.m2934i().m2939C());
        this.f6615a.f6599k.pushHalfPageSmoothly(createWebPage, null);
    }
}
