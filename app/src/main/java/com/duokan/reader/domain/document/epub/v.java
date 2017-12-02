package com.duokan.reader.domain.document.epub;

import com.duokan.kernel.DkFindTextSnippet;
import com.duokan.kernel.DkFlowPosition;
import com.duokan.reader.domain.document.aa;
import com.duokan.reader.domain.document.av;
import com.duokan.reader.domain.document.z;

import java.util.ArrayList;

class v extends ak {
    static final /* synthetic */ boolean d = (!s.class.desiredAssertionStatus());
    final /* synthetic */ int e;
    final /* synthetic */ av f;
    final /* synthetic */ e g;
    final /* synthetic */ String h;
    final /* synthetic */ s i;

    v(s sVar, String str, int i, av avVar, e eVar, String str2) {
        this.i = sVar;
        this.e = i;
        this.f = avVar;
        this.g = eVar;
        this.h = str2;
        super(str);
    }

    public void run() {
        ArrayList arrayList = new ArrayList(this.e);
        DkFlowPosition b = ((c) this.f).b(this.g.h());
        int i = 0;
        while (i < this.e) {
            DkFlowPosition[] findTextInBook = this.g.h().findTextInBook(b, this.h, 1);
            if (this.c) {
                break;
            } else if (d || findTextInBook != null) {
                if (findTextInBook.length < 2) {
                    break;
                }
                DkFlowPosition dkFlowPosition = findTextInBook[1];
                z zVar = new z();
                DkFlowPosition dkFlowPosition2 = findTextInBook[0];
                DkFlowPosition dkFlowPosition3 = findTextInBook[1];
                zVar.a = new ce(new c(dkFlowPosition2.mChapterIndex, dkFlowPosition2.mParaIndex, dkFlowPosition2.mAtomIndex), new c(dkFlowPosition3.mChapterIndex, dkFlowPosition3.mParaIndex, dkFlowPosition3.mAtomIndex));
                DkFindTextSnippet findTextSnippet = this.g.h().getFindTextSnippet(dkFlowPosition2, this.h, 50);
                zVar.b = findTextSnippet.mSnippetText;
                zVar.c = findTextSnippet.mMatchStartPos;
                zVar.d = findTextSnippet.mMatchEndPos;
                arrayList.add(zVar);
                i++;
                b = dkFlowPosition;
            } else {
                throw new AssertionError();
            }
        }
        this.b = (z[]) arrayList.toArray(new z[0]);
        this.i.a((aa) this);
        this.g.g();
    }
}
