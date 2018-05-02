package com.duokan.reader.ui.account;

import android.webkit.JavascriptInterface;

import com.duokan.reader.ui.account.MiAccountAssist.MergeAccountController;
import com.duokan.reader.ui.general.web.PageController;

class i extends PageController {
    final MergeAccountController ccountController;

    private i(MergeAccountController mergeAccountController) {
        super(mergeAccountController);
        this.ccountController = mergeAccountController;
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
