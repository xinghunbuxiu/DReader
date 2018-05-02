package com.duokan.reader.domain.document.txt;

import com.duokan.kernel.txtlib.DktBook;
import com.duokan.reader.domain.document.C0896a;
import com.duokan.reader.domain.document.C0897d;
import com.duokan.reader.domain.document.C0901g;
import com.duokan.reader.domain.document.C0911h;

/* renamed from: com.duokan.reader.domain.document.txt.w */
class C1007w extends C0911h {
    /* renamed from: b */
    final /* synthetic */ C1000p f5011b;
    /* renamed from: c */
    private String f5012c;
    /* renamed from: d */
    private C0988d[] f5013d;

    private C1007w(C1000p c1000p) {
        this.f5011b = c1000p;
        this.f5012c = "";
        this.f5013d = null;
    }

    /* renamed from: a */
    public String mo1264a() {
        return this.f5012c;
    }

    /* renamed from: a */
    public void mo1265a(String str) {
        this.f5012c = str;
    }

    /* renamed from: b */
    public C0901g[] mo1268b() {
        return this.f5013d;
    }

    /* renamed from: c */
    public int mo1269c() {
        return this.f5013d.length;
    }

    /* renamed from: b */
    public C0901g mo1267b(C0896a c0896a) {
        if (!this.f5011b.mo1233d(c0896a) || !c0896a.mo1192e()) {
            return null;
        }
        C0897d n = c0896a instanceof C0986b ? (C0986b) c0896a : c0896a instanceof af ? ((af) c0896a).mo1460n() : null;
        if (n == null || this.f5013d.length < 1) {
            return null;
        }
        C0988d c0988d = (C0988d) m6048a(this.f5013d, n);
        if (c0988d == null) {
            return this.f5013d[0];
        }
        return c0988d;
    }

    /* renamed from: a */
    protected boolean mo1266a(C0901g c0901g, C0897d c0897d) {
        return c0901g.mo1203f().mo1190c(c0897d);
    }

    /* renamed from: a */
    private void m7765a(DktBook dktBook) {
        int i = 0;
        if (this.f5013d == null) {
            TxtContentEntryData[] txtContentEntryDataArr;
            TxtContentEntryData[] a = this.f5011b.f4979j.mo1135a(this.f5011b);
            if (a != null) {
                C0988d[] c0988dArr = new C0988d[a.length];
                int i2 = 0;
                for (int i3 = 0; i3 < c0988dArr.length; i3++) {
                    c0988dArr[i3] = new C0988d(this.f5011b, i3, i2, a[i3].mTitle, C1000p.m7689b((long) a[i3].mContentOffset));
                    i2 += c0988dArr[i3].m5865a() + 1;
                }
                this.f5013d = c0988dArr;
                txtContentEntryDataArr = a;
            } else {
                this.f5013d = m7767b(dktBook);
                TxtContentEntryData[] txtContentEntryDataArr2 = new TxtContentEntryData[this.f5013d.length];
                for (int i4 = 0; i4 < txtContentEntryDataArr2.length; i4++) {
                    txtContentEntryDataArr2[i4] = new TxtContentEntryData();
                    txtContentEntryDataArr2[i4].mTitle = this.f5013d[i4].mo1202e();
                    txtContentEntryDataArr2[i4].mContentOffset = (int) ((C0986b) this.f5013d[i4].mo1203f()).m7539g();
                }
                this.f5011b.f4979j.mo1134a(this.f5011b, txtContentEntryDataArr2);
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

    /* renamed from: b */
    private C0988d[] m7767b(DktBook dktBook) {
        int i = 0;
        long[] toc = dktBook.getToc();
        C0988d[] c0988dArr = new C0988d[toc.length];
        int i2 = 0;
        while (i < c0988dArr.length) {
            long j = toc[i];
            c0988dArr[i] = new C0988d(this.f5011b, i, i2, dktBook.getChapterTitle(j), C1000p.m7689b(j));
            i2 += c0988dArr[i].m5865a() + 1;
            i++;
        }
        return c0988dArr;
    }
}
