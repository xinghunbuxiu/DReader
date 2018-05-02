package com.duokan.reader.domain.document.txt;

import com.duokan.kernel.DkFindTextSnippet;
import com.duokan.reader.domain.document.C1013z;
import com.duokan.reader.domain.document.aa;
import com.duokan.reader.domain.document.av;
import java.util.ArrayList;

/* renamed from: com.duokan.reader.domain.document.txt.s */
class C1003s extends ac {
    /* renamed from: d */
    static final /* synthetic */ boolean f4993d = (!C1000p.class.desiredAssertionStatus());
    /* renamed from: e */
    final /* synthetic */ int f4994e;
    /* renamed from: f */
    final /* synthetic */ av f4995f;
    /* renamed from: g */
    final /* synthetic */ C0987c f4996g;
    /* renamed from: h */
    final /* synthetic */ String f4997h;
    /* renamed from: i */
    final /* synthetic */ C1000p f4998i;

    C1003s(C1000p c1000p, String str, int i, av avVar, C0987c c0987c, String str2) {
        this.f4998i = c1000p;
        this.f4994e = i;
        this.f4995f = avVar;
        this.f4996g = c0987c;
        this.f4997h = str2;
        super(str);
    }

    public void run() {
        ArrayList arrayList = new ArrayList(this.f4994e);
        long g = ((C0986b) this.f4995f).m7539g();
        int i = 0;
        while (i < this.f4994e) {
            long[] findTextInBook = this.f4996g.mo1468h().findTextInBook(g, this.f4997h, 1);
            if (this.c) {
                break;
            } else if (f4993d || findTextInBook != null) {
                if (findTextInBook.length < 2) {
                    break;
                }
                g = findTextInBook[1];
                C1013z c1013z = new C1013z();
                long j = findTextInBook[0];
                c1013z.f5024a = new at(new C0986b(j), new C0986b(findTextInBook[1]));
                DkFindTextSnippet findTextSnippet = this.f4996g.mo1468h().getFindTextSnippet(j, this.f4997h, 50);
                c1013z.f5025b = findTextSnippet.mSnippetText;
                c1013z.f5026c = findTextSnippet.mMatchStartPos;
                c1013z.f5027d = findTextSnippet.mMatchEndPos;
                arrayList.add(c1013z);
                i++;
            } else {
                throw new AssertionError();
            }
        }
        this.b = (C1013z[]) arrayList.toArray(new C1013z[0]);
        this.f4998i.m5904a((aa) this);
        this.f4996g.mo1261g();
    }
}
