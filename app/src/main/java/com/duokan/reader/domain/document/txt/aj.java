package com.duokan.reader.domain.document.txt;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;
import com.duokan.core.diagnostic.C0328a;
import com.duokan.core.sys.UThread;
import com.duokan.core.sys.ah;
import com.duokan.kernel.DkArgbColor;
import com.duokan.kernel.DkBox;
import com.duokan.kernel.DkFlowRenderOption;
import com.duokan.kernel.DkPos;
import com.duokan.kernel.DkUtils;
import com.duokan.kernel.txtlib.DktPage;
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

public class aj extends ag implements ba, bd, ar {
    /* renamed from: c */
    static final /* synthetic */ boolean f4888c = (!aj.class.desiredAssertionStatus());
    /* renamed from: d */
    private final au f4889d;
    /* renamed from: e */
    private final ai f4890e;
    /* renamed from: f */
    private ah f4891f = null;
    /* renamed from: g */
    private final al f4892g;
    /* renamed from: h */
    private final at f4893h;
    /* renamed from: i */
    private as f4894i = null;
    /* renamed from: j */
    private boolean f4895j = false;
    /* renamed from: k */
    private boolean f4896k = false;
    /* renamed from: l */
    private int f4897l = -1;
    /* renamed from: m */
    private long f4898m = -1;
    /* renamed from: n */
    private String f4899n = null;
    /* renamed from: o */
    private String f4900o = null;
    /* renamed from: p */
    private ap f4901p = null;
    /* renamed from: q */
    private ap f4902q = null;

    /* renamed from: a */
    public /* synthetic */ bb mo1293a(Point point, Point point2) {
        return m7440b(point, point2);
    }

    /* renamed from: b */
    public /* synthetic */ bb mo1302b(Point point) {
        return m7462h(point);
    }

    /* renamed from: n */
    public /* synthetic */ C0897d[] mo1336n() {
        return m7448c();
    }

    public aj(au auVar, ai aiVar, ah ahVar, al alVar, at atVar) {
        if (!f4888c && (auVar == null || ahVar == null)) {
            throw new AssertionError();
        } else if (f4888c || (aiVar != null && aiVar.mo1186a())) {
            C0328a.m757c().m764b(m6108M());
            this.f4889d = auVar;
            this.f4889d.m5841b((Object) UThread.getCurrentThread());
            this.f4889d.m5841b((Object) this);
            this.f4890e = new ai(this.f4889d, aiVar, 0);
            this.f4891f = ahVar;
            this.f4892g = alVar;
            this.f4893h = atVar;
            this.f4897l = this.f4889d.m7524h().b;
            this.f4894i = this.f4889d.m7517a(this.f4890e, (ar) this);
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public boolean mo1299a() {
        C0328a.m757c().m764b(m6108M());
        return false;
    }

    /* renamed from: b */
    public boolean mo1305b() {
        C0328a.m757c().m764b(m6108M());
        return false;
    }

    /* renamed from: j */
    public long mo1327j() {
        C0328a.m757c().m764b(m6108M());
        return this.f4898m;
    }

    /* renamed from: p */
    public C0917k mo1340p() {
        C0328a.m757c().m764b(m6108M());
        return this.f4889d.m7524h();
    }

    /* renamed from: q */
    public C0923m mo1342q() {
        C0328a.m757c().m764b(m6108M());
        return this.f4891f;
    }

    /* renamed from: a */
    public void mo1296a(C0923m c0923m) {
        mo1288N();
        this.f4891f = (ah) c0923m;
        invalidateSelf();
    }

    /* renamed from: k */
    public boolean mo1330k() {
        C0328a.m757c().m764b(m6108M());
        return false;
    }

    /* renamed from: l */
    public ak mo1332l() {
        C0328a.m757c().m764b(m6108M());
        return this.f4890e;
    }

    /* renamed from: m */
    public bb mo1334m() {
        if (mo1282E()) {
            return new at(this.f4890e.mo1460n(), this.f4890e.mo1461o());
        }
        return new at();
    }

    /* renamed from: c */
    public C0986b[] m7448c() {
        int i = 0;
        C0328a.m757c().m764b(m6108M());
        if (!mo1282E()) {
            return new C0986b[0];
        }
        long[] charPositions = m7402P().getCharPositions();
        C0986b[] c0986bArr = new C0986b[charPositions.length];
        while (i < c0986bArr.length) {
            c0986bArr[i] = ab.m7382a(charPositions[i]);
            i++;
        }
        m7403Q();
        return c0986bArr;
    }

    /* renamed from: o */
    public CharSequence mo1338o() {
        C0328a.m757c().m764b(m6108M());
        if (!mo1282E()) {
            return "";
        }
        CharSequence chars = m7402P().getChars();
        m7403Q();
        return chars;
    }

    /* renamed from: r */
    public int mo1343r() {
        C0328a.m757c().m764b(m6108M());
        return 0;
    }

    /* renamed from: s */
    public int mo1345s() {
        C0328a.m757c().m764b(m6108M());
        return 0;
    }

    /* renamed from: t */
    public int mo1347t() {
        C0328a.m757c().m764b(m6108M());
        return 0;
    }

    /* renamed from: u */
    public int mo1349u() {
        C0328a.m757c().m764b(m6108M());
        return 0;
    }

    /* renamed from: x */
    public int mo1354x() {
        C0328a.m757c().m764b(m6108M());
        return 0;
    }

    /* renamed from: v */
    public int mo1351v() {
        C0328a.m757c().m764b(m6108M());
        return 0;
    }

    /* renamed from: w */
    public int mo1353w() {
        C0328a.m757c().m764b(m6108M());
        return 0;
    }

    /* renamed from: y */
    public int mo1355y() {
        C0328a.m757c().m764b(m6108M());
        return 0;
    }

    /* renamed from: z */
    public Rect mo1356z() {
        C0328a.m757c().m764b(m6108M());
        return new Rect();
    }

    /* renamed from: A */
    public Rect mo1280A() {
        C0328a.m757c().m764b(m6108M());
        return new Rect();
    }

    /* renamed from: B */
    public int mo1281B() {
        C0328a.m757c().m764b(m6108M());
        if (f4888c || mo1284G()) {
            return 0;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public Rect mo1291a(au auVar) {
        C0328a.m757c().m764b(m6108M());
        if (f4888c || mo1284G()) {
            return new Rect();
        }
        throw new AssertionError();
    }

    /* renamed from: E */
    public boolean mo1282E() {
        C0328a.m757c().m764b(m6108M());
        if (mo1284G()) {
            return true;
        }
        while (!this.f4895j && !this.f4894i.m7500d() && this.f4889d.a && !this.f4889d.mo1272c()) {
            try {
                Thread.sleep(50);
            } catch (Throwable th) {
            }
        }
        return mo1284G();
    }

    /* renamed from: a */
    public void mo1297a(Runnable runnable, Runnable runnable2) {
        C0328a.m757c().m764b(m6108M());
        ah.m871b(new ak(this, runnable, runnable2));
    }

    /* renamed from: F */
    public boolean mo1283F() {
        C0328a.m757c().m764b(m6108M());
        return this.f4894i.m7500d();
    }

    /* renamed from: G */
    public boolean mo1284G() {
        C0328a.m757c().m764b(m6108M());
        return !this.f4894i.m7500d() && this.f4895j;
    }

    /* renamed from: H */
    public void mo1285H() {
        C0328a.m757c().m764b(m6108M());
        if (!this.f4894i.m7500d()) {
            this.f4894i.mo1467a();
            if (this.f4896k) {
                m7412d();
                this.f4895j = false;
            }
            mo1288N();
            this.f4889d.m5840b((bd) this);
            this.f4889d.m5842c(UThread.getCurrentThread());
        }
    }

    /* renamed from: a */
    public void mo1298a(boolean z) {
        C0328a.m757c().m764b(m6108M());
        if (this.f4901p != null) {
            if (z) {
                this.f4892g.m6360a(this.f4901p, true);
            } else {
                this.f4892g.m6359a(this.f4901p);
            }
            this.f4901p = null;
        }
    }

    /* renamed from: a */
    public ae mo1292a(Point point) {
        C0328a.m757c().m764b(m6108M());
        return null;
    }

    /* renamed from: b */
    public at m7440b(Point point, Point point2) {
        C0328a.m757c().m764b(m6108M());
        if (!f4888c && !mo1284G()) {
            throw new AssertionError();
        } else if (!mo1284G() || this.f4890e.m5817f()) {
            return new at();
        } else {
            DktPage P = m7402P();
            if (f4888c || P != null) {
                DkPos dkPos = new DkPos();
                dkPos.mX = (float) point.x;
                dkPos.mY = (float) point.y;
                DkPos dkPos2 = new DkPos();
                dkPos2.mX = (float) point2.x;
                dkPos2.mY = (float) point2.y;
                long[] selectionRange = P.getSelectionRange(dkPos, dkPos2);
                if (selectionRange.length < 2) {
                    return new at();
                }
                at a = ab.m7381a(ab.m7382a(selectionRange[0]), ab.m7382a(selectionRange[1]));
                m7403Q();
                return a;
            }
            throw new AssertionError();
        }
    }

    /* renamed from: h */
    public at m7462h(Point point) {
        C0328a.m757c().m764b(m6108M());
        if (!f4888c && !mo1284G()) {
            throw new AssertionError();
        } else if (!mo1284G() || this.f4890e.m5817f()) {
            return new at();
        } else {
            DktPage P = m7402P();
            if (f4888c || P != null) {
                DkPos dkPos = new DkPos();
                dkPos.mX = (float) point.x;
                dkPos.mY = (float) point.y;
                long[] hitTestTextRangeByMode = P.hitTestTextRangeByMode(dkPos, 2);
                if (hitTestTextRangeByMode.length < 2) {
                    return new at();
                }
                at a = ab.m7381a(ab.m7382a(hitTestTextRangeByMode[0]), ab.m7382a(hitTestTextRangeByMode[1]));
                m7403Q();
                return (at) a.mo1197b(mo1334m());
            }
            throw new AssertionError();
        }
    }

    /* renamed from: c */
    public int mo1306c(Point point) {
        C0328a.m757c().m764b(m6108M());
        return -1;
    }

    /* renamed from: a */
    public int mo1289a(Point point, int i) {
        C0328a.m757c().m764b(m6108M());
        return -1;
    }

    /* renamed from: d */
    public int mo1310d(Point point) {
        C0328a.m757c().m764b(m6108M());
        return -1;
    }

    /* renamed from: e */
    public int mo1314e(Point point) {
        C0328a.m757c().m764b(m6108M());
        return -1;
    }

    /* renamed from: a */
    public int mo1290a(bb bbVar) {
        C0328a.m757c().m764b(m6108M());
        return -1;
    }

    /* renamed from: f */
    public int mo1317f(Point point) {
        C0328a.m757c().m764b(m6108M());
        return -1;
    }

    /* renamed from: g */
    public int mo1320g(Point point) {
        return -1;
    }

    /* renamed from: b */
    public Rect mo1301b(Rect rect) {
        C0328a.m757c().m764b(m6108M());
        return new Rect(rect);
    }

    /* renamed from: c */
    public Rect mo1307c(Rect rect) {
        C0328a.m757c().m764b(m6108M());
        return new Rect(rect);
    }

    /* renamed from: c */
    public af mo1308c(int i) {
        C0328a.m757c().m764b(m6108M());
        return null;
    }

    /* renamed from: d */
    public aw mo1312d(int i) {
        C0328a.m757c().m764b(m6108M());
        return null;
    }

    /* renamed from: e */
    public ab mo1315e(int i) {
        C0328a.m757c().m764b(m6108M());
        return null;
    }

    /* renamed from: f */
    public com.duokan.reader.domain.document.ah mo1319f(int i) {
        C0328a.m757c().m764b(m6108M());
        return null;
    }

    /* renamed from: g */
    public Rect mo1322g(int i) {
        C0328a.m757c().m764b(m6108M());
        return new Rect();
    }

    /* renamed from: h */
    public Rect mo1325h(int i) {
        C0328a.m757c().m764b(m6108M());
        return null;
    }

    /* renamed from: i */
    public Rect mo1326i(int i) {
        C0328a.m757c().m764b(m6108M());
        return new Rect();
    }

    /* renamed from: j */
    public Rect mo1328j(int i) {
        C0328a.m757c().m764b(m6108M());
        return new Rect();
    }

    /* renamed from: I */
    public String mo1286I() {
        C0328a.m757c().m764b(m6108M());
        if (!mo1282E() || this.f4890e.m5817f()) {
            return "";
        }
        String textContent = m7402P().getTextContent();
        m7403Q();
        return textContent;
    }

    /* renamed from: b */
    public String mo1303b(bb bbVar) {
        C0328a.m757c().m764b(m6108M());
        if (!f4888c && bbVar == null) {
            throw new AssertionError();
        } else if (!mo1282E() || this.f4890e.m5817f()) {
            return "";
        } else {
            String str = "";
            at atVar = (at) bbVar.mo1197b(mo1334m());
            str = m7402P().getTextContentOfRange(ab.m7379a(atVar.m7513j()), ab.m7379a(atVar.m7514k()));
            m7403Q();
            return str;
        }
    }

    /* renamed from: J */
    public String mo1287J() {
        C0328a.m757c().m764b(m6108M());
        if (!f4888c && !mo1284G()) {
            throw new AssertionError();
        } else if (this.f4891f.k) {
            return DkUtils.chs2chtText(mo1286I());
        } else {
            return mo1286I();
        }
    }

    /* renamed from: c */
    public String mo1309c(bb bbVar) {
        C0328a.m757c().m764b(m6108M());
        if (!f4888c && !mo1284G()) {
            throw new AssertionError();
        } else if (this.f4891f.k) {
            return DkUtils.chs2chtText(mo1303b(bbVar));
        } else {
            return mo1303b(bbVar);
        }
    }

    /* renamed from: d */
    public Rect mo1311d(bb bbVar) {
        C0328a.m757c().m764b(m6108M());
        if (!f4888c && !mo1284G()) {
            throw new AssertionError();
        } else if (!f4888c && bbVar == null) {
            throw new AssertionError();
        } else if (!mo1284G() || this.f4890e.m5817f()) {
            return new Rect();
        } else {
            if (bbVar == null || bbVar.m5817f()) {
                return new Rect();
            }
            DkBox[] textRects = m7402P().getTextRects(((C0986b) bbVar.mo1198g()).m7539g(), ((C0986b) bbVar.mo1199h()).m7539g());
            Rect rect = new Rect();
            for (int i = 0; i < textRects.length; i++) {
                rect.union(new Rect(Math.round(textRects[i].mX0), Math.round(textRects[i].mY0), Math.round(textRects[i].mX1), Math.round(textRects[i].mY1)));
            }
            m7403Q();
            return rect;
        }
    }

    /* renamed from: e */
    public Rect[] mo1316e(bb bbVar) {
        C0328a.m757c().m764b(m6108M());
        if (!f4888c && !mo1284G()) {
            throw new AssertionError();
        } else if (!f4888c && bbVar == null) {
            throw new AssertionError();
        } else if (!mo1284G() || this.f4890e.m5817f()) {
            return new Rect[0];
        } else {
            if (bbVar == null || bbVar.m5817f()) {
                return new Rect[0];
            }
            bb b = bbVar.mo1197b(mo1334m());
            if (b == null || b.m5817f()) {
                return new Rect[0];
            }
            DkBox[] textRects = m7402P().getTextRects(((C0986b) b.mo1198g()).m7539g(), ((C0986b) b.mo1199h()).m7539g());
            Rect[] rectArr = new Rect[textRects.length];
            for (int i = 0; i < rectArr.length; i++) {
                rectArr[i] = new Rect(Math.round(textRects[i].mX0), Math.round(textRects[i].mY0), Math.round(textRects[i].mX1), Math.round(textRects[i].mY1));
            }
            Arrays.sort(rectArr, new am(this));
            m7403Q();
            return rectArr;
        }
    }

    /* renamed from: f */
    public Point mo1318f(bb bbVar) {
        C0328a.m757c().m764b(m6108M());
        if (f4888c || mo1284G()) {
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
        C0328a.m757c().m764b(m6108M());
        if (f4888c || mo1284G()) {
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
        C0328a.m757c().m764b(m6108M());
        if (f4888c || mo1284G()) {
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: l */
    public Rect mo1331l(int i) {
        C0328a.m757c().m764b(m6108M());
        if (f4888c || mo1284G()) {
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: m */
    public Rect mo1333m(int i) {
        C0328a.m757c().m764b(m6108M());
        if (f4888c || mo1284G()) {
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: n */
    public com.duokan.reader.domain.document.aj mo1335n(int i) {
        C0328a.m757c().m764b(m6108M());
        if (f4888c || mo1284G()) {
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: p */
    public Rect mo1339p(int i) {
        C0328a.m757c().m764b(m6108M());
        if (f4888c || mo1284G()) {
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: o */
    public Rect mo1337o(int i) {
        C0328a.m757c().m764b(m6108M());
        if (f4888c || mo1284G()) {
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: q */
    public ad mo1341q(int i) {
        C0328a.m757c().m764b(m6108M());
        if (f4888c || mo1284G()) {
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: r */
    public Rect mo1344r(int i) {
        C0328a.m757c().m764b(m6108M());
        if (f4888c || mo1284G()) {
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: s */
    public ax mo1346s(int i) {
        C0328a.m757c().m764b(m6108M());
        if (f4888c || mo1284G()) {
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: t */
    public Rect mo1348t(int i) {
        C0328a.m757c().m764b(m6108M());
        if (f4888c || mo1284G()) {
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: u */
    public Rect mo1350u(int i) {
        C0328a.m757c().m764b(m6108M());
        if (f4888c || mo1284G()) {
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: v */
    public int mo1352v(int i) {
        C0328a.m757c().m764b(m6108M());
        if (f4888c || mo1284G()) {
            return -1;
        }
        throw new AssertionError();
    }

    /* renamed from: N */
    protected void mo1288N() {
        if (this.f4901p != null) {
            this.f4892g.m6361b(this.f4901p);
            this.f4901p = null;
        }
        if (this.f4902q != null) {
            this.f4892g.m6361b(this.f4902q);
            this.f4902q = null;
        }
    }

    /* renamed from: b */
    protected int mo1300b(Canvas canvas, long j) {
        if (!f4888c && this.f4890e == null) {
            throw new AssertionError();
        } else if (!this.f4896k) {
            mo1376a(canvas);
            return 2;
        } else if (this.f4890e.m5817f()) {
            this.f4891f.a.setBounds(0, 0, getBounds().width(), getBounds().height());
            this.f4891f.a.draw(canvas);
            return 1;
        } else {
            int i;
            Rect e = m7414e();
            if (m6107L()) {
                mo1288N();
            }
            if (this.f4901p != null && (this.f4901p.m6384b() != this.f4891f || this.f4901p.m6386d() != m6106K() || this.f4901p.m6388f() || this.f4901p.m6381a(e, 1.0f) == 0)) {
                this.f4892g.m6361b(this.f4901p);
                this.f4901p = null;
            }
            if (this.f4902q != null && (this.f4902q.m6384b() != this.f4891f || this.f4902q.m6386d() != m6106K() || this.f4902q.m6388f() || this.f4902q.m6381a(e, 1.0f) == 0)) {
                this.f4892g.m6361b(this.f4902q);
                this.f4902q = null;
            }
            if (this.f4901p == null) {
                this.f4901p = this.f4892g.m6354a(this.f4889d, this.f4890e, e, this.f4891f, 1.0f, m6106K());
            } else {
                int a = this.f4901p.m6381a(e, 1.0f);
                if (a < Integer.MAX_VALUE) {
                    ap a2 = this.f4892g.m6355a(this.f4889d, this.f4890e, e, this.f4891f, 1.0f, m6106K(), a + 1);
                    if (a2 != null) {
                        if (!a2.m6387e()) {
                            this.f4892g.m6359a(a2);
                        } else if (f4888c || !a2.m6388f()) {
                            this.f4892g.m6361b(this.f4901p);
                            this.f4901p = a2;
                        } else {
                            throw new AssertionError();
                        }
                    }
                }
            }
            Object obj;
            if (this.f4901p != null) {
                obj = this.f4901p.m6381a(e, 1.0f) == Integer.MAX_VALUE ? 1 : null;
                if (!this.f4901p.m6383a(canvas, 0.0f, 0.0f, 1.0f)) {
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
            if (this.f4902q == this.f4901p) {
                this.f4902q = null;
            }
            if (this.f4902q != null && this.f4902q.m6387e()) {
                this.f4902q = null;
            }
            if (this.f4902q == null && obj == null) {
                this.f4902q = m7401O();
            }
            if (mo1330k() || this.f4889d.m5844d()) {
                return i;
            }
            this.a.setTextSize((float) this.f4891f.f);
            C0911h d = this.f4889d.mo1469e().mo1258d();
            if (this.f4889d.m7524h().c.top >= this.f4891f.f) {
                float length;
                float f;
                if (this.f4891f.m && this.f4899n == null) {
                    this.f4899n = d.mo1264a();
                    C0901g b = d.mo1267b(this.f4890e);
                    if (!(b == null || b.mo1203f().equals(this.f4890e.mo1460n()))) {
                        this.f4899n = b.mo1202e();
                    }
                    if (this.f4891f.k) {
                        this.f4899n = DkUtils.chs2chtText(this.f4899n);
                    }
                }
                if (this.f4891f.l) {
                    length = (float) d.mo1264a().length();
                } else {
                    length = 0.0f;
                }
                if (!this.f4891f.m || TextUtils.isEmpty(this.f4899n) || (this.f4891f.l && this.f4899n == d.mo1264a())) {
                    f = 0.0f;
                } else {
                    f = (float) this.f4899n.length();
                }
                int width = getBounds().width() - (mo1340p().f4332c.left + mo1340p().f4332c.right);
                if (Float.compare(length, 1.0f) > 0) {
                    m6118a(canvas, d.mo1264a(), 3, Math.round((((float) width) * length) / (length + f)), this.a);
                }
                if (Float.compare(f, 1.0f) > 0) {
                    String str = this.f4899n;
                    int i2 = (!this.f4891f.n || this.f4891f.l) ? 5 : 3;
                    m6118a(canvas, str, i2, Math.round((((float) width) * f) / (length + f)), this.a);
                }
            }
            if (this.f4889d.m7524h().c.bottom < this.f4891f.f) {
                return i;
            }
            if (this.f4900o == null && this.f4898m >= 0) {
                this.f4900o = String.format("%d / %d", new Object[]{Long.valueOf(this.f4898m + 1), Long.valueOf(this.f4889d.m5839b())});
            }
            if (TextUtils.isEmpty(this.f4900o)) {
                return i;
            }
            int i3;
            String str2 = this.f4900o;
            if (this.f4891f.n) {
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
        if (j2 > 0 && this.f4894i != null) {
            this.f4898m = m7410c(this.f4894i);
        }
        m6122a(new an(this));
    }

    /* renamed from: a */
    public void mo1462a(as asVar) {
        if (!f4888c && (this.f4889d == null || !this.f4889d.a)) {
            throw new AssertionError();
        } else if (f4888c || (this.f4890e != null && this.f4890e.m5777b())) {
            this.f4894i = asVar;
            DktPage P = m7402P();
            if (this.f4889d.m5839b() >= 0) {
                this.f4898m = m7410c(this.f4894i);
            } else {
                this.f4889d.m5836a((bd) this);
            }
            if (this.f4894i.m7500d() || this.f4890e.m5817f()) {
                this.f4899n = "";
            } else {
                if (this.f4889d.m7524h().e) {
                    this.f4897l = Math.max(this.f4897l, (int) P.getPageHeight());
                }
                if (!this.f4890e.m5817f()) {
                    if (!f4888c && this.f4902q != null) {
                        throw new AssertionError();
                    } else if (this.f4902q == null) {
                        this.f4902q = m7401O();
                    }
                }
            }
            this.f4895j = true;
            m6122a(new ao(this));
            this.f4889d.m5842c(this);
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: b */
    public void mo1463b(as asVar) {
        if (f4888c || this.f4894i.m7500d()) {
            this.f4895j = false;
            m6122a(new ap(this));
            this.f4889d.m5842c(this);
            return;
        }
        throw new AssertionError();
    }

    public int getIntrinsicHeight() {
        return this.f4897l;
    }

    /* renamed from: d */
    private void m7412d() {
        if (this.f4895j) {
            m7403Q();
        }
    }

    /* renamed from: e */
    private Rect m7414e() {
        Rect rect = new Rect(0, 0, this.f4889d.m7524h().a, this.f4897l);
        if (rect.width() % 2 != 0) {
            rect.right++;
        }
        return rect;
    }

    /* renamed from: c */
    private long m7410c(as asVar) {
        if (f4888c || (asVar != null && this.f4889d.m5839b() >= 0)) {
            return this.f4889d.m7519b(asVar.f4915a);
        }
        throw new AssertionError();
    }

    /* renamed from: O */
    private ap m7401O() {
        Rect e = m7414e();
        ap a = this.f4892g.m6354a(this.f4889d, this.f4890e, e, this.f4891f, 1.0f, m6106K());
        if (a != null) {
            this.f4892g.m6359a(a);
            if (a.m6381a(e, 1.0f) == Integer.MAX_VALUE) {
                return a;
            }
        }
        m7402P();
        a = this.f4892g.m6356a(this.f4889d, this.f4890e, e, this.f4891f, 1.0f, m6106K(), new aq(this));
        this.f4892g.m6359a(a);
        return a;
    }

    /* renamed from: a */
    private void m7404a(Bitmap bitmap, Bitmap bitmap2) {
        if (!f4888c && bitmap == null) {
            throw new AssertionError();
        } else if (!f4888c && this.f4891f == null) {
            throw new AssertionError();
        } else if (f4888c || this.f4889d.a) {
            if (bitmap2 != null) {
                synchronized (bitmap2) {
                    if (!bitmap2.isRecycled()) {
                        new Canvas(bitmap).drawBitmap(bitmap2, 0.0f, 0.0f, null);
                    }
                }
            } else {
                bitmap.eraseColor(0);
            }
            aa.m7376c().m7377a().setChsToCht(this.f4891f.k);
            this.f4889d.mo1469e().mo1468h().setTextColor(new DkArgbColor(this.f4891f.c));
            DktPage P = m7402P();
            DkFlowRenderOption dkFlowRenderOption = new DkFlowRenderOption();
            dkFlowRenderOption.mWidth = bitmap.getWidth();
            dkFlowRenderOption.mHeight = bitmap.getHeight();
            dkFlowRenderOption.mBitmap = bitmap;
            dkFlowRenderOption.mNightColor = new DkArgbColor(this.f4891f.d);
            dkFlowRenderOption.mOptimizeForNight = this.f4891f.i;
            dkFlowRenderOption.mOptimizeForDarkBackground = this.f4891f.j;
            P.render(dkFlowRenderOption);
            if (!(P.checkRenderStatus() == 0 || this.f4893h == null)) {
                this.f4893h.mo1225b(null, this);
            }
            m7403Q();
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: P */
    private DktPage m7402P() {
        return this.f4889d.mo1469e().mo1468h().acquirePage(this.f4890e.mo1460n().m7539g(), ab.m7380a(this.f4889d.m7524h()));
    }

    /* renamed from: Q */
    private void m7403Q() {
        this.f4889d.mo1469e().mo1468h().releasePage(this.f4890e.mo1460n().m7539g(), ab.m7380a(this.f4889d.m7524h()));
    }
}
