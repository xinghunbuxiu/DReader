package com.duokan.reader.domain.micloud;

import android.content.Context;

import com.duokan.reader.common.async.work.IAsyncWorkProgressListener;
import com.duokan.reader.common.async.work.h;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ba {
    private static ag a;
    private static ThreadPoolExecutor b = new ThreadPoolExecutor(0, 1, 0, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private static ag c;
    private static ThreadPoolExecutor d = new ThreadPoolExecutor(0, 1, 0, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private static ae e;
    private static ThreadPoolExecutor f = new ThreadPoolExecutor(0, 1, 0, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private static final HashMap g = new HashMap();
    private final Context h;
    private final String i;
    private final String j;
    private final j k = new j(this.h, this.i, this.j, a.a(this.i, this.j), b);
    private final aa l = new aa(this.h, this.i, this.j, c.a(this.i, this.j), d);
    private final o m;

    public static synchronized void a(ag agVar, ag agVar2, ae aeVar) {
        synchronized (ba.class) {
            a = agVar;
            c = agVar2;
            e = aeVar;
        }
    }

    private ba(Context context, String str, String str2) {
        this.h = context.getApplicationContext();
        this.i = str;
        this.j = str2;
        this.m = new o(this.h, this.i, this.j, e.a(str, str2), f);
        this.k.a(new bb(this));
    }

    public static synchronized ba a(Context context, String str, String str2) {
        ba baVar;
        synchronized (ba.class) {
            HashMap hashMap;
            HashMap hashMap2 = (HashMap) g.get(str);
            if (hashMap2 == null) {
                hashMap2 = new HashMap();
                g.put(str, hashMap2);
                hashMap = hashMap2;
            } else {
                hashMap = hashMap2;
            }
            baVar = (ba) hashMap.get(str2);
            if (baVar == null) {
                baVar = new ba(context, str, str2);
                hashMap.put(str2, baVar);
            }
        }
        return baVar;
    }

    public static synchronized void a(String str, String str2) {
        synchronized (ba.class) {
            HashMap hashMap = (HashMap) g.get(str);
            if (hashMap != null) {
                ba baVar = (ba) hashMap.get(str2);
                if (baVar != null) {
                    baVar.e();
                    hashMap.remove(str2);
                    if (hashMap.size() == 0) {
                        g.remove(str);
                    }
                }
            }
        }
    }

    public static synchronized void a(String str) {
        synchronized (ba.class) {
            HashMap hashMap = (HashMap) g.get(str);
            if (hashMap != null) {
                for (String a : new LinkedHashSet(hashMap.keySet())) {
                    a(str, a);
                }
            }
        }
    }

    public j a() {
        return this.k;
    }

    public aa b() {
        return this.l;
    }

    public o c() {
        return this.m;
    }

    public m a(List list, boolean z, IAsyncWorkProgressListener iAsyncWorkProgressListener) {
        return b(list, z, new bc(this, iAsyncWorkProgressListener));
    }

    private m b(List list, boolean z, IAsyncWorkProgressListener iAsyncWorkProgressListener) {
        m mVar = new m(this.h, new n(this.i, this.j, list, z, 0), new h());
        mVar.a(new bd(this, iAsyncWorkProgressListener));
        mVar.a(f);
        return mVar;
    }

    public void d() {
        a(this.i, this.j);
    }

    private void e() {
        this.k.g();
        this.l.g();
        this.m.g();
    }
}
