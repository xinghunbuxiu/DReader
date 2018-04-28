package com.duokan.reader.common.download;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;
import com.duokan.core.diagnostic.C0327f;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.sys.C0366o;
import com.duokan.reader.common.download.DownloadBlock.BlockState;
import com.duokan.reader.common.download.IDownloadTask.TaskState;
import com.duokan.reader.common.download.IDownloadTask.TaskStatus;
import com.duokan.reader.common.p037c.C0558e;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import org.json.JSONObject;

public abstract class DownloadTask implements IDownloadTask, C0591a {
    /* renamed from: t */
    static final /* synthetic */ boolean f1948t;
    /* renamed from: u */
    private static final String f1949u = DownloadTask.class.getName();
    /* renamed from: a */
    protected final Context f1950a;
    /* renamed from: b */
    protected final long f1951b;
    /* renamed from: c */
    protected final String f1952c;
    /* renamed from: d */
    protected final String f1953d;
    /* renamed from: e */
    protected final String f1954e;
    /* renamed from: f */
    protected final String f1955f;
    /* renamed from: g */
    protected final String f1956g;
    /* renamed from: h */
    protected JSONObject f1957h = null;
    /* renamed from: i */
    protected TaskStatus f1958i = TaskStatus.STOPPED;
    /* renamed from: j */
    protected TaskState f1959j = TaskState.UNFINISHED;
    /* renamed from: k */
    protected DownloadingStage f1960k = DownloadingStage.UNKNOWN;
    /* renamed from: l */
    protected long f1961l = 0;
    /* renamed from: m */
    protected DownloadFailCode f1962m = DownloadFailCode.NONE;
    /* renamed from: n */
    protected C0593c f1963n = null;
    /* renamed from: o */
    protected RandomAccessFile f1964o = null;
    /* renamed from: p */
    protected FileChannel f1965p = null;
    /* renamed from: q */
    protected final C0595l f1966q;
    /* renamed from: r */
    protected final SQLiteDatabase f1967r;
    /* renamed from: s */
    protected final C0327f f1968s;
    /* renamed from: v */
    private LinkedList<DownloadBlock> f1969v = new LinkedList();
    /* renamed from: w */
    private LinkedList<DownloadBlock> f1970w = new LinkedList();
    /* renamed from: x */
    private LinkedList<DownloadBlock> f1971x = new LinkedList();

    public enum DownloadingStage {
        UNKNOWN,
        MULTI_BLOCK_DOWNLOADING_HANDSHAKE,
        MULTI_BLOCK_PARALLEL_DOWNLOADING,
        MULTI_BLOCK_SEQUENTIAL_DOWNLOADING,
        MONO_BLOCK_DOWNLOADING
    }

    /* renamed from: b */
    protected abstract DownloadBlock mo805b(long j);

    /* renamed from: z */
    protected void m2734z() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0058 in list [B:7:0x004b, B:13:0x0040]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:43)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:60)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r10 = this;
        r0 = r10.f1967r;
        r0.beginTransaction();
        r0 = r10.m2690A();	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
        r1 = new android.content.ContentValues;	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
        r1.<init>();	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
        r2 = "runtime_info";	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
        r1.put(r2, r0);	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
        r0 = r10.f1967r;	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
        r2 = "tasks";	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
        r3 = "task_id=?";	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
        r4 = 1;	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
        r4 = new java.lang.String[r4];	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
        r5 = 0;	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
        r6.<init>();	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
        r7 = "";	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
        r6 = r6.append(r7);	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
        r8 = r10.f1951b;	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
        r6 = r6.append(r8);	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
        r6 = r6.toString();	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
        r4[r5] = r6;	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
        r0.update(r2, r1, r3, r4);	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
        r0 = r10.f1967r;	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
        r0.setTransactionSuccessful();	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
        r0 = r10.f1967r;
        r0.endTransaction();
    L_0x0045:
        return;
    L_0x0046:
        r0 = move-exception;
        r0 = f1948t;	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
        if (r0 != 0) goto L_0x0058;	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
    L_0x004b:
        r0 = new java.lang.AssertionError;	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
        r0.<init>();	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
        throw r0;	 Catch:{ Exception -> 0x0046, all -> 0x0051 }
    L_0x0051:
        r0 = move-exception;
        r1 = r10.f1967r;
        r1.endTransaction();
        throw r0;
    L_0x0058:
        r0 = r10.f1967r;
        r0.endTransaction();
        goto L_0x0045;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.common.download.DownloadTask.z():void");
    }

    static {
        boolean z;
        if (DownloadTask.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        f1948t = z;
    }

    protected DownloadTask(android.content.Context r13, long r14, android.database.sqlite.SQLiteDatabase r16, com.duokan.reader.common.download.C0595l r17, java.io.File r18) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:60)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r12 = this;
        r12.<init>();
        r2 = 0;
        r12.f1957h = r2;
        r2 = com.duokan.reader.common.download.IDownloadTask.TaskStatus.STOPPED;
        r12.f1958i = r2;
        r2 = com.duokan.reader.common.download.IDownloadTask.TaskState.UNFINISHED;
        r12.f1959j = r2;
        r2 = com.duokan.reader.common.download.DownloadTask.DownloadingStage.UNKNOWN;
        r12.f1960k = r2;
        r2 = 0;
        r12.f1961l = r2;
        r2 = com.duokan.reader.common.download.DownloadFailCode.NONE;
        r12.f1962m = r2;
        r2 = 0;
        r12.f1963n = r2;
        r2 = 0;
        r12.f1964o = r2;
        r2 = 0;
        r12.f1965p = r2;
        r2 = new java.util.LinkedList;
        r2.<init>();
        r12.f1969v = r2;
        r2 = new java.util.LinkedList;
        r2.<init>();
        r12.f1970w = r2;
        r2 = new java.util.LinkedList;
        r2.<init>();
        r12.f1971x = r2;
        r2 = f1948t;
        if (r2 != 0) goto L_0x0044;
    L_0x003c:
        if (r13 != 0) goto L_0x0044;
    L_0x003e:
        r2 = new java.lang.AssertionError;
        r2.<init>();
        throw r2;
    L_0x0044:
        r2 = f1948t;
        if (r2 != 0) goto L_0x0050;
    L_0x0048:
        if (r16 != 0) goto L_0x0050;
    L_0x004a:
        r2 = new java.lang.AssertionError;
        r2.<init>();
        throw r2;
    L_0x0050:
        r12.f1950a = r13;
        r0 = r16;
        r12.f1967r = r0;
        r12.f1951b = r14;
        r2 = r12.f1967r;
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
        r10 = r12.f1951b;
        r8 = r8.append(r10);
        r8 = r8.toString();
        r6[r7] = r8;
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r3 = r2.query(r3, r4, r5, r6, r7, r8, r9);
        r2 = f1948t;
        if (r2 != 0) goto L_0x008d;
    L_0x0085:
        if (r3 != 0) goto L_0x008d;
    L_0x0087:
        r2 = new java.lang.AssertionError;
        r2.<init>();
        throw r2;
    L_0x008d:
        r2 = f1948t;
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
        r12.f1952c = r2;
        r2 = "task_title";
        r2 = r3.getColumnIndex(r2);
        r2 = r3.getString(r2);
        r12.f1953d = r2;
        r2 = "source_uri";
        r2 = r3.getColumnIndex(r2);
        r2 = r3.getString(r2);
        r12.f1954e = r2;
        r2 = "target_uri";
        r2 = r3.getColumnIndex(r2);
        r2 = r3.getString(r2);
        r12.f1955f = r2;
        r2 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x01d0 }
        r4 = "user_value";	 Catch:{ JSONException -> 0x01d0 }
        r4 = r3.getColumnIndex(r4);	 Catch:{ JSONException -> 0x01d0 }
        r4 = r3.getString(r4);	 Catch:{ JSONException -> 0x01d0 }
        r2.<init>(r4);	 Catch:{ JSONException -> 0x01d0 }
        r12.f1957h = r2;	 Catch:{ JSONException -> 0x01d0 }
    L_0x00e1:
        r2 = "md5";
        r2 = r3.getColumnIndex(r2);
        r2 = r3.getString(r2);
        r12.f1956g = r2;
        r0 = r17;
        r12.f1966q = r0;
        r2 = new com.duokan.core.diagnostic.f;
        r2.<init>();
        r12.f1968s = r2;
        r2 = r12.f1968s;
        r4 = new java.io.File;
        r5 = java.util.Locale.getDefault();
        r6 = "dl.%d.%s.log";
        r7 = 2;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r10 = r12.f1951b;
        r9 = java.lang.Long.valueOf(r10);
        r7[r8] = r9;
        r8 = 1;
        r9 = r12.f1955f;
        r9 = android.net.Uri.parse(r9);
        r9 = r9.getLastPathSegment();
        r7[r8] = r9;
        r5 = java.lang.String.format(r5, r6, r7);
        r0 = r18;
        r4.<init>(r0, r5);
        r2.m750a(r4);
        r2 = new org.json.JSONObject;	 Catch:{ Exception -> 0x017e }
        r4 = "runtime_info";	 Catch:{ Exception -> 0x017e }
        r4 = r3.getColumnIndex(r4);	 Catch:{ Exception -> 0x017e }
        r4 = r3.getString(r4);	 Catch:{ Exception -> 0x017e }
        r2.<init>(r4);	 Catch:{ Exception -> 0x017e }
        r4 = r2.length();	 Catch:{ Exception -> 0x017e }
        if (r4 <= 0) goto L_0x013f;	 Catch:{ Exception -> 0x017e }
    L_0x013c:
        r12.m2709b(r2);	 Catch:{ Exception -> 0x017e }
    L_0x013f:
        r3.close();
    L_0x0142:
        r2 = r12.f1967r;
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
        r10 = r12.f1951b;
        r8 = r8.append(r10);
        r8 = r8.toString();
        r6[r7] = r8;
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r8 = r2.query(r3, r4, r5, r6, r7, r8, r9);
        r2 = f1948t;
        if (r2 != 0) goto L_0x0192;
    L_0x0176:
        if (r8 != 0) goto L_0x0192;
    L_0x0178:
        r2 = new java.lang.AssertionError;
        r2.<init>();
        throw r2;
    L_0x017e:
        r2 = move-exception;
        r2 = f1948t;	 Catch:{ all -> 0x0189 }
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
        r2 = r2.m2692a(r3, r4, r6);
        r4 = f1948t;
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
        r2 = r12.mo805b(r2);
        r12.m2707b(r2);
    L_0x01b9:
        r8.close();
        return;
    L_0x01bd:
        r2 = r8.moveToNext();
        if (r2 == 0) goto L_0x01b9;
    L_0x01c3:
        r2 = 0;
        r2 = r8.getLong(r2);
        r2 = r12.mo805b(r2);
        r12.m2707b(r2);
        goto L_0x01bd;
    L_0x01d0:
        r2 = move-exception;
        goto L_0x00e1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.common.download.DownloadTask.<init>(android.content.Context, long, android.database.sqlite.SQLiteDatabase, com.duokan.reader.common.download.l, java.io.File):void");
    }

    /* renamed from: a */
    public long m2691a() {
        return this.f1951b;
    }

    /* renamed from: b */
    public String mo790b() {
        return this.f1952c;
    }

    /* renamed from: c */
    public String m2710c() {
        return this.f1953d;
    }

    /* renamed from: d */
    public JSONObject mo791d() {
        return this.f1957h;
    }

    /* renamed from: a */
    public void mo789a(JSONObject jSONObject) {
        this.f1957h = jSONObject;
        this.f1967r.beginTransaction();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("user_value", this.f1957h.toString());
            this.f1967r.update("tasks", contentValues, "task_id=?", new String[]{"" + this.f1951b});
            this.f1967r.setTransactionSuccessful();
        } catch (Exception e) {
        } finally {
            this.f1967r.endTransaction();
        }
    }

    /* renamed from: e */
    public TaskStatus mo792e() {
        return this.f1958i;
    }

    /* renamed from: f */
    public TaskState mo793f() {
        return this.f1959j;
    }

    /* renamed from: g */
    public long mo794g() {
        return this.f1961l;
    }

    /* renamed from: h */
    public DownloadFailCode mo795h() {
        return this.f1962m;
    }

    /* renamed from: i */
    public String m2717i() {
        return this.f1954e;
    }

    /* renamed from: j */
    public String mo796j() {
        return this.f1955f;
    }

    /* renamed from: k */
    public String m2719k() {
        return this.f1956g;
    }

    /* renamed from: l */
    public long mo797l() {
        long j;
        synchronized (this) {
            Iterator it = this.f1970w.iterator();
            j = 0;
            while (it.hasNext()) {
                j = ((DownloadBlock) it.next()).m2665b() + j;
            }
        }
        return j;
    }

    /* renamed from: m */
    public long mo798m() {
        return this.f1963n != null ? this.f1963n.f1980a : -1;
    }

    /* renamed from: n */
    public float mo799n() {
        float f = 100.0f;
        synchronized (this) {
            long m = mo798m();
            long o = mo800o();
            if (m < 0) {
                f = 0.0f;
            } else if (m == 0) {
            } else {
                f = 100.0f * (((float) o) / ((float) m));
            }
        }
        return f;
    }

    /* renamed from: o */
    public long mo800o() {
        long j;
        synchronized (this) {
            j = 0;
            Iterator it = this.f1969v.iterator();
            while (it.hasNext()) {
                j += ((DownloadBlock) it.next()).m2668c();
            }
            it = this.f1970w.iterator();
            while (it.hasNext()) {
                j += ((DownloadBlock) it.next()).m2668c();
            }
            Iterator it2 = this.f1971x.iterator();
            while (it2.hasNext()) {
                j = ((DownloadBlock) it2.next()).m2668c() + j;
            }
        }
        return j;
    }

    /* renamed from: p */
    public String m2724p() {
        Uri parse = Uri.parse(this.f1954e);
        if (!(this.f1963n == null || this.f1963n.f1984e == null)) {
            parse = Uri.parse(this.f1963n.f1984e);
        }
        String a = C0558e.m2465a(parse.getLastPathSegment());
        if (a == null && this.f1963n != null && this.f1963n.f1986g != null && this.f1963n.f1986g.length() > 0) {
            a = C0558e.m2465a(this.f1963n.f1986g);
        }
        if (a == null && this.f1963n != null && this.f1963n.f1983d != null && this.f1963n.f1983d.length() > 0) {
            a = C0558e.m2465a(Uri.parse(this.f1963n.f1983d).getLastPathSegment());
        }
        if (!(a != null || this.f1963n == null || this.f1963n.f1982c == null)) {
            a = this.f1963n.f1982c;
        }
        return a != null ? a : "application/octet-stream";
    }

    /* renamed from: q */
    public C0327f m2725q() {
        return this.f1968s;
    }

    /* renamed from: a */
    public void m2702a(String str) {
    }

    /* renamed from: a */
    public void mo788a(DownloadBlock downloadBlock, C0593c c0593c, boolean z) {
        if (!f1948t && downloadBlock == null) {
            throw new AssertionError();
        } else if (f1948t || c0593c != null) {
            if (z) {
                try {
                    this.f1963n = c0593c;
                    long m = mo798m();
                    if (m >= 0) {
                        if (this.f1964o != null) {
                            this.f1964o.setLength(m);
                        }
                        int i = (this.f1960k == DownloadingStage.MULTI_BLOCK_DOWNLOADING_HANDSHAKE && c0593c.f1981b) ? 4 : 1;
                        int i2 = i;
                        while (i2 > 1 && m / ((long) i2) < 2097152) {
                            i2--;
                        }
                        if (f1948t || (i2 >= 1 && i2 <= 4)) {
                            long j = m / ((long) i2);
                            long j2 = (m / ((long) i2)) + (m % ((long) i2));
                            synchronized (this) {
                                this.f1967r.beginTransaction();
                                try {
                                    downloadBlock.m2658a(j);
                                    int i3 = 1;
                                    while (i3 < i2) {
                                        long a = m2692a(i3, ((long) i3) * j, i3 == i2 + -1 ? j2 : j);
                                        if (f1948t || a != -1) {
                                            m2707b(mo805b(a));
                                            i3++;
                                        } else {
                                            throw new AssertionError();
                                        }
                                    }
                                    m2734z();
                                    this.f1967r.setTransactionSuccessful();
                                    this.f1967r.endTransaction();
                                } catch (Throwable th) {
                                    this.f1967r.endTransaction();
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
            if (this.f1960k == DownloadingStage.MULTI_BLOCK_DOWNLOADING_HANDSHAKE) {
                this.f1960k = DownloadingStage.MULTI_BLOCK_PARALLEL_DOWNLOADING;
            }
            downloadBlock.m2661a(this.f1960k);
            m2704a(z);
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public void mo786a(DownloadBlock downloadBlock, long j, long j2) {
        if (!f1948t && downloadBlock == null) {
            throw new AssertionError();
        } else if (f1948t || j2 > 0) {
            m2695a(j, j2);
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public void mo787a(DownloadBlock downloadBlock, BlockState blockState) {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: r */
    protected void m2726r() {
        /*
        r3 = this;
    L_0x0000:
        monitor-enter(r3);
        r0 = r3.f1958i;	 Catch:{ all -> 0x0033 }
        r1 = com.duokan.reader.common.download.IDownloadTask.TaskStatus.PAUSED;	 Catch:{ all -> 0x0033 }
        if (r0 == r1) goto L_0x000d;
    L_0x0007:
        r0 = r3.f1958i;	 Catch:{ all -> 0x0033 }
        r1 = com.duokan.reader.common.download.IDownloadTask.TaskStatus.STOPPED;	 Catch:{ all -> 0x0033 }
        if (r0 != r1) goto L_0x000f;
    L_0x000d:
        monitor-exit(r3);	 Catch:{ all -> 0x0033 }
    L_0x000e:
        return;
    L_0x000f:
        r0 = r3.f1960k;	 Catch:{ all -> 0x0033 }
        r1 = com.duokan.reader.common.download.DownloadTask.DownloadingStage.UNKNOWN;	 Catch:{ all -> 0x0033 }
        if (r0 != r1) goto L_0x0019;
    L_0x0015:
        r0 = com.duokan.reader.common.download.DownloadTask.DownloadingStage.MULTI_BLOCK_DOWNLOADING_HANDSHAKE;	 Catch:{ all -> 0x0033 }
        r3.f1960k = r0;	 Catch:{ all -> 0x0033 }
    L_0x0019:
        r0 = r3.f1958i;	 Catch:{ all -> 0x0033 }
        r1 = com.duokan.reader.common.download.IDownloadTask.TaskStatus.PENDING;	 Catch:{ all -> 0x0033 }
        if (r0 != r1) goto L_0x0036;
    L_0x001f:
        r0 = com.duokan.reader.common.download.IDownloadTask.TaskStatus.RUNNING;	 Catch:{ all -> 0x0033 }
        r3.f1958i = r0;	 Catch:{ all -> 0x0033 }
        r3.m2734z();	 Catch:{ all -> 0x0033 }
        r0 = r3.f1958i;	 Catch:{ all -> 0x0033 }
        r3.m2708b(r0);	 Catch:{ all -> 0x0033 }
        r0 = r3.m2688B();	 Catch:{ all -> 0x0033 }
        if (r0 == 0) goto L_0x0036;
    L_0x0031:
        monitor-exit(r3);	 Catch:{ all -> 0x0033 }
        goto L_0x000e;
    L_0x0033:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0033 }
        throw r0;
    L_0x0036:
        r0 = r3.f1960k;	 Catch:{ all -> 0x0033 }
        r1 = com.duokan.reader.common.download.DownloadTask.DownloadingStage.MULTI_BLOCK_PARALLEL_DOWNLOADING;	 Catch:{ all -> 0x0033 }
        if (r0 == r1) goto L_0x0046;
    L_0x003c:
        r0 = r3.f1970w;	 Catch:{ all -> 0x0033 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0033 }
        if (r0 != 0) goto L_0x0046;
    L_0x0044:
        monitor-exit(r3);	 Catch:{ all -> 0x0033 }
        goto L_0x000e;
    L_0x0046:
        r0 = r3.f1969v;	 Catch:{ all -> 0x0033 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0033 }
        if (r0 != 0) goto L_0x0082;
    L_0x004e:
        r0 = r3.f1969v;	 Catch:{ all -> 0x0033 }
        r0 = r0.getFirst();	 Catch:{ all -> 0x0033 }
        r0 = (com.duokan.reader.common.download.DownloadBlock) r0;	 Catch:{ all -> 0x0033 }
        r1 = r3.f1969v;	 Catch:{ all -> 0x0033 }
        r1.remove(r0);	 Catch:{ all -> 0x0033 }
        r1 = r3.f1970w;	 Catch:{ all -> 0x0033 }
        r1.addLast(r0);	 Catch:{ all -> 0x0033 }
        r3.m2696a(r0);	 Catch:{ all -> 0x0033 }
        monitor-exit(r3);	 Catch:{ all -> 0x0033 }
        r1 = r3.f1960k;
        r0.m2661a(r1);
        r1 = r3.f1963n;
        r0.m2662a(r1);
        monitor-enter(r3);
        r1 = f1948t;	 Catch:{ all -> 0x007f }
        if (r1 != 0) goto L_0x0084;
    L_0x0073:
        r1 = r3.f1959j;	 Catch:{ all -> 0x007f }
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
        r1 = r3.f1960k;	 Catch:{ all -> 0x007f }
        r2 = com.duokan.reader.common.download.DownloadTask.DownloadingStage.MULTI_BLOCK_DOWNLOADING_HANDSHAKE;	 Catch:{ all -> 0x007f }
        if (r1 != r2) goto L_0x009a;
    L_0x008a:
        r1 = r0.f1938f;	 Catch:{ all -> 0x007f }
        r2 = com.duokan.reader.common.download.DownloadBlock.BlockState.FAILED;	 Catch:{ all -> 0x007f }
        if (r1 != r2) goto L_0x009a;
    L_0x0090:
        r0 = com.duokan.reader.common.download.DownloadTask.DownloadingStage.MONO_BLOCK_DOWNLOADING;	 Catch:{ all -> 0x007f }
        r3.f1960k = r0;	 Catch:{ all -> 0x007f }
        r3.m2689C();	 Catch:{ all -> 0x007f }
    L_0x0097:
        monitor-exit(r3);	 Catch:{ all -> 0x007f }
        goto L_0x0000;
    L_0x009a:
        r1 = r3.f1970w;	 Catch:{ all -> 0x007f }
        r1.remove(r0);	 Catch:{ all -> 0x007f }
        r1 = r0.m2657a();	 Catch:{ all -> 0x007f }
        r2 = com.duokan.reader.common.download.DownloadBlock.BlockState.UNFINISHED;	 Catch:{ all -> 0x007f }
        if (r1 == r2) goto L_0x00b0;
    L_0x00a7:
        r1 = r3.f1971x;	 Catch:{ all -> 0x007f }
        r1.addLast(r0);	 Catch:{ all -> 0x007f }
    L_0x00ac:
        r3.m2688B();	 Catch:{ all -> 0x007f }
        goto L_0x0097;
    L_0x00b0:
        r1 = r3.f1969v;	 Catch:{ all -> 0x007f }
        r1.addLast(r0);	 Catch:{ all -> 0x007f }
        goto L_0x00ac;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.common.download.DownloadTask.r():void");
    }

    /* renamed from: B */
    private boolean m2688B() {
        if (!this.f1969v.isEmpty() || !this.f1970w.isEmpty()) {
            return false;
        }
        if (this.f1960k == DownloadingStage.MULTI_BLOCK_PARALLEL_DOWNLOADING) {
            ListIterator listIterator = this.f1971x.listIterator();
            while (listIterator.hasNext()) {
                DownloadBlock downloadBlock = (DownloadBlock) listIterator.next();
                if (downloadBlock.m2657a() == BlockState.FAILED) {
                    downloadBlock.m2666b(BlockState.UNFINISHED);
                    downloadBlock.m2661a(this.f1960k);
                    this.f1969v.add(downloadBlock);
                    listIterator.remove();
                }
            }
            if (!this.f1969v.isEmpty()) {
                this.f1960k = DownloadingStage.MULTI_BLOCK_SEQUENTIAL_DOWNLOADING;
            }
        }
        if (!this.f1969v.isEmpty()) {
            return false;
        }
        m2694a(mo800o());
        this.f1958i = TaskStatus.STOPPED;
        this.f1960k = DownloadingStage.UNKNOWN;
        if (m2732x()) {
            this.f1959j = TaskState.FAILED;
            this.f1962m = DownloadFailCode.UNKOWN;
        } else {
            boolean w = m2731w();
            this.f1959j = w ? TaskState.SUCCEEDED : TaskState.FAILED;
            this.f1962m = w ? DownloadFailCode.NONE : DownloadFailCode.MD5_MISMATCH;
        }
        if (this.f1959j == TaskState.SUCCEEDED) {
            this.f1968s.m752c(LogLevel.EVENT, "", "download succeeded");
        } else {
            this.f1968s.m749a(LogLevel.ERROR, "", "download failed(%s)", this.f1962m.name());
        }
        this.f1961l = System.currentTimeMillis();
        m2734z();
        m2708b(this.f1958i);
        m2700a(this.f1959j);
        return true;
    }

    /* renamed from: s */
    protected void m2727s() {
        synchronized (this) {
            m2701a(TaskStatus.STOPPED);
            this.f1958i = TaskStatus.STOPPED;
            this.f1959j = TaskState.UNFINISHED;
            m2689C();
        }
    }

    /* renamed from: C */
    private void m2689C() {
        this.f1963n = null;
        this.f1969v.clear();
        this.f1970w.clear();
        this.f1971x.clear();
        this.f1967r.beginTransaction();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("runtime_info", new JSONObject().toString());
            this.f1967r.update("tasks", contentValues, "task_id=?", new String[]{"" + this.f1951b});
            m2733y();
            long a = m2692a(0, 0, -1);
            if (f1948t || a != -1) {
                m2707b(mo805b(a));
                this.f1967r.setTransactionSuccessful();
                return;
            }
            throw new AssertionError();
        } finally {
            this.f1967r.endTransaction();
        }
    }

    /* renamed from: a */
    protected void m2701a(TaskStatus taskStatus) {
        if (f1948t || !(taskStatus == TaskStatus.RUNNING || taskStatus == TaskStatus.PENDING)) {
            synchronized (this) {
                if (this.f1959j != TaskState.UNFINISHED) {
                    return;
                } else if (this.f1958i == taskStatus) {
                    return;
                } else {
                    if (this.f1958i == TaskStatus.RUNNING) {
                        Iterator it = this.f1970w.iterator();
                        while (it.hasNext()) {
                            ((DownloadBlock) it.next()).m2670e();
                        }
                    }
                    this.f1958i = taskStatus;
                    this.f1960k = DownloadingStage.UNKNOWN;
                    m2734z();
                    m2694a(-1);
                    m2708b(this.f1958i);
                    return;
                }
            }
        }
        throw new AssertionError();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: t */
    protected void m2728t() {
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = r2.f1959j;	 Catch:{ all -> 0x0020 }
        r1 = com.duokan.reader.common.download.IDownloadTask.TaskState.SUCCEEDED;	 Catch:{ all -> 0x0020 }
        if (r0 != r1) goto L_0x0009;
    L_0x0007:
        monitor-exit(r2);	 Catch:{ all -> 0x0020 }
    L_0x0008:
        return;
    L_0x0009:
        r0 = r2.f1959j;	 Catch:{ all -> 0x0020 }
        r1 = com.duokan.reader.common.download.IDownloadTask.TaskState.FAILED;	 Catch:{ all -> 0x0020 }
        if (r0 != r1) goto L_0x0012;
    L_0x000f:
        r2.m2727s();	 Catch:{ all -> 0x0020 }
    L_0x0012:
        r0 = r2.f1958i;	 Catch:{ all -> 0x0020 }
        r1 = com.duokan.reader.common.download.IDownloadTask.TaskStatus.RUNNING;	 Catch:{ all -> 0x0020 }
        if (r0 == r1) goto L_0x001e;
    L_0x0018:
        r0 = r2.f1958i;	 Catch:{ all -> 0x0020 }
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
        r2.f1958i = r0;	 Catch:{ all -> 0x0020 }
        r0 = com.duokan.reader.common.download.DownloadTask.DownloadingStage.UNKNOWN;	 Catch:{ all -> 0x0020 }
        r2.f1960k = r0;	 Catch:{ all -> 0x0020 }
        r2.m2734z();	 Catch:{ all -> 0x0020 }
        r0 = r2.f1958i;	 Catch:{ all -> 0x0020 }
        r2.m2708b(r0);	 Catch:{ all -> 0x0020 }
        monitor-exit(r2);	 Catch:{ all -> 0x0020 }
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.common.download.DownloadTask.t():void");
    }

    /* renamed from: u */
    protected boolean m2729u() {
        boolean z;
        synchronized (this) {
            z = this.f1970w.size() < 4 && this.f1969v.size() > 0 && this.f1960k == DownloadingStage.MULTI_BLOCK_PARALLEL_DOWNLOADING;
        }
        return z;
    }

    /* renamed from: a */
    protected void m2696a(DownloadBlock downloadBlock) {
        if (f1948t || downloadBlock != null) {
            m2730v();
            if (!f1948t && this.f1963n == null && !this.f1969v.isEmpty()) {
                throw new AssertionError();
            } else if (f1948t || this.f1965p != null) {
                downloadBlock.m2664a(this.f1965p);
                return;
            } else {
                throw new AssertionError();
            }
        }
        throw new AssertionError();
    }

    /* renamed from: b */
    protected void m2707b(DownloadBlock downloadBlock) {
        if (downloadBlock.m2657a() != BlockState.UNFINISHED) {
            this.f1971x.addLast(downloadBlock);
        } else {
            this.f1969v.addLast(downloadBlock);
        }
    }

    /* renamed from: v */
    protected void m2730v() {
        if (this.f1964o == null) {
            try {
                File file = new File(Uri.parse(this.f1955f).getPath());
                File file2 = new File(file.getParent());
                if (file2 != null) {
                    file2.mkdirs();
                }
                if (f1948t || (file2.isDirectory() && file2.exists())) {
                    this.f1964o = new RandomAccessFile(file, "rws");
                    this.f1965p = this.f1964o.getChannel();
                    return;
                }
                throw new AssertionError();
            } catch (Exception e) {
                this.f1964o = null;
                this.f1965p = null;
            }
        } else if (!f1948t && this.f1965p == null) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    protected void m2694a(long j) {
        if (this.f1964o != null) {
            if (j >= 0) {
                try {
                    this.f1965p.truncate(j);
                } catch (Exception e) {
                    this.f1964o = null;
                    this.f1965p = null;
                    return;
                } catch (Throwable th) {
                    this.f1964o = null;
                    this.f1965p = null;
                }
            }
            this.f1965p.close();
            this.f1964o.close();
            this.f1964o = null;
            this.f1965p = null;
        }
    }

    /* renamed from: w */
    protected boolean m2731w() {
        if (TextUtils.isEmpty(this.f1956g) || C0366o.m1032a(this.f1955f, this.f1956g)) {
            return true;
        }
        return false;
    }

    /* renamed from: x */
    protected boolean m2732x() {
        Iterator it = this.f1971x.iterator();
        while (it.hasNext()) {
            DownloadBlock downloadBlock = (DownloadBlock) it.next();
            if (!f1948t && downloadBlock.m2657a() == BlockState.UNFINISHED) {
                throw new AssertionError();
            } else if (downloadBlock.m2657a() == BlockState.FAILED) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    protected void m2704a(boolean z) {
        if (f1948t || this.f1966q != null) {
            this.f1966q.mo810a(this, z);
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    protected void m2695a(long j, long j2) {
        if (f1948t || this.f1966q != null) {
            this.f1966q.mo807a(this, j, j2);
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: b */
    protected void m2708b(TaskStatus taskStatus) {
        if (f1948t || this.f1966q != null) {
            this.f1966q.mo809a(this, taskStatus);
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    protected void m2700a(TaskState taskState) {
        if (f1948t || this.f1966q != null) {
            this.f1966q.mo808a(this, taskState);
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: y */
    protected void m2733y() {
        this.f1967r.beginTransaction();
        try {
            this.f1967r.delete("blocks", "task_id=?", new String[]{"" + this.f1951b});
            this.f1967r.setTransactionSuccessful();
        } finally {
            this.f1967r.endTransaction();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    protected long m2692a(int r7, long r8, long r10) {
        /*
        r6 = this;
        r2 = -1;
        r0 = f1948t;
        if (r0 != 0) goto L_0x0010;
    L_0x0006:
        r0 = r6.f1967r;
        if (r0 != 0) goto L_0x0010;
    L_0x000a:
        r0 = new java.lang.AssertionError;
        r0.<init>();
        throw r0;
    L_0x0010:
        r0 = r6.f1967r;
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
        r4 = r6.f1951b;	 Catch:{ Exception -> 0x0071, all -> 0x0079 }
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x0071, all -> 0x0079 }
        r0.put(r1, r4);	 Catch:{ Exception -> 0x0071, all -> 0x0079 }
        r1 = "runtime_info";
        r4 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0071, all -> 0x0079 }
        r4.<init>();	 Catch:{ Exception -> 0x0071, all -> 0x0079 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0071, all -> 0x0079 }
        r0.put(r1, r4);	 Catch:{ Exception -> 0x0071, all -> 0x0079 }
        r1 = r6.f1967r;	 Catch:{ Exception -> 0x0071, all -> 0x0079 }
        r4 = "blocks";
        r5 = 0;
        r0 = r1.insert(r4, r5, r0);	 Catch:{ Exception -> 0x0071, all -> 0x0079 }
        r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r2 == 0) goto L_0x006b;
    L_0x0066:
        r2 = r6.f1967r;	 Catch:{ Exception -> 0x0080, all -> 0x0079 }
        r2.setTransactionSuccessful();	 Catch:{ Exception -> 0x0080, all -> 0x0079 }
    L_0x006b:
        r2 = r6.f1967r;
        r2.endTransaction();
    L_0x0070:
        return r0;
    L_0x0071:
        r0 = move-exception;
        r0 = r2;
    L_0x0073:
        r2 = r6.f1967r;
        r2.endTransaction();
        goto L_0x0070;
    L_0x0079:
        r0 = move-exception;
        r1 = r6.f1967r;
        r1.endTransaction();
        throw r0;
    L_0x0080:
        r2 = move-exception;
        goto L_0x0073;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.common.download.DownloadTask.a(int, long, long):long");
    }

    /* renamed from: A */
    protected JSONObject m2690A() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("task_status", this.f1958i);
        jSONObject.put("task_state", this.f1959j);
        jSONObject.put("finished_time", this.f1961l);
        jSONObject.put("fail_code", this.f1962m.toString());
        if (this.f1963n != null) {
            jSONObject.put("handshake_result", mo804a(this.f1963n));
        }
        return jSONObject;
    }

    /* renamed from: b */
    protected void m2709b(JSONObject jSONObject) {
        this.f1958i = TaskStatus.valueOf(jSONObject.getString("task_status"));
        this.f1959j = TaskState.valueOf(jSONObject.getString("task_state"));
        this.f1961l = jSONObject.optLong("finished_time", Long.MAX_VALUE);
        this.f1962m = DownloadFailCode.valueOf(jSONObject.optString("fail_code", DownloadFailCode.NONE.toString()));
        if (!(this.f1958i == TaskStatus.STOPPED || this.f1958i == TaskStatus.PAUSED)) {
            this.f1958i = TaskStatus.PENDING;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("handshake_result");
        if (optJSONObject != null) {
            mo806c(optJSONObject);
        }
    }

    /* renamed from: a */
    protected JSONObject mo804a(C0593c c0593c) {
        if (f1948t || c0593c != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("download_length", c0593c.f1980a);
            jSONObject.put("supports_multiblocked", c0593c.f1981b);
            jSONObject.putOpt("content_type", c0593c.f1982c);
            jSONObject.putOpt("another_location", c0593c.f1983d);
            jSONObject.putOpt("redirect_location", c0593c.f1984e);
            jSONObject.putOpt("permanent_redirect_location", c0593c.f1985f);
            jSONObject.putOpt("suggested_target_name", c0593c.f1986g);
            return jSONObject;
        }
        throw new AssertionError();
    }

    /* renamed from: c */
    protected void mo806c(JSONObject jSONObject) {
        if (f1948t || jSONObject != null) {
            if (this.f1963n == null) {
                this.f1963n = new C0593c();
            }
            this.f1963n.f1980a = jSONObject.optLong("download_length", -1);
            this.f1963n.f1981b = jSONObject.optBoolean("supports_multiblocked", false);
            this.f1963n.f1982c = jSONObject.optString("content_type", null);
            this.f1963n.f1983d = jSONObject.optString("another_location", null);
            this.f1963n.f1984e = jSONObject.optString("redirect_location", null);
            this.f1963n.f1985f = jSONObject.optString("permanent_redirect_location", null);
            this.f1963n.f1986g = jSONObject.optString("suggested_target_name", null);
            return;
        }
        throw new AssertionError();
    }
}
