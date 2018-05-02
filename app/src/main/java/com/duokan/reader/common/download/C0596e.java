package com.duokan.reader.common.download;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import com.duokan.core.app.ai;
import com.duokan.core.app.aj;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.reader.common.download.IDownloadTask.TaskState;
import com.duokan.reader.common.download.IDownloadTask.TaskStatus;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.duokan.reader.common.download.e */
public class C0596e extends Binder implements ai, C0595l {
    /* renamed from: a */
    static final /* synthetic */ boolean f1987a = (!C0596e.class.desiredAssertionStatus());
    /* renamed from: b */
    private static final aj<C0596e> f1988b = new aj();
    /* renamed from: c */
    private final Context f1989c;
    /* renamed from: d */
    private CopyOnWriteArrayList<Pair<C0594d, Looper>> f1990d = new CopyOnWriteArrayList();
    /* renamed from: e */
    private LinkedList<DownloadTask> f1991e = new LinkedList();
    /* renamed from: f */
    private LinkedList<C0601j> f1992f = new LinkedList();
    /* renamed from: g */
    private final SQLiteDatabase f1993g;
    /* renamed from: h */
    private final File f1994h;

    protected C0596e(Context context, File file) {
        if (f1987a || context != null) {
            this.f1989c = context;
            this.f1993g = new C0592b(this.f1989c).getWritableDatabase();
            this.f1994h = file;
            Cursor query = this.f1993g.query("tasks", new String[]{"task_id"}, null, null, null, null, null);
            while (query.moveToNext()) {
                this.f1991e.addLast(m2755a(this.f1989c, query.getLong(0), this.f1993g, this));
            }
            query.close();
            m2770c();
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public boolean m2766a() {
        boolean z;
        synchronized (this) {
            Iterator it = this.f1991e.iterator();
            while (it.hasNext()) {
                TaskStatus e = ((DownloadTask) it.next()).mo792e();
                if (e != TaskStatus.RUNNING) {
                    if (e == TaskStatus.PENDING) {
                    }
                }
                z = true;
            }
            z = false;
        }
        return z;
    }

    /* renamed from: a */
    public static void m2756a(Context context, File file) {
        f1988b.m709a(new C0596e(context, file));
    }

    /* renamed from: b */
    public static C0596e m2757b() {
        return (C0596e) f1988b.m707a();
    }

    /* renamed from: a */
    public void m2764a(C0594d c0594d, Looper looper) {
        this.f1990d.add(new Pair(c0594d, looper));
    }

    /* renamed from: b */
    public void m2769b(C0594d c0594d, Looper looper) {
        Iterator it = this.f1990d.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            if (pair.first == c0594d && pair.second == looper) {
                this.f1990d.remove(pair);
                return;
            }
        }
    }

    /* renamed from: a */
    public DownloadTask[] m2767a(String str) {
        DownloadTask[] downloadTaskArr;
        synchronized (this) {
            LinkedList linkedList = new LinkedList();
            Iterator it = this.f1991e.iterator();
            while (it.hasNext()) {
                DownloadTask downloadTask = (DownloadTask) it.next();
                if (downloadTask.mo790b().equals(str)) {
                    linkedList.addLast(downloadTask);
                }
            }
            downloadTaskArr = (DownloadTask[]) linkedList.toArray(new DownloadTask[0]);
        }
        return downloadTaskArr;
    }

    /* renamed from: a */
    public DownloadTask m2758a(C0602k c0602k) {
        long a = m2754a(HttpDownloadTask.class.getName(), c0602k.f2013e, c0602k.f2009a, c0602k.f2010b, c0602k.f2011c, c0602k.f2012d, c0602k.f2014f);
        if (f1987a || a != -1) {
            DownloadTask a2 = m2755a(this.f1989c, a, this.f1993g, this);
            a2.m2725q().print(LogLevel.EVENT, "", "download task created", String.format("title: %s\nsource uri: %s\ntarget uri: %s\nmd5: %s", new Object[]{a2.m2710c(), a2.m2717i(), a2.mo796j(), a2.m2719k()}));
            synchronized (this) {
                this.f1991e.addLast(a2);
                Iterator it = this.f1992f.iterator();
                while (it.hasNext()) {
                    ((C0601j) it.next()).f2008a = true;
                }
            }
            return a2;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public void m2759a(DownloadTask downloadTask) {
        if (f1987a || downloadTask != null) {
            synchronized (this) {
                this.f1993g.beginTransaction();
                try {
                    downloadTask.m2727s();
                    this.f1991e.remove(downloadTask);
                    this.f1993g.delete("tasks", "task_id=?", new String[]{"" + downloadTask.m2691a()});
                    this.f1993g.setTransactionSuccessful();
                    Iterator it = this.f1992f.iterator();
                    while (it.hasNext()) {
                        ((C0601j) it.next()).f2008a = true;
                    }
                } finally {
                    this.f1993g.endTransaction();
                }
            }
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: b */
    public void m2768b(DownloadTask downloadTask) {
        downloadTask.m2728t();
        m2770c();
    }

    /* renamed from: c */
    public void m2771c(DownloadTask downloadTask) {
        downloadTask.m2701a(TaskStatus.STOPPED);
    }

    /* renamed from: d */
    public void m2772d(DownloadTask downloadTask) {
        downloadTask.m2701a(TaskStatus.PAUSED);
    }

    /* renamed from: a */
    public void mo810a(DownloadTask downloadTask, boolean z) {
        if (f1987a || downloadTask != null) {
            m2770c();
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public void mo807a(DownloadTask downloadTask, long j, long j2) {
        if (f1987a || downloadTask != null) {
            Iterator it = this.f1990d.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                C0594d c0594d = (C0594d) pair.first;
                Looper looper = (Looper) pair.second;
                if (looper == null) {
                    c0594d.mo1471a(downloadTask);
                } else if (f1987a || c0594d != null) {
                    new Handler(looper, new C0597f(this, c0594d, downloadTask)).sendEmptyMessage(0);
                } else {
                    throw new AssertionError();
                }
            }
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public void mo809a(DownloadTask downloadTask, TaskStatus taskStatus) {
        if (f1987a || downloadTask != null) {
            Iterator it = this.f1990d.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                C0594d c0594d = (C0594d) pair.first;
                Looper looper = (Looper) pair.second;
                if (looper == null) {
                    c0594d.mo1473a((IDownloadTask) downloadTask, taskStatus);
                } else if (f1987a || c0594d != null) {
                    new Handler(looper, new C0598g(this, c0594d, downloadTask, taskStatus)).sendEmptyMessage(0);
                } else {
                    throw new AssertionError();
                }
            }
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public void mo808a(DownloadTask downloadTask, TaskState taskState) {
        if (f1987a || downloadTask != null) {
            Iterator it = this.f1990d.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                C0594d c0594d = (C0594d) pair.first;
                Looper looper = (Looper) pair.second;
                if (looper == null) {
                    c0594d.mo1472a((IDownloadTask) downloadTask, taskState);
                } else if (f1987a || c0594d != null) {
                    new Handler(looper, new C0599h(this, c0594d, downloadTask, taskState)).sendEmptyMessage(0);
                } else {
                    throw new AssertionError();
                }
            }
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: c */
    protected void m2770c() {
        synchronized (this) {
            if (this.f1992f.size() < 4) {
                C0601j c0601j = new C0601j();
                Thread thread = new Thread(new C0600i(this, c0601j));
                c0601j.f2008a = true;
                this.f1992f.addLast(c0601j);
                thread.start();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    protected void m2765a(com.duokan.reader.common.download.C0601j r6) {
        /*
        r5 = this;
        r1 = 0;
        r0 = f1987a;
        if (r0 != 0) goto L_0x000d;
    L_0x0005:
        if (r6 != 0) goto L_0x000d;
    L_0x0007:
        r0 = new java.lang.AssertionError;
        r0.<init>();
        throw r0;
    L_0x000d:
        r0 = r1;
    L_0x000e:
        monitor-enter(r5);
        r2 = r6.f2008a;	 Catch:{ all -> 0x005f }
        if (r2 == 0) goto L_0x0067;
    L_0x0013:
        r0 = r5.f1991e;	 Catch:{ all -> 0x005f }
        r2 = r0.iterator();	 Catch:{ all -> 0x005f }
        r0 = 0;
        r6.f2008a = r0;	 Catch:{ all -> 0x005f }
    L_0x001c:
        r0 = r2.hasNext();	 Catch:{ all -> 0x005f }
        if (r0 == 0) goto L_0x0069;
    L_0x0022:
        r0 = r2.next();	 Catch:{ all -> 0x005f }
        r0 = (com.duokan.reader.common.download.DownloadTask) r0;	 Catch:{ all -> 0x005f }
        r3 = r0.mo793f();	 Catch:{ all -> 0x005f }
        r4 = com.duokan.reader.common.download.IDownloadTask.TaskState.UNFINISHED;	 Catch:{ all -> 0x005f }
        if (r3 != r4) goto L_0x001c;
    L_0x0030:
        r3 = r0.mo792e();	 Catch:{ all -> 0x005f }
        r4 = com.duokan.reader.common.download.IDownloadTask.TaskStatus.PENDING;	 Catch:{ all -> 0x005f }
        if (r3 == r4) goto L_0x0040;
    L_0x0038:
        r3 = r0.mo792e();	 Catch:{ all -> 0x005f }
        r4 = com.duokan.reader.common.download.IDownloadTask.TaskStatus.RUNNING;	 Catch:{ all -> 0x005f }
        if (r3 != r4) goto L_0x001c;
    L_0x0040:
        if (r0 != 0) goto L_0x0049;
    L_0x0042:
        r0 = r5.f1992f;	 Catch:{ all -> 0x005f }
        r0.remove(r6);	 Catch:{ all -> 0x005f }
        monitor-exit(r5);	 Catch:{ all -> 0x005f }
        return;
    L_0x0049:
        monitor-exit(r5);	 Catch:{ all -> 0x005f }
        r3 = r0.m2729u();
        if (r3 == 0) goto L_0x0053;
    L_0x0050:
        r5.m2770c();
    L_0x0053:
        r3 = f1987a;
        if (r3 != 0) goto L_0x0062;
    L_0x0057:
        if (r0 != 0) goto L_0x0062;
    L_0x0059:
        r0 = new java.lang.AssertionError;
        r0.<init>();
        throw r0;
    L_0x005f:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x005f }
        throw r0;
    L_0x0062:
        r0.m2726r();
        r0 = r2;
        goto L_0x000e;
    L_0x0067:
        r2 = r0;
        goto L_0x001c;
    L_0x0069:
        r0 = r1;
        goto L_0x0040;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.common.download.e.a(com.duokan.reader.common.download.j):void");
    }

    /* renamed from: a */
    private DownloadTask m2755a(Context context, long j, SQLiteDatabase sQLiteDatabase, C0595l c0595l) {
        try {
            return new HttpDownloadTask(context, j, sQLiteDatabase, c0595l, this.f1994h);
        } catch (Throwable e) {
            WebLog.init().printStackTrace(LogLevel.ERROR, "dm", "fail to create a new task.", e);
            return null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private long m2754a(java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13) {
        /*
        r6 = this;
        r2 = -1;
        r0 = f1987a;
        if (r0 != 0) goto L_0x0010;
    L_0x0006:
        r0 = r6.f1993g;
        if (r0 != 0) goto L_0x0010;
    L_0x000a:
        r0 = new java.lang.AssertionError;
        r0.<init>();
        throw r0;
    L_0x0010:
        r0 = r6.f1993g;
        r0.beginTransaction();
        r0 = new android.content.ContentValues;	 Catch:{ Exception -> 0x0063, all -> 0x006b }
        r0.<init>();	 Catch:{ Exception -> 0x0063, all -> 0x006b }
        r1 = "task_class";
        r0.put(r1, r7);	 Catch:{ Exception -> 0x0063, all -> 0x006b }
        r1 = "task_tag";
        r0.put(r1, r8);	 Catch:{ Exception -> 0x0063, all -> 0x006b }
        r1 = "task_title";
        r0.put(r1, r9);	 Catch:{ Exception -> 0x0063, all -> 0x006b }
        r1 = "source_uri";
        r0.put(r1, r10);	 Catch:{ Exception -> 0x0063, all -> 0x006b }
        r1 = "target_uri";
        r0.put(r1, r11);	 Catch:{ Exception -> 0x0063, all -> 0x006b }
        r1 = "runtime_info";
        r4 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0063, all -> 0x006b }
        r4.<init>();	 Catch:{ Exception -> 0x0063, all -> 0x006b }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0063, all -> 0x006b }
        r0.put(r1, r4);	 Catch:{ Exception -> 0x0063, all -> 0x006b }
        r1 = "user_value";
        r0.put(r1, r13);	 Catch:{ Exception -> 0x0063, all -> 0x006b }
        r1 = "md5";
        r0.put(r1, r12);	 Catch:{ Exception -> 0x0063, all -> 0x006b }
        r1 = r6.f1993g;	 Catch:{ Exception -> 0x0063, all -> 0x006b }
        r4 = "tasks";
        r5 = 0;
        r0 = r1.insert(r4, r5, r0);	 Catch:{ Exception -> 0x0063, all -> 0x006b }
        r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r2 == 0) goto L_0x005d;
    L_0x0058:
        r2 = r6.f1993g;	 Catch:{ Exception -> 0x0072, all -> 0x006b }
        r2.setTransactionSuccessful();	 Catch:{ Exception -> 0x0072, all -> 0x006b }
    L_0x005d:
        r2 = r6.f1993g;
        r2.endTransaction();
    L_0x0062:
        return r0;
    L_0x0063:
        r0 = move-exception;
        r0 = r2;
    L_0x0065:
        r2 = r6.f1993g;
        r2.endTransaction();
        goto L_0x0062;
    L_0x006b:
        r0 = move-exception;
        r1 = r6.f1993g;
        r1.endTransaction();
        throw r0;
    L_0x0072:
        r2 = move-exception;
        goto L_0x0065;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.common.download.e.a(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):long");
    }
}
