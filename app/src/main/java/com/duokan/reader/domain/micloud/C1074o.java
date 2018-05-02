package com.duokan.reader.domain.micloud;

import android.content.Context;
import com.duokan.reader.common.async.work.C0520o;
import com.duokan.reader.common.async.work.C0523c;
import com.duokan.reader.common.async.work.C0530h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* renamed from: com.duokan.reader.domain.micloud.o */
public class C1074o extends bg<bl, bk> {
    /* renamed from: a */
    private final ad f5292a;
    /* renamed from: b */
    private final ad f5293b = new C1075p(this);
    /* renamed from: c */
    private final List<C0812t> f5294c = new LinkedList();

    /* renamed from: e */
    protected /* synthetic */ C0520o mo1478e(C0523c c0523c) {
        return m8258a((bl) c0523c);
    }

    public C1074o(Context context, String str, String str2, ad adVar, ThreadPoolExecutor threadPoolExecutor) {
        super(context, str, str2, new C0530h(), threadPoolExecutor);
        this.f5292a = adVar;
        m2357a(new C1076q(this));
    }

    /* renamed from: a */
    public void m8261a(C0812t c0812t) {
        synchronized (this) {
            if (c0812t != null) {
                if (!this.f5294c.contains(c0812t)) {
                    this.f5294c.add(c0812t);
                }
            }
        }
    }

    /* renamed from: b */
    public void m8264b(C0812t c0812t) {
        synchronized (this) {
            if (c0812t != null) {
                this.f5294c.remove(c0812t);
            }
        }
    }

    /* renamed from: h */
    public final bj m8267h() {
        bj a;
        synchronized (this) {
            a = this.f5292a.mo1481a();
        }
        return a;
    }

    /* renamed from: b */
    public final Collection<bi> m8262b(String str) {
        Collection<bi> b;
        synchronized (this) {
            b = this.f5292a.mo1486b(str);
        }
        return b;
    }

    /* renamed from: a */
    public final void m8260a(bi biVar) {
        List<C0812t> linkedList = new LinkedList();
        synchronized (this) {
            this.f5292a.mo1482a(biVar);
            bj a = this.f5292a.mo1481a();
            a.f5252b -= biVar.m8160j();
            a.f5253c += biVar.m8160j();
            this.f5292a.mo1483a(a);
            linkedList.addAll(this.f5294c);
        }
        for (C0812t b : linkedList) {
            b.mo1111b(this, biVar);
        }
    }

    /* renamed from: b */
    public final void m8263b(bi biVar) {
        List<C0812t> linkedList = new LinkedList();
        synchronized (this) {
            Collection arrayList = new ArrayList(1);
            arrayList.add(biVar);
            this.f5292a.mo1485a(arrayList);
            bj a = this.f5292a.mo1481a();
            a.f5252b += biVar.m8160j();
            a.f5253c -= biVar.m8160j();
            this.f5292a.mo1483a(a);
            linkedList.addAll(this.f5294c);
        }
        for (C0812t a2 : linkedList) {
            a2.mo1109a(this, biVar);
        }
    }

    /* renamed from: c */
    public final bl m8265c(String str) {
        return (bl) m2355a(new C1077r(this, str));
    }

    /* renamed from: a */
    public bl m8259a(String str, boolean z, boolean z2, boolean z3, int i) {
        C0523c c = m8265c(str);
        if (c == null) {
            c = new bl(m8041i(), m8042j(), str, str, z, z2, z3, i);
        }
        bl blVar = (bl) m2367c(c);
        m2359a((C0523c) blVar, new C1078s(this));
        return blVar;
    }

    /* renamed from: a */
    protected bk m8258a(bl blVar) {
        return new bk(m2354a(), blVar, this.f5293b);
    }
}
