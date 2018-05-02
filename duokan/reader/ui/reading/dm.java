package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.MyContextWrapper;
import com.duokan.reader.common.webservices.duokan.af;
import com.duokan.reader.common.webservices.duokan.p;
import com.duokan.reader.ui.general.web.StorePageController;

class dm implements OnClickListener {
    final /* synthetic */ af a;
    final /* synthetic */ de b;

    dm(de deVar, af afVar) {
        this.b = deVar;
        this.a = afVar;
    }

    public void onClick(View view) {
        ActivatedController storePageController = new StorePageController(MyContextWrapper.getFeature(this.b.getContext()));
        String d = p.i().d(this.a.e, null);
        if (this.b.e.U() != PageAnimationMode.VSCROLL) {
            a.k().a("ending_page_recommendation_v3", "click", this.b.getLabelPrefix() + this.a.d + "_topic_view_more", false);
        }
        storePageController.loadUrl(d);
        this.b.A.pushHalfPageSmoothly(storePageController, null);
    }
}
