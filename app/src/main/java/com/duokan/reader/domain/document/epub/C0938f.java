package com.duokan.reader.domain.document.epub;

import android.text.TextUtils;
import com.duokan.kernel.epublib.DKETocPointWrapper;
import com.duokan.kernel.epublib.DKFlowPosition;
import com.duokan.reader.domain.document.C0896a;
import com.duokan.reader.domain.document.C0901g;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.av;

/* renamed from: com.duokan.reader.domain.document.epub.f */
public class C0938f extends C0901g {
    /* renamed from: a */
    static final /* synthetic */ boolean f4671a = (!C0938f.class.desiredAssertionStatus());
    /* renamed from: b */
    private final C0952s f4672b;
    /* renamed from: c */
    private final int f4673c;
    /* renamed from: d */
    private final int f4674d;
    /* renamed from: e */
    private final C0938f[] f4675e;
    /* renamed from: f */
    private final String f4676f;
    /* renamed from: g */
    private final C0936c f4677g;
    /* renamed from: h */
    private final String f4678h;
    /* renamed from: i */
    private final int f4679i;
    /* renamed from: j */
    private final boolean f4680j;
    /* renamed from: k */
    private ak f4681k = null;

    protected C0938f(C0952s c0952s, int i, int i2, EpubContentEntryData epubContentEntryData) {
        if (f4671a || epubContentEntryData != null) {
            this.f4672b = c0952s;
            this.f4673c = i;
            this.f4674d = i2;
            this.f4675e = new C0938f[0];
            this.f4676f = epubContentEntryData.mTitle;
            this.f4677g = ai.m6508a(epubContentEntryData.mChapterIndex, 0, 0);
            this.f4678h = "";
            this.f4679i = 0;
            this.f4680j = true;
            return;
        }
        throw new AssertionError();
    }

    protected C0938f(C0952s c0952s, int i, int i2, DKETocPointWrapper dKETocPointWrapper) {
        if (f4671a || dKETocPointWrapper != null) {
            this.f4672b = c0952s;
            this.f4673c = i;
            this.f4674d = i2;
            this.f4675e = new C0938f[((int) dKETocPointWrapper.GetChildCount())];
            int i3 = this.f4674d + 1;
            for (int i4 = 0; i4 < this.f4675e.length; i4++) {
                this.f4675e[i4] = new C0938f(this.f4672b, i, i3, new DKETocPointWrapper(dKETocPointWrapper.GetChildByIndex(i4)));
                i3 += this.f4675e[i4].m5865a() + 1;
            }
            DKFlowPosition dKFlowPosition = new DKFlowPosition();
            dKETocPointWrapper.GetDestPosition(dKFlowPosition);
            this.f4676f = dKETocPointWrapper.GetTitle();
            this.f4677g = ai.m6508a(dKFlowPosition.chapterIndex, dKFlowPosition.paraIndex, dKFlowPosition.atomIndex);
            this.f4678h = dKETocPointWrapper.getDestPortionId();
            this.f4679i = dKETocPointWrapper.GetDepth() - 1;
            this.f4680j = dKETocPointWrapper.IsContentValid();
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: l */
    public long mo1432l() {
        return this.f4677g.m6780g();
    }

    /* renamed from: m */
    protected String m6834m() {
        return this.f4678h;
    }

    /* renamed from: d */
    public int mo1201d() {
        return this.f4673c;
    }

    /* renamed from: c */
    public int mo1200c() {
        return this.f4674d;
    }

    /* renamed from: e */
    public String mo1202e() {
        return this.f4676f;
    }

    /* renamed from: f */
    public av mo1203f() {
        if (TextUtils.isEmpty(this.f4678h)) {
            return this.f4677g;
        }
        C0896a g = mo1204g();
        if (this.f4672b.mo1233d(g) && g.mo1192e()) {
            return g.mo1198g();
        }
        return this.f4677g;
    }

    /* renamed from: g */
    public ak mo1204g() {
        if (this.f4681k == null || !this.f4681k.mo1186a()) {
            this.f4681k = TextUtils.isEmpty(this.f4678h) ? this.f4672b.m7063d(this.f4677g) : this.f4672b.m7042a(this.f4677g.m6780g(), this.f4678h);
        }
        return this.f4681k;
    }

    /* renamed from: h */
    public int mo1205h() {
        return this.f4679i;
    }

    /* renamed from: i */
    public int mo1206i() {
        return this.f4675e.length;
    }

    /* renamed from: j */
    public C0901g[] mo1207j() {
        return this.f4675e;
    }

    /* renamed from: k */
    public boolean mo1208k() {
        return this.f4680j;
    }
}
