package com.duokan.reader.ui.store;

import android.graphics.Bitmap;
import com.duokan.core.app.IFeature;
import com.duokan.core.sys.af;
import com.duokan.core.ui.fr;
import com.duokan.reader.DkApp;
import com.duokan.reader.domain.statistics.C1163a;
import com.duokan.reader.ui.general.web.StorePageController;

class StoreController$1 extends StorePageController {
    final /* synthetic */ bl this$0;

    StoreController$1(bl blVar, IFeature mFeature) {
        this.this$0 = blVar;
        super(mFeature);
    }

    public void onPageStarted(fr frVar, String str, Bitmap bitmap) {
        super.onPageStarted(frVar, str, bitmap);
        if (this.this$0.f11346d > 0 && this.this$0.f11347e == 0) {
            this.this$0.f11347e = System.currentTimeMillis();
            C1163a.m8627k().m8631a(this.this$0.f11347e, this.this$0.f11347e - this.this$0.f11346d);
        }
    }

    protected boolean onPullDownRefresh() {
        C1163a.m8627k().m8659e(getCurrentUrl());
        return super.onPullDownRefresh();
    }

    protected void webPageLoading(boolean z) {
        super.webPageLoading(z);
        if (!isLoading() && this.this$0.f11347e > 0 && this.this$0.f11348f == 0) {
            this.this$0.f11348f = System.currentTimeMillis();
            C1163a.m8627k().m8632a(this.this$0.f11348f, this.this$0.f11348f - this.this$0.f11347e, this.this$0.f11348f - this.this$0.f11346d);
            C1163a.m8627k().m8660f();
            DkApp.get().setReadyToSee();
        }
    }

    public void chooseStatusBarStyle(af<Boolean> afVar) {
        if (isActive()) {
            afVar.mo975a(Boolean.valueOf(this.this$0.f11351i));
        }
    }

    public void onSearchBarPosChange(int i) {
        super.onSearchBarPosChange(i);
        this.this$0.mo2544g(i);
    }

    public void onSearchWordChange(String str) {
        super.onSearchWordChange(str);
        this.this$0.m15283a(str);
    }
}
