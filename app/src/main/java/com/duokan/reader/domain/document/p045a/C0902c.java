package com.duokan.reader.domain.document.p045a;

import com.duokan.kernel.DkFlowPosition;
import com.duokan.kernel.pdflib.DkpBook;
import com.duokan.kernel.pdflib.DkpOutlineItem;
import com.duokan.reader.domain.document.C0901g;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.av;

/* renamed from: com.duokan.reader.domain.document.a.c */
public class C0902c extends C0901g {
    /* renamed from: a */
    static final /* synthetic */ boolean f4262a = (!C0902c.class.desiredAssertionStatus());
    /* renamed from: b */
    private final C0904d f4263b;
    /* renamed from: c */
    private final int f4264c;
    /* renamed from: d */
    private final int f4265d;
    /* renamed from: e */
    private final C0902c[] f4266e;
    /* renamed from: f */
    private final int f4267f;
    /* renamed from: g */
    private final String f4268g;
    /* renamed from: h */
    private final av f4269h;
    /* renamed from: i */
    private ak f4270i = null;
    /* renamed from: j */
    private final boolean f4271j;

    protected C0902c(C0904d c0904d, int i, int i2, int i3, DkpBook dkpBook, DkpOutlineItem dkpOutlineItem) {
        if (f4262a || dkpOutlineItem != null) {
            this.f4263b = c0904d;
            this.f4267f = i;
            this.f4264c = i2;
            this.f4265d = i3;
            DkpOutlineItem[] childOutlineItems = dkpBook.getChildOutlineItems(dkpOutlineItem.mIndex);
            this.f4266e = new C0902c[childOutlineItems.length];
            int i4 = this.f4265d + 1;
            for (int i5 = 0; i5 < this.f4266e.length; i5++) {
                this.f4266e[i5] = new C0902c(this.f4263b, this.f4267f + 1, i2, i4, dkpBook, childOutlineItems[i5]);
                i4 += this.f4266e[i5].m5865a() + 1;
            }
            this.f4268g = dkpOutlineItem.mTitle;
            this.f4271j = dkpOutlineItem.mDestPageNum > 0;
            if (this.f4271j) {
                this.f4269h = C0916p.m6081a(new DkFlowPosition(dkpOutlineItem.mDestPageNum, 0, 0));
                return;
            } else {
                this.f4269h = new C0898a(0, 0, 0);
                return;
            }
        }
        throw new AssertionError();
    }

    /* renamed from: d */
    public int mo1201d() {
        return this.f4264c;
    }

    /* renamed from: c */
    public int mo1200c() {
        return this.f4265d;
    }

    /* renamed from: e */
    public String mo1202e() {
        return this.f4268g;
    }

    /* renamed from: f */
    public av mo1203f() {
        return this.f4269h;
    }

    /* renamed from: g */
    public ak mo1204g() {
        if (this.f4270i == null || !this.f4270i.mo1186a()) {
            this.f4270i = this.f4263b.mo1230c(this.f4269h);
        }
        return this.f4270i;
    }

    /* renamed from: h */
    public int mo1205h() {
        return this.f4267f;
    }

    /* renamed from: i */
    public int mo1206i() {
        return this.f4266e.length;
    }

    /* renamed from: j */
    public C0901g[] mo1207j() {
        return this.f4266e;
    }

    /* renamed from: k */
    public boolean mo1208k() {
        return this.f4271j;
    }
}
