package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.core.app.e;
import com.duokan.core.app.x;
import com.duokan.reader.common.webservices.duokan.p;
import com.duokan.reader.domain.statistics.a;
import com.duokan.reader.ui.general.web.StorePageController;

class dl implements OnClickListener {
    final /* synthetic */ dk a;

    dl(dk dkVar) {
        this.a = dkVar;
    }

    public void onClick(View view) {
        e storePageController = new StorePageController(x.a(this.a.c.getContext()));
        String d = p.i().d(this.a.b.e, null);
        if (this.a.c.e.U() != PageAnimationMode.VSCROLL) {
            a.k().a("ending_page_recommendation_v3", "click", this.a.c.getLabelPrefix() + this.a.b.d + "_banner", false);
        }
        storePageController.loadUrl(d);
        this.a.c.A.pushHalfPageSmoothly(storePageController, null);
    }
}
