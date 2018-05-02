package com.duokan.reader.domain.document.epub;

import android.graphics.Rect;

import com.duokan.kernel.epublib.DkeHitTestInfo;
import com.duokan.reader.domain.document.ab;
import com.duokan.reader.domain.document.az;

class bj extends ab {
    public final String a;
    public final az b;
    public final Rect c;
    public final int d;
    public final int e;
    final /* synthetic */ az f;

    private bj(az azVar, DkeHitTestInfo dkeHitTestInfo, int i, int i2) {
        this.f = azVar;
        this.a = dkeHitTestInfo.mAltText;
        this.b = dkeHitTestInfo.mAltPage != null ? new cb(azVar, dkeHitTestInfo.mAltPage, new au()) : null;
        this.c = dkeHitTestInfo.mBoundingBox.toRect();
        this.d = i;
        this.e = i2;
    }

    public String a() {
        return this.a;
    }

    public az b() {
        return this.b;
    }
}
