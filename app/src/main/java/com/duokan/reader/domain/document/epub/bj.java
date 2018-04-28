package com.duokan.reader.domain.document.epub;

import android.graphics.Rect;
import com.duokan.kernel.epublib.DkeHitTestInfo;
import com.duokan.reader.domain.document.ab;
import com.duokan.reader.domain.document.az;

class bj extends ab {
    /* renamed from: a */
    public final String f4557a;
    /* renamed from: b */
    public final az f4558b;
    /* renamed from: c */
    public final Rect f4559c;
    /* renamed from: d */
    public final int f4560d;
    /* renamed from: e */
    public final int f4561e;
    /* renamed from: f */
    final /* synthetic */ az f4562f;

    private bj(az azVar, DkeHitTestInfo dkeHitTestInfo, int i, int i2) {
        this.f4562f = azVar;
        this.f4557a = dkeHitTestInfo.mAltText;
        this.f4558b = dkeHitTestInfo.mAltPage != null ? new cb(azVar, dkeHitTestInfo.mAltPage, new au()) : null;
        this.f4559c = dkeHitTestInfo.mBoundingBox.toRect();
        this.f4560d = i;
        this.f4561e = i2;
    }

    /* renamed from: a */
    public String mo1379a() {
        return this.f4557a;
    }

    /* renamed from: b */
    public az mo1380b() {
        return this.f4558b;
    }
}
