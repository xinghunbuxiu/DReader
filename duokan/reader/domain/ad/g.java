package com.duokan.reader.domain.ad;

import android.content.Context;

import com.duokan.core.app.ah;
import com.duokan.core.app.ai;
import com.duokan.core.ui.UTools;
import com.duokan.reader.DkApp;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class g implements ah {
    private static final ai d = new ai();
    private final String a;
    private final String b;
    private final String c;
    private final Context e;
    private String f;
    private final String g = "http://api.MyTask.xiaomi.com/u/api";
    private final String h = "http://api.MyTask.xiaomi.com/u/getSplashAds";
    private final int i;
    private final int j;
    private final int k;
    private final int l;
    private final int m;
    private final int n;
    private final int o;
    private int p = 0;
    private int q = 0;
    private final c r;
    private int s = 0;
    private ConcurrentLinkedQueue t = new ConcurrentLinkedQueue();
    private ConcurrentLinkedQueue u = new ConcurrentLinkedQueue();

    static /* synthetic */ int n(g gVar) {
        int i = gVar.q + 1;
        gVar.q = i;
        return i;
    }

    private g(Context context) {
        this.e = context;
        this.a = DkApp.get().getFictionChapterEndAdUpId();
        this.b = DkApp.get().getSplashAdUpId();
        this.c = DkApp.get().getComicChapterEndAdUpId();
        this.r = new c(context);
        this.i = UTools.getMinimumHeight(context, 275.0f);
        this.j = UTools.getMinimumHeight(context, 185.0f);
        this.k = UTools.getMinimumHeight(context, 120.0f);
        this.l = UTools.getMinimumHeight(context, 285.0f);
        this.m = UTools.getMinimumHeight(context, 205.0f);
        this.n = UTools.getMinimumHeight(context, 155.0f);
        this.o = UTools.getMinimumHeight(context, 115.0f);
    }

    public static void a(Context context) {
        d.a(new g(context));
    }

    public static g a() {
        return (g) d.a();
    }

    public void a(String str) {
        this.f = str;
        g();
    }

    public e b() {
        if (this.u.isEmpty()) {
            h();
            return null;
        }
        e eVar = (e) this.u.remove();
        if (this.u.size() > 1) {
            return eVar;
        }
        t.b(new h(this));
        return eVar;
    }

    public e a(int i) {
        if (i < this.k) {
            return null;
        }
        Iterator it = this.t.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            if (eVar.w < i) {
                this.t.remove(eVar);
                if (this.t.size() > 1) {
                    return eVar;
                }
                t.b(new i(this));
                return eVar;
            }
        }
        g();
        return null;
    }

    private void g() {
        synchronized (this) {
            this.p++;
        }
        new j(this).open();
    }

    private void h() {
        synchronized (this) {
            this.p++;
        }
        new l(this).open();
    }

    public void a(String str, int i, p pVar) {
        synchronized (this) {
            this.p++;
        }
        new n(this, str, i, pVar).open();
    }

    public void a(e eVar) {
        if (eVar != null) {
            a(eVar.j);
        }
    }

    public void b(e eVar) {
        if (eVar != null) {
            a(eVar.k);
        }
    }

    public void c(e eVar) {
        if (eVar != null) {
            a(eVar.l);
        }
    }

    public void d(e eVar) {
        if (eVar != null) {
            a(eVar.m);
        }
    }

    public void e(e eVar) {
        if (eVar != null) {
            a(eVar.n);
        }
    }

    public void f(e eVar) {
        if (eVar != null) {
            a(eVar.o);
        }
    }

    private void a(List list) {
        if (list != null && !list.isEmpty()) {
            new o(this, list).open();
        }
    }

    public int c() {
        int i;
        synchronized (this) {
            i = this.q;
            this.q = 0;
        }
        return i;
    }

    public int d() {
        int i;
        synchronized (this) {
            i = this.p;
            this.p = 0;
        }
        return i;
    }

    public int e() {
        int i;
        synchronized (this) {
            i = this.s;
            this.s = 0;
        }
        return i;
    }

    public void f() {
        synchronized (this) {
            this.s++;
        }
    }
}
