package com.duokan.reader.ui.store;

class bu implements Runnable {
    /* renamed from: a */
    final /* synthetic */ br f11386a;

    bu(br brVar) {
        this.f11386a = brVar;
    }

    public void run() {
        if (this.f11386a.m15338c() < 0 && this.f11386a.f11381b.size() > 0) {
            this.f11386a.m15333a(0, false);
        }
    }
}
