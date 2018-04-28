package com.duokan.reader.domain.document.sbk;

class ac implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0983y f4774a;

    ac(C0983y c0983y) {
        this.f4774a = c0983y;
    }

    public void run() {
        this.f4774a.f4861k = true;
        if (this.f4774a.f4859i.m7116c()) {
            this.f4774a.m7295e();
            this.f4774a.f4860j = false;
        }
        if (this.f4774a.f4858h != null) {
            this.f4774a.f4858h.mo1221a(null, this.f4774a);
        }
        this.f4774a.invalidateSelf();
    }
}
