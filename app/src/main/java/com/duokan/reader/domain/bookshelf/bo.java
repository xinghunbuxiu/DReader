package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;
import com.duokan.common.C0259a;
import com.duokan.core.sys.UIdleHandler;
import com.duokan.core.sys.UThread;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0647u;
import com.duokan.reader.domain.account.al;
import com.duokan.reader.domain.cloud.DkCloudPurchasedBook;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;

class bo extends WebSession {
    /* renamed from: a */
    private final al f2834a;
    /* renamed from: b */
    final /* synthetic */ ar f2835b;
    /* renamed from: c */
    private final List<bt> f2836c;
    /* renamed from: d */
    private final boolean f2837d;
    /* renamed from: e */
    private final jx f2838e = new jx();
    /* renamed from: f */
    private final jy f2839f;
    /* renamed from: g */
    private final ArrayList<cq> f2840g;
    /* renamed from: h */
    private final ArrayList<an> f2841h;
    /* renamed from: i */
    private final ik f2842i;

    public bo(ar arVar, al alVar, List<bt> list, boolean z, ik ikVar) {
        this.f2835b = arVar;
        super(aq.f2771a);
        this.f2834a = alVar;
        this.f2836c = list;
        this.f2837d = z;
        this.f2838e.m4783a();
        this.f2839f = new jy();
        this.f2839f.m4792a();
        this.f2840g = new ArrayList();
        this.f2841h = new ArrayList();
        this.f2842i = ikVar;
    }

    protected void onSessionTry() {
        int i;
        int i2;
        this.f2838e.m4787b();
        this.f2839f.m4793b();
        this.f2835b.m3946u();
        this.f2835b.m3891a(this.f2838e);
        HashMap v = this.f2835b.m3947v();
        ArrayList arrayList = new ArrayList();
        if (ReaderEnv.get().isFirstCloudSync() && this.f2836c.size() > 0) {
            ReaderEnv.get().setIsFirstCloudSync(false);
            C0800c[] i3 = this.f2835b.m3934i();
            List arrayList2 = new ArrayList();
            for (C0800c c0800c : i3) {
                if (c0800c.m4251w() && c0800c.m4153F() == 0 && (c0800c.mo1038k() || !c0800c.ae())) {
                    arrayList2.add(c0800c);
                }
            }
            this.f2835b.m3915b(arrayList2, true);
        }
        for (bt btVar : this.f2836c) {
            bt btVar2;
            C0800c c0800c2 = (C0800c) v.get(btVar2.f2858b);
            if (btVar2.m4070c() && c0800c2 != null && !c0800c2.m4204a() && c0800c2.az() < btVar2.f2861e && c0800c2.m4148A() < btVar2.f2861e) {
                arrayList.add(c0800c2);
            }
        }
        try {
            C0800c c0800c3;
            int i4;
            this.f2835b.k.mo1090a();
            this.f2835b.g.m677b();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                c0800c3 = (C0800c) it.next();
                this.f2835b.m3885a(c0800c3);
                v.remove(c0800c3.ar());
                this.f2841h.add(c0800c3);
            }
            this.f2835b.g.m681f();
            this.f2835b.g.m678c();
            this.f2835b.k.mo1096b();
            List list = this.f2837d ? this.f2839f.f3432b : this.f2836c;
            LinkedList linkedList = new LinkedList();
            for (int i5 = 0; i5 < list.size(); i5++) {
                if (((bt) list.get(i5)).f2857a == 0) {
                    DkCloudPurchasedBook a = this.f2838e.m4782a(((bt) list.get(i5)).f2858b);
                    if (a != null) {
                        linkedList.add(a.getBookUuid());
                    }
                }
            }
            Map hashMap = new HashMap();
            if (!linkedList.isEmpty()) {
                String[] strArr = (String[]) new C0647u(this, null).m3037a((String[]) linkedList.toArray(new String[0])).f2058a;
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
                this.f2835b.k.mo1090a();
                this.f2835b.g.m677b();
                long currentTimeMillis = System.currentTimeMillis();
                i4 = i;
                while (i4 < list.size() && System.currentTimeMillis() - currentTimeMillis < 200) {
                    btVar2 = (bt) list.get(i4);
                    if (!btVar2.m4070c()) {
                        c0800c2 = (C0800c) v.get(btVar2.f2858b);
                        if (c0800c2 == null) {
                            c0800c2 = this.f2835b.m3951a(btVar2, this.f2838e, hashMap, this.f2839f);
                            if (c0800c2 != null) {
                                v.put(btVar2.f2858b, c0800c2);
                            }
                        } else {
                            aa b = this.f2835b.m3904b(c0800c2.aJ());
                            if (c0800c2.m4148A() < btVar2.f2861e && !b.m3770k().equals(btVar2.f2859c)) {
                                this.f2835b.m3884a(btVar2, c0800c2);
                            }
                        }
                    }
                    i4++;
                }
                this.f2835b.g.m681f();
                try {
                    this.f2835b.g.m678c();
                    this.f2835b.k.mo1096b();
                    this.f2835b.m3949x();
                    UIdleHandler.sleep(200);
                    Semaphore semaphore = new Semaphore(0);
                    UThread.addIdleHandlerDelayed(new bp(this, semaphore), 2000);
                    semaphore.acquireUninterruptibly();
                    i = i4;
                } catch (Throwable th) {
                    this.f2835b.k.mo1096b();
                }
            }
            arrayList = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (C0800c c0800c32 : v.values()) {
                if (this.f2838e.m4785a(c0800c32)) {
                    if (this.f2838e.m4789b(c0800c32)) {
                        bt btVar3 = (bt) this.f2839f.f3434d.get(c0800c32.ar());
                        if (btVar3 == null) {
                            this.f2840g.add(cq.m4283a(c0800c32.aq(), c0800c32.ar(), this.f2835b.m3862a((an) c0800c32).m3770k()));
                        } else {
                            aa b2 = this.f2835b.m3904b(c0800c32.aJ());
                            if (!b2.m3770k().equals(btVar3.f2859c)) {
                                this.f2840g.add(cq.m4284a(c0800c32.aq(), c0800c32.ar(), btVar3.f2859c, b2.m3770k()));
                            }
                        }
                    } else if (c0800c32.m4233i() == BookState.CLOUD_ONLY || (c0800c32.aq() == 3 && c0800c32.m4171X())) {
                        arrayList.add(c0800c32);
                        this.f2840g.add(cq.m4282a(c0800c32.aq(), c0800c32.ar()));
                    }
                } else if (c0800c32.am() != null) {
                    if (c0800c32.m4233i() != BookState.NORMAL) {
                        arrayList.add(c0800c32);
                    } else {
                        c0800c32.an();
                        arrayList3.add(c0800c32);
                    }
                }
            }
            try {
                this.f2835b.k.mo1090a();
                this.f2835b.g.m677b();
                it = arrayList.iterator();
                while (it.hasNext()) {
                    c0800c32 = (C0800c) it.next();
                    this.f2835b.m3885a(c0800c32);
                    v.remove(c0800c32.ar());
                    this.f2841h.add(c0800c32);
                }
                it = arrayList3.iterator();
                while (it.hasNext()) {
                    ((C0800c) it.next()).aN();
                }
                this.f2835b.g.m681f();
                this.f2835b.g.m678c();
                this.f2835b.k.mo1096b();
                this.f2835b.m3939n();
            } catch (Throwable th2) {
                this.f2835b.k.mo1096b();
            }
        } catch (Throwable th3) {
            this.f2835b.k.mo1096b();
        }
    }

    protected void onSessionSucceeded() {
        if (!this.f2841h.isEmpty()) {
            C0259a.m568a(new ed(this.f2841h, null), new Void[0]);
        }
        if (!this.f2834a.m3365a(this.f2835b.j)) {
            return;
        }
        if (this.f2842i == null || !this.f2842i.isCancelled()) {
            bu.m4077a().m4110a(this.f2840g);
        }
    }

    protected void onSessionFailed() {
    }
}
