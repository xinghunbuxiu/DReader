package com.duokan.reader.domain.document.epub;

import com.duokan.core.diagnostic.C0328a;
import com.duokan.kernel.epublib.DkeHitTestInfo;
import com.duokan.reader.domain.document.ag;

class br extends ag {
    /* renamed from: a */
    final /* synthetic */ az f4597a;
    /* renamed from: b */
    private final String f4598b;
    /* renamed from: c */
    private final int f4599c;
    /* renamed from: d */
    private final int f4600d;
    /* renamed from: e */
    private final String f4601e;
    /* renamed from: f */
    private final String f4602f;

    private br(az azVar, DkeHitTestInfo dkeHitTestInfo) {
        this.f4597a = azVar;
        this.f4598b = dkeHitTestInfo.mSrcImagePath;
        this.f4599c = dkeHitTestInfo.mSrcImageWidth;
        this.f4600d = dkeHitTestInfo.mSrcImageHeight;
        this.f4601e = dkeHitTestInfo.mMainTitle;
        this.f4602f = dkeHitTestInfo.mSubTitle;
    }

    /* renamed from: a */
    public String mo1401a() {
        C0328a.m757c().m764b(this.f4597a.m6108M());
        return this.f4598b;
    }

    /* renamed from: b */
    public int mo1402b() {
        C0328a.m757c().m764b(this.f4597a.m6108M());
        return this.f4599c;
    }

    /* renamed from: c */
    public int mo1403c() {
        C0328a.m757c().m764b(this.f4597a.m6108M());
        return this.f4600d;
    }

    /* renamed from: d */
    public String mo1404d() {
        C0328a.m757c().m764b(this.f4597a.m6108M());
        return this.f4601e;
    }

    /* renamed from: e */
    public String mo1405e() {
        C0328a.m757c().m764b(this.f4597a.m6108M());
        return this.f4602f;
    }
}
