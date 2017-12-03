package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;

import com.duokan.core.sys.TaskHandler;
import com.duokan.core.sys.j;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.webservices.duokan.v;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.cloud.DkCloudPurchasedBook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;

class bp extends ap {
    private final ab a;
    final /* synthetic */ aq b;
    private final List c;
    private final boolean d;
    private final jl e = new jl();
    private final jm f;
    private final ArrayList g;
    private final ArrayList h;
    private final iq i;

    public bp(aq aqVar, ab abVar, List list, boolean z, iq iqVar) {
        this.b = aqVar;
        this.a = abVar;
        this.c = list;
        this.d = z;
        this.e.a();
        this.f = new jm();
        this.f.a();
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.i = iqVar;
    }

    protected void onSessionTry() {
        int i;
        int i2;
        this.e.b();
        this.f.b();
        this.b.u();
        this.b.a(this.e);
        HashMap v = this.b.v();
        ArrayList arrayList = new ArrayList();
        if (ReaderEnv.get().isFirstCloudSync() && this.c.size() > 0) {
            ReaderEnv.get().setIsFirstCloudSync(false);
            c[] i3 = this.b.i();
            List arrayList2 = new ArrayList();
            for (c cVar : i3) {
                if (cVar.w() && cVar.E() == 0 && (cVar.k() || !cVar.ac())) {
                    arrayList2.add(cVar);
                }
            }
            this.b.b(arrayList2, true);
        }
        for (bu buVar : this.c) {
            bu buVar2;
            c cVar2 = (c) v.get(buVar2.b);
            if (buVar2.c() && cVar2 != null && !cVar2.a() && cVar2.ax() < buVar2.e && cVar2.z() < buVar2.e) {
                arrayList.add(cVar2);
            }
        }
        try {
            c cVar3;
            int i4;
            this.b.k.a();
            this.b.g.b();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                cVar3 = (c) it.next();
                this.b.a(cVar3);
                v.remove(cVar3.ap());
                this.h.add(cVar3);
            }
            this.b.g.f();
            this.b.g.c();
            this.b.k.b();
            List list = this.d ? this.f.b : this.c;
            LinkedList linkedList = new LinkedList();
            for (int i5 = 0; i5 < list.size(); i5++) {
                if (((bu) list.get(i5)).a == 0) {
                    DkCloudPurchasedBook a = this.e.a(((bu) list.get(i5)).b);
                    if (a != null) {
                        linkedList.add(a.getBookUuid());
                    }
                }
            }
            Map hashMap = new HashMap();
            if (!linkedList.isEmpty()) {
                String[] strArr = (String[]) new v(this, null).a((String[]) linkedList.toArray(new String[0])).a;
                Iterator it2 = linkedList.iterator();
                i4 = 0;
                while (it2.hasNext()) {
                    String str = (String) it2.next();
                    i2 = i4 + 1;
                    CharSequence charSequence = strArr[i4];
                    if (!TextUtils.isEmpty(charSequence)) {
                        hashMap.put(str, charSequence);
                    }
                    i4 = i2;
                }
            }
            i = 0;
            while (i < list.size()) {
                this.b.k.a();
                this.b.g.b();
                long currentTimeMillis = System.currentTimeMillis();
                i4 = i;
                while (i4 < list.size() && System.currentTimeMillis() - currentTimeMillis < 200) {
                    buVar2 = (bu) list.get(i4);
                    if (!buVar2.c()) {
                        cVar2 = (c) v.get(buVar2.b);
                        if (cVar2 == null) {
                            cVar2 = this.b.a(buVar2, this.e, hashMap, this.f);
                            if (cVar2 != null) {
                                v.put(buVar2.b, cVar2);
                            }
                        } else {
                            aa b = this.b.b(cVar2.aH());
                            if (cVar2.z() < buVar2.e && !b.k().equals(buVar2.c)) {
                                this.b.a(buVar2, cVar2);
                            }
                        }
                    }
                    i4++;
                }
                this.b.g.f();
                try {
                    this.b.g.c();
                    this.b.k.b();
                    this.b.x();
                    j.a(200);
                    Semaphore semaphore = new Semaphore(0);
                    TaskHandler.postTask(new bq(this, semaphore), 2000);
                    semaphore.acquireUninterruptibly();
                    i = i4;
                } catch (Throwable th) {
                    this.b.k.b();
                }
            }
            arrayList = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (c cVar32 : v.values()) {
                if (this.e.a(cVar32)) {
                    if (this.e.b(cVar32)) {
                        bu buVar3 = (bu) this.f.d.get(cVar32.ap());
                        if (buVar3 == null) {
                            this.g.add(ct.a(cVar32.ao(), cVar32.ap(), this.b.a((an) cVar32).k()));
                        } else {
                            aa b2 = this.b.b(cVar32.aH());
                            if (!b2.k().equals(buVar3.c)) {
                                this.g.add(ct.a(cVar32.ao(), cVar32.ap(), buVar3.c, b2.k()));
                            }
                        }
                    } else if (cVar32.i() == BookState.CLOUD_ONLY || (cVar32.ao() == 3 && cVar32.V())) {
                        arrayList.add(cVar32);
                        this.g.add(ct.a(cVar32.ao(), cVar32.ap()));
                    }
                } else if (cVar32.ak() != null) {
                    if (cVar32.i() != BookState.NORMAL) {
                        arrayList.add(cVar32);
                    } else {
                        cVar32.al();
                        arrayList3.add(cVar32);
                    }
                }
            }
            try {
                this.b.k.a();
                this.b.g.b();
                it = arrayList.iterator();
                while (it.hasNext()) {
                    cVar32 = (c) it.next();
                    this.b.a(cVar32);
                    v.remove(cVar32.ap());
                    this.h.add(cVar32);
                }
                it = arrayList3.iterator();
                while (it.hasNext()) {
                    ((c) it.next()).aL();
                }
                this.b.g.f();
                this.b.g.c();
                this.b.k.b();
                this.b.n();
            } catch (Throwable th2) {
                this.b.k.b();
            }
        } catch (Throwable th3) {
            this.b.k.b();
        }
    }

    protected void onSessionSucceeded() {
        if (!this.h.isEmpty()) {
            a.a(new ei(this.h, null), new Void[0]);
        }
        if (!this.a.a(this.b.j)) {
            return;
        }
        if (this.i == null || !this.i.isCancelled()) {
            bv.a().a(this.g);
        }
    }

    protected void onSessionFailed() {
    }
}
