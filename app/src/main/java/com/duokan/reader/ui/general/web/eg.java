package com.duokan.reader.ui.general.web;

class eg implements a {
    final /* synthetic */ String a;
    final /* synthetic */ ef b;

    eg(ef efVar, String str) {
        this.b = efVar;
        this.a = str;
    }

    public void a(Object... objArr) {
        this.b.b.pageController.web_notifyWeb(this.a, 0, "operation", Integer.valueOf(1), "text", (String) objArr[0]);
    }

    public void b(Object... objArr) {
        this.b.b.pageController.web_notifyWeb(this.a, 0, "operation", Integer.valueOf(0), "text", "");
    }
}
