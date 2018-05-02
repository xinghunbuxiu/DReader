package com.duokan.reader.ui.bookshelf;

import android.view.ViewGroup.LayoutParams;
import com.duokan.core.app.IFeature;
import com.duokan.core.sys.UThread;
import com.duokan.core.ui.dv;
import com.duokan.core.ui.fr;
import com.duokan.reader.ui.general.web.StorePageController;

class SignInStatusController$1 extends StorePageController {
    String mAdWallStatus = "";
    final /* synthetic */ ie this$0;

    SignInStatusController$1(ie ieVar, IFeature mFeature) {
        this.this$0 = ieVar;
        super(mFeature);
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        this.mPageLoadingView.setAlpha(0.0f);
    }

    public void onPageFinished(fr frVar, String str) {
        super.onPageFinished(frVar, str);
        this.mWebView.setPullDownRefreshEnabled(false);
        if (checkPageError()) {
            this.this$0.m9833a("empty");
        }
    }

    public void onPageHeightChange(int i) {
        super.onPageHeightChange(i);
        if (i <= 0) {
            this.this$0.f6604p.setVisibility(8);
        } else if (this.mAdWallStatus.equals("done") || this.mAdWallStatus.equals("empty")) {
            this.this$0.m9833a(this.mAdWallStatus);
        } else {
            this.this$0.f6604p.setVisibility(0);
            this.this$0.f6602n.setVisibility(8);
            LayoutParams layoutParams = this.this$0.f6604p.getLayoutParams();
            int b = dv.m1932b(getContext(), (float) i);
            if (layoutParams.height != b) {
                layoutParams.height = b;
                this.this$0.f6604p.setLayoutParams(layoutParams);
            }
        }
    }

    public void onAdWallStatusChange(String str) {
        super.onAdWallStatusChange(str);
        this.this$0.m9833a(str);
    }

    protected boolean broadcastEvent(String str, String str2) {
        if (str.equals("taskUpdated")) {
            UThread.runOnThread(new C1295if(this));
        }
        return super.broadcastEvent(str, str2);
    }
}
