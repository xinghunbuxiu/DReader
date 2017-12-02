package com.duokan.reader.ui.account;

import android.webkit.JavascriptInterface;

import com.duokan.reader.ui.account.MiAccountAssist.MergeAccountController;
import com.duokan.reader.ui.general.web.cg;

class i extends cg {
    final /* synthetic */ MergeAccountController a;

    private i(MergeAccountController mergeAccountController) {
        this.a = mergeAccountController;
        super(mergeAccountController);
    }

    @JavascriptInterface
    public void mergeUserSuccess(boolean z) {
        a(new j(this));
    }

    @JavascriptInterface
    public void switchAccount() {
        a(new k(this));
    }
}
