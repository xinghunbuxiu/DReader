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
import com.duokan.core.app.BrightnessMode;
import com.duokan.core.app.ApplicationsStateCallbacks;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.sys.IdleHandlerListener;
import com.duokan.core.sys.af;
import com.duokan.core.ui.cv;
import com.duokan.core.ui.AnimUtils;
import com.duokan.p024c.C0254f;
import com.duokan.p024c.C0258j;
import com.duokan.reader.DkApp;
import com.duokan.reader.EmptyReaderFeature;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.SystemUiConditioner;
import com.duokan.reader.SystemUiMode;
import com.duokan.reader.UmengManager;
import com.duokan.reader.common.bitmap.C0544a;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.common.p037c.C0563j;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.oauth.ThirdOAuth;
import com.duokan.reader.domain.account.oauth.ThirdYinxiang;
import com.duokan.reader.domain.account.oauth.TokenStore;
import com.duokan.reader.domain.bookshelf.BookFormat;
import com.duokan.reader.domain.bookshelf.BookLimitType;
import com.duokan.reader.domain.bookshelf.BookType;
import com.duokan.reader.domain.bookshelf.C0798a;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.C0837w;
import com.duokan.reader.domain.bookshelf.ah;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.ee;
import com.duokan.reader.domain.bookshelf.ke;
import com.duokan.reader.domain.bookshelf.kg;
import com.duokan.reader.domain.cloud.C0848h;
import com.duokan.reader.domain.cloud.DkUserPurchasedBooksManager;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.domain.document.C0808w;
import com.duokan.reader.domain.document.C0896a;
import com.duokan.reader.domain.document.C0901g;
import com.duokan.reader.domain.document.C0903n;
import com.duokan.reader.domain.document.C0917k;
import com.duokan.reader.domain.document.C0923m;
import com.duokan.reader.domain.document.aa;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.av;
import com.duokan.reader.domain.document.p045a.C0904d;
import com.duokan.reader.domain.p044b.C0781b;
import com.duokan.reader.domain.statistics.C1163a;
import com.duokan.reader.domain.statistics.dailystats.C1167a;
import com.duokan.reader.domain.store.C1176a;
import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.domain.store.DkStoreFiction;
import com.duokan.reader.domain.store.DkStoreFictionDetail;
import com.duokan.reader.domain.store.DkStoreItemDetail;
import com.duokan.reader.ui.C1367p;
import com.duokan.reader.ui.general.PagesView;
import com.duokan.reader.ui.general.ReaderUi;
import com.duokan.reader.ui.general.ReaderUi.ScreenType;
import com.duokan.reader.ui.general.ap;
import com.duokan.reader.ui.general.fx;
import com.duokan.reader.ui.general.gc;
import com.duokan.reader.ui.welcome.C1540p;
import com.duokan.reader.ui.welcome.DkTipManager.UserInput;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public abstract class qr extends C1367p implements SystemUiConditioner, C0563j, C0808w, xo {
    /* renamed from: I */
    static final /* synthetic */ boolean f9261I = (!qr.class.desiredAssertionStatus());
    /* renamed from: A */
    protected ak f9262A = null;
    /* renamed from: B */
    protected ak f9263B = null;
    /* renamed from: C */
    protected ak f9264C = null;
    /* renamed from: D */
    protected boolean f9265D = true;
    /* renamed from: E */
    protected int f9266E = 0;
    /* renamed from: F */
    protected int f9267F = 0;
    /* renamed from: G */
    protected DkStoreBookDetail f9268G = null;
    /* renamed from: H */
    protected DkStoreFictionDetail f9269H = null;
    /* renamed from: J */
    private sv f9270J = null;
    /* renamed from: K */
    private adz f9271K = null;
    /* renamed from: L */
    private aq f9272L = null;
    /* renamed from: M */
    private cq f9273M = null;
    /* renamed from: N */
    private C0837w f9274N = null;
    /* renamed from: O */
    private ApplicationsStateCallbacks f9275O = null;
    /* renamed from: P */
    private Callback f9276P = new qs(this);
    /* renamed from: a */
    private IdleHandlerListener f9277a = null;
    /* renamed from: b */
    private final C1446a f9278b = new C1446a();
    /* renamed from: c */
    protected final si f9279c;
    /* renamed from: d */
    protected final ReadingPrefs f9280d;
    /* renamed from: e */
    protected final wy f9281e;
    /* renamed from: f */
    protected final C0800c f9282f;
    /* renamed from: g */
    protected final uk f9283g = new uk();
    /* renamed from: h */
    protected final C0903n f9284h;
    /* renamed from: i */
    protected final fx f9285i;
    /* renamed from: j */
    protected final LinkedList<to> f9286j = new LinkedList();
    /* renamed from: k */
    protected final LinkedHashMap<String, String> f9287k = new LinkedHashMap();
    /* renamed from: l */
    protected final long f9288l;
    /* renamed from: m */
    protected long f9289m = 0;
    /* renamed from: n */
    protected int f9290n = 0;
    /* renamed from: o */
    protected boolean f9291o = false;
    /* renamed from: p */
    protected boolean f9292p = false;
    /* renamed from: q */
    protected boolean f9293q = false;
    /* renamed from: r */
    protected BookType f9294r;
    /* renamed from: s */
    protected BookLimitType f9295s;
    /* renamed from: t */
    protected Bitmap f9296t = null;
    /* renamed from: u */
    protected String f9297u = "";
    /* renamed from: v */
    protected C0896a f9298v = null;
    /* renamed from: w */
    protected boolean f9299w = false;
    /* renamed from: x */
    protected av f9300x = null;
    /* renamed from: y */
    protected ak f9301y = null;
    /* renamed from: z */
    protected ak f9302z = null;

    /* renamed from: a */
    protected abstract float mo2233a(ak akVar);

    /* renamed from: a */
    protected abstract ak mo2234a(C0901g c0901g);

    /* renamed from: c */
    protected abstract sv mo2235c();

    /* renamed from: d */
    protected abstract wy mo2236d();

    /* renamed from: e */
    protected abstract si mo2237e();

    /* renamed from: f */
    protected abstract C0917k mo2238f();

    /* renamed from: k */
    protected abstract C0923m mo2239k();

    /* renamed from: l */
    protected abstract void mo2240l();

    public qr(IFeature mFeature, C0800c c0800c, C0896a c0896a) {
        super(mFeature);
        C1167a.m8671d().m8680a();
        this.f9288l = System.currentTimeMillis();
        this.f9282f = c0800c;
        this.f9280d = new ReadingPrefs(getContext());
        this.f9279c = mo2237e();
        this.f9294r = this.f9282f.m4242o();
        this.f9295s = this.f9282f.m4243p();
        getContext().addFeatureListener(this.f9279c);
        getContext().registerGlobalFeature(this.f9279c);
        ai.m3980a().m3889a(this.f9279c);
        m12858w();
        this.f9281e = mo2236d();
        m11280a(this.f9281e);
        this.f9298v = c0896a;
        this.f9284h = this.f9282f.mo1026a(new rh(this), (C0808w) this);
        this.f9285i = new ru(this);
        m12780M();
        m12779L();
        mo2240l();
        m12778K();
        m12817A().switchEyesSavingMode(this.f9279c.aK());
        this.f9284h.m5906a(this.f9279c);
        this.f9281e.m13657g();
        this.f9281e.setStatusColor(this.f9279c.mo2001R());
        this.f9281e.setOnPageBroadcastListener(this.f9285i);
        this.f9281e.setOnCurrentPageChangeListener(new rv(this));
    }

    /* renamed from: n */
    public C0800c m12849n() {
        return this.f9282f;
    }

    /* renamed from: o */
    public su m12850o() {
        return this.f9279c;
    }

    /* renamed from: b */
    public boolean m12837b(Runnable runnable) {
        if (this.f9293q) {
            runnable.run();
            return false;
        }
        this.f9293q = true;
        m12817A().removeSystemUiConditioner(this);
        if (this.f9270J != null) {
            deactivate(this.f9270J);
        }
        if (this.f9271K != null) {
            deactivate(this.f9271K);
        }
        if (this.f9272L != null) {
            deactivate(this.f9272L);
        }
        if (this.f9273M != null) {
            deactivate(this.f9273M);
        }
        m11288h();
        ReaderFeature readerFeature = (ReaderFeature) getContext().queryFeature(ReaderFeature.class);
        if (this.f9292p) {
            Runnable rwVar = new rw(this, runnable);
            if (this.f9282f.aI() && !this.f9279c.bg() && m11287g() == 0) {
                m12803d(rwVar);
            } else {
                if (this.f9279c.bg()) {
                    UmengManager.get().onEvent("READING_ADD_BOOKB", "NO");
                }
                readerFeature.setQuitOnBack(true);
                rwVar.run();
            }
        } else {
            readerFeature.setQuitOnBack(true);
            if (runnable != null) {
                runnable.run();
            }
        }
        return true;
    }

    /* renamed from: p */
    public void m12851p() {
        if (this.f9292p) {
            mo1981b();
        }
        if (this.f9296t != null) {
            this.f9296t.recycle();
            this.f9296t = null;
            this.f9297u = "";
        }
    }

    public void chooseStatusBarStyle(af<Boolean> afVar) {
        afVar.mo975a(Boolean.valueOf(!this.f9279c.aJ()));
    }

    public void chooseNavigationBarMode(af<SystemUiMode> afVar) {
        if (getActivity().hasWindowFocus()) {
            afVar.mo975a(this.f9279c.an() ? SystemUiMode.DOCK : SystemUiMode.GONE);
        }
    }

    public void chooseNavigationBarColor(af<Integer> afVar) {
        if (this.f9279c.aH()) {
            afVar.mo975a(Integer.valueOf(-16777216));
        }
    }

    public boolean navigateSmoothly(String str) {
        return navigate(str, null, true, null);
    }

    public boolean navigate(String str, Object obj, boolean z, Runnable runnable) {
        if (TextUtils.isEmpty(str) || !str.equals("prefs/font")) {
            return false;
        }
        ActivatedController exVar = new ex(getContext(), true);
        if (z) {
            ((ReaderFeature) getContext().queryFeature(ReaderFeature.class)).pushHalfPageSmoothly(exVar, runnable);
        } else {
            ((ReaderFeature) getContext().queryFeature(ReaderFeature.class)).pushHalfPage(exVar);
            AnimUtils.m1921a(exVar.getContentView(), runnable);
        }
        return true;
    }

    /* renamed from: e */
    public void mo1054e(C0903n c0903n) {
    }

    /* renamed from: f */
    public void mo1055f(C0903n c0903n) {
    }

    /* renamed from: a */
    public void mo1050a(C0903n c0903n, aa aaVar) {
    }

    /* renamed from: a */
    public void mo1049a(C0903n c0903n) {
        WebLog.init().m762a(this.f9284h.mo1448b());
        runAfterActive(new ry(this));
    }

    /* renamed from: b */
    public void mo1051b(C0903n c0903n) {
        runAfterActive(new sb(this));
    }

    /* renamed from: c */
    public void mo1052c(C0903n c0903n) {
    }

    /* renamed from: d */
    public void mo1053d(C0903n c0903n) {
    }

    public void onConnectivityChanged(C0559f c0559f) {
    }

    protected void onTrimMemory(int i) {
        if (i >= 40) {
            PagesView showingPagesView = this.f9281e.getShowingPagesView();
            if (showingPagesView != null) {
                View[] pageViews = showingPagesView.getPageViews();
                for (View view : pageViews) {
                    as pageDrawable = ((gx) view).getPageDrawable();
                    if (pageDrawable != null) {
                        pageDrawable.mo1298a(true);
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
        m12817A().addSystemUiConditioner(this);
        m12781N();
        this.f9275O = new sc(this);
        DkApp.get().addOnRunningStateChangedListener(this.f9275O);
        C0559f.m2476b().m2481a((C0563j) this);
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        ai.m3980a().m3912b(this.f9279c);
        getContext().unregisterGlobalFeature(this.f9279c);
        C1167a.m8671d().m8676a(this.f9282f, 0, this.f9266E, this.f9267F);
        if (this.f9275O != null) {
            DkApp.get().removeOnRunningStateChangedListener(this.f9275O);
        }
        C0559f.m2476b().m2483b((C0563j) this);
    }

    protected void onActive(boolean z) {
        if (z) {
            C1163a.m8627k().m8642a("single_reading", 3);
            mo2462m();
        }
        this.f9289m = System.currentTimeMillis();
        this.f9290n = 0;
        C0848h.m5604a().m5616a(this.f9282f);
        if (C1167a.m8671d().m8680a()) {
            C1167a.m8671d().m8681b();
        }
    }

    protected void onDeactive() {
        if (this.f9293q) {
            m12817A().switchEyesSavingMode(false);
        }
        if (this.f9292p) {
            kg H = this.f9282f.m4155H();
            if (DkApp.get().forCommunity() && C0641o.m2934i().m2985l()) {
                H.f3453a += Math.max(0, System.currentTimeMillis() - this.f9289m) * 60;
            } else {
                H.f3453a += Math.min(System.currentTimeMillis() - this.f9289m, TimeUnit.MINUTES.toMillis(5) * ((long) this.f9290n));
            }
            H.f3454b += Math.round(((float) this.f9290n) * mo1978B());
            this.f9282f.m4191a(H);
            C0848h.m5604a().m5622b(this.f9282f);
            if (this.f9282f.m4251w()) {
                C1163a.m8627k().m8645a(this.f9282f.getId(), String.valueOf((System.currentTimeMillis() - this.f9289m) / 1000));
            }
            if (this.f9284h.m5945p()) {
                if (this.f9293q) {
                    this.f9281e.m13661k();
                } else {
                    m12774G();
                }
                if (C0709k.m3476a().m3507c() && PersonalPrefs.m5175a().m5249y()) {
                    this.f9282f.m4194a(this.f9300x);
                }
                if (!TextUtils.isEmpty(this.f9282f.m4162O())) {
                    m12787a(this.f9282f, this.f9284h);
                }
                if (this.f9282f.ak() && this.f9282f.m4242o() == BookType.NORMAL) {
                    DkUserPurchasedBooksManager.m5029a().m5069d(this.f9282f.getId());
                }
            }
        }
        this.f9282f.aN();
    }

    /* renamed from: q */
    public void mo1977q() {
        if (!this.f9293q) {
            m12825a(mo2238f(), mo2239k());
            this.f9281e.m13659i();
            if (this.f9292p) {
                if (this.f9270J != null) {
                    this.f9270J.mo2384o();
                }
                if (this.f9272L != null) {
                    this.f9272L.m13759g();
                }
            }
        }
    }

    /* renamed from: B */
    private float mo1978B() {
        Rect b = this.f9284h.mo1245k().m6084b();
        return ((float) Math.max(0, b.height() * b.width())) / ((float) (((double) (this.f9279c.mo1986A() * this.f9279c.mo1986A())) * this.f9279c.mo1987B()));
    }

    /* renamed from: a */
    private final void m12787a(C0800c c0800c, C0903n c0903n) {
        if (!ReaderEnv.get().getSyncEvernoteEnabled()) {
            return;
        }
        if ((ReaderEnv.get().getIsOnlyWifiSyncEvernote() && C0559f.m2476b().m2485d()) || !ReaderEnv.get().getIsOnlyWifiSyncEvernote()) {
            ThirdYinxiang thirdYinxiang;
            if (TokenStore.getInstance().isBindAccessToken(getContext(), "evernote")) {
                thirdYinxiang = (ThirdYinxiang) ThirdOAuth.produceThird(getActivity(), "evernote");
            } else {
                thirdYinxiang = (ThirdYinxiang) ThirdOAuth.produceThird(getActivity(), "yinxiang");
            }
            thirdYinxiang.queryAccount(new sd(this, c0800c, c0903n, thirdYinxiang));
        }
    }

    /* renamed from: C */
    private final void m12770C() {
        this.f9282f.m4193a(new qt(this));
    }

    /* renamed from: a */
    protected void mo1979a() {
        ReaderEnv.get().setReadingBookUuid(this.f9282f.getId());
        this.f9284h.mo1240h().mo1265a(this.f9282f.ay());
        this.f9281e.setLineDirection(this.f9284h.mo1228c());
        this.f9281e.getShowingDocPresenter().setAnnotations(m12849n().as());
        this.f9274N = new qy(this);
        m12849n().m4192a(this.f9274N);
        this.f9278b.m12757a(this.f9282f);
        this.f9280d.m12524r();
    }

    /* renamed from: r */
    protected void m12853r() {
        C0641o.m2934i().m2982j();
        this.f9281e.setOnScrollListener(new qz(this));
        this.f9270J = mo2235c();
        this.f9270J.mo2368a(this.f9279c.mo2004U());
        this.f9270J.mo2366a(this.f9285i);
        addSubController(this.f9270J);
        this.f9271K = new adz(getContext());
        this.f9281e.addView(this.f9271K.getContentView(), new LayoutParams(-1, -1));
        addSubController(this.f9271K);
        this.f9272L = new aq(getContext(), this.f9281e);
        this.f9281e.addView(this.f9272L.getContentView(), new LayoutParams(-1, -1));
        addSubController(this.f9272L);
        this.f9273M = new cq(getContext(), this.f9279c, this.f9281e);
        this.f9281e.getPagesFrameView().addView(this.f9273M.getContentView());
        addSubController(this.f9273M);
        this.f9279c.mo2021a(new ra(this));
        activate(this.f9273M);
        activate(this.f9271K);
        activate(this.f9270J);
        activate(this.f9272L);
        if (this.f9282f.ak()) {
            m12801c(new rb(this));
        } else {
            m12770C();
        }
        ReaderEnv.get().addBookOpenTimes();
        m12782O();
        if (this.f9282f.ak()) {
            ee eeVar = (ee) this.f9282f;
            long ba = eeVar.ba();
            if (this.f9282f.m4166S() && eeVar.aZ() && ba - System.currentTimeMillis() < 259200000) {
                String c = ReaderUi.m10166c(getContext(), ba);
                if (!TextUtils.isEmpty(c)) {
                    String str;
                    if (ba - System.currentTimeMillis() < 900000) {
                        str = c + "\n\n" + getString(C0258j.reading__shared__buy_to_read);
                    } else {
                        str = c;
                    }
                    ((ReaderFeature) getContext().queryFeature(ReaderFeature.class)).prompt(str, 1);
                }
            }
        }
        if (m12773F() >= 0) {
            this.f9273M.m13870b(m12773F());
        }
        if (this.f9284h instanceof C0904d) {
            if (this.f9279c.mo2145g()) {
                ((C1540p) getContext().queryFeature(C1540p.class)).mo2564a(getContext(), UserInput.READING_SHOW_OPTION);
            } else {
                ((C1540p) getContext().queryFeature(C1540p.class)).mo2564a(getContext(), UserInput.READING_FAST_OPERATION);
            }
        } else if (!this.f9282f.m4239l()) {
            ((C1540p) getContext().queryFeature(C1540p.class)).mo2564a(getContext(), UserInput.READING_FAST_OPERATION);
        }
        try {
            UmengManager.get().onEvent("READING_PAGE_ANIM_V1", this.f9280d.m12452M().name());
        } catch (Throwable th) {
        }
    }

    /* renamed from: b */
    protected void mo1981b() {
        if (this.f9271K != null) {
            removeSubController(this.f9271K);
        }
        if (this.f9272L != null) {
            removeSubController(this.f9272L);
        }
        this.f9281e.getShowingDocPresenter().mo2028a(null, null);
        this.f9284h.m5944o();
        if (this.f9270J != null) {
            deactivate(this.f9270J);
        }
        C0781b.m3667b().m3694g();
        this.f9284h.m5918b(this.f9279c);
        if (this.f9274N != null) {
            m12849n().m4210b(this.f9274N);
        }
    }

    /* renamed from: m */
    protected void mo2462m() {
        m12825a(mo2238f(), mo2239k());
        if (this.f9298v == null) {
            this.f9300x = m12854s();
        } else if (this.f9298v instanceof av) {
            this.f9300x = (av) this.f9298v;
        } else {
            this.f9300x = m12854s();
        }
        this.f9281e.getShowingDocPresenter().mo2028a(this.f9284h, this.f9300x);
    }

    /* renamed from: a */
    protected void m12821a(int i, int i2) {
        Animation alphaAnimation;
        if ((i2 & 8) == 8) {
            alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setFillBefore(true);
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setDuration(200);
            alphaAnimation.setAnimationListener(new rc(this));
            this.f9281e.getPagesFrameView().startAnimation(alphaAnimation);
        } else if ((i & 8) == 8) {
            alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(200);
            this.f9281e.getPagesFrameView().startAnimation(alphaAnimation);
            this.f9281e.getPagesFrameView().setForeground(null);
        }
        if (this.f9271K != null) {
            this.f9271K.m13445a(i, i2);
        }
    }

    /* renamed from: a */
    protected void mo1980a(gc gcVar) {
        if (this.f9270J != null) {
            this.f9270J.mo2367a(gcVar);
        }
    }

    /* renamed from: b */
    protected void mo2351b(gc gcVar) {
        this.f9290n++;
        if (this.f9262A == null) {
            C1167a.m8671d().m8681b();
        }
        if (!this.f9299w) {
            if (this.f9279c.mo2004U() == PageAnimationMode.VSCROLL || this.f9279c.mo2145g()) {
                Rect rect = this.f9282f.m4152E().f3446b;
                if (rect != null) {
                    this.f9281e.getShowingPagesView().getCurrentPagePresenter().mo1763a(rect);
                }
            }
            this.f9299w = true;
            C1163a.m8627k().m8660f();
            DkApp.get().setReadyToSee();
            if (this.f9282f.aI()) {
                this.f9279c.mo2034a(new rd(this));
            }
        }
        this.f9262A = this.f9301y;
        gx gxVar = (gx) gcVar.mo2328d();
        as pageDrawable = gxVar.getPageDrawable();
        if (gxVar.mo2389a()) {
            gxVar.mo2390b();
        }
        if (pageDrawable.mo1281B() > 0) {
            ((C1540p) getContext().queryFeature(C1540p.class)).mo2564a(getContext(), UserInput.READING_SHOW_CARTOON);
        }
        this.f9281e.m13658h();
        this.f9279c.mo2034a(new re(this, gcVar));
    }

    /* renamed from: a */
    protected void mo2350a(gs gsVar, gs gsVar2) {
        if (f9261I || gsVar2 != null) {
            if (gsVar2.mo2329e()) {
                mo2351b((gc) gsVar2);
            }
            if ((this.f9282f.m4242o() == BookType.NORMAL || this.f9282f.m4166S()) && this.f9282f.m4154G() == 0 && this.f9279c.mo1995L() > 0 && gsVar != null && gsVar.mo2329e() && this.f9284h.mo1223b(gsVar.mo2331g()) + 1 >= Math.round(((double) this.f9279c.mo1995L()) * 0.95d)) {
                this.f9282f.m4223e(System.currentTimeMillis());
            }
            if (gsVar != null) {
                C0848h.m5604a().m5620b();
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    protected void m12830a(gs gsVar) {
    }

    /* renamed from: b */
    protected void m12836b(gs gsVar) {
        if (this.f9279c.mo2007X() == gsVar) {
            mo2351b((gc) gsVar);
        }
    }

    /* renamed from: a */
    protected void mo2348a(C0917k c0917k) {
        TypesettingStyle j = this.f9280d.m12514j();
        ScreenType l = ReaderUi.m10169l(getContext());
        switch (rt.f10914b[j.ordinal()]) {
            case 1:
                switch (rt.f10913a[l.ordinal()]) {
                    case 1:
                    case 2:
                        c0917k.f4336g = 1.6d;
                        c0917k.f4337h = 0.8d;
                        c0917k.f4338i = 2.0d;
                        break;
                    default:
                        c0917k.f4336g = 1.2d;
                        c0917k.f4337h = 0.4d;
                        c0917k.f4338i = 2.0d;
                        break;
                }
            case 2:
                switch (rt.f10913a[l.ordinal()]) {
                    case 1:
                    case 2:
                        c0917k.f4336g = 2.0d;
                        c0917k.f4337h = 2.0d;
                        c0917k.f4338i = 2.0d;
                        break;
                    default:
                        c0917k.f4336g = 1.6d;
                        c0917k.f4337h = 1.2d;
                        c0917k.f4338i = 2.0d;
                        break;
                }
            case 3:
                c0917k.f4336g = -1.0d;
                c0917k.f4337h = -1.0d;
                c0917k.f4338i = -1.0d;
                break;
            case 4:
                c0917k.f4336g = (double) this.f9280d.m12525s();
                c0917k.f4337h = (double) this.f9280d.m12526t();
                c0917k.f4338i = (double) this.f9280d.m12527u();
                break;
            default:
                switch (rt.f10913a[l.ordinal()]) {
                    case 1:
                    case 2:
                        c0917k.f4336g = 2.0d;
                        c0917k.f4337h = 1.0d;
                        c0917k.f4338i = 2.0d;
                        break;
                    default:
                        c0917k.f4336g = 1.6d;
                        c0917k.f4337h = 0.6d;
                        c0917k.f4338i = 2.0d;
                        break;
                }
        }
        c0917k.f4335f = this.f9280d.m12511i();
        c0917k.f4330a = this.f9279c.mo2167o() ? this.f9281e.getPageWidth() / 2 : this.f9281e.getPageWidth();
        c0917k.f4331b = this.f9281e.getPageHeight();
        c0917k.f4332c = this.f9279c.ab();
        c0917k.f4333d = this.f9279c.ac();
        c0917k.f4334e = this.f9279c.mo2004U() == PageAnimationMode.VSCROLL;
        c0917k.f4339j.putAll(this.f9287k);
        m12772E();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        if (this.f9279c.mo2145g()) {
            this.f9284h.m5903a(((displayMetrics.heightPixels * displayMetrics.widthPixels) * 2) * 6);
            return;
        }
        this.f9284h.m5903a(((c0917k.f4334e ? 4 : 2) * (displayMetrics.widthPixels * displayMetrics.heightPixels)) * 4);
    }

    /* renamed from: a */
    protected void mo2349a(C0923m c0923m) {
        boolean z = true;
        m12855t();
        if (this.f9270J != null) {
            this.f9270J.mo2363a(this.f9296t);
        }
        c0923m.f4355c = this.f9279c.k_();
        c0923m.f4357e = this.f9279c.mo2001R();
        c0923m.f4359g = m12857v();
        c0923m.f4358f = m12771D();
        c0923m.f4353a = new sh(this.f9296t);
        c0923m.f4354b = getResources().getDrawable(C0254f.reading__shared__pic_shadow_normal);
        boolean z2 = this.f9279c.mo2133d() && this.f9280d.m12455P();
        c0923m.f4363k = z2;
        if (ReaderUi.m10170m(getContext())) {
            z2 = this.f9279c.ao();
        } else {
            z2 = false;
        }
        c0923m.f4364l = z2;
        c0923m.f4365m = this.f9279c.ao();
        if (c0923m.f4355c != 0) {
            c0923m.f4361i = false;
            c0923m.f4362j = false;
        } else if (this.f9279c.mo1997N() == ReadingTheme.NIGHT) {
            c0923m.f4356d = Color.argb(255, Math.round(239.4737f), Math.round(236.8421f), Math.round(236.8421f));
            c0923m.f4361i = true;
            c0923m.f4362j = false;
        } else if (this.f9279c.mo1997N() == ReadingTheme.THEME12) {
            c0923m.f4356d = Color.argb(255, 53, 69, 81);
            c0923m.f4361i = true;
            c0923m.f4362j = false;
        } else if (this.f9279c.aJ()) {
            c0923m.f4361i = false;
            c0923m.f4362j = true;
        } else {
            c0923m.f4361i = false;
            c0923m.f4362j = false;
        }
        if (this.f9279c.mo2004U() != PageAnimationMode.VSCROLL) {
            z = false;
        }
        c0923m.f4368p = z;
    }

    /* renamed from: D */
    private int m12771D() {
        switch (rt.f10913a[ReaderUi.m10169l(getContext()).ordinal()]) {
            case 1:
            case 2:
                return (AnimUtils.m1963g(getContext(), 16.0f) / 2) * 2;
            case 3:
                return (AnimUtils.m1963g(getContext(), 12.0f) / 2) * 2;
            default:
                return (AnimUtils.m1963g(getContext(), 14.0f) / 2) * 2;
        }
    }

    /* renamed from: E */
    private void m12772E() {
        if (!this.f9293q) {
            cv.updateLayout();
        }
    }

    /* renamed from: F */
    private final int m12773F() {
        return this.f9282f.m4152E().f3448d;
    }

    /* renamed from: G */
    private void m12774G() {
        if (this.f9262A != null && this.f9279c.mo2007X() != null) {
            if (!(ReaderEnv.get().forHd() || this.f9282f.mo1039q() == BookFormat.PDF || this.f9282f.mo1039q() == BookFormat.SBK)) {
                this.f9280d.m12470a(this.f9279c.am() ? ReadingOrientation.LANDSCAPE : ReadingOrientation.PORTRAIT);
                this.f9280d.m12463X();
            }
            ke keVar = new ke();
            mo2461a(keVar);
            this.f9282f.m4190a(keVar);
            if (this.f9282f.mo1038k()) {
                ((ee) this.f9282f).bd();
            }
            this.f9282f.aN();
            if (!this.f9282f.aI()) {
            }
        }
    }

    /* renamed from: a */
    protected void mo2461a(ke keVar) {
        ak akVar = (ak) this.f9284h.mo1229c(this.f9262A);
        keVar.f3445a = akVar.mo1198g();
        keVar.f3449e = mo2233a(akVar);
        if (this.f9279c.mo2004U() == PageAnimationMode.VSCROLL || this.f9279c.mo2145g()) {
            Rect c;
            gs X = this.f9279c.mo2007X();
            if (X.mo2329e() && X.mo2331g().equals(this.f9262A)) {
                c = X.mo2326c(AnimUtils.m1904a(new Rect(), this.f9281e.getShowingPagesView(), X.mo2328d()));
            } else {
                c = new Rect(0, 0, 0, 0);
            }
            keVar.f3446b = c;
        }
        if (this.f9273M != null && this.f9283g.m15022a(2)) {
            int d = this.f9273M.mo2293d();
            ak c2 = this.f9284h.mo1230c(this.f9284h.mo1247m().mo1254a(d).mo1429a());
            this.f9284h.m5911a(c2);
            if (c2.mo1192e()) {
                keVar.f3445a = c2.mo1198g();
                keVar.f3448d = d;
            }
        }
    }

    /* renamed from: s */
    protected av m12854s() {
        return this.f9282f.m4152E().f3445a;
    }

    /* renamed from: a */
    protected final void m12832a(boolean z) {
        this.f9281e.m13651a(z);
    }

    /* renamed from: a */
    protected final void m12825a(C0917k c0917k, C0923m c0923m) {
        if (c0917k != null) {
            this.f9284h.mo1218a(c0917k);
        }
        if (c0923m != null) {
            if (c0923m.f4368p) {
                this.f9281e.setPagesFrameBackground(c0923m.f4353a.mutate());
            } else {
                this.f9281e.setPagesFrameBackground(null);
            }
            m12772E();
            this.f9284h.mo1220a(c0923m);
        }
    }

    /* renamed from: t */
    protected final void m12855t() {
        Object readingTheme;
        int pageWidth = this.f9279c.mo2167o() ? this.f9281e.getPageWidth() / 2 : this.f9281e.getPageWidth();
        int pageHeight = this.f9281e.getPageHeight();
        if (!(this.f9296t != null && this.f9296t.getWidth() == pageWidth && this.f9296t.getHeight() == pageHeight && m12775H())) {
            if (this.f9296t != null) {
                this.f9296t.recycle();
            }
            this.f9296t = C0544a.m2447c(pageWidth, pageHeight, this.f9279c.mo1997N() == ReadingTheme.THEME14 ? Config.ARGB_8888 : Config.RGB_565);
            this.f9297u = "";
        }
        if (this.f9279c.mo1997N() != ReadingTheme.CUSTOM) {
            readingTheme = this.f9279c.mo1997N().toString();
        } else {
            readingTheme = this.f9279c.mo1997N().toString() + this.f9279c.mo1998O();
        }
        if (!TextUtils.equals(this.f9297u, readingTheme)) {
            m12822a(this.f9296t);
            this.f9297u = readingTheme;
        }
    }

    /* renamed from: H */
    private boolean m12775H() {
        ReadingTheme N = this.f9279c.mo1997N();
        if (this.f9296t == null) {
            return false;
        }
        if (this.f9296t.getConfig() == Config.ARGB_8888 && N == ReadingTheme.THEME14) {
            return true;
        }
        if (this.f9296t.getConfig() != Config.RGB_565 || N == ReadingTheme.THEME14) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    protected final void m12822a(Bitmap bitmap) {
        if (f9261I || bitmap != null) {
            Canvas canvas = new Canvas(bitmap);
            Drawable u = m12856u();
            u.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
            u.draw(canvas);
            if (this.f9279c.mo1997N() == ReadingTheme.THEME14) {
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

    /* renamed from: u */
    protected final Drawable m12856u() {
        ReadingTheme N = this.f9279c.mo1997N();
        switch (rt.f10915c[N.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return this.f9280d.m12484c(N);
            default:
                return new ColorDrawable(this.f9280d.m12478b(N));
        }
    }

    /* renamed from: v */
    protected int m12857v() {
        switch (rt.f10915c[m12850o().mo1997N().ordinal()]) {
            case 7:
                int P = m12850o().mo1999P();
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

    /* renamed from: w */
    protected final void m12858w() {
        this.f9287k.clear();
        m12859x();
        m12860y();
        File systemFontFileZh = ReaderEnv.get().getSystemFontFileZh();
        File systemFontFileEn = ReaderEnv.get().getSystemFontFileEn();
        Object U = this.f9280d.m12460U();
        if (this.f9282f.ak()) {
            this.f9287k.put("CUSTOM_FONT_EN", "");
        } else if (U.equals("FONT_URI_DEFAULT")) {
            this.f9287k.put("CUSTOM_FONT_EN", "");
        } else {
            if (!new File(Uri.parse(U).getPath()).exists()) {
                U = Uri.fromFile(systemFontFileZh).toString();
            }
            this.f9287k.put("CUSTOM_FONT_EN", U);
        }
        if (this.f9282f.ak()) {
            U = this.f9280d.m12461V();
        } else {
            U = this.f9280d.m12459T();
        }
        if (U.equals("FONT_URI_DEFAULT")) {
            this.f9287k.put("CUSTOM_FONT_ZH", "");
        } else {
            if (!new File(Uri.parse(U).getPath()).exists()) {
                U = Uri.fromFile(systemFontFileZh).toString();
            }
            this.f9287k.put("CUSTOM_FONT_ZH", U);
        }
        this.f9287k.put("DEFAULT_FONT_EN", Uri.fromFile(systemFontFileEn).toString());
        this.f9287k.put("DEFAULT_FONT_ZH", Uri.fromFile(systemFontFileZh).toString());
        this.f9287k.put("FALLBACK_FONT", Uri.fromFile(systemFontFileZh).toString());
    }

    /* renamed from: x */
    protected final void m12859x() {
        File kernelFontDirectory = ReaderEnv.get().getKernelFontDirectory();
        File file = new File(kernelFontDirectory, "Gentium Book Basic.ttf");
        if (file.exists()) {
            String uri = Uri.fromFile(file).toString();
            this.f9287k.put("Palatino", uri);
            this.f9287k.put("Gentium Book Basic", uri);
            this.f9287k.put("DK-SERIF", uri);
        }
        file = new File(kernelFontDirectory, "Inconsolata.ttf");
        if (file.exists()) {
            uri = Uri.fromFile(file).toString();
            this.f9287k.put("Inconsolata", uri);
            this.f9287k.put("DK-CODE", uri);
        }
        file = new File(kernelFontDirectory, "dk-symbol.ttf");
        if (file.exists()) {
            uri = Uri.fromFile(file).toString();
            this.f9287k.put("Symbol", uri);
            this.f9287k.put("DK-SYMBOL", uri);
        }
        file = new File(kernelFontDirectory, "dk-math.ttc");
        if (file.exists()) {
            String uri2 = Uri.fromFile(file).toString();
            this.f9287k.put("STIXGeneral", uri2);
            this.f9287k.put("DK-MATH", uri2);
        }
    }

    /* renamed from: y */
    protected final void m12860y() {
        File userFontDirectory = ReaderEnv.get().getUserFontDirectory();
        File file = new File(userFontDirectory, "方正兰亭刊黑_GBK.ttf");
        if (file.exists()) {
            String uri = Uri.fromFile(file).toString();
            this.f9287k.put("方正兰亭刊黑", uri);
            this.f9287k.put("方正兰亭刊黑简体", uri);
            this.f9287k.put("方正兰亭刊黑_GBK", uri);
            this.f9287k.put("DK-XIHEITI", uri);
        }
        file = new File(userFontDirectory, "方正书宋_GBK.ttf");
        File file2 = new File(userFontDirectory, "方正宋三_GBK.ttf");
        File file3 = new File(userFontDirectory, "方正宋三简体.ttf");
        if (file.exists()) {
            uri = Uri.fromFile(file).toString();
            this.f9287k.put("宋体", uri);
            this.f9287k.put("方正宋三", uri);
            this.f9287k.put("方正宋三简体", uri);
            this.f9287k.put("方正宋三_GBK", uri);
            this.f9287k.put("方正书宋", uri);
            this.f9287k.put("方正书宋简体", uri);
            this.f9287k.put("方正书宋_GBK", uri);
            this.f9287k.put("DK-SONGTI", uri);
        } else if (file2.exists()) {
            uri = Uri.fromFile(file2).toString();
            this.f9287k.put("宋体", uri);
            this.f9287k.put("方正宋三", uri);
            this.f9287k.put("方正宋三简体", uri);
            this.f9287k.put("方正宋三_GBK", uri);
            this.f9287k.put("方正书宋", uri);
            this.f9287k.put("方正书宋简体", uri);
            this.f9287k.put("方正书宋_GBK", uri);
            this.f9287k.put("DK-SONGTI", uri);
        } else if (file3.exists()) {
            uri = Uri.fromFile(file3).toString();
            this.f9287k.put("宋体", uri);
            this.f9287k.put("方正宋三", uri);
            this.f9287k.put("方正宋三简体", uri);
            this.f9287k.put("方正宋三_GBK", uri);
            this.f9287k.put("方正书宋", uri);
            this.f9287k.put("方正书宋简体", uri);
            this.f9287k.put("方正书宋_GBK", uri);
            this.f9287k.put("DK-SONGTI", uri);
        }
        file = new File(userFontDirectory, "方正仿宋_GBK.ttf");
        if (file.exists()) {
            uri = Uri.fromFile(file).toString();
            this.f9287k.put("仿宋", uri);
            this.f9287k.put("华文仿宋", uri);
            this.f9287k.put("方正仿宋", uri);
            this.f9287k.put("方正仿宋简体", uri);
            this.f9287k.put("方正仿宋_GBK", uri);
            this.f9287k.put("DK-FANGSONG", uri);
        }
        file = new File(userFontDirectory, "方正楷体_GBK.ttf");
        file2 = new File(userFontDirectory, "华文楷体.ttf");
        if (file.exists()) {
            uri = Uri.fromFile(file).toString();
            this.f9287k.put("楷体", uri);
            this.f9287k.put("华文楷体", uri);
            this.f9287k.put("方正楷体", uri);
            this.f9287k.put("方正楷体简体", uri);
            this.f9287k.put("方正楷体_GBK", uri);
            this.f9287k.put("DK-KAITI", uri);
        } else if (file2.exists()) {
            uri = Uri.fromFile(file2).toString();
            this.f9287k.put("楷体", uri);
            this.f9287k.put("华文楷体", uri);
            this.f9287k.put("方正楷体", uri);
            this.f9287k.put("方正楷体简体", uri);
            this.f9287k.put("方正楷体_GBK", uri);
            this.f9287k.put("DK-KAITI", uri);
        }
        file = new File(userFontDirectory, "方正小标宋简体.ttf");
        file2 = new File(userFontDirectory, "方正小标宋_GBK.ttf");
        if (file2.exists()) {
            uri = Uri.fromFile(file2).toString();
            this.f9287k.put("方正小标宋", uri);
            this.f9287k.put("方正小标宋简体", uri);
            this.f9287k.put("方正小标宋_GBK", uri);
            this.f9287k.put("DK-XIAOBIAOSONG", uri);
        } else if (file.exists()) {
            uri = Uri.fromFile(file).toString();
            this.f9287k.put("方正小标宋", uri);
            this.f9287k.put("方正小标宋简体", uri);
            this.f9287k.put("方正小标宋_GBK", uri);
            this.f9287k.put("DK-XIAOBIAOSONG", uri);
        }
        file = new File(userFontDirectory, "方正中等线_GBK.ttf");
        if (file.exists()) {
            this.f9287k.put("DK-DENGXIAN", Uri.fromFile(file).toString());
        }
        file2 = new File(ReaderEnv.get().getKernelFontDirectory(), "fzlth.ttf");
        file = new File(userFontDirectory, "fzlth_gbk.ttf");
        if (file.exists()) {
            String uri2 = Uri.fromFile(file).toString();
            this.f9287k.put("黑体", uri2);
            this.f9287k.put("方正兰亭黑", uri2);
            this.f9287k.put("方正兰亭黑简体", uri2);
            this.f9287k.put("方正兰亭黑_GBK", uri2);
            this.f9287k.put("DK-HEITI", uri2);
            return;
        }
        uri2 = Uri.fromFile(file2).toString();
        this.f9287k.put("黑体", uri2);
        this.f9287k.put("方正兰亭黑", uri2);
        this.f9287k.put("方正兰亭黑简体", uri2);
        this.f9287k.put("方正兰亭黑_GBK", uri2);
        this.f9287k.put("DK-HEITI", uri2);
    }

    /* renamed from: I */
    private final ah m12776I() {
        String str;
        CharSequence J = m12777J();
        if (TextUtils.isEmpty(J)) {
            str = "";
        } else {
            CharSequence str2 = J;
        }
        ah ahVar = (ah) C0798a.m3712c(null);
        ahVar.m3721b(this.f9279c.mo1992G().aH());
        ahVar.m3719a(str2);
        ahVar.m3718a(this.f9279c.mo2009Z().mo1198g());
        ahVar.m3722b(this.f9279c.mo2009Z().mo1199h());
        return ahVar;
    }

    /* renamed from: J */
    private final String m12777J() {
        String I = this.f9279c.aa().mo1286I();
        if (I == null) {
            return null;
        }
        if (I.length() > 100) {
            return I.substring(0, 100);
        }
        return I;
    }

    /* renamed from: K */
    private final void m12778K() {
        m12817A().setScreenTimeout(this.f9280d.m12519m());
    }

    /* renamed from: L */
    private final void m12779L() {
        m12817A().setScreenBrightnessMode(this.f9279c.mo1990E());
        m12817A().setScreenBrightness(this.f9279c.mo1991F());
    }

    /* renamed from: M */
    private final void m12780M() {
        m12817A().setKeyboardBrightnessMode(BrightnessMode.MANUAL);
        m12817A().setKeyboardBrightness(0.0f);
    }

    /* renamed from: N */
    private final void m12781N() {
        m12817A().updateSystemUi(true);
    }

    /* renamed from: z */
    protected final void m12861z() {
        PageAnimationMode U = this.f9279c.mo2004U();
        if (this.f9270J != null) {
            this.f9270J.mo2368a(U);
        }
    }

    /* renamed from: a */
    private final void m12788a(ak akVar, ak akVar2) {
        Iterator it = this.f9286j.iterator();
        while (it.hasNext()) {
            ((to) it.next()).mo2199a(this.f9279c, akVar, akVar2);
        }
    }

    /* renamed from: b */
    private final void m12799b(int i, int i2) {
        Iterator it = this.f9286j.iterator();
        while (it.hasNext()) {
            ((to) it.next()).mo2198a(this.f9279c, i, i2);
        }
    }

    /* renamed from: O */
    private final void m12782O() {
        if (this.f9279c.mo2106b(1) && !ReaderEnv.get().getPrefBoolean(PrivatePref.READING, "reading_prompt_font", false) && this.f9282f.ak() && C0781b.m3667b().m3691d() && !this.f9282f.m4239l() && C0559f.m2476b().m2486e() && ReaderEnv.get().getBookOpenTimes() > 50) {
            C0781b.m3667b().m3685a(getActivity(), new rf(this));
        }
    }

    /* renamed from: c */
    private void m12801c(Runnable runnable) {
        if (this.f9282f.mo1038k()) {
            ((ee) this.f9282f).m4410a(false, new rk(this, runnable), new rl(this, runnable));
            return;
        }
        C1176a.m8695a().m8703a(this.f9282f.getId(), false, new rg(this, runnable));
    }

    /* renamed from: a */
    private void m12789a(DkStoreBookDetail dkStoreBookDetail) {
        this.f9268G = dkStoreBookDetail;
        Object obj = null;
        if (TextUtils.equals(this.f9268G.getBook().getBookUuid(), this.f9282f.getId()) && this.f9282f.m4159L() != this.f9268G.getBook().getNewPrice()) {
            this.f9282f.m4175a(this.f9268G.getBook().getNewPrice());
            obj = 1;
        }
        if (obj != null) {
            this.f9282f.aN();
        }
        m12791a((DkStoreItemDetail) dkStoreBookDetail);
    }

    /* renamed from: a */
    private void m12790a(DkStoreFictionDetail dkStoreFictionDetail) {
        this.f9269H = dkStoreFictionDetail;
        if (Float.compare(this.f9269H.getFiction().getSpecialPrice(), 0.0f) > 0) {
            this.f9282f.mo1009a(new af());
        }
        m12791a((DkStoreItemDetail) dkStoreFictionDetail);
    }

    /* renamed from: a */
    private void m12791a(DkStoreItemDetail dkStoreItemDetail) {
        View[] pageViews = this.f9281e.getShowingPagesView().getPageViews();
        for (View view : pageViews) {
            gx gxVar = (gx) view;
            gxVar.setStatusColor(this.f9279c.mo2001R());
            gxVar.m14297c();
        }
    }

    /* renamed from: P */
    private boolean m12783P() {
        if (this.f9269H != null) {
            DkStoreFiction fiction = this.f9269H.getFiction();
            if (fiction.supportTip() && fiction.isOnSale()) {
                return true;
            }
            return false;
        } else if (this.f9268G != null) {
            return this.f9268G.getBook().supportTip();
        } else {
            return false;
        }
    }

    /* renamed from: Q */
    private boolean m12784Q() {
        return this.f9282f.ak() && (this.f9269H == null || this.f9269H.getFiction().isOnSale());
    }

    /* renamed from: d */
    private void m12803d(Runnable runnable) {
        ap apVar = new ap(getContext());
        apVar.setPrompt(C0258j.reading__shared__add_to_bookshelf);
        apVar.setNoLabel(C0258j.reading__shared__add_to_bookshelf_no);
        apVar.setOkLabelResid(C0258j.reading__shared__add_to_bookshelf_ok);
        apVar.setCancelOnTouchOutside(false);
        apVar.open(new rn(this, new rm(this, runnable)));
    }

    /* renamed from: R */
    private void m12785R() {
        ap apVar = new ap(getContext());
        apVar.setTitle(C0258j.reading__login_mi_account);
        apVar.setPromptLayoutGravity(3);
        apVar.setNoLabel(C0258j.reading__login_mi_account_no);
        apVar.setOkLabelResid(C0258j.reading__login_mi_account_ok);
        apVar.setCancelOnTouchOutside(false);
        apVar.open(new rr(this));
    }

    /* renamed from: A */
    protected ReaderFeature m12817A() {
        ReaderFeature readerFeature = (ReaderFeature) getContext().queryFeature(ReaderFeature.class);
        if (readerFeature == null) {
            return EmptyReaderFeature.get();
        }
        return readerFeature;
    }
}
