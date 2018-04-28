package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.core.app.AppContext;
import com.duokan.core.app.ActivatedController;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.domain.statistics.C1163a;
import com.duokan.reader.ui.general.web.StorePageController;

class dp implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C1451do f10036a;

    dp(C1451do c1451do) {
        this.f10036a = c1451do;
    }

    public void onClick(View view) {
        ActivatedController storePageController = new StorePageController(AppContext.getAppContext(this.f10036a.f10035c.getContext()));
        String d = C0641o.m2934i().m2969d(this.f10036a.f10034b.f2106e, null);
        if (this.f10036a.f10035c.f10005f.mo2004U() != PageAnimationMode.VSCROLL) {
            C1163a.m8627k().m8648a("ending_page_recommendation_v3", "click", this.f10036a.f10035c.getLabelPrefix() + this.f10036a.f10034b.f2105d + "_banner", false);
        }
        storePageController.loadUrl(d);
        this.f10036a.f10035c.f9993B.pushHalfPageSmoothly(storePageController, null);
    }
}
