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
import com.duokan.core.app.AppContext;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.sys.UIdleHandler;
import com.duokan.core.sys.UThread;
import com.duokan.core.sys.ag;
import com.duokan.core.ui.AnimUtils;
import com.duokan.core.ui.er;
import com.duokan.p024c.C0258j;
import com.duokan.reader.DkPublic;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.UmengManager;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.bookshelf.BookLimitType;
import com.duokan.reader.domain.bookshelf.BookType;
import com.duokan.reader.domain.bookshelf.C0798a;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ah;
import com.duokan.reader.domain.bookshelf.an;
import com.duokan.reader.domain.bookshelf.ea;
import com.duokan.reader.domain.bookshelf.hb;
import com.duokan.reader.domain.bookshelf.ip;
import com.duokan.reader.domain.cloud.DkCloudRedeemBenefit;
import com.duokan.reader.domain.cloud.DkUserPurchasedBooksManager;
import com.duokan.reader.domain.document.C0896a;
import com.duokan.reader.domain.document.C0897d;
import com.duokan.reader.domain.document.C0901g;
import com.duokan.reader.domain.document.C0903n;
import com.duokan.reader.domain.document.C0923m;
import com.duokan.reader.domain.document.C0941i;
import com.duokan.reader.domain.document.ac;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.at;
import com.duokan.reader.domain.document.au;
import com.duokan.reader.domain.document.av;
import com.duokan.reader.domain.document.ay;
import com.duokan.reader.domain.document.ba;
import com.duokan.reader.domain.document.bb;
import com.duokan.reader.domain.p044b.C0781b;
import com.duokan.reader.domain.store.DkStoreItemDetail;
import com.duokan.reader.domain.tts.TtsManager;
import com.duokan.reader.ui.C0435s;
import com.duokan.reader.ui.C0457r;
import com.duokan.reader.ui.bookshelf.kb;
import com.duokan.reader.ui.general.FixedPagesView.PageScaleType;
import com.duokan.reader.ui.general.PagesView.PageLayout;
import com.duokan.reader.ui.general.ReaderUi;
import com.duokan.reader.ui.general.ap;
import com.duokan.reader.ui.general.web.TtsWebController;
import com.duokan.reader.ui.store.bv;
import com.duokan.reader.ui.welcome.C1540p;
import com.duokan.reader.ui.welcome.DkTipManager.UserInput;
import com.google.android.collect.Lists;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class si implements ip, at, su {
    /* renamed from: b */
    static final /* synthetic */ boolean f9356b = (!qr.class.desiredAssertionStatus());
    /* renamed from: a */
    private Rect f9357a;
    /* renamed from: c */
    final /* synthetic */ qr f9358c;
    /* renamed from: d */
    private boolean f9359d = false;
    /* renamed from: e */
    private C1455g f9360e;
    /* renamed from: f */
    private final C0457r f9361f = new sj(this);
    /* renamed from: g */
    private int f9362g = 0;

    protected si(qr qrVar) {
        this.f9358c = qrVar;
    }

    /* renamed from: p */
    public void mo2168p() {
        mo2180v().showMenuFromTop(new kb(this.f9358c.getContext()));
    }

    public C0457r getTheme() {
        return this.f9361f;
    }

    public bb getSelection() {
        return this.f9358c.f9281e.getShowingDocPresenter().getSelection();
    }

    public Rect getSelectionStartIndicatorBounds() {
        return this.f9358c.f9281e.getShowingDocPresenter().getSelectionStartIndicatorBounds();
    }

    public Rect getSelectionEndIndicatorBounds() {
        return this.f9358c.f9281e.getShowingDocPresenter().getSelectionEndIndicatorBounds();
    }

    public void setSelection(bb bbVar) {
        this.f9358c.f9281e.getShowingDocPresenter().setSelection(bbVar);
    }

    public void setAnnotations(C0798a[] c0798aArr) {
        this.f9358c.f9281e.getShowingDocPresenter().setAnnotations(c0798aArr);
    }

    public C0798a[] getAnnotations() {
        return this.f9358c.f9281e.getShowingDocPresenter().getAnnotations();
    }

    /* renamed from: a */
    public void mo2028a(C0903n c0903n, C0896a c0896a) {
    }

    /* renamed from: a */
    public Drawable mo2012a(DecorDrawableStyle decorDrawableStyle) {
        return this.f9358c.f9281e.getShowingDocPresenter().mo2012a(decorDrawableStyle);
    }

    public Drawable getSelectionDrawable() {
        return this.f9358c.f9281e.getShowingDocPresenter().getSelectionDrawable();
    }

    public void setSelectionDrawable(Drawable drawable) {
        this.f9358c.f9281e.getShowingDocPresenter().setSelectionDrawable(drawable);
    }

    public void setShowSelectionIndicators(boolean z) {
        this.f9358c.f9281e.getShowingDocPresenter().setShowSelectionIndicators(z);
    }

    /* renamed from: s */
    public boolean mo2171s() {
        return this.f9358c.f9281e.getShowingDocPresenter().mo2171s();
    }

    /* renamed from: d */
    public void mo2131d(bb bbVar) {
        if (!aW()) {
            this.f9358c.f9281e.getShowingDocPresenter().mo2131d(bbVar);
        }
    }

    /* renamed from: a */
    public void mo2026a(bb bbVar, DecorDrawableStyle decorDrawableStyle) {
        this.f9358c.f9281e.getShowingDocPresenter().mo2026a(bbVar, decorDrawableStyle);
    }

    /* renamed from: b */
    public void mo2101b(bb bbVar, DecorDrawableStyle decorDrawableStyle) {
        this.f9358c.f9281e.getShowingDocPresenter().mo2101b(bbVar, decorDrawableStyle);
    }

    public Map<Drawable, List<bb>> getHighlights() {
        return this.f9358c.f9281e.getShowingDocPresenter().getHighlights();
    }

    public void setActiveColorText(bb bbVar) {
        this.f9358c.f9281e.getShowingDocPresenter().setActiveColorText(bbVar);
    }

    public bb getActiveText() {
        return this.f9358c.f9281e.getShowingDocPresenter().getActiveText();
    }

    /* renamed from: t */
    public void mo2178t() {
        this.f9358c.f9281e.getShowingPagesView().m10020h();
    }

    /* renamed from: a */
    public void mo2035a(Runnable runnable, Runnable runnable2) {
        mo2018a(null, runnable, runnable2);
    }

    /* renamed from: a */
    public void mo2018a(PointF pointF, Runnable runnable, Runnable runnable2) {
        if (this.f9358c.f9270J != null && !this.f9358c.f9270J.mo2373b(pointF, runnable, runnable2)) {
            this.f9358c.f9281e.getShowingPagesView().m9999a(runnable, runnable2);
        }
    }

    /* renamed from: u */
    public void mo2179u() {
        this.f9358c.f9281e.getShowingPagesView().m10021i();
    }

    /* renamed from: b */
    public void mo2104b(Runnable runnable, Runnable runnable2) {
        mo2099b(null, runnable, runnable2);
    }

    /* renamed from: b */
    public void mo2099b(PointF pointF, Runnable runnable, Runnable runnable2) {
        if (this.f9358c.f9270J != null && !this.f9358c.f9270J.mo2371a(pointF, runnable, runnable2)) {
            this.f9358c.f9281e.getShowingPagesView().m10008b(runnable, runnable2);
        }
    }

    public void scrollBy(int i, int i2) {
        this.f9358c.f9281e.getShowingPagesView().scrollBy(i, i2);
    }

    /* renamed from: q */
    public boolean mo2169q() {
        return this.f9358c.f9281e.getShowingDocPresenter().mo2169q();
    }

    public Rect getViewableBounds() {
        return this.f9358c.f9281e.getShowingDocPresenter().getViewableBounds();
    }

    /* renamed from: b */
    public bb mo2096b(int i, int i2) {
        return this.f9358c.f9281e.getShowingDocPresenter().mo2096b(i, i2);
    }

    /* renamed from: b */
    public bb mo2097b(int i, int i2, int i3, int i4) {
        return this.f9358c.f9281e.getShowingDocPresenter().mo2097b(i, i2, i3, i4);
    }

    /* renamed from: r */
    public bb mo2170r() {
        return this.f9358c.f9281e.getShowingDocPresenter().mo2170r();
    }

    /* renamed from: b */
    public Pair<gx, Integer> mo2094b(Point point) {
        return this.f9358c.f9281e.getShowingDocPresenter().mo2094b(point);
    }

    /* renamed from: a */
    public Pair<gx, Integer> mo2013a(Point point, int i) {
        return this.f9358c.f9281e.getShowingDocPresenter().mo2013a(point, i);
    }

    /* renamed from: c */
    public Pair<gx, Integer> mo2125c(Point point) {
        return this.f9358c.f9281e.getShowingDocPresenter().mo2125c(point);
    }

    /* renamed from: a */
    public int mo2010a(bb bbVar) {
        return this.f9358c.f9281e.getShowingDocPresenter().mo2010a(bbVar);
    }

    /* renamed from: a */
    public ac mo2015a(int i) {
        return this.f9358c.f9281e.getShowingDocPresenter().mo2015a(i);
    }

    /* renamed from: c */
    public boolean mo2129c(int i, int i2) {
        return this.f9358c.f9281e.getShowingDocPresenter().mo2129c(i, i2);
    }

    /* renamed from: d */
    public boolean mo2134d(int i, int i2) {
        return this.f9358c.f9281e.getShowingDocPresenter().mo2134d(i, i2);
    }

    /* renamed from: b */
    public Rect[] mo2107b(bb bbVar) {
        return this.f9358c.f9281e.getShowingDocPresenter().mo2107b(bbVar);
    }

    /* renamed from: c */
    public Rect mo2124c(bb bbVar) {
        return this.f9358c.f9281e.getShowingDocPresenter().mo2124c(bbVar);
    }

    /* renamed from: v */
    public ReaderFeature mo2180v() {
        return this.f9358c.m12817A();
    }

    /* renamed from: w */
    public acd mo2181w() {
        if (this.f9358c.f9273M != null) {
            return this.f9358c.f9273M;
        }
        WebLog.init().defaultW();
        return new cz();
    }

    /* renamed from: a */
    public void mo2019a(View view) {
        this.f9358c.f9281e.m13648a(view);
    }

    /* renamed from: a */
    public void mo2021a(er erVar) {
        if (this.f9358c.f9270J != null) {
            this.f9358c.f9270J.mo2364a(erVar);
        }
    }

    /* renamed from: a */
    public er[] mo2042a(Class<?>... clsArr) {
        return this.f9358c.f9270J != null ? this.f9358c.f9270J.mo2372a((Class[]) clsArr) : new er[0];
    }

    /* renamed from: a */
    public void mo2034a(Runnable runnable) {
        this.f9358c.f9281e.m13650a(runnable);
    }

    /* renamed from: b */
    public void mo2103b(Runnable runnable) {
        this.f9358c.f9281e.m13653b(runnable);
    }

    /* renamed from: x */
    public boolean mo2182x() {
        if (bb() || aE()) {
            return false;
        }
        return this.f9358c.f9280d.m12450K();
    }

    /* renamed from: c */
    public void mo2128c(boolean z) {
        this.f9358c.f9280d.m12502f(z);
        this.f9358c.f9280d.m12463X();
    }

    /* renamed from: y */
    public int mo2183y() {
        return (this.f9358c.f9281e.getWidth() - this.f9358c.f9281e.getPaddingLeft()) - this.f9358c.f9281e.getPaddingRight();
    }

    /* renamed from: z */
    public int mo2184z() {
        return (this.f9358c.f9281e.getHeight() - this.f9358c.f9281e.getPaddingTop()) - this.f9358c.f9281e.getPaddingBottom();
    }

    /* renamed from: A */
    public int mo1986A() {
        return this.f9358c.f9284h.mo1245k().f4335f;
    }

    /* renamed from: B */
    public double mo1987B() {
        return this.f9358c.f9284h.mo1245k().f4336g;
    }

    /* renamed from: C */
    public int mo1988C() {
        return Math.round(((((float) (this.f9358c.f9284h.mo1245k().f4335f - this.f9358c.f9280d.m12489d())) / ((float) (this.f9358c.f9280d.m12495e() - this.f9358c.f9280d.m12489d()))) * ((float) (this.f9358c.f9280d.m12483c() - this.f9358c.f9280d.m12476b()))) + ((float) this.f9358c.f9280d.m12476b()));
    }

    /* renamed from: a */
    public Rect[] mo2041a(ea eaVar) {
        View[] pageViews = this.f9358c.f9281e.getShowingPagesView().getPageViews();
        LinkedList linkedList = new LinkedList();
        for (View view : pageViews) {
            View view2 = (gx) view2;
            Rect a = view2.m14287a(eaVar);
            if (!a.isEmpty()) {
                AnimUtils.m1937b(a, view2, this.f9358c.f9281e.getShowingPagesView());
                linkedList.add(a);
            }
        }
        return (Rect[]) linkedList.toArray(new Rect[0]);
    }

    /* renamed from: D */
    public float[] mo1989D() {
        return this.f9358c.m12817A().getScreenBrightnessRange();
    }

    /* renamed from: E */
    public BrightnessMode mo1990E() {
        if (aH()) {
            return this.f9358c.f9280d.m12520n();
        }
        return this.f9358c.f9280d.m12516k();
    }

    /* renamed from: a */
    public void mo2020a(BrightnessMode brightnessMode) {
        if (aH()) {
            this.f9358c.f9280d.m12480b(brightnessMode);
        } else {
            this.f9358c.f9280d.m12467a(brightnessMode);
        }
        this.f9358c.f9280d.m12463X();
        this.f9358c.m12779L();
    }

    /* renamed from: F */
    public float mo1991F() {
        if (aH()) {
            return this.f9358c.f9280d.m12521o();
        }
        return this.f9358c.f9280d.m12518l();
    }

    /* renamed from: a */
    public void mo2016a(float f) {
        if (aH()) {
            this.f9358c.f9280d.m12479b(f);
        } else {
            this.f9358c.f9280d.m12466a(f);
        }
        this.f9358c.f9280d.m12463X();
        this.f9358c.m12779L();
    }

    /* renamed from: b */
    public boolean mo2106b(int i) {
        return this.f9358c.f9283g.m15022a(i);
    }

    /* renamed from: a */
    public boolean mo2040a(int i, int i2) {
        int a = this.f9358c.f9283g.m15021a();
        boolean a2 = this.f9358c.f9283g.m15023a(i, i2);
        if (a2) {
            this.f9358c.m12821a(a, this.f9358c.f9283g.m15021a());
            this.f9358c.m12799b(a, this.f9358c.f9283g.m15021a());
        }
        return a2;
    }

    /* renamed from: G */
    public C0800c mo1992G() {
        return this.f9358c.f9282f;
    }

    /* renamed from: H */
    public BookType m13037H() {
        return this.f9358c.f9294r;
    }

    /* renamed from: I */
    public BookLimitType m13038I() {
        return this.f9358c.f9295s;
    }

    /* renamed from: J */
    public boolean mo1993J() {
        return this.f9358c.f9292p;
    }

    /* renamed from: K */
    public boolean mo1994K() {
        return this.f9358c.f9293q;
    }

    public C0903n getDocument() {
        return this.f9358c.f9284h;
    }

    /* renamed from: L */
    public int mo1995L() {
        long e = this.f9358c.f9284h.mo1234e();
        if (!this.f9358c.f9282f.ak()) {
            return (int) e;
        }
        return (int) (e > 0 ? e + 1 : -1);
    }

    /* renamed from: M */
    public DocPageLayout mo1996M() {
        switch (rt.f10916d[this.f9358c.f9281e.getShowingPagesView().getPageLayout().ordinal()]) {
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

    /* renamed from: N */
    public ReadingTheme mo1997N() {
        if (this.f9358c.m12817A().inNightMode()) {
            return ReadingTheme.NIGHT;
        }
        return this.f9358c.f9280d.m12523q();
    }

    /* renamed from: a */
    public void mo2031a(ReadingTheme readingTheme) {
        this.f9358c.f9280d.m12492d(readingTheme);
        this.f9358c.f9280d.m12463X();
        mo2142f(false);
    }

    /* renamed from: O */
    public int mo1998O() {
        return this.f9358c.f9280d.m12440A();
    }

    /* renamed from: c */
    public void mo2127c(int i) {
        this.f9358c.f9279c.aM();
        this.f9358c.f9280d.m12505g(i);
        this.f9358c.f9280d.m12463X();
        if (mo1997N() == ReadingTheme.CUSTOM) {
            this.f9358c.m12855t();
            this.f9358c.m12825a(null, this.f9358c.mo2239k());
            this.f9358c.m12832a(false);
            this.f9358c.f9281e.setStatusColor(mo2001R());
        }
        this.f9358c.f9281e.m13660j();
    }

    /* renamed from: P */
    public int mo1999P() {
        return this.f9358c.f9280d.m12443D();
    }

    /* renamed from: d */
    public void mo2130d(int i) {
        this.f9358c.f9280d.m12512i(i);
        this.f9358c.f9280d.m12463X();
        if (mo1997N() == ReadingTheme.CUSTOM) {
            this.f9358c.m12825a(null, this.f9358c.mo2239k());
            this.f9358c.m12832a(false);
            this.f9358c.f9281e.setStatusColor(mo2001R());
        }
        this.f9358c.f9281e.m13660j();
    }

    /* renamed from: Q */
    public int mo2000Q() {
        switch (rt.f10915c[this.f9358c.m12850o().mo1997N().ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return Color.argb(Math.round(178.5f), 0, 0, 0);
            case 6:
                return Color.argb(Math.round(178.5f), 255, 255, 255);
            case 7:
                return this.f9358c.m12850o().mo1999P();
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

    /* renamed from: R */
    public int mo2001R() {
        int round = Math.round(76.5f);
        if (this.f9358c.f9279c.mo1997N() == ReadingTheme.NIGHT) {
            return Color.argb(Math.round(127.5f), 255, 255, 255);
        }
        if (this.f9358c.f9279c.mo1997N() == ReadingTheme.THEME12) {
            return Color.rgb(27, 33, 42);
        }
        if (this.f9358c.f9279c.aJ()) {
            return Color.argb(round, 255, 255, 255);
        }
        if (this.f9358c.f9279c.aI()) {
            return this.f9358c.f9280d.m12443D();
        }
        return Color.argb(round, 0, 0, 0);
    }

    public int k_() {
        if (aI()) {
            return this.f9358c.m12850o().ae().m12443D();
        }
        return 0;
    }

    /* renamed from: S */
    public Drawable mo2002S() {
        if (this.f9358c.f9296t == null) {
            this.f9358c.m12855t();
        }
        return new sh(this.f9358c.f9296t);
    }

    /* renamed from: T */
    public boolean mo2003T() {
        return this.f9358c.f9284h.mo1246l().f4363k;
    }

    /* renamed from: d */
    public void mo2132d(boolean z) {
        this.f9358c.f9280d.m12510h(z);
        this.f9358c.f9280d.m12463X();
        this.f9358c.m12825a(null, this.f9358c.mo2239k());
        aN();
        this.f9358c.f9281e.m13660j();
    }

    /* renamed from: U */
    public PageAnimationMode mo2004U() {
        if (this.f9358c.f9279c.mo2145g()) {
            return PageAnimationMode.NONE;
        }
        return this.f9358c.f9280d.m12452M();
    }

    /* renamed from: a */
    public void mo2030a(PageAnimationMode pageAnimationMode) {
        this.f9358c.f9280d.m12469a(pageAnimationMode);
        this.f9358c.f9280d.m12463X();
    }

    /* renamed from: V */
    public SlideShowEffect mo2005V() {
        return this.f9358c.f9280d.m12454O();
    }

    /* renamed from: a */
    public void mo2032a(SlideShowEffect slideShowEffect) {
        this.f9358c.f9280d.m12471a(slideShowEffect);
        this.f9358c.f9280d.m12463X();
    }

    /* renamed from: W */
    public LinkedList<ah> mo2006W() {
        return ((gx) mo2007X().mo2328d()).m14301g();
    }

    /* renamed from: b */
    public void mo2105b(boolean z) {
    }

    /* renamed from: X */
    public gs mo2007X() {
        return (gs) this.f9358c.f9281e.getShowingPagesView().getCurrentPagePresenter();
    }

    /* renamed from: Y */
    public int mo2008Y() {
        return (int) this.f9358c.f9284h.mo1223b(mo2009Z());
    }

    /* renamed from: Z */
    public ak mo2009Z() {
        return this.f9358c.f9301y;
    }

    public as aa() {
        gs X = mo2007X();
        if (X == null) {
            return null;
        }
        gx gxVar = (gx) X.mo2328d();
        WebLog.init().w(gxVar != null);
        if (gxVar == null) {
            return null;
        }
        return gxVar.getPageDrawable();
    }

    /* renamed from: e */
    public gs mo2136e(int i) {
        gs X = mo2007X();
        View[] orderedPageViews = this.f9358c.f9281e.getShowingPagesView().getOrderedPageViews();
        int i2 = 0;
        while (i2 < orderedPageViews.length && ((gx) orderedPageViews[i2]).getPage() != X) {
            i2++;
        }
        int i3 = i2 + i;
        if (i3 < 0 || i3 >= orderedPageViews.length) {
            return null;
        }
        return ((gx) orderedPageViews[i3]).getPage();
    }

    /* renamed from: b */
    public void m13100b(ak akVar, boolean z, ag<as> agVar) {
        if (this.f9358c.f9293q) {
            UThread.runOnThread(new sm(this, agVar));
            return;
        }
        C0923m a;
        if (z) {
            a = this.f9358c.f9284h.mo1246l().mo1277a();
            a.f4367o = true;
        } else {
            a = this.f9358c.f9284h.mo1246l();
        }
        as a2 = this.f9358c.f9284h.mo1215a(akVar, a);
        a2.mo1297a(new sn(this, agVar, a2), new so(this, agVar));
    }

    /* renamed from: a */
    public void mo2022a(ak akVar, boolean z, ag<as> agVar) {
        m13100b(akVar, z, new sp(this, agVar));
    }

    /* renamed from: b */
    public hb mo2095b() {
        return this.f9358c.f9282f.m4152E().m4819b();
    }

    /* renamed from: a */
    public void mo2038a(RectF[] rectFArr) {
    }

    /* renamed from: a */
    public void mo2029a(PageScaleType pageScaleType) {
    }

    public Rect ab() {
        Rect rect = new Rect(0, 0, 0, 0);
        Rect bq = bq();
        int i = bq.left;
        rect.right = i;
        rect.left = i;
        int headerPaddingTop = ((C0435s) AppContext.getAppContext(this.f9358c.getContext()).queryFeature(C0435s.class)).getTheme().getHeaderPaddingTop();
        int g = this.f9358c.m12771D();
        if (ao()) {
            if (ReaderEnv.get().isNotchDevice()) {
                i = Math.round((((float) headerPaddingTop) + (((float) (bq.top - headerPaddingTop)) * 0.5f)) + (((float) g) * 0.5f));
            } else {
                i = Math.round((((float) bq.top) * 0.6f) + (((float) g) * 0.5f));
            }
            rect.top = i;
        }
        if (ap()) {
            rect.bottom = Math.round((((float) bq.bottom) * 0.65f) + (((float) g) * 0.5f));
        }
        if (ao()) {
            i = g;
        } else {
            i = 0;
        }
        i += headerPaddingTop;
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
        Rect bq = bq();
        int i = bq.left;
        rect.right = i;
        rect.left = i;
        rect.top = Math.max(bq.top - ab.top, 0);
        rect.bottom = Math.max(bq.bottom - ab.bottom, 0);
        return rect;
    }

    private Rect bq() {
        Rect rect = new Rect(0, 0, 0, 0);
        int w;
        if (this.f9358c.f9280d.m12514j() == TypesettingStyle.CUSTOM) {
            w = this.f9358c.f9280d.m12529w();
            rect.right = w;
            rect.left = w;
            rect.top = this.f9358c.f9280d.m12531y();
            rect.bottom = this.f9358c.f9280d.m12532z();
        } else {
            switch (rt.f10913a[ReaderUi.m10169l(this.f9358c.getContext()).ordinal()]) {
                case 1:
                    rect.top = AnimUtils.m1963g(this.f9358c.getContext(), 110.0f);
                    rect.bottom = AnimUtils.m1963g(this.f9358c.getContext(), 74.0f);
                    w = AnimUtils.m1960f(this.f9358c.getContext(), 54.0f);
                    rect.right = w;
                    rect.left = w;
                    break;
                case 2:
                    rect.top = AnimUtils.m1963g(this.f9358c.getContext(), 100.0f);
                    rect.bottom = AnimUtils.m1963g(this.f9358c.getContext(), 70.0f);
                    w = AnimUtils.m1960f(this.f9358c.getContext(), 44.0f);
                    rect.right = w;
                    rect.left = w;
                    break;
                case 3:
                    rect.top = AnimUtils.m1963g(this.f9358c.getContext(), 46.0f);
                    rect.bottom = AnimUtils.m1963g(this.f9358c.getContext(), 36.0f);
                    w = AnimUtils.m1960f(this.f9358c.getContext(), 20.0f);
                    rect.right = w;
                    rect.left = w;
                    break;
                case 5:
                    rect.top = AnimUtils.m1963g(this.f9358c.getContext(), 66.0f);
                    rect.bottom = AnimUtils.m1963g(this.f9358c.getContext(), 42.0f);
                    w = AnimUtils.m1960f(this.f9358c.getContext(), 30.0f);
                    rect.right = w;
                    rect.left = w;
                    break;
                default:
                    rect.top = AnimUtils.m1963g(this.f9358c.getContext(), 60.0f);
                    rect.bottom = AnimUtils.m1963g(this.f9358c.getContext(), 38.0f);
                    w = AnimUtils.m1960f(this.f9358c.getContext(), 24.0f);
                    rect.right = w;
                    rect.left = w;
                    break;
            }
            if (this.f9358c.f9280d.m12514j() == TypesettingStyle.TIGHT) {
                rect.top = Math.round(((float) rect.top) * 0.6f);
                rect.bottom = Math.round(((float) rect.bottom) * 0.6f);
                rect.left = Math.round(((float) rect.left) * 0.7f);
                rect.right = Math.round(((float) rect.right) * 0.7f);
            }
            w = this.f9358c.m12771D();
            if (!ap()) {
                rect.bottom = Math.max(rect.bottom - w, 0);
            }
            if (!ao()) {
                rect.top = Math.max(rect.top - w, 0);
            }
        }
        if (bg()) {
            rect.bottom = Math.max(rect.bottom, AnimUtils.m1932b(this.f9358c.getContext(), 30.0f));
        }
        return rect;
    }

    public Rect ad() {
        int[] iArr = new int[2];
        this.f9358c.f9281e.getLocationOnScreen(iArr);
        return new Rect(iArr[0], iArr[1], iArr[0] + this.f9358c.f9281e.getPageWidth(), iArr[1] + this.f9358c.f9281e.getPageHeight());
    }

    public ReadingPrefs ae() {
        return this.f9358c.f9280d;
    }

    /* renamed from: a */
    public void mo2033a(to toVar) {
        if (!f9356b && toVar == null) {
            throw new AssertionError();
        } else if (!this.f9358c.f9286j.contains(toVar)) {
            this.f9358c.f9286j.add(toVar);
        }
    }

    /* renamed from: b */
    public void mo2102b(to toVar) {
        if (f9356b || toVar != null) {
            this.f9358c.f9286j.remove(toVar);
            return;
        }
        throw new AssertionError();
    }

    public void af() {
        LinkedList W = this.f9358c.f9279c.mo2006W();
        if (W.size() > 0) {
            this.f9358c.f9279c.mo1992G().m4200a(Lists.newArrayList(W.toArray(new ah[0])), true);
        } else {
            this.f9358c.f9279c.mo1992G().m4185a(this.f9358c.m12776I());
            ((C1540p) this.f9358c.getContext().queryFeature(C1540p.class)).mo2564a(this.f9358c.getContext(), UserInput.DO_BOOK_MARK);
        }
        this.f9358c.f9279c.aN();
    }

    public boolean ag() {
        return this.f9358c.f9265D;
    }

    /* renamed from: e */
    public void mo2138e(boolean z) {
        this.f9358c.f9265D = z;
    }

    public boolean ah() {
        if (this.f9358c.f9282f.mo1038k() && !this.f9358c.f9282f.al() && this.f9358c.f9282f.mo1012a(true) && C0709k.m3476a().m3500a(PersonalAccount.class)) {
            return true;
        }
        return false;
    }

    public DkCloudRedeemBenefit ai() {
        if (this.f9358c.f9282f.mo1038k()) {
            return null;
        }
        return DkUserPurchasedBooksManager.m5029a().m5067c(this.f9358c.f9282f.getId());
    }

    /* renamed from: a */
    public View mo2014a(Context context) {
        return null;
    }

    public boolean aj() {
        return ReaderUi.m10170m(this.f9358c.getContext()) || this.f9358c.f9282f.mo1038k() || this.f9358c.f9282f.m4239l() || !this.f9358c.f9282f.ak();
    }

    public boolean i_() {
        return ReaderUi.m10170m(this.f9358c.getContext());
    }

    public boolean ak() {
        return false;
    }

    public boolean al() {
        return this.f9358c.f9281e.getShowingPagesView().getPageLayout() == PageLayout.RIGHT_TO_LEFT;
    }

    /* renamed from: o */
    public boolean mo2167o() {
        return this.f9358c.f9281e.m13655e();
    }

    /* renamed from: g */
    public boolean mo2145g() {
        return false;
    }

    /* renamed from: h */
    public boolean mo2155h() {
        return false;
    }

    public boolean am() {
        return this.f9358c.f9281e.m13654d();
    }

    public boolean an() {
        if (this.f9358c.f9282f.m4239l()) {
            return false;
        }
        return this.f9358c.f9280d.m12446G();
    }

    public boolean ao() {
        if (this.f9358c.f9282f.m4239l()) {
            return false;
        }
        return this.f9358c.f9280d.m12448I();
    }

    public boolean ap() {
        if (this.f9358c.f9282f.m4239l()) {
            return false;
        }
        return this.f9358c.f9280d.m12449J();
    }

    public boolean l_() {
        int i = this.f9358c.f9280d.m12511i();
        int a = this.f9358c.f9280d.m12464a(i);
        if (a <= i) {
            return false;
        }
        this.f9358c.f9280d.m12486c(a);
        ReaderEnv.get().commitPrefs();
        this.f9358c.m12825a(this.f9358c.mo2238f(), null);
        aN();
        return true;
    }

    /* renamed from: l */
    public boolean mo2163l() {
        int i = this.f9358c.f9280d.m12511i();
        int b = this.f9358c.f9280d.m12477b(i);
        if (b >= i) {
            return false;
        }
        this.f9358c.f9280d.m12486c(b);
        ReaderEnv.get().commitPrefs();
        this.f9358c.m12825a(this.f9358c.mo2238f(), null);
        aN();
        return true;
    }

    /* renamed from: m */
    public boolean mo2165m() {
        int i = this.f9358c.f9280d.m12511i();
        if (this.f9358c.f9280d.m12464a(i) <= i) {
            return true;
        }
        return false;
    }

    /* renamed from: n */
    public boolean mo2166n() {
        int i = this.f9358c.f9280d.m12511i();
        if (this.f9358c.f9280d.m12477b(i) >= i) {
            return true;
        }
        return false;
    }

    public boolean aq() {
        return (!this.f9358c.f9292p || this.f9358c.f9263B == null || this.f9358c.f9263B == mo2009Z()) ? false : true;
    }

    public boolean ar() {
        return (!this.f9358c.f9292p || this.f9358c.f9264C == null || this.f9358c.f9264C == mo2009Z()) ? false : true;
    }

    public void as() {
        this.f9358c.f9263B = mo2009Z();
        this.f9358c.f9264C = null;
    }

    /* renamed from: b */
    public int mo2093b(C0896a c0896a) {
        if (mo1995L() < 1) {
            return 0;
        }
        long b;
        if (c0896a instanceof ak) {
            b = this.f9358c.f9284h.mo1223b((ak) c0896a);
        } else if (c0896a instanceof av) {
            b = this.f9358c.f9284h.mo1209a((av) c0896a);
        } else if (c0896a instanceof ay) {
            b = this.f9358c.f9284h.mo1209a(((ay) c0896a).mo1198g());
        } else {
            b = 0;
        }
        return ((int) b) + 1;
    }

    public void at() {
        if (ar()) {
            ak Z = mo2009Z();
            m13116c(this.f9358c.f9264C);
            this.f9358c.f9263B = Z;
            this.f9358c.f9264C = null;
        }
    }

    public void au() {
        if (aq()) {
            ak Z = mo2009Z();
            m13116c(this.f9358c.f9263B);
            this.f9358c.f9264C = Z;
            this.f9358c.f9263B = null;
        }
    }

    /* renamed from: f */
    public void mo2141f(long j) {
        m13116c(this.f9358c.f9284h.mo1213a(j));
    }

    /* renamed from: a */
    public void mo2024a(av avVar) {
        if (this.f9358c.f9292p) {
            this.f9358c.f9281e.getShowingDocPresenter().mo1984a((C0896a) avVar);
        } else {
            this.f9358c.f9298v = avVar;
        }
    }

    /* renamed from: c */
    public void m13116c(ak akVar) {
        if (this.f9358c.f9292p) {
            this.f9358c.f9281e.getShowingDocPresenter().mo1984a((C0896a) akVar);
        } else {
            this.f9358c.f9298v = akVar;
        }
    }

    /* renamed from: a */
    public void mo1984a(C0896a c0896a) {
        if (c0896a instanceof ak) {
            m13116c((ak) c0896a);
        } else if (c0896a instanceof av) {
            mo2024a((av) c0896a);
        }
    }

    /* renamed from: a */
    public void mo2027a(C0901g c0901g) {
        m13116c(this.f9358c.mo2234a(c0901g));
    }

    public void av() {
        BookType o = this.f9358c.f9282f.m4242o();
        if (this.f9358c.f9282f.ak() && (o == BookType.TRIAL || o == BookType.NORMAL || o == BookType.SERIAL)) {
            m13116c(getDocument().mo1237f(getDocument().mo1249r()));
        } else {
            m13116c(getDocument().mo1249r());
        }
    }

    public boolean aw() {
        return mo2135d(this.f9358c.f9279c.mo2009Z());
    }

    public boolean ax() {
        return mo2139e(this.f9358c.f9279c.mo2009Z());
    }

    /* renamed from: d */
    public boolean mo2135d(ak akVar) {
        return this.f9358c.f9284h.mo1241h(akVar);
    }

    /* renamed from: e */
    public boolean mo2139e(ak akVar) {
        return this.f9358c.f9284h.mo1243i(akVar);
    }

    /* renamed from: b */
    public boolean mo2186b(ak akVar) {
        if (akVar.m5817f()) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    public boolean m13110b(as asVar) {
        boolean z = true;
        if (this.f9358c.f9284h.mo1448b() || !mo2186b(asVar.mo1332l())) {
            return false;
        }
        boolean z2;
        if (asVar instanceof C0941i) {
            z2 = (((ba) ((C0941i) asVar).mo1305b()).mo1299a() || ((ba) ((C0941i) asVar).mo1434c()).mo1299a()) ? false : true;
        } else {
            if (((ba) asVar).mo1299a()) {
                z = false;
            }
            z2 = z;
        }
        return z2;
    }

    /* renamed from: e */
    public gx mo2137e(int i, int i2) {
        return (gx) this.f9358c.f9281e.getShowingPagesView().m9987a(i, i2);
    }

    public gx[] ay() {
        Rect viewableBounds = getViewableBounds();
        View[] a = this.f9358c.f9281e.getShowingPagesView().m10002a(viewableBounds.left, viewableBounds.top, viewableBounds.right, viewableBounds.bottom);
        gx[] gxVarArr = new gx[a.length];
        for (int i = 0; i < gxVarArr.length; i++) {
            gxVarArr[i] = (gx) a[i];
        }
        return gxVarArr;
    }

    /* renamed from: a */
    public void mo2039a(gx[] gxVarArr) {
        Arrays.sort(gxVarArr, new sq(this));
    }

    public void az() {
        if (this.f9358c.f9270J != null) {
            this.f9358c.f9270J.mo2383n();
        }
    }

    public void aA() {
        aM();
        ReaderEnv.get().commitPrefs();
        this.f9358c.m12778K();
        this.f9358c.m12781N();
        this.f9358c.m12858w();
        this.f9358c.m12825a(this.f9358c.mo2238f(), this.f9358c.mo2239k());
        this.f9358c.m12861z();
        aN();
        this.f9358c.f9281e.m13660j();
    }

    public void aB() {
        this.f9358c.m12825a(this.f9358c.mo2238f(), null);
        aN();
    }

    /* renamed from: f */
    public void mo2142f(boolean z) {
        this.f9358c.f9279c.aM();
        this.f9358c.m12817A().switchNightMode(z, true);
        this.f9358c.m12855t();
        this.f9358c.m12825a(null, this.f9358c.mo2239k());
        this.f9358c.f9281e.setStatusColor(mo2001R());
        aN();
        this.f9358c.f9281e.m13660j();
        if (z) {
            this.f9358c.m12779L();
        } else {
            UIdleHandler.addIdleHandler(new sr(this));
        }
    }

    /* renamed from: g */
    public void mo2144g(boolean z) {
        this.f9358c.f9280d.m12474a(z);
        this.f9358c.f9280d.m12463X();
        this.f9358c.m12817A().switchEyesSavingMode(this.f9358c.f9279c.aK());
        if (this.f9358c.f9270J != null) {
            this.f9358c.f9270J.mo2370a(z);
        }
    }

    public void aC() {
        if (this.f9358c.f9272L != null) {
            this.f9358c.f9272L.m13751a();
        }
    }

    public void aD() {
        if (this.f9358c.f9272L != null) {
            this.f9358c.f9272L.m13754b();
        }
    }

    public boolean aE() {
        return this.f9358c.f9272L != null ? this.f9358c.f9272L.m13756d() : false;
    }

    public void aF() {
        if (this.f9358c.f9272L != null) {
            this.f9358c.f9272L.m13757e();
        }
    }

    public void aG() {
        if (this.f9358c.f9272L != null) {
            this.f9358c.f9272L.m13758f();
        }
    }

    /* renamed from: f */
    public void mo2140f(int i) {
        if (this.f9358c.f9272L != null) {
            this.f9358c.f9272L.m13752a(i);
        }
    }

    /* renamed from: h */
    public void mo2154h(boolean z) {
        this.f9358c.f9280d.m12506g(z);
        this.f9358c.f9280d.m12463X();
    }

    public boolean aH() {
        return mo1997N() == ReadingTheme.NIGHT;
    }

    public boolean aI() {
        return mo1997N() == ReadingTheme.CUSTOM;
    }

    public boolean aJ() {
        switch (rt.f10915c[mo1997N().ordinal()]) {
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
        return this.f9358c.f9280d.m12522p();
    }

    public boolean aL() {
        return this.f9358c.f9280d.m12451L();
    }

    public void aM() {
        this.f9358c.f9281e.m13656f();
    }

    public void aN() {
        this.f9358c.m12832a(true);
    }

    /* renamed from: i */
    public void mo2157i(boolean z) {
        this.f9358c.m12832a(z);
    }

    /* renamed from: a */
    public void mo2185a(boolean z) {
        if (z) {
            this.f9358c.f9281e.m13656f();
        }
        this.f9358c.f9281e.m13659i();
    }

    /* renamed from: j */
    public void mo2159j(boolean z) {
        this.f9358c.f9277a = new ss(this, z);
        UIdleHandler.addIdleHandler(this.f9358c.f9277a);
    }

    /* renamed from: a */
    public Rect mo2011a(Rect rect) {
        Rect ad = ad();
        return new Rect(Math.round((float) (ad.left + rect.left)), Math.round((float) (ad.top + rect.top)), Math.round((float) (ad.left + rect.right)), Math.round((float) (ad.top + rect.bottom)));
    }

    /* renamed from: a */
    public void mo2036a(String str) {
        this.f9358c.f9279c.mo2040a(1, 0);
        m13106b(str);
    }

    public void aO() {
        if (this.f9358c.f9270J != null) {
            this.f9358c.f9270J.mo2369a("");
        }
    }

    /* renamed from: b */
    public void m13106b(String str) {
        if (this.f9358c.f9270J != null) {
            this.f9358c.f9270J.mo2369a(str);
        }
    }

    public void aP() {
        if (this.f9358c.f9270J != null) {
            this.f9358c.f9270J.mo2378i();
        }
    }

    public void aQ() {
        if (this.f9358c.f9270J != null) {
            this.f9358c.f9270J.mo2377h();
        }
    }

    public void aR() {
        if (this.f9358c.f9270J != null) {
            this.f9358c.f9270J.mo2376g();
        }
    }

    /* renamed from: d */
    public boolean mo2133d() {
        return true;
    }

    /* renamed from: f */
    public boolean mo2362f() {
        return true;
    }

    public void onItemChanged(an anVar, int i) {
    }

    /* renamed from: a */
    public void mo1221a(C0903n c0903n, as asVar) {
    }

    /* renamed from: b */
    public void mo1225b(C0903n c0903n, as asVar) {
    }

    public void aS() {
        C0781b.m3667b().m3694g();
    }

    /* renamed from: b */
    public void mo2100b(ea eaVar) {
        boolean z = mo2004U() != PageAnimationMode.VSCROLL && mo2009Z().m5777b() && mo2009Z().mo1198g().equals(eaVar.m3726d());
        C0798a[] as = mo1992G().as();
        Arrays.sort(as, new st(this));
        String m = eaVar.m4384m();
        ay a = getDocument().mo1216a((C0897d) eaVar.m3726d(), (C0897d) eaVar.m3728e());
        List linkedList = new LinkedList();
        int length = as.length;
        int i = 0;
        while (i < length) {
            ay ayVar;
            String str;
            C0798a c0798a = as[i];
            if (c0798a instanceof ah) {
                ayVar = a;
                str = m;
            } else {
                bb a2 = getDocument().mo1216a((C0897d) c0798a.m3726d(), (C0897d) c0798a.m3728e());
                if (a2.m5814b(a) || (z && a2.mo1199h().equals(a.mo1198g()))) {
                    ay a3 = a2.mo1196a(a);
                    String str2 = a2.mo1198g().m5778b(a3.mo1198g()) ? ((ea) c0798a).m4384m() + m : m + ((ea) c0798a).m4384m();
                    linkedList.add(c0798a);
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
        mo1992G().m4200a(linkedList, false);
        eaVar.m3718a(a.mo1198g());
        eaVar.m3722b(a.mo1199h());
        eaVar.m3719a(getDocument().m5902a((bb) a));
        eaVar.m4380e(m);
        mo1992G().m4185a((C0798a) eaVar);
    }

    /* renamed from: a */
    public void mo2025a(ay ayVar, boolean z) {
    }

    /* renamed from: i */
    public void mo2156i() {
    }

    public boolean aT() {
        return this.f9358c.f9280d.m12456Q();
    }

    /* renamed from: k */
    public void mo2162k(boolean z) {
        this.f9358c.f9280d.m12513i(z);
        this.f9358c.f9280d.m12463X();
    }

    public void aU() {
        this.f9362g++;
    }

    public void aV() {
        this.f9362g--;
    }

    public boolean aW() {
        return this.f9362g > 0;
    }

    public void aX() {
        if (this.f9358c.f9271K != null) {
            UmengManager.get().onEvent("TTS_PLAY_V1");
            ap apVar;
            if (!mo2362f()) {
                apVar = new ap(this.f9358c.getContext());
                apVar.setTitle(C0258j.reading__shared__tts_not_allowed_title);
                apVar.setPrompt(C0258j.reading__shared__tts_not_allowed_prompt);
                apVar.setOkLabelResid(C0258j.general__shared__iknow);
                apVar.show();
            } else if (TtsManager.get().getSpeakerList().size() == 0) {
                TtsManager.get().setTtsUserNotified(true);
                apVar = new ap(this.f9358c.getContext());
                apVar.setTitle(C0258j.reading__tts_view__download_title);
                apVar.setPrompt(C0258j.reading__tts_view__download_prompt);
                apVar.setOkLabel(String.format(this.f9358c.getString(C0258j.reading__tts_view__download), new Object[]{DkPublic.formatBytes(TtsManager.get().getDefaultPackSize())}));
                apVar.setNoLabel(C0258j.general__shared__cancel);
                apVar.open(new sk(this));
            } else {
                if (!(TtsManager.get().isTtsUserNotified() || TtsManager.get().isEventExpired())) {
                    TtsManager.get().setTtsUserNotified(true);
                    apVar = new ap(this.f9358c.getContext());
                    apVar.setTitle(C0258j.reading__tts_view__limited_speaker);
                    apVar.setPrompt(C0258j.reading__tts_view__limited_speaker_prompt);
                    apVar.setPromptLayoutGravity(17);
                    apVar.setOkLabelResid(C0258j.reading__tts_view__get_it_now);
                    apVar.setNoLabel(C0258j.reading__tts_view__not_now);
                    apVar.open(new sl(this));
                }
                this.f9358c.f9271K.m13442a();
            }
        }
    }

    public void aY() {
        if (this.f9358c.f9271K != null) {
            this.f9358c.f9271K.m13446b();
        }
    }

    public void aZ() {
        if (this.f9358c.f9271K != null) {
            this.f9358c.f9271K.m13447c();
        }
    }

    public void ba() {
        if (this.f9358c.f9271K != null) {
            this.f9358c.f9271K.m13448d();
        }
    }

    public boolean bb() {
        return this.f9358c.f9271K != null ? this.f9358c.f9271K.m13449e() : false;
    }

    public float bc() {
        return this.f9358c.f9280d.m12457R();
    }

    /* renamed from: b */
    public void mo2098b(float f) {
        if (this.f9358c.f9271K != null) {
            this.f9358c.f9271K.m13443a(f);
        }
    }

    /* renamed from: g */
    public void mo2143g(int i) {
        if (this.f9358c.f9271K != null) {
            this.f9358c.f9271K.m13444a(i);
        }
    }

    public int bd() {
        return this.f9358c.f9271K != null ? this.f9358c.f9271K.m13452h() : 0;
    }

    public void be() {
        if (this.f9358c.f9271K != null) {
            this.f9358c.pushPageSmoothly(new afm(this.f9358c.getContext()), null);
        }
    }

    public void bf() {
        if (this.f9358c.f9271K != null) {
            this.f9358c.pushPageSmoothly(new TtsWebController(this.f9358c.getContext()), null);
        }
    }

    /* renamed from: k */
    public bb mo2161k() {
        return null;
    }

    /* renamed from: j */
    public boolean mo2160j() {
        return false;
    }

    /* renamed from: a */
    public void mo2023a(au auVar, Rect rect) {
        if (this.f9358c.f9270J != null) {
            this.f9358c.f9270J.mo2365a(auVar, rect);
        }
    }

    public boolean bg() {
        return false;
    }

    public C1455g bh() {
        if (this.f9360e == null) {
            this.f9360e = new C1455g(this.f9358c.getContext(), this.f9358c.f9279c);
            this.f9360e.setCallback(this.f9358c.f9276P);
        }
        return this.f9360e;
    }

    /* renamed from: a */
    public void mo2017a(Canvas canvas, int i, int i2, int i3, int i4, int i5) {
        C1455g bh = bh();
        Rect rect = (Rect) AnimUtils.f1198g.addAnimation();
        rect.set(i - (bh.getIntrinsicWidth() / 2), i2 - (bh.getIntrinsicHeight() / 2), (bh.getIntrinsicWidth() / 2) + i, (bh.getIntrinsicHeight() / 2) + i2);
        bh.setBounds(rect);
        bh.m14194a(rect.left, i3, rect.right, i4);
        bh.m14193a(i5);
        bh.draw(canvas);
        AnimUtils.f1198g.clearAnimation(rect);
    }

    public boolean bi() {
        return this.f9358c.f9270J != null ? this.f9358c.f9270J.mo2374e() : false;
    }

    public void bj() {
        ((ReaderFeature) this.f9358c.getContext().queryFeature(ReaderFeature.class)).shareBooks(this.f9358c, mo1992G());
    }

    /* renamed from: c */
    public void mo2126c(float f) {
        this.f9358c.f9281e.setStatusOpacity(f);
    }

    public Rect bk() {
        if (this.f9357a != null && this.f9359d == am()) {
            return this.f9357a;
        }
        DisplayMetrics displayMetrics = this.f9358c.getResources().getDisplayMetrics();
        this.f9359d = am();
        int i = displayMetrics.widthPixels / 4;
        int i2 = displayMetrics.heightPixels / 4;
        this.f9357a = new Rect(i, i2, i, i2);
        return this.f9357a;
    }

    /* renamed from: a */
    public void mo2037a(String str, int i) {
        ((ReaderFeature) this.f9358c.getContext().queryFeature(ReaderFeature.class)).pushPageSmoothly(bv.m15355a(this.f9358c.getContext(), "0", i, str, null), null);
    }

    public C1446a bl() {
        return this.f9358c.f9278b;
    }

    public DkStoreItemDetail bm() {
        if (this.f9358c.f9282f.mo1038k()) {
            return this.f9358c.f9269H;
        }
        return this.f9358c.f9268G;
    }

    public boolean bn() {
        return this.f9358c.m12783P();
    }

    public boolean bo() {
        return this.f9358c.m12784Q();
    }

    public void bp() {
        this.f9358c.requestShowMenu();
    }
}
