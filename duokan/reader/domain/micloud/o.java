package com.duokan.reader.domain.micloud;

import android.content.Context;

import com.duokan.reader.common.async.work.c;
import com.duokan.reader.common.async.work.h;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

public class o extends bg {
    private final ad a;
    private final ad b = new p(this);
    private final List c = new LinkedList();

    protected /* synthetic */ com.duokan.reader.common.async.work.o e(c cVar) {
        return a((bl) cVar);
    }

    public o(Context context, String str, String str2, ad adVar, ThreadPoolExecutor threadPoolExecutor) {
        super(context, str, str2, new h(), threadPoolExecutor);
        this.a = adVar;
        a(new q(this));
    }

    public void a(t tVar) {
        synchronized (this) {
            if (tVar != null) {
                if (!this.c.contains(tVar)) {
                    this.c.add(tVar);
                }
            }
        }
    }

    public void b(t tVar) {
        synchronized (this) {
            if (tVar != null) {
                this.c.remove(tVar);
            }
        }
    }

    public final bj i() {
        bj a;
        synchronized (this) {
            a = this.a.a();
        }
        return a;
    }

    public final Collection b(String str) {
        Collection b;
        synchronized (this) {
            b = this.a.b(str);
        }
        return b;
    }

    public final void a(bi biVar) {
        List<t> linkedList = new LinkedList();
        synchronized (this) {
            this.a.a(biVar);
            bj a = this.a.a();
            a.b -= biVar.j();
            a.c += biVar.j();
            this.a.a(a);
            linkedList.addAll(this.c);
        }
        for (t b : linkedList) {
            b.b(this, biVar);
        }
    }

    public final void b(bi biVar) {
        List<t> linkedList = new LinkedList();
        synchronized (this) {
            Collection arrayList = new ArrayList(1);
            arrayList.add(biVar);
            this.a.a(arrayList);
            bj a = this.a.a();
            a.b += biVar.j();
            a.c -= biVar.j();
            this.a.a(a);
            linkedList.addAll(this.c);
        }
        for (t a2 : linkedList) {
            a2.a(this, biVar);
        }
    }

    public final bl c(String str) {
        return (bl) a(new r(this, str));
    }

    public bl a(String str, boolean z, boolean z2, boolean z3, int i) {
        c c = c(str);
        if (c == null) {
            c = new bl(j(), k(), str, str, z, z2, z3, i);
        }
        bl blVar = (bl) c(c);
        a((c) blVar, new s(this));
        return blVar;
    }

    protected bk a(bl blVar) {
        return new bk(a(), blVar, this.b);
    }
}
