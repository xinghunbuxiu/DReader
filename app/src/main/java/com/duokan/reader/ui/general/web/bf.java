package com.duokan.reader.ui.general.web;

class bf implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f7623a;
    /* renamed from: b */
    final /* synthetic */ StorePageController f7624b;

    bf(StorePageController storePageController, String str) {
        this.f7624b = storePageController;
        this.f7623a = str;
    }

    public void run() {
        this.f7624b.mWebView.loadUrl(String.format("javascript:(function() { try { %s } catch(e) { fictionApi.log(e.message); } }())", new Object[]{this.f7623a}));
    }
}
