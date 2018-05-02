package com.duokan.reader.domain.document.epub;

import android.graphics.Rect;

import com.duokan.kernel.epublib.DkePreText;
import com.duokan.reader.domain.document.ax;
import com.duokan.reader.domain.document.az;

class ca extends ax {
    final /* synthetic */ az a;
    private final DkePreText b;
    private final Rect c = this.b.mBoundingBox.toRect();
    private final ce d = ai.a(ai.a(this.b.mStartPos.mChapterIndex, this.b.mStartPos.mParaIndex, this.b.mStartPos.mAtomIndex), ai.a(this.b.mEndPos.mChapterIndex, this.b.mEndPos.mParaIndex, this.b.mEndPos.mAtomIndex));
    private final cb e;

    public ca(az azVar, DkePreText dkePreText) {
        this.a = azVar;
        this.b = dkePreText;
        this.e = new cb(azVar, this.b.mPrePage, null);
        this.e.b(azVar.e.j().f);
        this.e.a(this.b.mMaxWidth);
    }

    public int a() {
        return this.b.mMaxWidth;
    }

    public az b() {
        return this.e;
    }
}
