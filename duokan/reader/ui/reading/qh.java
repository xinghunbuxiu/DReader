package com.duokan.reader.ui.reading;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.net.Uri;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout.LayoutParams;

import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.BrightnessMode;
import com.duokan.core.app.IActivityRunStatusChanged;
import com.duokan.core.app.IFeature;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.sys.af;
import com.duokan.core.sys.IdleStatus;
import com.duokan.core.ui.UTools;
import com.duokan.core.ui.cv;
import com.duokan.reader.DkApp;
import com.duokan.reader.MiuiAssistContent;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.SystemUiConditioner;
import com.duokan.reader.SystemUiMode;
import com.duokan.reader.UmengManager;
import com.duokan.reader.common.classc;
import com.duokan.reader.domain.account.oauth.ThirdOAuth;
import com.duokan.reader.domain.account.oauth.ThirdYinxiang;
import com.duokan.reader.domain.account.oauth.TokenStore;
import com.duokan.reader.domain.bookshelf.BookFormat;
import com.duokan.reader.domain.bookshelf.BookLimitType;
import com.duokan.reader.domain.bookshelf.BookType;
import com.duokan.reader.domain.bookshelf.ah;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.ej;
import com.duokan.reader.domain.bookshelf.js;
import com.duokan.reader.domain.bookshelf.ju;
import com.duokan.reader.domain.cloud.DkUserPurchasedBooksManager;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.domain.document.Document_a;
import com.duokan.reader.domain.document.Document_a.d;
import com.duokan.reader.domain.document.aa;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.av;
import com.duokan.reader.domain.document.k;
import com.duokan.reader.domain.document.m;
import com.duokan.reader.domain.document.n;
import com.duokan.reader.domain.document.w;
import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.domain.store.DkStoreFiction;
import com.duokan.reader.domain.store.DkStoreFictionDetail;
import com.duokan.reader.domain.store.DkStoreItemDetail;
import com.duokan.reader.ui.general.PagesView;
import com.duokan.reader.ui.general.ReaderUi;
import com.duokan.reader.ui.general.ReaderUi.ScreenType;
import com.duokan.reader.ui.general.ap;
import com.duokan.reader.ui.general.gd;
import com.duokan.reader.ui.general.gi;
import com.duokan.reader.ui.p;
import com.duokan.reader.ui.welcome.DkTipManager.UserInput;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public abstract class qh extends p implements SystemUiConditioner, classc.IConnectChanged, w, xb {
    static final /* synthetic */ boolean I = (!qh.class.desiredAssertionStatus());
    protected ak A = null;
    protected ak B = null;
    protected ak C = null;
    protected boolean D = true;
    protected int E = 0;
    protected int F = 0;
    protected DkStoreBookDetail G = null;
    protected DkStoreFictionDetail H = null;
    private si J = null;
    private adm K = null;
    private aq L = null;
    private co M = null;
    private com.duokan.reader.domain.bookshelf.w N = null;
    private IActivityRunStatusChanged O = null;
    private Callback P = new qi(this);
    private IdleStatus a = null;
    private final Document_a b = new Document_a();
    protected final rx c;
    protected final ReadingPrefs d;
    protected final wl e;
    protected final c f;
    protected final tx g = new tx();
    protected final n h;
    protected final gd i;
    protected final LinkedList j = new LinkedList();
    protected final LinkedHashMap k = new LinkedHashMap();
    protected final long l;
    protected long m = 0;
    protected int n = 0;
    protected boolean o = false;
    protected boolean p = false;
    protected boolean q = false;
    protected BookType r;
    protected BookLimitType s;
    protected Bitmap t = null;
    protected String u = "";
    protected Document_a v = null;
    protected boolean w = false;
    protected av x = null;
    protected ak y = null;
    protected ak z = null;

    protected abstract float a(ak akVar);

    protected abstract ak a(com.duokan.reader.domain.document.g gVar);

    protected abstract si c();

    protected abstract wl d();

    protected abstract rx e();

    protected abstract k f();

    protected abstract m k();

    protected abstract void l();

    public qh(IFeature featrue, c cVar, Document_a aVar) {
        super(featrue);
        com.duokan.reader.domain.statistics.dailystats.a.d().a();
        this.l = System.currentTimeMillis();
        this.f = cVar;
        this.d = new ReadingPrefs(getContext());
        this.c = e();
        this.r = this.f.o();
        this.s = this.f.p();
        getContext().addFirstLocalFeature(this.c);
        getContext().registerGlobalFeature(this.c);
        ai.a().a(this.c);
        w();
        this.e = d();
        a(this.e);
        this.v = aVar;
        this.h = this.f.a(new qx(this), (w) this);
        this.i = new rj(this);
        M();
        L();
        l();
        K();
        A().switchEyesSavingMode(this.c.aK());
        this.h.a(this.c);
        this.e.g();
        this.e.setStatusColor(this.c.R());
        this.e.setOnPageBroadcastListener(this.i);
        this.e.setOnCurrentPageChangeListener(new rk(this));
    }

    public c n() {
        return this.f;
    }

    public sh o() {
        return this.c;
    }

    public boolean b(Runnable runnable) {
        if (this.q) {
            runnable.run();
            return false;
        }
        this.q = true;
        A().removeSystemUiConditioner(this);
        if (this.J != null) {
            deactivate(this.J);
        }
        if (this.K != null) {
            deactivate(this.K);
        }
        if (this.L != null) {
            deactivate(this.L);
        }
        if (this.M != null) {
            deactivate(this.M);
        }
        h();
        ReaderFeature readerFeature = (ReaderFeature) getContext().queryFeature(ReaderFeature.class);
        if (this.p) {
            Runnable rlVar = new rl(this, runnable);
            if (this.f.aG() && !this.c.bf() && g() == 0) {
                d(rlVar);
            } else {
                if (this.c.bf()) {
                    UmengManager.get().onEvent("READING_ADD_BOOKB", "NO");
                }
                readerFeature.setQuitOnBack(true);
                rlVar.run();
            }
        } else {
            readerFeature.setQuitOnBack(true);
            if (runnable != null) {
                runnable.run();
            }
        }
        return true;
    }

    public void p() {
        if (this.p) {
            b();
        }
        if (this.t != null) {
            this.t.recycle();
            this.t = null;
            this.u = "";
        }
    }

    public void chooseStatusBarStyle(af afVar) {
        afVar.a(Boolean.valueOf(!this.c.aJ()));
    }

    public void chooseNavigationBarMode(af afVar) {
        if (getActivity().hasWindowFocus()) {
            afVar.a(this.c.an() ? SystemUiMode.DOCK : SystemUiMode.GONE);
        }
    }

    public void chooseNavigationBarColor(af afVar) {
        if (this.c.aH()) {
            afVar.a(Integer.valueOf(-16777216));
        }
    }

    public boolean navigateSmoothly(String str) {
        return navigate(str, null, true, null);
    }

    public boolean navigate(String str, Object obj, boolean z, Runnable runnable) {
        if (TextUtils.isEmpty(str) || !str.equals("prefs/font")) {
            return false;
        }
        ActivatedController etVar = new et(getContext(), true);
        if (z) {
            ((ReaderFeature) getContext().queryFeature(ReaderFeature.class)).pushHalfPageSmoothly(etVar, runnable);
        } else {
            ((ReaderFeature) getContext().queryFeature(ReaderFeature.class)).pushHalfPage(etVar);
            UTools.creatCallTask(etVar.getContentView(), runnable);
        }
        return true;
    }

    public void e(n nVar) {
    }

    public void f(n nVar) {
    }

    public void a(n nVar, aa aaVar) {
    }

    public void a(n nVar) {
        WebLog.c().a(this.h.b());
        runAfterActive(new rn(this));
    }

    public void b(n nVar) {
        runAfterActive(new rq(this));
    }

    public void c(n nVar) {
    }

    public void d(n nVar) {
    }

    public void onConnectivityChanged(classc.ConnectivityReceiver connectivity) {
    }

    protected void onTrimMemory(int i) {
        if (i >= 40) {
            PagesView showingPagesView = this.e.getShowingPagesView();
            if (showingPagesView != null) {
                View[] pageViews = showingPagesView.getPageViews();
                for (View view : pageViews) {
                    as pageDrawable = ((gs) view).getPageDrawable();
                    if (pageDrawable != null) {
                        pageDrawable.a(true);
                    }
                }
            }
        }
        super.onTrimMemory(i);
    }

    protected boolean onBack() {
        requestDetach();
        return true;
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
        A().addSystemUiConditioner(this);
        N();
        this.O = new rr(this);
        DkApp.get().addOnRunningStateChangedListener(this.O);
        f.b().a((classc.IConnectChanged) this);
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        ai.a().b(this.c);
        getContext().unregisterGlobalFeature(this.c);
        com.duokan.reader.domain.statistics.dailystats.a.d().a(this.f, 0, this.E, this.F);
        if (this.O != null) {
            DkApp.get().removeOnRunningStateChangedListener(this.O);
        }
        f.b().b(this);
    }

    protected void onActive(boolean z) {
        if (z) {
            com.duokan.reader.domain.statistics.a.k().a("single_reading", 3);
            m();
        }
        this.m = System.currentTimeMillis();
        this.n = 0;
        h.a().a(this.f);
        if (com.duokan.reader.domain.statistics.dailystats.a.d().a()) {
            com.duokan.reader.domain.statistics.dailystats.a.d().b();
        }
    }

    protected void onDeactive() {
        if (this.q) {
            A().switchEyesSavingMode(false);
        }
        if (this.p) {
            ju G = this.f.G();
            if (DkApp.get().forCommunity() && com.duokan.reader.common.webservices.duokan.p.i().l()) {
                G.a += Math.max(0, System.currentTimeMillis() - this.m) * 60;
            } else {
                G.a += Math.min(System.currentTimeMillis() - this.m, TimeUnit.MINUTES.toMillis(5) * ((long) this.n));
            }
            G.b += Math.round(((float) this.n) * B());
            this.f.a(G);
            h.a().b(this.f);
            if (this.f.w()) {
                com.duokan.reader.domain.statistics.a.k().a(this.f.H(), String.valueOf((System.currentTimeMillis() - this.m) / 1000));
            }
            if (this.h.p()) {
                if (this.q) {
                    this.e.k();
                } else {
                    G();
                }
                if (i.f().b() && PersonalPrefs.a().x()) {
                    this.f.a(this.x);
                }
                if (!TextUtils.isEmpty(this.f.N())) {
                    a(this.f, this.h);
                }
                if (this.f.ai() && this.f.o() == BookType.NORMAL) {
                    DkUserPurchasedBooksManager.a().d(this.f.H());
                }
            }
        }
        this.f.aL();
    }

    public void q() {
        if (!this.q) {
            a(f(), k());
            this.e.i();
            if (this.p) {
                if (this.J != null) {
                    this.J.o();
                }
                if (this.L != null) {
                    this.L.g();
                }
            }
        }
    }

    private float B() {
        Rect b = this.h.k().b();
        return ((float) Math.max(0, b.height() * b.width())) / ((float) (((double) (this.c.A() * this.c.A())) * this.c.B()));
    }

    private final void a(c cVar, n nVar) {
        if (!ReaderEnv.get().getSyncEvernoteEnabled()) {
            return;
        }
        if ((ReaderEnv.get().getIsOnlyWifiSyncEvernote() && f.b().d()) || !ReaderEnv.get().getIsOnlyWifiSyncEvernote()) {
            ThirdYinxiang thirdYinxiang;
            if (TokenStore.getInstance().isBindAccessToken(getContext(), "evernote")) {
                thirdYinxiang = (ThirdYinxiang) ThirdOAuth.produceThird(getActivity(), "evernote");
            } else {
                thirdYinxiang = (ThirdYinxiang) ThirdOAuth.produceThird(getActivity(), "yinxiang");
            }
            thirdYinxiang.queryAccount(new rs(this, cVar, nVar, thirdYinxiang));
        }
    }

    private final void C() {
        this.f.a(new qj(this));
    }

    protected void a() {
        ReaderEnv.get().setReadingBookUuid(this.f.H());
        this.h.h().a(this.f.aw());
        this.e.setLineDirection(this.h.c());
        this.e.getShowingDocPresenter().setAnnotations(n().aq());
        this.N = new qo(this);
        n().a(this.N);
        this.b.a(this.f);
        this.d.r();
    }

    protected void r() {
        com.duokan.reader.common.webservices.duokan.p.i().j();
        this.e.setOnScrollListener(new qp(this));
        this.J = c();
        this.J.a(this.c.U());
        this.J.a(this.i);
        addSubController(this.J);
        this.K = new adm(getContext());
        this.e.addView(this.K.getContentView(), new LayoutParams(-1, -1));
        addSubController(this.K);
        this.L = new aq(getContext(), this.e);
        this.e.addView(this.L.getContentView(), new LayoutParams(-1, -1));
        addSubController(this.L);
        this.M = new co(getContext(), this.c, this.e);
        this.e.getPagesFrameView().addView(this.M.getContentView());
        addSubController(this.M);
        this.c.a(new qq(this));
        activate(this.M);
        activate(this.K);
        activate(this.J);
        activate(this.L);
        if (this.f.ai()) {
            c(new qr(this));
        } else {
            C();
        }
        ReaderEnv.get().addBookOpenTimes();
        O();
        if (this.f.ai()) {
            ej ejVar = (ej) this.f;
            long aY = ejVar.aY();
            if (this.f.Q() && ejVar.aX() && aY - System.currentTimeMillis() < 259200000) {
                String c = ReaderUi.c(getContext(), aY);
                if (!TextUtils.isEmpty(c)) {
                    String str;
                    if (aY - System.currentTimeMillis() < 900000) {
                        str = c + "\n\n" + getString(j.reading__shared__buy_to_read);
                    } else {
                        str = c;
                    }
                    ((ReaderFeature) getContext().queryFeature(ReaderFeature.class)).prompt(str, 1);
                }
            }
        }
        if (F() >= 0) {
            this.M.b(F());
        }
        if (this.h instanceof d) {
            if (this.c.g()) {
                ((com.duokan.reader.ui.welcome.p) getContext().queryFeature(com.duokan.reader.ui.welcome.p.class)).a(getContext(), UserInput.READING_SHOW_OPTION);
            } else {
                ((com.duokan.reader.ui.welcome.p) getContext().queryFeature(com.duokan.reader.ui.welcome.p.class)).a(getContext(), UserInput.READING_FAST_OPERATION);
            }
        } else if (!this.f.l()) {
            ((com.duokan.reader.ui.welcome.p) getContext().queryFeature(com.duokan.reader.ui.welcome.p.class)).a(getContext(), UserInput.READING_FAST_OPERATION);
        }
        try {
            UmengManager.get().onEvent("READING_PAGE_ANIM_V1", this.d.M().name());
        } catch (Throwable th) {
        }
    }

    protected void b() {
        if (this.K != null) {
            removeSubController(this.K);
        }
        if (this.L != null) {
            removeSubController(this.L);
        }
        this.e.getShowingDocPresenter().a(null, null);
        this.h.o();
        if (this.J != null) {
            deactivate(this.J);
        }
        b.b().g();
        this.h.b(this.c);
        if (this.N != null) {
            n().b(this.N);
        }
    }

    protected void m() {
        a(f(), k());
        if (this.v == null) {
            this.x = s();
        } else if (this.v instanceof av) {
            this.x = (av) this.v;
        } else {
            this.x = s();
        }
        this.e.getShowingDocPresenter().a(this.h, this.x);
    }

    protected void a(int i, int i2) {
        Animation alphaAnimation;
        if ((i2 & 8) == 8) {
            alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setFillBefore(true);
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setDuration(200);
            alphaAnimation.setAnimationListener(new qs(this));
            this.e.getPagesFrameView().startAnimation(alphaAnimation);
        } else if ((i & 8) == 8) {
            alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(200);
            this.e.getPagesFrameView().startAnimation(alphaAnimation);
            this.e.getPagesFrameView().setForeground(null);
        }
        if (this.K != null) {
            this.K.a(i, i2);
        }
    }

    protected void a(gi giVar) {
        if (this.J != null) {
            this.J.a(giVar);
        }
    }

    protected void b(gi giVar) {
        this.n++;
        if (this.A == null) {
            com.duokan.reader.domain.statistics.dailystats.a.d().b();
        }
        if (!this.w) {
            if (this.c.U() == PageAnimationMode.VSCROLL || this.c.g()) {
                Rect rect = this.f.D().b;
                if (rect != null) {
                    this.e.getShowingPagesView().getCurrentPagePresenter().a(rect);
                }
            }
            this.w = true;
            com.duokan.reader.domain.statistics.a.k().f();
            DkApp.get().setReadyToSee();
            if (this.f.aG()) {
                this.c.a(new qt(this));
            }
        }
        this.A = this.y;
        gs gsVar = (gs) giVar.d();
        as pageDrawable = gsVar.getPageDrawable();
        if (gsVar.a()) {
            gsVar.b();
        }
        if (pageDrawable.B() > 0) {
            ((com.duokan.reader.ui.welcome.p) getContext().queryFeature(com.duokan.reader.ui.welcome.p.class)).a(getContext(), UserInput.READING_SHOW_CARTOON);
        }
        this.e.h();
        this.c.a(new qu(this, giVar));
    }

    protected void a(gn gnVar, gn gnVar2) {
        if (I || gnVar2 != null) {
            if (gnVar2.e()) {
                b((gi) gnVar2);
            }
            if ((this.f.o() == BookType.NORMAL || this.f.Q()) && this.f.F() == 0 && this.c.L() > 0 && gnVar != null && gnVar.e() && this.h.b(gnVar.g()) + 1 >= Math.round(((double) this.c.L()) * 0.95d)) {
                this.f.e(System.currentTimeMillis());
            }
            if (gnVar != null) {
                h.a().b();
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    protected void a(gn gnVar) {
    }

    protected void b(gn gnVar) {
        if (this.c.X() == gnVar) {
            b((gi) gnVar);
        }
    }

    protected void a(k kVar) {
        TypesettingStyle j = this.d.j();
        ScreenType l = ReaderUi.l(getContext());
        switch (ri.b[j.ordinal()]) {
            case 1:
                switch (ri.a[l.ordinal()]) {
                    case 1:
                    case 2:
                        kVar.g = 1.6d;
                        kVar.h = 0.8d;
                        kVar.i = 2.0d;
                        break;
                    default:
                        kVar.g = 1.2d;
                        kVar.h = 0.4d;
                        kVar.i = 2.0d;
                        break;
                }
            case 2:
                switch (ri.a[l.ordinal()]) {
                    case 1:
                    case 2:
                        kVar.g = 2.0d;
                        kVar.h = 2.0d;
                        kVar.i = 2.0d;
                        break;
                    default:
                        kVar.g = 1.6d;
                        kVar.h = 1.2d;
                        kVar.i = 2.0d;
                        break;
                }
            case 3:
                kVar.g = -1.0d;
                kVar.h = -1.0d;
                kVar.i = -1.0d;
                break;
            case 4:
                kVar.g = (double) this.d.s();
                kVar.h = (double) this.d.t();
                kVar.i = (double) this.d.u();
                break;
            default:
                switch (ri.a[l.ordinal()]) {
                    case 1:
                    case 2:
                        kVar.g = 2.0d;
                        kVar.h = 1.0d;
                        kVar.i = 2.0d;
                        break;
                    default:
                        kVar.g = 1.6d;
                        kVar.h = 0.6d;
                        kVar.i = 2.0d;
                        break;
                }
        }
        kVar.f = this.d.i();
        kVar.a = this.c.o() ? this.e.getPageWidth() / 2 : this.e.getPageWidth();
        kVar.b = this.e.getPageHeight();
        kVar.c = this.c.ab();
        kVar.d = this.c.ac();
        kVar.e = this.c.U() == PageAnimationMode.VSCROLL;
        kVar.j.putAll(this.k);
        E();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        if (this.c.g()) {
            this.h.a(((displayMetrics.heightPixels * displayMetrics.widthPixels) * 2) * 6);
            return;
        }
        this.h.a(((kVar.e ? 4 : 2) * (displayMetrics.widthPixels * displayMetrics.heightPixels)) * 4);
    }

    protected void a(m mVar) {
        boolean z = true;
        t();
        if (this.J != null) {
            this.J.a(this.t);
        }
        mVar.c = this.c.j_();
        mVar.e = this.c.R();
        mVar.g = v();
        mVar.f = D();
        mVar.a = new rw(this);
        mVar.b = getResources().getDrawable(com.duokan.c.f.reading__shared__pic_shadow_normal);
        boolean z2 = this.c.d() && this.d.P();
        mVar.k = z2;
        if (ReaderUi.m(getContext())) {
            z2 = this.c.ao();
        } else {
            z2 = false;
        }
        mVar.l = z2;
        mVar.m = this.c.ao();
        if (mVar.c != 0) {
            mVar.i = false;
            mVar.j = false;
        } else if (this.c.N() == ReadingTheme.NIGHT) {
            mVar.d = Color.argb(255, Math.round(239.4737f), Math.round(236.8421f), Math.round(236.8421f));
            mVar.i = true;
            mVar.j = false;
        } else if (this.c.N() == ReadingTheme.THEME12) {
            mVar.d = Color.argb(255, 53, 69, 81);
            mVar.i = true;
            mVar.j = false;
        } else if (this.c.aJ()) {
            mVar.i = false;
            mVar.j = true;
        } else {
            mVar.i = false;
            mVar.j = false;
        }
        if (this.c.U() != PageAnimationMode.VSCROLL) {
            z = false;
        }
        mVar.p = z;
    }

    private int D() {
        switch (ri.a[ReaderUi.l(getContext()).ordinal()]) {
            case 1:
            case 2:
                return (UTools.g(getContext(), 16.0f) / 2) * 2;
            case 3:
                return (UTools.g(getContext(), 12.0f) / 2) * 2;
            default:
                return (UTools.g(getContext(), 14.0f) / 2) * 2;
        }
    }

    private void E() {
        if (!this.q) {
            cv.updateLayout();
        }
    }

    private final int F() {
        return this.f.D().d;
    }

    private void G() {
        if (this.A != null && this.c.X() != null) {
            if (!(ReaderEnv.get().forHd() || this.f.q() == BookFormat.PDF || this.f.q() == BookFormat.SBK)) {
                this.d.a(this.c.am() ? ReadingOrientation.LANDSCAPE : ReadingOrientation.PORTRAIT);
                this.d.Y();
            }
            js jsVar = new js();
            a(jsVar);
            this.f.a(jsVar);
            if (this.f.k()) {
                ((ej) this.f).bb();
            }
            this.f.aL();
            if (!this.f.aG()) {
                try {
                    String string;
                    if (this.c.aa() != null) {
                        string = getContext().getString(j.miui_assitant__shared__reading_progress, new Object[]{this.c.aa().I()});
                    } else {
                        string = "";
                    }
                    MiuiAssistContent.insert(this.f, string);
                } catch (Throwable th) {
                }
            }
        }
    }

    protected void a(js jsVar) {
        ak akVar = (ak) this.h.c(this.A);
        jsVar.a = akVar.g();
        jsVar.e = a(akVar);
        if (this.c.U() == PageAnimationMode.VSCROLL || this.c.g()) {
            Rect c;
            gn X = this.c.X();
            if (X.e() && X.g().equals(this.A)) {
                c = X.c(UTools.getRect(new Rect(), this.e.getShowingPagesView(), X.d()));
            } else {
                c = new Rect(0, 0, 0, 0);
            }
            jsVar.b = c;
        }
        if (this.M != null && this.g.a(2)) {
            int d = this.M.d();
            ak c2 = this.h.c(this.h.m().a(d).a());
            this.h.a(c2);
            if (c2.e()) {
                jsVar.a = c2.g();
                jsVar.d = d;
            }
        }
    }

    protected av s() {
        return this.f.D().a;
    }

    protected final void a(boolean z) {
        this.e.a(z);
    }

    protected final void a(k kVar, m mVar) {
        if (kVar != null) {
            this.h.a(kVar);
        }
        if (mVar != null) {
            if (mVar.p) {
                this.e.setPagesFrameBackground(mVar.a.mutate());
            } else {
                this.e.setPagesFrameBackground(null);
            }
            E();
            this.h.a(mVar);
        }
    }

    protected final void t() {
        Object readingTheme;
        int pageWidth = this.c.o() ? this.e.getPageWidth() / 2 : this.e.getPageWidth();
        int pageHeight = this.e.getPageHeight();
        if (!(this.t != null && this.t.getWidth() == pageWidth && this.t.getHeight() == pageHeight && H())) {
            if (this.t != null) {
                this.t.recycle();
            }
            this.t = com.duokan.reader.common.bitmap.a.c(pageWidth, pageHeight, this.c.N() == ReadingTheme.THEME14 ? Config.ARGB_8888 : Config.RGB_565);
            this.u = "";
        }
        if (this.c.N() != ReadingTheme.CUSTOM) {
            readingTheme = this.c.N().toString();
        } else {
            readingTheme = this.c.N().toString() + this.c.O();
        }
        if (!TextUtils.equals(this.u, readingTheme)) {
            a(this.t);
            this.u = readingTheme;
        }
    }

    private boolean H() {
        ReadingTheme N = this.c.N();
        if (this.t == null) {
            return false;
        }
        if (this.t.getConfig() == Config.ARGB_8888 && N == ReadingTheme.THEME14) {
            return true;
        }
        if (this.t.getConfig() != Config.RGB_565 || N == ReadingTheme.THEME14) {
            return false;
        }
        return true;
    }

    protected final void a(Bitmap bitmap) {
        if (I || bitmap != null) {
            Canvas canvas = new Canvas(bitmap);
            Drawable u = u();
            u.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
            u.draw(canvas);
            if (this.c.N() == ReadingTheme.THEME14) {
                u = ReaderEnv.get().getOldPaperDrawable();
                u.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                u.setFilterBitmap(true);
                u.draw(canvas);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    protected final Drawable u() {
        ReadingTheme N = this.c.N();
        switch (ri.c[N.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return this.d.c(N);
            default:
                return new ColorDrawable(this.d.b(N));
        }
    }

    protected int v() {
        switch (ri.c[o().N().ordinal()]) {
            case 7:
                int P = o().P();
                return Color.rgb(((16711680 & P) >> 8) ^ 255, ((65280 & P) >> 4) ^ 255, (P & 255) ^ 255);
            case 8:
                return Color.rgb(170, 103, 14);
            case 9:
                return Color.rgb(231, 143, 64);
            case 10:
                return Color.rgb(227, 188, 68);
            case 11:
                return Color.rgb(216, 143, 40);
            case 12:
                return Color.rgb(183, 95, 9);
            case 13:
                return Color.rgb(249, 183, 7);
            case 14:
                return Color.rgb(194, 94, 14);
            case 15:
                return 0;
            default:
                return -16777216;
        }
    }

    protected final void w() {
        this.k.clear();
        x();
        y();
        File systemFontFileZh = ReaderEnv.get().getSystemFontFileZh();
        File systemFontFileEn = ReaderEnv.get().getSystemFontFileEn();
        Object V = this.d.V();
        if (this.f.ai()) {
            this.k.put("CUSTOM_FONT_EN", "");
        } else if (V.equals("FONT_URI_DEFAULT")) {
            this.k.put("CUSTOM_FONT_EN", "");
        } else {
            if (!new File(Uri.parse(V).getPath()).exists()) {
                V = Uri.fromFile(systemFontFileZh).toString();
            }
            this.k.put("CUSTOM_FONT_EN", V);
        }
        if (this.f.ai()) {
            V = this.d.W();
        } else {
            V = this.d.U();
        }
        if (V.equals("FONT_URI_DEFAULT")) {
            this.k.put("CUSTOM_FONT_ZH", "");
        } else {
            if (!new File(Uri.parse(V).getPath()).exists()) {
                V = Uri.fromFile(systemFontFileZh).toString();
            }
            this.k.put("CUSTOM_FONT_ZH", V);
        }
        this.k.put("DEFAULT_FONT_EN", Uri.fromFile(systemFontFileEn).toString());
        this.k.put("DEFAULT_FONT_ZH", Uri.fromFile(systemFontFileZh).toString());
        this.k.put("FALLBACK_FONT", Uri.fromFile(systemFontFileZh).toString());
    }

    protected final void x() {
        File kernelFontDirectory = ReaderEnv.get().getKernelFontDirectory();
        File file = new File(kernelFontDirectory, "Gentium Book Basic.ttf");
        if (file.exists()) {
            String uri = Uri.fromFile(file).toString();
            this.k.put("Palatino", uri);
            this.k.put("Gentium Book Basic", uri);
            this.k.put("DK-SERIF", uri);
        }
        file = new File(kernelFontDirectory, "Inconsolata.ttf");
        if (file.exists()) {
            uri = Uri.fromFile(file).toString();
            this.k.put("Inconsolata", uri);
            this.k.put("DK-CODE", uri);
        }
        file = new File(kernelFontDirectory, "dk-symbol.ttf");
        if (file.exists()) {
            uri = Uri.fromFile(file).toString();
            this.k.put("Symbol", uri);
            this.k.put("DK-SYMBOL", uri);
        }
        file = new File(kernelFontDirectory, "dk-math.ttc");
        if (file.exists()) {
            String uri2 = Uri.fromFile(file).toString();
            this.k.put("STIXGeneral", uri2);
            this.k.put("DK-MATH", uri2);
        }
    }

    protected final void y() {
        File userFontDirectory = ReaderEnv.get().getUserFontDirectory();
        File file = new File(userFontDirectory, "方正兰亭刊黑_GBK.ttf");
        if (file.exists()) {
            String uri = Uri.fromFile(file).toString();
            this.k.put("方正兰亭刊黑", uri);
            this.k.put("方正兰亭刊黑简体", uri);
            this.k.put("方正兰亭刊黑_GBK", uri);
            this.k.put("DK-XIHEITI", uri);
        }
        file = new File(userFontDirectory, "方正书宋_GBK.ttf");
        File file2 = new File(userFontDirectory, "方正宋三_GBK.ttf");
        File file3 = new File(userFontDirectory, "方正宋三简体.ttf");
        if (file.exists()) {
            uri = Uri.fromFile(file).toString();
            this.k.put("宋体", uri);
            this.k.put("方正宋三", uri);
            this.k.put("方正宋三简体", uri);
            this.k.put("方正宋三_GBK", uri);
            this.k.put("方正书宋", uri);
            this.k.put("方正书宋简体", uri);
            this.k.put("方正书宋_GBK", uri);
            this.k.put("DK-SONGTI", uri);
        } else if (file2.exists()) {
            uri = Uri.fromFile(file2).toString();
            this.k.put("宋体", uri);
            this.k.put("方正宋三", uri);
            this.k.put("方正宋三简体", uri);
            this.k.put("方正宋三_GBK", uri);
            this.k.put("方正书宋", uri);
            this.k.put("方正书宋简体", uri);
            this.k.put("方正书宋_GBK", uri);
            this.k.put("DK-SONGTI", uri);
        } else if (file3.exists()) {
            uri = Uri.fromFile(file3).toString();
            this.k.put("宋体", uri);
            this.k.put("方正宋三", uri);
            this.k.put("方正宋三简体", uri);
            this.k.put("方正宋三_GBK", uri);
            this.k.put("方正书宋", uri);
            this.k.put("方正书宋简体", uri);
            this.k.put("方正书宋_GBK", uri);
            this.k.put("DK-SONGTI", uri);
        }
        file = new File(userFontDirectory, "方正仿宋_GBK.ttf");
        if (file.exists()) {
            uri = Uri.fromFile(file).toString();
            this.k.put("仿宋", uri);
            this.k.put("华文仿宋", uri);
            this.k.put("方正仿宋", uri);
            this.k.put("方正仿宋简体", uri);
            this.k.put("方正仿宋_GBK", uri);
            this.k.put("DK-FANGSONG", uri);
        }
        file = new File(userFontDirectory, "方正楷体_GBK.ttf");
        file2 = new File(userFontDirectory, "华文楷体.ttf");
        if (file.exists()) {
            uri = Uri.fromFile(file).toString();
            this.k.put("楷体", uri);
            this.k.put("华文楷体", uri);
            this.k.put("方正楷体", uri);
            this.k.put("方正楷体简体", uri);
            this.k.put("方正楷体_GBK", uri);
            this.k.put("DK-KAITI", uri);
        } else if (file2.exists()) {
            uri = Uri.fromFile(file2).toString();
            this.k.put("楷体", uri);
            this.k.put("华文楷体", uri);
            this.k.put("方正楷体", uri);
            this.k.put("方正楷体简体", uri);
            this.k.put("方正楷体_GBK", uri);
            this.k.put("DK-KAITI", uri);
        }
        file = new File(userFontDirectory, "方正小标宋简体.ttf");
        file2 = new File(userFontDirectory, "方正小标宋_GBK.ttf");
        if (file2.exists()) {
            uri = Uri.fromFile(file2).toString();
            this.k.put("方正小标宋", uri);
            this.k.put("方正小标宋简体", uri);
            this.k.put("方正小标宋_GBK", uri);
            this.k.put("DK-XIAOBIAOSONG", uri);
        } else if (file.exists()) {
            uri = Uri.fromFile(file).toString();
            this.k.put("方正小标宋", uri);
            this.k.put("方正小标宋简体", uri);
            this.k.put("方正小标宋_GBK", uri);
            this.k.put("DK-XIAOBIAOSONG", uri);
        }
        file = new File(userFontDirectory, "方正中等线_GBK.ttf");
        if (file.exists()) {
            this.k.put("DK-DENGXIAN", Uri.fromFile(file).toString());
        }
        file2 = new File(ReaderEnv.get().getKernelFontDirectory(), "fzlth.ttf");
        file = new File(userFontDirectory, "fzlth_gbk.ttf");
        if (file.exists()) {
            String uri2 = Uri.fromFile(file).toString();
            this.k.put("黑体", uri2);
            this.k.put("方正兰亭黑", uri2);
            this.k.put("方正兰亭黑简体", uri2);
            this.k.put("方正兰亭黑_GBK", uri2);
            this.k.put("DK-HEITI", uri2);
            return;
        }
        uri2 = Uri.fromFile(file2).toString();
        this.k.put("黑体", uri2);
        this.k.put("方正兰亭黑", uri2);
        this.k.put("方正兰亭黑简体", uri2);
        this.k.put("方正兰亭黑_GBK", uri2);
        this.k.put("DK-HEITI", uri2);
    }

    private final ah I() {
        String str;
        CharSequence J = J();
        if (TextUtils.isEmpty(J)) {
            str = "";
        } else {
            CharSequence charSequence = J;
        }
        ah ahVar = (ah) com.duokan.reader.domain.bookshelf.a.c(null);
        ahVar.b(this.c.G().aF());
        ahVar.a(str);
        ahVar.a(this.c.Z().g());
        ahVar.b(this.c.Z().h());
        return ahVar;
    }

    private final String J() {
        String J = this.c.aa().J();
        if (J == null) {
            return null;
        }
        if (J.length() > 100) {
            return J.substring(0, 100);
        }
        return J;
    }

    private final void K() {
        A().setScreenTimeout(this.d.m());
    }

    private final void L() {
        A().setScreenBrightnessMode(this.c.E());
        A().setScreenBrightness(this.c.F());
    }

    private final void M() {
        A().setKeyboardBrightnessMode(BrightnessMode.MANUAL);
        A().setKeyboardBrightness(0.0f);
    }

    private final void N() {
        A().updateSystemUi(true);
    }

    protected final void z() {
        PageAnimationMode U = this.c.U();
        if (this.J != null) {
            this.J.a(U);
        }
    }

    private final void a(ak akVar, ak akVar2) {
        Iterator it = this.j.iterator();
        while (it.hasNext()) {
            ((tb) it.next()).a(this.c, akVar, akVar2);
        }
    }

    private final void b(int i, int i2) {
        Iterator it = this.j.iterator();
        while (it.hasNext()) {
            ((tb) it.next()).a(this.c, i, i2);
        }
    }

    private final void O() {
        if (this.c.b(1) && !ReaderEnv.get().getPrefBoolean(PrivatePref.READING, "reading_prompt_font", false) && this.f.ai() && b.b().d() && !this.f.l() && f.b().e() && ReaderEnv.get().getBookOpenTimes() > 50) {
            b.b().a(getActivity(), new qv(this));
        }
    }

    private void c(Runnable runnable) {
        if (this.f.k()) {
            ((ej) this.f).a(false, new ra(this, runnable), new rb(this, runnable));
            return;
        }
        com.duokan.reader.domain.store.a.a().a(this.f.H(), false, new qw(this, runnable));
    }

    private void a(DkStoreBookDetail dkStoreBookDetail) {
        this.G = dkStoreBookDetail;
        Object obj = null;
        if (TextUtils.equals(this.G.getBook().getBookUuid(), this.f.H()) && this.f.K() != this.G.getBook().getNewPrice()) {
            this.f.a(this.G.getBook().getNewPrice());
            obj = 1;
        }
        if (obj != null) {
            this.f.aL();
        }
        a((DkStoreItemDetail) dkStoreBookDetail);
    }

    private void a(DkStoreFictionDetail dkStoreFictionDetail) {
        this.H = dkStoreFictionDetail;
        if (Float.compare(this.H.getFiction().getSpecialPrice(), 0.0f) > 0) {
            this.f.a(new af());
        }
        a((DkStoreItemDetail) dkStoreFictionDetail);
    }

    private void a(DkStoreItemDetail dkStoreItemDetail) {
        View[] pageViews = this.e.getShowingPagesView().getPageViews();
        for (View view : pageViews) {
            gs gsVar = (gs) view;
            gsVar.setStatusColor(this.c.R());
            gsVar.c();
        }
    }

    private boolean P() {
        if (this.H != null) {
            DkStoreFiction fiction = this.H.getFiction();
            if (fiction.supportTip() && fiction.isOnSale()) {
                return true;
            }
            return false;
        } else if (this.G != null) {
            return this.G.getBook().supportTip();
        } else {
            return false;
        }
    }

    private boolean Q() {
        return this.f.ai() && (this.H == null || this.H.getFiction().isOnSale());
    }

    private void d(Runnable runnable) {
        ap apVar = new ap(getContext());
        apVar.setPrompt(j.reading__shared__add_to_bookshelf);
        apVar.setNoLabel(j.reading__shared__add_to_bookshelf_no);
        apVar.setOkLabel(j.reading__shared__add_to_bookshelf_ok);
        apVar.setCancelOnTouchOutside(false);
        apVar.open(new rc(this, runnable));
    }

    private void R() {
        ap apVar = new ap(getContext());
        apVar.setTitle(j.reading__login_mi_account);
        apVar.setPromptLayoutGravity(3);
        apVar.setNoLabel(j.reading__login_mi_account_no);
        apVar.setOkLabel(j.reading__login_mi_account_ok);
        apVar.setCancelOnTouchOutside(false);
        apVar.open(new rg(this));
    }

    protected ReaderFeature A() {
        return (ReaderFeature) getContext().queryFeature(ReaderFeature.class);
    }
}
