package com.duokan.reader.domain.document.epub;

import android.text.TextUtils;

import com.duokan.kernel.epublib.DKETocPointWrapper;
import com.duokan.kernel.epublib.DKFlowPosition;
import com.duokan.reader.domain.document.Document_a;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.av;
import com.duokan.reader.domain.document.g;

public class f extends g {
    static final /* synthetic */ boolean a = (!f.class.desiredAssertionStatus());
    private final s b;
    private final int c;
    private final int d;
    private final f[] e;
    private final String f;
    private final c g;
    private final String h;
    private final int i;
    private final boolean j;
    private ak k = null;

    protected f(s sVar, int i, int i2, EpubContentEntryData epubContentEntryData) {
        if (a || epubContentEntryData != null) {
            this.b = sVar;
            this.c = i;
            this.d = i2;
            this.e = new f[0];
            this.f = epubContentEntryData.mTitle;
            this.g = ai.a(epubContentEntryData.mChapterIndex, 0, 0);
            this.h = "";
            this.i = 0;
            this.j = true;
            return;
        }
        throw new AssertionError();
    }

    protected f(s sVar, int i, int i2, DKETocPointWrapper dKETocPointWrapper) {
        if (a || dKETocPointWrapper != null) {
            this.b = sVar;
            this.c = i;
            this.d = i2;
            this.e = new f[((int) dKETocPointWrapper.GetChildCount())];
            int i3 = this.d + 1;
            for (int i4 = 0; i4 < this.e.length; i4++) {
                this.e[i4] = new f(this.b, i, i3, new DKETocPointWrapper(dKETocPointWrapper.GetChildByIndex(i4)));
                i3 += this.e[i4].a() + 1;
            }
            DKFlowPosition dKFlowPosition = new DKFlowPosition();
            dKETocPointWrapper.GetDestPosition(dKFlowPosition);
            this.f = dKETocPointWrapper.GetTitle();
            this.g = ai.a(dKFlowPosition.chapterIndex, dKFlowPosition.paraIndex, dKFlowPosition.atomIndex);
            this.h = dKETocPointWrapper.getDestPortionId();
            this.i = dKETocPointWrapper.GetDepth() - 1;
            this.j = dKETocPointWrapper.IsContentValid();
            return;
        }
        throw new AssertionError();
    }

    public long l() {
        return this.g.g();
    }

    protected String m() {
        return this.h;
    }

    public int d() {
        return this.c;
    }

    public int c() {
        return this.d;
    }

    public String e() {
        return this.f;
    }

    public av f() {
        if (TextUtils.isEmpty(this.h)) {
            return this.g;
        }
        Document_a g = g();
        if (this.b.d(g) && g.e()) {
            return g.g();
        }
        return this.g;
    }

    public ak g() {
        if (this.k == null || !this.k.a()) {
            this.k = TextUtils.isEmpty(this.h) ? this.b.d(this.g) : this.b.a(this.g.g(), this.h);
        }
        return this.k;
    }

    public int h() {
        return this.i;
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
