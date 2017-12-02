package com.duokan.reader.domain.document;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;

import com.duokan.core.diagnostic.a;
import com.duokan.core.sys.t;
import com.duokan.kernel.DkUtils;

import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;

public abstract class n {
    static final /* synthetic */ boolean h = (!n.class.desiredAssertionStatus());
    protected boolean a = false;
    protected boolean b = false;
    protected boolean c = false;
    protected final CountDownLatch d = new CountDownLatch(1);
    protected final ConcurrentLinkedQueue e = new ConcurrentLinkedQueue();
    protected final ConcurrentLinkedQueue f = new ConcurrentLinkedQueue();
    protected final al g = new al();
    private int i = 0;

    public abstract long a(av avVar);

    public abstract Bitmap a(String str, Rect rect, int i, int i2);

    public abstract aa a(aa aaVar, int i);

    public abstract aa a(av avVar, String str, int i);

    public abstract ak a(long j);

    public abstract ak a(ak akVar, int i);

    public abstract as a(ak akVar, m mVar);

    public abstract bb a(d dVar, d dVar2);

    public abstract y a(String str);

    public abstract void a(k kVar);

    public abstract void a(l lVar);

    public abstract void a(m mVar);

    public abstract int b(int i);

    public abstract long b(ak akVar);

    public abstract long b(av avVar);

    public abstract int c(int i);

    public abstract long c(ak akVar);

    public abstract WritingDirection c();

    public abstract a c(a aVar);

    public abstract ak c(av avVar);

    public abstract FootnoteStyle d();

    public abstract ak d(ak akVar);

    public abstract boolean d(a aVar);

    public abstract long e();

    public abstract ak e(ak akVar);

    public abstract int f();

    public abstract ak f(ak akVar);

    public abstract float g();

    public abstract ak g(ak akVar);

    public abstract h h();

    public abstract boolean h(ak akVar);

    public abstract boolean i();

    public abstract boolean i(ak akVar);

    public abstract boolean j();

    public abstract k k();

    public abstract m l();

    public abstract f m();

    public abstract av q();

    public abstract ak r();

    public abstract bb s();

    protected abstract void t();

    protected n() {
    }

    public void a(int i) {
        this.g.a(i);
    }

    public int a() {
        return this.i;
    }

    public boolean b() {
        return this.a;
    }

    public final ak a(a aVar) {
        if (aVar instanceof av) {
            return c((av) aVar);
        }
        if (aVar instanceof ak) {
            return e((ak) aVar);
        }
        return null;
    }

    public final ak b(a aVar) {
        if (aVar instanceof av) {
            return d(c((av) aVar));
        }
        if (aVar instanceof ak) {
            return d((ak) aVar);
        }
        return null;
    }

    public void a(a... aVarArr) {
        if (aVarArr != null) {
            synchronized (this) {
                for (int length = aVarArr.length - 1; length >= 0; length--) {
                    d(aVarArr[length]);
                }
            }
        }
    }

    public boolean n() {
        return e() >= 0;
    }

    public void a(w wVar) {
        if (h || wVar != null) {
            this.e.add(wVar);
            return;
        }
        throw new AssertionError();
    }

    public void a(at atVar) {
        if (h || atVar != null) {
            this.f.add(atVar);
            return;
        }
        throw new AssertionError();
    }

    public void b(at atVar) {
        if (h || atVar != null) {
            this.f.remove(atVar);
            return;
        }
        throw new AssertionError();
    }

    public String a(bb bbVar) {
        a.c().b(A());
        if (bbVar == null || bbVar.f()) {
            return "";
        }
        m a = l().a();
        a.o = true;
        String str = "";
        as a2 = a(c(bbVar.g()), a);
        while (a2 != null) {
            a2.E();
            if (a2.l().f()) {
                a2.H();
                return str;
            } else if (a2.l().b(bbVar)) {
                String str2 = str + a2.b(bbVar);
                as a3 = a(f(a2.l()), a);
                a3.E();
                if (a3.l().equals(a2.l())) {
                    a2.H();
                    a3.H();
                    a2 = null;
                    str = str2;
                } else {
                    a2.H();
                    a2 = a3;
                    str = str2;
                }
            } else {
                a2.H();
                return str;
            }
        }
        return str;
    }

    public String b(bb bbVar) {
        a.c().b(A());
        if (bbVar == null || bbVar.f()) {
            return "";
        }
        m a = l().a();
        a.o = true;
        String str = "";
        as a2 = a(c(bbVar.g()), a);
        while (a2 != null) {
            a2.E();
            if (a2.l().f()) {
                a2.H();
                return str;
            } else if (a2.l().b(bbVar)) {
                String str2 = str + a2.c(bbVar);
                as a3 = a(f(a2.l()), a);
                a3.E();
                if (a3.l().equals(a2.l())) {
                    a2.H();
                    a3.H();
                    a2 = null;
                    str = str2;
                } else {
                    a2.H();
                    a2 = a3;
                    str = str2;
                }
            } else {
                a2.H();
                return str;
            }
        }
        return str;
    }

    public as a(ak akVar) {
        return a(akVar, l());
    }

    public void o() {
        a.c().b(A());
        if (!this.a) {
            this.a = true;
            if (this.c) {
                t();
            }
        }
    }

    public boolean p() {
        a.c().b(A());
        if (w() && !this.a) {
            return true;
        }
        return false;
    }

    protected void u() {
        this.b = true;
        this.d.countDown();
        t.a(new o(this));
    }

    protected void v() {
        this.a = true;
        this.b = true;
        this.d.countDown();
        this.g.a();
        t.a(new p(this));
    }

    protected boolean w() {
        if (this.b) {
            return true;
        }
        try {
            this.d.await();
            return true;
        } catch (Throwable th) {
            if (this.d.getCount() >= 1) {
                return false;
            }
            return true;
        }
    }

    protected void x() {
        t.b(new q(this));
    }

    protected void a(as asVar) {
        t.b(new r(this, asVar));
    }

    protected void b(as asVar) {
        t.b(new s(this, asVar));
    }

    protected void y() {
        t.b(new t(this));
    }

    protected void z() {
        t.b(new u(this));
    }

    protected void a(aa aaVar) {
        t.b(new v(this, aaVar));
    }

    protected static String a(Map map, String str) {
        String c = c(map, str);
        return !DkUtils.isZhFont(c) ? c : "";
    }

    protected static String b(Map map, String str) {
        String c = c(map, str);
        return DkUtils.isZhFont(c) ? c : "";
    }

    protected static String c(Map map, String str) {
        String str2 = (String) map.get(str);
        if (str2 == null) {
            return "";
        }
        File file = new File(Uri.parse(str2).getPath());
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        return "";
    }

    protected void d(int i) {
        if (this.i == 0) {
            this.i = i;
        }
    }

    protected boolean A() {
        return t.a() && !this.a;
    }
}
