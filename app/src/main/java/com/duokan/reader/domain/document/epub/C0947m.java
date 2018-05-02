package com.duokan.reader.domain.document.epub;

/* renamed from: com.duokan.reader.domain.document.epub.m */
class C0947m implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0945k f4715a;

    C0947m(C0945k c0945k) {
        this.f4715a = c0945k;
    }

    public void run() {
        if (this.f4715a.f4710a.f4698j.m6797d()) {
            this.f4715a.f4710a.f4700l.mo1285H();
            this.f4715a.f4710a.f4701m.mo1285H();
            return;
        }
        this.f4715a.f4710a.f4700l.setCallback(this.f4715a.f4710a.f4697i);
        this.f4715a.f4710a.f4701m.setCallback(this.f4715a.f4710a.f4697i);
        this.f4715a.f4710a.invalidateSelf();
    }
}
