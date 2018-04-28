package com.duokan.reader.ui.general.web;

class iv implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f8017a;
    /* renamed from: b */
    final /* synthetic */ it f8018b;

    iv(it itVar, String str) {
        this.f8018b = itVar;
        this.f8017a = str;
    }

    public void run() {
        this.f8018b.f8014b.f7581b.web_notifyWeb(this.f8017a, 2, new Object[0]);
    }
}
