package com.duokan.reader.domain.document.txt;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.sys.UThread;
import com.duokan.core.sys.ah;
import com.duokan.reader.domain.document.C0897d;
import com.duokan.reader.domain.document.C0917k;
import com.duokan.reader.domain.document.C0923m;
import com.duokan.reader.domain.document.C0941i;
import com.duokan.reader.domain.document.ab;
import com.duokan.reader.domain.document.ac;
import com.duokan.reader.domain.document.ad;
import com.duokan.reader.domain.document.ae;
import com.duokan.reader.domain.document.af;
import com.duokan.reader.domain.document.aj;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.al;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.at;
import com.duokan.reader.domain.document.au;
import com.duokan.reader.domain.document.aw;
import com.duokan.reader.domain.document.ax;
import com.duokan.reader.domain.document.bb;
import java.util.concurrent.CountDownLatch;
import org.apache.http.HttpStatus;

/* renamed from: com.duokan.reader.domain.document.txt.f */
public class C0990f extends ag implements C0941i {
    /* renamed from: c */
    static final /* synthetic */ boolean f4952c = (!C0990f.class.desiredAssertionStatus());
    /* renamed from: d */
    private final au f4953d;
    /* renamed from: e */
    private final C0989e f4954e;
    /* renamed from: f */
    private ah f4955f = null;
    /* renamed from: g */
    private final al f4956g;
    /* renamed from: h */
    private final at f4957h;
    /* renamed from: i */
    private final Callback f4958i = new C0991g(this);
    /* renamed from: j */
    private C0999o f4959j = null;
    /* renamed from: k */
    private boolean f4960k = false;
    /* renamed from: l */
    private aj f4961l = null;
    /* renamed from: m */
    private aj f4962m = null;
    /* renamed from: n */
    private Rect f4963n = new Rect();
    /* renamed from: o */
    private Rect f4964o = new Rect();
    /* renamed from: p */
    private boolean f4965p = false;
    /* renamed from: q */
    private CountDownLatch f4966q = null;
    /* renamed from: r */
    private Paint f4967r = new Paint();

    /* renamed from: b */
    public /* synthetic */ as mo1305b() {
        return m7600P();
    }

    /* renamed from: c */
    public /* synthetic */ as mo1434c() {
        return m7601Q();
    }

    public C0990f(au auVar, C0989e c0989e, ah ahVar, al alVar, at atVar) {
        if (!f4952c && (auVar == null || ahVar == null)) {
            throw new AssertionError();
        } else if (f4952c || (c0989e != null && c0989e.mo1186a())) {
            WebLog.init().w(m6108M());
            this.f4953d = auVar;
            this.f4953d.m5841b((Object) UThread.getCurrentThread());
            this.f4954e = new C0989e(this.f4953d, c0989e, 0);
            this.f4955f = ahVar;
            this.f4956g = alVar;
            this.f4957h = atVar;
            this.f4959j = this.f4953d.m7518a(this.f4954e, new C0993h(this));
        } else {
            throw new AssertionError();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: O */
    public boolean m7599O() {
        /*
        r4 = this;
        r0 = 1;
        r1 = com.duokan.core.diagnostic.C0328a.init();
        r2 = r4.m6108M();
        r1.w(r2);
        r1 = r4.mo1299a();
        if (r1 == 0) goto L_0x0013;
    L_0x0012:
        return r0;
    L_0x0013:
        monitor-enter(r4);
        r1 = r4.f4965p;	 Catch:{ all -> 0x001a }
        if (r1 == 0) goto L_0x001d;
    L_0x0018:
        monitor-exit(r4);	 Catch:{ all -> 0x001a }
        goto L_0x0012;
    L_0x001a:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x001a }
        throw r0;
    L_0x001d:
        r0 = r4.f4966q;	 Catch:{ all -> 0x001a }
        if (r0 != 0) goto L_0x0029;
    L_0x0021:
        r0 = new java.util.concurrent.CountDownLatch;	 Catch:{ all -> 0x001a }
        r1 = 1;
        r0.<init>(r1);	 Catch:{ all -> 0x001a }
        r4.f4966q = r0;	 Catch:{ all -> 0x001a }
    L_0x0029:
        monitor-exit(r4);	 Catch:{ all -> 0x001a }
    L_0x002a:
        r0 = r4.f4965p;
        if (r0 != 0) goto L_0x0050;
    L_0x002e:
        r0 = r4.f4959j;
        r0 = r0.m7500d();
        if (r0 != 0) goto L_0x0050;
    L_0x0036:
        r0 = r4.f4953d;
        r0 = r0.a;
        if (r0 == 0) goto L_0x0050;
    L_0x003c:
        r0 = r4.f4953d;
        r0 = r0.mo1272c();
        if (r0 != 0) goto L_0x0050;
    L_0x0044:
        r0 = r4.f4966q;	 Catch:{ InterruptedException -> 0x004e }
        r2 = 1;
        r1 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ InterruptedException -> 0x004e }
        r0.await(r2, r1);	 Catch:{ InterruptedException -> 0x004e }
        goto L_0x002a;
    L_0x004e:
        r0 = move-exception;
        goto L_0x002a;
    L_0x0050:
        r0 = r4.mo1299a();
        goto L_0x0012;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.document.txt.f.O():boolean");
    }

    /* renamed from: j */
    public long mo1327j() {
        WebLog.init().w(m6108M());
        if (!f4952c && !mo1284G()) {
            throw new AssertionError();
        } else if (mo1284G()) {
            return this.f4961l.mo1327j();
        } else {
            return -1;
        }
    }

    /* renamed from: k */
    public boolean mo1330k() {
        WebLog.init().w(m6108M());
        return false;
    }

    /* renamed from: l */
    public ak mo1332l() {
        WebLog.init().w(m6108M());
        return this.f4954e;
    }

    /* renamed from: m */
    public bb mo1334m() {
        if (mo1282E()) {
            return new at(this.f4954e.mo1460n(), this.f4954e.mo1461o());
        }
        return new at();
    }

    /* renamed from: n */
    public C0897d[] mo1336n() {
        WebLog.init().w(m6108M());
        if (!mo1282E()) {
            return new C0897d[0];
        }
        Object c = this.f4961l.m7448c();
        Object c2 = this.f4962m.m7448c();
        C0897d[] c0897dArr = new C0986b[(c.length + c2.length)];
        System.arraycopy(c, 0, c0897dArr, 0, c.length);
        System.arraycopy(c2, 0, c0897dArr, c.length, c2.length);
        return c0897dArr;
    }

    /* renamed from: o */
    public CharSequence mo1338o() {
        WebLog.init().w(m6108M());
        if (!mo1282E()) {
            return "";
        }
        CharSequence o = this.f4961l.mo1338o();
        CharSequence o2 = this.f4962m.mo1338o();
        return TextUtils.concat(new CharSequence[]{o, o2});
    }

    /* renamed from: p */
    public C0917k mo1340p() {
        WebLog.init().w(m6108M());
        return this.f4953d.m7524h();
    }

    /* renamed from: q */
    public C0923m mo1342q() {
        WebLog.init().w(m6108M());
        return this.f4955f;
    }

    /* renamed from: a */
    public void mo1296a(C0923m c0923m) {
        WebLog.init().w(m6108M());
        if (mo1282E()) {
            this.f4955f = (ah) c0923m;
            C0923m ahVar = new ah(this.f4955f);
            ahVar.l = this.f4961l.mo1342q().f4364l;
            ahVar.m = this.f4961l.mo1342q().f4365m;
            C0923m ahVar2 = new ah(this.f4955f);
            ahVar2.l = this.f4962m.mo1342q().f4364l;
            ahVar2.m = this.f4962m.mo1342q().f4365m;
            this.f4961l.mo1296a(ahVar);
            this.f4962m.mo1296a(ahVar2);
        }
    }

    /* renamed from: r */
    public int mo1343r() {
        WebLog.init().w(m6108M());
        if (!f4952c && !mo1284G()) {
            throw new AssertionError();
        } else if (mo1284G()) {
            return this.f4961l.mo1343r() + this.f4962m.mo1343r();
        } else {
            return 0;
        }
    }

    /* renamed from: s */
    public int mo1345s() {
        WebLog.init().w(m6108M());
        return 0;
    }

    /* renamed from: t */
    public int mo1347t() {
        WebLog.init().w(m6108M());
        return 0;
    }

    /* renamed from: u */
    public int mo1349u() {
        WebLog.init().w(m6108M());
        return 0;
    }

    /* renamed from: v */
    public int mo1351v() {
        WebLog.init().w(m6108M());
        if (f4952c || mo1284G()) {
            return 0;
        }
        throw new AssertionError();
    }

    /* renamed from: w */
    public int mo1353w() {
        WebLog.init().w(m6108M());
        if (f4952c || mo1284G()) {
            return 0;
        }
        throw new AssertionError();
    }

    /* renamed from: x */
    public int mo1354x() {
        WebLog.init().w(m6108M());
        if (f4952c || mo1284G()) {
            return 0;
        }
        throw new AssertionError();
    }

    /* renamed from: y */
    public int mo1355y() {
        WebLog.init().w(m6108M());
        if (f4952c || mo1284G()) {
            return 0;
        }
        throw new AssertionError();
    }

    /* renamed from: z */
    public Rect mo1356z() {
        WebLog.init().w(m6108M());
        if (!mo1284G()) {
            return new Rect(0, 0, 0, 0);
        }
        if (!this.f4962m.mo1356z().isEmpty()) {
            m7576b(this.f4962m.mo1356z());
            return this.f4962m.mo1356z();
        } else if (this.f4961l.mo1356z().isEmpty()) {
            return new Rect(0, 0, 0, 0);
        } else {
            m7572a(this.f4961l.mo1356z());
            return this.f4961l.mo1356z();
        }
    }

    /* renamed from: A */
    public Rect mo1280A() {
        WebLog.init().w(m6108M());
        return new Rect();
    }

    /* renamed from: B */
    public int mo1281B() {
        WebLog.init().w(m6108M());
        if (f4952c || mo1284G()) {
            return 0;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public Rect mo1291a(au auVar) {
        WebLog.init().w(m6108M());
        if (f4952c || mo1284G()) {
            return new Rect();
        }
        throw new AssertionError();
    }

    /* renamed from: E */
    public boolean mo1282E() {
        WebLog.init().w(m6108M());
        if (mo1284G()) {
            return true;
        }
        if (m7599O() && this.f4961l.mo1282E() && this.f4962m.mo1282E()) {
            return mo1284G();
        }
        return false;
    }

    /* renamed from: a */
    public void mo1297a(Runnable runnable, Runnable runnable2) {
        WebLog.init().w(m6108M());
        ah.m871b(new C0996k(this, runnable2, runnable));
    }

    /* renamed from: F */
    public boolean mo1283F() {
        WebLog.init().w(m6108M());
        return this.f4959j.m7500d();
    }

    /* renamed from: G */
    public boolean mo1284G() {
        WebLog.init().w(m6108M());
        if (!this.f4959j.m7500d() && mo1299a() && this.f4961l.mo1284G() && this.f4962m.mo1284G()) {
            return true;
        }
        return false;
    }

    /* renamed from: H */
    public void mo1285H() {
        WebLog.init().w(m6108M());
        if (!this.f4959j.m7500d()) {
            this.f4959j.mo1467a();
            if (mo1299a()) {
                this.f4961l.mo1285H();
                this.f4962m.mo1285H();
            }
            this.f4953d.m5842c(UThread.getCurrentThread());
        }
    }

    /* renamed from: a */
    public void mo1298a(boolean z) {
        WebLog.init().w(m6108M());
        if (mo1299a()) {
            this.f4961l.mo1298a(z);
            this.f4962m.mo1298a(z);
        }
    }

    /* renamed from: a */
    public ae mo1292a(Point point) {
        WebLog.init().w(m6108M());
        return null;
    }

    /* renamed from: a */
    public bb mo1293a(Point point, Point point2) {
        WebLog.init().w(m6108M());
        if (!f4952c && !mo1284G()) {
            throw new AssertionError();
        } else if (!mo1284G()) {
            return new at(new C0986b(0), new C0986b(0));
        } else {
            if (m7583h(point) && !m7585i(point2)) {
                return this.f4961l.m7440b(m7586j(point), m7586j(point2));
            } else if (m7585i(point) && !m7583h(point2)) {
                return this.f4962m.m7440b(m7588k(point), m7588k(point2));
            } else if (m7583h(point) && m7585i(point2)) {
                r0 = m7586j(point);
                r1 = new Point(this.f4961l.mo1340p().m6084b().right, this.f4961l.mo1340p().m6084b().bottom);
                r2 = new Point(this.f4962m.mo1340p().m6084b().left, this.f4962m.mo1340p().m6084b().top);
                r3 = m7588k(point2);
                r0 = this.f4961l.m7440b(r0, r1);
                r1 = this.f4962m.m7440b(r2, r3);
                if (f4952c || (r0 != null && r1 != null)) {
                    return at.m7503a(r0, r1);
                }
                throw new AssertionError();
            } else if (!m7585i(point) || !m7583h(point2)) {
                return new at(new C0986b(0), new C0986b(0));
            } else {
                r0 = m7586j(point2);
                r1 = new Point(this.f4961l.mo1340p().m6084b().right, this.f4961l.mo1340p().m6084b().bottom);
                r2 = new Point(this.f4962m.mo1340p().m6084b().left, this.f4962m.mo1340p().m6084b().top);
                r3 = m7588k(point);
                r0 = this.f4961l.m7440b(r0, r1);
                r1 = this.f4962m.m7440b(r2, r3);
                if (f4952c || (r0 != null && r1 != null)) {
                    return at.m7503a(r0, r1);
                }
                throw new AssertionError();
            }
        }
    }

    /* renamed from: b */
    public bb mo1302b(Point point) {
        WebLog.init().w(m6108M());
        if (!f4952c && !mo1284G()) {
            throw new AssertionError();
        } else if (!mo1284G()) {
            return new at(new C0986b(0), new C0986b(0));
        } else {
            if (m7583h(point)) {
                return this.f4961l.m7462h(m7586j(point));
            } else if (!m7585i(point)) {
                return new at(new C0986b(0), new C0986b(0));
            } else {
                return this.f4962m.m7462h(m7588k(point));
            }
        }
    }

    /* renamed from: c */
    public int mo1306c(Point point) {
        WebLog.init().w(m6108M());
        return -1;
    }

    /* renamed from: a */
    public int mo1289a(Point point, int i) {
        WebLog.init().w(m6108M());
        return -1;
    }

    /* renamed from: d */
    public int mo1310d(Point point) {
        WebLog.init().w(m6108M());
        return -1;
    }

    /* renamed from: e */
    public int mo1314e(Point point) {
        WebLog.init().w(m6108M());
        return -1;
    }

    /* renamed from: a */
    public int mo1290a(bb bbVar) {
        WebLog.init().w(m6108M());
        return -1;
    }

    /* renamed from: f */
    public int mo1317f(Point point) {
        WebLog.init().w(m6108M());
        return -1;
    }

    /* renamed from: g */
    public int mo1320g(Point point) {
        return -1;
    }

    /* renamed from: b */
    public Rect mo1301b(Rect rect) {
        WebLog.init().w(m6108M());
        return new Rect(rect);
    }

    /* renamed from: c */
    public Rect mo1307c(Rect rect) {
        WebLog.init().w(m6108M());
        return new Rect(rect);
    }

    /* renamed from: c */
    public af mo1308c(int i) {
        WebLog.init().w(m6108M());
        return null;
    }

    /* renamed from: d */
    public aw mo1312d(int i) {
        WebLog.init().w(m6108M());
        return null;
    }

    /* renamed from: e */
    public ab mo1315e(int i) {
        WebLog.init().w(m6108M());
        return null;
    }

    /* renamed from: f */
    public com.duokan.reader.domain.document.ah mo1319f(int i) {
        WebLog.init().w(m6108M());
        return null;
    }

    /* renamed from: g */
    public Rect mo1322g(int i) {
        WebLog.init().w(m6108M());
        return new Rect();
    }

    /* renamed from: h */
    public Rect mo1325h(int i) {
        WebLog.init().w(m6108M());
        return null;
    }

    /* renamed from: i */
    public Rect mo1326i(int i) {
        WebLog.init().w(m6108M());
        return new Rect();
    }

    /* renamed from: j */
    public Rect mo1328j(int i) {
        WebLog.init().w(m6108M());
        return null;
    }

    /* renamed from: I */
    public String mo1286I() {
        WebLog.init().w(m6108M());
        if (mo1282E()) {
            return this.f4961l.mo1286I() + this.f4962m.mo1286I();
        }
        return "";
    }

    /* renamed from: b */
    public String mo1303b(bb bbVar) {
        WebLog.init().w(m6108M());
        if (!mo1282E()) {
            return "";
        }
        if (bbVar == null || bbVar.m5817f()) {
            return "";
        }
        if (m7567R().m5814b(bbVar) && m7568S().m5814b(bbVar)) {
            bb b = at.m7504b((at) bbVar, new at(m7567R().mo1460n(), m7567R().mo1461o()));
            bb b2 = at.m7504b((at) bbVar, new at(m7568S().mo1460n(), m7568S().mo1461o()));
            String b3 = this.f4961l.mo1303b(b);
            return b3 + this.f4962m.mo1303b(b2);
        } else if (m7567R().m5814b(bbVar)) {
            return this.f4961l.mo1303b(bbVar);
        } else {
            if (m7568S().m5814b(bbVar)) {
                return this.f4962m.mo1303b(bbVar);
            }
            return "";
        }
    }

    /* renamed from: J */
    public String mo1287J() {
        WebLog.init().w(m6108M());
        if (mo1282E()) {
            return this.f4961l.mo1287J() + this.f4962m.mo1287J();
        }
        return "";
    }

    /* renamed from: c */
    public String mo1309c(bb bbVar) {
        WebLog.init().w(m6108M());
        if (!mo1282E()) {
            return "";
        }
        if (bbVar == null || bbVar.m5817f()) {
            return "";
        }
        if (m7567R().m5814b(bbVar) && m7568S().m5814b(bbVar)) {
            bb b = at.m7504b((at) bbVar, new at(m7567R().mo1460n(), m7567R().mo1461o()));
            bb b2 = at.m7504b((at) bbVar, new at(m7568S().mo1460n(), m7568S().mo1461o()));
            String c = this.f4961l.mo1309c(b);
            return c + this.f4962m.mo1309c(b2);
        } else if (m7567R().m5814b(bbVar)) {
            return this.f4961l.mo1303b(bbVar);
        } else {
            if (m7568S().m5814b(bbVar)) {
                return this.f4962m.mo1303b(bbVar);
            }
            return "";
        }
    }

    /* renamed from: d */
    public Rect mo1311d(bb bbVar) {
        WebLog.init().w(m6108M());
        if (!f4952c && !mo1284G()) {
            throw new AssertionError();
        } else if (!f4952c && bbVar == null) {
            throw new AssertionError();
        } else if (!mo1284G()) {
            return new Rect();
        } else {
            if (bbVar == null || bbVar.m5817f()) {
                return new Rect();
            }
            if (m7567R().m5814b(bbVar) && m7568S().m5814b(bbVar)) {
                bb b = at.m7504b((at) bbVar, new at(m7567R().mo1460n(), m7567R().mo1461o()));
                bb b2 = at.m7504b((at) bbVar, new at(m7568S().mo1460n(), m7568S().mo1461o()));
                Rect d = this.f4961l.mo1311d(b);
                Rect d2 = this.f4962m.mo1311d(b2);
                m7572a(d);
                m7576b(d2);
                Rect rect = new Rect(d);
                rect.union(d2);
                return rect;
            } else if (m7567R().m5814b(bbVar)) {
                m7572a(this.f4961l.mo1311d(bbVar));
                return this.f4961l.mo1311d(bbVar);
            } else if (!m7568S().m5814b(bbVar)) {
                return new Rect();
            } else {
                m7576b(this.f4962m.mo1311d(bbVar));
                return this.f4962m.mo1311d(bbVar);
            }
        }
    }

    /* renamed from: e */
    public Rect[] mo1316e(bb bbVar) {
        WebLog.init().w(m6108M());
        if (!f4952c && !mo1284G()) {
            throw new AssertionError();
        } else if (!f4952c && bbVar == null) {
            throw new AssertionError();
        } else if (!mo1284G()) {
            return new Rect[0];
        } else {
            if (bbVar == null || bbVar.m5817f()) {
                return new Rect[0];
            }
            Rect[] rectArr;
            if (m7567R().m5814b(bbVar) && m7568S().m5814b(bbVar)) {
                bb b = at.m7504b((at) bbVar, new at(m7567R().mo1460n(), m7567R().mo1461o()));
                bb b2 = at.m7504b((at) bbVar, new at(m7568S().mo1460n(), m7568S().mo1461o()));
                Rect[] e = this.f4961l.mo1316e(b);
                Rect[] e2 = this.f4962m.mo1316e(b2);
                m7572a(e);
                m7576b(e2);
                rectArr = new Rect[(e.length + e2.length)];
                System.arraycopy(e, 0, rectArr, 0, e.length);
                System.arraycopy(e2, 0, rectArr, e.length, e2.length);
                return rectArr;
            } else if (m7567R().m5814b(bbVar)) {
                rectArr = this.f4961l.mo1316e(bbVar);
                m7572a(rectArr);
                return rectArr;
            } else if (!m7568S().m5814b(bbVar)) {
                return new Rect[0];
            } else {
                rectArr = this.f4962m.mo1316e(bbVar);
                m7576b(rectArr);
                return rectArr;
            }
        }
    }

    /* renamed from: f */
    public Point mo1318f(bb bbVar) {
        WebLog.init().w(m6108M());
        if (f4952c || mo1284G()) {
            Point point = new Point();
            Rect[] e = mo1316e(bbVar);
            if (e.length >= 1) {
                point.x = e[0].left;
                point.y = e[0].top;
            }
            return point;
        }
        throw new AssertionError();
    }

    /* renamed from: g */
    public Point mo1321g(bb bbVar) {
        WebLog.init().w(m6108M());
        if (f4952c || mo1284G()) {
            Point point = new Point();
            Rect[] e = mo1316e(bbVar);
            if (e.length >= 1) {
                point.x = e[e.length - 1].right;
                point.y = e[e.length - 1].bottom;
            }
            return point;
        }
        throw new AssertionError();
    }

    /* renamed from: k */
    public ac mo1329k(int i) {
        WebLog.init().w(m6108M());
        if (f4952c || mo1284G()) {
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: l */
    public Rect mo1331l(int i) {
        WebLog.init().w(m6108M());
        if (f4952c || mo1284G()) {
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: m */
    public Rect mo1333m(int i) {
        WebLog.init().w(m6108M());
        if (f4952c || mo1284G()) {
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: n */
    public aj mo1335n(int i) {
        WebLog.init().w(m6108M());
        if (f4952c || mo1284G()) {
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: p */
    public Rect mo1339p(int i) {
        WebLog.init().w(m6108M());
        if (f4952c || mo1284G()) {
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: o */
    public Rect mo1337o(int i) {
        WebLog.init().w(m6108M());
        if (f4952c || mo1284G()) {
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: q */
    public ad mo1341q(int i) {
        WebLog.init().w(m6108M());
        if (f4952c || mo1284G()) {
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: r */
    public Rect mo1344r(int i) {
        WebLog.init().w(m6108M());
        if (f4952c || mo1284G()) {
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: s */
    public ax mo1346s(int i) {
        WebLog.init().w(m6108M());
        if (f4952c || mo1284G()) {
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: t */
    public Rect mo1348t(int i) {
        WebLog.init().w(m6108M());
        if (f4952c || mo1284G()) {
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: u */
    public Rect mo1350u(int i) {
        WebLog.init().w(m6108M());
        if (f4952c || mo1284G()) {
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: v */
    public int mo1352v(int i) {
        WebLog.init().w(m6108M());
        if (f4952c || mo1284G()) {
            return -1;
        }
        throw new AssertionError();
    }

    /* renamed from: N */
    protected void mo1288N() {
        if (mo1284G()) {
            this.f4961l.mo1288N();
            this.f4962m.mo1288N();
        }
    }

    /* renamed from: b */
    protected int mo1300b(Canvas canvas, long j) {
        int rgb;
        int i = 2;
        Paint paint = this.f4967r;
        if (this.f4955f.e == 0) {
            rgb = Color.rgb(HttpStatus.SC_PROCESSING, HttpStatus.SC_PROCESSING, HttpStatus.SC_PROCESSING);
        } else {
            rgb = this.f4955f.e;
        }
        paint.setColor(rgb);
        this.f4967r.setSubpixelText(true);
        this.f4967r.setAntiAlias(true);
        if (this.f4961l == null || !this.f4961l.mo1284G()) {
            this.f4955f.a.setBounds(this.f4963n);
            this.f4955f.a.draw(canvas);
            rgb = 2;
        } else {
            this.f4961l.setBounds(this.f4963n);
            this.f4961l.m6117a(canvas, j);
            rgb = this.f4961l.m6151i();
        }
        if (this.f4962m == null || !this.f4962m.mo1284G()) {
            this.f4955f.a.setBounds(this.f4964o);
            this.f4955f.a.draw(canvas);
        } else {
            this.f4962m.setBounds(this.f4964o);
            this.f4962m.m6117a(canvas, j);
            i = this.f4962m.m6151i();
        }
        return rgb | i;
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f4963n = new Rect(rect.left, rect.top, rect.centerX(), rect.bottom);
        this.f4964o = new Rect(rect.centerX(), rect.top, rect.right, rect.bottom);
    }

    public int getIntrinsicWidth() {
        WebLog.init().w(m6108M());
        return super.getIntrinsicWidth() * 2;
    }

    /* renamed from: a */
    public boolean mo1299a() {
        WebLog.init().w(m6108M());
        return this.f4965p;
    }

    /* renamed from: P */
    public aj m7600P() {
        WebLog.init().w(m6108M());
        if (f4952c || mo1299a()) {
            return this.f4961l;
        }
        throw new AssertionError();
    }

    /* renamed from: Q */
    public aj m7601Q() {
        WebLog.init().w(m6108M());
        if (f4952c || mo1299a()) {
            return this.f4962m;
        }
        throw new AssertionError();
    }

    /* renamed from: d */
    public Rect mo1435d() {
        WebLog.init().w(m6108M());
        return this.f4963n;
    }

    /* renamed from: e */
    public Rect mo1436e() {
        WebLog.init().w(m6108M());
        return this.f4964o;
    }

    /* renamed from: h */
    private boolean m7583h(Point point) {
        return this.f4963n.contains(point.x, point.y);
    }

    /* renamed from: i */
    private boolean m7585i(Point point) {
        return this.f4964o.contains(point.x, point.y);
    }

    /* renamed from: a */
    private void m7572a(Rect... rectArr) {
        for (Rect offset : rectArr) {
            offset.offset(this.f4963n.left, this.f4963n.top);
        }
    }

    /* renamed from: b */
    private void m7576b(Rect... rectArr) {
        for (Rect offset : rectArr) {
            offset.offset(this.f4964o.left, this.f4964o.top);
        }
    }

    /* renamed from: j */
    private Point m7586j(Point point) {
        return new Point(point.x - this.f4963n.left, point.y - this.f4963n.top);
    }

    /* renamed from: k */
    private Point m7588k(Point point) {
        return new Point(point.x - this.f4964o.left, point.y - this.f4964o.top);
    }

    /* renamed from: R */
    private ai m7567R() {
        return (ai) this.f4961l.mo1332l();
    }

    /* renamed from: S */
    private ai m7568S() {
        return (ai) this.f4962m.mo1332l();
    }
}
