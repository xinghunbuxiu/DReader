package com.duokan.reader.domain.document.epub;

import com.duokan.reader.domain.document.C0903n;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.at;

/* renamed from: com.duokan.reader.domain.document.epub.l */
class C0946l implements at {
    /* renamed from: a */
    final /* synthetic */ C0945k f4711a;
    /* renamed from: b */
    private boolean f4712b = false;
    /* renamed from: c */
    private boolean f4713c = false;
    /* renamed from: d */
    private boolean f4714d = false;

    C0946l(C0945k c0945k) {
        this.f4711a = c0945k;
    }

    /* renamed from: a */
    public void mo1221a(C0903n c0903n, as asVar) {
        if (asVar == this.f4711a.f4710a.f4700l) {
            this.f4712b = true;
        } else if (asVar == this.f4711a.f4710a.f4701m) {
            this.f4713c = true;
        }
        if (this.f4712b && this.f4713c && this.f4711a.f4710a.f4696h != null) {
            this.f4711a.f4710a.f4696h.mo1221a(null, this.f4711a.f4710a);
        }
    }

    /* renamed from: b */
    public void mo1225b(C0903n c0903n, as asVar) {
        if (!this.f4714d && this.f4711a.f4710a.f4696h != null) {
            this.f4714d = true;
            this.f4711a.f4710a.f4696h.mo1225b(null, this.f4711a.f4710a);
        }
    }
}
