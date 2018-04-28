package com.duokan.reader.domain.micloud;

import android.content.Context;
import com.duokan.reader.common.async.work.C0530h;
import com.duokan.reader.common.async.work.IAsyncWorkProgressListener;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ba {
    /* renamed from: a */
    private static ag<C1068i> f5214a;
    /* renamed from: b */
    private static ThreadPoolExecutor f5215b = new ThreadPoolExecutor(0, 1, 0, TimeUnit.SECONDS, new LinkedBlockingQueue());
    /* renamed from: c */
    private static ag<C1084z> f5216c;
    /* renamed from: d */
    private static ThreadPoolExecutor f5217d = new ThreadPoolExecutor(0, 1, 0, TimeUnit.SECONDS, new LinkedBlockingQueue());
    /* renamed from: e */
    private static ae f5218e;
    /* renamed from: f */
    private static ThreadPoolExecutor f5219f = new ThreadPoolExecutor(0, 1, 0, TimeUnit.SECONDS, new LinkedBlockingQueue());
    /* renamed from: g */
    private static final HashMap<String, HashMap<String, ba>> f5220g = new HashMap();
    /* renamed from: h */
    private final Context f5221h;
    /* renamed from: i */
    private final String f5222i;
    /* renamed from: j */
    private final String f5223j;
    /* renamed from: k */
    private final C1069j f5224k = new C1069j(this.f5221h, this.f5222i, this.f5223j, f5214a.mo1477a(this.f5222i, this.f5223j), f5215b);
    /* renamed from: l */
    private final aa f5225l = new aa(this.f5221h, this.f5222i, this.f5223j, f5216c.mo1477a(this.f5222i, this.f5223j), f5217d);
    /* renamed from: m */
    private final C1074o f5226m;

    /* renamed from: a */
    public static synchronized void m8107a(ag<C1068i> agVar, ag<C1084z> agVar2, ae aeVar) {
        synchronized (ba.class) {
            f5214a = agVar;
            f5216c = agVar2;
            f5218e = aeVar;
        }
    }

    private ba(Context context, String str, String str2) {
        this.f5221h = context.getApplicationContext();
        this.f5222i = str;
        this.f5223j = str2;
        this.f5226m = new C1074o(this.f5221h, this.f5222i, this.f5223j, f5218e.mo1479a(str, str2), f5219f);
        this.f5224k.m2357a(new bb(this));
    }

    /* renamed from: a */
    public static synchronized ba m8105a(Context context, String str, String str2) {
        ba baVar;
        synchronized (ba.class) {
            HashMap hashMap;
            HashMap hashMap2 = (HashMap) f5220g.get(str);
            if (hashMap2 == null) {
                hashMap2 = new HashMap();
                f5220g.put(str, hashMap2);
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

    /* renamed from: a */
    public static synchronized void m8109a(String str, String str2) {
        synchronized (ba.class) {
            HashMap hashMap = (HashMap) f5220g.get(str);
            if (hashMap != null) {
                ba baVar = (ba) hashMap.get(str2);
                if (baVar != null) {
                    baVar.m8111e();
                    hashMap.remove(str2);
                    if (hashMap.size() == 0) {
                        f5220g.remove(str);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static synchronized void m8108a(String str) {
        synchronized (ba.class) {
            HashMap hashMap = (HashMap) f5220g.get(str);
            if (hashMap != null) {
                for (String a : new LinkedHashSet(hashMap.keySet())) {
                    m8109a(str, a);
                }
            }
        }
    }

    /* renamed from: a */
    public C1069j m8112a() {
        return this.f5224k;
    }

    /* renamed from: b */
    public aa m8114b() {
        return this.f5225l;
    }

    /* renamed from: c */
    public C1074o m8115c() {
        return this.f5226m;
    }

    /* renamed from: a */
    public C1072m m8113a(List<bi> list, boolean z, IAsyncWorkProgressListener<C1073n> iAsyncWorkProgressListener) {
        return m8110b(list, z, new bc(this, iAsyncWorkProgressListener));
    }

    /* renamed from: b */
    private C1072m m8110b(List<bi> list, boolean z, IAsyncWorkProgressListener<C1073n> iAsyncWorkProgressListener) {
        C1072m c1072m = new C1072m(this.f5221h, new C1073n(this.f5222i, this.f5223j, list, z, 0), new C0530h());
        c1072m.mo731a(new bd(this, iAsyncWorkProgressListener));
        c1072m.mo732a(f5219f);
        return c1072m;
    }

    /* renamed from: d */
    public void m8116d() {
        m8109a(this.f5222i, this.f5223j);
    }

    /* renamed from: e */
    private void m8111e() {
        this.f5224k.m2373f();
        this.f5225l.m2373f();
        this.f5226m.m2373f();
    }
}
