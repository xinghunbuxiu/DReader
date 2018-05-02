package com.duokan.reader.domain.document.sbk;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.sys.UThread;
import com.duokan.core.sys.ah;
import com.duokan.kernel.DkUtils;
import com.duokan.reader.domain.document.C0897d;
import com.duokan.reader.domain.document.C0901g;
import com.duokan.reader.domain.document.C0911h;
import com.duokan.reader.domain.document.C0917k;
import com.duokan.reader.domain.document.C0923m;
import com.duokan.reader.domain.document.ab;
import com.duokan.reader.domain.document.ac;
import com.duokan.reader.domain.document.ad;
import com.duokan.reader.domain.document.ae;
import com.duokan.reader.domain.document.af;
import com.duokan.reader.domain.document.aj;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.al;
import com.duokan.reader.domain.document.ap;
import com.duokan.reader.domain.document.at;
import com.duokan.reader.domain.document.au;
import com.duokan.reader.domain.document.aw;
import com.duokan.reader.domain.document.ax;
import com.duokan.reader.domain.document.ba;
import com.duokan.reader.domain.document.bb;
import com.duokan.reader.domain.document.bc;
import com.duokan.reader.domain.document.bd;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* renamed from: com.duokan.reader.domain.document.sbk.y */
public class C0983y extends C0980u implements ba, bd, af {
    /* renamed from: c */
    static final /* synthetic */ boolean f4853c = (!C0983y.class.desiredAssertionStatus());
    /* renamed from: d */
    private final SbkTypesettingContext f4854d;
    /* renamed from: e */
    private final C0982x f4855e;
    /* renamed from: f */
    private C0981w f4856f = null;
    /* renamed from: g */
    private final al f4857g;
    /* renamed from: h */
    private final at f4858h;
    /* renamed from: i */
    private ag f4859i = null;
    /* renamed from: j */
    private boolean f4860j = false;
    /* renamed from: k */
    private boolean f4861k = false;
    /* renamed from: l */
    private boolean f4862l = false;
    /* renamed from: m */
    private int f4863m = -1;
    /* renamed from: n */
    private long f4864n = -1;
    /* renamed from: o */
    private String f4865o = null;
    /* renamed from: p */
    private String f4866p = null;
    /* renamed from: q */
    private ap f4867q = null;
    /* renamed from: r */
    private ap f4868r = null;
    /* renamed from: s */
    private List<String> f4869s = Collections.emptyList();

    /* renamed from: a */
    public /* synthetic */ bb mo1293a(Point point, Point point2) {
        return m7320b(point, point2);
    }

    /* renamed from: b */
    public /* synthetic */ bb mo1302b(Point point) {
        return m7343h(point);
    }

    /* renamed from: n */
    public /* synthetic */ C0897d[] mo1336n() {
        return m7332d();
    }

    public C0983y(SbkTypesettingContext sbkTypesettingContext, C0982x c0982x, C0981w c0981w, al alVar, at atVar) {
        if (!f4853c && (sbkTypesettingContext == null || c0981w == null)) {
            throw new AssertionError();
        } else if (f4853c || (c0982x != null && c0982x.mo1186a())) {
            WebLog.init().w(m6108M());
            this.f4854d = sbkTypesettingContext;
            this.f4854d.m5841b((Object) UThread.getCurrentThread());
            this.f4854d.m5841b((Object) this);
            this.f4855e = new C0982x(this.f4854d, c0982x, 0);
            this.f4856f = c0981w;
            this.f4857g = alVar;
            this.f4858h = atVar;
            this.f4863m = this.f4854d.m7107g().b;
            this.f4859i = this.f4854d.m7101a(this.f4855e, this);
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: c */
    public long m7325c() {
        WebLog.init().w(m6108M());
        return this.f4859i.f4780a;
    }

    /* renamed from: a */
    public boolean mo1299a() {
        WebLog.init().w(m6108M());
        if (mo1282E()) {
            return this.f4862l;
        }
        return false;
    }

    /* renamed from: b */
    public boolean mo1305b() {
        WebLog.init().w(m6108M());
        return false;
    }

    /* renamed from: D */
    public List<String> mo1456D() {
        WebLog.init().w(m6108M());
        return this.f4869s;
    }

    /* renamed from: j */
    public long mo1327j() {
        WebLog.init().w(m6108M());
        return this.f4864n;
    }

    /* renamed from: p */
    public C0917k mo1340p() {
        WebLog.init().w(m6108M());
        return this.f4854d.m7107g();
    }

    /* renamed from: q */
    public C0923m mo1342q() {
        WebLog.init().w(m6108M());
        return this.f4856f;
    }

    /* renamed from: a */
    public void mo1296a(C0923m c0923m) {
        mo1288N();
        this.f4856f = (C0981w) c0923m;
        invalidateSelf();
    }

    /* renamed from: k */
    public boolean mo1330k() {
        WebLog.init().w(m6108M());
        return false;
    }

    /* renamed from: l */
    public ak mo1332l() {
        WebLog.init().w(m6108M());
        return this.f4855e;
    }

    /* renamed from: m */
    public bb mo1334m() {
        if (mo1282E()) {
            return new ah(this.f4855e.mo1454j(), this.f4855e.mo1455k());
        }
        return new ah();
    }

    /* renamed from: d */
    public C0965b[] m7332d() {
        WebLog.init().w(m6108M());
        return new C0965b[0];
    }

    /* renamed from: o */
    public CharSequence mo1338o() {
        WebLog.init().w(m6108M());
        return "";
    }

    /* renamed from: r */
    public int mo1343r() {
        WebLog.init().w(m6108M());
        return 0;
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

    /* renamed from: x */
    public int mo1354x() {
        WebLog.init().w(m6108M());
        return 0;
    }

    /* renamed from: v */
    public int mo1351v() {
        WebLog.init().w(m6108M());
        return 0;
    }

    /* renamed from: w */
    public int mo1353w() {
        WebLog.init().w(m6108M());
        return 0;
    }

    /* renamed from: y */
    public int mo1355y() {
        WebLog.init().w(m6108M());
        return 0;
    }

    /* renamed from: z */
    public Rect mo1356z() {
        WebLog.init().w(m6108M());
        return new Rect();
    }

    /* renamed from: A */
    public Rect mo1280A() {
        WebLog.init().w(m6108M());
        return new Rect();
    }

    /* renamed from: B */
    public int mo1281B() {
        WebLog.init().w(m6108M());
        if (f4853c || mo1284G()) {
            return 0;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public Rect mo1291a(au auVar) {
        WebLog.init().w(m6108M());
        if (f4853c || mo1284G()) {
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
        while (!this.f4860j && !this.f4859i.m7116c() && this.f4854d.a && !this.f4854d.mo1272c()) {
            try {
                Thread.sleep(50);
            } catch (Throwable th) {
            }
        }
        return mo1284G();
    }

    /* renamed from: a */
    public void mo1297a(Runnable runnable, Runnable runnable2) {
        WebLog.init().w(m6108M());
        ah.m871b(new C0984z(this, runnable, runnable2));
    }

    /* renamed from: F */
    public boolean mo1283F() {
        WebLog.init().w(m6108M());
        return this.f4859i.m7116c();
    }

    /* renamed from: G */
    public boolean mo1284G() {
        WebLog.init().w(m6108M());
        return !this.f4859i.m7116c() && this.f4860j;
    }

    /* renamed from: H */
    public void mo1285H() {
        WebLog.init().w(m6108M());
        if (!this.f4859i.m7116c()) {
            this.f4859i.m7119f();
            if (this.f4861k) {
                m7295e();
                this.f4860j = false;
            }
            mo1288N();
            this.f4854d.m5840b((bd) this);
            this.f4854d.m5842c(UThread.getCurrentThread());
        }
    }

    /* renamed from: a */
    public void mo1298a(boolean z) {
        WebLog.init().w(m6108M());
        if (this.f4867q != null) {
            if (z) {
                this.f4857g.m6360a(this.f4867q, true);
            } else {
                this.f4857g.m6359a(this.f4867q);
            }
            this.f4867q = null;
        }
    }

    /* renamed from: a */
    public ae mo1292a(Point point) {
        WebLog.init().w(m6108M());
        return null;
    }

    /* renamed from: b */
    public ah m7320b(Point point, Point point2) {
        WebLog.init().w(m6108M());
        if (f4853c || mo1284G()) {
            return new ah();
        }
        throw new AssertionError();
    }

    /* renamed from: h */
    public ah m7343h(Point point) {
        WebLog.init().w(m6108M());
        if (f4853c || mo1284G()) {
            return new ah();
        }
        throw new AssertionError();
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
        return new Rect();
    }

    /* renamed from: I */
    public String mo1286I() {
        WebLog.init().w(m6108M());
        return "";
    }

    /* renamed from: b */
    public String mo1303b(bb bbVar) {
        WebLog.init().w(m6108M());
        if (f4853c || bbVar != null) {
            return "";
        }
        throw new AssertionError();
    }

    /* renamed from: J */
    public String mo1287J() {
        WebLog.init().w(m6108M());
        if (!f4853c && !mo1284G()) {
            throw new AssertionError();
        } else if (this.f4856f.k) {
            return DkUtils.chs2chtText(mo1286I());
        } else {
            return mo1286I();
        }
    }

    /* renamed from: c */
    public String mo1309c(bb bbVar) {
        WebLog.init().w(m6108M());
        if (!f4853c && !mo1284G()) {
            throw new AssertionError();
        } else if (this.f4856f.k) {
            return DkUtils.chs2chtText(mo1303b(bbVar));
        } else {
            return mo1303b(bbVar);
        }
    }

    /* renamed from: d */
    public Rect mo1311d(bb bbVar) {
        WebLog.init().w(m6108M());
        if (!f4853c && !mo1284G()) {
            throw new AssertionError();
        } else if (f4853c || bbVar != null) {
            return new Rect();
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: e */
    public Rect[] mo1316e(bb bbVar) {
        WebLog.init().w(m6108M());
        if (!f4853c && !mo1284G()) {
            throw new AssertionError();
        } else if (f4853c || bbVar != null) {
            return new Rect[0];
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: f */
    public Point mo1318f(bb bbVar) {
        WebLog.init().w(m6108M());
        if (f4853c || mo1284G()) {
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
        if (f4853c || mo1284G()) {
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
        if (f4853c || mo1284G()) {
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: l */
    public Rect mo1331l(int i) {
        WebLog.init().w(m6108M());
        if (f4853c || mo1284G()) {
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: m */
    public Rect mo1333m(int i) {
        WebLog.init().w(m6108M());
        if (f4853c || mo1284G()) {
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: n */
    public aj mo1335n(int i) {
        WebLog.init().w(m6108M());
        if (f4853c || mo1284G()) {
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: p */
    public Rect mo1339p(int i) {
        WebLog.init().w(m6108M());
        if (f4853c || mo1284G()) {
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: o */
    public Rect mo1337o(int i) {
        WebLog.init().w(m6108M());
        if (f4853c || mo1284G()) {
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: q */
    public ad mo1341q(int i) {
        WebLog.init().w(m6108M());
        if (f4853c || mo1284G()) {
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: r */
    public Rect mo1344r(int i) {
        WebLog.init().w(m6108M());
        if (f4853c || mo1284G()) {
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: s */
    public ax mo1346s(int i) {
        WebLog.init().w(m6108M());
        if (f4853c || mo1284G()) {
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: t */
    public Rect mo1348t(int i) {
        WebLog.init().w(m6108M());
        if (f4853c || mo1284G()) {
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: u */
    public Rect mo1350u(int i) {
        WebLog.init().w(m6108M());
        if (f4853c || mo1284G()) {
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: v */
    public int mo1352v(int i) {
        WebLog.init().w(m6108M());
        if (f4853c || mo1284G()) {
            return -1;
        }
        throw new AssertionError();
    }

    /* renamed from: N */
    protected void mo1288N() {
        if (this.f4867q != null) {
            this.f4857g.m6361b(this.f4867q);
            this.f4867q = null;
        }
        if (this.f4868r != null) {
            this.f4857g.m6361b(this.f4868r);
            this.f4868r = null;
        }
    }

    /* renamed from: b */
    protected int mo1300b(Canvas canvas, long j) {
        if (!f4853c && this.f4855e == null) {
            throw new AssertionError();
        } else if (!this.f4861k) {
            mo1376a(canvas);
            return 2;
        } else if (this.f4855e.m5817f()) {
            return 1;
        } else {
            int i;
            Rect O = m7282O();
            if (this.f4867q != null && (this.f4867q.m6384b() != this.f4856f || this.f4867q.m6386d() != m6106K() || this.f4867q.m6388f() || this.f4867q.m6381a(O, 1.0f) == 0)) {
                this.f4857g.m6361b(this.f4867q);
                this.f4867q = null;
            }
            if (this.f4868r != null && (this.f4868r.m6384b() != this.f4856f || this.f4868r.m6386d() != m6106K() || this.f4868r.m6388f() || this.f4868r.m6381a(O, 1.0f) == 0)) {
                this.f4857g.m6361b(this.f4868r);
                this.f4868r = null;
            }
            if (this.f4867q == null) {
                this.f4867q = this.f4857g.m6354a(this.f4854d, this.f4855e, O, this.f4856f, 1.0f, m6106K());
            } else {
                int a = this.f4867q.m6381a(O, 1.0f);
                if (a < Integer.MAX_VALUE) {
                    ap a2 = this.f4857g.m6355a(this.f4854d, this.f4855e, O, this.f4856f, 1.0f, m6106K(), a + 1);
                    if (a2 != null) {
                        if (!a2.m6387e()) {
                            this.f4857g.m6359a(a2);
                        } else if (f4853c || !a2.m6388f()) {
                            this.f4857g.m6361b(this.f4867q);
                            this.f4867q = a2;
                        } else {
                            throw new AssertionError();
                        }
                    }
                }
            }
            Object obj;
            if (this.f4867q != null) {
                obj = this.f4867q.m6381a(O, 1.0f) == Integer.MAX_VALUE ? 1 : null;
                if (!this.f4867q.m6383a(canvas, 0.0f, 0.0f, 1.0f)) {
                    mo1376a(canvas);
                    i = 2;
                } else if (obj == null) {
                    invalidateSelf();
                    i = 3;
                } else {
                    i = 1;
                }
            } else {
                mo1376a(canvas);
                obj = null;
                i = 2;
            }
            if (this.f4868r == this.f4867q) {
                this.f4868r = null;
            }
            if (this.f4868r != null && this.f4868r.m6387e()) {
                this.f4868r = null;
            }
            if (this.f4868r == null && obj == null) {
                this.f4868r = m7283P();
            }
            if (mo1330k() || this.f4854d.m5844d()) {
                return i;
            }
            this.a.setTextSize((float) this.f4856f.f);
            C0911h d = this.f4854d.mo1453e().mo1258d();
            if (this.f4854d.m7107g().c.top >= this.f4856f.f) {
                float length;
                float f;
                if (this.f4856f.m && this.f4865o == null) {
                    this.f4865o = d.mo1264a();
                    C0901g b = d.mo1267b(this.f4855e);
                    if (!(b == null || b.mo1203f().equals(this.f4855e.mo1454j()))) {
                        this.f4865o = b.mo1202e();
                    }
                    if (this.f4856f.k) {
                        this.f4865o = DkUtils.chs2chtText(this.f4865o);
                    }
                }
                if (this.f4856f.l) {
                    length = (float) d.mo1264a().length();
                } else {
                    length = 0.0f;
                }
                if (!this.f4856f.m || TextUtils.isEmpty(this.f4865o) || (this.f4856f.l && this.f4865o == d.mo1264a())) {
                    f = 0.0f;
                } else {
                    f = (float) this.f4865o.length();
                }
                int width = getBounds().width() - (mo1340p().f4332c.left + mo1340p().f4332c.right);
                if (Float.compare(length, 1.0f) > 0) {
                    m6118a(canvas, d.mo1264a(), 3, Math.round((((float) width) * length) / (length + f)), this.a);
                }
                if (Float.compare(f, 1.0f) > 0) {
                    String str = this.f4865o;
                    int i2 = (!this.f4856f.n || this.f4856f.l) ? 5 : 3;
                    m6118a(canvas, str, i2, Math.round((((float) width) * f) / (length + f)), this.a);
                }
            }
            if (this.f4854d.m7107g().c.bottom < this.f4856f.f) {
                return i;
            }
            if (this.f4866p == null && this.f4864n >= 0) {
                this.f4866p = String.format("%d / %d", new Object[]{Long.valueOf(this.f4864n + 1), Long.valueOf(this.f4854d.m5839b())});
            }
            if (TextUtils.isEmpty(this.f4866p)) {
                return i;
            }
            int i3;
            String str2 = this.f4866p;
            if (this.f4856f.n) {
                i3 = 5;
            } else {
                i3 = 1;
            }
            m6119a(canvas, str2, i3, this.a);
            return i;
        }
    }

    /* renamed from: a */
    public void mo1295a(bc bcVar, long j, long j2) {
        if (j2 > 0 && this.f4859i != null) {
            this.f4864n = m7291c(this.f4859i);
        }
        m6122a(new ab(this));
    }

    /* renamed from: a */
    public void mo1457a(ag agVar) {
        boolean z = true;
        if (!f4853c && (this.f4854d == null || !this.f4854d.a)) {
            throw new AssertionError();
        } else if (f4853c || (this.f4855e != null && this.f4855e.m5777b())) {
            this.f4859i = agVar;
            if (this.f4854d.m5839b() >= 0) {
                this.f4864n = m7291c(this.f4859i);
            } else {
                this.f4854d.m5836a((bd) this);
            }
            if (this.f4859i.m7116c() || this.f4855e.m5817f()) {
                this.f4865o = "";
            } else {
                this.f4863m = this.f4859i.f4789j;
                if (!this.f4855e.m5817f()) {
                    if (!f4853c && this.f4868r != null) {
                        throw new AssertionError();
                    } else if (this.f4868r == null) {
                        this.f4868r = m7283P();
                    }
                }
            }
            this.f4860j = true;
            if (m7284Q() != null) {
                z = false;
            }
            this.f4862l = z;
            m6122a(new ac(this));
            this.f4854d.m5842c(this);
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: b */
    public void mo1458b(ag agVar) {
        if (f4853c || this.f4859i.m7116c()) {
            this.f4860j = false;
            m6122a(new ad(this));
            this.f4854d.m5842c(this);
            return;
        }
        throw new AssertionError();
    }

    public int getIntrinsicHeight() {
        return this.f4863m;
    }

    public void invalidateSelf() {
        if (!this.f4869s.isEmpty()) {
            mo1288N();
        }
        super.invalidateSelf();
    }

    /* renamed from: e */
    private void m7295e() {
        if (!this.f4860j) {
        }
    }

    /* renamed from: O */
    private Rect m7282O() {
        Rect rect = new Rect(0, 0, this.f4854d.m7107g().a, this.f4863m);
        if (rect.width() % 2 != 0) {
            rect.right++;
        }
        return rect;
    }

    /* renamed from: c */
    private long m7291c(ag agVar) {
        if (f4853c || (agVar != null && this.f4854d.m5839b() >= 0)) {
            return this.f4854d.m7100a(agVar.f4780a, agVar.f4781b, agVar.f4782c);
        }
        throw new AssertionError();
    }

    /* renamed from: P */
    private ap m7283P() {
        Rect O = m7282O();
        ap a = this.f4857g.m6354a(this.f4854d, this.f4855e, O, this.f4856f, 1.0f, m6106K());
        if (a != null) {
            this.f4857g.m6359a(a);
            if (a.m6381a(O, 1.0f) == Integer.MAX_VALUE) {
                return a;
            }
        }
        a = this.f4857g.m6356a(this.f4854d, this.f4855e, O, this.f4856f, 1.0f, m6106K(), new ae(this));
        this.f4857g.m6359a(a);
        return a;
    }

    /* renamed from: a */
    private void m7285a(Bitmap bitmap, Bitmap bitmap2) {
        if (!f4853c && bitmap == null) {
            throw new AssertionError();
        } else if (!f4853c && this.f4856f == null) {
            throw new AssertionError();
        } else if (f4853c || this.f4854d.a) {
            boolean a;
            C0824v Q = m7284Q();
            Canvas canvas = new Canvas(bitmap);
            bitmap.eraseColor(0);
            if (Q != null) {
                float b;
                if (this.f4854d.m5844d()) {
                    b = ((float) this.f4859i.f4788i) / ((float) Q.mo1131b());
                    canvas.scale(b, b);
                } else {
                    b = Math.min(((float) this.f4859i.f4788i) / ((float) Q.mo1131b()), ((float) this.f4859i.f4789j) / ((float) Q.mo1132f()));
                    canvas.translate((((float) this.f4859i.f4788i) - (((float) Q.mo1131b()) * b)) / 2.0f, (((float) this.f4859i.f4789j) - (((float) Q.mo1132f()) * b)) / 2.0f);
                    canvas.scale(b, b);
                }
                a = Q.mo1130a(canvas, new Rect(0, 0, Q.mo1131b(), Q.mo1132f()));
            } else {
                a = false;
            }
            if (a) {
                this.f4869s = Collections.emptyList();
                return;
            }
            if (Q != null) {
                this.f4869s = Arrays.asList(new String[]{Q.mo1124c()});
            }
            if (this.f4858h != null) {
                this.f4858h.mo1225b(null, this);
            }
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: Q */
    private C0824v m7284Q() {
        if (this.f4855e.m5777b()) {
            return this.f4854d.mo1453e().mo1450a(this.f4855e);
        }
        return null;
    }
}
