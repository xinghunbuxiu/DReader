package com.duokan.reader.domain.document.epub;

import com.duokan.core.diagnostic.WebLog;
import com.duokan.kernel.epublib.DkeBook;
import com.duokan.reader.domain.document.C0896a;
import com.duokan.reader.domain.document.C0908f;
import com.duokan.reader.domain.document.C0932e;
import com.duokan.reader.domain.document.av;

class aa extends C0908f {
    /* renamed from: a */
    final /* synthetic */ C0952s f4458a;
    /* renamed from: b */
    private final DkeBook f4459b;
    /* renamed from: c */
    private C0937d[] f4460c = null;

    /* renamed from: a */
    public /* synthetic */ C0932e mo1254a(int i) {
        return m6461b(i);
    }

    public aa(C0952s c0952s, DkeBook dkeBook) {
        this.f4458a = c0952s;
        this.f4459b = dkeBook;
    }

    /* renamed from: a */
    public int mo1252a() {
        WebLog.init().w(this.f4458a.m5889A());
        if (this.f4458a.m5945p()) {
            return m6457b().length;
        }
        return 0;
    }

    /* renamed from: b */
    public C0937d m6461b(int i) {
        WebLog.init().w(this.f4458a.m5889A());
        if (!this.f4458a.m5945p() || i < 0 || i >= mo1252a()) {
            return null;
        }
        if (m6457b()[i] == null) {
            C0896a a = this.f4458a.m7041a(this.f4459b.getChapterIndexOfFrame((long) i), 0);
            if (!this.f4458a.mo1233d(a) || !a.mo1192e()) {
                return null;
            }
            m6457b()[i] = new C0937d(this.f4459b, i);
        }
        return m6457b()[i];
    }

    /* renamed from: a */
    public int mo1253a(av avVar) {
        WebLog.init().w(this.f4458a.m5889A());
        if (!this.f4458a.m5945p()) {
            return -1;
        }
        C0934e p = this.f4458a.f4724k;
        C0936c c0936c = (C0936c) avVar;
        for (int i = 0; i < mo1252a(); i++) {
            if (p.mo1365h().getChapterIndexOfFrame((long) i) >= c0936c.m6780g()) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: b */
    private C0937d[] m6457b() {
        WebLog.init().w(this.f4458a.m5889A());
        if (!this.f4458a.m5945p()) {
            return new C0937d[0];
        }
        if (this.f4460c == null) {
            this.f4460c = new C0937d[((int) this.f4459b.getComicsFrameCount())];
        }
        return this.f4460c;
    }
}
