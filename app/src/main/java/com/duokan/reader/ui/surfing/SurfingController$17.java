package com.duokan.reader.ui.surfing;

import com.duokan.core.app.IFeature;
import com.duokan.core.ui.PullDownRefreshView.RefreshStyle;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.ui.general.web.StorePageController;

class SurfingController$17 extends StorePageController {
    final /* synthetic */ C1522i this$0;

    SurfingController$17(C1522i c1522i, IFeature mFeature) {
        this.this$0 = c1522i;
        super(mFeature);
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            this.this$0.f11551s.setHasTitle(false);
            this.this$0.f11551s.setRefreshStyle(RefreshStyle.STORE);
            this.this$0.f11551s.loadUrl(C0641o.m2934i().m2970e());
        }
    }
}
