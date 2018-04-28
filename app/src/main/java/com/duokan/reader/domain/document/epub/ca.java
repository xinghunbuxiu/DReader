package com.duokan.reader.domain.document.epub;

import android.graphics.Rect;
import com.duokan.kernel.epublib.DkePreText;
import com.duokan.reader.domain.document.ax;
import com.duokan.reader.domain.document.az;

class ca extends ax {
    /* renamed from: a */
    final /* synthetic */ az f4635a;
    /* renamed from: b */
    private final DkePreText f4636b;
    /* renamed from: c */
    private final Rect f4637c = this.f4636b.mBoundingBox.toRect();
    /* renamed from: d */
    private final ce f4638d = ai.m6509a(ai.m6508a(this.f4636b.mStartPos.mChapterIndex, this.f4636b.mStartPos.mParaIndex, this.f4636b.mStartPos.mAtomIndex), ai.m6508a(this.f4636b.mEndPos.mChapterIndex, this.f4636b.mEndPos.mParaIndex, this.f4636b.mEndPos.mAtomIndex));
    /* renamed from: e */
    private final cb f4639e;

    public ca(az azVar, DkePreText dkePreText) {
        this.f4635a = azVar;
        this.f4636b = dkePreText;
        this.f4639e = new cb(azVar, this.f4636b.mPrePage, null);
        this.f4639e.m6409b(azVar.f4524e.m6455j().f);
        this.f4639e.m6404a(this.f4636b.mMaxWidth);
    }

    /* renamed from: a */
    public int mo1422a() {
        return this.f4636b.mMaxWidth;
    }

    /* renamed from: b */
    public az mo1423b() {
        return this.f4639e;
    }
}
