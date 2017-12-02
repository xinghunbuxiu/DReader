package com.duokan.reader.domain.document.epub;

import com.duokan.kernel.DkStream;
import com.duokan.kernel.epublib.DkeAudioText;
import com.duokan.reader.domain.document.b;
import com.duokan.reader.domain.document.bb;
import com.duokan.reader.domain.document.j;
import com.duokan.reader.domain.document.y;

class z extends b {
    final /* synthetic */ s a;
    private final DkeAudioText b;
    private final ce c = ai.a(ai.a(this.b.mStartPos.mChapterIndex, this.b.mStartPos.mParaIndex, this.b.mStartPos.mAtomIndex), ai.a(this.b.mEndPos.mChapterIndex, this.b.mEndPos.mParaIndex, this.b.mEndPos.mAtomIndex));

    public z(s sVar, DkeAudioText dkeAudioText) {
        this.a = sVar;
        this.b = dkeAudioText;
    }

    public bb a() {
        return this.c;
    }

    public float b() {
        return this.b.mStartTime;
    }

    public float c() {
        return this.b.mEndTime;
    }

    public String d() {
        return this.b.mAudioUrl;
    }

    public y e() {
        j p = this.a.k;
        DkStream mediaStream = p.h().getMediaStream(this.c.j().g(), this.b.mAudioUrl);
        if (mediaStream == null) {
            return null;
        }
        return new y(p, mediaStream);
    }
}
