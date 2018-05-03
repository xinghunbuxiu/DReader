package com.duokan.reader.domain.document.epub;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.sys.UThread;
import com.duokan.core.sys.ah;
import com.duokan.core.ui.AnimUtils;
import com.duokan.kernel.DkArgbColor;
import com.duokan.kernel.DkBox;
import com.duokan.kernel.DkFlowPosition;
import com.duokan.kernel.DkFlowRenderOption;
import com.duokan.kernel.DkPos;
import com.duokan.kernel.DkUtils;
import com.duokan.kernel.epublib.DkeBook;
import com.duokan.kernel.epublib.DkeDummyPage;
import com.duokan.kernel.epublib.DkeErrorPage;
import com.duokan.kernel.epublib.DkeGallery;
import com.duokan.kernel.epublib.DkeHitTestInfo;
import com.duokan.kernel.epublib.DkeInteractiveGifImage;
import com.duokan.kernel.epublib.DkeLinkInfo;
import com.duokan.kernel.epublib.DkeMultiCallout;
import com.duokan.kernel.epublib.DkePage;
import com.duokan.kernel.epublib.DkePreText;
import com.duokan.kernel.epublib.DkeStuffingPage;
import com.duokan.reader.DkApp;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class az extends as implements ba, bd, cc {
    /* renamed from: c */
    static final /* synthetic */ boolean f4514c = (!az.class.desiredAssertionStatus());
    /* renamed from: d */
    private static final String f4515d = (az.class.getName() + ".loadPic");
    /* renamed from: A */
    private bs[] f4516A = null;
    /* renamed from: B */
    private bk[] f4517B = null;
    /* renamed from: C */
    private bt[] f4518C = null;
    /* renamed from: D */
    private bm[] f4519D = null;
    /* renamed from: E */
    private ca[] f4520E = null;
    /* renamed from: F */
    private ap f4521F = null;
    /* renamed from: G */
    private ap f4522G = null;
    /* renamed from: H */
    private long f4523H = 0;
    /* renamed from: e */
    private final EpubTypesettingContext f4524e;
    /* renamed from: f */
    private final ay f4525f;
    /* renamed from: g */
    private au f4526g = null;
    /* renamed from: h */
    private final al f4527h;
    /* renamed from: i */
    private final at f4528i;
    /* renamed from: j */
    private cd f4529j = null;
    /* renamed from: k */
    private List<av> f4530k = Collections.emptyList();
    /* renamed from: l */
    private List<av> f4531l = Collections.emptyList();
    /* renamed from: m */
    private boolean f4532m = false;
    /* renamed from: n */
    private boolean f4533n = false;
    /* renamed from: o */
    private boolean f4534o = false;
    /* renamed from: p */
    private boolean f4535p = false;
    /* renamed from: q */
    private boolean f4536q = false;
    /* renamed from: r */
    private int f4537r = -1;
    /* renamed from: s */
    private long f4538s = -1;
    /* renamed from: t */
    private String f4539t = null;
    /* renamed from: u */
    private String f4540u = null;
    /* renamed from: v */
    private String f4541v = null;
    /* renamed from: w */
    private DkeHitTestInfo[] f4542w = null;
    /* renamed from: x */
    private bz f4543x = null;
    /* renamed from: y */
    private bq[] f4544y = null;
    /* renamed from: z */
    private bj[] f4545z = null;

    /* renamed from: a */
    public /* synthetic */ bb mo1293a(Point point, Point point2) {
        return m6609b(point, point2);
    }

    /* renamed from: b */
    public /* synthetic */ bb mo1302b(Point point) {
        return m6634h(point);
    }

    /* renamed from: n */
    public /* synthetic */ C0897d[] mo1336n() {
        return m6626e();
    }

    /* renamed from: q */
    public /* synthetic */ ad mo1341q(int i) {
        return m6663w(i);
    }

    public az(EpubTypesettingContext epubTypesettingContext, ay ayVar, au auVar, al alVar, at atVar) {
        if (!f4514c && (epubTypesettingContext == null || auVar == null)) {
            throw new AssertionError();
        } else if (f4514c || (ayVar != null && ayVar.mo1186a())) {
            WebLog.init().w(m6108M());
            this.f4524e = epubTypesettingContext;
            this.f4524e.m5841b((Object) UThread.getCurrentThread());
            this.f4524e.m5841b((Object) this);
            this.f4525f = new ay(this.f4524e, ayVar, 0);
            this.f4526g = auVar;
            this.f4527h = alVar;
            this.f4528i = atVar;
            this.f4537r = this.f4524e.m6455j().b;
            this.f4529j = this.f4524e.m6443a(this.f4525f, (cc) this);
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: c */
    public long m6615c() {
        return this.f4529j.f4647a;
    }

    /* renamed from: d */
    public long m6620d() {
        return this.f4529j.f4648b;
    }

    /* renamed from: a */
    public boolean mo1299a() {
        WebLog.init().w(m6108M());
        if (mo1282E()) {
            return this.f4534o;
        }
        return false;
    }

    /* renamed from: b */
    public boolean mo1305b() {
        WebLog.init().w(m6108M());
        if (mo1282E()) {
            return this.f4535p;
        }
        return false;
    }

    /* renamed from: j */
    public long mo1327j() {
        WebLog.init().w(m6108M());
        return this.f4538s;
    }

    /* renamed from: k */
    public boolean mo1330k() {
        WebLog.init().w(m6108M());
        if (mo1282E() && !this.f4525f.m5817f() && !this.f4535p && !this.f4534o && m6544Y().getChapterType(this.f4529j.f4647a) == 2 && mo1280A().isEmpty()) {
            return true;
        }
        return false;
    }

    /* renamed from: l */
    public ak mo1332l() {
        WebLog.init().w(m6108M());
        return this.f4525f;
    }

    /* renamed from: m */
    public bb mo1334m() {
        WebLog.init().w(m6108M());
        if (mo1282E()) {
            return new ce(this.f4525f.m6533k(), this.f4525f.m6534l());
        }
        return new ce();
    }

    /* renamed from: e */
    public C0936c[] m6626e() {
        WebLog.init().w(m6108M());
        if (!mo1282E()) {
            return new C0936c[0];
        }
        if (this.f4525f.m5817f()) {
            return new C0936c[0];
        }
        DkFlowPosition[] charPositions = m6543X().getCharPositions();
        C0936c[] c0936cArr = new C0936c[charPositions.length];
        for (int i = 0; i < c0936cArr.length; i++) {
            c0936cArr[i] = ai.m6508a(charPositions[i].mChapterIndex, charPositions[i].mParaIndex, charPositions[i].mAtomIndex);
        }
        return c0936cArr;
    }

    /* renamed from: o */
    public CharSequence mo1338o() {
        WebLog.init().w(m6108M());
        if (!mo1282E()) {
            return "";
        }
        if (this.f4525f.m5817f()) {
            return "";
        }
        return m6543X().getChars();
    }

    /* renamed from: p */
    public C0917k mo1340p() {
        WebLog.init().w(m6108M());
        return this.f4524e.m6455j();
    }

    /* renamed from: q */
    public C0923m mo1342q() {
        WebLog.init().w(m6108M());
        return this.f4526g;
    }

    /* renamed from: a */
    public void mo1296a(C0923m c0923m) {
        WebLog.init().w(m6108M());
        mo1288N();
        this.f4526g = (au) c0923m;
        if (this.f4517B != null) {
            for (bk a : this.f4517B) {
                a.m6682m();
            }
        }
        invalidateSelf();
    }

    /* renamed from: r */
    public int mo1343r() {
        WebLog.init().w(m6108M());
        if (!f4514c && !mo1284G()) {
            throw new AssertionError();
        } else if (mo1284G()) {
            return this.f4544y.length;
        } else {
            return 0;
        }
    }

    /* renamed from: s */
    public int mo1345s() {
        return this.f4543x != null ? 1 : 0;
    }

    /* renamed from: t */
    public int mo1347t() {
        WebLog.init().w(m6108M());
        if (mo1284G()) {
            return this.f4545z.length;
        }
        return 0;
    }

    /* renamed from: u */
    public int mo1349u() {
        WebLog.init().w(m6108M());
        if (mo1284G()) {
            return this.f4516A.length;
        }
        return 0;
    }

    /* renamed from: v */
    public int mo1351v() {
        WebLog.init().w(m6108M());
        if (mo1284G()) {
            return this.f4517B.length;
        }
        return 0;
    }

    /* renamed from: w */
    public int mo1353w() {
        WebLog.init().w(m6108M());
        if (mo1284G()) {
            return this.f4518C.length;
        }
        return 0;
    }

    /* renamed from: x */
    public int mo1354x() {
        WebLog.init().w(m6108M());
        if (mo1284G()) {
            return this.f4519D.length;
        }
        return 0;
    }

    /* renamed from: y */
    public int mo1355y() {
        WebLog.init().w(m6108M());
        if (mo1284G()) {
            return this.f4520E.length;
        }
        return 0;
    }

    /* renamed from: z */
    public Rect mo1356z() {
        WebLog.init().w(m6108M());
        if (!mo1284G()) {
            return new Rect(0, 0, 0, 0);
        }
        if (this.f4525f.m5817f()) {
            return new Rect(0, 0, 0, 0);
        }
        C0917k p = mo1340p();
        Rect a = p.m6083a();
        Rect rect = new Rect(a.left, mo1311d(mo1334m()).bottom, getIntrinsicWidth() - a.right, getIntrinsicHeight() - a.bottom);
        if (rect.height() < p.f4335f * 2) {
            return new Rect(0, 0, 0, 0);
        }
        return rect;
    }

    /* renamed from: A */
    public Rect mo1280A() {
        WebLog.init().w(m6108M());
        if (!mo1284G()) {
            return new Rect(0, 0, 0, 0);
        }
        if (this.f4525f.m5817f()) {
            return new Rect(0, 0, 0, 0);
        }
        if (m6543X() instanceof DkeStuffingPage) {
            return getBounds();
        }
        return new Rect(0, 0, 0, 0);
    }

    /* renamed from: B */
    public int mo1281B() {
        if (mo1284G()) {
            return (int) m6543X().getFrameCount();
        }
        return 0;
    }

    /* renamed from: O */
    public boolean m6591O() {
        if (mo1284G()) {
            return m6544Y().isDrmChapter(this.f4529j.f4647a);
        }
        return false;
    }

    /* renamed from: a */
    public Rect mo1291a(au auVar) {
        WebLog.init().w(m6108M());
        if (!mo1284G()) {
            return new Rect();
        }
        if (m6613b(auVar)) {
            return new Rect(0, 0, getBounds().width(), getBounds().height());
        }
        return new Rect();
    }

    /* renamed from: b */
    public boolean m6613b(au auVar) {
        WebLog.init().w(m6108M());
        if (!mo1284G() || auVar == null) {
            return false;
        }
        if (this.f4543x == auVar) {
            return true;
        }
        if (this.f4544y != null) {
            for (au auVar2 : this.f4544y) {
                if (auVar2 == auVar) {
                    return true;
                }
            }
        }
        if (this.f4517B != null) {
            for (au auVar22 : this.f4517B) {
                if (auVar22 == auVar) {
                    return true;
                }
            }
        }
        if (this.f4518C != null) {
            for (au auVar222 : this.f4518C) {
                if (auVar222 == auVar) {
                    return true;
                }
            }
        }
        if (this.f4519D == null) {
            return false;
        }
        for (au auVar2222 : this.f4519D) {
            if (auVar2222 == auVar) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: H */
    public void mo1285H() {
        WebLog.init().w(m6108M());
        if (!this.f4529j.m6797d()) {
            this.f4529j.mo1440a();
            if (this.f4533n) {
                m6540U();
                this.f4532m = false;
            }
            mo1288N();
            this.f4524e.m5840b((bd) this);
            this.f4524e.m5842c(UThread.getCurrentThread());
        }
    }

    /* renamed from: a */
    public void mo1298a(boolean z) {
        WebLog.init().w(m6108M());
        if (this.f4521F != null) {
            if (z) {
                this.f4527h.m6360a(this.f4521F, true);
            } else {
                this.f4527h.m6359a(this.f4521F);
            }
            this.f4521F = null;
        }
    }

    /* renamed from: E */
    public boolean mo1282E() {
        WebLog.init().w(m6108M());
        if (mo1284G()) {
            return true;
        }
        while (!this.f4532m && !this.f4529j.m6797d() && this.f4524e.a && !this.f4524e.mo1272c()) {
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
        ah.m871b(new ba(this, runnable, runnable2));
    }

    /* renamed from: F */
    public boolean mo1283F() {
        WebLog.init().w(m6108M());
        return this.f4529j.m6797d();
    }

    /* renamed from: G */
    public boolean mo1284G() {
        WebLog.init().w(m6108M());
        return !this.f4529j.m6797d() && this.f4532m;
    }

    /* renamed from: a */
    public ae mo1292a(Point point) {
        WebLog.init().w(m6108M());
        if (!mo1284G() || this.f4525f.m5817f()) {
            return null;
        }
        bk i = m6569i(point);
        DkeLinkInfo hitTestLink;
        if (i != null) {
            ae aeVar;
            DkPos dkPos = new DkPos();
            dkPos.mX = (float) point.x;
            dkPos.mY = (float) point.y;
            hitTestLink = i.f4564b.hitTestLink(dkPos);
            if (hitTestLink == null || hitTestLink.mLinkType != 1) {
                aeVar = null;
            } else {
                aeVar = new bp(this, hitTestLink, null);
            }
            return aeVar;
        }
        DkPos dkPos2 = new DkPos();
        dkPos2.mX = (float) point.x;
        dkPos2.mY = (float) point.y;
        hitTestLink = m6543X().hitTestLink(dkPos2);
        if (hitTestLink == null || hitTestLink.mLinkType != 1) {
            return null;
        }
        return new bp(this, hitTestLink, null);
    }

    /* renamed from: b */
    public ce m6609b(Point point, Point point2) {
        WebLog.init().w(m6108M());
        if (!mo1284G() || this.f4525f.m5817f()) {
            return new ce();
        }
        DkFlowPosition[] selectionRange = m6543X().getSelectionRange(new DkPos((float) point.x, (float) point.y), new DkPos((float) point2.x, (float) point2.y));
        if (selectionRange.length < 2) {
            return new ce();
        }
        return ai.m6509a(ai.m6508a(selectionRange[0].mChapterIndex, selectionRange[0].mParaIndex, selectionRange[0].mAtomIndex), ai.m6508a(selectionRange[1].mChapterIndex, selectionRange[1].mParaIndex, selectionRange[1].mAtomIndex));
    }

    /* renamed from: h */
    public ce m6634h(Point point) {
        WebLog.init().w(m6108M());
        if (!mo1284G() || this.f4525f.m5817f()) {
            return new ce();
        }
        bk i = m6569i(point);
        DkFlowPosition[] hitTestTextRange;
        if (i != null) {
            DkPos dkPos = new DkPos();
            dkPos.mX = (float) point.x;
            dkPos.mY = (float) point.y;
            hitTestTextRange = i.f4564b.hitTestTextRange(dkPos);
            if (hitTestTextRange.length < 2) {
                return new ce();
            }
            return ai.m6509a(ai.m6508a(hitTestTextRange[0].mChapterIndex, hitTestTextRange[0].mParaIndex, hitTestTextRange[0].mAtomIndex), ai.m6508a(hitTestTextRange[1].mChapterIndex, hitTestTextRange[1].mParaIndex, hitTestTextRange[1].mAtomIndex));
        }
        DkPos dkPos2 = new DkPos();
        dkPos2.mX = (float) point.x;
        dkPos2.mY = (float) point.y;
        hitTestTextRange = m6543X().hitTestTextRangeByMode(dkPos2, 2);
        if (hitTestTextRange.length < 2) {
            return new ce();
        }
        return (ce) ai.m6509a(ai.m6508a(hitTestTextRange[0].mChapterIndex, hitTestTextRange[0].mParaIndex, hitTestTextRange[0].mAtomIndex), ai.m6508a(hitTestTextRange[1].mChapterIndex, hitTestTextRange[1].mParaIndex, hitTestTextRange[1].mAtomIndex)).mo1197b(mo1334m());
    }

    /* renamed from: c */
    public int mo1306c(Point point) {
        WebLog.init().w(m6108M());
        if (!mo1284G()) {
            return -1;
        }
        for (int i = 0; i < this.f4544y.length; i++) {
            if (this.f4544y[i].c.contains(point.x, point.y)) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: a */
    public int mo1289a(Point point, int i) {
        WebLog.init().w(m6108M());
        if (!mo1284G()) {
            return -1;
        }
        int i2 = 0;
        while (i2 < this.f4545z.length) {
            if ((this.f4545z[i2].f4560d < 0 || this.f4545z[i2].f4561e == this.f4517B[this.f4545z[i2].f4560d].mo1381a()) && this.f4545z[i2].f4559c.intersects(point.x - i, point.y - i, point.x + i, point.y + i)) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    /* renamed from: d */
    public int mo1310d(Point point) {
        WebLog.init().w(m6108M());
        if (!mo1284G()) {
            return -1;
        }
        for (int i = 0; i < this.f4516A.length; i++) {
            if (this.f4516A[i].f4606d.contains(point.x, point.y)) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: e */
    public int mo1314e(Point point) {
        WebLog.init().w(m6108M());
        if (!mo1284G()) {
            return -1;
        }
        for (int i = 0; i < this.f4517B.length; i++) {
            if (this.f4517B[i].f4565c.contains(point.x, point.y)) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: a */
    public int mo1290a(bb bbVar) {
        WebLog.init().w(m6108M());
        if (!mo1284G()) {
            return -1;
        }
        for (int i = 0; i < this.f4517B.length; i++) {
            if (this.f4517B[i].m6675a(bbVar)) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: f */
    public int mo1317f(Point point) {
        WebLog.init().w(m6108M());
        return this.f4543x == null ? -1 : 0;
    }

    /* renamed from: g */
    public int mo1320g(Point point) {
        WebLog.init().w(m6108M());
        if (!mo1284G()) {
            return -1;
        }
        for (int i = 0; i < mo1281B(); i++) {
            if (mo1350u(i).contains(point.x, point.y)) {
                return i;
            }
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
        if (mo1282E()) {
            return this.f4544y[i];
        }
        return null;
    }

    /* renamed from: d */
    public aw mo1312d(int i) {
        return i == 0 ? this.f4543x : null;
    }

    /* renamed from: e */
    public ab mo1315e(int i) {
        WebLog.init().w(m6108M());
        if (mo1282E()) {
            return this.f4545z[i];
        }
        return null;
    }

    /* renamed from: f */
    public com.duokan.reader.domain.document.ah mo1319f(int i) {
        WebLog.init().w(m6108M());
        if (mo1282E()) {
            return this.f4516A[i];
        }
        return null;
    }

    /* renamed from: g */
    public Rect mo1322g(int i) {
        WebLog.init().w(m6108M());
        if (mo1282E()) {
            return this.f4544y[i].c;
        }
        return new Rect();
    }

    /* renamed from: h */
    public Rect mo1325h(int i) {
        WebLog.init().w(m6108M());
        if (mo1282E()) {
            return (this.f4543x == null || i != 0) ? new Rect() : this.f4543x.c;
        } else {
            return new Rect();
        }
    }

    /* renamed from: i */
    public Rect mo1326i(int i) {
        WebLog.init().w(m6108M());
        if (mo1282E()) {
            return this.f4545z[i].f4559c;
        }
        return new Rect();
    }

    /* renamed from: j */
    public Rect mo1328j(int i) {
        WebLog.init().w(m6108M());
        if (mo1282E()) {
            return this.f4516A[i].f4606d;
        }
        return new Rect();
    }

    /* renamed from: I */
    public String mo1286I() {
        WebLog.init().w(m6108M());
        if (mo1282E()) {
            return m6543X().getTextContent();
        }
        return "";
    }

    /* renamed from: b */
    public String mo1303b(bb bbVar) {
        WebLog.init().w(m6108M());
        if (!f4514c && bbVar == null) {
            throw new AssertionError();
        } else if (!mo1282E()) {
            return "";
        } else {
            String str = "";
            ce ceVar = (ce) bbVar.mo1197b(mo1334m());
            return m6543X().getTextContentOfRange(ceVar.m6813j().m6774b(m6544Y()), ceVar.m6814k().m6774b(m6544Y()));
        }
    }

    /* renamed from: J */
    public String mo1287J() {
        WebLog.init().w(m6108M());
        if (!f4514c && !mo1284G()) {
            throw new AssertionError();
        } else if (this.f4526g.k) {
            return DkUtils.chs2chtText(mo1286I());
        } else {
            return mo1286I();
        }
    }

    /* renamed from: c */
    public String mo1309c(bb bbVar) {
        WebLog.init().w(m6108M());
        if (!f4514c && !mo1284G()) {
            throw new AssertionError();
        } else if (this.f4526g.k) {
            return DkUtils.chs2chtText(mo1303b(bbVar));
        } else {
            return mo1303b(bbVar);
        }
    }

    /* renamed from: d */
    public Rect mo1311d(bb bbVar) {
        int i = 0;
        WebLog.init().w(m6108M());
        if (!f4514c && !mo1284G()) {
            throw new AssertionError();
        } else if (!f4514c && bbVar == null) {
            throw new AssertionError();
        } else if (!mo1284G() || this.f4525f.m5817f()) {
            return new Rect();
        } else {
            if (bbVar == null || bbVar.m5817f()) {
                return new Rect();
            }
            ce ceVar = (ce) bbVar;
            bk a = m6545a(ceVar);
            DkBox[] textRects;
            Rect rect;
            if (a != null) {
                textRects = a.f4564b.getTextRects(ceVar.m6813j().m6774b(m6544Y()), ceVar.m6814k().m6774b(m6544Y()));
                rect = new Rect();
                while (i < textRects.length) {
                    rect.union(new Rect(Math.round(textRects[i].mX0), Math.round(textRects[i].mY0), Math.round(textRects[i].mX1), Math.round(textRects[i].mY1)));
                    i++;
                }
                return rect;
            }
            textRects = m6543X().getTextRects(ceVar.m6813j().m6774b(m6544Y()), ceVar.m6814k().m6774b(m6544Y()));
            rect = new Rect();
            while (i < textRects.length) {
                rect.union(new Rect(Math.round(textRects[i].mX0), Math.round(textRects[i].mY0), Math.round(textRects[i].mX1), Math.round(textRects[i].mY1)));
                i++;
            }
            return rect;
        }
    }

    /* renamed from: e */
    public Rect[] mo1316e(bb bbVar) {
        int i = 0;
        WebLog.init().w(m6108M());
        if (!f4514c && !mo1284G()) {
            throw new AssertionError();
        } else if (!f4514c && bbVar == null) {
            throw new AssertionError();
        } else if (!mo1282E() || this.f4525f.m5817f()) {
            return new Rect[0];
        } else {
            if (bbVar == null || bbVar.m5817f()) {
                return new Rect[0];
            }
            ce ceVar = (ce) bbVar;
            bk a = m6545a(ceVar);
            DkBox[] textRects;
            Rect[] rectArr;
            if (a != null) {
                textRects = a.f4564b.getTextRects(ceVar.m6813j().m6774b(m6544Y()), ceVar.m6814k().m6774b(m6544Y()));
                rectArr = new Rect[textRects.length];
                while (i < rectArr.length) {
                    rectArr[i] = new Rect(Math.round(textRects[i].mX0), Math.round(textRects[i].mY0), Math.round(textRects[i].mX1), Math.round(textRects[i].mY1));
                    i++;
                }
                m6551a(rectArr);
                return rectArr;
            }
            textRects = m6543X().getTextRects(ceVar.m6813j().m6774b(m6544Y()), ceVar.m6814k().m6774b(m6544Y()));
            rectArr = new Rect[textRects.length];
            while (i < rectArr.length) {
                rectArr[i] = new Rect(Math.round(textRects[i].mX0), Math.round(textRects[i].mY0), Math.round(textRects[i].mX1), Math.round(textRects[i].mY1));
                i++;
            }
            m6551a(rectArr);
            return rectArr;
        }
    }

    /* renamed from: f */
    public Point mo1318f(bb bbVar) {
        WebLog.init().w(m6108M());
        if (f4514c || mo1284G()) {
            Point point = new Point();
            Rect[] e = mo1316e(bbVar);
            if (e.length >= 1) {
                switch (m6544Y().getWritingMode()) {
                    case 1:
                        point.x = e[0].right;
                        point.y = e[0].top;
                        break;
                    case 2:
                        point.x = e[0].left;
                        point.y = e[0].top;
                        break;
                    default:
                        point.x = e[0].left;
                        point.y = e[0].top;
                        break;
                }
            }
            return point;
        }
        throw new AssertionError();
    }

    /* renamed from: g */
    public Point mo1321g(bb bbVar) {
        WebLog.init().w(m6108M());
        if (f4514c || mo1284G()) {
            Point point = new Point();
            Rect[] e = mo1316e(bbVar);
            if (e.length >= 1) {
                switch (m6544Y().getWritingMode()) {
                    case 1:
                        point.x = e[e.length - 1].left;
                        point.y = e[e.length - 1].bottom;
                        break;
                    case 2:
                        point.x = e[e.length - 1].right;
                        point.y = e[e.length - 1].bottom;
                        break;
                    default:
                        point.x = e[e.length - 1].right;
                        point.y = e[e.length - 1].bottom;
                        break;
                }
            }
            return point;
        }
        throw new AssertionError();
    }

    /* renamed from: k */
    public ac mo1329k(int i) {
        WebLog.init().w(m6108M());
        if (mo1282E()) {
            return this.f4517B[i];
        }
        return null;
    }

    /* renamed from: l */
    public Rect mo1331l(int i) {
        WebLog.init().w(m6108M());
        if (mo1282E()) {
            return this.f4517B[i].f4565c;
        }
        return new Rect();
    }

    /* renamed from: m */
    public Rect mo1333m(int i) {
        WebLog.init().w(m6108M());
        if (!mo1282E()) {
            return new Rect();
        }
        Rect rect = new Rect(this.f4517B[i].mo1385b());
        rect.offset(this.f4517B[i].f4565c.left, this.f4517B[i].f4565c.top);
        return rect;
    }

    /* renamed from: n */
    public aj mo1335n(int i) {
        WebLog.init().w(m6108M());
        if (mo1282E()) {
            return this.f4518C[i];
        }
        return null;
    }

    /* renamed from: p */
    public Rect mo1339p(int i) {
        WebLog.init().w(m6108M());
        if (mo1282E()) {
            return this.f4518C[i].f4610n;
        }
        return new Rect();
    }

    /* renamed from: o */
    public Rect mo1337o(int i) {
        WebLog.init().w(m6108M());
        if (mo1282E()) {
            return this.f4518C[i].m6760c();
        }
        return new Rect();
    }

    /* renamed from: w */
    public bm m6663w(int i) {
        WebLog.init().w(m6108M());
        if (mo1282E()) {
            return this.f4519D[i];
        }
        return null;
    }

    /* renamed from: r */
    public Rect mo1344r(int i) {
        WebLog.init().w(m6108M());
        if (mo1282E()) {
            return this.f4519D[i].f4574b;
        }
        return new Rect();
    }

    /* renamed from: s */
    public ax mo1346s(int i) {
        WebLog.init().w(m6108M());
        if (mo1282E()) {
            return this.f4520E[i];
        }
        return null;
    }

    /* renamed from: t */
    public Rect mo1348t(int i) {
        WebLog.init().w(m6108M());
        if (mo1282E()) {
            return this.f4520E[i].f4637c;
        }
        return new Rect();
    }

    /* renamed from: u */
    public Rect mo1350u(int i) {
        WebLog.init().w(m6108M());
        if (mo1282E()) {
            return m6543X().getFrameBoxOnPage((long) i).toRect();
        }
        return new Rect();
    }

    /* renamed from: v */
    public int mo1352v(int i) {
        WebLog.init().w(m6108M());
        if (mo1282E()) {
            return (int) m6543X().getGlobalFrameIndex((long) i);
        }
        return -1;
    }

    /* renamed from: P */
    public List<av> mo1374P() {
        WebLog.init().w(m6108M());
        if (!mo1282E()) {
            return Collections.emptyList();
        }
        Collection b = this.f4524e.m6447b(this.f4529j.f4647a);
        Collection collection = this.f4530k;
        List<av> arrayList = new ArrayList(b.size() + collection.size());
        arrayList.addAll(b);
        arrayList.addAll(collection);
        return arrayList;
    }

    /* renamed from: Q */
    public List<av> mo1375Q() {
        WebLog.init().w(m6108M());
        if (!mo1282E()) {
            return Collections.emptyList();
        }
        Collection c = this.f4524e.m6448c(this.f4529j.f4647a);
        Collection collection = this.f4531l;
        List<av> arrayList = new ArrayList(c.size() + collection.size());
        arrayList.addAll(c);
        arrayList.addAll(collection);
        return arrayList;
    }

    /* renamed from: a */
    public void mo1295a(bc bcVar, long j, long j2) {
        if (j2 > 0 && this.f4529j != null) {
            this.f4538s = m6557c(this.f4529j);
        }
        m6122a(new bc(this));
    }

    /* renamed from: a */
    public void mo1377a(cd cdVar) {
        if (!f4514c && (this.f4524e == null || !this.f4524e.a)) {
            throw new AssertionError();
        } else if (f4514c || (this.f4525f != null && this.f4525f.m5777b())) {
            DkePage dkePage;
            this.f4529j = cdVar;
            if (this.f4524e.m5839b() >= 0) {
                this.f4538s = m6557c(this.f4529j);
            } else {
                this.f4524e.m5836a((bd) this);
            }
            if (this.f4529j.m6797d() || this.f4525f.m5817f()) {
                dkePage = null;
            } else {
                boolean z;
                DkePage X = m6543X();
                this.f4534o = X instanceof DkeDummyPage;
                if (!(X instanceof DkeErrorPage) || TextUtils.equals(m6544Y().getChapterPackUri(this.f4529j.f4647a), "/")) {
                    z = false;
                } else {
                    z = true;
                }
                this.f4535p = z;
                this.f4536q = X instanceof DkeStuffingPage;
                if (!X.checkPageElements()) {
                    X.setInvisible(5);
                    X.setInvisible(13);
                    X.setInvisible(14);
                    X.setInvisible(7);
                    X.setInvisible(20);
                    X.buildPageElements();
                }
                if (!this.f4524e.m6455j().e) {
                    dkePage = X;
                } else if (m6538S()) {
                    this.f4537r = (int) X.getPageHeight();
                    dkePage = X;
                } else {
                    this.f4537r = Math.max(this.f4537r, (int) X.getPageHeight());
                    dkePage = X;
                }
            }
            if (dkePage == null || this.f4526g.o) {
                this.f4542w = new DkeHitTestInfo[0];
                this.f4539t = "";
                this.f4544y = new bq[0];
                this.f4517B = new bk[0];
                this.f4518C = new bt[0];
                this.f4545z = new bj[0];
                this.f4516A = new bs[0];
                this.f4519D = new bm[0];
                this.f4520E = new ca[0];
            } else {
                this.f4542w = dkePage.getImages();
                if (!this.f4525f.m5817f()) {
                    if (!f4514c && this.f4522G != null) {
                        throw new AssertionError();
                    } else if (this.f4522G == null) {
                        this.f4522G = m6542W();
                    }
                }
                m6565f(dkePage);
                m6563e(dkePage);
                m6566g(dkePage);
                m6555b(dkePage);
                m6548a(dkePage);
                m6559c(dkePage);
                m6560d(dkePage);
            }
            this.f4532m = true;
            m6122a(new bd(this));
            this.f4524e.m5842c(this);
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: b */
    public void mo1378b(cd cdVar) {
        if (f4514c || this.f4529j.m6797d()) {
            this.f4532m = false;
            m6122a(new be(this));
            this.f4524e.m5842c(this);
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: b */
    protected int mo1300b(Canvas canvas, long j) {
        if (!f4514c && this.f4525f == null) {
            throw new AssertionError();
        } else if (!this.f4533n) {
            mo1376a(canvas);
            return 2;
        } else if (this.f4525f.m5817f()) {
            this.f4526g.a.setBounds(0, 0, getBounds().width(), getBounds().height());
            this.f4526g.a.draw(canvas);
            return 1;
        } else {
            int a;
            int i;
            Rect V = m6541V();
            if (m6107L()) {
                mo1288N();
            }
            if (this.f4521F != null && (this.f4521F.m6384b() != this.f4526g || this.f4521F.m6386d() != m6106K() || this.f4521F.m6388f() || this.f4521F.m6381a(V, 1.0f) == 0)) {
                this.f4527h.m6361b(this.f4521F);
                this.f4521F = null;
            }
            if (this.f4522G != null && (this.f4522G.m6384b() != this.f4526g || this.f4522G.m6386d() != m6106K() || this.f4522G.m6388f() || this.f4522G.m6381a(V, 1.0f) == 0)) {
                this.f4527h.m6361b(this.f4522G);
                this.f4522G = null;
            }
            if (this.f4521F == null) {
                this.f4521F = this.f4527h.m6354a(this.f4524e, this.f4525f, V, this.f4526g, 1.0f, m6106K());
            } else {
                a = this.f4521F.m6381a(V, 1.0f);
                if (a < Integer.MAX_VALUE) {
                    ap a2 = this.f4527h.m6355a(this.f4524e, this.f4525f, V, this.f4526g, 1.0f, m6106K(), a + 1);
                    if (a2 != null) {
                        if (!a2.m6387e()) {
                            this.f4527h.m6359a(a2);
                        } else if (f4514c || !a2.m6388f()) {
                            this.f4527h.m6361b(this.f4521F);
                            this.f4521F = a2;
                        } else {
                            throw new AssertionError();
                        }
                    }
                }
            }
            Object obj;
            if (this.f4521F != null) {
                obj = this.f4521F.m6381a(V, 1.0f) == Integer.MAX_VALUE ? 1 : null;
                if (!this.f4521F.m6383a(canvas, 0.0f, 0.0f, 1.0f)) {
                    mo1376a(canvas);
                    i = 2;
                } else if (obj == null) {
                    invalidateSelf();
                    i = 3;
                } else if (!mo1330k() || this.f4523H == 0) {
                    i = 1;
                } else {
                    i = 2;
                }
            } else {
                mo1376a(canvas);
                obj = null;
                i = 2;
            }
            if (this.f4522G == this.f4521F) {
                this.f4522G = null;
            }
            if (this.f4522G != null && this.f4522G.m6387e()) {
                this.f4522G = null;
            }
            if (this.f4522G == null && obj == null) {
                this.f4522G = m6542W();
            }
            if (mo1330k() || this.f4524e.m5844d()) {
                return i;
            }
            C0901g b;
            this.a.setTextSize((float) this.f4526g.f);
            C0911h d = this.f4524e.mo1369e().mo1258d();
            if (this.f4524e.m6455j().c.top >= this.f4526g.f) {
                float length;
                float f;
                if (this.f4526g.m && this.f4539t == null) {
                    this.f4539t = d.mo1264a();
                    b = d.mo1267b(this.f4525f);
                    if (!(b == null || b.mo1203f().equals(this.f4525f.m6533k()))) {
                        this.f4539t = b.mo1202e();
                    }
                    if (this.f4526g.k) {
                        this.f4539t = DkUtils.chs2chtText(this.f4539t);
                    }
                }
                if (this.f4526g.l) {
                    length = (float) d.mo1264a().length();
                } else {
                    length = 0.0f;
                }
                if (!this.f4526g.m || TextUtils.isEmpty(this.f4539t) || (this.f4526g.l && this.f4539t == d.mo1264a())) {
                    f = 0.0f;
                } else {
                    f = (float) this.f4539t.length();
                }
                int width = getBounds().width() - (mo1340p().f4332c.left + mo1340p().f4332c.right);
                if (Float.compare(length, 1.0f) >= 0) {
                    m6118a(canvas, d.mo1264a(), 3, Math.round((((float) width) * length) / (length + f)), this.a);
                }
                if (Float.compare(f, 1.0f) >= 0) {
                    String str = this.f4539t;
                    int i2 = (!this.f4526g.n || this.f4526g.l) ? 5 : 3;
                    m6118a(canvas, str, i2, Math.round((((float) width) * f) / (length + f)), this.a);
                }
            }
            if (this.f4524e.m6455j().c.bottom < this.f4526g.f) {
                return i;
            }
            if (this.f4541v == null && this.f4538s >= 0) {
                this.f4541v = String.format("%d / %d", new Object[]{Long.valueOf(this.f4538s + 1), Long.valueOf(this.f4524e.m5839b())});
            }
            if (this.f4540u == null && this.f4538s >= 0) {
                long d2 = this.f4524e.m6449d(this.f4529j.f4647a) - this.f4529j.f4648b;
                b = (C0938f) d.mo1267b(this.f4525f);
                if (b != null) {
                    C0938f c0938f = (C0938f) d.m6047a(b);
                    long j2 = this.f4529j.f4647a + 1;
                    while (j2 < (c0938f == null ? b.mo1432l() + 1 : c0938f.mo1432l())) {
                        long d3 = this.f4524e.m6449d(j2) + d2;
                        j2 = 1 + j2;
                        d2 = d3;
                    }
                }
                long j3 = d2;
                this.f4540u = String.format(!TextUtils.isEmpty(this.f4526g.f4490q) ? this.f4526g.f4490q : "%d", new Object[]{Long.valueOf(j3)});
            }
            if (this.f4526g.f4491r && this.f4540u != null) {
                m6119a(canvas, this.f4540u, 5, this.a);
            }
            if (TextUtils.isEmpty(this.f4541v)) {
                return i;
            }
            C0917k p = mo1340p();
            C0923m q = mo1342q();
            Rect rect = (Rect) AnimUtils.f1198g.addAnimation();
            Rect rect2 = (Rect) AnimUtils.f1198g.addAnimation();
            int i3 = p.f4332c.left;
            a = getBounds().height() - p.f4332c.bottom;
            int width2 = getBounds().width() - p.f4332c.right;
            int width3 = (this.f4526g.n && this.f4526g.f4491r && this.f4540u != null) ? AnimUtils.getTextBounds(rect2, this.a, this.f4540u, (float) (getBounds().width() - p.f4332c.right)).width() + AnimUtils.m1932b(DkApp.get().getTopActivity(), 10.0f) : 0;
            rect.set(i3, a, width2 - width3, (getBounds().height() - p.f4332c.bottom) + q.f4358f);
            AnimUtils.m1913a(canvas, this.f4541v, rect, (this.f4526g.n ? 5 : 1) | 16, this.a);
            AnimUtils.f1198g.clearAnimation(rect2);
            AnimUtils.f1198g.clearAnimation(rect);
            return i;
        }
    }

    /* renamed from: N */
    protected void mo1288N() {
        if (this.f4521F != null) {
            this.f4527h.m6361b(this.f4521F);
            this.f4521F = null;
        }
        if (this.f4522G != null) {
            this.f4527h.m6361b(this.f4522G);
            this.f4522G = null;
        }
    }

    public int getIntrinsicHeight() {
        return this.f4537r;
    }

    /* renamed from: a */
    protected void mo1376a(Canvas canvas) {
        super.mo1376a(canvas);
        if (this.f4524e.mo1369e() != null && m6539T()) {
            canvas.drawColor(-16777216);
        }
    }

    /* renamed from: S */
    private boolean m6538S() {
        return m6539T() && TextUtils.isEmpty(m6543X().getTextContent());
    }

    /* renamed from: T */
    private boolean m6539T() {
        int layoutType = m6544Y().getLayoutType();
        return layoutType == 2 || layoutType == 3 || layoutType == 4;
    }

    /* renamed from: U */
    private void m6540U() {
        int i = 0;
        if (this.f4543x != null) {
            this.f4543x.mo1417b();
            this.f4543x = null;
        }
        if (this.f4544y != null) {
            for (bu b : this.f4544y) {
                b.mo1417b();
            }
            this.f4544y = null;
        }
        if (this.f4517B != null) {
            for (bk d : this.f4517B) {
                d.m6683n();
            }
            this.f4517B = null;
        }
        if (this.f4518C != null) {
            for (bt b2 : this.f4518C) {
                b2.mo1417b();
            }
        }
        if (this.f4519D != null) {
            bm[] bmVarArr = this.f4519D;
            int length = bmVarArr.length;
            while (i < length) {
                bmVarArr[i].m6708b();
                i++;
            }
        }
        if (this.f4545z != null) {
            this.f4545z = null;
        }
        if (this.f4520E != null) {
            this.f4520E = null;
        }
    }

    /* renamed from: V */
    private Rect m6541V() {
        Rect rect = new Rect(0, 0, this.f4524e.m6455j().a, this.f4537r);
        if (rect.width() % 2 != 0) {
            rect.right++;
        }
        return rect;
    }

    /* renamed from: i */
    private bk m6569i(Point point) {
        if (f4514c || this.f4517B != null) {
            for (int i = 0; i < this.f4517B.length; i++) {
                if (this.f4517B[i].f4565c.contains(point.x, point.y)) {
                    return this.f4517B[i];
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    private bk m6545a(ce ceVar) {
        if (f4514c || this.f4517B != null) {
            for (int i = 0; i < this.f4517B.length; i++) {
                if (this.f4517B[i].m6675a((bb) ceVar)) {
                    return this.f4517B[i];
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: c */
    private long m6557c(cd cdVar) {
        long j = 0;
        if (f4514c || (cdVar != null && this.f4524e.m5839b() >= 0)) {
            long j2 = 0;
            while (j < cdVar.f4647a) {
                j2 += (long) this.f4524e.f4451i[(int) j].length;
                j++;
            }
            return cdVar.f4648b + j2;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    private void m6548a(DkePage dkePage) {
        if (!f4514c && this.f4545z != null) {
            throw new AssertionError();
        } else if (this.f4525f.m5817f()) {
            this.f4545z = new bj[0];
        } else {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < this.f4517B.length; i++) {
                int curActiveCell = this.f4517B[i].f4564b.getCurActiveCell();
                int i2 = 0;
                while (i2 < this.f4517B[i].f4564b.getCellCount()) {
                    this.f4517B[i].f4564b.setCurActiveCell(i2);
                    DkeHitTestInfo[] footnotes = this.f4517B[i].f4564b.getFootnotes();
                    if (f4514c || footnotes != null) {
                        for (DkeHitTestInfo bjVar : footnotes) {
                            linkedList.add(new bj(this, bjVar, i, i2));
                        }
                        i2++;
                    } else {
                        throw new AssertionError();
                    }
                }
                this.f4517B[i].f4564b.setCurActiveCell(curActiveCell);
            }
            DkeHitTestInfo[] footnotes2 = dkePage.getFootnotes();
            if (f4514c || footnotes2 != null) {
                for (DkeHitTestInfo bjVar2 : footnotes2) {
                    linkedList.add(new bj(this, bjVar2, -1, -1));
                }
                this.f4545z = (bj[]) linkedList.toArray(new bj[0]);
                return;
            }
            throw new AssertionError();
        }
    }

    /* renamed from: b */
    private void m6555b(DkePage dkePage) {
        if (!f4514c && this.f4544y != null) {
            throw new AssertionError();
        } else if (this.f4544y == null) {
            if (this.f4525f.m5817f()) {
                this.f4544y = new bq[0];
                return;
            }
            int chapterType = m6544Y().getChapterType(this.f4529j.f4647a);
            if ((chapterType == 5 || chapterType == 6) && this.f4542w.length > 0) {
                this.f4543x = new bz(this, this.f4542w[0], chapterType);
                this.f4544y = new bq[0];
                return;
            }
            ArrayList arrayList = new ArrayList(this.f4542w.length);
            chapterType = 0;
            while (chapterType < this.f4542w.length) {
                if (this.f4542w[chapterType].mObjType == 2 || this.f4542w[chapterType].mObjType == 3 || this.f4542w[chapterType].mObjType == 5) {
                    arrayList.add(new bq(this, this.f4542w[chapterType]));
                }
                chapterType++;
            }
            this.f4544y = (bq[]) arrayList.toArray(new bq[0]);
        }
    }

    /* renamed from: c */
    private void m6559c(DkePage dkePage) {
        int i = 0;
        if (!f4514c && this.f4516A != null) {
            throw new AssertionError();
        } else if (this.f4516A == null) {
            if (this.f4525f.m5817f()) {
                this.f4516A = new bs[0];
                return;
            }
            DkeHitTestInfo[] medias = dkePage.getMedias();
            if (f4514c || medias != null) {
                bs[] bsVarArr = new bs[medias.length];
                while (i < bsVarArr.length) {
                    bsVarArr[i] = new bs(this, medias[i]);
                    i++;
                }
                this.f4516A = bsVarArr;
                return;
            }
            throw new AssertionError();
        }
    }

    /* renamed from: d */
    private void m6560d(DkePage dkePage) {
        int i = 0;
        if (!f4514c && this.f4520E != null) {
            throw new AssertionError();
        } else if (this.f4520E == null) {
            if (this.f4525f.m5817f()) {
                this.f4520E = new ca[0];
                return;
            }
            DkePreText[] preTexts = dkePage.getPreTexts();
            if (f4514c || preTexts != null) {
                ca[] caVarArr = new ca[preTexts.length];
                while (i < caVarArr.length) {
                    caVarArr[i] = new ca(this, preTexts[i]);
                    i++;
                }
                this.f4520E = caVarArr;
                return;
            }
            throw new AssertionError();
        }
    }

    /* renamed from: e */
    private void m6563e(DkePage dkePage) {
        int i = 0;
        if (!f4514c && this.f4518C != null) {
            throw new AssertionError();
        } else if (this.f4518C == null) {
            if (this.f4525f.m5817f()) {
                this.f4518C = new bt[0];
                return;
            }
            DkeMultiCallout[] multiCallouts = dkePage.getMultiCallouts();
            if (f4514c || multiCallouts != null) {
                bt[] btVarArr = new bt[multiCallouts.length];
                while (i < multiCallouts.length) {
                    btVarArr[i] = new bt(this, multiCallouts[i]);
                    i++;
                }
                this.f4518C = btVarArr;
                return;
            }
            throw new AssertionError();
        }
    }

    /* renamed from: f */
    private void m6565f(DkePage dkePage) {
        int i = 0;
        if (!f4514c && this.f4519D != null) {
            throw new AssertionError();
        } else if (this.f4519D == null) {
            if (this.f4525f.m5817f()) {
                this.f4519D = new bm[0];
                return;
            }
            DkeInteractiveGifImage[] interactiveGifImages = dkePage.getInteractiveGifImages();
            if (f4514c || interactiveGifImages != null) {
                bm[] bmVarArr = new bm[interactiveGifImages.length];
                while (i < interactiveGifImages.length) {
                    bmVarArr[i] = new bm(this, interactiveGifImages[i]);
                    i++;
                }
                this.f4519D = bmVarArr;
                return;
            }
            throw new AssertionError();
        }
    }

    /* renamed from: g */
    private void m6566g(DkePage dkePage) {
        int i = 0;
        if (!f4514c && this.f4517B != null) {
            throw new AssertionError();
        } else if (this.f4517B == null) {
            if (this.f4525f.m5817f()) {
                this.f4517B = new bk[0];
                return;
            }
            DkeGallery[] galleries = dkePage.getGalleries();
            if (f4514c || galleries != null) {
                bk[] bkVarArr = new bk[galleries.length];
                while (i < bkVarArr.length) {
                    bkVarArr[i] = new bk(this, galleries[i]);
                    i++;
                }
                this.f4517B = bkVarArr;
                return;
            }
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    private void m6551a(Rect[] rectArr) {
        int writingMode = m6544Y().getWritingMode();
        Comparator bfVar = writingMode == 2 ? new bf(this) : writingMode == 1 ? new bg(this) : new bh(this);
        Arrays.sort(rectArr, bfVar);
    }

    /* renamed from: W */
    private ap m6542W() {
        Rect V = m6541V();
        ap a = this.f4527h.m6354a(this.f4524e, this.f4525f, V, this.f4526g, 1.0f, m6106K());
        if (a != null) {
            this.f4527h.m6359a(a);
            if (a.m6381a(V, 1.0f) == Integer.MAX_VALUE) {
                return a;
            }
        }
        a = this.f4527h.m6356a(this.f4524e, this.f4525f, V, this.f4526g, 1.0f, m6106K(), new bi(this));
        this.f4527h.m6359a(a);
        return a;
    }

    /* renamed from: a */
    private void m6546a(Bitmap bitmap, Bitmap bitmap2) {
        if (!f4514c && bitmap == null) {
            throw new AssertionError();
        } else if (!f4514c && this.f4526g == null) {
            throw new AssertionError();
        } else if (f4514c || this.f4524e.a) {
            if (m6538S()) {
                bitmap.eraseColor(-16777216);
            } else if (bitmap2 != null) {
                synchronized (bitmap2) {
                    if (!bitmap2.isRecycled()) {
                        new Canvas(bitmap).drawBitmap(bitmap2, 0.0f, 0.0f, null);
                    }
                }
            } else {
                bitmap.eraseColor(0);
            }
            int chapterType = m6544Y().getChapterType(this.f4529j.f4647a);
            if (chapterType != 5 && chapterType != 6) {
                ah.m6500e().m6504d().setChsToCht(this.f4526g.k);
                DkePage X = m6543X();
                if (!f4514c && X == null) {
                    throw new AssertionError();
                } else if (X != null) {
                    DkFlowRenderOption dkFlowRenderOption = new DkFlowRenderOption();
                    m6547a(dkFlowRenderOption, bitmap, this.f4526g);
                    this.f4524e.mo1370f();
                    X.render(dkFlowRenderOption);
                    this.f4530k = this.f4524e.mo1371g();
                    this.f4531l = this.f4524e.mo1372h();
                    this.f4523H = X.checkRenderStatus() & -2;
                    if ((X instanceof DkeErrorPage) || !this.f4531l.isEmpty()) {
                        if (!(this.f4523H == 0 || m6544Y().getChapterType(this.f4529j.f4647a) == 2)) {
                            Canvas canvas = new Canvas(bitmap);
                            Paint paint = (Paint) AnimUtils.f1193b.addAnimation();
                            paint.setColor(Color.argb(Math.round(12.75f), 0, 0, 0));
                            for (av avVar : this.f4531l) {
                                if (avVar.mo1074j() || avVar.mo1076l() == null) {
                                    for (DkeHitTestInfo dkeHitTestInfo : this.f4542w) {
                                        if (dkeHitTestInfo.mSrcImagePath.equals(avVar.mo1071g().f4492a)) {
                                            canvas.drawRect(dkeHitTestInfo.mBoundingBox.toRect(), paint);
                                            break;
                                        }
                                    }
                                }
                            }
                            AnimUtils.f1193b.clearAnimation(paint);
                        }
                        if (this.f4528i != null) {
                            this.f4528i.mo1225b(null, this);
                        }
                    }
                }
            }
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    private void m6547a(DkFlowRenderOption dkFlowRenderOption, Bitmap bitmap, au auVar) {
        dkFlowRenderOption.mWidth = bitmap.getWidth();
        dkFlowRenderOption.mHeight = bitmap.getHeight();
        dkFlowRenderOption.mBitmap = bitmap;
        dkFlowRenderOption.mNightColor = new DkArgbColor(auVar.d);
        if (m6544Y().getChapterType(this.f4529j.f4647a) != 2) {
            dkFlowRenderOption.mOptimizeForNight = auVar.i;
            dkFlowRenderOption.mOptimizeForDarkBackground = auVar.j;
        } else {
            dkFlowRenderOption.mOptimizeForNight = false;
            dkFlowRenderOption.mOptimizeForDarkBackground = false;
        }
        if (auVar.c == 0) {
            dkFlowRenderOption.mTextColor = null;
        } else {
            dkFlowRenderOption.mTextColor = new DkArgbColor(auVar.c);
        }
    }

    /* renamed from: X */
    private DkePage m6543X() {
        return m6544Y().getPageOfChapterEx(this.f4529j.f4647a, this.f4529j.f4648b);
    }

    /* renamed from: Y */
    private DkeBook m6544Y() {
        return this.f4524e.mo1369e().mo1365h();
    }
}
