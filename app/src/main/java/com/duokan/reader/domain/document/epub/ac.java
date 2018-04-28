package com.duokan.reader.domain.document.epub;

import android.text.TextUtils;
import com.duokan.kernel.epublib.DKETocPointWrapper;
import com.duokan.kernel.epublib.DkeBook;
import com.duokan.reader.domain.document.C0896a;
import com.duokan.reader.domain.document.C0897d;
import com.duokan.reader.domain.document.C0901g;

class ac extends C0935g {
    /* renamed from: b */
    static final /* synthetic */ boolean f4472b = (!C0952s.class.desiredAssertionStatus());
    /* renamed from: c */
    final /* synthetic */ C0952s f4473c;
    /* renamed from: d */
    private C0938f[] f4474d;

    private ac(C0952s c0952s) {
        this.f4473c = c0952s;
        this.f4474d = new C0938f[0];
    }

    /* renamed from: b */
    public /* synthetic */ C0901g mo1267b(C0896a c0896a) {
        return m6490c(c0896a);
    }

    /* renamed from: a */
    protected void m6485a(EpubContentEntryData[] epubContentEntryDataArr) {
        int i = 0;
        if (f4472b || epubContentEntryDataArr != null) {
            this.f4474d = new C0938f[epubContentEntryDataArr.length];
            int i2 = 0;
            while (i < epubContentEntryDataArr.length) {
                this.f4474d[i] = new C0938f(this.f4473c, i, i2, epubContentEntryDataArr[i]);
                i2 += this.f4474d[i].m5865a() + 1;
                i++;
            }
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    protected void m6483a(DkeBook dkeBook) {
        int i = 0;
        if (f4472b || dkeBook != null) {
            C0938f[] c0938fArr;
            long tocRoot = dkeBook.getTocRoot();
            if (tocRoot == 0) {
                c0938fArr = new C0938f[0];
            } else {
                DKETocPointWrapper dKETocPointWrapper = new DKETocPointWrapper(tocRoot);
                C0938f[] c0938fArr2 = new C0938f[((int) dKETocPointWrapper.GetChildCount())];
                int i2 = 0;
                while (i < c0938fArr2.length) {
                    c0938fArr2[i] = new C0938f(this.f4473c, i, i2, new DKETocPointWrapper(dKETocPointWrapper.GetChildByIndex(i)));
                    i2 += c0938fArr2[i].m5865a() + 1;
                    i++;
                }
                c0938fArr = c0938fArr2;
            }
            this.f4474d = c0938fArr;
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public String mo1264a() {
        return this.f4473c.f4729p;
    }

    /* renamed from: a */
    public void mo1265a(String str) {
        this.f4473c.f4729p = str;
    }

    /* renamed from: b */
    public C0901g[] mo1268b() {
        return this.f4474d;
    }

    /* renamed from: c */
    public int mo1269c() {
        return this.f4474d.length;
    }

    /* renamed from: c */
    public C0938f m6490c(C0896a c0896a) {
        if (!this.f4473c.mo1233d(c0896a) || !c0896a.mo1192e()) {
            return null;
        }
        C0897d c0897d = c0896a instanceof C0936c ? (C0936c) c0896a : c0896a instanceof ar ? (C0936c) ((ar) c0896a).mo1198g() : null;
        if (c0897d == null) {
            return null;
        }
        if (this.f4474d.length < 1) {
            return null;
        }
        C0938f c0938f = (C0938f) m6048a(this.f4474d, c0897d);
        if (c0938f == null) {
            return this.f4474d[0];
        }
        return c0938f;
    }

    /* renamed from: a */
    protected boolean mo1266a(C0901g c0901g, C0897d c0897d) {
        C0938f c0938f = (C0938f) c0901g;
        C0936c c0936c = (C0936c) c0897d;
        if (TextUtils.isEmpty(c0938f.m6834m())) {
            return c0901g.mo1203f().mo1190c(c0897d);
        }
        if (c0938f.mo1432l() < c0936c.m6780g()) {
            return false;
        }
        if (c0938f.mo1432l() > c0936c.m6780g()) {
            return true;
        }
        return c0938f.mo1203f().mo1190c(c0897d);
    }

    /* renamed from: a */
    public C0901g mo1367a(long j) {
        if (j < 0) {
            return null;
        }
        C0938f c0938f = (C0938f) m6481a(this.f4474d, j);
        return c0938f == null ? this.f4474d[0] : c0938f;
    }

    /* renamed from: a */
    protected C0901g m6481a(C0901g[] c0901gArr, long j) {
        if (!f4472b && c0901gArr == null) {
            throw new AssertionError();
        } else if (f4472b || c0901gArr.length > 0) {
            C0901g c0901g;
            C0901g c0901g2 = null;
            int i = 0;
            while (i < c0901gArr.length) {
                if (!c0901gArr[i].mo1208k()) {
                    c0901g = c0901g2;
                } else if (((C0938f) c0901gArr[i]).mo1432l() > j) {
                    break;
                } else {
                    c0901g = c0901gArr[i];
                }
                i++;
                c0901g2 = c0901g;
            }
            if (c0901g2 == null || c0901g2.mo1207j().length <= 0) {
                return c0901g2;
            }
            c0901g = m6481a(c0901g2.mo1207j(), j);
            if (c0901g != null) {
                return c0901g;
            }
            return c0901g2;
        } else {
            throw new AssertionError();
        }
    }
}
