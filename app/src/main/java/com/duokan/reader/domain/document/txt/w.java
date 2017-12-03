package com.duokan.reader.domain.document.txt;

import com.duokan.kernel.txtlib.DktBook;
import com.duokan.reader.domain.document.Document_a;
import com.duokan.reader.domain.document.d;
import com.duokan.reader.domain.document.g;
import com.duokan.reader.domain.document.h;

class w extends h {
    final /* synthetic */ p b;
    private String c;
    private d[] d;

    private w(p pVar) {
        this.b = pVar;
        this.c = "";
        this.d = null;
    }

    public String a() {
        return this.c;
    }

    public void a(String str) {
        this.c = str;
    }

    public g[] b() {
        return this.d;
    }

    public int c() {
        return this.d.length;
    }

    public g b(Document_a aVar) {
        if (!this.b.d(aVar) || !aVar.e()) {
            return null;
        }
        aVar = aVar instanceof b ? (b) aVar : aVar instanceof af ? ((af) aVar).n() : null;
        if (aVar == null || this.d.length < 1) {
            return null;
        }
        d dVar = (d) a(this.d, (d) aVar);
        if (dVar == null) {
            return this.d[0];
        }
        return dVar;
    }

    protected boolean a(g gVar, d dVar) {
        return gVar.f().c(dVar);
    }

    private void a(DktBook dktBook) {
        int i = 0;
        if (this.d == null) {
            TxtContentEntryData[] txtContentEntryDataArr;
            TxtContentEntryData[] a = this.b.j.a(this.b);
            if (a != null) {
                d[] dVarArr = new d[a.length];
                int i2 = 0;
                for (int i3 = 0; i3 < dVarArr.length; i3++) {
                    dVarArr[i3] = new d(this.b, i3, i2, a[i3].mTitle, p.b((long) a[i3].mContentOffset));
                    i2 += dVarArr[i3].a() + 1;
                }
                this.d = dVarArr;
                txtContentEntryDataArr = a;
            } else {
                this.d = b(dktBook);
                TxtContentEntryData[] txtContentEntryDataArr2 = new TxtContentEntryData[this.d.length];
                for (int i4 = 0; i4 < txtContentEntryDataArr2.length; i4++) {
                    txtContentEntryDataArr2[i4] = new TxtContentEntryData();
                    txtContentEntryDataArr2[i4].mTitle = this.d[i4].e();
                    txtContentEntryDataArr2[i4].mContentOffset = (int) ((b) this.d[i4].f()).g();
                }
                this.b.j.a(this.b, txtContentEntryDataArr2);
                txtContentEntryDataArr = txtContentEntryDataArr2;
            }
            long[] jArr = new long[txtContentEntryDataArr.length];
            while (i < jArr.length) {
                jArr[i] = (long) txtContentEntryDataArr[i].mContentOffset;
                i++;
            }
            dktBook.setToc(jArr);
        }
    }

    private d[] b(DktBook dktBook) {
        int i = 0;
        long[] toc = dktBook.getToc();
        d[] dVarArr = new d[toc.length];
        int i2 = 0;
        while (i < dVarArr.length) {
            long j = toc[i];
            dVarArr[i] = new d(this.b, i, i2, dktBook.getChapterTitle(j), p.b(j));
            i2 += dVarArr[i].a() + 1;
            i++;
        }
        return dVarArr;
    }
}
