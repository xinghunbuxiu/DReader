package com.duokan.reader.domain.document.a;

import com.duokan.kernel.DkFlowPosition;
import com.duokan.kernel.pdflib.DkpBook;
import com.duokan.kernel.pdflib.DkpSearchResult;
import com.duokan.reader.domain.document.aa;
import com.duokan.reader.domain.document.z;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class k extends aa implements Runnable {
    final /* synthetic */ d d;
    private final k e;
    private final DkpBook f;
    private final AtomicInteger g;
    private final a h;
    private final int i;

    public k(d dVar, k kVar, int i) {
        this.d = dVar;
        super(kVar.a);
        this.e = kVar;
        this.f = this.e.f;
        this.g = this.e.g;
        this.g.incrementAndGet();
        this.h = d.a(((ag) this.e.b[this.e.b.length - 1].a).k().g() + 1, 0, 0);
        this.i = i;
    }

    public k(d dVar, String str, a aVar, int i) {
        this.d = dVar;
        super(str);
        b f = dVar.k;
        this.e = null;
        this.f = o.c().a().openBook(f.a().getAbsolutePath());
        this.g = new AtomicInteger(1);
        this.h = aVar;
        this.i = i;
    }

    protected void finalize() {
        super.finalize();
        if (this.g.decrementAndGet() < 1) {
            this.f.close();
        }
    }

    public void run() {
        LinkedList linkedList = new LinkedList();
        long g = this.h.g() + 1;
        while (g < ((long) this.f.getPageCount())) {
            linkedList.addAll(Arrays.asList(this.f.findTextInPage(g, this.a, 50)));
            if (linkedList.size() > this.i) {
                break;
            } else if (!this.c) {
                g++;
            } else {
                return;
            }
        }
        this.b = new z[linkedList.size()];
        Iterator it = linkedList.iterator();
        int i = 0;
        while (it.hasNext()) {
            DkpSearchResult dkpSearchResult = (DkpSearchResult) it.next();
            this.b[i] = new z();
            DkFlowPosition dkFlowPosition = dkpSearchResult.mMatchStartPos;
            DkFlowPosition dkFlowPosition2 = dkpSearchResult.mMatchEndPos;
            a aVar = new a(dkFlowPosition.mChapterIndex - 1, dkFlowPosition.mParaIndex, dkFlowPosition.mAtomIndex);
            a aVar2 = new a(dkFlowPosition2.mChapterIndex - 1, dkFlowPosition2.mParaIndex, dkFlowPosition2.mAtomIndex);
            this.b[i].a = new ag(aVar, aVar2);
            this.b[i].b = dkpSearchResult.mSnippetText;
            this.b[i].c = dkpSearchResult.mStartPosInSnippet;
            this.b[i].d = dkpSearchResult.mEndPosInSnippet;
            i++;
        }
        this.d.a((aa) this);
    }
}
