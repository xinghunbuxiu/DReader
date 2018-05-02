package com.duokan.reader.domain.document.epub;

import com.duokan.core.diagnostic.WebLog;
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
        WebLog.init().w(this.f4597a.m6108M());
        return this.f4598b;
    }

    /* renamed from: b */
    public int mo1402b() {
        WebLog.init().w(this.f4597a.m6108M());
        return this.f4599c;
    }

    /* renamed from: c */
    public int mo1403c() {
        WebLog.init().w(this.f4597a.m6108M());
        return this.f4600d;
    }

    /* renamed from: d */
    public String mo1404d() {
        WebLog.init().w(this.f4597a.m6108M());
        return this.f4601e;
    }

    /* renamed from: e */
    public String mo1405e() {
        WebLog.init().w(this.f4597a.m6108M());
        return this.f4602f;
    }
}
