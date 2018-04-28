package com.duokan.reader.domain.document.sbk;

class ab implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0983y f4773a;

    ab(C0983y c0983y) {
        this.f4773a = c0983y;
    }

    public void run() {
        if (!this.f4773a.mo1283F()) {
            this.f4773a.invalidateSelf();
        }
    }
}
