package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.core.app.AppContext;
import com.duokan.core.app.ActivatedController;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.common.webservices.duokan.af;
import com.duokan.reader.domain.statistics.C1163a;
import com.duokan.reader.ui.general.web.StorePageController;

class dq implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ af f10037a;
    /* renamed from: b */
    final /* synthetic */ dg f10038b;

    dq(dg dgVar, af afVar) {
        this.f10038b = dgVar;
        this.f10037a = afVar;
    }

    public void onClick(View view) {
        ActivatedController storePageController = new StorePageController(AppContext.getAppContext(this.f10038b.getContext()));
        String d = C0641o.m2934i().m2969d(this.f10037a.f2106e, null);
        if (this.f10038b.f10005f.mo2004U() != PageAnimationMode.VSCROLL) {
            C1163a.m8627k().m8648a("ending_page_recommendation_v3", "click", this.f10038b.getLabelPrefix() + this.f10037a.f2105d + "_topic_view_more", false);
        }
        storePageController.loadUrl(d);
        this.f10038b.f9993B.pushHalfPageSmoothly(storePageController, null);
    }
}
