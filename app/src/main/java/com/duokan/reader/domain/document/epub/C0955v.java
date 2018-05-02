package com.duokan.reader.domain.document.epub;

import com.duokan.kernel.DkFindTextSnippet;
import com.duokan.kernel.DkFlowPosition;
import com.duokan.reader.domain.document.C1013z;
import com.duokan.reader.domain.document.aa;
import com.duokan.reader.domain.document.av;
import java.util.ArrayList;

/* renamed from: com.duokan.reader.domain.document.epub.v */
class C0955v extends ak {
    /* renamed from: d */
    static final /* synthetic */ boolean f4740d = (!C0952s.class.desiredAssertionStatus());
    /* renamed from: e */
    final /* synthetic */ int f4741e;
    /* renamed from: f */
    final /* synthetic */ av f4742f;
    /* renamed from: g */
    final /* synthetic */ C0934e f4743g;
    /* renamed from: h */
    final /* synthetic */ String f4744h;
    /* renamed from: i */
    final /* synthetic */ C0952s f4745i;

    C0955v(C0952s c0952s, String str, int i, av avVar, C0934e c0934e, String str2) {
        this.f4745i = c0952s;
        this.f4741e = i;
        this.f4742f = avVar;
        this.f4743g = c0934e;
        this.f4744h = str2;
        super(str);
    }

    public void run() {
        ArrayList arrayList = new ArrayList(this.f4741e);
        DkFlowPosition b = ((C0936c) this.f4742f).m6774b(this.f4743g.mo1365h());
        int i = 0;
        while (i < this.f4741e) {
            DkFlowPosition[] findTextInBook = this.f4743g.mo1365h().findTextInBook(b, this.f4744h, 1);
            if (this.c) {
                break;
            } else if (f4740d || findTextInBook != null) {
                if (findTextInBook.length < 2) {
                    break;
                }
                DkFlowPosition dkFlowPosition = findTextInBook[1];
                C1013z c1013z = new C1013z();
                DkFlowPosition dkFlowPosition2 = findTextInBook[0];
                DkFlowPosition dkFlowPosition3 = findTextInBook[1];
                c1013z.f5024a = new ce(new C0936c(dkFlowPosition2.mChapterIndex, dkFlowPosition2.mParaIndex, dkFlowPosition2.mAtomIndex), new C0936c(dkFlowPosition3.mChapterIndex, dkFlowPosition3.mParaIndex, dkFlowPosition3.mAtomIndex));
                DkFindTextSnippet findTextSnippet = this.f4743g.mo1365h().getFindTextSnippet(dkFlowPosition2, this.f4744h, 50);
                c1013z.f5025b = findTextSnippet.mSnippetText;
                c1013z.f5026c = findTextSnippet.mMatchStartPos;
                c1013z.f5027d = findTextSnippet.mMatchEndPos;
                arrayList.add(c1013z);
                i++;
                b = dkFlowPosition;
            } else {
                throw new AssertionError();
            }
        }
        this.b = (C1013z[]) arrayList.toArray(new C1013z[0]);
        this.f4745i.m5904a((aa) this);
        this.f4743g.mo1261g();
    }
}
