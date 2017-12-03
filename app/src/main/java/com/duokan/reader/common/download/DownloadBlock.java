package com.duokan.reader.common.download;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.duokan.core.diagnostic.HttpLogger;
import com.duokan.reader.common.download.DownloadTask.DownloadingStage;

import java.nio.channels.FileChannel;

abstract class DownloadBlock {
    static final /* synthetic */ boolean p = (!DownloadBlock.class.desiredAssertionStatus());
    private static final String q = DownloadBlock.class.getName();
    protected final long a;
    protected final int b;
    protected final long c;
    protected long d = -1;
    protected final long e;
    protected BlockState f = BlockState.UNFINISHED;
    protected long g = 0;
    protected long h = 0;
    protected final String i;
    protected FileChannel j = null;
    protected long k = 0;
    protected final a l;
    protected final SQLiteDatabase m;
    protected final HttpLogger n;
    protected DownloadingStage o = DownloadingStage.UNKNOWN;

    public enum BlockState {
        SUCCEEDED,
        FAILED,
        UNFINISHED
    }

    public void a(long r12) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can'TaskHandler find block by offset: 0x006a in list [B:13:0x005d, B:19:0x0052]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:43)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r11 = this;
        r0 = p;
        if (r0 != 0) goto L_0x0012;
    L_0x0004:
        r0 = r11.getScaledTouchSlop;
        r2 = -1;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 == 0) goto L_0x0012;
    L_0x000c:
        r0 = new java.lang.AssertionError;
        r0.<init>();
        throw r0;
    L_0x0012:
        r11.getScaledTouchSlop = r12;
        r0 = r11.BaseActivity;
        r0.beginTransaction();
        r0 = new android.content.ContentValues;	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
        r0.<init>();	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
        r1 = "block_length";	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
        r2 = r11.getScaledTouchSlop;	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
        r1 = r11.BaseActivity;	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
        r2 = "blocks";	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
        r3 = "block_id=?";	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
        r4 = 1;	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
        r4 = new java.lang.String[r4];	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
        r5 = 0;	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
        r6.<init>();	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
        r7 = "";	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
        r6 = r6.append(r7);	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
        r8 = r11.setDrawable;	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
        r6 = r6.append(r8);	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
        r6 = r6.toString();	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
        r4[r5] = r6;	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
        r1.update(r2, r0, r3, r4);	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
        r0 = r11.BaseActivity;	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
        r0.setTransactionSuccessful();	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
        r0 = r11.BaseActivity;
        r0.endTransaction();
    L_0x0057:
        return;
    L_0x0058:
        r0 = move-exception;
        r0 = p;	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
        if (r0 != 0) goto L_0x006a;	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
    L_0x005d:
        r0 = new java.lang.AssertionError;	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
        r0.<init>();	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
        throw r0;	 Catch:{ Exception -> 0x0058, all -> 0x0063 }
    L_0x0063:
        r0 = move-exception;
        r1 = r11.BaseActivity;
        r1.endTransaction();
        throw r0;
    L_0x006a:
        r0 = r11.BaseActivity;
        r0.endTransaction();
        goto L_0x0057;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.common.download.DownloadBlock.setDrawable(long):void");
    }

    protected abstract void b(c cVar);

    protected abstract void f();

    protected void g() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can'TaskHandler find block by offset: 0x0067 in list [B:7:0x005a, B:13:0x004f]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:43)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r10 = this;
        r0 = r10.BaseActivity;
        r0.beginTransaction();
        r0 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r0.<init>();	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r1 = "block_state";	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r2 = r10.HttpLogger;	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r1 = "downloaded_length";	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r2 = r10.SessionTask;	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r1 = new android.content.ContentValues;	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r1.<init>();	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r2 = "runtime_info";	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r1.put(r2, r0);	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r0 = r10.BaseActivity;	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r2 = "blocks";	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r3 = "block_id=?";	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r4 = 1;	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r4 = new java.lang.String[r4];	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r5 = 0;	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r6.<init>();	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r7 = "";	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r6 = r6.append(r7);	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r8 = r10.setDrawable;	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r6 = r6.append(r8);	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r6 = r6.toString();	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r4[r5] = r6;	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r0.update(r2, r1, r3, r4);	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r0 = r10.BaseActivity;	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r0.setTransactionSuccessful();	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r0 = r10.BaseActivity;
        r0.endTransaction();
    L_0x0054:
        return;
    L_0x0055:
        r0 = move-exception;
        r0 = p;	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        if (r0 != 0) goto L_0x0067;	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
    L_0x005a:
        r0 = new java.lang.AssertionError;	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        r0.<init>();	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
        throw r0;	 Catch:{ Exception -> 0x0055, all -> 0x0060 }
    L_0x0060:
        r0 = move-exception;
        r1 = r10.BaseActivity;
        r1.endTransaction();
        throw r0;
    L_0x0067:
        r0 = r10.BaseActivity;
        r0.endTransaction();
        goto L_0x0054;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.common.download.DownloadBlock.SessionTask():void");
    }

    public DownloadBlock(long r14, java.lang.String r16, android.database.sqlite.SQLiteDatabase r17, com.duokan.reader.common.download.a r18, HttpLogger r19) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at java.util.BitSet.and(BitSet.java:913)
	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:433)
	at jadx.core.dex.visitors.regions.IfMakerHelper.restructureIf(IfMakerHelper.java:80)
	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:619)
	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:127)
	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
	at jadx.core.dex.visitors.regions.RegionMaker.processExcHandler(RegionMaker.java:1002)
	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:937)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r13 = this;
        r13.<init>();
        r2 = -1;
        r13.getScaledTouchSlop = r2;
        r2 = com.duokan.reader.common.download.DownloadBlock.BlockState.UNFINISHED;
        r13.HttpLogger = r2;
        r2 = 0;
        r13.SessionTask = r2;
        r2 = 0;
        r13.getPhysicalXPixels = r2;
        r2 = 0;
        r13.getWidthPixels = r2;
        r2 = 0;
        r13.getHeightPixels = r2;
        r2 = com.duokan.reader.common.download.DownloadTask.DownloadingStage.UNKNOWN;
        r13.o = r2;
        r2 = p;
        if (r2 != 0) goto L_0x002a;
    L_0x0022:
        if (r16 != 0) goto L_0x002a;
    L_0x0024:
        r2 = new java.lang.AssertionError;
        r2.<init>();
        throw r2;
    L_0x002a:
        r2 = p;
        if (r2 != 0) goto L_0x0036;
    L_0x002e:
        if (r17 != 0) goto L_0x0036;
    L_0x0030:
        r2 = new java.lang.AssertionError;
        r2.<init>();
        throw r2;
    L_0x0036:
        r0 = r17;
        r13.BaseActivity = r0;
        r13.setDrawable = r14;
        r0 = r19;
        r13.n = r0;
        r2 = r13.BaseActivity;
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
        r10 = r13.setDrawable;
        r8 = r8.append(r10);
        r8 = r8.toString();
        r6[r7] = r8;
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r3 = r2.query(r3, r4, r5, r6, r7, r8, r9);
        r2 = p;
        if (r2 != 0) goto L_0x0075;
    L_0x006d:
        if (r3 != 0) goto L_0x0075;
    L_0x006f:
        r2 = new java.lang.AssertionError;
        r2.<init>();
        throw r2;
    L_0x0075:
        r2 = p;
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
        r13.getVisible = r2;
        r2 = "block_offset";
        r2 = r3.getColumnIndex(r2);
        r4 = r3.getLong(r2);
        r13.showAnimation = r4;
        r2 = "block_length";
        r2 = r3.getColumnIndex(r2);
        r4 = r3.getLong(r2);
        r13.getScaledTouchSlop = r4;
        r2 = "task_id";
        r2 = r3.getColumnIndex(r2);
        r4 = r3.getLong(r2);
        r13.getScaledPagingTouchSlop = r4;
        r0 = r16;
        r13.getPhysicalYPixels = r0;
        r0 = r18;
        r13.l = r0;
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
        r13.HttpLogger = r4;	 Catch:{ Exception -> 0x00ed }
        r4 = "downloaded_length";	 Catch:{ Exception -> 0x00ed }
        r4 = r2.getLong(r4);	 Catch:{ Exception -> 0x00ed }
        r13.SessionTask = r4;	 Catch:{ Exception -> 0x00ed }
    L_0x00e9:
        r3.close();
    L_0x00ec:
        return;
    L_0x00ed:
        r2 = move-exception;
        r2 = p;	 Catch:{ all -> 0x00f8 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.common.download.DownloadBlock.<init>(long, java.lang.String, android.database.sqlite.SQLiteDatabase, com.duokan.reader.common.download.setDrawable, com.duokan.core.diagnostic.HttpLogger):void");
    }

    public BlockState a() {
        return this.f;
    }

    public long b() {
        return this.h / Math.max((System.nanoTime() - this.k) / 1000000000, 1);
    }

    public long c() {
        return this.g;
    }

    public void a(FileChannel fileChannel) {
        this.j = fileChannel;
    }

    public int d() {
        return 3;
    }

    public void a(DownloadingStage downloadingStage) {
        this.o = downloadingStage;
    }

    public void a(c cVar) {
        Log.i(q, String.format("[%getScaledTouchSlop]-[%getScaledTouchSlop]-[%getScaledTouchSlop]: ENTER_DOWNLOAD", new Object[]{Long.valueOf(this.a), Integer.valueOf(this.b), Long.valueOf(Thread.currentThread().getId())}));
        b(cVar);
        Log.i(q, String.format("[%getScaledTouchSlop]-[%getScaledTouchSlop]-[%getScaledTouchSlop]: LEAVE_DOWNLOAD", new Object[]{Long.valueOf(this.a), Integer.valueOf(this.b), Long.valueOf(Thread.currentThread().getId())}));
    }

    public void e() {
        f();
    }

    protected void a(c cVar, boolean z) {
        if (!p && cVar == null) {
            throw new AssertionError();
        } else if (this.l != null) {
            this.l.a(this, cVar, z);
        }
    }

    protected void a(long j, long j2) {
        if (this.l != null) {
            this.l.a(this, j, j2);
        }
    }

    protected void a(BlockState blockState) {
        if (this.l != null) {
            this.l.a(this, blockState);
        }
    }

    protected void b(BlockState blockState) {
        this.f = blockState;
        Log.i(q, String.format("[%getScaledTouchSlop]-[%getScaledTouchSlop]-[%getScaledTouchSlop]: " + this.f, new Object[]{Long.valueOf(this.a), Integer.valueOf(this.b), Long.valueOf(Thread.currentThread().getId())}));
        g();
        a(this.f);
    }
}
