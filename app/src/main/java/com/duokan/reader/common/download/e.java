package com.duokan.reader.common.download;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;

import com.duokan.core.app.ah;
import com.duokan.core.app.ai;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.reader.common.download.IDownloadTask.TaskState;
import com.duokan.reader.common.download.IDownloadTask.TaskStatus;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

public class e extends Binder implements ah, l {
    static final /* synthetic */ boolean a = (!e.class.desiredAssertionStatus());
    private static final ai b = new ai();
    private final Context c;
    private CopyOnWriteArrayList d = new CopyOnWriteArrayList();
    private LinkedList e = new LinkedList();
    private LinkedList f = new LinkedList();
    private final SQLiteDatabase g;
    private final File h;

    protected e(Context context, File file) {
        if (a || context != null) {
            this.c = context;
            this.g = new b(this.c).getWritableDatabase();
            this.h = file;
            Cursor query = this.g.query("tasks", new String[]{"task_id"}, null, null, null, null, null);
            while (query.moveToNext()) {
                this.e.addLast(a(this.c, query.getLong(0), this.g, this));
            }
            query.close();
            c();
            return;
        }
        throw new AssertionError();
    }

    public boolean a() {
        boolean z;
        synchronized (this) {
            Iterator it = this.e.iterator();
            while (it.hasNext()) {
                TaskStatus e = ((DownloadTask) it.next()).e();
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

    public static void a(Context context, File file) {
        b.a(new e(context, file));
    }

    public static e b() {
        return (e) b.a();
    }

    public void a(d dVar, Looper looper) {
        this.d.add(new Pair(dVar, looper));
    }

    public void b(d dVar, Looper looper) {
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            if (pair.first == dVar && pair.second == looper) {
                this.d.remove(pair);
                return;
            }
        }
    }

    public DownloadTask[] a(String str) {
        DownloadTask[] downloadTaskArr;
        synchronized (this) {
            LinkedList linkedList = new LinkedList();
            Iterator it = this.e.iterator();
            while (it.hasNext()) {
                DownloadTask downloadTask = (DownloadTask) it.next();
                if (downloadTask.b().equals(str)) {
                    linkedList.addLast(downloadTask);
                }
            }
            downloadTaskArr = (DownloadTask[]) linkedList.toArray(new DownloadTask[0]);
        }
        return downloadTaskArr;
    }

    public DownloadTask a(k kVar) {
        long a = a(HttpDownloadTask.class.getName(), kVar.e, kVar.a, kVar.b, kVar.c, kVar.d, kVar.f);
        if (a || a != -1) {
            DownloadTask a2 = a(this.c, a, this.g, this);
            a2.q().a(LogLevel.EVENT, "", "download task created", String.format("title: %s\nsource uri: %s\ntarget uri: %s\nmd5: %s", new Object[]{a2.c(), a2.i(), a2.j(), a2.k()}));
            synchronized (this) {
                this.e.addLast(a2);
                Iterator it = this.f.iterator();
                while (it.hasNext()) {
                    ((j) it.next()).a = true;
                }
            }
            return a2;
        }
        throw new AssertionError();
    }

    public void a(DownloadTask downloadTask) {
        if (a || downloadTask != null) {
            synchronized (this) {
                this.g.beginTransaction();
                try {
                    downloadTask.s();
                    this.e.remove(downloadTask);
                    this.g.delete("tasks", "task_id=?", new String[]{"" + downloadTask.a()});
                    this.g.setTransactionSuccessful();
                    Iterator it = this.f.iterator();
                    while (it.hasNext()) {
                        ((j) it.next()).a = true;
                    }
                } finally {
                    this.g.endTransaction();
                }
            }
            return;
        }
        throw new AssertionError();
    }

    public void b(DownloadTask downloadTask) {
        downloadTask.t();
        c();
    }

    public void c(DownloadTask downloadTask) {
        downloadTask.a(TaskStatus.STOPPED);
    }

    public void d(DownloadTask downloadTask) {
        downloadTask.a(TaskStatus.PAUSED);
    }

    public void a(DownloadTask downloadTask, boolean z) {
        if (a || downloadTask != null) {
            c();
            return;
        }
        throw new AssertionError();
    }

    public void a(DownloadTask downloadTask, long j, long j2) {
        if (a || downloadTask != null) {
            Iterator it = this.d.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                d dVar = (d) pair.first;
                Looper looper = (Looper) pair.second;
                if (looper == null) {
                    dVar.a(downloadTask);
                } else if (a || dVar != null) {
                    new Handler(looper, new f(this, dVar, downloadTask)).sendEmptyMessage(0);
                } else {
                    throw new AssertionError();
                }
            }
            return;
        }
        throw new AssertionError();
    }

    public void a(DownloadTask downloadTask, TaskStatus taskStatus) {
        if (a || downloadTask != null) {
            Iterator it = this.d.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                d dVar = (d) pair.first;
                Looper looper = (Looper) pair.second;
                if (looper == null) {
                    dVar.a((IDownloadTask) downloadTask, taskStatus);
                } else if (a || dVar != null) {
                    new Handler(looper, new g(this, dVar, downloadTask, taskStatus)).sendEmptyMessage(0);
                } else {
                    throw new AssertionError();
                }
            }
            return;
        }
        throw new AssertionError();
    }

    public void a(DownloadTask downloadTask, TaskState taskState) {
        if (a || downloadTask != null) {
            Iterator it = this.d.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                d dVar = (d) pair.first;
                Looper looper = (Looper) pair.second;
                if (looper == null) {
                    dVar.a((IDownloadTask) downloadTask, taskState);
                } else if (a || dVar != null) {
                    new Handler(looper, new h(this, dVar, downloadTask, taskState)).sendEmptyMessage(0);
                } else {
                    throw new AssertionError();
                }
            }
            return;
        }
        throw new AssertionError();
    }

    protected void c() {
        synchronized (this) {
            if (this.f.size() < 4) {
                j jVar = new j();
                Thread thread = new Thread(new i(this, jVar));
                jVar.a = true;
                this.f.addLast(jVar);
                thread.start();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void a(com.duokan.reader.common.download.j r6) {
        /*
        r5 = this;
        r1 = 0;
        r0 = setDrawable;
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
        r2 = r6.setDrawable;	 Catch:{ all -> 0x005f }
        if (r2 == 0) goto L_0x0067;
    L_0x0013:
        r0 = r5.getScaledPagingTouchSlop;	 Catch:{ all -> 0x005f }
        r2 = r0.iterator();	 Catch:{ all -> 0x005f }
        r0 = 0;
        r6.setDrawable = r0;	 Catch:{ all -> 0x005f }
    L_0x001c:
        r0 = r2.hasNext();	 Catch:{ all -> 0x005f }
        if (r0 == 0) goto L_0x0069;
    L_0x0022:
        r0 = r2.next();	 Catch:{ all -> 0x005f }
        r0 = (com.duokan.reader.common.download.DownloadTask) r0;	 Catch:{ all -> 0x005f }
        r3 = r0.HttpLogger();	 Catch:{ all -> 0x005f }
        r4 = com.duokan.reader.common.download.IDownloadTask.TaskState.UNFINISHED;	 Catch:{ all -> 0x005f }
        if (r3 != r4) goto L_0x001c;
    L_0x0030:
        r3 = r0.getScaledPagingTouchSlop();	 Catch:{ all -> 0x005f }
        r4 = com.duokan.reader.common.download.IDownloadTask.TaskStatus.PENDING;	 Catch:{ all -> 0x005f }
        if (r3 == r4) goto L_0x0040;
    L_0x0038:
        r3 = r0.getScaledPagingTouchSlop();	 Catch:{ all -> 0x005f }
        r4 = com.duokan.reader.common.download.IDownloadTask.TaskStatus.RUNNING;	 Catch:{ all -> 0x005f }
        if (r3 != r4) goto L_0x001c;
    L_0x0040:
        if (r0 != 0) goto L_0x0049;
    L_0x0042:
        r0 = r5.HttpLogger;	 Catch:{ all -> 0x005f }
        r0.remove(r6);	 Catch:{ all -> 0x005f }
        monitor-exit(r5);	 Catch:{ all -> 0x005f }
        return;
    L_0x0049:
        monitor-exit(r5);	 Catch:{ all -> 0x005f }
        r3 = r0.u();
        if (r3 == 0) goto L_0x0053;
    L_0x0050:
        r5.showAnimation();
    L_0x0053:
        r3 = setDrawable;
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
        r0.onActivityResult();
        r0 = r2;
        goto L_0x000e;
    L_0x0067:
        r2 = r0;
        goto L_0x001c;
    L_0x0069:
        r0 = r1;
        goto L_0x0040;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.common.download.getScaledPagingTouchSlop.setDrawable(com.duokan.reader.common.download.getWidthPixels):void");
    }

    private DownloadTask a(Context context, long j, SQLiteDatabase sQLiteDatabase, l lVar) {
        try {
            return new HttpDownloadTask(context, j, sQLiteDatabase, lVar, this.h);
        } catch (Throwable e) {
            a.c().a(LogLevel.ERROR, "dm", "fail to create setDrawable new task.", e);
            return null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private long a(java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13) {
        /*
        r6 = this;
        r2 = -1;
        r0 = setDrawable;
        if (r0 != 0) goto L_0x0010;
    L_0x0006:
        r0 = r6.SessionTask;
        if (r0 != 0) goto L_0x0010;
    L_0x000a:
        r0 = new java.lang.AssertionError;
        r0.<init>();
        throw r0;
    L_0x0010:
        r0 = r6.SessionTask;
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
        r1 = r6.SessionTask;	 Catch:{ Exception -> 0x0063, all -> 0x006b }
        r4 = "tasks";
        r5 = 0;
        r0 = r1.insert(r4, r5, r0);	 Catch:{ Exception -> 0x0063, all -> 0x006b }
        r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r2 == 0) goto L_0x005d;
    L_0x0058:
        r2 = r6.SessionTask;	 Catch:{ Exception -> 0x0072, all -> 0x006b }
        r2.setTransactionSuccessful();	 Catch:{ Exception -> 0x0072, all -> 0x006b }
    L_0x005d:
        r2 = r6.SessionTask;
        r2.endTransaction();
    L_0x0062:
        return r0;
    L_0x0063:
        r0 = move-exception;
        r0 = r2;
    L_0x0065:
        r2 = r6.SessionTask;
        r2.endTransaction();
        goto L_0x0062;
    L_0x006b:
        r0 = move-exception;
        r1 = r6.SessionTask;
        r1.endTransaction();
        throw r0;
    L_0x0072:
        r2 = move-exception;
        goto L_0x0065;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.common.download.getScaledPagingTouchSlop.setDrawable(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):long");
    }
}
