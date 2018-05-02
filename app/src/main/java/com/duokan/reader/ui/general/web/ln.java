package com.duokan.reader.ui.general.web;

class ln implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ll f8159a;

    ln(ll llVar) {
        this.f8159a = llVar;
    }

    public void run() {
        this.f8159a.f8156c.cancel();
    }
}
