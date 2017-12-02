package com.duokan.reader.domain.document.epub;

import android.text.TextUtils;

import com.duokan.kernel.epublib.DKETocPointWrapper;
import com.duokan.kernel.epublib.DkeBook;
import com.duokan.reader.domain.document.a;
import com.duokan.reader.domain.document.d;
import com.duokan.reader.domain.document.g;

class ac extends g {
    static final /* synthetic */ boolean b = (!s.class.desiredAssertionStatus());
    final /* synthetic */ s c;
    private f[] d;

    private ac(s sVar) {
        this.c = sVar;
        this.d = new f[0];
    }

    public /* synthetic */ g b(a aVar) {
        return c(aVar);
    }

    protected void a(EpubContentEntryData[] epubContentEntryDataArr) {
        int i = 0;
        if (b || epubContentEntryDataArr != null) {
            this.d = new f[epubContentEntryDataArr.length];
            int i2 = 0;
            while (i < epubContentEntryDataArr.length) {
                this.d[i] = new f(this.c, i, i2, epubContentEntryDataArr[i]);
                i2 += this.d[i].a() + 1;
                i++;
            }
            return;
        }
        throw new AssertionError();
    }

    protected void a(DkeBook dkeBook) {
        int i = 0;
        if (b || dkeBook != null) {
            f[] fVarArr;
            long tocRoot = dkeBook.getTocRoot();
            if (tocRoot == 0) {
                fVarArr = new f[0];
            } else {
                DKETocPointWrapper dKETocPointWrapper = new DKETocPointWrapper(tocRoot);
                f[] fVarArr2 = new f[((int) dKETocPointWrapper.GetChildCount())];
                int i2 = 0;
                while (i < fVarArr2.length) {
                    fVarArr2[i] = new f(this.c, i, i2, new DKETocPointWrapper(dKETocPointWrapper.GetChildByIndex(i)));
                    i2 += fVarArr2[i].a() + 1;
                    i++;
                }
                fVarArr = fVarArr2;
            }
            this.d = fVarArr;
            return;
        }
        throw new AssertionError();
    }

    public String a() {
        return this.c.p;
    }

    public void a(String str) {
        this.c.p = str;
    }

    public g[] b() {
        return this.d;
    }

    public int c() {
        return this.d.length;
    }

    public f c(a aVar) {
        if (!this.c.d(aVar) || !aVar.e()) {
            return null;
        }
        aVar = aVar instanceof c ? (c) aVar : aVar instanceof ar ? (c) ((ar) aVar).g() : null;
        if (aVar == null) {
            return null;
        }
        if (this.d.length < 1) {
            return null;
        }
        f fVar = (f) a(this.d, (d) aVar);
        if (fVar == null) {
            return this.d[0];
        }
        return fVar;
    }

    protected boolean a(g gVar, d dVar) {
        f fVar = (f) gVar;
        c cVar = (c) dVar;
        if (TextUtils.isEmpty(fVar.m())) {
            return gVar.f().c(dVar);
        }
        if (fVar.l() < cVar.g()) {
            return false;
        }
        if (fVar.l() > cVar.g()) {
            return true;
        }
        return fVar.f().c(dVar);
    }

    public g a(long j) {
        if (j < 0) {
            return null;
        }
        f fVar = (f) a(this.d, j);
        return fVar == null ? this.d[0] : fVar;
    }

    protected g a(g[] gVarArr, long j) {
        if (!b && gVarArr == null) {
            throw new AssertionError();
        } else if (b || gVarArr.length > 0) {
            g gVar;
            g gVar2 = null;
            int i = 0;
            while (i < gVarArr.length) {
                if (!gVarArr[i].k()) {
                    gVar = gVar2;
                } else if (((f) gVarArr[i]).l() > j) {
                    break;
                } else {
                    gVar = gVarArr[i];
                }
                i++;
                gVar2 = gVar;
            }
            if (gVar2 == null || gVar2.j().length <= 0) {
                return gVar2;
            }
            gVar = a(gVar2.j(), j);
            if (gVar != null) {
                return gVar;
            }
            return gVar2;
        } else {
            throw new AssertionError();
        }
    }
}
