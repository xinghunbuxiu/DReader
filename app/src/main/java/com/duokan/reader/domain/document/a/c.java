package com.duokan.reader.domain.document.a;

import com.duokan.kernel.DkFlowPosition;
import com.duokan.kernel.pdflib.DkpBook;
import com.duokan.kernel.pdflib.DkpOutlineItem;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.av;
import com.duokan.reader.domain.document.g;

public class c extends g {
    static final /* synthetic */ boolean a = (!c.class.desiredAssertionStatus());
    private final d b;
    private final int c;
    private final int d;
    private final c[] e;
    private final int f;
    private final String g;
    private final av h;
    private ak i = null;
    private final boolean j;

    protected c(d dVar, int i, int i2, int i3, DkpBook dkpBook, DkpOutlineItem dkpOutlineItem) {
        if (a || dkpOutlineItem != null) {
            this.b = dVar;
            this.f = i;
            this.c = i2;
            this.d = i3;
            DkpOutlineItem[] childOutlineItems = dkpBook.getChildOutlineItems(dkpOutlineItem.mIndex);
            this.e = new c[childOutlineItems.length];
            int i4 = this.d + 1;
            for (int i5 = 0; i5 < this.e.length; i5++) {
                this.e[i5] = new c(this.b, this.f + 1, i2, i4, dkpBook, childOutlineItems[i5]);
                i4 += this.e[i5].a() + 1;
            }
            this.g = dkpOutlineItem.mTitle;
            this.j = dkpOutlineItem.mDestPageNum > 0;
            if (this.j) {
                this.h = p.a(new DkFlowPosition(dkpOutlineItem.mDestPageNum, 0, 0));
                return;
            } else {
                this.h = new a(0, 0, 0);
                return;
            }
        }
        throw new AssertionError();
    }

    public int d() {
        return this.c;
    }

    public int c() {
        return this.d;
    }

    public String e() {
        return this.g;
    }

    public av f() {
        return this.h;
    }

    public ak g() {
        if (this.i == null || !this.i.a()) {
            this.i = this.b.c(this.h);
        }
        return this.i;
    }

    public int h() {
        return this.f;
    }

    public int i() {
        return this.e.length;
    }

    public g[] j() {
        return this.e;
    }

    public boolean k() {
        return this.j;
    }
}
