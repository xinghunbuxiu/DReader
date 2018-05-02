package com.duokan.reader.domain.document.txt;

import com.duokan.kernel.DkFindTextSnippet;
import com.duokan.reader.domain.document.aa;
import com.duokan.reader.domain.document.av;
import com.duokan.reader.domain.document.z;

import java.util.ArrayList;

class s extends ac {
    static final /* synthetic */ boolean d = (!p.class.desiredAssertionStatus());
    final /* synthetic */ int e;
    final /* synthetic */ av f;
    final /* synthetic */ c g;
    final /* synthetic */ String h;
    final /* synthetic */ p i;

    s(p pVar, String str, int i, av avVar, c cVar, String str2) {
        this.i = pVar;
        this.e = i;
        this.f = avVar;
        this.g = cVar;
        this.h = str2;
        super(str);
    }

    public void run() {
        ArrayList arrayList = new ArrayList(this.e);
        long g = ((b) this.f).g();
        int i = 0;
        while (i < this.e) {
            long[] findTextInBook = this.g.h().findTextInBook(g, this.h, 1);
            if (this.c) {
                break;
            } else if (d || findTextInBook != null) {
                if (findTextInBook.length < 2) {
                    break;
                }
                g = findTextInBook[1];
                z zVar = new z();
                long j = findTextInBook[0];
                zVar.a = new at(new b(j), new b(findTextInBook[1]));
                DkFindTextSnippet findTextSnippet = this.g.h().getFindTextSnippet(j, this.h, 50);
                zVar.b = findTextSnippet.mSnippetText;
                zVar.c = findTextSnippet.mMatchStartPos;
                zVar.d = findTextSnippet.mMatchEndPos;
                arrayList.add(zVar);
                i++;
            } else {
                throw new AssertionError();
            }
        }
        this.b = (z[]) arrayList.toArray(new z[0]);
        this.i.a((aa) this);
        this.g.g();
    }
}
