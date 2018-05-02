package com.duokan.reader.domain.document.sbk;

import com.duokan.reader.domain.document.C0896a;
import com.duokan.reader.domain.document.C0897d;
import com.duokan.reader.domain.document.C0901g;

/* renamed from: com.duokan.reader.domain.document.sbk.l */
class C0975l extends C0968e {
    /* renamed from: b */
    final /* synthetic */ C0969f f4834b;
    /* renamed from: c */
    private String f4835c;
    /* renamed from: d */
    private C0967d[] f4836d;

    private C0975l(C0969f c0969f) {
        this.f4834b = c0969f;
        this.f4835c = "";
        this.f4836d = new C0967d[0];
    }

    /* renamed from: b */
    public /* synthetic */ C0901g mo1267b(C0896a c0896a) {
        return m7259c(c0896a);
    }

    /* renamed from: a */
    protected void m7253a(C0823q c0823q) {
        C0967d[] c0967dArr = new C0967d[c0823q.mo1127a()];
        for (int i = 0; i < c0967dArr.length; i++) {
            c0967dArr[i] = new C0967d(this.f4834b, 0, i, i, c0823q.mo1129a(i));
        }
        this.f4836d = c0967dArr;
    }

    /* renamed from: a */
    public String mo1264a() {
        return this.f4835c;
    }

    /* renamed from: a */
    public void mo1265a(String str) {
        this.f4835c = str;
    }

    /* renamed from: b */
    public C0901g[] mo1268b() {
        return this.f4836d;
    }

    /* renamed from: c */
    public int mo1269c() {
        return this.f4836d.length;
    }

    /* renamed from: a */
    public C0901g mo1452a(long j) {
        if (j < 0 || j >= ((long) this.f4836d.length)) {
            return null;
        }
        return this.f4836d[(int) j];
    }

    /* renamed from: c */
    public C0967d m7259c(C0896a c0896a) {
        if (!this.f4834b.mo1233d(c0896a) || !c0896a.mo1192e()) {
            return null;
        }
        C0897d j = c0896a instanceof C0965b ? (C0965b) c0896a : c0896a instanceof C0979t ? ((C0979t) c0896a).mo1454j() : null;
        if (j == null || this.f4836d.length < 1) {
            return null;
        }
        C0967d c0967d = (C0967d) m6048a(this.f4836d, j);
        if (c0967d == null) {
            return this.f4836d[0];
        }
        return c0967d;
    }

    /* renamed from: a */
    protected boolean mo1266a(C0901g c0901g, C0897d c0897d) {
        return c0901g.mo1203f().mo1190c(c0897d);
    }
}
