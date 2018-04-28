package com.duokan.reader.domain.cloud;

import android.os.AsyncTask;
import com.duokan.reader.common.async.p035a.C0517a;
import com.duokan.reader.domain.account.al;

class ej extends AsyncTask<Void, Void, Void> {
    /* renamed from: a */
    final /* synthetic */ al f3926a;
    /* renamed from: b */
    final /* synthetic */ C0517a f3927b;
    /* renamed from: c */
    final /* synthetic */ DkUserReadingNotesManager f3928c;
    /* renamed from: d */
    private long f3929d = 0;

    ej(DkUserReadingNotesManager dkUserReadingNotesManager, al alVar, C0517a c0517a) {
        this.f3928c = dkUserReadingNotesManager;
        this.f3926a = alVar;
        this.f3927b = c0517a;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m5490a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m5491a((Void) obj);
    }

    /* renamed from: a */
    protected java.lang.Void m5490a(java.lang.Void... r9) {
        /* JADX: method processing error */
/*
Error: java.lang.IndexOutOfBoundsException: bitIndex < 0: -1
	at java.util.BitSet.get(BitSet.java:623)
	at jadx.core.dex.visitors.CodeShrinker$ArgsInfo.usedArgAssign(CodeShrinker.java:138)
	at jadx.core.dex.visitors.CodeShrinker$ArgsInfo.access$300(CodeShrinker.java:43)
	at jadx.core.dex.visitors.CodeShrinker.canMoveBetweenBlocks(CodeShrinker.java:282)
	at jadx.core.dex.visitors.CodeShrinker.shrinkBlock(CodeShrinker.java:232)
	at jadx.core.dex.visitors.CodeShrinker.shrinkMethod(CodeShrinker.java:38)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.checkArrayForEach(LoopRegionVisitor.java:196)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.checkForIndexedLoop(LoopRegionVisitor.java:119)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.processLoopRegion(LoopRegionVisitor.java:65)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.enterRegion(LoopRegionVisitor.java:52)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:56)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:18)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.visit(LoopRegionVisitor.java:46)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r8 = this;
        r1 = new com.duokan.reader.domain.cloud.ev;
        r0 = r8.f3926a;
        r1.<init>(r0);
        r1.m5513b();
        r2 = r1.m5512a();
        r4 = r2.mReadingNoteCount;
        r8.f3929d = r4;
        r4 = r8.f3929d;
        r6 = -1;
        r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r0 != 0) goto L_0x003e;
    L_0x001a:
        r4 = 0;
        r8.f3929d = r4;
        r0 = r8.f3928c;
        r3 = r0.m5144a(r1);
        r0 = 0;
    L_0x0025:
        r4 = r3.length;
        if (r0 >= r4) goto L_0x0037;
    L_0x0028:
        r4 = r8.f3929d;
        r6 = r3[r0];
        r6 = r6.getNoteCount();
        r6 = (long) r6;
        r4 = r4 + r6;
        r8.f3929d = r4;
        r0 = r0 + 1;
        goto L_0x0025;
    L_0x0037:
        r4 = r8.f3929d;
        r2.mReadingNoteCount = r4;
        r1.updateInfo(r2);
    L_0x003e:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.cloud.ej.a(java.lang.Void[]):java.lang.Void");
    }

    /* renamed from: a */
    protected void m5491a(Void voidR) {
        super.onPostExecute(voidR);
        if (this.f3926a.m3365a(this.f3928c.f3626d)) {
            this.f3928c.f3627e = this.f3929d;
            this.f3928c.m5150d();
            this.f3927b.mo730a(null);
            return;
        }
        this.f3927b.mo729a(-1, "");
    }
}
