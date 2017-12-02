package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.core.app.e;
import com.duokan.core.app.x;
import com.duokan.reader.common.webservices.duokan.af;
import com.duokan.reader.common.webservices.duokan.p;
import com.duokan.reader.domain.statistics.a;
import com.duokan.reader.ui.general.web.StorePageController;

class dm implements OnClickListener {
    final /* synthetic */ af a;
    final /* synthetic */ de b;

    dm(de deVar, af afVar) {
        this.b = deVar;
        this.a = afVar;
    }

    public void onClick(View view) {
        e storePageController = new StorePageController(x.a(this.b.getContext()));
        String d = p.i().d(this.a.e, null);
        if (this.b.e.U() != PageAnimationMode.VSCROLL) {
            a.k().a("ending_page_recommendation_v3", "click", this.b.getLabelPrefix() + this.a.d + "_topic_view_more", false);
        }
        storePageController.loadUrl(d);
        this.b.A.pushHalfPageSmoothly(storePageController, null);
    }
}
