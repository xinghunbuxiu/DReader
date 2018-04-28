package com.duokan.reader.ui.general.web;

class bi implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f7628a;
    /* renamed from: b */
    final /* synthetic */ StorePageController f7629b;

    bi(StorePageController storePageController, String str) {
        this.f7629b = storePageController;
        this.f7628a = str;
    }

    public void run() {
        this.f7629b.mWebView.m10989c(String.format("javascript:(function() { try { %s } catch(e) { fictionApi.log(e.message); } }())", new Object[]{this.f7628a}));
    }
}
