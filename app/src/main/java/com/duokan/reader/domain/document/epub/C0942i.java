package com.duokan.reader.domain.document.epub;

import android.graphics.Canvas;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.duokan.reader.domain.document.epub.i */
public class C0942i extends as implements C0941i {
    /* renamed from: c */
    static final /* synthetic */ boolean f4691c = (!C0942i.class.desiredAssertionStatus());
    /* renamed from: d */
    private final EpubTypesettingContext f4692d;
    /* renamed from: e */
    private final C0940h f4693e;
    /* renamed from: f */
    private au f4694f = null;
    /* renamed from: g */
    private final al f4695g;
    /* renamed from: h */
    private final at f4696h;
    /* renamed from: i */
    private final Callback f4697i = new C0943j(this);
    /* renamed from: j */
    private C0951r f4698j = null;
    /* renamed from: k */
    private boolean f4699k = false;
    /* renamed from: l */
    private az f4700l = null;
    /* renamed from: m */
    private az f4701m = null;
    /* renamed from: n */
    private az f4702n = null;
    /* renamed from: o */
    private az f4703o = null;
    /* renamed from: p */
    private Rect f4704p = new Rect();
    /* renamed from: q */
    private Rect f4705q = new Rect();
    /* renamed from: r */
    private boolean f4706r = false;
    /* renamed from: s */
    private boolean f4707s = false;
    /* renamed from: t */
    private CountDownLatch f4708t = null;

    /* renamed from: b */
    public /* synthetic */ as mo1305b() {
        return m6901R();
    }

    /* renamed from: c */
    public /* synthetic */ as mo1434c() {
        return m6902S();
    }

    public C0942i(EpubTypesettingContext epubTypesettingContext, C0940h c0940h, au auVar, al alVar, at atVar) {
        if (!f4691c && (epubTypesettingContext == null || auVar == null)) {
            throw new AssertionError();
        } else if (f4691c || (c0940h != null && c0940h.mo1186a())) {
            WebLog.init().w(m6108M());
            this.f4692d = epubTypesettingContext;
            this.f4692d.m5841b((Object) UThread.getCurrentThread());
            this.f4693e = new C0940h(this.f4692d, c0940h, 0);
            this.f4694f = auVar;
            this.f4695g = alVar;
            this.f4696h = atVar;
            this.f4698j = this.f4692d.m6444a(this.f4693e, new C0945k(this));
        } else {
            throw new AssertionError();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: O */
    public boolean m6898O() {
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
        r1 = r4.f4706r;	 Catch:{ all -> 0x001a }
        if (r1 == 0) goto L_0x001d;
    L_0x0018:
        monitor-exit(r4);	 Catch:{ all -> 0x001a }
        goto L_0x0012;
    L_0x001a:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x001a }
        throw r0;
    L_0x001d:
        r0 = r4.f4708t;	 Catch:{ all -> 0x001a }
        if (r0 != 0) goto L_0x0029;
    L_0x0021:
        r0 = new java.util.concurrent.CountDownLatch;	 Catch:{ all -> 0x001a }
        r1 = 1;
        r0.<init>(r1);	 Catch:{ all -> 0x001a }
        r4.f4708t = r0;	 Catch:{ all -> 0x001a }
    L_0x0029:
        monitor-exit(r4);	 Catch:{ all -> 0x001a }
    L_0x002a:
        r0 = r4.f4706r;
        if (r0 != 0) goto L_0x0050;
    L_0x002e:
        r0 = r4.f4698j;
        r0 = r0.m6797d();
        if (r0 != 0) goto L_0x0050;
    L_0x0036:
        r0 = r4.f4692d;
        r0 = r0.a;
        if (r0 == 0) goto L_0x0050;
    L_0x003c:
        r0 = r4.f4692d;
        r0 = r0.mo1272c();
        if (r0 != 0) goto L_0x0050;
    L_0x0044:
        r0 = r4.f4708t;	 Catch:{ InterruptedException -> 0x004e }
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
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.document.epub.i.O():boolean");
    }

    /* renamed from: j */
    public long mo1327j() {
        WebLog.init().w(m6108M());
        if (!f4691c && !mo1284G()) {
            throw new AssertionError();
        } else if (mo1284G()) {
            return this.f4700l.mo1327j();
        } else {
            return -1;
        }
    }

    /* renamed from: k */
    public boolean mo1330k() {
        WebLog.init().w(m6108M());
        if (!mo1284G()) {
            return false;
        }
        if (this.f4700l.mo1330k() || this.f4701m.mo1330k()) {
            return true;
        }
        return false;
    }

    /* renamed from: l */
    public ak mo1332l() {
        WebLog.init().w(m6108M());
        return this.f4693e;
    }

    /* renamed from: m */
    public bb mo1334m() {
        WebLog.init().w(m6108M());
        if (mo1282E()) {
            return new ce(this.f4693e.m6850n(), this.f4693e.m6851o());
        }
        return new ce();
    }

    /* renamed from: n */
    public C0897d[] mo1336n() {
        WebLog.init().w(m6108M());
        if (!mo1282E()) {
            return new C0897d[0];
        }
        Object e = this.f4700l.m6626e();
        Object e2 = this.f4701m.m6626e();
        C0897d[] c0897dArr = new C0936c[(e.length + e2.length)];
        System.arraycopy(e, 0, c0897dArr, 0, e.length);
        System.arraycopy(e2, 0, c0897dArr, e.length, e2.length);
        return c0897dArr;
    }

    /* renamed from: o */
    public CharSequence mo1338o() {
        WebLog.init().w(m6108M());
        if (!mo1282E()) {
            return "";
        }
        CharSequence o = this.f4700l.mo1338o();
        CharSequence o2 = this.f4701m.mo1338o();
        return TextUtils.concat(new CharSequence[]{o, o2});
    }

    /* renamed from: p */
    public C0917k mo1340p() {
        WebLog.init().w(m6108M());
        return this.f4692d.m6455j();
    }

    /* renamed from: q */
    public C0923m mo1342q() {
        WebLog.init().w(m6108M());
        return this.f4694f;
    }

    /* renamed from: a */
    public void mo1296a(C0923m c0923m) {
        WebLog.init().w(m6108M());
        if (mo1282E()) {
            this.f4694f = (au) c0923m;
            C0923m auVar = new au(this.f4694f);
            auVar.l = this.f4700l.mo1342q().f4364l;
            auVar.m = this.f4700l.mo1342q().f4365m;
            auVar.f4491r = ((au) this.f4700l.mo1342q()).f4491r;
            C0923m auVar2 = new au(this.f4694f);
            auVar2.l = this.f4701m.mo1342q().f4364l;
            auVar2.m = this.f4701m.mo1342q().f4365m;
            auVar2.f4491r = ((au) this.f4701m.mo1342q()).f4491r;
            this.f4700l.mo1296a(auVar);
            this.f4701m.mo1296a(auVar2);
        }
    }

    /* renamed from: r */
    public int mo1343r() {
        WebLog.init().w(m6108M());
        if (!f4691c && !mo1284G()) {
            throw new AssertionError();
        } else if (mo1284G()) {
            return this.f4700l.mo1343r() + this.f4701m.mo1343r();
        } else {
            return 0;
        }
    }

    /* renamed from: s */
    public int mo1345s() {
        WebLog.init().w(m6108M());
        if (!f4691c && !mo1284G()) {
            throw new AssertionError();
        } else if (mo1284G()) {
            return this.f4700l.mo1345s() + this.f4701m.mo1345s();
        } else {
            return 0;
        }
    }

    /* renamed from: t */
    public int mo1347t() {
        WebLog.init().w(m6108M());
        if (mo1284G()) {
            return this.f4700l.mo1347t() + this.f4701m.mo1347t();
        }
        return 0;
    }

    /* renamed from: u */
    public int mo1349u() {
        WebLog.init().w(m6108M());
        if (mo1284G()) {
            return this.f4700l.mo1349u() + this.f4701m.mo1349u();
        }
        return 0;
    }

    /* renamed from: x */
    public int mo1354x() {
        WebLog.init().w(m6108M());
        if (mo1284G()) {
            return this.f4700l.mo1354x() + this.f4701m.mo1354x();
        }
        return 0;
    }

    /* renamed from: v */
    public int mo1351v() {
        WebLog.init().w(m6108M());
        if (mo1284G()) {
            return this.f4700l.mo1351v() + this.f4701m.mo1351v();
        }
        return 0;
    }

    /* renamed from: w */
    public int mo1353w() {
        WebLog.init().w(m6108M());
        if (mo1284G()) {
            return this.f4700l.mo1353w() + this.f4701m.mo1353w();
        }
        return 0;
    }

    /* renamed from: y */
    public int mo1355y() {
        WebLog.init().w(m6108M());
        if (mo1284G()) {
            return this.f4700l.mo1355y() + this.f4701m.mo1355y();
        }
        return 0;
    }

    /* renamed from: z */
    public Rect mo1356z() {
        WebLog.init().w(m6108M());
        if (!mo1284G()) {
            return new Rect(0, 0, 0, 0);
        }
        if (!this.f4701m.mo1356z().isEmpty()) {
            m6867b(this.f4701m.mo1356z());
            return this.f4701m.mo1356z();
        } else if (this.f4700l.mo1356z().isEmpty()) {
            return new Rect(0, 0, 0, 0);
        } else {
            m6863a(this.f4700l.mo1356z());
            return this.f4700l.mo1356z();
        }
    }

    /* renamed from: A */
    public Rect mo1280A() {
        WebLog.init().w(m6108M());
        if (!mo1284G()) {
            return new Rect(0, 0, 0, 0);
        }
        if (!this.f4700l.mo1280A().isEmpty()) {
            return mo1435d();
        }
        if (this.f4701m.mo1280A().isEmpty()) {
            return new Rect(0, 0, 0, 0);
        }
        return mo1436e();
    }

    /* renamed from: B */
    public int mo1281B() {
        WebLog.init().w(m6108M());
        if (mo1282E()) {
            return this.f4700l.mo1281B() + this.f4701m.mo1281B();
        }
        return 0;
    }

    /* renamed from: a */
    public Rect mo1291a(au auVar) {
        WebLog.init().w(m6108M());
        if (!mo1282E()) {
            return new Rect();
        }
        if (this.f4700l.m6613b(auVar)) {
            return new Rect(mo1435d());
        }
        if (this.f4701m.m6613b(auVar)) {
            return new Rect(mo1436e());
        }
        return new Rect();
    }

    /* renamed from: E */
    public boolean mo1282E() {
        WebLog.init().w(m6108M());
        if (mo1284G()) {
            return true;
        }
        if (m6898O() && this.f4700l.mo1282E() && this.f4701m.mo1282E()) {
            return mo1284G();
        }
        return false;
    }

    /* renamed from: a */
    public void mo1297a(Runnable runnable, Runnable runnable2) {
        WebLog.init().w(m6108M());
        ah.m871b(new C0948n(this, runnable2, runnable));
    }

    /* renamed from: F */
    public boolean mo1283F() {
        WebLog.init().w(m6108M());
        return this.f4698j.m6797d();
    }

    /* renamed from: G */
    public boolean mo1284G() {
        WebLog.init().w(m6108M());
        if (!this.f4698j.m6797d() && mo1299a() && this.f4700l.mo1284G() && this.f4701m.mo1284G()) {
            return true;
        }
        return false;
    }

    /* renamed from: H */
    public void mo1285H() {
        WebLog.init().w(m6108M());
        if (!this.f4698j.m6797d()) {
            this.f4698j.mo1440a();
            if (mo1299a()) {
                this.f4700l.mo1285H();
                this.f4701m.mo1285H();
            }
            this.f4692d.m5842c(UThread.getCurrentThread());
        }
    }

    /* renamed from: a */
    public void mo1298a(boolean z) {
        if (mo1299a()) {
            this.f4700l.mo1298a(z);
            this.f4701m.mo1298a(z);
        }
    }

    /* renamed from: a */
    public ae mo1292a(Point point) {
        WebLog.init().w(m6108M());
        if (!mo1284G()) {
            return null;
        }
        if (m6876h(point)) {
            return this.f4700l.mo1292a(m6885n(point));
        } else if (!m6878i(point)) {
            return null;
        } else {
            return this.f4701m.mo1292a(m6886o(point));
        }
    }

    /* renamed from: a */
    public bb mo1293a(Point point, Point point2) {
        WebLog.init().w(m6108M());
        if (!mo1284G()) {
            return new ce(new C0936c(0, 0, 0), new C0936c(0, 0, 0));
        }
        if (m6880j(point) && !m6881k(point2)) {
            return this.f4702n.m6609b(m6887p(point), m6887p(point2));
        } else if (m6881k(point) && !m6880j(point2)) {
            return this.f4703o.m6609b(m6888q(point), m6888q(point2));
        } else if (m6880j(point) && m6881k(point2)) {
            r0 = m6887p(point);
            r1 = new Point(this.f4702n.mo1340p().m6084b().right, this.f4702n.mo1340p().m6084b().bottom);
            r2 = new Point(this.f4703o.mo1340p().m6084b().left, this.f4703o.mo1340p().m6084b().top);
            r3 = m6888q(point2);
            r0 = this.f4702n.m6609b(r0, r1);
            r1 = this.f4703o.m6609b(r2, r3);
            if (f4691c || (r0 != null && r1 != null)) {
                return ce.m6800a(r0, r1);
            }
            throw new AssertionError();
        } else if (!m6881k(point) || !m6880j(point2)) {
            return new ce(new C0936c(0, 0, 0), new C0936c(0, 0, 0));
        } else {
            r0 = m6887p(point2);
            r1 = new Point(this.f4702n.mo1340p().m6084b().right, this.f4702n.mo1340p().m6084b().bottom);
            r2 = new Point(this.f4703o.mo1340p().m6084b().left, this.f4703o.mo1340p().m6084b().top);
            r3 = m6888q(point);
            r0 = this.f4702n.m6609b(r0, r1);
            r1 = this.f4703o.m6609b(r2, r3);
            if (f4691c || (r0 != null && r1 != null)) {
                return ce.m6800a(r0, r1);
            }
            throw new AssertionError();
        }
    }

    /* renamed from: b */
    public bb mo1302b(Point point) {
        WebLog.init().w(m6108M());
        if (!mo1284G()) {
            return new ce(new C0936c(0, 0, 0), new C0936c(0, 0, 0));
        }
        if (m6876h(point)) {
            return this.f4700l.m6634h(m6885n(point));
        } else if (!m6878i(point)) {
            return new ce(new C0936c(0, 0, 0), new C0936c(0, 0, 0));
        } else {
            return this.f4701m.m6634h(m6886o(point));
        }
    }

    /* renamed from: c */
    public int mo1306c(Point point) {
        WebLog.init().w(m6108M());
        if (!mo1284G()) {
            return -1;
        }
        if (m6876h(point)) {
            return this.f4700l.mo1306c(m6885n(point));
        } else if (!m6878i(point)) {
            return -1;
        } else {
            int c = this.f4701m.mo1306c(m6886o(point));
            if (c >= 0) {
                return this.f4700l.mo1343r() + c;
            }
            return -1;
        }
    }

    /* renamed from: f */
    public int mo1317f(Point point) {
        WebLog.init().w(m6108M());
        if (!mo1284G()) {
            return -1;
        }
        if (m6876h(point)) {
            return this.f4700l.mo1317f(m6885n(point));
        } else if (!m6878i(point)) {
            return -1;
        } else {
            int f = this.f4701m.mo1317f(m6886o(point));
            if (f >= 0) {
                return this.f4700l.mo1345s() + f;
            }
            return -1;
        }
    }

    /* renamed from: g */
    public int mo1320g(Point point) {
        WebLog.init().w(m6108M());
        if (!mo1284G()) {
            return -1;
        }
        if (m6876h(point)) {
            return this.f4700l.mo1320g(m6885n(point));
        } else if (!m6878i(point)) {
            return -1;
        } else {
            int g = this.f4701m.mo1320g(m6886o(point));
            if (g >= 0) {
                return this.f4700l.mo1281B() + g;
            }
            return -1;
        }
    }

    /* renamed from: a */
    public int mo1289a(Point point, int i) {
        WebLog.init().w(m6108M());
        if (!mo1284G()) {
            return -1;
        }
        if (m6876h(point)) {
            return this.f4700l.mo1289a(m6885n(point), i);
        } else if (!m6878i(point)) {
            return -1;
        } else {
            int a = this.f4701m.mo1289a(m6886o(point), i);
            if (a >= 0) {
                return this.f4700l.mo1347t() + a;
            }
            return -1;
        }
    }

    /* renamed from: d */
    public int mo1310d(Point point) {
        WebLog.init().w(m6108M());
        if (!mo1284G()) {
            return -1;
        }
        if (m6876h(point)) {
            return this.f4700l.mo1310d(m6885n(point));
        } else if (!m6878i(point)) {
            return -1;
        } else {
            int d = this.f4701m.mo1310d(m6886o(point));
            if (d >= 0) {
                return this.f4700l.mo1349u() + d;
            }
            return -1;
        }
    }

    /* renamed from: e */
    public int mo1314e(Point point) {
        WebLog.init().w(m6108M());
        if (!mo1284G()) {
            return -1;
        }
        if (m6876h(point)) {
            return this.f4700l.mo1314e(m6885n(point));
        } else if (!m6878i(point)) {
            return -1;
        } else {
            int e = this.f4701m.mo1314e(m6886o(point));
            if (e >= 0) {
                return this.f4700l.mo1351v() + e;
            }
            return -1;
        }
    }

    /* renamed from: a */
    public int mo1290a(bb bbVar) {
        WebLog.init().w(m6108M());
        if (!mo1284G()) {
            return -1;
        }
        int a = this.f4700l.mo1290a(bbVar);
        if (a >= 0) {
            return a;
        }
        a = this.f4701m.mo1290a(bbVar);
        if (a >= 0) {
            return this.f4700l.mo1351v() + a;
        }
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
        if (!mo1282E()) {
            return null;
        }
        if (i < this.f4700l.mo1343r()) {
            return this.f4700l.mo1308c(i);
        }
        return this.f4701m.mo1308c(i - this.f4700l.mo1343r());
    }

    /* renamed from: d */
    public aw mo1312d(int i) {
        WebLog.init().w(m6108M());
        if (!mo1282E()) {
            return null;
        }
        if (i < this.f4700l.mo1345s()) {
            return this.f4700l.mo1312d(i);
        }
        return this.f4701m.mo1312d(i - this.f4700l.mo1345s());
    }

    /* renamed from: e */
    public ab mo1315e(int i) {
        WebLog.init().w(m6108M());
        if (!mo1282E()) {
            return null;
        }
        if (i < this.f4700l.mo1347t()) {
            return this.f4700l.mo1315e(i);
        }
        return this.f4701m.mo1315e(i - this.f4700l.mo1347t());
    }

    /* renamed from: f */
    public com.duokan.reader.domain.document.ah mo1319f(int i) {
        WebLog.init().w(m6108M());
        if (!mo1282E()) {
            return null;
        }
        if (i < this.f4700l.mo1349u()) {
            return this.f4700l.mo1319f(i);
        }
        return this.f4701m.mo1319f(i - this.f4700l.mo1349u());
    }

    /* renamed from: g */
    public Rect mo1322g(int i) {
        WebLog.init().w(m6108M());
        if (!mo1282E()) {
            return new Rect();
        }
        if (i < this.f4700l.mo1343r()) {
            m6863a(new Rect(this.f4700l.mo1322g(i)));
            return new Rect(this.f4700l.mo1322g(i));
        }
        m6867b(new Rect(this.f4701m.mo1322g(i - this.f4700l.mo1343r())));
        return new Rect(this.f4701m.mo1322g(i - this.f4700l.mo1343r()));
    }

    /* renamed from: h */
    public Rect mo1325h(int i) {
        WebLog.init().w(m6108M());
        if (!mo1282E()) {
            return new Rect();
        }
        if (i < this.f4700l.mo1345s()) {
            m6863a(new Rect(this.f4700l.mo1325h(i)));
            return new Rect(this.f4700l.mo1325h(i));
        }
        m6867b(new Rect(this.f4701m.mo1325h(i - this.f4700l.mo1345s())));
        return new Rect(this.f4701m.mo1325h(i - this.f4700l.mo1345s()));
    }

    /* renamed from: i */
    public Rect mo1326i(int i) {
        WebLog.init().w(m6108M());
        if (!mo1282E()) {
            return new Rect();
        }
        if (i < this.f4700l.mo1347t()) {
            m6863a(new Rect(this.f4700l.mo1326i(i)));
            return new Rect(this.f4700l.mo1326i(i));
        }
        m6867b(new Rect(this.f4701m.mo1326i(i - this.f4700l.mo1347t())));
        return new Rect(this.f4701m.mo1326i(i - this.f4700l.mo1347t()));
    }

    /* renamed from: j */
    public Rect mo1328j(int i) {
        WebLog.init().w(m6108M());
        if (!mo1282E()) {
            return new Rect();
        }
        if (i < this.f4700l.mo1349u()) {
            m6863a(new Rect(this.f4700l.mo1328j(i)));
            return new Rect(this.f4700l.mo1328j(i));
        }
        m6867b(new Rect(this.f4701m.mo1328j(i - this.f4700l.mo1349u())));
        return new Rect(this.f4701m.mo1328j(i - this.f4700l.mo1349u()));
    }

    /* renamed from: I */
    public String mo1286I() {
        WebLog.init().w(m6108M());
        if (mo1282E()) {
            return this.f4700l.mo1286I() + this.f4701m.mo1286I();
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
        if (m6858T().m5814b(bbVar) && m6859U().m5814b(bbVar)) {
            bb b = ce.m6802b((ce) bbVar, new ce(m6858T().m6533k(), m6859U().m6534l()));
            bb b2 = ce.m6802b((ce) bbVar, new ce(m6859U().m6533k(), m6859U().m6534l()));
            String b3 = m6901R().mo1303b(b);
            return b3 + m6902S().mo1303b(b2);
        } else if (m6858T().m5814b(bbVar)) {
            return this.f4700l.mo1303b(bbVar);
        } else {
            if (m6859U().m5814b(bbVar)) {
                return this.f4701m.mo1303b(bbVar);
            }
            return "";
        }
    }

    /* renamed from: J */
    public String mo1287J() {
        WebLog.init().w(m6108M());
        if (mo1282E()) {
            return this.f4700l.mo1287J() + this.f4701m.mo1287J();
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
        if (m6858T().m5814b(bbVar) && m6859U().m5814b(bbVar)) {
            bb b = ce.m6802b((ce) bbVar, new ce(m6858T().m6533k(), m6858T().m6534l()));
            bb b2 = ce.m6802b((ce) bbVar, new ce(m6859U().m6533k(), m6859U().m6534l()));
            String c = this.f4700l.mo1309c(b);
            return c + this.f4701m.mo1309c(b2);
        } else if (m6858T().m5814b(bbVar)) {
            return this.f4700l.mo1303b(bbVar);
        } else {
            if (m6859U().m5814b(bbVar)) {
                return this.f4701m.mo1303b(bbVar);
            }
            return "";
        }
    }

    /* renamed from: d */
    public Rect mo1311d(bb bbVar) {
        WebLog.init().w(m6108M());
        if (!f4691c && !mo1284G()) {
            throw new AssertionError();
        } else if (!f4691c && bbVar == null) {
            throw new AssertionError();
        } else if (!mo1284G()) {
            return new Rect();
        } else {
            if (bbVar == null || bbVar.m5817f()) {
                return new Rect();
            }
            if (m6858T().m5814b(bbVar) && m6859U().m5814b(bbVar)) {
                bb b = ce.m6802b((ce) bbVar, new ce(m6858T().m6533k(), m6858T().m6534l()));
                bb b2 = ce.m6802b((ce) bbVar, new ce(m6859U().m6533k(), m6859U().m6534l()));
                Rect d = this.f4700l.mo1311d(b);
                Rect d2 = this.f4701m.mo1311d(b2);
                m6863a(d);
                m6867b(d2);
                Rect rect = new Rect(d);
                rect.union(d2);
                return rect;
            } else if (m6858T().m5814b(bbVar)) {
                m6863a(this.f4700l.mo1311d(bbVar));
                return this.f4700l.mo1311d(bbVar);
            } else if (!m6859U().m5814b(bbVar)) {
                return new Rect();
            } else {
                m6867b(this.f4701m.mo1311d(bbVar));
                return this.f4701m.mo1311d(bbVar);
            }
        }
    }

    /* renamed from: e */
    public Rect[] mo1316e(bb bbVar) {
        WebLog.init().w(m6108M());
        if (!f4691c && !mo1284G()) {
            throw new AssertionError();
        } else if (!f4691c && bbVar == null) {
            throw new AssertionError();
        } else if (!mo1284G()) {
            return new Rect[0];
        } else {
            if (bbVar == null || bbVar.m5817f()) {
                return new Rect[0];
            }
            Rect[] rectArr;
            if (m6858T().m5814b(bbVar) && m6859U().m5814b(bbVar)) {
                bb b = ce.m6802b((ce) bbVar, new ce(m6858T().m6533k(), m6858T().m6534l()));
                bb b2 = ce.m6802b((ce) bbVar, new ce(m6859U().m6533k(), m6859U().m6534l()));
                Rect[] e = this.f4700l.mo1316e(b);
                Rect[] e2 = this.f4701m.mo1316e(b2);
                m6863a(e);
                m6867b(e2);
                rectArr = new Rect[(e.length + e2.length)];
                System.arraycopy(e, 0, rectArr, 0, e.length);
                System.arraycopy(e2, 0, rectArr, e.length, e2.length);
                return rectArr;
            } else if (m6858T().m5814b(bbVar)) {
                rectArr = this.f4700l.mo1316e(bbVar);
                m6863a(rectArr);
                return rectArr;
            } else if (!m6859U().m5814b(bbVar)) {
                return new Rect[0];
            } else {
                rectArr = this.f4701m.mo1316e(bbVar);
                m6867b(rectArr);
                return rectArr;
            }
        }
    }

    /* renamed from: f */
    public Point mo1318f(bb bbVar) {
        WebLog.init().w(m6108M());
        if (!f4691c && !mo1284G()) {
            throw new AssertionError();
        } else if (m6858T().m5814b(bbVar)) {
            return m6883l(this.f4700l.mo1318f(bbVar));
        } else {
            if (m6859U().m5814b(bbVar)) {
                return m6884m(this.f4701m.mo1318f(bbVar));
            }
            return new Point();
        }
    }

    /* renamed from: g */
    public Point mo1321g(bb bbVar) {
        WebLog.init().w(m6108M());
        if (!f4691c && !mo1284G()) {
            throw new AssertionError();
        } else if (m6859U().m5814b(bbVar)) {
            return m6884m(this.f4701m.mo1321g(bbVar));
        } else {
            if (m6858T().m5814b(bbVar)) {
                return m6883l(this.f4700l.mo1321g(bbVar));
            }
            return new Point();
        }
    }

    /* renamed from: k */
    public ac mo1329k(int i) {
        WebLog.init().w(m6108M());
        if (!mo1282E()) {
            return null;
        }
        if (i < this.f4700l.mo1351v()) {
            return this.f4700l.mo1329k(i);
        }
        return this.f4701m.mo1329k(i - this.f4700l.mo1351v());
    }

    /* renamed from: l */
    public Rect mo1331l(int i) {
        WebLog.init().w(m6108M());
        if (!mo1282E()) {
            return new Rect();
        }
        if (i < this.f4700l.mo1351v()) {
            m6863a(new Rect(this.f4700l.mo1331l(i)));
            return new Rect(this.f4700l.mo1331l(i));
        }
        m6867b(new Rect(this.f4701m.mo1331l(i - this.f4700l.mo1351v())));
        return new Rect(this.f4701m.mo1331l(i - this.f4700l.mo1351v()));
    }

    /* renamed from: m */
    public Rect mo1333m(int i) {
        WebLog.init().w(m6108M());
        if (!mo1282E()) {
            return new Rect();
        }
        if (i < this.f4700l.mo1351v()) {
            m6863a(new Rect(this.f4700l.mo1333m(i)));
            return new Rect(this.f4700l.mo1333m(i));
        }
        m6867b(new Rect(this.f4701m.mo1333m(i - this.f4700l.mo1351v())));
        return new Rect(this.f4701m.mo1333m(i - this.f4700l.mo1351v()));
    }

    /* renamed from: n */
    public aj mo1335n(int i) {
        WebLog.init().w(m6108M());
        if (!mo1282E()) {
            return null;
        }
        if (i < this.f4700l.mo1353w()) {
            return this.f4700l.mo1335n(i);
        }
        return this.f4701m.mo1335n(i - this.f4700l.mo1353w());
    }

    /* renamed from: p */
    public Rect mo1339p(int i) {
        WebLog.init().w(m6108M());
        if (!mo1282E()) {
            return new Rect();
        }
        if (i < this.f4700l.mo1353w()) {
            m6863a(new Rect(this.f4700l.mo1339p(i)));
            return new Rect(this.f4700l.mo1339p(i));
        }
        m6867b(new Rect(this.f4701m.mo1339p(i - this.f4700l.mo1353w())));
        return new Rect(this.f4701m.mo1339p(i - this.f4700l.mo1353w()));
    }

    /* renamed from: o */
    public Rect mo1337o(int i) {
        WebLog.init().w(m6108M());
        if (!mo1282E()) {
            return new Rect();
        }
        if (i < this.f4700l.mo1353w()) {
            m6863a(new Rect(this.f4700l.mo1337o(i)));
            return new Rect(this.f4700l.mo1337o(i));
        }
        m6867b(new Rect(this.f4701m.mo1337o(i - this.f4700l.mo1353w())));
        return new Rect(this.f4701m.mo1337o(i - this.f4700l.mo1353w()));
    }

    /* renamed from: q */
    public ad mo1341q(int i) {
        WebLog.init().w(m6108M());
        if (!mo1282E()) {
            return null;
        }
        if (i < this.f4700l.mo1354x()) {
            return this.f4700l.m6663w(i);
        }
        return this.f4701m.m6663w(i - this.f4700l.mo1354x());
    }

    /* renamed from: r */
    public Rect mo1344r(int i) {
        WebLog.init().w(m6108M());
        if (!mo1282E()) {
            return new Rect();
        }
        if (i < this.f4700l.mo1354x()) {
            m6863a(new Rect(this.f4700l.mo1344r(i)));
            return new Rect(this.f4700l.mo1344r(i));
        }
        m6867b(new Rect(this.f4701m.mo1344r(i - this.f4700l.mo1354x())));
        return new Rect(this.f4701m.mo1344r(i - this.f4700l.mo1354x()));
    }

    /* renamed from: s */
    public ax mo1346s(int i) {
        WebLog.init().w(m6108M());
        if (!mo1282E()) {
            return null;
        }
        if (i < this.f4700l.mo1355y()) {
            return this.f4700l.mo1346s(i);
        }
        return this.f4701m.mo1346s(i - this.f4700l.mo1355y());
    }

    /* renamed from: t */
    public Rect mo1348t(int i) {
        WebLog.init().w(m6108M());
        if (!mo1282E()) {
            return new Rect();
        }
        if (i < this.f4700l.mo1355y()) {
            m6863a(new Rect(this.f4700l.mo1348t(i)));
            return new Rect(this.f4700l.mo1348t(i));
        }
        m6867b(new Rect(this.f4701m.mo1348t(i - this.f4700l.mo1355y())));
        return new Rect(this.f4701m.mo1348t(i - this.f4700l.mo1355y()));
    }

    /* renamed from: u */
    public Rect mo1350u(int i) {
        WebLog.init().w(m6108M());
        if (!mo1282E()) {
            return new Rect();
        }
        if (i < this.f4700l.mo1281B()) {
            return this.f4700l.mo1350u(i);
        }
        m6867b(new Rect(this.f4701m.mo1350u(i - this.f4700l.mo1281B())));
        return new Rect(this.f4701m.mo1350u(i - this.f4700l.mo1281B()));
    }

    /* renamed from: v */
    public int mo1352v(int i) {
        WebLog.init().w(m6108M());
        if (!mo1282E()) {
            return -1;
        }
        if (i < this.f4700l.mo1281B()) {
            return this.f4700l.mo1352v(i);
        }
        return this.f4701m.mo1352v(i - this.f4700l.mo1281B());
    }

    /* renamed from: P */
    public List<av> mo1374P() {
        WebLog.init().w(m6108M());
        if (!mo1282E()) {
            return Collections.emptyList();
        }
        Collection P = this.f4700l.mo1374P();
        Collection P2 = this.f4701m.mo1374P();
        List<av> arrayList = new ArrayList(P.size() + P2.size());
        arrayList.addAll(P);
        arrayList.addAll(P2);
        return arrayList;
    }

    /* renamed from: Q */
    public List<av> mo1375Q() {
        WebLog.init().w(m6108M());
        if (!mo1282E()) {
            return Collections.emptyList();
        }
        Collection Q = this.f4700l.mo1375Q();
        Collection Q2 = this.f4701m.mo1375Q();
        List<av> arrayList = new ArrayList(Q.size() + Q2.size());
        arrayList.addAll(Q);
        arrayList.addAll(Q2);
        return arrayList;
    }

    /* renamed from: a */
    public boolean mo1299a() {
        WebLog.init().w(m6108M());
        return this.f4706r;
    }

    /* renamed from: R */
    public az m6901R() {
        WebLog.init().w(m6108M());
        if (f4691c || mo1299a()) {
            return this.f4700l;
        }
        throw new AssertionError();
    }

    /* renamed from: S */
    public az m6902S() {
        WebLog.init().w(m6108M());
        if (f4691c || mo1299a()) {
            return this.f4701m;
        }
        throw new AssertionError();
    }

    /* renamed from: d */
    public Rect mo1435d() {
        if (mo1299a()) {
            return this.f4700l == this.f4702n ? this.f4704p : this.f4705q;
        } else {
            return this.f4704p;
        }
    }

    /* renamed from: e */
    public Rect mo1436e() {
        if (mo1299a()) {
            return this.f4700l == this.f4702n ? this.f4705q : this.f4704p;
        } else {
            return this.f4705q;
        }
    }

    /* renamed from: N */
    protected void mo1288N() {
        if (mo1284G()) {
            this.f4700l.mo1288N();
            this.f4701m.mo1288N();
        }
    }

    /* renamed from: b */
    protected int mo1300b(Canvas canvas, long j) {
        int i;
        int i2 = 2;
        if (this.f4700l == null || !this.f4700l.mo1284G()) {
            this.f4694f.a.setBounds(mo1435d());
            this.f4694f.a.draw(canvas);
            i = 2;
        } else {
            this.f4700l.setBounds(mo1435d());
            this.f4700l.m6117a(canvas, j);
            i = this.f4700l.m6151i();
        }
        if (this.f4701m == null || !this.f4701m.mo1284G()) {
            this.f4694f.a.setBounds(mo1436e());
            this.f4694f.a.draw(canvas);
        } else {
            this.f4701m.setBounds(mo1436e());
            this.f4701m.m6117a(canvas, j);
            i2 = this.f4701m.m6151i();
        }
        return i | i2;
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f4704p = new Rect(rect.left, rect.top, rect.centerX(), rect.bottom);
        this.f4705q = new Rect(rect.centerX(), rect.top, rect.right, rect.bottom);
    }

    public int getIntrinsicWidth() {
        WebLog.init().w(m6108M());
        return super.getIntrinsicWidth() * 2;
    }

    public int getIntrinsicHeight() {
        WebLog.init().w(m6108M());
        if (mo1284G()) {
            return Math.max(this.f4700l.getIntrinsicHeight(), this.f4701m.getIntrinsicHeight());
        }
        return super.getIntrinsicHeight();
    }

    /* renamed from: h */
    private boolean m6876h(Point point) {
        return mo1435d().contains(point.x, point.y);
    }

    /* renamed from: i */
    private boolean m6878i(Point point) {
        return mo1436e().contains(point.x, point.y);
    }

    /* renamed from: j */
    private boolean m6880j(Point point) {
        return this.f4704p.contains(point.x, point.y);
    }

    /* renamed from: k */
    private boolean m6881k(Point point) {
        return this.f4705q.contains(point.x, point.y);
    }

    /* renamed from: a */
    private void m6863a(Rect... rectArr) {
        Rect d = mo1435d();
        for (Rect offset : rectArr) {
            offset.offset(d.left, d.top);
        }
    }

    /* renamed from: b */
    private void m6867b(Rect... rectArr) {
        Rect e = mo1436e();
        for (Rect offset : rectArr) {
            offset.offset(e.left, e.top);
        }
    }

    /* renamed from: l */
    private Point m6883l(Point point) {
        Rect d = mo1435d();
        return new Point(point.x + d.left, d.top + point.y);
    }

    /* renamed from: m */
    private Point m6884m(Point point) {
        Rect e = mo1436e();
        return new Point(point.x + e.left, e.top + point.y);
    }

    /* renamed from: n */
    private Point m6885n(Point point) {
        Rect d = mo1435d();
        return new Point(point.x - d.left, point.y - d.top);
    }

    /* renamed from: o */
    private Point m6886o(Point point) {
        Rect e = mo1436e();
        return new Point(point.x - e.left, point.y - e.top);
    }

    /* renamed from: p */
    private Point m6887p(Point point) {
        return new Point(point.x - this.f4704p.left, point.y - this.f4704p.top);
    }

    /* renamed from: q */
    private Point m6888q(Point point) {
        return new Point(point.x - this.f4705q.left, point.y - this.f4705q.top);
    }

    /* renamed from: T */
    private ay m6858T() {
        return (ay) this.f4700l.mo1332l();
    }

    /* renamed from: U */
    private ay m6859U() {
        return (ay) this.f4701m.mo1332l();
    }
}
