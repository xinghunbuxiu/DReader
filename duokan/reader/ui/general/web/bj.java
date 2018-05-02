package com.duokan.reader.ui.general.web;

class bj implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ StorePageController b;

    bj(StorePageController storePageController, String str) {
        this.b = storePageController;
        this.a = str;
    }

    public void run() {
        this.b.mWebView.c(String.format("javascript:(function() { try { %s } catch(getScaledPagingTouchSlop) { fictionApi.log(getScaledPagingTouchSlop.message); } }())", new Object[]{this.a}));
    }
}
