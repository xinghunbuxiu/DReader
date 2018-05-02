package com.duokan.reader.domain.document.epub;

import com.duokan.kernel.DkStream;
import com.duokan.kernel.epublib.DkeAudioText;
import com.duokan.reader.domain.document.C0899j;
import com.duokan.reader.domain.document.C0930b;
import com.duokan.reader.domain.document.C1012y;
import com.duokan.reader.domain.document.bb;

/* renamed from: com.duokan.reader.domain.document.epub.z */
class C0959z extends C0930b {
    /* renamed from: a */
    final /* synthetic */ C0952s f4752a;
    /* renamed from: b */
    private final DkeAudioText f4753b;
    /* renamed from: c */
    private final ce f4754c = ai.m6509a(ai.m6508a(this.f4753b.mStartPos.mChapterIndex, this.f4753b.mStartPos.mParaIndex, this.f4753b.mStartPos.mAtomIndex), ai.m6508a(this.f4753b.mEndPos.mChapterIndex, this.f4753b.mEndPos.mParaIndex, this.f4753b.mEndPos.mAtomIndex));

    public C0959z(C0952s c0952s, DkeAudioText dkeAudioText) {
        this.f4752a = c0952s;
        this.f4753b = dkeAudioText;
    }

    /* renamed from: a */
    public bb mo1443a() {
        return this.f4754c;
    }

    /* renamed from: b */
    public float mo1444b() {
        return this.f4753b.mStartTime;
    }

    /* renamed from: c */
    public float mo1445c() {
        return this.f4753b.mEndTime;
    }

    /* renamed from: d */
    public String mo1446d() {
        return this.f4753b.mAudioUrl;
    }

    /* renamed from: e */
    public C1012y mo1447e() {
        C0899j p = this.f4752a.f4724k;
        DkStream mediaStream = p.mo1365h().getMediaStream(this.f4754c.m6813j().m6780g(), this.f4753b.mAudioUrl);
        if (mediaStream == null) {
            return null;
        }
        return new C1012y(p, mediaStream);
    }
}
