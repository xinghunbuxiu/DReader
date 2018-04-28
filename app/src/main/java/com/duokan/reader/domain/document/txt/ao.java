package com.duokan.reader.domain.document.txt;

class ao implements Runnable {
    /* renamed from: a */
    final /* synthetic */ aj f4909a;

    ao(aj ajVar) {
        this.f4909a = ajVar;
    }

    public void run() {
        this.f4909a.f4896k = true;
        if (this.f4909a.f4894i.m7500d()) {
            this.f4909a.m7412d();
            this.f4909a.f4895j = false;
        }
        if (this.f4909a.f4893h != null) {
            this.f4909a.f4893h.mo1221a(null, this.f4909a);
        }
        this.f4909a.invalidateSelf();
    }
}
