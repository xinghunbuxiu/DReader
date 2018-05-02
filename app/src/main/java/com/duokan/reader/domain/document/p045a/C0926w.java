package com.duokan.reader.domain.document.p045a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.sys.UThread;
import com.duokan.core.sys.ah;
import com.duokan.kernel.DkArgbColor;
import com.duokan.kernel.DkBox;
import com.duokan.kernel.DkFlowPosition;
import com.duokan.kernel.DkFlowRenderOption;
import com.duokan.kernel.DkPos;
import com.duokan.kernel.DkRenderInfo;
import com.duokan.kernel.DkUtils;
import com.duokan.kernel.pdflib.DkpPage;
import com.duokan.kernel.pdflib.DkpPageEx;
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

/* renamed from: com.duokan.reader.domain.document.a.w */
public class C0926w extends C0922t implements ae, ba, bd {
    /* renamed from: c */
    static final /* synthetic */ boolean f4381c = (!C0926w.class.desiredAssertionStatus());
    /* renamed from: d */
    private final ah f4382d;
    /* renamed from: e */
    private final C0925v f4383e;
    /* renamed from: f */
    private C0924u f4384f = null;
    /* renamed from: g */
    private final al f4385g;
    /* renamed from: h */
    private final at f4386h;
    /* renamed from: i */
    private af f4387i = null;
    /* renamed from: j */
    private boolean f4388j = false;
    /* renamed from: k */
    private boolean f4389k = false;
    /* renamed from: l */
    private long f4390l = -1;
    /* renamed from: m */
    private String f4391m = null;
    /* renamed from: n */
    private String f4392n = null;
    /* renamed from: o */
    private ap f4393o = null;
    /* renamed from: p */
    private ap f4394p = null;

    /* renamed from: a */
    public /* synthetic */ bb mo1293a(Point point, Point point2) {
        return m6256b(point, point2);
    }

    /* renamed from: b */
    public /* synthetic */ bb mo1302b(Point point) {
        return m6280h(point);
    }

    /* renamed from: n */
    public /* synthetic */ C0897d[] mo1336n() {
        return m6265c();
    }

    public C0926w(ah ahVar, C0925v c0925v, C0924u c0924u, al alVar, at atVar) {
        if (!f4381c && (ahVar == null || c0924u == null)) {
            throw new AssertionError();
        } else if (f4381c || (c0925v != null && c0925v.mo1186a())) {
            WebLog.init().w(m6108M());
            this.f4382d = ahVar;
            this.f4382d.m5841b((Object) UThread.getCurrentThread());
            this.f4382d.m5841b((Object) this);
            this.f4383e = new C0925v(this.f4382d, c0925v, 0);
            this.f4384f = c0924u;
            this.f4385g = alVar;
            this.f4386h = atVar;
            this.f4387i = this.f4382d.m5847a(this.f4383e, this);
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public boolean mo1299a() {
        WebLog.init().w(m6108M());
        return false;
    }

    /* renamed from: b */
    public boolean mo1305b() {
        WebLog.init().w(m6108M());
        return false;
    }

    public int getIntrinsicWidth() {
        if (m6203T()) {
            return this.f4382d.mo1270a(this.f4383e);
        }
        return this.f4382d.m5852g().a;
    }

    public int getIntrinsicHeight() {
        if (m6203T()) {
            return this.f4382d.mo1271b(this.f4383e);
        }
        return this.f4382d.m5852g().b;
    }

    /* renamed from: j */
    public long mo1327j() {
        WebLog.init().w(m6108M());
        return this.f4390l;
    }

    /* renamed from: p */
    public C0917k mo1340p() {
        WebLog.init().w(m6108M());
        return this.f4382d.m5852g();
    }

    /* renamed from: q */
    public C0923m mo1342q() {
        WebLog.init().w(m6108M());
        return this.f4384f;
    }

    /* renamed from: a */
    public void mo1296a(C0923m c0923m) {
        WebLog.init().w(m6108M());
        mo1288N();
        this.f4384f = (C0924u) c0923m;
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
        return this.f4383e;
    }

    /* renamed from: m */
    public bb mo1334m() {
        if (mo1282E()) {
            return new ag(this.f4383e.mo1278j(), this.f4383e.mo1279k());
        }
        return new ag();
    }

    /* renamed from: c */
    public C0898a[] m6265c() {
        int i = 0;
        WebLog.init().w(m6108M());
        if (!mo1282E()) {
            return new C0898a[0];
        }
        DkFlowPosition[] charPositions;
        if (this.f4382d.m5852g().mo1274c()) {
            charPositions = m6199P().getCharPositions();
            m6200Q();
        } else {
            charPositions = m6201R().getCharPositions();
            m6202S();
        }
        C0898a[] c0898aArr = new C0898a[charPositions.length];
        while (i < c0898aArr.length) {
            c0898aArr[i] = C0916p.m6081a(charPositions[i]);
            i++;
        }
        return c0898aArr;
    }

    /* renamed from: o */
    public CharSequence mo1338o() {
        WebLog.init().w(m6108M());
        if (!mo1282E()) {
            return "";
        }
        if (this.f4382d.m5852g().mo1274c()) {
            CharSequence chars = m6199P().getChars();
            m6200Q();
            return chars;
        }
        chars = m6201R().getChars();
        m6202S();
        return chars;
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

    /* renamed from: x */
    public int mo1354x() {
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
        if (f4381c || mo1284G()) {
            return 0;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public Rect mo1291a(au auVar) {
        WebLog.init().w(m6108M());
        if (f4381c || mo1284G()) {
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
        while (!this.f4388j && !this.f4387i.m5807c() && this.f4382d.a && !this.f4382d.mo1272c()) {
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
        ah.m871b(new C0927x(this, runnable, runnable2));
    }

    /* renamed from: F */
    public boolean mo1283F() {
        WebLog.init().w(m6108M());
        return this.f4387i.m5807c();
    }

    /* renamed from: G */
    public boolean mo1284G() {
        WebLog.init().w(m6108M());
        return !this.f4387i.m5807c() && this.f4388j;
    }

    /* renamed from: H */
    public void mo1285H() {
        WebLog.init().w(m6108M());
        if (!this.f4387i.m5807c()) {
            this.f4387i.m5810f();
            if (this.f4389k) {
                m6221d();
                this.f4388j = false;
            }
            mo1288N();
            this.f4382d.m5840b((bd) this);
            this.f4382d.m5842c(UThread.getCurrentThread());
        }
    }

    /* renamed from: a */
    public void mo1298a(boolean z) {
        WebLog.init().w(m6108M());
        if (this.f4393o != null) {
            if (z) {
                this.f4385g.m6360a(this.f4393o, true);
            } else {
                this.f4385g.m6359a(this.f4393o);
            }
            this.f4393o = null;
        }
    }

    /* renamed from: a */
    public ae mo1292a(Point point) {
        WebLog.init().w(m6108M());
        return null;
    }

    /* renamed from: b */
    public ag m6256b(Point point, Point point2) {
        WebLog.init().w(m6108M());
        if (!mo1284G() || this.f4383e.m5817f()) {
            return new ag();
        }
        DkPos i = m6230i(point);
        DkPos i2 = m6230i(point2);
        if (this.f4382d.m5852g().mo1274c()) {
            DkFlowPosition[] selectionRange = m6199P().getSelectionRange(i, i2);
            ag a = C0916p.m6082a(selectionRange[0], selectionRange[1]);
            m6200Q();
            return a;
        }
        selectionRange = m6201R().getSelectionRange(i, i2);
        a = C0916p.m6082a(selectionRange[0], selectionRange[1]);
        m6202S();
        return a;
    }

    /* renamed from: h */
    public ag m6280h(Point point) {
        WebLog.init().w(m6108M());
        if (!mo1284G() || this.f4383e.m5817f()) {
            return new ag();
        }
        ag a;
        DkPos i = m6230i(point);
        DkFlowPosition[] hitTestTextRange;
        if (this.f4382d.m5852g().mo1274c()) {
            hitTestTextRange = m6199P().hitTestTextRange(i);
            a = C0916p.m6082a(hitTestTextRange[0], hitTestTextRange[1]);
            m6200Q();
        } else {
            hitTestTextRange = m6201R().hitTestTextRange(i);
            a = C0916p.m6082a(hitTestTextRange[0], hitTestTextRange[1]);
            m6202S();
        }
        return (ag) a.mo1197b(mo1334m());
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
        if (!mo1282E()) {
            return new Rect();
        }
        DkBox e = m6224e(rect);
        rect.left = (int) e.mX0;
        rect.top = (int) e.mY0;
        rect.right = (int) e.mX1;
        rect.bottom = (int) e.mY1;
        return rect;
    }

    /* renamed from: c */
    public Rect mo1307c(Rect rect) {
        WebLog.init().w(m6108M());
        if (!mo1282E()) {
            return new Rect();
        }
        Rect a = m6208a(new DkBox((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom));
        rect.left = a.left;
        rect.top = a.top;
        rect.right = a.right;
        rect.bottom = a.bottom;
        return rect;
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
        return new Rect();
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
        return mo1303b(mo1334m());
    }

    /* renamed from: b */
    public String mo1303b(bb bbVar) {
        WebLog.init().w(m6108M());
        if (!f4381c && bbVar == null) {
            throw new AssertionError();
        } else if (!mo1282E() || this.f4383e.m5817f()) {
            return "";
        } else {
            String str = "";
            ag agVar = (ag) bbVar.mo1197b(mo1334m());
            if (m6203T()) {
                str = m6199P().getTextContentOfRange(agVar.m5833j().m5786a(this.f4382d.mo1273e().mo1262h()), agVar.m5834k().m5786a(this.f4382d.mo1273e().mo1262h()));
                m6200Q();
                return str;
            }
            str = m6201R().getTextContentOfRange(agVar.m5833j().m5786a(this.f4382d.mo1273e().mo1263i()), agVar.m5834k().m5786a(this.f4382d.mo1273e().mo1263i()));
            m6202S();
            return str;
        }
    }

    /* renamed from: J */
    public String mo1287J() {
        WebLog.init().w(m6108M());
        if (!f4381c && !mo1284G()) {
            throw new AssertionError();
        } else if (this.f4384f.k) {
            return DkUtils.chs2chtText(mo1286I());
        } else {
            return mo1286I();
        }
    }

    /* renamed from: c */
    public String mo1309c(bb bbVar) {
        WebLog.init().w(m6108M());
        if (!f4381c && !mo1284G()) {
            throw new AssertionError();
        } else if (this.f4384f.k) {
            return DkUtils.chs2chtText(mo1303b(bbVar));
        } else {
            return mo1303b(bbVar);
        }
    }

    /* renamed from: d */
    public Rect mo1311d(bb bbVar) {
        WebLog.init().w(m6108M());
        Rect rect = new Rect();
        for (Rect union : mo1316e(bbVar)) {
            rect.union(union);
        }
        return rect;
    }

    /* renamed from: e */
    public Rect[] mo1316e(bb bbVar) {
        int i = 0;
        WebLog.init().w(m6108M());
        if (!mo1282E()) {
            return new Rect[0];
        }
        ag agVar = (ag) bbVar.mo1197b(mo1334m());
        if (agVar.m5817f()) {
            return new Rect[0];
        }
        DkBox[] textRects;
        if (m6203T()) {
            textRects = m6199P().getTextRects(agVar.m5833j().m5786a(this.f4382d.mo1273e().mo1262h()), agVar.m5834k().m5786a(this.f4382d.mo1273e().mo1262h()));
            m6200Q();
        } else {
            textRects = m6201R().getTextRects(agVar.m5833j().m5786a(this.f4382d.mo1273e().mo1263i()), agVar.m5834k().m5786a(this.f4382d.mo1273e().mo1263i()));
            m6202S();
        }
        Rect[] rectArr = new Rect[textRects.length];
        while (i < rectArr.length) {
            rectArr[i] = m6208a(textRects[i]);
            i++;
        }
        m6214a(rectArr);
        return rectArr;
    }

    /* renamed from: f */
    public Point mo1318f(bb bbVar) {
        WebLog.init().w(m6108M());
        if (f4381c || mo1284G()) {
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
        if (f4381c || mo1284G()) {
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
        if (f4381c || mo1284G()) {
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: l */
    public Rect mo1331l(int i) {
        WebLog.init().w(m6108M());
        if (f4381c || mo1284G()) {
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: m */
    public Rect mo1333m(int i) {
        WebLog.init().w(m6108M());
        if (f4381c || mo1284G()) {
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: n */
    public aj mo1335n(int i) {
        WebLog.init().w(m6108M());
        if (f4381c || mo1284G()) {
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: p */
    public Rect mo1339p(int i) {
        WebLog.init().w(m6108M());
        if (f4381c || mo1284G()) {
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: o */
    public Rect mo1337o(int i) {
        WebLog.init().w(m6108M());
        if (f4381c || mo1284G()) {
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: q */
    public ad mo1341q(int i) {
        WebLog.init().w(m6108M());
        if (f4381c || mo1284G()) {
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: r */
    public Rect mo1344r(int i) {
        WebLog.init().w(m6108M());
        if (f4381c || mo1284G()) {
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: s */
    public ax mo1346s(int i) {
        WebLog.init().w(m6108M());
        if (f4381c || mo1284G()) {
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: t */
    public Rect mo1348t(int i) {
        WebLog.init().w(m6108M());
        if (f4381c || mo1284G()) {
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: u */
    public Rect mo1350u(int i) {
        WebLog.init().w(m6108M());
        if (f4381c || mo1284G()) {
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: v */
    public int mo1352v(int i) {
        WebLog.init().w(m6108M());
        if (f4381c || mo1284G()) {
            return -1;
        }
        throw new AssertionError();
    }

    /* renamed from: N */
    protected void mo1288N() {
        if (this.f4393o != null) {
            this.f4385g.m6361b(this.f4393o);
            this.f4393o = null;
        }
        if (this.f4394p != null) {
            this.f4385g.m6361b(this.f4394p);
            this.f4394p = null;
        }
    }

    /* renamed from: b */
    protected int mo1300b(Canvas canvas, long j) {
        if (this.f4389k) {
            int i;
            float e = m6223e();
            Rect O = m6198O();
            if (m6107L()) {
                mo1288N();
            }
            if (this.f4393o != null && (this.f4393o.m6384b() != this.f4384f || this.f4393o.m6386d() != m6106K() || this.f4393o.m6388f() || this.f4393o.m6381a(O, e) == 0)) {
                this.f4385g.m6361b(this.f4393o);
                this.f4393o = null;
            }
            if (this.f4394p != null && (this.f4394p.m6384b() != this.f4384f || this.f4394p.m6386d() != m6106K() || this.f4394p.m6388f() || this.f4394p.m6381a(O, e) == 0)) {
                this.f4385g.m6361b(this.f4394p);
                this.f4394p = null;
            }
            if (this.f4393o == null) {
                this.f4393o = this.f4385g.m6354a(this.f4382d, this.f4383e, O, this.f4384f, e, m6106K());
            } else {
                int a = this.f4393o.m6381a(O, e);
                if (a < Integer.MAX_VALUE) {
                    ap a2 = this.f4385g.m6355a(this.f4382d, this.f4383e, O, this.f4384f, e, m6106K(), a + 1);
                    if (a2 != null) {
                        if (!a2.m6387e()) {
                            this.f4385g.m6359a(a2);
                        } else if (f4381c || !a2.m6388f()) {
                            this.f4385g.m6361b(this.f4393o);
                            this.f4393o = a2;
                        } else {
                            throw new AssertionError();
                        }
                    }
                }
            }
            Object obj;
            if (this.f4393o != null) {
                int i2;
                float c = e / this.f4393o.m6385c();
                float f = ((float) this.f4393o.m6382a().left) * c;
                float f2 = ((float) this.f4393o.m6382a().top) * c;
                if (m6203T()) {
                    canvas.drawColor(-1);
                }
                obj = this.f4393o.m6381a(O, e) == Integer.MAX_VALUE ? 1 : null;
                if (!this.f4393o.m6383a(canvas, f, f2, c)) {
                    mo1376a(canvas);
                    i2 = 2;
                } else if (obj == null) {
                    invalidateSelf();
                    i2 = 3;
                } else {
                    i2 = 1;
                }
                i = i2;
            } else {
                mo1376a(canvas);
                obj = null;
                i = 2;
            }
            if (this.f4394p == this.f4393o) {
                this.f4394p = null;
            }
            if (this.f4394p != null && this.f4394p.m6387e()) {
                this.f4394p = null;
            }
            if (this.f4394p == null && obj == null) {
                this.f4394p = m6209a(O, e);
            }
            if (mo1330k() || this.f4382d.m5844d()) {
                return i;
            }
            this.a.setTextSize((float) this.f4384f.f);
            C0911h d = this.f4382d.mo1273e().mo1258d();
            if (!m6203T() && this.f4382d.m5852g().c.top >= this.f4384f.f) {
                float length;
                float f3;
                if (this.f4384f.m && this.f4391m == null) {
                    this.f4391m = d.mo1264a();
                    C0901g b = d.mo1267b(this.f4383e);
                    if (!(b == null || b.mo1203f().equals(this.f4383e.mo1278j()))) {
                        this.f4391m = b.mo1202e();
                    }
                    if (this.f4384f.k) {
                        this.f4391m = DkUtils.chs2chtText(this.f4391m);
                    }
                }
                if (this.f4384f.l) {
                    length = (float) d.mo1264a().length();
                } else {
                    length = 0.0f;
                }
                if (!this.f4384f.m || TextUtils.isEmpty(this.f4391m) || (this.f4384f.l && this.f4391m == d.mo1264a())) {
                    f3 = 0.0f;
                } else {
                    f3 = (float) this.f4391m.length();
                }
                int width = getBounds().width() - (mo1340p().f4332c.left + mo1340p().f4332c.right);
                if (Float.compare(length, 1.0f) > 0) {
                    m6118a(canvas, d.mo1264a(), 3, Math.round((((float) width) * length) / (length + f3)), this.a);
                }
                if (Float.compare(f3, 1.0f) > 0) {
                    String str = this.f4391m;
                    int i3 = (!this.f4384f.n || this.f4384f.l) ? 5 : 3;
                    m6118a(canvas, str, i3, Math.round((((float) width) * f3) / (length + f3)), this.a);
                }
            }
            if (m6203T() || this.f4382d.m5852g().c.bottom < this.f4384f.f) {
                return i;
            }
            if (this.f4392n == null && this.f4390l >= 0) {
                this.f4392n = String.format("%d / %d", new Object[]{Long.valueOf(this.f4390l + 1), Long.valueOf(this.f4382d.m5839b())});
            }
            if (TextUtils.isEmpty(this.f4392n)) {
                return i;
            }
            int i4;
            String str2 = this.f4392n;
            if (this.f4384f.n) {
                i4 = 5;
            } else {
                i4 = 1;
            }
            m6119a(canvas, str2, i4, this.a);
            return i;
        }
        mo1376a(canvas);
        return 2;
    }

    /* renamed from: d */
    protected void mo1313d(Rect rect) {
        if (!m6203T()) {
            return;
        }
        if (rect.isEmpty()) {
            mo1288N();
        } else if (mo1284G() && this.f4393o == null && this.f4394p == null) {
            this.f4394p = m6209a(m6198O(), m6223e());
        }
    }

    /* renamed from: a */
    public void mo1295a(bc bcVar, long j, long j2) {
        if (j2 > 0 && this.f4387i != null) {
            this.f4390l = m6219c(this.f4387i);
        }
        m6122a(new C0929z(this));
    }

    /* renamed from: a */
    public void mo1294a(af afVar) {
        if (!f4381c && (this.f4382d == null || !this.f4382d.a)) {
            throw new AssertionError();
        } else if (f4381c || (this.f4383e != null && this.f4383e.m5777b())) {
            this.f4387i = afVar;
            if (m6203T()) {
                m6199P();
            } else {
                m6201R();
            }
            if (this.f4382d.m5839b() >= 0) {
                this.f4390l = m6219c(this.f4387i);
            } else {
                this.f4382d.m5836a((bd) this);
            }
            if (this.f4387i.m5807c() || this.f4383e.m5817f()) {
                this.f4391m = "";
            } else if (!this.f4383e.m5817f()) {
                if (!f4381c && this.f4394p != null) {
                    throw new AssertionError();
                } else if (!m6203T() && this.f4394p == null) {
                    this.f4394p = m6209a(m6198O(), m6223e());
                }
            }
            this.f4388j = true;
            m6122a(new aa(this));
            this.f4382d.m5842c(this);
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: b */
    public void mo1304b(af afVar) {
        if (f4381c || this.f4387i.m5807c()) {
            this.f4388j = false;
            m6122a(new ab(this));
            this.f4382d.m5842c(this);
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: d */
    private void m6221d() {
        if (!this.f4388j) {
            return;
        }
        if (m6203T()) {
            m6200Q();
        } else {
            m6202S();
        }
    }

    /* renamed from: c */
    private long m6219c(af afVar) {
        if (f4381c || (afVar != null && this.f4382d.m5839b() >= 0)) {
            return this.f4382d.m5846a(afVar.f4232a, afVar.f4233b, afVar.f4234c);
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    private void m6214a(Rect[] rectArr) {
        Arrays.sort(rectArr, new ac(this));
    }

    /* renamed from: a */
    private ap m6209a(Rect rect, float f) {
        ap a = this.f4385g.m6354a(this.f4382d, this.f4383e, rect, this.f4384f, f, m6106K());
        if (a != null) {
            this.f4385g.m6359a(a);
            if (a.m6381a(rect, f) == Integer.MAX_VALUE) {
                return a;
            }
        }
        if (m6203T()) {
            m6199P();
        } else {
            m6201R();
        }
        a = this.f4385g.m6356a(this.f4382d, this.f4383e, rect, this.f4384f, f, m6106K(), new ad(this, rect, f));
        this.f4385g.m6359a(a);
        return a;
    }

    /* renamed from: a */
    private void m6212a(Bitmap bitmap, Bitmap bitmap2, Rect rect, float f) {
        if (bitmap2 != null) {
            synchronized (bitmap2) {
                if (!bitmap2.isRecycled()) {
                    new Canvas(bitmap).drawBitmap(bitmap2, 0.0f, 0.0f, null);
                }
            }
        } else {
            bitmap.eraseColor(-1);
        }
        if (m6203T()) {
            long X = m6207X();
            DkRenderInfo dkRenderInfo = new DkRenderInfo();
            dkRenderInfo.mBitmap = bitmap;
            dkRenderInfo.mPageRect = m6224e(rect);
            dkRenderInfo.mPageNum = X;
            dkRenderInfo.mScale = f;
            this.f4382d.mo1273e().mo1262h().renderFixedPage(dkRenderInfo);
            return;
        }
        DkFlowRenderOption dkFlowRenderOption = new DkFlowRenderOption();
        dkFlowRenderOption.mWidth = bitmap.getWidth();
        dkFlowRenderOption.mHeight = bitmap.getHeight();
        dkFlowRenderOption.mBitmap = bitmap;
        dkFlowRenderOption.mNightColor = new DkArgbColor(this.f4384f.d);
        dkFlowRenderOption.mOptimizeForNight = this.f4384f.i;
        dkFlowRenderOption.mOptimizeForDarkBackground = this.f4384f.j;
        if (this.f4384f.c == 0) {
            dkFlowRenderOption.mTextColor = null;
        } else {
            dkFlowRenderOption.mTextColor = new DkArgbColor(this.f4384f.c);
        }
        this.f4382d.mo1273e().mo1263i().renderFlowPage(dkFlowRenderOption, C0916p.m6079a(this.f4383e.mo1278j()), C0916p.m6080a(this.f4382d.m5852g()));
    }

    /* renamed from: e */
    private float m6223e() {
        if (!m6203T()) {
            return 1.0f;
        }
        long X = m6207X() - 1;
        RectF[] rectFArr = this.f4382d.m5852g().f4341m;
        if (rectFArr.length < 1) {
            return ((float) getBounds().width()) / ((float) this.f4382d.mo1270a(this.f4383e));
        }
        RectF rectF = rectFArr[((int) X) % rectFArr.length];
        return ((float) getBounds().width()) / (((1.0f - rectF.left) - rectF.right) * ((float) this.f4382d.mo1270a(this.f4383e)));
    }

    /* renamed from: O */
    private Rect m6198O() {
        Rect rect;
        if (m6203T()) {
            int width = getBounds().width();
            int height = getBounds().height();
            Rect h = m6149h();
            if (h.isEmpty()) {
                return new Rect();
            }
            Rect rect2 = new Rect(0, 0, width, height);
            rect = new Rect(h);
            int f = (int) (((double) m6141f()) * 1.25d);
            while (rect.width() < width && rect.width() < f) {
                int width2 = f - rect.width();
                if (rect.left == rect2.left) {
                    rect.right = width2 + rect.right;
                } else if (rect.right == rect2.right) {
                    rect.left -= width2;
                } else {
                    rect.inset((-(width2 + 1)) / 2, 0);
                }
                rect.intersect(rect2);
            }
            width = ((m6145g() * m6141f()) * 2) / rect.width();
            while (rect.height() < height && rect.height() < width) {
                f = width - rect.height();
                if (rect.top == rect2.top) {
                    rect.bottom = f + rect.bottom;
                } else if (rect.bottom == rect2.bottom) {
                    rect.top -= f;
                } else {
                    rect.inset(0, (-(f + 1)) / 2);
                }
                rect.intersect(rect2);
            }
        } else {
            rect = new Rect(0, 0, this.f4382d.m5852g().a, this.f4382d.m5852g().b);
        }
        if (rect.width() % 2 == 0) {
            return rect;
        }
        rect.right++;
        return rect;
    }

    /* renamed from: P */
    private DkpPage m6199P() {
        return this.f4382d.mo1273e().mo1262h().acquireFixedPage(m6207X());
    }

    /* renamed from: Q */
    private void m6200Q() {
        this.f4382d.mo1273e().mo1262h().releaseFixedPage(m6207X());
    }

    /* renamed from: R */
    private DkpPageEx m6201R() {
        return this.f4382d.mo1273e().mo1263i().acquireFlowPage(C0916p.m6079a(this.f4383e.mo1278j()), C0916p.m6080a(this.f4382d.m5852g()));
    }

    /* renamed from: S */
    private void m6202S() {
        this.f4382d.mo1273e().mo1263i().releaseFlowPage(C0916p.m6079a(this.f4383e.mo1278j()), C0916p.m6080a(this.f4382d.m5852g()));
    }

    /* renamed from: T */
    private boolean m6203T() {
        return this.f4382d.m5852g().mo1274c();
    }

    /* renamed from: e */
    private DkBox m6224e(Rect rect) {
        float e = m6223e();
        RectF W = m6206W();
        return new DkBox((float) Math.round((((float) rect.left) / e) + (W.left * ((float) m6204U()))), (float) Math.round((((float) rect.top) / e) + (W.top * ((float) m6205V()))), (float) Math.round((((float) rect.right) / e) + (W.left * ((float) m6204U()))), (float) Math.round((((float) rect.bottom) / e) + (W.top * ((float) m6205V()))));
    }

    /* renamed from: i */
    private DkPos m6230i(Point point) {
        float e = m6223e();
        RectF W = m6206W();
        return new DkPos((float) Math.round((((float) point.x) / e) + (W.left * ((float) m6204U()))), (float) Math.round((((float) point.y) / e) + (W.top * ((float) m6205V()))));
    }

    /* renamed from: a */
    private Rect m6208a(DkBox dkBox) {
        float e = m6223e();
        RectF W = m6206W();
        RectF toRectF = dkBox.toRectF();
        toRectF.offset((-W.left) * ((float) m6204U()), (-W.top) * ((float) m6205V()));
        toRectF.left *= e;
        toRectF.top *= e;
        toRectF.right *= e;
        toRectF.bottom = e * toRectF.bottom;
        Rect rect = new Rect();
        toRectF.round(rect);
        return rect;
    }

    /* renamed from: U */
    private int m6204U() {
        return this.f4382d.mo1270a(this.f4383e);
    }

    /* renamed from: V */
    private int m6205V() {
        return this.f4382d.mo1271b(this.f4383e);
    }

    /* renamed from: W */
    private RectF m6206W() {
        if (!m6203T()) {
            return new RectF();
        }
        long X = m6207X() - 1;
        RectF[] rectFArr = this.f4382d.m5852g().f4341m;
        return rectFArr.length < 1 ? new RectF() : rectFArr[((int) X) % rectFArr.length];
    }

    /* renamed from: X */
    private long m6207X() {
        return C0916p.m6078a(this.f4382d.mo1273e().mo1262h(), this.f4383e);
    }
}
