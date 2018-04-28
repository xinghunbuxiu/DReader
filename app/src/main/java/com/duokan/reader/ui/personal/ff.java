package com.duokan.reader.ui.personal;

class ff implements Runnable {
    /* renamed from: a */
    final /* synthetic */ fe f8538a;

    ff(fe feVar) {
        this.f8538a = feVar;
    }

    public void run() {
        if (this.f8538a.f8537a.f8530a.f8525c != null && this.f8538a.f8537a.f8530a.f8525c.isShowing()) {
            this.f8538a.f8537a.f8530a.f8525c.dismiss();
        }
    }
}
