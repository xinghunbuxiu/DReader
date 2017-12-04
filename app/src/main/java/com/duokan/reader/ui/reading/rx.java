package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.View;

import com.duokan.core.app.BrightnessMode;
import com.duokan.core.app.MyContextWrapper;
import com.duokan.core.sys.TaskHandler;
import com.duokan.core.sys.ag;
import com.duokan.core.sys.j;
import com.duokan.core.ui.UTools;
import com.duokan.core.ui.er;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.bookshelf.BookLimitType;
import com.duokan.reader.domain.bookshelf.BookType;
import com.duokan.reader.domain.bookshelf.a;
import com.duokan.reader.domain.bookshelf.ah;
import com.duokan.reader.domain.bookshelf.an;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.ef;
import com.duokan.reader.domain.bookshelf.hh;
import com.duokan.reader.domain.bookshelf.iv;
import com.duokan.reader.domain.cloud.DkCloudRedeemBenefit;
import com.duokan.reader.domain.cloud.DkUserPurchasedBooksManager;
import com.duokan.reader.domain.document.Document_a;
import com.duokan.reader.domain.document.ac;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.at;
import com.duokan.reader.domain.document.au;
import com.duokan.reader.domain.document.av;
import com.duokan.reader.domain.document.ay;
import com.duokan.reader.domain.document.ba;
import com.duokan.reader.domain.document.bb;
import com.duokan.reader.domain.document.d;
import com.duokan.reader.domain.document.g;
import com.duokan.reader.domain.document.m;
import com.duokan.reader.domain.document.n;
import com.duokan.reader.domain.store.DkStoreItemDetail;
import com.duokan.reader.ui.bookshelf.jd;
import com.duokan.reader.ui.general.FixedPagesView.PageScaleType;
import com.duokan.reader.ui.general.PagesView.PageLayout;
import com.duokan.reader.ui.general.ReaderUi;
import com.duokan.reader.ui.r;
import com.duokan.reader.ui.s;
import com.duokan.reader.ui.store.bv;
import com.duokan.reader.ui.welcome.DkTipManager.UserInput;
import com.duokan.reader.ui.welcome.p;
import com.google.android.collect.Lists;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class rx implements iv, at, sh {
    static final /* synthetic */ boolean b = (!qh.class.desiredAssertionStatus());
    private Rect a;
    final /* synthetic */ qh c;
    private boolean d = false;
    private g e;
    private final r f = new ry(this);
    private int g = 0;

    protected rx(qh qhVar) {
        this.c = qhVar;
    }

    public void p() {
        v().showMenuFromTop(new jd(this.c.getContext()));
    }

    public r getTheme() {
        return this.f;
    }

    public bb getSelection() {
        return this.c.e.getShowingDocPresenter().getSelection();
    }

    public Rect getSelectionStartIndicatorBounds() {
        return this.c.e.getShowingDocPresenter().getSelectionStartIndicatorBounds();
    }

    public Rect getSelectionEndIndicatorBounds() {
        return this.c.e.getShowingDocPresenter().getSelectionEndIndicatorBounds();
    }

    public void setSelection(bb bbVar) {
        this.c.e.getShowingDocPresenter().setSelection(bbVar);
    }

    public void setAnnotations(a[] aVarArr) {
        this.c.e.getShowingDocPresenter().setAnnotations(aVarArr);
    }

    public a[] getAnnotations() {
        return this.c.e.getShowingDocPresenter().getAnnotations();
    }

    public void a(n nVar, Document_a aVar) {
    }

    public Drawable a(DecorDrawableStyle decorDrawableStyle) {
        return this.c.e.getShowingDocPresenter().a(decorDrawableStyle);
    }

    public Drawable getSelectionDrawable() {
        return this.c.e.getShowingDocPresenter().getSelectionDrawable();
    }

    public void setSelectionDrawable(Drawable drawable) {
        this.c.e.getShowingDocPresenter().setSelectionDrawable(drawable);
    }

    public void setShowSelectionIndicators(boolean z) {
        this.c.e.getShowingDocPresenter().setShowSelectionIndicators(z);
    }

    public boolean s() {
        return this.c.e.getShowingDocPresenter().s();
    }

    public void d(bb bbVar) {
        if (!aW()) {
            this.c.e.getShowingDocPresenter().d(bbVar);
        }
    }

    public void a(bb bbVar, DecorDrawableStyle decorDrawableStyle) {
        this.c.e.getShowingDocPresenter().a(bbVar, decorDrawableStyle);
    }

    public void b(bb bbVar, DecorDrawableStyle decorDrawableStyle) {
        this.c.e.getShowingDocPresenter().b(bbVar, decorDrawableStyle);
    }

    public Map getHighlights() {
        return this.c.e.getShowingDocPresenter().getHighlights();
    }

    public void setActiveColorText(bb bbVar) {
        this.c.e.getShowingDocPresenter().setActiveColorText(bbVar);
    }

    public bb getActiveText() {
        return this.c.e.getShowingDocPresenter().getActiveText();
    }

    public void t() {
        this.c.e.getShowingPagesView().h();
    }

    public void a(Runnable runnable, Runnable runnable2) {
        a(null, runnable, runnable2);
    }

    public void a(PointF pointF, Runnable runnable, Runnable runnable2) {
        if (this.c.J != null && !this.c.J.b(pointF, runnable, runnable2)) {
            this.c.e.getShowingPagesView().a(runnable, runnable2);
        }
    }

    public void u() {
        this.c.e.getShowingPagesView().i();
    }

    public void b(Runnable runnable, Runnable runnable2) {
        b(null, runnable, runnable2);
    }

    public void b(PointF pointF, Runnable runnable, Runnable runnable2) {
        if (this.c.J != null && !this.c.J.a(pointF, runnable, runnable2)) {
            this.c.e.getShowingPagesView().b(runnable, runnable2);
        }
    }

    public void scrollBy(int i, int i2) {
        this.c.e.getShowingPagesView().scrollBy(i, i2);
    }

    public boolean q() {
        return this.c.e.getShowingDocPresenter().q();
    }

    public Rect getViewableBounds() {
        return this.c.e.getShowingDocPresenter().getViewableBounds();
    }

    public bb b(int i, int i2) {
        return this.c.e.getShowingDocPresenter().b(i, i2);
    }

    public bb b(int i, int i2, int i3, int i4) {
        return this.c.e.getShowingDocPresenter().b(i, i2, i3, i4);
    }

    public bb r() {
        return this.c.e.getShowingDocPresenter().r();
    }

    public Pair b(Point point) {
        return this.c.e.getShowingDocPresenter().b(point);
    }

    public Pair a(Point point, int i) {
        return this.c.e.getShowingDocPresenter().a(point, i);
    }

    public Pair c(Point point) {
        return this.c.e.getShowingDocPresenter().c(point);
    }

    public int a(bb bbVar) {
        return this.c.e.getShowingDocPresenter().a(bbVar);
    }

    public ac a(int i) {
        return this.c.e.getShowingDocPresenter().a(i);
    }

    public boolean c(int i, int i2) {
        return this.c.e.getShowingDocPresenter().c(i, i2);
    }

    public boolean d(int i, int i2) {
        return this.c.e.getShowingDocPresenter().d(i, i2);
    }

    public Rect[] b(bb bbVar) {
        return this.c.e.getShowingDocPresenter().b(bbVar);
    }

    public Rect c(bb bbVar) {
        return this.c.e.getShowingDocPresenter().c(bbVar);
    }

    public ReaderFeature v() {
        return this.c.A();
    }

    public abq w() {
        if (this.c.M != null) {
            return this.c.M;
        }
        com.duokan.core.diagnostic.a.c().b();
        return new cx();
    }

    public void a(View view) {
        this.c.e.a(view);
    }

    public void a(er erVar) {
        if (this.c.J != null) {
            this.c.J.a(erVar);
        }
    }

    public er[] a(Class... clsArr) {
        return this.c.J != null ? this.c.J.a(clsArr) : new er[0];
    }

    public void a(Runnable runnable) {
        this.c.e.a(runnable);
    }

    public void b(Runnable runnable) {
        this.c.e.b(runnable);
    }

    public boolean x() {
        if (bb() || aE()) {
            return false;
        }
        return this.c.d.K();
    }

    public void c(boolean z) {
        this.c.d.f(z);
        this.c.d.Y();
    }

    public int y() {
        return (this.c.e.getWidth() - this.c.e.getPaddingLeft()) - this.c.e.getPaddingRight();
    }

    public int z() {
        return (this.c.e.getHeight() - this.c.e.getPaddingTop()) - this.c.e.getPaddingBottom();
    }

    public int A() {
        return this.c.h.k().f;
    }

    public double B() {
        return this.c.h.k().g;
    }

    public int C() {
        return Math.round(((((float) (this.c.h.k().f - this.c.d.d())) / ((float) (this.c.d.e() - this.c.d.d()))) * ((float) (this.c.d.c() - this.c.d.b()))) + ((float) this.c.d.b()));
    }

    public Rect[] a(ef efVar) {
        View[] pageViews = this.c.e.getShowingPagesView().getPageViews();
        LinkedList linkedList = new LinkedList();
        for (View view : pageViews) {
            View view2 = (gs) view2;
            Rect a = view2.a(efVar);
            if (!a.isEmpty()) {
                UTools.closeAnimation(a, view2, this.c.e.getShowingPagesView());
                linkedList.add(a);
            }
        }
        return (Rect[]) linkedList.toArray(new Rect[0]);
    }

    public float[] D() {
        return this.c.A().getScreenBrightnessRange();
    }

    public BrightnessMode E() {
        if (aH()) {
            return this.c.d.n();
        }
        return this.c.d.k();
    }

    public void a(BrightnessMode brightnessMode) {
        if (aH()) {
            this.c.d.b(brightnessMode);
        } else {
            this.c.d.a(brightnessMode);
        }
        this.c.d.Y();
        this.c.L();
    }

    public float F() {
        if (aH()) {
            return this.c.d.o();
        }
        return this.c.d.l();
    }

    public void a(float f) {
        if (aH()) {
            this.c.d.b(f);
        } else {
            this.c.d.a(f);
        }
        this.c.d.Y();
        this.c.L();
    }

    public boolean b(int i) {
        return this.c.g.a(i);
    }

    public boolean a(int i, int i2) {
        int a = this.c.g.a();
        boolean a2 = this.c.g.a(i, i2);
        if (a2) {
            this.c.a(a, this.c.g.a());
            this.c.b(a, this.c.g.a());
        }
        return a2;
    }

    public c G() {
        return this.c.f;
    }

    public BookType H() {
        return this.c.r;
    }

    public BookLimitType I() {
        return this.c.s;
    }

    public boolean J() {
        return this.c.p;
    }

    public boolean K() {
        return this.c.q;
    }

    public n getDocument() {
        return this.c.h;
    }

    public int L() {
        long e = this.c.h.e();
        if (!this.c.f.ai()) {
            return (int) e;
        }
        return (int) (e > 0 ? e + 1 : -1);
    }

    public DocPageLayout M() {
        switch (ri.d[this.c.e.getShowingPagesView().getPageLayout().ordinal()]) {
            case 1:
                return DocPageLayout.LEFT_TO_RIGHT;
            case 2:
                return DocPageLayout.RIGHT_TO_LEFT;
            case 3:
                return DocPageLayout.TOP_TO_BOTTOM;
            default:
                return DocPageLayout.LEFT_TO_RIGHT;
        }
    }

    public ReadingTheme N() {
        if (((ReaderFeature) this.c.getContext().queryFeature(ReaderFeature.class)).inNightMode()) {
            return ReadingTheme.NIGHT;
        }
        return this.c.d.q();
    }

    public void a(ReadingTheme readingTheme) {
        this.c.d.d(readingTheme);
        this.c.d.Y();
        f(false);
    }

    public int O() {
        return this.c.d.A();
    }

    public void c(int i) {
        this.c.c.aM();
        this.c.d.g(i);
        this.c.d.Y();
        if (N() == ReadingTheme.CUSTOM) {
            this.c.t();
            this.c.a(null, this.c.k());
            this.c.a(false);
            this.c.e.setStatusColor(R());
        }
        this.c.e.j();
    }

    public int P() {
        return this.c.d.D();
    }

    public void d(int i) {
        this.c.d.i(i);
        this.c.d.Y();
        if (N() == ReadingTheme.CUSTOM) {
            this.c.a(null, this.c.k());
            this.c.a(false);
            this.c.e.setStatusColor(R());
        }
        this.c.e.j();
    }

    public int Q() {
        switch (ri.c[this.c.o().N().ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return Color.argb(Math.round(178.5f), 0, 0, 0);
            case 6:
                return Color.argb(Math.round(178.5f), 255, 255, 255);
            case 7:
                return this.c.o().P();
            case 9:
                return Color.rgb(58, 49, 33);
            case 10:
                return Color.argb(Math.round(204.0f), 0, 0, 0);
            case 11:
                return Color.argb(Math.round(204.0f), 0, 0, 0);
            case 12:
                return Color.argb(Math.round(127.5f), 255, 255, 255);
            case 13:
                return Color.argb(Math.round(117.3f), 255, 255, 255);
            case 14:
                return Color.argb(Math.round(204.0f), 0, 0, 0);
            case 15:
                return Color.rgb(170, 170, 170);
            case 16:
                return Color.argb(255, Math.round(239.4737f), Math.round(236.8421f), Math.round(236.8421f));
            case 17:
                return Color.rgb(65, 84, 65);
            case 18:
                return Color.argb(Math.round(178.5f), 0, 0, 0);
            case 19:
                return Color.argb(Math.round(127.5f), 255, 255, 255);
            case 20:
                return Color.rgb(175, 198, 180);
            case 21:
                return Color.argb(255, 53, 69, 81);
            default:
                return Color.rgb(59, 53, 43);
        }
    }

    public int R() {
        int round = Math.round(76.5f);
        if (this.c.c.N() == ReadingTheme.NIGHT) {
            return Color.argb(Math.round(127.5f), 255, 255, 255);
        }
        if (this.c.c.N() == ReadingTheme.THEME12) {
            return Color.rgb(27, 33, 42);
        }
        if (this.c.c.aJ()) {
            return Color.argb(round, 255, 255, 255);
        }
        if (this.c.c.aI()) {
            return this.c.d.D();
        }
        return Color.argb(round, 0, 0, 0);
    }

    public int j_() {
        if (aI()) {
            return this.c.o().ae().D();
        }
        return 0;
    }

    public Drawable S() {
        if (this.c.t == null) {
            this.c.t();
        }
        return new rw(this.c);
    }

    public boolean T() {
        return this.c.h.l().k;
    }

    public void d(boolean z) {
        this.c.d.h(z);
        this.c.d.Y();
        this.c.a(null, this.c.k());
        aN();
        this.c.e.j();
    }

    public PageAnimationMode U() {
        if (this.c.c.g()) {
            return PageAnimationMode.NONE;
        }
        return this.c.d.M();
    }

    public void a(PageAnimationMode pageAnimationMode) {
        this.c.d.a(pageAnimationMode);
        this.c.d.Y();
    }

    public SlideShowEffect V() {
        return this.c.d.O();
    }

    public void a(SlideShowEffect slideShowEffect) {
        this.c.d.a(slideShowEffect);
        this.c.d.Y();
    }

    public LinkedList W() {
        return ((gs) X().d()).g();
    }

    public void b(boolean z) {
    }

    public gn X() {
        return (gn) this.c.e.getShowingPagesView().getCurrentPagePresenter();
    }

    public int Y() {
        return (int) this.c.h.b(Z());
    }

    public ak Z() {
        return this.c.y;
    }

    public as aa() {
        gn X = X();
        if (X == null) {
            return null;
        }
        gs gsVar = (gs) X.d();
        com.duokan.core.diagnostic.a.c().b(gsVar != null);
        if (gsVar == null) {
            return null;
        }
        return gsVar.getPageDrawable();
    }

    public gn e(int i) {
        gn X = X();
        View[] orderedPageViews = this.c.e.getShowingPagesView().getOrderedPageViews();
        int i2 = 0;
        while (i2 < orderedPageViews.length && ((gs) orderedPageViews[i2]).getPage() != X) {
            i2++;
        }
        int i3 = i2 + i;
        if (i3 < 0 || i3 >= orderedPageViews.length) {
            return null;
        }
        return ((gs) orderedPageViews[i3]).getPage();
    }

    public void b(ak akVar, boolean z, ag agVar) {
        if (this.c.q) {
            TaskHandler.postTask(new rz(this, agVar));
            return;
        }
        m a;
        if (z) {
            a = this.c.h.l().a();
            a.o = true;
        } else {
            a = this.c.h.l();
        }
        as a2 = this.c.h.a(akVar, a);
        a2.a(new sa(this, agVar, a2), new sb(this, agVar));
    }

    public void a(ak akVar, boolean z, ag agVar) {
        b(akVar, z, new sc(this, agVar));
    }

    public hh b() {
        return this.c.f.D().b();
    }

    public void a(RectF[] rectFArr) {
    }

    public void a(PageScaleType pageScaleType) {
    }

    public Rect ab() {
        Rect rect = new Rect(0, 0, 0, 0);
        Rect bo = bo();
        int i = bo.left;
        rect.right = i;
        rect.left = i;
        int headerPaddingTop = ((s) MyContextWrapper.getFeature(this.c.getContext()).queryFeature(s.class)).getTheme().getHeaderPaddingTop();
        int g = this.c.D();
        if (ao()) {
            rect.top = Math.round((((float) bo.top) * 0.6f) + (((float) g) * 0.5f));
        }
        if (ap()) {
            rect.bottom = Math.round((((float) bo.bottom) * 0.65f) + (((float) g) * 0.5f));
        }
        i = (ao() ? g : 0) + headerPaddingTop;
        if (!ap()) {
            g = 0;
        }
        rect.top = Math.max(i, rect.top);
        rect.bottom = Math.max(g, rect.bottom);
        return rect;
    }

    public Rect ac() {
        Rect rect = new Rect(0, 0, 0, 0);
        Rect ab = ab();
        Rect bo = bo();
        int i = bo.left;
        rect.right = i;
        rect.left = i;
        rect.top = Math.max(bo.top - ab.top, 0);
        rect.bottom = Math.max(bo.bottom - ab.bottom, 0);
        return rect;
    }

    private Rect bo() {
        Rect rect = new Rect(0, 0, 0, 0);
        int w;
        if (this.c.d.j() == TypesettingStyle.CUSTOM) {
            w = this.c.d.w();
            rect.right = w;
            rect.left = w;
            rect.top = this.c.d.y();
            rect.bottom = this.c.d.z();
        } else {
            switch (ri.a[ReaderUi.l(this.c.getContext()).ordinal()]) {
                case 1:
                    rect.top = UTools.g(this.c.getContext(), 110.0f);
                    rect.bottom = UTools.g(this.c.getContext(), 74.0f);
                    w = UTools.f(this.c.getContext(), 54.0f);
                    rect.right = w;
                    rect.left = w;
                    break;
                case 2:
                    rect.top = UTools.g(this.c.getContext(), 100.0f);
                    rect.bottom = UTools.g(this.c.getContext(), 70.0f);
                    w = UTools.f(this.c.getContext(), 44.0f);
                    rect.right = w;
                    rect.left = w;
                    break;
                case 3:
                    rect.top = UTools.g(this.c.getContext(), 46.0f);
                    rect.bottom = UTools.g(this.c.getContext(), 36.0f);
                    w = UTools.f(this.c.getContext(), 20.0f);
                    rect.right = w;
                    rect.left = w;
                    break;
                case 5:
                    rect.top = UTools.g(this.c.getContext(), 66.0f);
                    rect.bottom = UTools.g(this.c.getContext(), 42.0f);
                    w = UTools.f(this.c.getContext(), 30.0f);
                    rect.right = w;
                    rect.left = w;
                    break;
                default:
                    rect.top = UTools.g(this.c.getContext(), 60.0f);
                    rect.bottom = UTools.g(this.c.getContext(), 38.0f);
                    w = UTools.f(this.c.getContext(), 24.0f);
                    rect.right = w;
                    rect.left = w;
                    break;
            }
            if (this.c.d.j() == TypesettingStyle.TIGHT) {
                rect.top = Math.round(((float) rect.top) * 0.6f);
                rect.bottom = Math.round(((float) rect.bottom) * 0.6f);
                rect.left = Math.round(((float) rect.left) * 0.7f);
                rect.right = Math.round(((float) rect.right) * 0.7f);
            }
            w = this.c.D();
            if (!ap()) {
                rect.bottom = Math.max(rect.bottom - w, 0);
            }
            if (!ao()) {
                rect.top = Math.max(rect.top - w, 0);
            }
        }
        if (bf()) {
            rect.bottom = Math.max(rect.bottom, UTools.closeAnimation(this.c.getContext(), 30.0f));
        }
        return rect;
    }

    public Rect ad() {
        int[] iArr = new int[2];
        this.c.e.getLocationOnScreen(iArr);
        return new Rect(iArr[0], iArr[1], iArr[0] + this.c.e.getPageWidth(), iArr[1] + this.c.e.getPageHeight());
    }

    public ReadingPrefs ae() {
        return this.c.d;
    }

    public void a(tb tbVar) {
        if (!b && tbVar == null) {
            throw new AssertionError();
        } else if (!this.c.j.contains(tbVar)) {
            this.c.j.add(tbVar);
        }
    }

    public void b(tb tbVar) {
        if (b || tbVar != null) {
            this.c.j.remove(tbVar);
            return;
        }
        throw new AssertionError();
    }

    public void af() {
        LinkedList W = this.c.c.W();
        if (W.size() > 0) {
            this.c.c.G().a(Lists.newArrayList(W.toArray(new ah[0])), true);
        } else {
            this.c.c.G().a(this.c.I());
            ((p) this.c.getContext().queryFeature(p.class)).a(this.c.getContext(), UserInput.DO_BOOK_MARK);
        }
        this.c.c.aN();
    }

    public boolean ag() {
        return this.c.D;
    }

    public void e(boolean z) {
        this.c.D = z;
    }

    public boolean ah() {
        if (this.c.f.k() && !this.c.f.aj() && this.c.f.a(true) && i.f().a(PersonalAccount.class)) {
            return true;
        }
        return false;
    }

    public DkCloudRedeemBenefit ai() {
        if (this.c.f.k()) {
            return null;
        }
        return DkUserPurchasedBooksManager.a().c(this.c.f.H());
    }

    public View a(Context context) {
        return null;
    }

    public boolean aj() {
        return ReaderUi.m(this.c.getContext()) || this.c.f.k() || this.c.f.l() || !this.c.f.ai();
    }

    public boolean h_() {
        return ReaderUi.m(this.c.getContext());
    }

    public boolean ak() {
        return false;
    }

    public boolean al() {
        return this.c.e.getShowingPagesView().getPageLayout() == PageLayout.RIGHT_TO_LEFT;
    }

    public boolean o() {
        return this.c.e.e();
    }

    public boolean g() {
        return false;
    }

    public boolean h() {
        return false;
    }

    public boolean am() {
        return this.c.e.d();
    }

    public boolean an() {
        if (this.c.f.l()) {
            return false;
        }
        return this.c.d.G();
    }

    public boolean ao() {
        if (this.c.f.l()) {
            return false;
        }
        return this.c.d.I();
    }

    public boolean ap() {
        if (this.c.f.l()) {
            return false;
        }
        return this.c.d.J();
    }

    public boolean k_() {
        int i = this.c.d.i();
        int a = this.c.d.a(i);
        if (a <= i) {
            return false;
        }
        this.c.d.c(a);
        ReaderEnv.get().commitPrefs();
        this.c.a(this.c.f(), null);
        aN();
        return true;
    }

    public boolean l() {
        int i = this.c.d.i();
        int b = this.c.d.b(i);
        if (b >= i) {
            return false;
        }
        this.c.d.c(b);
        ReaderEnv.get().commitPrefs();
        this.c.a(this.c.f(), null);
        aN();
        return true;
    }

    public boolean m() {
        int i = this.c.d.i();
        if (this.c.d.a(i) <= i) {
            return true;
        }
        return false;
    }

    public boolean n() {
        int i = this.c.d.i();
        if (this.c.d.b(i) >= i) {
            return true;
        }
        return false;
    }

    public boolean aq() {
        return (!this.c.p || this.c.B == null || this.c.B == Z()) ? false : true;
    }

    public boolean ar() {
        return (!this.c.p || this.c.C == null || this.c.C == Z()) ? false : true;
    }

    public void as() {
        this.c.B = Z();
        this.c.C = null;
    }

    public int b(Document_a aVar) {
        if (L() < 1) {
            return 0;
        }
        long b;
        if (aVar instanceof ak) {
            b = this.c.h.b((ak) aVar);
        } else if (aVar instanceof av) {
            b = this.c.h.a((av) aVar);
        } else if (aVar instanceof ay) {
            b = this.c.h.a(((ay) aVar).g());
        } else {
            b = 0;
        }
        return ((int) b) + 1;
    }

    public void at() {
        if (ar()) {
            ak Z = Z();
            c(this.c.C);
            this.c.B = Z;
            this.c.C = null;
        }
    }

    public void au() {
        if (aq()) {
            ak Z = Z();
            c(this.c.B);
            this.c.C = Z;
            this.c.B = null;
        }
    }

    public void f(long j) {
        c(this.c.h.a(j));
    }

    public void a(av avVar) {
        if (this.c.p) {
            this.c.e.getShowingDocPresenter().a((Document_a) avVar);
        } else {
            this.c.v = avVar;
        }
    }

    public void c(ak akVar) {
        if (this.c.p) {
            this.c.e.getShowingDocPresenter().a((Document_a) akVar);
        } else {
            this.c.v = akVar;
        }
    }

    public void a(Document_a aVar) {
        if (aVar instanceof ak) {
            c((ak) aVar);
        } else if (aVar instanceof av) {
            a((av) aVar);
        }
    }

    public void a(g gVar) {
        c(this.c.a(gVar));
    }

    public void av() {
        BookType o = this.c.f.o();
        if (this.c.f.ai() && (o == BookType.TRIAL || o == BookType.NORMAL || o == BookType.SERIAL)) {
            c(getDocument().f(getDocument().r()));
        } else {
            c(getDocument().r());
        }
    }

    public boolean aw() {
        return d(this.c.c.Z());
    }

    public boolean ax() {
        return e(this.c.c.Z());
    }

    public boolean d(ak akVar) {
        return this.c.h.h(akVar);
    }

    public boolean e(ak akVar) {
        return this.c.h.i(akVar);
    }

    public boolean b(ak akVar) {
        if (akVar.f()) {
            return false;
        }
        return true;
    }

    public boolean b(as asVar) {
        boolean z = true;
        if (this.c.h.b() || !b(asVar.l())) {
            return false;
        }
        boolean z2;
        if (asVar instanceof com.duokan.reader.domain.document.i) {
            z2 = (((ba) ((com.duokan.reader.domain.document.i) asVar).b()).a() || ((ba) ((com.duokan.reader.domain.document.i) asVar).c()).a()) ? false : true;
        } else {
            if (((ba) asVar).a()) {
                z = false;
            }
            z2 = z;
        }
        return z2;
    }

    public gs e(int i, int i2) {
        return (gs) this.c.e.getShowingPagesView().a(i, i2);
    }

    public gs[] ay() {
        Rect viewableBounds = getViewableBounds();
        View[] a = this.c.e.getShowingPagesView().a(viewableBounds.left, viewableBounds.top, viewableBounds.right, viewableBounds.bottom);
        gs[] gsVarArr = new gs[a.length];
        for (int i = 0; i < gsVarArr.length; i++) {
            gsVarArr[i] = (gs) a[i];
        }
        return gsVarArr;
    }

    public void a(gs[] gsVarArr) {
        Arrays.sort(gsVarArr, new sd(this));
    }

    public void az() {
        if (this.c.J != null) {
            this.c.J.n();
        }
    }

    public void aA() {
        aM();
        ReaderEnv.get().commitPrefs();
        this.c.K();
        this.c.N();
        this.c.w();
        this.c.a(this.c.f(), this.c.k());
        this.c.z();
        aN();
        this.c.e.j();
    }

    public void aB() {
        this.c.a(this.c.f(), null);
        aN();
    }

    public void f(boolean z) {
        this.c.c.aM();
        this.c.A().switchNightMode(z, true);
        this.c.t();
        this.c.a(null, this.c.k());
        this.c.e.setStatusColor(R());
        aN();
        this.c.e.j();
        if (z) {
            this.c.L();
        } else {
            j.a(new se(this));
        }
    }

    public void g(boolean z) {
        this.c.d.a(z);
        this.c.d.Y();
        this.c.A().switchEyesSavingMode(this.c.c.aK());
        if (this.c.J != null) {
            this.c.J.a(z);
        }
    }

    public void aC() {
        if (this.c.L != null) {
            this.c.L.a();
        }
    }

    public void aD() {
        if (this.c.L != null) {
            this.c.L.b();
        }
    }

    public boolean aE() {
        return this.c.L != null ? this.c.L.d() : false;
    }

    public void aF() {
        if (this.c.L != null) {
            this.c.L.e();
        }
    }

    public void aG() {
        if (this.c.L != null) {
            this.c.L.f();
        }
    }

    public void f(int i) {
        if (this.c.L != null) {
            this.c.L.a(i);
        }
    }

    public void h(boolean z) {
        this.c.d.g(z);
        this.c.d.Y();
    }

    public boolean aH() {
        return N() == ReadingTheme.NIGHT;
    }

    public boolean aI() {
        return N() == ReadingTheme.CUSTOM;
    }

    public boolean aJ() {
        switch (ri.c[N().ordinal()]) {
            case 6:
            case 12:
            case 13:
            case 15:
            case 16:
            case 19:
            case 20:
            case 21:
                return true;
            default:
                return false;
        }
    }

    public boolean aK() {
        return this.c.d.p();
    }

    public boolean aL() {
        return this.c.d.L();
    }

    public void aM() {
        this.c.e.f();
    }

    public void aN() {
        this.c.a(true);
    }

    public void i(boolean z) {
        this.c.a(z);
    }

    public void a(boolean z) {
        if (z) {
            this.c.e.f();
        }
        this.c.e.i();
    }

    public void j(boolean z) {
        this.c.a = new sf(this, z);
        j.a(this.c.a);
    }

    public Rect a(Rect rect) {
        Rect ad = ad();
        return new Rect(Math.round((float) (ad.left + rect.left)), Math.round((float) (ad.top + rect.top)), Math.round((float) (ad.left + rect.right)), Math.round((float) (ad.top + rect.bottom)));
    }

    public void a(String str) {
        this.c.c.a(1, 0);
        b(str);
    }

    public void aO() {
        if (this.c.J != null) {
            this.c.J.a("");
        }
    }

    public void b(String str) {
        if (this.c.J != null) {
            this.c.J.a(str);
        }
    }

    public void aP() {
        if (this.c.J != null) {
            this.c.J.i();
        }
    }

    public void aQ() {
        if (this.c.J != null) {
            this.c.J.h();
        }
    }

    public void aR() {
        if (this.c.J != null) {
            this.c.J.g();
        }
    }

    public boolean d() {
        return true;
    }

    public boolean f() {
        return true;
    }

    public void onItemChanged(an anVar, int i) {
    }

    public void a(n nVar, as asVar) {
    }

    public void b(n nVar, as asVar) {
    }

    public void aS() {
        b.b().g();
    }

    public void b(ef efVar) {
        boolean z = U() != PageAnimationMode.VSCROLL && Z().b() && Z().g().equals(efVar.d());
        a[] aq = G().aq();
        Arrays.sort(aq, new sg(this));
        String m = efVar.m();
        ay a = getDocument().a((d) efVar.d(), (d) efVar.e());
        List linkedList = new LinkedList();
        int length = aq.length;
        int i = 0;
        while (i < length) {
            ay ayVar;
            String str;
            a aVar = aq[i];
            if (aVar instanceof ah) {
                ayVar = a;
                str = m;
            } else {
                bb a2 = getDocument().a((d) aVar.d(), (d) aVar.e());
                if (a2.b(a) || (z && a2.h().equals(a.g()))) {
                    ay a3 = a2.a(a);
                    String str2 = a2.g().b(a3.g()) ? ((ef) aVar).m() + m : m + ((ef) aVar).m();
                    linkedList.add(aVar);
                    ay ayVar2 = a3;
                    str = str2;
                    ayVar = ayVar2;
                } else {
                    ayVar = a;
                    str = m;
                }
            }
            i++;
            a = ayVar;
            m = str;
        }
        G().a(linkedList, false);
        efVar.a(a.g());
        efVar.b(a.h());
        efVar.a(getDocument().a((bb) a));
        efVar.e(m);
        G().a((a) efVar);
    }

    public void a(ay ayVar, boolean z) {
    }

    public void i() {
    }

    public boolean aT() {
        return this.c.d.Q();
    }

    public void k(boolean z) {
        this.c.d.i(z);
        this.c.d.Y();
    }

    public void aU() {
        this.g++;
    }

    public void aV() {
        this.g--;
    }

    public boolean aW() {
        return this.g > 0;
    }

    public void aX() {
        if (this.c.K != null) {
            this.c.K.a();
        }
    }

    public void aY() {
        if (this.c.K != null) {
            this.c.K.b();
        }
    }

    public void aZ() {
        if (this.c.K != null) {
            this.c.K.c();
        }
    }

    public void ba() {
        if (this.c.K != null) {
            this.c.K.d();
        }
    }

    public boolean bb() {
        return this.c.K != null ? this.c.K.e() : false;
    }

    public float bc() {
        return this.c.d.R();
    }

    public void b(float f) {
        if (this.c.K != null) {
            this.c.K.a(f);
        }
    }

    public void g(int i) {
        if (this.c.K != null) {
            this.c.K.a(i);
        }
    }

    public int bd() {
        return this.c.K != null ? this.c.K.g() : 0;
    }

    public String be() {
        return this.c.K != null ? this.c.d.S() : "";
    }

    public void c(String str) {
        if (this.c.K != null) {
            this.c.K.a(str);
        }
    }

    public void c(Runnable runnable) {
        if (this.c.K != null) {
            this.c.K.a(runnable);
        }
    }

    public bb k() {
        return null;
    }

    public boolean j() {
        return false;
    }

    public void a(au auVar, Rect rect) {
        if (this.c.J != null) {
            this.c.J.a(auVar, rect);
        }
    }

    public boolean bf() {
        return false;
    }

    public g bg() {
        if (this.e == null) {
            this.e = new g(this.c.getContext(), this.c.c);
            this.e.setCallback(this.c.P);
        }
        return this.e;
    }

    public void a(Canvas canvas, int i, int i2, int i3, int i4, int i5) {
        g bg = bg();
        Rect rect = (Rect) UTools.g.getRect();
        rect.set(i - (bg.getIntrinsicWidth() / 2), i2 - (bg.getIntrinsicHeight() / 2), (bg.getIntrinsicWidth() / 2) + i, (bg.getIntrinsicHeight() / 2) + i2);
        bg.setBounds(rect);
        bg.a(rect.left, i3, rect.right, i4);
        bg.a(i5);
        bg.draw(canvas);
        UTools.g.getRect(rect);
    }

    public boolean bh() {
        return this.c.J != null ? this.c.J.e() : false;
    }

    public void bi() {
        ((ReaderFeature) this.c.getContext().queryFeature(ReaderFeature.class)).shareBooks(this.c, G());
    }

    public void c(float f) {
        this.c.e.setStatusOpacity(f);
    }

    public Rect bj() {
        if (this.a != null && this.d == am()) {
            return this.a;
        }
        DisplayMetrics displayMetrics = this.c.getResources().getDisplayMetrics();
        this.d = am();
        int i = displayMetrics.widthPixels / 4;
        int i2 = displayMetrics.heightPixels / 4;
        this.a = new Rect(i, i2, i, i2);
        return this.a;
    }

    public void a(String str, int i) {
        ((ReaderFeature) this.c.getContext().queryFeature(ReaderFeature.class)).pushPageSmoothly(bv.a(this.c.getContext(), "0", i, str, null), null);
    }

    public a bk() {
        return this.c.b;
    }

    public DkStoreItemDetail bl() {
        if (this.c.f.k()) {
            return this.c.H;
        }
        return this.c.G;
    }

    public boolean bm() {
        return this.c.P();
    }

    public boolean bn() {
        return this.c.Q();
    }
}
