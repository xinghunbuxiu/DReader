package com.duokan.reader.ui.general.web;

import com.duokan.reader.ui.general.fa;

class eh implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ a d;
    final /* synthetic */ ef e;

    eh(ef efVar, String str, String str2, String str3, a aVar) {
        this.e = efVar;
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = aVar;
    }

    public void run() {
        fa faVar = new fa(this.e.b.pageController.getContext());
        faVar.a(this.e.b.pageController.mPageTitle);
        faVar.b(this.a);
        faVar.d(this.b);
        faVar.c(this.c);
        this.e.b.pageController.mCallBackSucceed = false;
        faVar.a(new ei(this));
        faVar.a(new ej(this));
        faVar.setOnDismissListener(new ek(this));
        faVar.show();
    }
}
