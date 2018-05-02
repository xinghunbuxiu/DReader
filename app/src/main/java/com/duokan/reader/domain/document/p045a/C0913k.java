package com.duokan.reader.domain.document.p045a;

import com.duokan.kernel.DkFlowPosition;
import com.duokan.kernel.pdflib.DkpBook;
import com.duokan.kernel.pdflib.DkpSearchResult;
import com.duokan.reader.domain.document.C1013z;
import com.duokan.reader.domain.document.aa;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.duokan.reader.domain.document.a.k */
public class C0913k extends aa implements Runnable {
    /* renamed from: d */
    final /* synthetic */ C0904d f4317d;
    /* renamed from: e */
    private final C0913k f4318e;
    /* renamed from: f */
    private final DkpBook f4319f;
    /* renamed from: g */
    private final AtomicInteger f4320g;
    /* renamed from: h */
    private final C0898a f4321h;
    /* renamed from: i */
    private final int f4322i;

    public C0913k(C0904d c0904d, C0913k c0913k, int i) {
        this.f4317d = c0904d;
        super(c0913k.a);
        this.f4318e = c0913k;
        this.f4319f = this.f4318e.f4319f;
        this.f4320g = this.f4318e.f4320g;
        this.f4320g.incrementAndGet();
        this.f4321h = C0904d.m5963a(((ag) this.f4318e.b[this.f4318e.b.length - 1].f5024a).m5834k().m5795g() + 1, 0, 0);
        this.f4322i = i;
    }

    public C0913k(C0904d c0904d, String str, C0898a c0898a, int i) {
        this.f4317d = c0904d;
        super(str);
        C0900b f = c0904d.f4283k;
        this.f4318e = null;
        this.f4319f = C0915o.m6074c().m6075a().openBook(f.mo1255a().getAbsolutePath());
        this.f4320g = new AtomicInteger(1);
        this.f4321h = c0898a;
        this.f4322i = i;
    }

    protected void finalize() {
        super.finalize();
        if (this.f4320g.decrementAndGet() < 1) {
            this.f4319f.close();
        }
    }

    public void run() {
        LinkedList linkedList = new LinkedList();
        long g = this.f4321h.m5795g() + 1;
        while (g < ((long) this.f4319f.getPageCount())) {
            linkedList.addAll(Arrays.asList(this.f4319f.findTextInPage(g, this.a, 50)));
            if (linkedList.size() > this.f4322i) {
                break;
            } else if (!this.c) {
                g++;
            } else {
                return;
            }
        }
        this.b = new C1013z[linkedList.size()];
        Iterator it = linkedList.iterator();
        int i = 0;
        while (it.hasNext()) {
            DkpSearchResult dkpSearchResult = (DkpSearchResult) it.next();
            this.b[i] = new C1013z();
            DkFlowPosition dkFlowPosition = dkpSearchResult.mMatchStartPos;
            DkFlowPosition dkFlowPosition2 = dkpSearchResult.mMatchEndPos;
            C0898a c0898a = new C0898a(dkFlowPosition.mChapterIndex - 1, dkFlowPosition.mParaIndex, dkFlowPosition.mAtomIndex);
            C0898a c0898a2 = new C0898a(dkFlowPosition2.mChapterIndex - 1, dkFlowPosition2.mParaIndex, dkFlowPosition2.mAtomIndex);
            this.b[i].f5024a = new ag(c0898a, c0898a2);
            this.b[i].f5025b = dkpSearchResult.mSnippetText;
            this.b[i].f5026c = dkpSearchResult.mStartPosInSnippet;
            this.b[i].f5027d = dkpSearchResult.mEndPosInSnippet;
            i++;
        }
        this.f4317d.m5904a((aa) this);
    }
}
