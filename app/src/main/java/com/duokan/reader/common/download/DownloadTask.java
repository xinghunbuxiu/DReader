package com.duokan.reader.common.download;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;

import com.duokan.core.diagnostic.HttpLogger;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.reader.common.download.DownloadBlock.BlockState;

import org.json.JSONObject;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public abstract class DownloadTask implements IDownloadTask, a {
    static final /* synthetic */ boolean t;
    private static final String u = DownloadTask.class.getName();
    protected final Context a;
    protected final long b;
    protected final String c;
    protected final String d;
    protected final String e;
    protected final String f;
    protected final String g;
    protected JSONObject h = null;
    protected TaskStatus i = TaskStatus.STOPPED;
    protected TaskState j = TaskState.UNFINISHED;
    protected DownloadingStage k = DownloadingStage.UNKNOWN;
    protected long l = 0;
    protected DownloadFailCode m = DownloadFailCode.NONE;
    protected c n = null;
    protected RandomAccessFile o = null;
    protected FileChannel p = null;
    protected final l q;
    protected final SQLiteDatabase r;
    protected final HttpLogger s;
    private LinkedList v = new LinkedList();
    private LinkedList w = new LinkedList();
    private LinkedList x = new LinkedList();

    public enum DownloadingStage {
        UNKNOWN,
        MULTI_BLOCK_DOWNLOADING_HANDSHAKE,
        MULTI_BLOCK_PARALLEL_DOWNLOADING,
        MULTI_BLOCK_SEQUENTIAL_DOWNLOADING,
        MONO_BLOCK_DOWNLOADING
    }

    protected abstract DownloadBlock b(long j);

    protected void z() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can'TaskHandler find block by offset: 0x0058 in list [B:7:0x004b, B:13:0x0040]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:43)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
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
        r0 = r10.onActivityResult;
        r0.beginTransaction();
        r0 = r10.A();	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
        r1 = new android.content.ContentValues;	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
        r1.<init>();	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
        r2 = "runtime_info";	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
        r1.put(r2, r0);	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
        r0 = r10.onActivityResult;	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
        r2 = "tasks";	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
        r3 = "task_id=?";	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
        r4 = 1;	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
        r4 = new java.lang.String[r4];	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
        r5 = 0;	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
        r6.<init>();	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
        r7 = "";	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
        r6 = r6.append(r7);	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
        r8 = r10.getVisible;	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
        r6 = r6.append(r8);	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
        r6 = r6.toString();	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
        r4[r5] = r6;	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
        r0.update(r2, r1, r3, r4);	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
        r0 = r10.onActivityResult;	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
        r0.setTransactionSuccessful();	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
        r0 = r10.onActivityResult;
        r0.endTransaction();
    L_0x0045:
        return;
    L_0x0046:
        r0 = move-exception;
        r0 = TaskHandler;	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
        if (r0 != 0) goto L_0x0058;	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
    L_0x004b:
        r0 = new java.lang.AssertionError;	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
        r0.<init>();	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
        throw r0;	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
    L_0x0051:
        r0 = move-exception;
        r1 = r10.onActivityResult;
        r1.endTransaction();
        throw r0;
    L_0x0058:
        r0 = r10.onActivityResult;
        r0.endTransaction();
        goto L_0x0045;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.common.download.DownloadTask.QueryFeatureWrapper():void");
    }

    static {
        boolean z;
        if (DownloadTask.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        t = z;
    }

    protected DownloadTask(android.content.Context r13, long r14, android.database.sqlite.SQLiteDatabase r16, com.duokan.reader.common.download.l r17, java.io.File r18) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r12 = this;
        r12.<init>();
        r2 = 0;
        r12.getPhysicalXPixels = r2;
        r2 = com.duokan.reader.common.download.IDownloadTask.TaskStatus.STOPPED;
        r12.i = r2;
        r2 = com.duokan.reader.common.download.IDownloadTask.TaskState.UNFINISHED;
        r12.getWidthPixels = r2;
        r2 = com.duokan.reader.common.download.DownloadTask.DownloadingStage.UNKNOWN;
        r12.getHeightPixels = r2;
        r2 = 0;
        r12.OnDismissListener = r2;
        r2 = com.duokan.reader.common.download.DownloadFailCode.NONE;
        r12.BaseActivity = r2;
        r2 = 0;
        r12.n = r2;
        r2 = 0;
        r12.o = r2;
        r2 = 0;
        r12.p = r2;
        r2 = new java.util.LinkedList;
        r2.<init>();
        r12.v = r2;
        r2 = new java.util.LinkedList;
        r2.<init>();
        r12.IActivityRunStatusChanged = r2;
        r2 = new java.util.LinkedList;
        r2.<init>();
        r12.MyContextWrapper = r2;
        r2 = TaskHandler;
        if (r2 != 0) goto L_0x0044;
    L_0x003c:
        if (r13 != 0) goto L_0x0044;
    L_0x003e:
        r2 = new java.lang.AssertionError;
        r2.<init>();
        throw r2;
    L_0x0044:
        r2 = TaskHandler;
        if (r2 != 0) goto L_0x0050;
    L_0x0048:
        if (r16 != 0) goto L_0x0050;
    L_0x004a:
        r2 = new java.lang.AssertionError;
        r2.<init>();
        throw r2;
    L_0x0050:
        r12.setDrawable = r13;
        r0 = r16;
        r12.onActivityResult = r0;
        r12.getVisible = r14;
        r2 = r12.onActivityResult;
        r3 = "tasks";
        r4 = 0;
        r5 = "task_id=?";
        r6 = 1;
        r6 = new java.lang.String[r6];
        r7 = 0;
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r9 = "";
        r8 = r8.append(r9);
        r10 = r12.getVisible;
        r8 = r8.append(r10);
        r8 = r8.toString();
        r6[r7] = r8;
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r3 = r2.query(r3, r4, r5, r6, r7, r8, r9);
        r2 = TaskHandler;
        if (r2 != 0) goto L_0x008d;
    L_0x0085:
        if (r3 != 0) goto L_0x008d;
    L_0x0087:
        r2 = new java.lang.AssertionError;
        r2.<init>();
        throw r2;
    L_0x008d:
        r2 = TaskHandler;
        if (r2 != 0) goto L_0x009d;
    L_0x0091:
        r2 = r3.isAfterLast();
        if (r2 == 0) goto L_0x009d;
    L_0x0097:
        r2 = new java.lang.AssertionError;
        r2.<init>();
        throw r2;
    L_0x009d:
        r3.moveToNext();
        r2 = "task_tag";
        r2 = r3.getColumnIndex(r2);
        r2 = r3.getString(r2);
        r12.showAnimation = r2;
        r2 = "task_title";
        r2 = r3.getColumnIndex(r2);
        r2 = r3.getString(r2);
        r12.getScaledTouchSlop = r2;
        r2 = "source_uri";
        r2 = r3.getColumnIndex(r2);
        r2 = r3.getString(r2);
        r12.getScaledPagingTouchSlop = r2;
        r2 = "target_uri";
        r2 = r3.getColumnIndex(r2);
        r2 = r3.getString(r2);
        r12.HttpLogger = r2;
        r2 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x01d0 }
        r4 = "user_value";	 Catch:{ JSONException -> 0x01d0 }
        r4 = r3.getColumnIndex(r4);	 Catch:{ JSONException -> 0x01d0 }
        r4 = r3.getString(r4);	 Catch:{ JSONException -> 0x01d0 }
        r2.<init>(r4);	 Catch:{ JSONException -> 0x01d0 }
        r12.getPhysicalXPixels = r2;	 Catch:{ JSONException -> 0x01d0 }
    L_0x00e1:
        r2 = "md5";
        r2 = r3.getColumnIndex(r2);
        r2 = r3.getString(r2);
        r12.SessionTask = r2;
        r0 = r17;
        r12.q = r0;
        r2 = new com.duokan.core.diagnostic.HttpLogger;
        r2.<init>();
        r12.s = r2;
        r2 = r12.s;
        r4 = new java.io.File;
        r5 = java.util.Locale.getDefault();
        r6 = "dl.%getScaledTouchSlop.%s.log";
        r7 = 2;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r10 = r12.getVisible;
        r9 = java.lang.Long.valueOf(r10);
        r7[r8] = r9;
        r8 = 1;
        r9 = r12.HttpLogger;
        r9 = android.net.Uri.parse(r9);
        r9 = r9.getLastPathSegment();
        r7[r8] = r9;
        r5 = java.lang.String.format(r5, r6, r7);
        r0 = r18;
        r4.<init>(r0, r5);
        r2.setDrawable(r4);
        r2 = new org.json.JSONObject;	 Catch:{ Exception -> 0x017e }
        r4 = "runtime_info";	 Catch:{ Exception -> 0x017e }
        r4 = r3.getColumnIndex(r4);	 Catch:{ Exception -> 0x017e }
        r4 = r3.getString(r4);	 Catch:{ Exception -> 0x017e }
        r2.<init>(r4);	 Catch:{ Exception -> 0x017e }
        r4 = r2.length();	 Catch:{ Exception -> 0x017e }
        if (r4 <= 0) goto L_0x013f;	 Catch:{ Exception -> 0x017e }
    L_0x013c:
        r12.getVisible(r2);	 Catch:{ Exception -> 0x017e }
    L_0x013f:
        r3.close();
    L_0x0142:
        r2 = r12.onActivityResult;
        r3 = "blocks";
        r4 = 1;
        r4 = new java.lang.String[r4];
        r5 = 0;
        r6 = "block_id";
        r4[r5] = r6;
        r5 = "task_id=?";
        r6 = 1;
        r6 = new java.lang.String[r6];
        r7 = 0;
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r9 = "";
        r8 = r8.append(r9);
        r10 = r12.getVisible;
        r8 = r8.append(r10);
        r8 = r8.toString();
        r6[r7] = r8;
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r8 = r2.query(r3, r4, r5, r6, r7, r8, r9);
        r2 = TaskHandler;
        if (r2 != 0) goto L_0x0192;
    L_0x0176:
        if (r8 != 0) goto L_0x0192;
    L_0x0178:
        r2 = new java.lang.AssertionError;
        r2.<init>();
        throw r2;
    L_0x017e:
        r2 = move-exception;
        r2 = TaskHandler;	 Catch:{ all -> 0x0189 }
        if (r2 != 0) goto L_0x018e;	 Catch:{ all -> 0x0189 }
    L_0x0183:
        r2 = new java.lang.AssertionError;	 Catch:{ all -> 0x0189 }
        r2.<init>();	 Catch:{ all -> 0x0189 }
        throw r2;	 Catch:{ all -> 0x0189 }
    L_0x0189:
        r2 = move-exception;
        r3.close();
        throw r2;
    L_0x018e:
        r3.close();
        goto L_0x0142;
    L_0x0192:
        r2 = r8.isAfterLast();
        if (r2 == 0) goto L_0x01bd;
    L_0x0198:
        r3 = 0;
        r4 = 0;
        r6 = -1;
        r2 = r12;
        r2 = r2.setDrawable(r3, r4, r6);
        r4 = TaskHandler;
        if (r4 != 0) goto L_0x01b2;
    L_0x01a6:
        r4 = -1;
        r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r4 != 0) goto L_0x01b2;
    L_0x01ac:
        r2 = new java.lang.AssertionError;
        r2.<init>();
        throw r2;
    L_0x01b2:
        r2 = r12.getVisible(r2);
        r12.getVisible(r2);
    L_0x01b9:
        r8.close();
        return;
    L_0x01bd:
        r2 = r8.moveToNext();
        if (r2 == 0) goto L_0x01b9;
    L_0x01c3:
        r2 = 0;
        r2 = r8.getLong(r2);
        r2 = r12.getVisible(r2);
        r12.getVisible(r2);
        goto L_0x01bd;
    L_0x01d0:
        r2 = move-exception;
        goto L_0x00e1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.common.download.DownloadTask.<init>(android.content.Context, long, android.database.sqlite.SQLiteDatabase, com.duokan.reader.common.download.OnDismissListener, java.io.File):void");
    }

    public long a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }

    public JSONObject d() {
        return this.h;
    }

    public void a(JSONObject jSONObject) {
        this.h = jSONObject;
        this.r.beginTransaction();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("user_value", this.h.toString());
            this.r.update("tasks", contentValues, "task_id=?", new String[]{"" + this.b});
            this.r.setTransactionSuccessful();
        } catch (Exception e) {
        } finally {
            this.r.endTransaction();
        }
    }

    public TaskStatus e() {
        return this.i;
    }

    public TaskState f() {
        return this.j;
    }

    public long g() {
        return this.l;
    }

    public DownloadFailCode h() {
        return this.m;
    }

    public String i() {
        return this.e;
    }

    public String j() {
        return this.f;
    }

    public String k() {
        return this.g;
    }

    public long l() {
        long j;
        synchronized (this) {
            Iterator it = this.w.iterator();
            j = 0;
            while (it.hasNext()) {
                j = ((DownloadBlock) it.next()).b() + j;
            }
        }
        return j;
    }

    public long m() {
        return this.n != null ? this.n.a : -1;
    }

    public float n() {
        float f = 100.0f;
        synchronized (this) {
            long m = m();
            long o = o();
            if (m < 0) {
                f = 0.0f;
            } else if (m == 0) {
            } else {
                f = 100.0f * (((float) o) / ((float) m));
            }
        }
        return f;
    }

    public long o() {
        long j;
        synchronized (this) {
            j = 0;
            Iterator it = this.v.iterator();
            while (it.hasNext()) {
                j += ((DownloadBlock) it.next()).c();
            }
            it = this.w.iterator();
            while (it.hasNext()) {
                j += ((DownloadBlock) it.next()).c();
            }
            Iterator it2 = this.x.iterator();
            while (it2.hasNext()) {
                j = ((DownloadBlock) it2.next()).c() + j;
            }
        }
        return j;
    }

    public String p() {
        Uri parse = Uri.parse(this.e);
        if (!(this.n == null || this.n.e == null)) {
            parse = Uri.parse(this.n.e);
        }
        String a = e.a(parse.getLastPathSegment());
        if (a == null && this.n != null && this.n.g != null && this.n.g.length() > 0) {
            a = e.a(this.n.g);
        }
        if (a == null && this.n != null && this.n.d != null && this.n.d.length() > 0) {
            a = e.a(Uri.parse(this.n.d).getLastPathSegment());
        }
        if (!(a != null || this.n == null || this.n.c == null)) {
            a = this.n.c;
        }
        return a != null ? a : "application/octet-stream";
    }

    public HttpLogger q() {
        return this.s;
    }

    public void a(String str) {
    }

    public void a(DownloadBlock downloadBlock, c cVar, boolean z) {
        if (!t && downloadBlock == null) {
            throw new AssertionError();
        } else if (t || cVar != null) {
            if (z) {
                try {
                    this.n = cVar;
                    long m = m();
                    if (m >= 0) {
                        if (this.o != null) {
                            this.o.setLength(m);
                        }
                        int i = (this.k == DownloadingStage.MULTI_BLOCK_DOWNLOADING_HANDSHAKE && cVar.b) ? 4 : 1;
                        int i2 = i;
                        while (i2 > 1 && m / ((long) i2) < 2097152) {
                            i2--;
                        }
                        if (t || (i2 >= 1 && i2 <= 4)) {
                            long j = m / ((long) i2);
                            long j2 = (m / ((long) i2)) + (m % ((long) i2));
                            synchronized (this) {
                                this.r.beginTransaction();
                                try {
                                    downloadBlock.a(j);
                                    int i3 = 1;
                                    while (i3 < i2) {
                                        long a = a(i3, ((long) i3) * j, i3 == i2 + -1 ? j2 : j);
                                        if (t || a != -1) {
                                            b(b(a));
                                            i3++;
                                        } else {
                                            throw new AssertionError();
                                        }
                                    }
                                    z();
                                    this.r.setTransactionSuccessful();
                                    this.r.endTransaction();
                                } catch (Throwable th) {
                                    this.r.endTransaction();
                                }
                            }
                        } else {
                            throw new AssertionError();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            if (this.k == DownloadingStage.MULTI_BLOCK_DOWNLOADING_HANDSHAKE) {
                this.k = DownloadingStage.MULTI_BLOCK_PARALLEL_DOWNLOADING;
            }
            downloadBlock.a(this.k);
            a(z);
        } else {
            throw new AssertionError();
        }
    }

    public void a(DownloadBlock downloadBlock, long j, long j2) {
        if (!t && downloadBlock == null) {
            throw new AssertionError();
        } else if (t || j2 > 0) {
            a(j, j2);
        } else {
            throw new AssertionError();
        }
    }

    public void a(DownloadBlock downloadBlock, BlockState blockState) {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void r() {
        /*
        r3 = this;
    L_0x0000:
        monitor-enter(r3);
        r0 = r3.getPhysicalYPixels;	 Catch:{ all -> 0x0033 }
        r1 = com.duokan.reader.common.download.IDownloadTask.TaskStatus.PAUSED;	 Catch:{ all -> 0x0033 }
        if (r0 == r1) goto L_0x000d;
    L_0x0007:
        r0 = r3.getPhysicalYPixels;	 Catch:{ all -> 0x0033 }
        r1 = com.duokan.reader.common.download.IDownloadTask.TaskStatus.STOPPED;	 Catch:{ all -> 0x0033 }
        if (r0 != r1) goto L_0x000f;
    L_0x000d:
        monitor-exit(r3);	 Catch:{ all -> 0x0033 }
    L_0x000e:
        return;
    L_0x000f:
        r0 = r3.getHeightPixels;	 Catch:{ all -> 0x0033 }
        r1 = com.duokan.reader.common.download.DownloadTask.DownloadingStage.UNKNOWN;	 Catch:{ all -> 0x0033 }
        if (r0 != r1) goto L_0x0019;
    L_0x0015:
        r0 = com.duokan.reader.common.download.DownloadTask.DownloadingStage.MULTI_BLOCK_DOWNLOADING_HANDSHAKE;	 Catch:{ all -> 0x0033 }
        r3.getHeightPixels = r0;	 Catch:{ all -> 0x0033 }
    L_0x0019:
        r0 = r3.getPhysicalYPixels;	 Catch:{ all -> 0x0033 }
        r1 = com.duokan.reader.common.download.IDownloadTask.TaskStatus.PENDING;	 Catch:{ all -> 0x0033 }
        if (r0 != r1) goto L_0x0036;
    L_0x001f:
        r0 = com.duokan.reader.common.download.IDownloadTask.TaskStatus.RUNNING;	 Catch:{ all -> 0x0033 }
        r3.getPhysicalYPixels = r0;	 Catch:{ all -> 0x0033 }
        r3.QueryFeatureWrapper();	 Catch:{ all -> 0x0033 }
        r0 = r3.getPhysicalYPixels;	 Catch:{ all -> 0x0033 }
        r3.getVisible(r0);	 Catch:{ all -> 0x0033 }
        r0 = r3.B();	 Catch:{ all -> 0x0033 }
        if (r0 == 0) goto L_0x0036;
    L_0x0031:
        monitor-exit(r3);	 Catch:{ all -> 0x0033 }
        goto L_0x000e;
    L_0x0033:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0033 }
        throw r0;
    L_0x0036:
        r0 = r3.getHeightPixels;	 Catch:{ all -> 0x0033 }
        r1 = com.duokan.reader.common.download.DownloadTask.DownloadingStage.MULTI_BLOCK_PARALLEL_DOWNLOADING;	 Catch:{ all -> 0x0033 }
        if (r0 == r1) goto L_0x0046;
    L_0x003c:
        r0 = r3.IActivityRunStatusChanged;	 Catch:{ all -> 0x0033 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0033 }
        if (r0 != 0) goto L_0x0046;
    L_0x0044:
        monitor-exit(r3);	 Catch:{ all -> 0x0033 }
        goto L_0x000e;
    L_0x0046:
        r0 = r3.v;	 Catch:{ all -> 0x0033 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0033 }
        if (r0 != 0) goto L_0x0082;
    L_0x004e:
        r0 = r3.v;	 Catch:{ all -> 0x0033 }
        r0 = r0.getFirst();	 Catch:{ all -> 0x0033 }
        r0 = (com.duokan.reader.common.download.DownloadBlock) r0;	 Catch:{ all -> 0x0033 }
        r1 = r3.v;	 Catch:{ all -> 0x0033 }
        r1.remove(r0);	 Catch:{ all -> 0x0033 }
        r1 = r3.IActivityRunStatusChanged;	 Catch:{ all -> 0x0033 }
        r1.addLast(r0);	 Catch:{ all -> 0x0033 }
        r3.setDrawable(r0);	 Catch:{ all -> 0x0033 }
        monitor-exit(r3);	 Catch:{ all -> 0x0033 }
        r1 = r3.getHeightPixels;
        r0.setDrawable(r1);
        r1 = r3.n;
        r0.setDrawable(r1);
        monitor-enter(r3);
        r1 = TaskHandler;	 Catch:{ all -> 0x007f }
        if (r1 != 0) goto L_0x0084;
    L_0x0073:
        r1 = r3.getWidthPixels;	 Catch:{ all -> 0x007f }
        r2 = com.duokan.reader.common.download.IDownloadTask.TaskState.UNFINISHED;	 Catch:{ all -> 0x007f }
        if (r1 == r2) goto L_0x0084;
    L_0x0079:
        r0 = new java.lang.AssertionError;	 Catch:{ all -> 0x007f }
        r0.<init>();	 Catch:{ all -> 0x007f }
        throw r0;	 Catch:{ all -> 0x007f }
    L_0x007f:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x007f }
        throw r0;
    L_0x0082:
        monitor-exit(r3);	 Catch:{ all -> 0x0033 }
        goto L_0x000e;
    L_0x0084:
        r1 = r3.getHeightPixels;	 Catch:{ all -> 0x007f }
        r2 = com.duokan.reader.common.download.DownloadTask.DownloadingStage.MULTI_BLOCK_DOWNLOADING_HANDSHAKE;	 Catch:{ all -> 0x007f }
        if (r1 != r2) goto L_0x009a;
    L_0x008a:
        r1 = r0.HttpLogger;	 Catch:{ all -> 0x007f }
        r2 = com.duokan.reader.common.download.DownloadBlock.BlockState.FAILED;	 Catch:{ all -> 0x007f }
        if (r1 != r2) goto L_0x009a;
    L_0x0090:
        r0 = com.duokan.reader.common.download.DownloadTask.DownloadingStage.MONO_BLOCK_DOWNLOADING;	 Catch:{ all -> 0x007f }
        r3.getHeightPixels = r0;	 Catch:{ all -> 0x007f }
        r3.C();	 Catch:{ all -> 0x007f }
    L_0x0097:
        monitor-exit(r3);	 Catch:{ all -> 0x007f }
        goto L_0x0000;
    L_0x009a:
        r1 = r3.IActivityRunStatusChanged;	 Catch:{ all -> 0x007f }
        r1.remove(r0);	 Catch:{ all -> 0x007f }
        r1 = r0.setDrawable();	 Catch:{ all -> 0x007f }
        r2 = com.duokan.reader.common.download.DownloadBlock.BlockState.UNFINISHED;	 Catch:{ all -> 0x007f }
        if (r1 == r2) goto L_0x00b0;
    L_0x00a7:
        r1 = r3.MyContextWrapper;	 Catch:{ all -> 0x007f }
        r1.addLast(r0);	 Catch:{ all -> 0x007f }
    L_0x00ac:
        r3.B();	 Catch:{ all -> 0x007f }
        goto L_0x0097;
    L_0x00b0:
        r1 = r3.v;	 Catch:{ all -> 0x007f }
        r1.addLast(r0);	 Catch:{ all -> 0x007f }
        goto L_0x00ac;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.common.download.DownloadTask.onActivityResult():void");
    }

    private boolean B() {
        if (!this.v.isEmpty() || !this.w.isEmpty()) {
            return false;
        }
        if (this.k == DownloadingStage.MULTI_BLOCK_PARALLEL_DOWNLOADING) {
            ListIterator listIterator = this.x.listIterator();
            while (listIterator.hasNext()) {
                DownloadBlock downloadBlock = (DownloadBlock) listIterator.next();
                if (downloadBlock.a() == BlockState.FAILED) {
                    downloadBlock.b(BlockState.UNFINISHED);
                    downloadBlock.a(this.k);
                    this.v.add(downloadBlock);
                    listIterator.remove();
                }
            }
            if (!this.v.isEmpty()) {
                this.k = DownloadingStage.MULTI_BLOCK_SEQUENTIAL_DOWNLOADING;
            }
        }
        if (!this.v.isEmpty()) {
            return false;
        }
        a(o());
        this.i = TaskStatus.STOPPED;
        this.k = DownloadingStage.UNKNOWN;
        if (x()) {
            this.j = TaskState.FAILED;
            this.m = DownloadFailCode.UNKOWN;
        } else {
            boolean w = w();
            this.j = w ? TaskState.SUCCEEDED : TaskState.FAILED;
            this.m = w ? DownloadFailCode.NONE : DownloadFailCode.MD5_MISMATCH;
        }
        if (this.j == TaskState.SUCCEEDED) {
            this.s.c(LogLevel.EVENT, "", "download succeeded");
        } else {
            this.s.a(LogLevel.ERROR, "", "download failed(%s)", this.m.name());
        }
        this.l = System.currentTimeMillis();
        z();
        b(this.i);
        a(this.j);
        return true;
    }

    protected void s() {
        synchronized (this) {
            a(TaskStatus.STOPPED);
            this.i = TaskStatus.STOPPED;
            this.j = TaskState.UNFINISHED;
            C();
        }
    }

    private void C() {
        this.n = null;
        this.v.clear();
        this.w.clear();
        this.x.clear();
        this.r.beginTransaction();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("runtime_info", new JSONObject().toString());
            this.r.update("tasks", contentValues, "task_id=?", new String[]{"" + this.b});
            y();
            long a = a(0, 0, -1);
            if (t || a != -1) {
                b(b(a));
                this.r.setTransactionSuccessful();
                return;
            }
            throw new AssertionError();
        } finally {
            this.r.endTransaction();
        }
    }

    protected void a(TaskStatus taskStatus) {
        if (t || !(taskStatus == TaskStatus.RUNNING || taskStatus == TaskStatus.PENDING)) {
            synchronized (this) {
                if (this.j != TaskState.UNFINISHED) {
                    return;
                } else if (this.i == taskStatus) {
                    return;
                } else {
                    if (this.i == TaskStatus.RUNNING) {
                        Iterator it = this.w.iterator();
                        while (it.hasNext()) {
                            ((DownloadBlock) it.next()).e();
                        }
                    }
                    this.i = taskStatus;
                    this.k = DownloadingStage.UNKNOWN;
                    z();
                    a(-1);
                    b(this.i);
                    return;
                }
            }
        }
        throw new AssertionError();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void t() {
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = r2.getWidthPixels;	 Catch:{ all -> 0x0020 }
        r1 = com.duokan.reader.common.download.IDownloadTask.TaskState.SUCCEEDED;	 Catch:{ all -> 0x0020 }
        if (r0 != r1) goto L_0x0009;
    L_0x0007:
        monitor-exit(r2);	 Catch:{ all -> 0x0020 }
    L_0x0008:
        return;
    L_0x0009:
        r0 = r2.getWidthPixels;	 Catch:{ all -> 0x0020 }
        r1 = com.duokan.reader.common.download.IDownloadTask.TaskState.FAILED;	 Catch:{ all -> 0x0020 }
        if (r0 != r1) goto L_0x0012;
    L_0x000f:
        r2.s();	 Catch:{ all -> 0x0020 }
    L_0x0012:
        r0 = r2.getPhysicalYPixels;	 Catch:{ all -> 0x0020 }
        r1 = com.duokan.reader.common.download.IDownloadTask.TaskStatus.RUNNING;	 Catch:{ all -> 0x0020 }
        if (r0 == r1) goto L_0x001e;
    L_0x0018:
        r0 = r2.getPhysicalYPixels;	 Catch:{ all -> 0x0020 }
        r1 = com.duokan.reader.common.download.IDownloadTask.TaskStatus.PENDING;	 Catch:{ all -> 0x0020 }
        if (r0 != r1) goto L_0x0023;
    L_0x001e:
        monitor-exit(r2);	 Catch:{ all -> 0x0020 }
        goto L_0x0008;
    L_0x0020:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0020 }
        throw r0;
    L_0x0023:
        r0 = com.duokan.reader.common.download.IDownloadTask.TaskStatus.PENDING;	 Catch:{ all -> 0x0020 }
        r2.getPhysicalYPixels = r0;	 Catch:{ all -> 0x0020 }
        r0 = com.duokan.reader.common.download.DownloadTask.DownloadingStage.UNKNOWN;	 Catch:{ all -> 0x0020 }
        r2.getHeightPixels = r0;	 Catch:{ all -> 0x0020 }
        r2.QueryFeatureWrapper();	 Catch:{ all -> 0x0020 }
        r0 = r2.getPhysicalYPixels;	 Catch:{ all -> 0x0020 }
        r2.getVisible(r0);	 Catch:{ all -> 0x0020 }
        monitor-exit(r2);	 Catch:{ all -> 0x0020 }
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.common.download.DownloadTask.TaskHandler():void");
    }

    protected boolean u() {
        boolean z;
        synchronized (this) {
            z = this.w.size() < 4 && this.v.size() > 0 && this.k == DownloadingStage.MULTI_BLOCK_PARALLEL_DOWNLOADING;
        }
        return z;
    }

    protected void a(DownloadBlock downloadBlock) {
        if (t || downloadBlock != null) {
            v();
            if (!t && this.n == null && !this.v.isEmpty()) {
                throw new AssertionError();
            } else if (t || this.p != null) {
                downloadBlock.a(this.p);
                return;
            } else {
                throw new AssertionError();
            }
        }
        throw new AssertionError();
    }

    protected void b(DownloadBlock downloadBlock) {
        if (downloadBlock.a() != BlockState.UNFINISHED) {
            this.x.addLast(downloadBlock);
        } else {
            this.v.addLast(downloadBlock);
        }
    }

    protected void v() {
        if (this.o == null) {
            try {
                File file = new File(Uri.parse(this.f).getPath());
                File file2 = new File(file.getParent());
                if (file2 != null) {
                    file2.mkdirs();
                }
                if (t || (file2.isDirectory() && file2.exists())) {
                    this.o = new RandomAccessFile(file, "rws");
                    this.p = this.o.getChannel();
                    return;
                }
                throw new AssertionError();
            } catch (Exception e) {
                this.o = null;
                this.p = null;
            }
        } else if (!t && this.p == null) {
            throw new AssertionError();
        }
    }

    protected void a(long j) {
        if (this.o != null) {
            if (j >= 0) {
                try {
                    this.p.truncate(j);
                } catch (Exception e) {
                    this.o = null;
                    this.p = null;
                    return;
                } catch (Throwable th) {
                    this.o = null;
                    this.p = null;
                }
            }
            this.p.close();
            this.o.close();
            this.o = null;
            this.p = null;
        }
    }

    protected boolean w() {
        if (TextUtils.isEmpty(this.g) || o.a(this.f, this.g)) {
            return true;
        }
        return false;
    }

    protected boolean x() {
        Iterator it = this.x.iterator();
        while (it.hasNext()) {
            DownloadBlock downloadBlock = (DownloadBlock) it.next();
            if (!t && downloadBlock.a() == BlockState.UNFINISHED) {
                throw new AssertionError();
            } else if (downloadBlock.a() == BlockState.FAILED) {
                return true;
            }
        }
        return false;
    }

    protected void a(boolean z) {
        if (t || this.q != null) {
            this.q.a(this, z);
            return;
        }
        throw new AssertionError();
    }

    protected void a(long j, long j2) {
        if (t || this.q != null) {
            this.q.a(this, j, j2);
            return;
        }
        throw new AssertionError();
    }

    protected void b(TaskStatus taskStatus) {
        if (t || this.q != null) {
            this.q.a(this, taskStatus);
            return;
        }
        throw new AssertionError();
    }

    protected void a(TaskState taskState) {
        if (t || this.q != null) {
            this.q.a(this, taskState);
            return;
        }
        throw new AssertionError();
    }

    protected void y() {
        this.r.beginTransaction();
        try {
            this.r.delete("blocks", "task_id=?", new String[]{"" + this.b});
            this.r.setTransactionSuccessful();
        } finally {
            this.r.endTransaction();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected long a(int r7, long r8, long r10) {
        /*
        r6 = this;
        r2 = -1;
        r0 = TaskHandler;
        if (r0 != 0) goto L_0x0010;
    L_0x0006:
        r0 = r6.onActivityResult;
        if (r0 != 0) goto L_0x0010;
    L_0x000a:
        r0 = new java.lang.AssertionError;
        r0.<init>();
        throw r0;
    L_0x0010:
        r0 = r6.onActivityResult;
        r0.beginTransaction();
        r0 = new android.content.ContentValues;	 Catch:{ Exception -> 0x0071, all -> 0x0079 }
        r0.<init>();	 Catch:{ Exception -> 0x0071, all -> 0x0079 }
        r1 = "block_class";
        r4 = com.duokan.reader.common.download.HttpDownloadBlock.class;
        r4 = r4.getName();	 Catch:{ Exception -> 0x0071, all -> 0x0079 }
        r0.put(r1, r4);	 Catch:{ Exception -> 0x0071, all -> 0x0079 }
        r1 = "block_index";
        r4 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x0071, all -> 0x0079 }
        r0.put(r1, r4);	 Catch:{ Exception -> 0x0071, all -> 0x0079 }
        r1 = "block_offset";
        r4 = java.lang.Long.valueOf(r8);	 Catch:{ Exception -> 0x0071, all -> 0x0079 }
        r0.put(r1, r4);	 Catch:{ Exception -> 0x0071, all -> 0x0079 }
        r1 = "block_length";
        r4 = java.lang.Long.valueOf(r10);	 Catch:{ Exception -> 0x0071, all -> 0x0079 }
        r0.put(r1, r4);	 Catch:{ Exception -> 0x0071, all -> 0x0079 }
        r1 = "task_id";
        r4 = r6.getVisible;	 Catch:{ Exception -> 0x0071, all -> 0x0079 }
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x0071, all -> 0x0079 }
        r0.put(r1, r4);	 Catch:{ Exception -> 0x0071, all -> 0x0079 }
        r1 = "runtime_info";
        r4 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0071, all -> 0x0079 }
        r4.<init>();	 Catch:{ Exception -> 0x0071, all -> 0x0079 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0071, all -> 0x0079 }
        r0.put(r1, r4);	 Catch:{ Exception -> 0x0071, all -> 0x0079 }
        r1 = r6.onActivityResult;	 Catch:{ Exception -> 0x0071, all -> 0x0079 }
        r4 = "blocks";
        r5 = 0;
        r0 = r1.insert(r4, r5, r0);	 Catch:{ Exception -> 0x0071, all -> 0x0079 }
        r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r2 == 0) goto L_0x006b;
    L_0x0066:
        r2 = r6.onActivityResult;	 Catch:{ Exception -> 0x0080, all -> 0x0079 }
        r2.setTransactionSuccessful();	 Catch:{ Exception -> 0x0080, all -> 0x0079 }
    L_0x006b:
        r2 = r6.onActivityResult;
        r2.endTransaction();
    L_0x0070:
        return r0;
    L_0x0071:
        r0 = move-exception;
        r0 = r2;
    L_0x0073:
        r2 = r6.onActivityResult;
        r2.endTransaction();
        goto L_0x0070;
    L_0x0079:
        r0 = move-exception;
        r1 = r6.onActivityResult;
        r1.endTransaction();
        throw r0;
    L_0x0080:
        r2 = move-exception;
        goto L_0x0073;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.common.download.DownloadTask.setDrawable(int, long, long):long");
    }

    protected JSONObject A() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("task_status", this.i);
        jSONObject.put("task_state", this.j);
        jSONObject.put("finished_time", this.l);
        jSONObject.put("fail_code", this.m.toString());
        if (this.n != null) {
            jSONObject.put("handshake_result", a(this.n));
        }
        return jSONObject;
    }

    protected void b(JSONObject jSONObject) {
        this.i = TaskStatus.valueOf(jSONObject.getString("task_status"));
        this.j = TaskState.valueOf(jSONObject.getString("task_state"));
        this.l = jSONObject.optLong("finished_time", Long.MAX_VALUE);
        this.m = DownloadFailCode.valueOf(jSONObject.optString("fail_code", DownloadFailCode.NONE.toString()));
        if (!(this.i == TaskStatus.STOPPED || this.i == TaskStatus.PAUSED)) {
            this.i = TaskStatus.PENDING;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("handshake_result");
        if (optJSONObject != null) {
            c(optJSONObject);
        }
    }

    protected JSONObject a(c cVar) {
        if (t || cVar != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("download_length", cVar.a);
            jSONObject.put("supports_multiblocked", cVar.b);
            jSONObject.putOpt("content_type", cVar.c);
            jSONObject.putOpt("another_location", cVar.d);
            jSONObject.putOpt("redirect_location", cVar.e);
            jSONObject.putOpt("permanent_redirect_location", cVar.f);
            jSONObject.putOpt("suggested_target_name", cVar.g);
            return jSONObject;
        }
        throw new AssertionError();
    }

    protected void c(JSONObject jSONObject) {
        if (t || jSONObject != null) {
            if (this.n == null) {
                this.n = new c();
            }
            this.n.a = jSONObject.optLong("download_length", -1);
            this.n.b = jSONObject.optBoolean("supports_multiblocked", false);
            this.n.c = jSONObject.optString("content_type", null);
            this.n.d = jSONObject.optString("another_location", null);
            this.n.e = jSONObject.optString("redirect_location", null);
            this.n.f = jSONObject.optString("permanent_redirect_location", null);
            this.n.g = jSONObject.optString("suggested_target_name", null);
            return;
        }
        throw new AssertionError();
    }
}
