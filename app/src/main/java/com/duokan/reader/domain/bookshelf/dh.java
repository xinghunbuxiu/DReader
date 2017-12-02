package com.duokan.reader.domain.bookshelf;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Pair;

import com.duokan.core.app.ah;
import com.duokan.core.app.ai;
import com.duokan.reader.DkApp;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.account.i;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"UseSparseArrays"})
public class dh implements ah {
    private static final ai a = new ai();
    private final Context b;
    private ab c;
    private ea d = new ea();
    private boolean e = true;
    private long f = System.currentTimeMillis();
    private final LinkedList g = new LinkedList();
    private final LinkedList h = new LinkedList();

    public static void a(Context context) {
        a.a(new dh(context));
    }

    public static dh a() {
        return (dh) a.a();
    }

    private dh(Context context) {
        this.b = context;
        this.c = new ab(i.f().c());
        DkApp.get().runPreReady(new di(this));
    }

    private void c() {
        this.e = true;
        this.f = System.currentTimeMillis();
        if (this.c.c()) {
            a(null, true);
        }
    }

    private void a(ea eaVar) {
        if (this.e) {
            ea eaVar2 = this.d;
            this.d = eaVar;
            Iterator it = eaVar2.a.iterator();
            while (it.hasNext()) {
                dg dgVar = (dg) it.next();
                if (dgVar.e && dgVar.g >= this.f) {
                    int i = dgVar.a;
                    String str = dgVar.b;
                    long j = dgVar.g;
                    if (dgVar.d) {
                        a(this.d, i, str, j);
                    } else {
                        a(this.d, i, str, dgVar.c, j);
                    }
                }
            }
            this.e = false;
        }
    }

    public List b() {
        return this.d.b;
    }

    public dg a(int i, String str) {
        return this.d.b(i, str);
    }

    public void a(dz dzVar) {
        a(dzVar, false);
    }

    private void a(dz dzVar, boolean z) {
        if (this.c.c()) {
            if (dzVar != null) {
                dzVar.a();
            }
        } else if (this.e) {
            new dl(this, this.c, dzVar).open();
        } else if (dzVar != null) {
            dzVar.a();
        }
    }

    public void b(int i, String str) {
        if (this.c.c() && i != -1) {
            dg a = a(this.d, i, str, System.currentTimeMillis());
            a(Arrays.asList(new dg[]{a}));
        }
    }

    public void a(int i, String str, long j) {
        if (this.c.c() && i != -1) {
            dg a = a(this.d, i, str, j, System.currentTimeMillis());
            a(Arrays.asList(new dg[]{a}));
        }
    }

    private dg a(ea eaVar, int i, String str, long j) {
        dg a = eaVar.a(i, str);
        if (a == null) {
            a = new dg(i, str);
            eaVar.a(a);
        }
        a.d = true;
        a.c = -1;
        a.e = true;
        a.f = 2;
        a.g = j;
        return a;
    }

    private dg a(ea eaVar, int i, String str, long j, long j2) {
        dg a = eaVar.a(i, str);
        if (a == null) {
            a = new dg(i, str);
            eaVar.a(a);
        }
        a.d = false;
        a.c = j;
        a.e = true;
        a.f = 1;
        a.g = j2;
        return a;
    }

    private void a(Collection collection) {
        if (!collection.isEmpty()) {
            ArrayList arrayList = new ArrayList(collection);
            for (dg a : collection) {
                arrayList.add(a.a());
            }
            new dm(this, this.c, this.e, arrayList).open();
        }
    }

    public void a(eb ebVar) {
        if (this.c.c()) {
            this.g.add(new Pair(this.c, ebVar));
            if (this.g.size() == 1) {
                d();
                return;
            }
            return;
        }
        ebVar.a("");
    }

    private void d() {
        Pair pair;
        while (!this.g.isEmpty()) {
            Pair pair2 = (Pair) this.g.peek();
            if (((ab) pair2.first).a(this.c)) {
                pair = pair2;
                break;
            } else {
                ((eb) pair2.second).a("");
                this.g.poll();
            }
        }
        pair = null;
        if (pair != null) {
            new dn(this, (ab) pair.first, (eb) pair.second).open();
        }
    }

    private void a(df dfVar, eb ebVar) {
        b(dfVar, new dp(this, ebVar));
    }

    private void b(df dfVar, eb ebVar) {
        new dr(this, this.c, dfVar, ebVar).open();
    }

    public void a(jl jlVar, ee eeVar) {
        if (this.c.c()) {
            this.h.add(new ed(this.c, jlVar, eeVar));
            if (this.h.size() == 1) {
                e();
                return;
            }
            return;
        }
        eeVar.a("");
    }

    private void e() {
        ed edVar;
        while (!this.h.isEmpty()) {
            edVar = (ed) this.h.peek();
            if (edVar.a.a(this.c)) {
                break;
            }
            edVar.c.a("");
            this.h.poll();
        }
        edVar = null;
        if (edVar != null) {
            ab abVar = edVar.a;
            new dt(this, edVar.b, abVar, this.e, edVar.c).open();
        }
    }

    private void a(List list, ee eeVar) {
        if (list.isEmpty()) {
            eeVar.a();
        } else {
            a(list, new dv(this, list, eeVar));
        }
    }

    private void a(List list, ec ecVar) {
        new dx(this, this.c, list, ecVar).open();
    }
}
