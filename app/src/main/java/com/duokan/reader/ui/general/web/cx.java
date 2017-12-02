package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;

class cx implements as {
    final /* synthetic */ String a;
    final /* synthetic */ cg b;

    cx(cg cgVar, String str) {
        this.b = cgVar;
        this.a = str;
    }

    public void a() {
        StorePageController.mBackParam = this.a;
        this.b.b.requestDetach();
    }
}
