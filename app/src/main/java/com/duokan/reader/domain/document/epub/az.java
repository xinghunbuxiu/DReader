package com.duokan.reader.domain.document.epub;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;

import com.duokan.core.sys.ah;
import com.duokan.core.ui.UTools;
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
import com.duokan.reader.domain.document.d;
import com.duokan.reader.domain.document.g;
import com.duokan.reader.domain.document.h;
import com.duokan.reader.domain.document.k;
import com.duokan.reader.domain.document.m;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class az extends as implements ba, bd, cc {
    static final /* synthetic */ boolean c = (!az.class.desiredAssertionStatus());
    private static final String d = (az.class.getName() + ".loadPic");
    private bs[] A = null;
    private bk[] B = null;
    private bt[] C = null;
    private bm[] D = null;
    private ca[] E = null;
    private ap F = null;
    private ap G = null;
    private long H = 0;
    private final EpubTypesettingContext e;
    private final ay f;
    private au g = null;
    private final al h;
    private final at i;
    private cd j = null;
    private List k = Collections.emptyList();
    private List l = Collections.emptyList();
    private boolean m = false;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private boolean q = false;
    private int r = -1;
    private long s = -1;
    private String t = null;
    private String u = null;
    private String v = null;
    private DkeHitTestInfo[] w = null;
    private bz x = null;
    private bq[] y = null;
    private bj[] z = null;

    public /* synthetic */ bb a(Point point, Point point2) {
        return b(point, point2);
    }

    public /* synthetic */ bb b(Point point) {
        return h(point);
    }

    public /* synthetic */ d[] n() {
        return e();
    }

    public /* synthetic */ ad q(int i) {
        return w(i);
    }

    public az(EpubTypesettingContext epubTypesettingContext, ay ayVar, au auVar, al alVar, at atVar) {
        if (!c && (epubTypesettingContext == null || auVar == null)) {
            throw new AssertionError();
        } else if (c || (ayVar != null && ayVar.a())) {
            a.c().b(N());
            this.e = epubTypesettingContext;
            this.e.b((Object) t.b());
            this.e.b((Object) this);
            this.f = new ay(this.e, ayVar, 0);
            this.g = auVar;
            this.h = alVar;
            this.i = atVar;
            this.r = this.e.j().b;
            this.j = this.e.a(this.f, (cc) this);
        } else {
            throw new AssertionError();
        }
    }

    public long c() {
        return this.j.a;
    }

    public long d() {
        return this.j.b;
    }

    public boolean a() {
        a.c().b(N());
        if (E()) {
            return this.o;
        }
        return false;
    }

    public boolean b() {
        a.c().b(N());
        if (E()) {
            return this.p;
        }
        return false;
    }

    public long j() {
        a.c().b(N());
        return this.s;
    }

    public boolean k() {
        a.c().b(N());
        if (E() && !this.f.f() && !this.p && !this.o && Z().getChapterType(this.j.a) == 2 && A().isEmpty()) {
            return true;
        }
        return false;
    }

    public ak l() {
        a.c().b(N());
        return this.f;
    }

    public bb m() {
        a.c().b(N());
        if (E()) {
            return new ce(this.f.k(), this.f.l());
        }
        return new ce();
    }

    public c[] e() {
        a.c().b(N());
        if (!E()) {
            return new c[0];
        }
        if (this.f.f()) {
            return new c[0];
        }
        DkFlowPosition[] charPositions = Y().getCharPositions();
        c[] cVarArr = new c[charPositions.length];
        for (int i = 0; i < cVarArr.length; i++) {
            cVarArr[i] = ai.a(charPositions[i].mChapterIndex, charPositions[i].mParaIndex, charPositions[i].mAtomIndex);
        }
        return cVarArr;
    }

    public CharSequence o() {
        a.c().b(N());
        if (!E()) {
            return "";
        }
        if (this.f.f()) {
            return "";
        }
        return Y().getChars();
    }

    public k p() {
        a.c().b(N());
        return this.e.j();
    }

    public m q() {
        a.c().b(N());
        return this.g;
    }

    public void a(m mVar) {
        a.c().b(N());
        O();
        this.g = (au) mVar;
        if (this.B != null) {
            for (bk a : this.B) {
                a.m();
            }
        }
        invalidateSelf();
    }

    public int r() {
        a.c().b(N());
        if (!c && !G()) {
            throw new AssertionError();
        } else if (G()) {
            return this.y.length;
        } else {
            return 0;
        }
    }

    public int s() {
        return this.x != null ? 1 : 0;
    }

    public int t() {
        a.c().b(N());
        if (G()) {
            return this.z.length;
        }
        return 0;
    }

    public int u() {
        a.c().b(N());
        if (G()) {
            return this.A.length;
        }
        return 0;
    }

    public int v() {
        a.c().b(N());
        if (G()) {
            return this.B.length;
        }
        return 0;
    }

    public int w() {
        a.c().b(N());
        if (G()) {
            return this.C.length;
        }
        return 0;
    }

    public int x() {
        a.c().b(N());
        if (G()) {
            return this.D.length;
        }
        return 0;
    }

    public int y() {
        a.c().b(N());
        if (G()) {
            return this.E.length;
        }
        return 0;
    }

    public Rect z() {
        a.c().b(N());
        if (!G()) {
            return new Rect(0, 0, 0, 0);
        }
        if (this.f.f()) {
            return new Rect(0, 0, 0, 0);
        }
        k p = p();
        Rect a = p.a();
        Rect rect = new Rect(a.left, d(m()).bottom, getIntrinsicWidth() - a.right, getIntrinsicHeight() - a.bottom);
        if (rect.height() < p.f * 2) {
            return new Rect(0, 0, 0, 0);
        }
        return rect;
    }

    public Rect A() {
        a.c().b(N());
        if (!G()) {
            return new Rect(0, 0, 0, 0);
        }
        if (this.f.f()) {
            return new Rect(0, 0, 0, 0);
        }
        if (Y() instanceof DkeStuffingPage) {
            return getBounds();
        }
        return new Rect(0, 0, 0, 0);
    }

    public int B() {
        if (G()) {
            return (int) Y().getFrameCount();
        }
        return 0;
    }

    public boolean P() {
        if (G()) {
            return Z().isDrmChapter(this.j.a);
        }
        return false;
    }

    public Rect a(au auVar) {
        a.c().b(N());
        if (!G()) {
            return new Rect();
        }
        if (b(auVar)) {
            return new Rect(0, 0, getBounds().width(), getBounds().height());
        }
        return new Rect();
    }

    public boolean b(au auVar) {
        a.c().b(N());
        if (!G() || auVar == null) {
            return false;
        }
        if (this.x == auVar) {
            return true;
        }
        if (this.y != null) {
            for (au auVar2 : this.y) {
                if (auVar2 == auVar) {
                    return true;
                }
            }
        }
        if (this.B != null) {
            for (au auVar22 : this.B) {
                if (auVar22 == auVar) {
                    return true;
                }
            }
        }
        if (this.C != null) {
            for (au auVar222 : this.C) {
                if (auVar222 == auVar) {
                    return true;
                }
            }
        }
        if (this.D == null) {
            return false;
        }
        for (au auVar2222 : this.D) {
            if (auVar2222 == auVar) {
                return true;
            }
        }
        return false;
    }

    public void H() {
        a.c().b(N());
        if (!this.j.d()) {
            this.j.a();
            if (this.n) {
                V();
                this.m = false;
            }
            O();
            this.e.b((bd) this);
            this.e.c(t.b());
        }
    }

    public void a(boolean z) {
        a.c().b(N());
        if (this.F != null) {
            if (z) {
                this.h.a(this.F, true);
            } else {
                this.h.a(this.F);
            }
            this.F = null;
        }
    }

    public boolean E() {
        a.c().b(N());
        if (G()) {
            return true;
        }
        while (!this.m && !this.j.d() && this.e.a && !this.e.c()) {
            try {
                Thread.sleep(50);
            } catch (Throwable th) {
            }
        }
        return G();
    }

    public void a(Runnable runnable, Runnable runnable2) {
        a.c().b(N());
        ah.submitFuture(new ba(this, runnable, runnable2));
    }

    public boolean F() {
        a.c().b(N());
        return this.j.d();
    }

    public boolean G() {
        a.c().b(N());
        return !this.j.d() && this.m;
    }

    public ae a(Point point) {
        a.c().b(N());
        if (!G() || this.f.f()) {
            return null;
        }
        bk i = i(point);
        DkeLinkInfo hitTestLink;
        if (i != null) {
            ae aeVar;
            DkPos dkPos = new DkPos();
            dkPos.mX = (float) point.x;
            dkPos.mY = (float) point.y;
            hitTestLink = i.b.hitTestLink(dkPos);
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
        hitTestLink = Y().hitTestLink(dkPos2);
        if (hitTestLink == null || hitTestLink.mLinkType != 1) {
            return null;
        }
        return new bp(this, hitTestLink, null);
    }

    public ce b(Point point, Point point2) {
        a.c().b(N());
        if (!G() || this.f.f()) {
            return new ce();
        }
        DkFlowPosition[] selectionRange = Y().getSelectionRange(new DkPos((float) point.x, (float) point.y), new DkPos((float) point2.x, (float) point2.y));
        if (selectionRange.length < 2) {
            return new ce();
        }
        return ai.a(ai.a(selectionRange[0].mChapterIndex, selectionRange[0].mParaIndex, selectionRange[0].mAtomIndex), ai.a(selectionRange[1].mChapterIndex, selectionRange[1].mParaIndex, selectionRange[1].mAtomIndex));
    }

    public ce h(Point point) {
        a.c().b(N());
        if (!G() || this.f.f()) {
            return new ce();
        }
        bk i = i(point);
        DkFlowPosition[] hitTestTextRange;
        if (i != null) {
            DkPos dkPos = new DkPos();
            dkPos.mX = (float) point.x;
            dkPos.mY = (float) point.y;
            hitTestTextRange = i.b.hitTestTextRange(dkPos);
            if (hitTestTextRange.length < 2) {
                return new ce();
            }
            return ai.a(ai.a(hitTestTextRange[0].mChapterIndex, hitTestTextRange[0].mParaIndex, hitTestTextRange[0].mAtomIndex), ai.a(hitTestTextRange[1].mChapterIndex, hitTestTextRange[1].mParaIndex, hitTestTextRange[1].mAtomIndex));
        }
        DkPos dkPos2 = new DkPos();
        dkPos2.mX = (float) point.x;
        dkPos2.mY = (float) point.y;
        hitTestTextRange = Y().hitTestTextRangeByMode(dkPos2, 2);
        if (hitTestTextRange.length < 2) {
            return new ce();
        }
        return (ce) ai.a(ai.a(hitTestTextRange[0].mChapterIndex, hitTestTextRange[0].mParaIndex, hitTestTextRange[0].mAtomIndex), ai.a(hitTestTextRange[1].mChapterIndex, hitTestTextRange[1].mParaIndex, hitTestTextRange[1].mAtomIndex)).b(m());
    }

    public int c(Point point) {
        a.c().b(N());
        if (!G()) {
            return -1;
        }
        for (int i = 0; i < this.y.length; i++) {
            if (this.y[i].c.contains(point.x, point.y)) {
                return i;
            }
        }
        return -1;
    }

    public int a(Point point, int i) {
        a.c().b(N());
        if (!G()) {
            return -1;
        }
        int i2 = 0;
        while (i2 < this.z.length) {
            if ((this.z[i2].d < 0 || this.z[i2].e == this.B[this.z[i2].d].a()) && this.z[i2].c.intersects(point.x - i, point.y - i, point.x + i, point.y + i)) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public int d(Point point) {
        a.c().b(N());
        if (!G()) {
            return -1;
        }
        for (int i = 0; i < this.A.length; i++) {
            if (this.A[i].d.contains(point.x, point.y)) {
                return i;
            }
        }
        return -1;
    }

    public int e(Point point) {
        a.c().b(N());
        if (!G()) {
            return -1;
        }
        for (int i = 0; i < this.B.length; i++) {
            if (this.B[i].c.contains(point.x, point.y)) {
                return i;
            }
        }
        return -1;
    }

    public int a(bb bbVar) {
        a.c().b(N());
        if (!G()) {
            return -1;
        }
        for (int i = 0; i < this.B.length; i++) {
            if (this.B[i].a(bbVar)) {
                return i;
            }
        }
        return -1;
    }

    public int f(Point point) {
        a.c().b(N());
        return this.x == null ? -1 : 0;
    }

    public int g(Point point) {
        a.c().b(N());
        if (!G()) {
            return -1;
        }
        for (int i = 0; i < B(); i++) {
            if (u(i).contains(point.x, point.y)) {
                return i;
            }
        }
        return -1;
    }

    public Rect b(Rect rect) {
        a.c().b(N());
        return new Rect(rect);
    }

    public Rect c(Rect rect) {
        a.c().b(N());
        return new Rect(rect);
    }

    public af c(int i) {
        a.c().b(N());
        if (E()) {
            return this.y[i];
        }
        return null;
    }

    public aw d(int i) {
        return i == 0 ? this.x : null;
    }

    public ab e(int i) {
        a.c().b(N());
        if (E()) {
            return this.z[i];
        }
        return null;
    }

    public com.duokan.reader.domain.document.ah f(int i) {
        a.c().b(N());
        if (E()) {
            return this.A[i];
        }
        return null;
    }

    public Rect g(int i) {
        a.c().b(N());
        if (E()) {
            return this.y[i].c;
        }
        return new Rect();
    }

    public Rect h(int i) {
        a.c().b(N());
        if (E()) {
            return (this.x == null || i != 0) ? new Rect() : this.x.c;
        } else {
            return new Rect();
        }
    }

    public Rect i(int i) {
        a.c().b(N());
        if (E()) {
            return this.z[i].c;
        }
        return new Rect();
    }

    public Rect j(int i) {
        a.c().b(N());
        if (E()) {
            return this.A[i].d;
        }
        return new Rect();
    }

    public String I() {
        return this.t == null ? "" : this.t;
    }

    public String J() {
        a.c().b(N());
        if (E()) {
            return Y().getTextContent();
        }
        return "";
    }

    public String b(bb bbVar) {
        a.c().b(N());
        if (!c && bbVar == null) {
            throw new AssertionError();
        } else if (!E()) {
            return "";
        } else {
            String str = "";
            ce ceVar = (ce) bbVar.b(m());
            return Y().getTextContentOfRange(ceVar.j().b(Z()), ceVar.k().b(Z()));
        }
    }

    public String K() {
        a.c().b(N());
        if (!c && !G()) {
            throw new AssertionError();
        } else if (this.g.k) {
            return DkUtils.chs2chtText(J());
        } else {
            return J();
        }
    }

    public String c(bb bbVar) {
        a.c().b(N());
        if (!c && !G()) {
            throw new AssertionError();
        } else if (this.g.k) {
            return DkUtils.chs2chtText(b(bbVar));
        } else {
            return b(bbVar);
        }
    }

    public Rect d(bb bbVar) {
        int i = 0;
        a.c().b(N());
        if (!c && !G()) {
            throw new AssertionError();
        } else if (!c && bbVar == null) {
            throw new AssertionError();
        } else if (!G() || this.f.f()) {
            return new Rect();
        } else {
            if (bbVar == null || bbVar.f()) {
                return new Rect();
            }
            ce ceVar = (ce) bbVar;
            bk a = a(ceVar);
            DkBox[] textRects;
            Rect rect;
            if (a != null) {
                textRects = a.b.getTextRects(ceVar.j().b(Z()), ceVar.k().b(Z()));
                rect = new Rect();
                while (i < textRects.length) {
                    rect.union(new Rect(Math.round(textRects[i].mX0), Math.round(textRects[i].mY0), Math.round(textRects[i].mX1), Math.round(textRects[i].mY1)));
                    i++;
                }
                return rect;
            }
            textRects = Y().getTextRects(ceVar.j().b(Z()), ceVar.k().b(Z()));
            rect = new Rect();
            while (i < textRects.length) {
                rect.union(new Rect(Math.round(textRects[i].mX0), Math.round(textRects[i].mY0), Math.round(textRects[i].mX1), Math.round(textRects[i].mY1)));
                i++;
            }
            return rect;
        }
    }

    public Rect[] e(bb bbVar) {
        int i = 0;
        a.c().b(N());
        if (!c && !G()) {
            throw new AssertionError();
        } else if (!c && bbVar == null) {
            throw new AssertionError();
        } else if (!E() || this.f.f()) {
            return new Rect[0];
        } else {
            if (bbVar == null || bbVar.f()) {
                return new Rect[0];
            }
            ce ceVar = (ce) bbVar;
            bk a = a(ceVar);
            DkBox[] textRects;
            Rect[] rectArr;
            if (a != null) {
                textRects = a.b.getTextRects(ceVar.j().b(Z()), ceVar.k().b(Z()));
                rectArr = new Rect[textRects.length];
                while (i < rectArr.length) {
                    rectArr[i] = new Rect(Math.round(textRects[i].mX0), Math.round(textRects[i].mY0), Math.round(textRects[i].mX1), Math.round(textRects[i].mY1));
                    i++;
                }
                a(rectArr);
                return rectArr;
            }
            textRects = Y().getTextRects(ceVar.j().b(Z()), ceVar.k().b(Z()));
            rectArr = new Rect[textRects.length];
            while (i < rectArr.length) {
                rectArr[i] = new Rect(Math.round(textRects[i].mX0), Math.round(textRects[i].mY0), Math.round(textRects[i].mX1), Math.round(textRects[i].mY1));
                i++;
            }
            a(rectArr);
            return rectArr;
        }
    }

    public Point f(bb bbVar) {
        a.c().b(N());
        if (c || G()) {
            Point point = new Point();
            Rect[] e = e(bbVar);
            if (e.length >= 1) {
                switch (Z().getWritingMode()) {
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

    public Point g(bb bbVar) {
        a.c().b(N());
        if (c || G()) {
            Point point = new Point();
            Rect[] e = e(bbVar);
            if (e.length >= 1) {
                switch (Z().getWritingMode()) {
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

    public ac k(int i) {
        a.c().b(N());
        if (E()) {
            return this.B[i];
        }
        return null;
    }

    public Rect l(int i) {
        a.c().b(N());
        if (E()) {
            return this.B[i].c;
        }
        return new Rect();
    }

    public Rect m(int i) {
        a.c().b(N());
        if (!E()) {
            return new Rect();
        }
        Rect rect = new Rect(this.B[i].b());
        rect.offset(this.B[i].c.left, this.B[i].c.top);
        return rect;
    }

    public aj n(int i) {
        a.c().b(N());
        if (E()) {
            return this.C[i];
        }
        return null;
    }

    public Rect p(int i) {
        a.c().b(N());
        if (E()) {
            return this.C[i].n;
        }
        return new Rect();
    }

    public Rect o(int i) {
        a.c().b(N());
        if (E()) {
            return this.C[i].c();
        }
        return new Rect();
    }

    public bm w(int i) {
        a.c().b(N());
        if (E()) {
            return this.D[i];
        }
        return null;
    }

    public Rect r(int i) {
        a.c().b(N());
        if (E()) {
            return this.D[i].b;
        }
        return new Rect();
    }

    public ax s(int i) {
        a.c().b(N());
        if (E()) {
            return this.E[i];
        }
        return null;
    }

    public Rect t(int i) {
        a.c().b(N());
        if (E()) {
            return this.E[i].c;
        }
        return new Rect();
    }

    public Rect u(int i) {
        a.c().b(N());
        if (E()) {
            return Y().getFrameBoxOnPage((long) i).toRect();
        }
        return new Rect();
    }

    public int v(int i) {
        a.c().b(N());
        if (E()) {
            return (int) Y().getGlobalFrameIndex((long) i);
        }
        return -1;
    }

    public List Q() {
        a.c().b(N());
        if (!E()) {
            return Collections.emptyList();
        }
        Collection b = this.e.b(this.j.a);
        Collection collection = this.k;
        List arrayList = new ArrayList(b.size() + collection.size());
        arrayList.addAll(b);
        arrayList.addAll(collection);
        return arrayList;
    }

    public List R() {
        a.c().b(N());
        if (!E()) {
            return Collections.emptyList();
        }
        Collection c = this.e.c(this.j.a);
        Collection collection = this.l;
        List arrayList = new ArrayList(c.size() + collection.size());
        arrayList.addAll(c);
        arrayList.addAll(collection);
        return arrayList;
    }

    public void a(bc bcVar, long j, long j2) {
        if (j2 > 0 && this.j != null) {
            this.s = c(this.j);
        }
        a(new bc(this));
    }

    public void a(cd cdVar) {
        if (!c && (this.e == null || !this.e.a)) {
            throw new AssertionError();
        } else if (c || (this.f != null && this.f.b())) {
            DkePage dkePage;
            this.j = cdVar;
            if (this.e.b() >= 0) {
                this.s = c(this.j);
            } else {
                this.e.a((bd) this);
            }
            if (this.j.d() || this.f.f()) {
                dkePage = null;
            } else {
                boolean z;
                DkePage Y = Y();
                this.o = Y instanceof DkeDummyPage;
                if (!(Y instanceof DkeErrorPage) || TextUtils.equals(Z().getChapterPackUri(this.j.a), "/")) {
                    z = false;
                } else {
                    z = true;
                }
                this.p = z;
                this.q = Y instanceof DkeStuffingPage;
                if (!Y.checkPageElements()) {
                    Y.setInvisible(5);
                    Y.setInvisible(13);
                    Y.setInvisible(14);
                    Y.setInvisible(7);
                    Y.setInvisible(20);
                    Y.buildPageElements();
                }
                if (!this.e.j().e) {
                    dkePage = Y;
                } else if (T()) {
                    this.r = (int) Y.getPageHeight();
                    dkePage = Y;
                } else {
                    this.r = Math.max(this.r, (int) Y.getPageHeight());
                    dkePage = Y;
                }
            }
            if (dkePage == null || this.g.o) {
                this.w = new DkeHitTestInfo[0];
                this.t = "";
                this.y = new bq[0];
                this.B = new bk[0];
                this.C = new bt[0];
                this.z = new bj[0];
                this.A = new bs[0];
                this.D = new bm[0];
                this.E = new ca[0];
            } else {
                this.w = dkePage.getImages();
                if (!this.f.f()) {
                    if (!c && this.G != null) {
                        throw new AssertionError();
                    } else if (this.G == null) {
                        this.G = X();
                    }
                }
                f(dkePage);
                e(dkePage);
                g(dkePage);
                b(dkePage);
                a(dkePage);
                c(dkePage);
                d(dkePage);
            }
            this.m = true;
            a(new bd(this));
            this.e.c(this);
        } else {
            throw new AssertionError();
        }
    }

    public void b(cd cdVar) {
        if (c || this.j.d()) {
            this.m = false;
            a(new be(this));
            this.e.c(this);
            return;
        }
        throw new AssertionError();
    }

    protected int b(Canvas canvas, long j) {
        if (!c && this.f == null) {
            throw new AssertionError();
        } else if (!this.n) {
            a(canvas);
            return 2;
        } else if (this.f.f()) {
            this.g.a.setBounds(0, 0, getBounds().width(), getBounds().height());
            this.g.a.draw(canvas);
            return 1;
        } else {
            int a;
            int i;
            Rect W = W();
            if (M()) {
                O();
            }
            if (this.F != null && (this.F.b() != this.g || this.F.d() != L() || this.F.f() || this.F.a(W, 1.0f) == 0)) {
                this.h.b(this.F);
                this.F = null;
            }
            if (this.G != null && (this.G.b() != this.g || this.G.d() != L() || this.G.f() || this.G.a(W, 1.0f) == 0)) {
                this.h.b(this.G);
                this.G = null;
            }
            if (this.F == null) {
                this.F = this.h.a(this.e, this.f, W, this.g, 1.0f, L());
            } else {
                a = this.F.a(W, 1.0f);
                if (a < Integer.MAX_VALUE) {
                    ap a2 = this.h.a(this.e, this.f, W, this.g, 1.0f, L(), a + 1);
                    if (a2 != null) {
                        if (!a2.e()) {
                            this.h.a(a2);
                        } else if (c || !a2.f()) {
                            this.h.b(this.F);
                            this.F = a2;
                        } else {
                            throw new AssertionError();
                        }
                    }
                }
            }
            Object obj;
            if (this.F != null) {
                obj = this.F.a(W, 1.0f) == Integer.MAX_VALUE ? 1 : null;
                if (!this.F.a(canvas, 0.0f, 0.0f, 1.0f)) {
                    a(canvas);
                    i = 2;
                } else if (obj == null) {
                    invalidateSelf();
                    i = 3;
                } else if (!k() || this.H == 0) {
                    i = 1;
                } else {
                    i = 2;
                }
            } else {
                a(canvas);
                obj = null;
                i = 2;
            }
            if (this.G == this.F) {
                this.G = null;
            }
            if (this.G != null && this.G.e()) {
                this.G = null;
            }
            if (this.G == null && r0 == null) {
                this.G = X();
            }
            if (k() || this.e.d()) {
                return i;
            }
            g b;
            this.a.setTextSize((float) this.g.f);
            h d = this.e.e().d();
            if (this.e.j().c.top >= this.g.f) {
                float length;
                float f;
                if (this.g.m && this.t == null) {
                    this.t = d.a();
                    b = d.b(this.f);
                    if (!(b == null || b.f().equals(this.f.k()))) {
                        this.t = b.e();
                    }
                    if (this.g.k) {
                        this.t = DkUtils.chs2chtText(this.t);
                    }
                }
                if (this.g.l) {
                    length = (float) d.a().length();
                } else {
                    length = 0.0f;
                }
                if (!this.g.m || TextUtils.isEmpty(this.t) || (this.g.l && this.t == d.a())) {
                    f = 0.0f;
                } else {
                    f = (float) this.t.length();
                }
                int width = getBounds().width() - (p().c.left + p().c.right);
                if (Float.compare(length, 1.0f) >= 0) {
                    a(canvas, d.a(), 3, Math.round((((float) width) * length) / (length + f)), this.a);
                }
                if (Float.compare(f, 1.0f) >= 0) {
                    String str = this.t;
                    int i2 = (!this.g.n || this.g.l) ? 5 : 3;
                    a(canvas, str, i2, Math.round((((float) width) * f) / (length + f)), this.a);
                }
            }
            if (this.e.j().c.bottom < this.g.f) {
                return i;
            }
            if (this.v == null && this.s >= 0) {
                this.v = String.format("%getTriangleEdge / %getTriangleEdge", new Object[]{Long.valueOf(this.s + 1), Long.valueOf(this.e.b())});
            }
            if (this.u == null && this.s >= 0) {
                long d2 = this.e.d(this.j.a) - this.j.b;
                b = (f) d.b(this.f);
                if (b != null) {
                    f fVar = (f) d.a(b);
                    long j2 = this.j.a + 1;
                    while (j2 < (fVar == null ? b.l() + 1 : fVar.l())) {
                        long d3 = this.e.d(j2) + d2;
                        j2 = 1 + j2;
                        d2 = d3;
                    }
                }
                long j3 = d2;
                this.u = String.format(!TextUtils.isEmpty(this.g.q) ? this.g.q : "%getTriangleEdge", new Object[]{Long.valueOf(j3)});
            }
            if (this.g.r && this.u != null) {
                a(canvas, this.u, 5, this.a);
            }
            if (TextUtils.isEmpty(this.v)) {
                return i;
            }
            k p = p();
            m q = q();
            Rect rect = (Rect) UTools.g.getRect();
            Rect rect2 = (Rect) UTools.g.getRect();
            int i3 = p.c.left;
            a = getBounds().height() - p.c.bottom;
            int width2 = getBounds().width() - p.c.right;
            int width3 = (this.g.n && this.g.r && this.u != null) ? UTools.addAnimation(rect2, this.a, this.u, (float) (getBounds().width() - p.c.right)).width() + UTools.getMinimumHeight(DkApp.get().getTopActivity(), 10.0f) : 0;
            rect.set(i3, a, width2 - width3, (getBounds().height() - p.c.bottom) + q.f);
            UTools.addAnimation(canvas, this.v, rect, (this.g.n ? 5 : 1) | 16, this.a);
            UTools.g.getRect(rect2);
            UTools.g.getRect(rect);
            return i;
        }
    }

    protected void O() {
        if (this.F != null) {
            this.h.b(this.F);
            this.F = null;
        }
        if (this.G != null) {
            this.h.b(this.G);
            this.G = null;
        }
    }

    public int getIntrinsicHeight() {
        return this.r;
    }

    protected void a(Canvas canvas) {
        super.a(canvas);
        if (this.e.e() != null && U()) {
            canvas.drawColor(-16777216);
        }
    }

    private boolean T() {
        return U() && TextUtils.isEmpty(Y().getTextContent());
    }

    private boolean U() {
        int layoutType = Z().getLayoutType();
        return layoutType == 2 || layoutType == 3 || layoutType == 4;
    }

    private void V() {
        int i = 0;
        if (this.x != null) {
            this.x.b();
            this.x = null;
        }
        if (this.y != null) {
            for (bu b : this.y) {
                b.b();
            }
            this.y = null;
        }
        if (this.B != null) {
            for (bk d : this.B) {
                d.n();
            }
            this.B = null;
        }
        if (this.C != null) {
            for (bt b2 : this.C) {
                b2.b();
            }
        }
        if (this.D != null) {
            bm[] bmVarArr = this.D;
            int length = bmVarArr.length;
            while (i < length) {
                bmVarArr[i].b();
                i++;
            }
        }
        if (this.z != null) {
            this.z = null;
        }
        if (this.E != null) {
            this.E = null;
        }
    }

    private Rect W() {
        Rect rect = new Rect(0, 0, this.e.j().a, this.r);
        if (rect.width() % 2 != 0) {
            rect.right++;
        }
        return rect;
    }

    private bk i(Point point) {
        if (c || this.B != null) {
            for (int i = 0; i < this.B.length; i++) {
                if (this.B[i].c.contains(point.x, point.y)) {
                    return this.B[i];
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    private bk a(ce ceVar) {
        if (c || this.B != null) {
            for (int i = 0; i < this.B.length; i++) {
                if (this.B[i].a((bb) ceVar)) {
                    return this.B[i];
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    private long c(cd cdVar) {
        long j = 0;
        if (c || (cdVar != null && this.e.b() >= 0)) {
            long j2 = 0;
            while (j < cdVar.a) {
                j2 += (long) this.e.i[(int) j].length;
                j++;
            }
            return cdVar.b + j2;
        }
        throw new AssertionError();
    }

    private void a(DkePage dkePage) {
        if (!c && this.z != null) {
            throw new AssertionError();
        } else if (this.f.f()) {
            this.z = new bj[0];
        } else {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < this.B.length; i++) {
                int curActiveCell = this.B[i].b.getCurActiveCell();
                int i2 = 0;
                while (i2 < this.B[i].b.getCellCount()) {
                    this.B[i].b.setCurActiveCell(i2);
                    DkeHitTestInfo[] footnotes = this.B[i].b.getFootnotes();
                    if (c || footnotes != null) {
                        for (DkeHitTestInfo bjVar : footnotes) {
                            linkedList.add(new bj(this, bjVar, i, i2));
                        }
                        i2++;
                    } else {
                        throw new AssertionError();
                    }
                }
                this.B[i].b.setCurActiveCell(curActiveCell);
            }
            DkeHitTestInfo[] footnotes2 = dkePage.getFootnotes();
            if (c || footnotes2 != null) {
                for (DkeHitTestInfo bjVar2 : footnotes2) {
                    linkedList.add(new bj(this, bjVar2, -1, -1));
                }
                this.z = (bj[]) linkedList.toArray(new bj[0]);
                return;
            }
            throw new AssertionError();
        }
    }

    private void b(DkePage dkePage) {
        if (!c && this.y != null) {
            throw new AssertionError();
        } else if (this.y == null) {
            if (this.f.f()) {
                this.y = new bq[0];
                return;
            }
            int chapterType = Z().getChapterType(this.j.a);
            if ((chapterType == 5 || chapterType == 6) && this.w.length > 0) {
                this.x = new bz(this, this.w[0], chapterType);
                this.y = new bq[0];
                return;
            }
            ArrayList arrayList = new ArrayList(this.w.length);
            chapterType = 0;
            while (chapterType < this.w.length) {
                if (this.w[chapterType].mObjType == 2 || this.w[chapterType].mObjType == 3 || this.w[chapterType].mObjType == 5) {
                    arrayList.add(new bq(this, this.w[chapterType]));
                }
                chapterType++;
            }
            this.y = (bq[]) arrayList.toArray(new bq[0]);
        }
    }

    private void c(DkePage dkePage) {
        int i = 0;
        if (!c && this.A != null) {
            throw new AssertionError();
        } else if (this.A == null) {
            if (this.f.f()) {
                this.A = new bs[0];
                return;
            }
            DkeHitTestInfo[] medias = dkePage.getMedias();
            if (c || medias != null) {
                bs[] bsVarArr = new bs[medias.length];
                while (i < bsVarArr.length) {
                    bsVarArr[i] = new bs(this, medias[i]);
                    i++;
                }
                this.A = bsVarArr;
                return;
            }
            throw new AssertionError();
        }
    }

    private void d(DkePage dkePage) {
        int i = 0;
        if (!c && this.E != null) {
            throw new AssertionError();
        } else if (this.E == null) {
            if (this.f.f()) {
                this.E = new ca[0];
                return;
            }
            DkePreText[] preTexts = dkePage.getPreTexts();
            if (c || preTexts != null) {
                ca[] caVarArr = new ca[preTexts.length];
                while (i < caVarArr.length) {
                    caVarArr[i] = new ca(this, preTexts[i]);
                    i++;
                }
                this.E = caVarArr;
                return;
            }
            throw new AssertionError();
        }
    }

    private void e(DkePage dkePage) {
        int i = 0;
        if (!c && this.C != null) {
            throw new AssertionError();
        } else if (this.C == null) {
            if (this.f.f()) {
                this.C = new bt[0];
                return;
            }
            DkeMultiCallout[] multiCallouts = dkePage.getMultiCallouts();
            if (c || multiCallouts != null) {
                bt[] btVarArr = new bt[multiCallouts.length];
                while (i < multiCallouts.length) {
                    btVarArr[i] = new bt(this, multiCallouts[i]);
                    i++;
                }
                this.C = btVarArr;
                return;
            }
            throw new AssertionError();
        }
    }

    private void f(DkePage dkePage) {
        int i = 0;
        if (!c && this.D != null) {
            throw new AssertionError();
        } else if (this.D == null) {
            if (this.f.f()) {
                this.D = new bm[0];
                return;
            }
            DkeInteractiveGifImage[] interactiveGifImages = dkePage.getInteractiveGifImages();
            if (c || interactiveGifImages != null) {
                bm[] bmVarArr = new bm[interactiveGifImages.length];
                while (i < interactiveGifImages.length) {
                    bmVarArr[i] = new bm(this, interactiveGifImages[i]);
                    i++;
                }
                this.D = bmVarArr;
                return;
            }
            throw new AssertionError();
        }
    }

    private void g(DkePage dkePage) {
        int i = 0;
        if (!c && this.B != null) {
            throw new AssertionError();
        } else if (this.B == null) {
            if (this.f.f()) {
                this.B = new bk[0];
                return;
            }
            DkeGallery[] galleries = dkePage.getGalleries();
            if (c || galleries != null) {
                bk[] bkVarArr = new bk[galleries.length];
                while (i < bkVarArr.length) {
                    bkVarArr[i] = new bk(this, galleries[i]);
                    i++;
                }
                this.B = bkVarArr;
                return;
            }
            throw new AssertionError();
        }
    }

    private void a(Rect[] rectArr) {
        int writingMode = Z().getWritingMode();
        Comparator bfVar = writingMode == 2 ? new bf(this) : writingMode == 1 ? new bg(this) : new bh(this);
        Arrays.sort(rectArr, bfVar);
    }

    private ap X() {
        Rect W = W();
        ap a = this.h.a(this.e, this.f, W, this.g, 1.0f, L());
        if (a != null) {
            this.h.a(a);
            if (a.a(W, 1.0f) == Integer.MAX_VALUE) {
                return a;
            }
        }
        a = this.h.a(this.e, this.f, W, this.g, 1.0f, L(), new bi(this));
        this.h.a(a);
        return a;
    }

    private void a(Bitmap bitmap, Bitmap bitmap2) {
        if (!c && bitmap == null) {
            throw new AssertionError();
        } else if (!c && this.g == null) {
            throw new AssertionError();
        } else if (c || this.e.a) {
            if (T()) {
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
            int chapterType = Z().getChapterType(this.j.a);
            if (chapterType != 5 && chapterType != 6) {
                ah.e().d().setChsToCht(this.g.k);
                DkePage Y = Y();
                if (!c && Y == null) {
                    throw new AssertionError();
                } else if (Y != null) {
                    DkFlowRenderOption dkFlowRenderOption = new DkFlowRenderOption();
                    a(dkFlowRenderOption, bitmap, this.g);
                    this.e.f();
                    Y.render(dkFlowRenderOption);
                    this.k = this.e.g();
                    this.l = this.e.h();
                    this.H = Y.checkRenderStatus() & -2;
                    if ((Y instanceof DkeErrorPage) || !this.l.isEmpty()) {
                        if (!(this.H == 0 || Z().getChapterType(this.j.a) == 2)) {
                            Canvas canvas = new Canvas(bitmap);
                            Paint paint = (Paint) UTools.b.getRect();
                            paint.setColor(Color.argb(Math.round(12.75f), 0, 0, 0));
                            for (av avVar : this.l) {
                                if (avVar.j() || avVar.l() == null) {
                                    for (DkeHitTestInfo dkeHitTestInfo : this.w) {
                                        if (dkeHitTestInfo.mSrcImagePath.equals(avVar.g().a)) {
                                            canvas.drawRect(dkeHitTestInfo.mBoundingBox.toRect(), paint);
                                            break;
                                        }
                                    }
                                }
                            }
                            UTools.b.getRect(paint);
                        }
                        if (this.i != null) {
                            this.i.b(null, this);
                        }
                    }
                }
            }
        } else {
            throw new AssertionError();
        }
    }

    private void a(DkFlowRenderOption dkFlowRenderOption, Bitmap bitmap, au auVar) {
        dkFlowRenderOption.mWidth = bitmap.getWidth();
        dkFlowRenderOption.mHeight = bitmap.getHeight();
        dkFlowRenderOption.mBitmap = bitmap;
        dkFlowRenderOption.mNightColor = new DkArgbColor(auVar.d);
        if (Z().getChapterType(this.j.a) != 2) {
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

    private DkePage Y() {
        return Z().getPageOfChapterEx(this.j.a, this.j.b);
    }

    private DkeBook Z() {
        return this.e.e().h();
    }
}
