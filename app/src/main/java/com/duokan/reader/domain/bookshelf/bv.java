package com.duokan.reader.domain.bookshelf;

import android.annotation.SuppressLint;
import android.content.Context;

import com.duokan.core.app.ah;
import com.duokan.core.app.ai;
import com.duokan.core.sys.t;
import com.duokan.reader.DkApp;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.account.i;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"UseSparseArrays"})
public class bv implements ah {
    private static final ai a = new ai();
    private final Context b;
    private ab c;
    private cs d = new cs();
    private boolean e = true;
    private long f = System.currentTimeMillis();
    private final LinkedList g = new LinkedList();
    private final LinkedList h = new LinkedList();

    public static void a(Context context) {
        a.a(new bv(context));
    }

    public static bv a() {
        return (bv) a.a();
    }

    private bv(Context context) {
        this.b = context;
        this.c = new ab(i.f().c());
        DkApp.get().runPreReady(new bw(this));
    }

    private void c() {
        this.e = true;
        this.f = System.currentTimeMillis();
        if (this.c.c()) {
            a(null, true);
        }
    }

    private void a(cs csVar) {
        if (this.e) {
            this.d = csVar;
            Iterator it = csVar.a.iterator();
            while (it.hasNext()) {
                bu buVar = (bu) it.next();
                if (buVar.g && buVar.i >= this.f) {
                    int i = buVar.a;
                    String str = buVar.b;
                    if (buVar.h == 1) {
                        a(this.d, i, str, buVar.c, buVar.i);
                    } else if (buVar.h == 2) {
                        b(this.d, i, str, buVar.c, buVar.i);
                    } else if (buVar.h == 3) {
                        a(this.d, i, str, buVar.i);
                    }
                }
            }
            this.e = false;
        }
    }

    public List b() {
        return this.d.b;
    }

    public void a(cw cwVar) {
        a(cwVar, false);
    }

    private void a(cw cwVar, boolean z) {
        if (this.c.c()) {
            if (cwVar != null) {
                cwVar.a();
            }
        } else if (this.e) {
            new ch(this, this.c, cwVar).open();
        } else if (cwVar != null) {
            cwVar.a();
        }
    }

    public void a(int i, String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        t.a(new ci(this, i, str, str2));
    }

    public void a(int i, String str) {
        t.a(new cj(this, i, str));
    }

    public void a(String str, Collection collection) {
        if (str == null) {
            str = "";
        }
        t.a(new ck(this, collection, str));
    }

    public void a(List list) {
        t.a(new cl(this, list));
    }

    private void a(Collection collection) {
        if (!collection.isEmpty()) {
            ArrayList arrayList = new ArrayList(collection);
            for (bu a : collection) {
                arrayList.add(a.a());
            }
            new cm(this, this.c, this.e, arrayList).open();
        }
    }

    private bu a(cs csVar, int i, String str, String str2, long j) {
        bu a = csVar.a(i, str);
        if (a == null) {
            a = new bu(i, str, str2);
            csVar.a(a);
            a.f = 0;
            a.d = 0;
            a.e = j;
            a.g = true;
            a.h = 1;
            a.i = j;
            return a;
        } else if (!a.g) {
            a.c = str2;
            a.e = j;
            a.g = true;
            a.h = 2;
            a.i = j;
            return a;
        } else if (a.c()) {
            a.c = str2;
            a.f = 0;
            a.e = j;
            if (a.d == 0) {
                a.h = 1;
            } else {
                a.h = 2;
            }
            a.i = j;
            return a;
        } else {
            a.c = str2;
            a.e = j;
            a.h = 2;
            a.i = j;
            return a;
        }
    }

    private bu b(cs csVar, int i, String str, String str2, long j) {
        bu a = csVar.a(i, str);
        if (a == null) {
            a = new bu(i, str, str2);
            csVar.a(a);
            a.f = 0;
            a.d = 0;
            a.e = j;
            a.g = true;
            a.h = 1;
            a.i = j;
            return a;
        } else if (!a.g) {
            a.c = str2;
            a.e = j;
            a.g = true;
            a.h = 2;
            a.i = j;
            return a;
        } else if (a.c()) {
            a.c = str2;
            a.f = 0;
            a.e = j;
            if (a.d == 0) {
                a.h = 1;
            } else {
                a.h = 2;
            }
            a.i = j;
            return a;
        } else {
            a.c = str2;
            a.e = j;
            a.h = 2;
            a.i = j;
            return a;
        }
    }

    private bu a(cs csVar, int i, String str, long j) {
        bu a = csVar.a(i, str);
        if (a == null) {
            a = new bu(i, str, "");
            csVar.a(a);
            a.d = 0;
        }
        a.f = 1;
        a.e = j;
        a.g = true;
        a.h = 3;
        a.i = j;
        return a;
    }

    public void a(boolean z, cx cxVar) {
        if (this.c.c()) {
            cz czVar = new cz();
            czVar.a = this.c;
            czVar.b = z;
            czVar.c = cxVar;
            this.g.add(czVar);
            if (this.g.size() == 1) {
                d();
                return;
            }
            return;
        }
        cxVar.a("");
    }

    private void d() {
        cz czVar;
        while (!this.g.isEmpty()) {
            czVar = (cz) this.g.peek();
            if (czVar.a.a(this.c)) {
                break;
            }
            czVar.c.a("");
            this.g.poll();
        }
        czVar = null;
        if (czVar != null) {
            new cn(this, czVar).open();
        }
    }

    private void a(bt btVar, cx cxVar) {
        a(btVar, new cp(this, btVar, cxVar));
    }

    private void a(bt btVar, cy cyVar) {
        if (this.c.c()) {
            new bz(this, this.c, btVar, cyVar).open();
        } else {
            cyVar.a("");
        }
    }

    public void a(jl jlVar, da daVar) {
        if (this.c.c()) {
            this.h.add(new dc(this.c, jlVar, daVar));
            if (this.h.size() == 1) {
                e();
                return;
            }
            return;
        }
        daVar.a("");
    }

    private void e() {
        dc dcVar;
        while (!this.h.isEmpty()) {
            dcVar = (dc) this.h.peek();
            if (dcVar.a.a(this.c)) {
                break;
            }
            dcVar.c.a("");
            this.h.poll();
        }
        dcVar = null;
        if (dcVar != null) {
            ab abVar = dcVar.a;
            new cb(this, dcVar.b, abVar, this.e, dcVar.c).open();
        }
    }

    private void a(bt btVar, List list, da daVar) {
        if (list.isEmpty()) {
            daVar.a();
        } else {
            a(btVar, list, new cd(this, list, daVar));
        }
    }

    private void a(bt btVar, List list, db dbVar) {
        new cf(this, this.c, list, btVar, dbVar).open();
    }
}
