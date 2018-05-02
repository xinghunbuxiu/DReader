package com.duokan.reader.ui.general.web;

/* renamed from: com.duokan.reader.ui.general.web.c */
class C1354c implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f7657a;
    /* renamed from: b */
    final /* synthetic */ C1353b f7658b;

    C1354c(C1353b c1353b, String str) {
        this.f7658b = c1353b;
        this.f7657a = str;
    }

    public void run() {
        this.f7658b.f7615a.setPageTitle(this.f7657a);
    }
}
