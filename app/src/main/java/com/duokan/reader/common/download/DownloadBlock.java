package com.duokan.reader.common.download;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.duokan.core.diagnostic.HttpLogger;
import com.duokan.reader.common.download.DownloadTask.DownloadingStage;
import java.nio.channels.FileChannel;

abstract class DownloadBlock {
    /* renamed from: p */
    static final /* synthetic */ boolean f1931p = (!DownloadBlock.class.desiredAssertionStatus());
    /* renamed from: q */
    private static final String f1932q = DownloadBlock.class.getName();
    /* renamed from: a */
    protected final long f1933a;
    /* renamed from: b */
    protected final int f1934b;
    /* renamed from: c */
    protected final long f1935c;
    /* renamed from: d */
    protected long f1936d = -1;
    /* renamed from: e */
    protected final long f1937e;
    /* renamed from: f */
    protected BlockState f1938f = BlockState.UNFINISHED;
    /* renamed from: g */
    protected long f1939g = 0;
    /* renamed from: h */
    protected long f1940h = 0;
    /* renamed from: i */
    protected final String f1941i;
    /* renamed from: j */
    protected FileChannel f1942j = null;
    /* renamed from: k */
    protected long f1943k = 0;
    /* renamed from: l */
    protected final C0591a f1944l;
    /* renamed from: m */
    protected final SQLiteDatabase f1945m;
    /* renamed from: n */
    protected final HttpLogger f1946n;
    /* renamed from: o */
    protected DownloadingStage f1947o = DownloadingStage.UNKNOWN;

    public enum BlockState {
        SUCCEEDED,
        FAILED,
        UNFINISHED
    }

    /* renamed from: a */
    public void m2658a(long r12) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x006a in list [B:13:0x005d, B:19:0x0052]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:43)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r11 = this;
        r0 = f1931p;
        if (r0 != 0) goto L_0x0012;
    L_0x0004:
        r0 = r11.f1936d;
        r2 = -1;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 == 0) goto L_0x0012;
    L_0x000c:
        r0 = new java.lang.AssertionError;
        r0.<init>();
        throw r0;
    L_0x0012:
        r11.f1936d = r12;
        r0 = r11.f1945m;
        r0.beginTransaction();
        r0 = new android.content.ContentValues;	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
        r0.<init>();	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
        r1 = "block_length";	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
        r2 = r11.f1936d;	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
        r1 = r11.f1945m;	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
        r2 = "blocks";	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
        r3 = "block_id=?";	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
        r4 = 1;	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
        r4 = new java.lang.String[r4];	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
        r5 = 0;	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
        r6.<init>();	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
        r7 = "";	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
        r6 = r6.append(r7);	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
        r8 = r11.f1933a;	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
        r6 = r6.append(r8);	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
        r6 = r6.toString();	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
        r4[r5] = r6;	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
        r1.update(r2, r0, r3, r4);	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
        r0 = r11.f1945m;	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
        r0.setTransactionSuccessful();	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
        r0 = r11.f1945m;
        r0.endTransaction();
    L_0x0057:
        return;
    L_0x0058:
        r0 = move-exception;
        r0 = f1931p;	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
        if (r0 != 0) goto L_0x006a;	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
    L_0x005d:
        r0 = new java.lang.AssertionError;	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
        r0.<init>();	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
        throw r0;	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
    L_0x0063:
        r0 = move-exception;
        r1 = r11.f1945m;
        r1.endTransaction();
        throw r0;
    L_0x006a:
        r0 = r11.f1945m;
        r0.endTransaction();
        goto L_0x0057;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.common.download.DownloadBlock.a(long):void");
    }

    /* renamed from: b */
    protected abstract void mo801b(C0593c c0593c);

    /* renamed from: f */
    protected abstract void mo803f();

    /* renamed from: g */
    protected void m2672g() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0067 in list [B:7:0x005a, B:13:0x004f]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:43)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r10 = this;
        r0 = r10.f1945m;
        r0.beginTransaction();
        r0 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r0.<init>();	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r1 = "block_state";	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r2 = r10.f1938f;	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r1 = "downloaded_length";	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r2 = r10.f1939g;	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r1 = new android.content.ContentValues;	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r1.<init>();	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r2 = "runtime_info";	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r1.put(r2, r0);	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r0 = r10.f1945m;	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r2 = "blocks";	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r3 = "block_id=?";	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r4 = 1;	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r4 = new java.lang.String[r4];	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r5 = 0;	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r6.<init>();	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r7 = "";	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r6 = r6.append(r7);	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r8 = r10.f1933a;	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r6 = r6.append(r8);	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r6 = r6.toString();	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r4[r5] = r6;	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r0.update(r2, r1, r3, r4);	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r0 = r10.f1945m;	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r0.setTransactionSuccessful();	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r0 = r10.f1945m;
        r0.endTransaction();
    L_0x0054:
        return;
    L_0x0055:
        r0 = move-exception;
        r0 = f1931p;	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        if (r0 != 0) goto L_0x0067;	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
    L_0x005a:
        r0 = new java.lang.AssertionError;	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r0.<init>();	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        throw r0;	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
    L_0x0060:
        r0 = move-exception;
        r1 = r10.f1945m;
        r1.endTransaction();
        throw r0;
    L_0x0067:
        r0 = r10.f1945m;
        r0.endTransaction();
        goto L_0x0054;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.common.download.DownloadBlock.g():void");
    }

    public DownloadBlock(long r14, java.lang.String r16, android.database.sqlite.SQLiteDatabase r17, com.duokan.reader.common.download.C0591a r18, HttpLogger r19) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at java.util.BitSet.and(BitSet.java:913)
	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:433)
	at jadx.core.dex.visitors.regions.IfMakerHelper.restructureIf(IfMakerHelper.java:80)
	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:619)
	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:127)
	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
	at jadx.core.dex.visitors.regions.RegionMaker.processExcHandler(RegionMaker.java:1001)
	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:936)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r13 = this;
        r13.<init>();
        r2 = -1;
        r13.f1936d = r2;
        r2 = com.duokan.reader.common.download.DownloadBlock.BlockState.UNFINISHED;
        r13.f1938f = r2;
        r2 = 0;
        r13.f1939g = r2;
        r2 = 0;
        r13.f1940h = r2;
        r2 = 0;
        r13.f1942j = r2;
        r2 = 0;
        r13.f1943k = r2;
        r2 = com.duokan.reader.common.download.DownloadTask.DownloadingStage.UNKNOWN;
        r13.f1947o = r2;
        r2 = f1931p;
        if (r2 != 0) goto L_0x002a;
    L_0x0022:
        if (r16 != 0) goto L_0x002a;
    L_0x0024:
        r2 = new java.lang.AssertionError;
        r2.<init>();
        throw r2;
    L_0x002a:
        r2 = f1931p;
        if (r2 != 0) goto L_0x0036;
    L_0x002e:
        if (r17 != 0) goto L_0x0036;
    L_0x0030:
        r2 = new java.lang.AssertionError;
        r2.<init>();
        throw r2;
    L_0x0036:
        r0 = r17;
        r13.f1945m = r0;
        r13.f1933a = r14;
        r0 = r19;
        r13.f1946n = r0;
        r2 = r13.f1945m;
        r3 = "blocks";
        r4 = 0;
        r5 = "block_id=?";
        r6 = 1;
        r6 = new java.lang.String[r6];
        r7 = 0;
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r9 = "";
        r8 = r8.append(r9);
        r10 = r13.f1933a;
        r8 = r8.append(r10);
        r8 = r8.toString();
        r6[r7] = r8;
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r3 = r2.query(r3, r4, r5, r6, r7, r8, r9);
        r2 = f1931p;
        if (r2 != 0) goto L_0x0075;
    L_0x006d:
        if (r3 != 0) goto L_0x0075;
    L_0x006f:
        r2 = new java.lang.AssertionError;
        r2.<init>();
        throw r2;
    L_0x0075:
        r2 = f1931p;
        if (r2 != 0) goto L_0x0085;
    L_0x0079:
        r2 = r3.isAfterLast();
        if (r2 == 0) goto L_0x0085;
    L_0x007f:
        r2 = new java.lang.AssertionError;
        r2.<init>();
        throw r2;
    L_0x0085:
        r3.moveToNext();
        r2 = "block_index";
        r2 = r3.getColumnIndex(r2);
        r2 = r3.getInt(r2);
        r13.f1934b = r2;
        r2 = "block_offset";
        r2 = r3.getColumnIndex(r2);
        r4 = r3.getLong(r2);
        r13.f1935c = r4;
        r2 = "block_length";
        r2 = r3.getColumnIndex(r2);
        r4 = r3.getLong(r2);
        r13.f1936d = r4;
        r2 = "task_id";
        r2 = r3.getColumnIndex(r2);
        r4 = r3.getLong(r2);
        r13.f1937e = r4;
        r0 = r16;
        r13.f1941i = r0;
        r0 = r18;
        r13.f1944l = r0;
        r2 = new org.json.JSONObject;	 Catch:{ Exception -> 0x00ed }
        r4 = "runtime_info";	 Catch:{ Exception -> 0x00ed }
        r4 = r3.getColumnIndex(r4);	 Catch:{ Exception -> 0x00ed }
        r4 = r3.getString(r4);	 Catch:{ Exception -> 0x00ed }
        r2.<init>(r4);	 Catch:{ Exception -> 0x00ed }
        r4 = r2.length();	 Catch:{ Exception -> 0x00ed }
        if (r4 <= 0) goto L_0x00e9;	 Catch:{ Exception -> 0x00ed }
    L_0x00d5:
        r4 = "block_state";	 Catch:{ Exception -> 0x00ed }
        r4 = r2.getString(r4);	 Catch:{ Exception -> 0x00ed }
        r4 = com.duokan.reader.common.download.DownloadBlock.BlockState.valueOf(r4);	 Catch:{ Exception -> 0x00ed }
        r13.f1938f = r4;	 Catch:{ Exception -> 0x00ed }
        r4 = "downloaded_length";	 Catch:{ Exception -> 0x00ed }
        r4 = r2.getLong(r4);	 Catch:{ Exception -> 0x00ed }
        r13.f1939g = r4;	 Catch:{ Exception -> 0x00ed }
    L_0x00e9:
        r3.close();
    L_0x00ec:
        return;
    L_0x00ed:
        r2 = move-exception;
        r2 = f1931p;	 Catch:{ all -> 0x00f8 }
        if (r2 != 0) goto L_0x00fd;	 Catch:{ all -> 0x00f8 }
    L_0x00f2:
        r2 = new java.lang.AssertionError;	 Catch:{ all -> 0x00f8 }
        r2.<init>();	 Catch:{ all -> 0x00f8 }
        throw r2;	 Catch:{ all -> 0x00f8 }
    L_0x00f8:
        r2 = move-exception;
        r3.close();
        throw r2;
    L_0x00fd:
        r3.close();
        goto L_0x00ec;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.common.download.DownloadBlock.<init>(long, java.lang.String, android.database.sqlite.SQLiteDatabase, com.duokan.reader.common.download.a, com.duokan.core.diagnostic.f):void");
    }

    /* renamed from: a */
    public BlockState m2657a() {
        return this.f1938f;
    }

    /* renamed from: b */
    public long m2665b() {
        return this.f1940h / Math.max((System.nanoTime() - this.f1943k) / 1000000000, 1);
    }

    /* renamed from: c */
    public long m2668c() {
        return this.f1939g;
    }

    /* renamed from: a */
    public void m2664a(FileChannel fileChannel) {
        this.f1942j = fileChannel;
    }

    /* renamed from: d */
    public int mo802d() {
        return 3;
    }

    /* renamed from: a */
    public void m2661a(DownloadingStage downloadingStage) {
        this.f1947o = downloadingStage;
    }

    /* renamed from: a */
    public void m2662a(C0593c c0593c) {
        Log.i(f1932q, String.format("[%d]-[%d]-[%d]: ENTER_DOWNLOAD", new Object[]{Long.valueOf(this.f1933a), Integer.valueOf(this.f1934b), Long.valueOf(Thread.currentThread().getId())}));
        mo801b(c0593c);
        Log.i(f1932q, String.format("[%d]-[%d]-[%d]: LEAVE_DOWNLOAD", new Object[]{Long.valueOf(this.f1933a), Integer.valueOf(this.f1934b), Long.valueOf(Thread.currentThread().getId())}));
    }

    /* renamed from: e */
    public void m2670e() {
        mo803f();
    }

    /* renamed from: a */
    protected void m2663a(C0593c c0593c, boolean z) {
        if (!f1931p && c0593c == null) {
            throw new AssertionError();
        } else if (this.f1944l != null) {
            this.f1944l.mo788a(this, c0593c, z);
        }
    }

    /* renamed from: a */
    protected void m2659a(long j, long j2) {
        if (this.f1944l != null) {
            this.f1944l.mo786a(this, j, j2);
        }
    }

    /* renamed from: a */
    protected void m2660a(BlockState blockState) {
        if (this.f1944l != null) {
            this.f1944l.mo787a(this, blockState);
        }
    }

    /* renamed from: b */
    protected void m2666b(BlockState blockState) {
        this.f1938f = blockState;
        Log.i(f1932q, String.format("[%d]-[%d]-[%d]: " + this.f1938f, new Object[]{Long.valueOf(this.f1933a), Integer.valueOf(this.f1934b), Long.valueOf(Thread.currentThread().getId())}));
        m2672g();
        m2660a(this.f1938f);
    }
}
