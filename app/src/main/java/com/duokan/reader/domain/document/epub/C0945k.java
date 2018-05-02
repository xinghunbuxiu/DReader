package com.duokan.reader.domain.document.epub;

import com.duokan.reader.domain.document.at;

/* renamed from: com.duokan.reader.domain.document.epub.k */
class C0945k implements C0944q {
    /* renamed from: a */
    final /* synthetic */ C0942i f4710a;

    C0945k(C0942i c0942i) {
        this.f4710a = c0942i;
    }

    /* renamed from: a */
    public void mo1437a(C0951r c0951r) {
        at c0946l = new C0946l(this);
        au auVar = new au(this.f4710a.f4694f);
        auVar.m = false;
        auVar.f4491r = false;
        auVar.n = false;
        au auVar2 = new au(this.f4710a.f4694f);
        auVar2.l = false;
        auVar2.n = false;
        if (this.f4710a.f4692d.mo1369e().mo1365h().getWritingMode() == 1) {
            this.f4710a.f4701m = this.f4710a.f4702n = new az(this.f4710a.f4692d, this.f4710a.f4693e.m6848l(), auVar, this.f4710a.f4695g, c0946l);
            this.f4710a.f4700l = this.f4710a.f4703o = new az(this.f4710a.f4692d, this.f4710a.f4693e.m6847k(), auVar2, this.f4710a.f4695g, c0946l);
        } else {
            this.f4710a.f4701m = this.f4710a.f4703o = new az(this.f4710a.f4692d, this.f4710a.f4693e.m6848l(), auVar2, this.f4710a.f4695g, c0946l);
            this.f4710a.f4700l = this.f4710a.f4702n = new az(this.f4710a.f4692d, this.f4710a.f4693e.m6847k(), auVar, this.f4710a.f4695g, c0946l);
        }
        this.f4710a.f4706r = true;
        synchronized (this.f4710a) {
            if (this.f4710a.f4708t != null) {
                this.f4710a.f4708t.countDown();
            }
        }
        this.f4710a.m6122a(new C0947m(this));
    }

    /* renamed from: b */
    public void mo1438b(C0951r c0951r) {
    }

    /* renamed from: c */
    public void mo1439c(C0951r c0951r) {
    }
}
