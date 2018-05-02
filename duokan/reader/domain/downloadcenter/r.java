package com.duokan.reader.domain.downloadcenter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;

import com.duokan.core.app.ah;
import com.duokan.core.app.ai;
import com.duokan.reader.common.download.IDownloadTask;
import com.duokan.reader.common.download.IDownloadTask.TaskState;
import com.duokan.reader.common.download.IDownloadTask.TaskStatus;
import com.duokan.reader.common.download.d;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.h;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.micloud.ba;
import com.duokan.reader.domain.micloud.bi;
import com.duokan.reader.domain.micloud.z;

import org.json.JSONObject;

import java.util.Iterator;
import java.util.LinkedList;

public class r implements ah, d, h {
    static final /* synthetic */ boolean a;
    private static final ai h = new ai();
    private final Context b;
    private final i c;
    private final String[] d;
    private LinkedList e = new LinkedList();
    private String f;
    private LinkedList g = new LinkedList();

    static {
        boolean z;
        if (r.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        a = z;
    }

    private r(Context context, i iVar, String[] strArr) {
        this.b = context;
        this.c = iVar;
        this.d = strArr;
        this.c.add((h) this);
        c();
    }

    public static void a(Context context, i iVar, String[] strArr) {
        h.a(new r(context, iVar, strArr));
    }

    public static r a() {
        return (r) h.a();
    }

    public void a(a aVar) {
        c();
    }

    public void b(a aVar) {
    }

    public void c(a aVar) {
        c();
    }

    public void d(a aVar) {
    }

    private void c() {
        if (this.c.b()) {
            if (TextUtils.isEmpty(this.f)) {
                this.f = this.c.c().c();
                synchronized (this) {
                    for (String a : this.d) {
                        Iterator it = ba.a(this.b, this.f, a).b().d().iterator();
                        while (it.hasNext()) {
                            this.g.add(new p(this.b, (z) it.next(), this));
                        }
                    }
                }
            }
        } else if (!TextUtils.isEmpty(this.f)) {
            ba.a(this.f);
            this.f = null;
        }
    }

    public void a(d dVar, Looper looper) {
        synchronized (this) {
            this.e.addLast(new Pair(dVar, looper));
        }
    }

    public void b(d dVar, Looper looper) {
        synchronized (this) {
            Iterator it = this.e.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                if (pair.first == dVar && pair.second == looper) {
                    this.e.remove(pair);
                    break;
                }
            }
        }
    }

    public p[] a(String str) {
        p[] pVarArr;
        synchronized (this) {
            LinkedList linkedList = new LinkedList();
            Iterator it = this.g.iterator();
            while (it.hasNext()) {
                p pVar = (p) it.next();
                if (pVar.b().equals(str)) {
                    linkedList.addLast(pVar);
                }
            }
            pVarArr = (p[]) linkedList.toArray(new p[0]);
        }
        return pVarArr;
    }

    public p a(String str, String str2, bi biVar, JSONObject jSONObject) {
        return new p(this.b, str, str2, biVar, jSONObject, this);
    }

    public void a(p pVar) {
        synchronized (this) {
            if (!this.g.contains(pVar)) {
                this.g.addLast(pVar);
            }
        }
        if (!TextUtils.isEmpty(this.f) && pVar.a().b().equals(this.f)) {
            pVar.c();
        }
    }

    public void a(p pVar, boolean z) {
        pVar.a(z);
    }

    public void b(p pVar) {
        pVar.i();
        synchronized (this) {
            this.g.remove(pVar);
        }
    }

    public boolean b() {
        boolean z;
        synchronized (this) {
            Iterator it = this.g.iterator();
            while (it.hasNext()) {
                TaskStatus e = ((p) it.next()).e();
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

    public void a(IDownloadTask iDownloadTask) {
        LinkedList linkedList = new LinkedList();
        synchronized (this) {
            linkedList.addAll(this.e);
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            d dVar = (d) pair.first;
            Looper looper = (Looper) pair.second;
            if (looper == null) {
                dVar.a(iDownloadTask);
            } else if (a || dVar != null) {
                new Handler(looper, new s(this, dVar, iDownloadTask)).sendEmptyMessage(0);
            } else {
                throw new AssertionError();
            }
        }
    }

    public void a(IDownloadTask iDownloadTask, TaskStatus taskStatus) {
        LinkedList linkedList = new LinkedList();
        synchronized (this) {
            linkedList.addAll(this.e);
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            d dVar = (d) pair.first;
            Looper looper = (Looper) pair.second;
            if (looper == null) {
                dVar.a(iDownloadTask, taskStatus);
            } else if (a || dVar != null) {
                new Handler(looper, new t(this, dVar, iDownloadTask, taskStatus)).sendEmptyMessage(0);
            } else {
                throw new AssertionError();
            }
        }
    }

    public void a(IDownloadTask iDownloadTask, TaskState taskState) {
        if (a || iDownloadTask != null) {
            LinkedList linkedList = new LinkedList();
            synchronized (this) {
                linkedList.addAll(this.e);
            }
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                d dVar = (d) pair.first;
                Looper looper = (Looper) pair.second;
                if (looper == null) {
                    dVar.a(iDownloadTask, taskState);
                } else if (a || dVar != null) {
                    new Handler(looper, new u(this, dVar, iDownloadTask, taskState)).sendEmptyMessage(0);
                } else {
                    throw new AssertionError();
                }
            }
            return;
        }
        throw new AssertionError();
    }
}
