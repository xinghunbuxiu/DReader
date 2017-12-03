package com.duokan.reader.ui.surfing;

import com.duokan.core.app.IFeature;
import com.duokan.core.ui.PullDownRefreshView.RefreshStyle;
import com.duokan.reader.common.webservices.duokan.p;
import com.duokan.reader.ui.general.web.StorePageController;

class SurfingController$14 extends StorePageController {
    final /* synthetic */ f this$0;

    SurfingController$14(f fVar, IFeature featrue) {
        this.this$0 = fVar;
        super(featrue);
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            this.this$0.p.setHasTitle(false);
            this.this$0.p.setRefreshStyle(RefreshStyle.STORE);
            this.this$0.p.loadUrl(p.i().e());
        }
    }
}
