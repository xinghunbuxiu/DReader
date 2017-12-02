package com.duokan.reader.domain.cloud;

import android.os.AsyncTask;

import com.duokan.reader.common.async.a.a;
import com.duokan.reader.domain.account.ab;

class fa extends AsyncTask {
    final /* synthetic */ ab a;
    final /* synthetic */ a b;
    final /* synthetic */ DkUserReadingNotesManager c;
    private long d = 0;

    fa(DkUserReadingNotesManager dkUserReadingNotesManager, ab abVar, a aVar) {
        this.c = dkUserReadingNotesManager;
        this.a = abVar;
        this.b = aVar;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((Void) obj);
    }

    protected java.lang.Void a(java.lang.Void... r9) {
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
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r8 = this;
        r1 = new com.duokan.reader.domain.cloud.fn;
        r0 = r8.a;
        r1.<init>(r0);
        r1.b();
        r2 = r1.a();
        r4 = r2.mReadingNoteCount;
        r8.d = r4;
        r4 = r8.d;
        r6 = -1;
        r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r0 != 0) goto L_0x003e;
    L_0x001a:
        r4 = 0;
        r8.d = r4;
        r0 = r8.c;
        r3 = r0.a(r1);
        r0 = 0;
    L_0x0025:
        r4 = r3.length;
        if (r0 >= r4) goto L_0x0037;
    L_0x0028:
        r4 = r8.d;
        r6 = r3[r0];
        r6 = r6.getNoteCount();
        r6 = (long) r6;
        r4 = r4 + r6;
        r8.d = r4;
        r0 = r0 + 1;
        goto L_0x0025;
    L_0x0037:
        r4 = r8.d;
        r2.mReadingNoteCount = r4;
        r1.updateInfo(r2);
    L_0x003e:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.cloud.fa.a(java.lang.Void[]):java.lang.Void");
    }

    protected void a(Void voidR) {
        super.onPostExecute(voidR);
        if (this.a.a(this.c.d)) {
            this.c.e = this.d;
            this.c.d();
            this.b.a(null);
            return;
        }
        this.b.a(-1, "");
    }
}
