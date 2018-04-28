package com.duokan.reader.ui.general.web;

class bg implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f7625a;
    /* renamed from: b */
    final /* synthetic */ StorePageController f7626b;

    bg(StorePageController storePageController, String str) {
        this.f7626b = storePageController;
        this.f7625a = str;
    }

    public void run() {
        this.f7626b.mWebView.mo1815a(String.format("javascript:(function() { try { %s } catch(e) { fictionApi.log(e.message); } }())", new Object[]{this.f7625a}));
    }
}
