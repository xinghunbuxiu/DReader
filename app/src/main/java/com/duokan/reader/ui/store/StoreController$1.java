package com.duokan.reader.ui.store;

import android.graphics.Bitmap;

import com.duokan.core.app.y;
import com.duokan.core.sys.af;
import com.duokan.core.ui.fr;
import com.duokan.reader.DkApp;
import com.duokan.reader.domain.statistics.a;
import com.duokan.reader.ui.general.web.StorePageController;

class StoreController$1 extends StorePageController {
    final /* synthetic */ bl this$0;

    StoreController$1(bl blVar, y yVar) {
        this.this$0 = blVar;
        super(yVar);
    }

    public void onPageStarted(fr frVar, String str, Bitmap bitmap) {
        super.onPageStarted(frVar, str, bitmap);
        if (this.this$0.d > 0 && this.this$0.e == 0) {
            this.this$0.e = System.currentTimeMillis();
            a.k().a(this.this$0.e, this.this$0.e - this.this$0.d);
        }
    }

    protected boolean onPullDownRefresh() {
        a.k().f(getCurrentUrl());
        return super.onPullDownRefresh();
    }

    protected void webPageLoading(boolean z) {
        super.webPageLoading(z);
        if (!isLoading() && this.this$0.e > 0 && this.this$0.f == 0) {
            this.this$0.f = System.currentTimeMillis();
            a.k().a(this.this$0.f, this.this$0.f - this.this$0.e, this.this$0.f - this.this$0.d);
            a.k().f();
            DkApp.get().setReadyToSee();
        }
    }

    public void chooseStatusBarStyle(af afVar) {
        if (isActive()) {
            afVar.a(Boolean.valueOf(this.this$0.i));
        }
    }
}
