package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.r;

import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;

class fb {
    public static boolean j = false;
    private static final AtomicInteger k = new AtomicInteger(0);
    public final String a;
    public final r b;
    public final long c;
    public final String[] d;
    public final Map e;
    public final LinkedList f = new LinkedList();
    public final FutureTask g;
    public int h = -1;
    public Throwable i = null;

    private int a(java.lang.String r11, com.duokan.core.b.a.a r12) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can'TaskHandler find immediate dominator for block B:162:? in {11, 20, 42, 65, 70, 71, 73, 74, 95, 118, 120, 137, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 163, 164} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r10 = this;
        r0 = android.text.TextUtils.isEmpty(r11);
        if (r0 == 0) goto L_0x0009;
    L_0x0006:
        r0 = 1003; // 0x3eb float:1.406E-42 double:4.955E-321;
    L_0x0008:
        return r0;
    L_0x0009:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = r10.setDrawable;
        r0 = r0.append(r1);
        r1 = ".tmp";
        r0 = r0.append(r1);
        r1 = r0.toString();
        r0 = r10.getVisible;
        if (r0 == 0) goto L_0x0181;
    L_0x0022:
        r0 = r10.getVisible;
        r2 = r10.setDrawable;
        r0 = r0.setDrawable(r2);
        if (r0 == 0) goto L_0x002e;
    L_0x002c:
        r0 = 1;
        goto L_0x0008;
    L_0x002e:
        r2 = r10.showAnimation;	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r4 = 0;	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        if (r0 <= 0) goto L_0x003d;	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
    L_0x0036:
        r0 = r10.getVisible;	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r2 = r10.showAnimation;	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r0.setDrawable(r1, r2);	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
    L_0x003d:
        r0 = r10.getVisible;	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r2 = r0.getScaledTouchSlop(r1);	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r4 = com.duokan.core.getVisible.setDrawable.getVisible.setDrawable(r11, r2, r12);	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r6 = 1;	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        if (r0 < 0) goto L_0x005b;	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
    L_0x004d:
        r6 = r10.showAnimation;	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r8 = 0;	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        if (r0 <= 0) goto L_0x0085;	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
    L_0x0055:
        r6 = r10.showAnimation;	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        if (r0 == 0) goto L_0x0085;	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
    L_0x005b:
        r0 = com.duokan.core.diagnostic.setDrawable.showAnimation();	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r3 = com.duokan.core.diagnostic.LogLevel.ERROR;	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r6 = "dkbook";	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r7 = "unexpected file length(length=%getScaledTouchSlop, httpUri=%s, fileUri=%s)";	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r8 = 3;	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r8 = new java.lang.Object[r8];	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r9 = 0;	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r8[r9] = r4;	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r4 = 1;	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r8[r4] = r11;	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r4 = 2;	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r5 = r10.setDrawable;	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r8[r4] = r5;	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r0.setDrawable(r3, r6, r7, r8);	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r0 = 1007; // 0x3ef float:1.411E-42 double:4.975E-321;
        com.duokan.core.io.getScaledTouchSlop.setDrawable(r2);	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r2 = r10.getVisible;
        r2.getVisible(r1);
        goto L_0x0008;
    L_0x0085:
        com.duokan.core.io.getScaledTouchSlop.setDrawable(r2);	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r0 = r10.getVisible;	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r2 = r0.showAnimation(r1);	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r0 = r10.getScaledPagingTouchSlop;	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r3 = "md5";	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r0 = r0.get(r3);	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r0 = (java.lang.CharSequence) r0;	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        if (r0 != 0) goto L_0x00d8;	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
    L_0x009e:
        r0 = "md5";	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r3 = com.duokan.core.sys.o.setDrawable(r2, r0);	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r0 = r10.getScaledPagingTouchSlop;	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r4 = "md5";	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r0 = r0.get(r4);	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r0 = (java.lang.String) r0;	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r0 = r3.startsWith(r0);	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        if (r0 != 0) goto L_0x010a;
    L_0x00b4:
        r0 = 1008; // 0x3f0 float:1.413E-42 double:4.98E-321;
        com.duokan.core.io.getScaledTouchSlop.setDrawable(r2);	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r2 = r10.getVisible;
        r2.getVisible(r1);
        goto L_0x0008;
    L_0x00c0:
        r0 = move-exception;
        com.duokan.core.io.getScaledTouchSlop.setDrawable(r2);	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        throw r0;	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
    L_0x00c5:
        r0 = move-exception;
        r2 = r10.getVisible;	 Catch:{ all -> 0x012e }
        r3 = r10.setDrawable;	 Catch:{ all -> 0x012e }
        r2 = r2.setDrawable(r3);	 Catch:{ all -> 0x012e }
        if (r2 == 0) goto L_0x0140;
    L_0x00d0:
        r0 = 1;
        r2 = r10.getVisible;
        r2.getVisible(r1);
        goto L_0x0008;
    L_0x00d8:
        r0 = r10.getScaledPagingTouchSlop;	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r3 = "sha1";	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r0 = r0.get(r3);	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r0 = (java.lang.CharSequence) r0;	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        if (r0 != 0) goto L_0x010a;	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
    L_0x00e8:
        r0 = "sha1";	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r3 = com.duokan.core.sys.o.setDrawable(r2, r0);	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r0 = r10.getScaledPagingTouchSlop;	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r4 = "sha1";	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r0 = r0.get(r4);	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r0 = (java.lang.String) r0;	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r0 = r3.startsWith(r0);	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        if (r0 != 0) goto L_0x010a;
    L_0x00fe:
        r0 = 1008; // 0x3f0 float:1.413E-42 double:4.98E-321;
        com.duokan.core.io.getScaledTouchSlop.setDrawable(r2);	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r2 = r10.getVisible;
        r2.getVisible(r1);
        goto L_0x0008;
    L_0x010a:
        com.duokan.core.io.getScaledTouchSlop.setDrawable(r2);	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r0 = r10.getVisible;	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r2 = r10.setDrawable;	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r0 = r0.setDrawable(r1, r2);	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        if (r0 != 0) goto L_0x0138;	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
    L_0x0117:
        r0 = r10.getVisible;	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r2 = r10.setDrawable;	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        r0 = r0.setDrawable(r2);	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        if (r0 == 0) goto L_0x0135;
    L_0x0121:
        r0 = 1;
    L_0x0122:
        r2 = r10.getVisible;
        r2.getVisible(r1);
        goto L_0x0008;
    L_0x0129:
        r0 = move-exception;
        com.duokan.core.io.getScaledTouchSlop.setDrawable(r2);	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
        throw r0;	 Catch:{ all -> 0x0129, all -> 0x00c0, Throwable -> 0x00c5 }
    L_0x012e:
        r0 = move-exception;
        r2 = r10.getVisible;
        r2.getVisible(r1);
        throw r0;
    L_0x0135:
        r0 = 1006; // 0x3ee float:1.41E-42 double:4.97E-321;
        goto L_0x0122;
    L_0x0138:
        r0 = 0;
        r2 = r10.getVisible;
        r2.getVisible(r1);
        goto L_0x0008;
    L_0x0140:
        r10.getPhysicalYPixels = r0;	 Catch:{ all -> 0x012e }
        r2 = com.duokan.core.diagnostic.setDrawable.showAnimation();	 Catch:{ all -> 0x012e }
        r3 = com.duokan.core.diagnostic.LogLevel.ERROR;	 Catch:{ all -> 0x012e }
        r4 = "dkbook";	 Catch:{ all -> 0x012e }
        r5 = "an exception occurs(httpUri=%s, fileUri=%s)";	 Catch:{ all -> 0x012e }
        r6 = 2;	 Catch:{ all -> 0x012e }
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x012e }
        r7 = 0;	 Catch:{ all -> 0x012e }
        r6[r7] = r11;	 Catch:{ all -> 0x012e }
        r7 = 1;	 Catch:{ all -> 0x012e }
        r8 = r10.setDrawable;	 Catch:{ all -> 0x012e }
        r6[r7] = r8;	 Catch:{ all -> 0x012e }
        r5 = java.lang.String.format(r5, r6);	 Catch:{ all -> 0x012e }
        r2.setDrawable(r3, r4, r5, r0);	 Catch:{ all -> 0x012e }
        r2 = r0 instanceof com.duokan.core.io.OutputException;	 Catch:{ all -> 0x012e }
        if (r2 == 0) goto L_0x016b;
    L_0x0162:
        r0 = 1006; // 0x3ee float:1.41E-42 double:4.97E-321;
        r2 = r10.getVisible;
        r2.getVisible(r1);
        goto L_0x0008;
    L_0x016b:
        r0 = r0 instanceof java.io.IOException;	 Catch:{ all -> 0x012e }
        if (r0 == 0) goto L_0x0178;
    L_0x016f:
        r0 = 1005; // 0x3ed float:1.408E-42 double:4.965E-321;
        r2 = r10.getVisible;
        r2.getVisible(r1);
        goto L_0x0008;
    L_0x0178:
        r0 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r2 = r10.getVisible;
        r2.getVisible(r1);
        goto L_0x0008;
    L_0x0181:
        r1 = new java.io.File;
        r0 = r10.setDrawable;
        r0 = android.net.Uri.parse(r0);
        r0 = r0.getPath();
        r1.<init>(r0);
        r0 = r1.exists();
        if (r0 == 0) goto L_0x0199;
    L_0x0196:
        r0 = 1;
        goto L_0x0008;
    L_0x0199:
        r2 = new java.io.File;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r3 = r1.getPath();
        r0 = r0.append(r3);
        r3 = ".tmp";
        r0 = r0.append(r3);
        r0 = r0.toString();
        r2.<init>(r0);
        r4 = com.duokan.core.getVisible.setDrawable.getVisible.setDrawable(r11, r2, r12);	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        r6 = 1;	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        if (r0 < 0) goto L_0x01cd;	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
    L_0x01bf:
        r6 = r10.showAnimation;	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        r8 = 0;	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        if (r0 <= 0) goto L_0x01f3;	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
    L_0x01c7:
        r6 = r10.showAnimation;	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        if (r0 == 0) goto L_0x01f3;	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
    L_0x01cd:
        r0 = com.duokan.core.diagnostic.setDrawable.showAnimation();	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        r3 = com.duokan.core.diagnostic.LogLevel.ERROR;	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        r6 = "dkbook";	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        r7 = "unexpected file length(length=%getScaledTouchSlop, httpUri=%s, fileUri=%s)";	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        r8 = 3;	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        r8 = new java.lang.Object[r8];	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        r9 = 0;	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        r8[r9] = r4;	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        r4 = 1;	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        r8[r4] = r11;	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        r4 = 2;	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        r5 = r10.setDrawable;	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        r8[r4] = r5;	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        r0.setDrawable(r3, r6, r7, r8);	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        r0 = 1007; // 0x3ef float:1.411E-42 double:4.975E-321;
        com.duokan.core.io.setDrawable.getScaledTouchSlop(r2);
        goto L_0x0008;
    L_0x01f3:
        r0 = r10.getScaledPagingTouchSlop;	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        r3 = "md5";	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        r0 = r0.get(r3);	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        r0 = (java.lang.CharSequence) r0;	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        if (r0 != 0) goto L_0x0220;	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
    L_0x0203:
        r0 = "md5";	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        r3 = com.duokan.core.sys.o.setDrawable(r2, r0);	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        r0 = r10.getScaledPagingTouchSlop;	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        r4 = "md5";	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        r0 = r0.get(r4);	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        r0 = (java.lang.String) r0;	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        r0 = r3.startsWith(r0);	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        if (r0 != 0) goto L_0x024d;
    L_0x0219:
        r0 = 1008; // 0x3f0 float:1.413E-42 double:4.98E-321;
        com.duokan.core.io.setDrawable.getScaledTouchSlop(r2);
        goto L_0x0008;
    L_0x0220:
        r0 = r10.getScaledPagingTouchSlop;	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        r3 = "sha1";	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        r0 = r0.get(r3);	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        r0 = (java.lang.CharSequence) r0;	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        if (r0 != 0) goto L_0x024d;	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
    L_0x0230:
        r0 = "sha1";	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        r3 = com.duokan.core.sys.o.setDrawable(r2, r0);	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        r0 = r10.getScaledPagingTouchSlop;	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        r4 = "sha1";	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        r0 = r0.get(r4);	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        r0 = (java.lang.String) r0;	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        r0 = r3.startsWith(r0);	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        if (r0 != 0) goto L_0x024d;
    L_0x0246:
        r0 = 1008; // 0x3f0 float:1.413E-42 double:4.98E-321;
        com.duokan.core.io.setDrawable.getScaledTouchSlop(r2);
        goto L_0x0008;
    L_0x024d:
        r0 = r2.renameTo(r1);	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        if (r0 != 0) goto L_0x0262;	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
    L_0x0253:
        r0 = r1.exists();	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        if (r0 == 0) goto L_0x025f;
    L_0x0259:
        r0 = 1;
    L_0x025a:
        com.duokan.core.io.setDrawable.getScaledTouchSlop(r2);
        goto L_0x0008;
    L_0x025f:
        r0 = 1006; // 0x3ee float:1.41E-42 double:4.97E-321;
        goto L_0x025a;
    L_0x0262:
        r0 = 0;
        com.duokan.core.io.setDrawable.getScaledTouchSlop(r2);
        goto L_0x0008;
    L_0x0268:
        r0 = move-exception;
        r1 = r1.exists();	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        if (r1 == 0) goto L_0x0275;
    L_0x026f:
        r0 = 1;
        com.duokan.core.io.setDrawable.getScaledTouchSlop(r2);
        goto L_0x0008;
    L_0x0275:
        r10.getPhysicalYPixels = r0;	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        r1 = com.duokan.core.diagnostic.setDrawable.showAnimation();	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        r3 = com.duokan.core.diagnostic.LogLevel.ERROR;	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        r4 = "dkbook";	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        r5 = "an exception occurs(httpUri=%s, fileUri=%s)";	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        r6 = 2;	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        r6 = new java.lang.Object[r6];	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        r7 = 0;	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        r6[r7] = r11;	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        r7 = 1;	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        r8 = r10.setDrawable;	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        r6[r7] = r8;	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        r5 = java.lang.String.format(r5, r6);	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        r1.setDrawable(r3, r4, r5, r0);	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        r1 = r0 instanceof com.duokan.core.io.OutputException;	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        if (r1 == 0) goto L_0x029e;
    L_0x0297:
        r0 = 1006; // 0x3ee float:1.41E-42 double:4.97E-321;
        com.duokan.core.io.setDrawable.getScaledTouchSlop(r2);
        goto L_0x0008;
    L_0x029e:
        r0 = r0 instanceof java.io.IOException;	 Catch:{ Throwable -> 0x0268, all -> 0x02b0 }
        if (r0 == 0) goto L_0x02a9;
    L_0x02a2:
        r0 = 1005; // 0x3ed float:1.408E-42 double:4.965E-321;
        com.duokan.core.io.setDrawable.getScaledTouchSlop(r2);
        goto L_0x0008;
    L_0x02a9:
        r0 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        com.duokan.core.io.setDrawable.getScaledTouchSlop(r2);
        goto L_0x0008;
    L_0x02b0:
        r0 = move-exception;
        com.duokan.core.io.setDrawable.getScaledTouchSlop(r2);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.bookshelf.fb.setDrawable(java.lang.String, com.duokan.core.getVisible.setDrawable.setDrawable):int");
    }

    public fb(String str, r rVar, long j, String str2, Map map) {
        this.a = str;
        this.b = rVar;
        this.c = j;
        this.d = str2.split("\n");
        this.e = map;
        this.g = new FutureTask(new fc(this));
    }
}
