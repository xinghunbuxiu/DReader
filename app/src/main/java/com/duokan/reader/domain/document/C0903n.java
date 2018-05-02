package com.duokan.reader.domain.document;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.sys.UThread;
import com.duokan.kernel.DkUtils;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.duokan.reader.domain.document.n */
public abstract class C0903n {
    /* renamed from: h */
    static final /* synthetic */ boolean f4272h = (!C0903n.class.desiredAssertionStatus());
    /* renamed from: a */
    protected boolean f4273a = false;
    /* renamed from: b */
    protected boolean f4274b = false;
    /* renamed from: c */
    protected boolean f4275c = false;
    /* renamed from: d */
    protected final CountDownLatch f4276d = new CountDownLatch(1);
    /* renamed from: e */
    protected final ConcurrentLinkedQueue<C0808w> f4277e = new ConcurrentLinkedQueue();
    /* renamed from: f */
    protected final ConcurrentLinkedQueue<at> f4278f = new ConcurrentLinkedQueue();
    /* renamed from: g */
    protected final al f4279g = new al();
    /* renamed from: i */
    private int f4280i = 0;

    /* renamed from: a */
    public abstract long mo1209a(av avVar);

    /* renamed from: a */
    public abstract Bitmap mo1210a(String str, Rect rect, int i, int i2);

    /* renamed from: a */
    public abstract aa mo1211a(aa aaVar, int i);

    /* renamed from: a */
    public abstract aa mo1212a(av avVar, String str, int i);

    /* renamed from: a */
    public abstract ak mo1213a(long j);

    /* renamed from: a */
    public abstract ak mo1214a(ak akVar, int i);

    /* renamed from: a */
    public abstract as mo1215a(ak akVar, C0923m c0923m);

    /* renamed from: a */
    public abstract bb mo1216a(C0897d c0897d, C0897d c0897d2);

    /* renamed from: a */
    public abstract C1012y mo1217a(String str);

    /* renamed from: a */
    public abstract void mo1218a(C0917k c0917k);

    /* renamed from: a */
    public abstract void mo1219a(C0919l c0919l);

    /* renamed from: a */
    public abstract void mo1220a(C0923m c0923m);

    /* renamed from: b */
    public abstract int mo1222b(int i);

    /* renamed from: b */
    public abstract long mo1223b(ak akVar);

    /* renamed from: b */
    public abstract long mo1224b(av avVar);

    /* renamed from: c */
    public abstract int mo1226c(int i);

    /* renamed from: c */
    public abstract long mo1227c(ak akVar);

    /* renamed from: c */
    public abstract WritingDirection mo1228c();

    /* renamed from: c */
    public abstract C0896a mo1229c(C0896a c0896a);

    /* renamed from: c */
    public abstract ak mo1230c(av avVar);

    /* renamed from: d */
    public abstract FootnoteStyle mo1231d();

    /* renamed from: d */
    public abstract ak mo1232d(ak akVar);

    /* renamed from: d */
    public abstract boolean mo1233d(C0896a c0896a);

    /* renamed from: e */
    public abstract long mo1234e();

    /* renamed from: e */
    public abstract ak mo1235e(ak akVar);

    /* renamed from: f */
    public abstract int mo1236f();

    /* renamed from: f */
    public abstract ak mo1237f(ak akVar);

    /* renamed from: g */
    public abstract float mo1238g();

    /* renamed from: g */
    public abstract ak mo1239g(ak akVar);

    /* renamed from: h */
    public abstract C0911h mo1240h();

    /* renamed from: h */
    public abstract boolean mo1241h(ak akVar);

    /* renamed from: i */
    public abstract boolean mo1242i();

    /* renamed from: i */
    public abstract boolean mo1243i(ak akVar);

    /* renamed from: j */
    public abstract boolean mo1244j();

    /* renamed from: k */
    public abstract C0917k mo1245k();

    /* renamed from: l */
    public abstract C0923m mo1246l();

    /* renamed from: m */
    public abstract C0908f mo1247m();

    /* renamed from: q */
    public abstract av mo1248q();

    /* renamed from: r */
    public abstract ak mo1249r();

    /* renamed from: s */
    public abstract bb mo1250s();

    /* renamed from: t */
    protected abstract void mo1251t();

    protected C0903n() {
    }

    /* renamed from: a */
    public void m5903a(int i) {
        this.f4279g.m6358a(i);
    }

    /* renamed from: a */
    public int m5890a() {
        return this.f4280i;
    }

    /* renamed from: b */
    public boolean mo1448b() {
        return this.f4273a;
    }

    /* renamed from: a */
    public final ak m5896a(C0896a c0896a) {
        if (c0896a instanceof av) {
            return mo1230c((av) c0896a);
        }
        if (c0896a instanceof ak) {
            return mo1235e((ak) c0896a);
        }
        return null;
    }

    /* renamed from: b */
    public final ak m5915b(C0896a c0896a) {
        if (c0896a instanceof av) {
            return mo1232d(mo1230c((av) c0896a));
        }
        if (c0896a instanceof ak) {
            return mo1232d((ak) c0896a);
        }
        return null;
    }

    /* renamed from: a */
    public void m5911a(C0896a... c0896aArr) {
        if (c0896aArr != null) {
            synchronized (this) {
                for (int length = c0896aArr.length - 1; length >= 0; length--) {
                    mo1233d(c0896aArr[length]);
                }
            }
        }
    }

    /* renamed from: n */
    public boolean m5943n() {
        return mo1234e() >= 0;
    }

    /* renamed from: a */
    public void m5910a(C0808w c0808w) {
        if (f4272h || c0808w != null) {
            this.f4277e.add(c0808w);
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public void m5906a(at atVar) {
        if (f4272h || atVar != null) {
            this.f4278f.add(atVar);
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: b */
    public void m5918b(at atVar) {
        if (f4272h || atVar != null) {
            this.f4278f.remove(atVar);
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public String m5902a(bb bbVar) {
        WebLog.init().w(m5889A());
        if (bbVar == null || bbVar.m5817f()) {
            return "";
        }
        C0923m a = mo1246l().mo1277a();
        a.f4367o = true;
        String str = "";
        as a2 = mo1215a(mo1230c(bbVar.mo1198g()), a);
        while (a2 != null) {
            a2.mo1282E();
            if (a2.mo1332l().m5817f()) {
                a2.mo1285H();
                return str;
            } else if (a2.mo1332l().m5814b(bbVar)) {
                String str2 = str + a2.mo1303b(bbVar);
                as a3 = mo1215a(mo1237f(a2.mo1332l()), a);
                a3.mo1282E();
                if (a3.mo1332l().equals(a2.mo1332l())) {
                    a2.mo1285H();
                    a3.mo1285H();
                    a2 = null;
                    str = str2;
                } else {
                    a2.mo1285H();
                    a2 = a3;
                    str = str2;
                }
            } else {
                a2.mo1285H();
                return str;
            }
        }
        return str;
    }

    /* renamed from: b */
    public String m5916b(bb bbVar) {
        WebLog.init().w(m5889A());
        if (bbVar == null || bbVar.m5817f()) {
            return "";
        }
        C0923m a = mo1246l().mo1277a();
        a.f4367o = true;
        String str = "";
        as a2 = mo1215a(mo1230c(bbVar.mo1198g()), a);
        while (a2 != null) {
            a2.mo1282E();
            if (a2.mo1332l().m5817f()) {
                a2.mo1285H();
                return str;
            } else if (a2.mo1332l().m5814b(bbVar)) {
                String str2 = str + a2.mo1309c(bbVar);
                as a3 = mo1215a(mo1237f(a2.mo1332l()), a);
                a3.mo1282E();
                if (a3.mo1332l().equals(a2.mo1332l())) {
                    a2.mo1285H();
                    a3.mo1285H();
                    a2 = null;
                    str = str2;
                } else {
                    a2.mo1285H();
                    a2 = a3;
                    str = str2;
                }
            } else {
                a2.mo1285H();
                return str;
            }
        }
        return str;
    }

    /* renamed from: a */
    public as m5898a(ak akVar) {
        return mo1215a(akVar, mo1246l());
    }

    /* renamed from: o */
    public void m5944o() {
        WebLog.init().w(m5889A());
        if (!this.f4273a) {
            this.f4273a = true;
            if (this.f4275c) {
                mo1251t();
            }
        }
    }

    /* renamed from: p */
    public boolean m5945p() {
        WebLog.init().w(m5889A());
        if (m5952w() && !this.f4273a) {
            return true;
        }
        return false;
    }

    /* renamed from: u */
    protected void m5950u() {
        this.f4274b = true;
        this.f4276d.countDown();
        UThread.runOnThread(new C0960o(this));
    }

    /* renamed from: v */
    protected void m5951v() {
        this.f4273a = true;
        this.f4274b = true;
        this.f4276d.countDown();
        this.f4279g.m6357a();
        UThread.runOnThread(new C0961p(this));
    }

    /* renamed from: w */
    protected boolean m5952w() {
        if (this.f4274b) {
            return true;
        }
        try {
            this.f4276d.await();
            return true;
        } catch (Throwable th) {
            if (this.f4276d.getCount() >= 1) {
                return false;
            }
            return true;
        }
    }

    /* renamed from: x */
    protected void m5953x() {
        UThread.post(new C0962q(this));
    }

    /* renamed from: a */
    protected void m5905a(as asVar) {
        UThread.post(new C0963r(this, asVar));
    }

    /* renamed from: b */
    protected void m5917b(as asVar) {
        UThread.post(new C0964s(this, asVar));
    }

    /* renamed from: y */
    protected void m5954y() {
        UThread.post(new C0985t(this));
    }

    /* renamed from: z */
    protected void m5955z() {
        UThread.post(new C1009u(this));
    }

    /* renamed from: a */
    protected void m5904a(aa aaVar) {
        UThread.post(new C1010v(this, aaVar));
    }

    /* renamed from: a */
    protected static String m5886a(Map<String, String> map, String str) {
        String c = C0903n.m5888c(map, str);
        return !DkUtils.isZhFont(c) ? c : "";
    }

    /* renamed from: b */
    protected static String m5887b(Map<String, String> map, String str) {
        String c = C0903n.m5888c(map, str);
        return DkUtils.isZhFont(c) ? c : "";
    }

    /* renamed from: c */
    protected static String m5888c(Map<String, String> map, String str) {
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

    /* renamed from: d */
    protected void m5927d(int i) {
        if (this.f4280i == 0) {
            this.f4280i = i;
        }
    }

    /* renamed from: A */
    protected boolean m5889A() {
        return UThread.isCurrentThread() && !this.f4273a;
    }
}
