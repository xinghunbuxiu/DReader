package com.duokan.reader.domain.document.p045a;

import com.duokan.kernel.pdflib.DkpBook;
import com.duokan.kernel.pdflib.DkpOutlineItem;
import com.duokan.reader.domain.document.C0896a;
import com.duokan.reader.domain.document.C0897d;
import com.duokan.reader.domain.document.C0901g;
import com.duokan.reader.domain.document.C0911h;

/* renamed from: com.duokan.reader.domain.document.a.j */
class C0912j extends C0911h {
    /* renamed from: b */
    static final /* synthetic */ boolean f4310b = (!C0904d.class.desiredAssertionStatus());
    /* renamed from: c */
    final /* synthetic */ C0904d f4311c;
    /* renamed from: d */
    private String f4312d;
    /* renamed from: e */
    private C0902c[] f4313e;

    private C0912j(C0904d c0904d) {
        this.f4311c = c0904d;
        this.f4312d = "";
        this.f4313e = new C0902c[0];
    }

    /* renamed from: b */
    public /* synthetic */ C0901g mo1267b(C0896a c0896a) {
        return m6065c(c0896a);
    }

    /* renamed from: a */
    protected void m6059a(DkpBook dkpBook) {
        if (f4310b || dkpBook != null) {
            DkpOutlineItem[] childOutlineItems = dkpBook.getChildOutlineItems(0);
            C0902c[] c0902cArr = new C0902c[childOutlineItems.length];
            int i = 0;
            for (int i2 = 0; i2 < c0902cArr.length; i2++) {
                c0902cArr[i2] = new C0902c(this.f4311c, 0, i2, i, dkpBook, childOutlineItems[i2]);
                i += c0902cArr[i2].m5865a() + 1;
            }
            this.f4313e = c0902cArr;
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public String mo1264a() {
        return this.f4312d;
    }

    /* renamed from: a */
    public void mo1265a(String str) {
        this.f4312d = str;
    }

    /* renamed from: b */
    public C0901g[] mo1268b() {
        return this.f4313e;
    }

    /* renamed from: c */
    public int mo1269c() {
        return this.f4313e.length;
    }

    /* renamed from: c */
    public C0902c m6065c(C0896a c0896a) {
        if (!this.f4311c.mo1233d(c0896a) || !c0896a.mo1192e()) {
            return null;
        }
        C0897d j = c0896a instanceof C0898a ? (C0898a) c0896a : c0896a instanceof C0921s ? ((C0921s) c0896a).mo1278j() : null;
        if (j == null || this.f4313e.length < 1) {
            return null;
        }
        C0902c c0902c = (C0902c) m6048a(this.f4313e, j);
        if (c0902c == null) {
            return this.f4313e[0];
        }
        return c0902c;
    }

    /* renamed from: a */
    protected boolean mo1266a(C0901g c0901g, C0897d c0897d) {
        return c0901g.mo1203f().mo1190c(c0897d);
    }
}
