package com.duokan.reader.domain.document.epub;

import com.duokan.kernel.epublib.DkeHitTestInfo;
import com.duokan.reader.domain.document.ag;

class br extends ag {
    final /* synthetic */ az a;
    private final String b;
    private final int c;
    private final int d;
    private final String e;
    private final String f;

    private br(az azVar, DkeHitTestInfo dkeHitTestInfo) {
        this.a = azVar;
        this.b = dkeHitTestInfo.mSrcImagePath;
        this.c = dkeHitTestInfo.mSrcImageWidth;
        this.d = dkeHitTestInfo.mSrcImageHeight;
        this.e = dkeHitTestInfo.mMainTitle;
        this.f = dkeHitTestInfo.mSubTitle;
    }

    public String a() {
        a.c().b(this.a.N());
        return this.b;
    }

    public int b() {
        a.c().b(this.a.N());
        return this.c;
    }

    public int c() {
        a.c().b(this.a.N());
        return this.d;
    }

    public String d() {
        a.c().b(this.a.N());
        return this.e;
    }

    public String e() {
        a.c().b(this.a.N());
        return this.f;
    }
}
