package com.duokan.reader.ui.reading;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.sys.af;
import com.duokan.core.ui.dv;
import com.duokan.core.ui.er;
import com.duokan.p024c.C0255g;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.UmengManager;
import com.duokan.reader.domain.document.C1013z;
import com.duokan.reader.domain.document.ab;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.au;
import com.duokan.reader.ui.account.ShareEntranceController;
import com.duokan.reader.ui.general.fx;
import com.duokan.reader.ui.general.gc;
import com.duokan.reader.ui.general.gs;
import com.duokan.reader.ui.reading.p054a.C1426g;
import com.duokan.reader.ui.reading.p054a.C1429j;
import com.duokan.reader.ui.reading.p054a.C1431l;
import com.duokan.reader.ui.reading.p054a.C1434o;
import com.duokan.reader.ui.reading.p054a.C1437r;
import com.duokan.reader.ui.reading.p054a.C1440u;
import com.duokan.reader.ui.reading.p054a.aa;
import com.duokan.reader.ui.reading.p054a.ad;
import com.duokan.reader.ui.reading.p054a.ag;
import com.duokan.reader.ui.reading.p054a.al;
import com.duokan.reader.ui.reading.p054a.ao;
import com.duokan.reader.ui.welcome.C1540p;
import com.duokan.reader.ui.welcome.DkTipManager.UserInput;
import miuipub.date.Calendar;

abstract class sv extends gs {
    /* renamed from: a */
    protected final su f9656a;
    /* renamed from: b */
    protected final wy f9657b;
    /* renamed from: c */
    protected boolean f9658c = false;
    /* renamed from: d */
    protected boolean f9659d = false;
    /* renamed from: e */
    protected final gs f9660e;
    /* renamed from: f */
    protected final yo f9661f;
    /* renamed from: g */
    protected ai f9662g = null;
    /* renamed from: h */
    protected nh f9663h = null;
    /* renamed from: i */
    private final tf f9664i;
    /* renamed from: j */
    private final mc f9665j;
    /* renamed from: k */
    private final View f9666k;
    /* renamed from: l */
    private int f9667l = -1;
    /* renamed from: m */
    private int f9668m = 0;
    /* renamed from: n */
    private ShareEntranceController f9669n = null;
    /* renamed from: o */
    private TextSelectionController f9670o = null;
    /* renamed from: p */
    private abe f9671p = null;

    /* renamed from: a */
    protected abstract gs mo2244a();

    /* renamed from: b */
    protected abstract View mo2245b();

    /* renamed from: c */
    protected abstract View mo2246c();

    /* renamed from: d */
    protected abstract View mo2247d();

    public sv(IFeature mFeature, su suVar, wy wyVar) {
        super(mFeature);
        this.f9656a = suVar;
        this.f9657b = wyVar;
        this.f9666k = this.f9657b.findViewById(C0255g.reading__reading_view__search_panel);
        this.f9660e = mo2244a();
        this.f9661f = new ym(getContext(), new sw(this));
        this.f9664i = new tf();
        this.f9670o = new TextSelectionController(mFeature, this.f9656a, this.f9657b, this.f9664i);
        this.f9665j = new mc(getContext(), this.f9656a, this.f9657b);
        this.f9663h = new nh(getContext(), this.f9657b);
        this.f9662g = new ai(mFeature, this.f9656a, this.f9657b);
        mo2364a(new C1429j(this.f9656a));
        this.f9671p = new abe(getContext(), this.f9656a, this.f9657b);
        mo2364a(new C1426g());
        mo2364a(new ag(this.f9663h));
        mo2364a(new C1440u(this.f9656a, new bh(getContext(), this.f9656a, this.f9657b)));
        mo2364a(new al(this.f9656a));
        mo2364a(new ad(this.f9656a));
        mo2364a(new ao(this.f9656a));
        mo2364a(new C1434o(this.f9656a));
        mo2364a(new aa(this.f9656a));
        mo2364a(new C1431l(this.f9656a));
        mo2364a(new C1437r(this.f9656a));
        mo2364a(this.f9665j.m14642b());
        this.f9657b.setReadingGestureListener(this.f9664i);
        mo2377h();
        this.f9666k.setOnClickListener(new sy(this));
        this.f9666k.findViewById(C0255g.reading__reading_view__search_prev).setOnClickListener(new sz(this));
        this.f9666k.findViewById(C0255g.reading__reading_view__show_search_bar).setOnClickListener(new ta(this));
        this.f9666k.findViewById(C0255g.reading__reading_view__search_next).setOnClickListener(new tb(this));
    }

    /* renamed from: a */
    public void mo2367a(gc gcVar) {
    }

    /* renamed from: o */
    public void mo2384o() {
        this.f9671p.m13233a();
    }

    /* renamed from: a */
    public void mo2366a(fx fxVar) {
        this.f9671p.m13235a(fxVar);
    }

    /* renamed from: a */
    public void mo2368a(PageAnimationMode pageAnimationMode) {
        this.f9671p.m13236a(pageAnimationMode);
        this.f9671p.m13237a(this.f9656a.al());
    }

    /* renamed from: a */
    public void mo2363a(Bitmap bitmap) {
        this.f9671p.m13234a(bitmap);
    }

    /* renamed from: b */
    public boolean mo2373b(PointF pointF, Runnable runnable, Runnable runnable2) {
        return this.f9671p.m13238a(pointF, runnable, runnable2);
    }

    /* renamed from: a */
    public boolean mo2371a(PointF pointF, Runnable runnable, Runnable runnable2) {
        return this.f9671p.m13240b(pointF, runnable, runnable2);
    }

    /* renamed from: a */
    public void mo2370a(boolean z) {
        this.f9671p.m13239b(z);
    }

    /* renamed from: n */
    public void mo2383n() {
        this.f9663h.m14744b();
    }

    /* renamed from: m */
    public boolean mo2382m() {
        return this.f9663h.m14743a();
    }

    /* renamed from: l */
    public void mo2381l() {
        this.f9663h.m14745c();
    }

    /* renamed from: a */
    public void mo2369a(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f9661f.m15179a();
        } else {
            this.f9661f.m15182a(str);
        }
        if (isMenuShowing()) {
            requestHideMenu();
        }
        if (!this.f9661f.isAttached()) {
            showPopup(this.f9661f);
        }
    }

    /* renamed from: k */
    public boolean mo2380k() {
        return isPopup(this.f9661f);
    }

    /* renamed from: a */
    public void mo2364a(er erVar) {
        this.f9657b.m13649a(erVar);
    }

    /* renamed from: a */
    public er[] mo2372a(Class<?>... clsArr) {
        return this.f9657b.m13652a((Class[]) clsArr);
    }

    /* renamed from: j */
    public void mo2379j() {
        this.f9663h.m14746d();
    }

    /* renamed from: i */
    public void mo2378i() {
        if (this.f9663h.m14743a()) {
            this.f9663h.m14745c();
        } else {
            dismissAllPopups();
        }
    }

    /* renamed from: h */
    public void mo2377h() {
        this.f9668m++;
        if (this.f9668m == 1) {
            this.f9657b.getShowingPagesView().getScrollDetector().m2043a(false);
        }
    }

    /* renamed from: g */
    public void mo2376g() {
        this.f9668m--;
        if (this.f9668m == 0) {
            this.f9657b.getShowingPagesView().getScrollDetector().m2043a(true);
        }
    }

    /* renamed from: f */
    public boolean mo2375f() {
        return this.f9668m > 0;
    }

    /* renamed from: a */
    public void mo2365a(au auVar, Rect rect) {
        this.f9664i.mo2496a(auVar, rect);
    }

    /* renamed from: e */
    public boolean mo2374e() {
        return this.f9664i.f10969b;
    }

    /* renamed from: p */
    private void m13562p() {
        C1013z a = this.f9661f.m15178a(this.f9667l);
        if (a != null) {
            this.f9656a.mo2026a(a.f5024a, DecorDrawableStyle.SELECTION_HIGHLIGHT_RECT);
            this.f9656a.mo2131d(a.f5024a);
        }
        this.f9666k.setVisibility(0);
        dv.showAnimation(this.f9666k, null);
        this.f9656a.mo2040a(0, 128);
    }

    /* renamed from: q */
    private void m13563q() {
        C1013z a = this.f9661f.m15178a(this.f9667l);
        if (a != null) {
            this.f9656a.mo2101b(a.f5024a, DecorDrawableStyle.SELECTION_HIGHLIGHT_RECT);
        }
        this.f9666k.setVisibility(8);
        dv.hideAnimation(this.f9666k, null);
        this.f9656a.mo2040a(128, 0);
    }

    /* renamed from: r */
    private boolean m13564r() {
        return this.f9666k.getVisibility() == 0;
    }

    /* renamed from: a */
    private void m13552a(View view, float f, float f2, long j, long j2) {
        if (view != null) {
            Animation alphaAnimation = new AlphaAnimation(f, f2);
            alphaAnimation.setDuration(j);
            alphaAnimation.setStartOffset(j2);
            view.startAnimation(alphaAnimation);
        }
    }

    protected void onActive(boolean z) {
        if (z) {
            addSubController(this.f9670o);
            activate(this.f9670o);
            addSubController(this.f9663h);
            activate(this.f9663h);
            addSubController(this.f9665j);
            activate(this.f9665j);
            addSubController(this.f9662g);
            activate(this.f9662g);
            addSubController(this.f9671p);
            activate(this.f9671p);
        }
        mo2376g();
    }

    protected void onDeactive() {
        mo2377h();
    }

    protected boolean onBack() {
        if (this.f9656a.mo2106b(32)) {
            this.f9656a.mo2040a(0, 32);
            return true;
        } else if (mo2375f()) {
            return true;
        } else {
            if (!m13564r()) {
                return super.onBack();
            }
            m13563q();
            return true;
        }
    }

    protected boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (mo2375f() || this.f9656a.mo2106b(16)) {
            return false;
        }
        if (this.f9656a.mo2106b(1)) {
            switch (i) {
                case 19:
                case 21:
                    this.f9656a.mo2035a(null, null);
                    return true;
                case 20:
                case 22:
                    this.f9656a.mo2104b(null, null);
                    return true;
                case 24:
                    if (!this.f9656a.mo2182x()) {
                        return false;
                    }
                    this.f9656a.mo2035a(null, null);
                    return true;
                case Calendar.FIELD_COUNT /*25*/:
                    if (!this.f9656a.mo2182x()) {
                        return false;
                    }
                    this.f9656a.mo2104b(null, null);
                    return true;
                default:
                    return false;
            }
        } else if (!this.f9656a.mo2106b(2)) {
            return false;
        } else {
            switch (i) {
                case 19:
                case 21:
                    this.f9656a.mo2181w().mo2296g();
                    return true;
                case 20:
                case 22:
                    this.f9656a.mo2181w().mo2297h();
                    return true;
                case 24:
                    if (!this.f9656a.mo2182x()) {
                        return false;
                    }
                    this.f9656a.mo2181w().mo2296g();
                    return true;
                case Calendar.FIELD_COUNT /*25*/:
                    if (!this.f9656a.mo2182x()) {
                        return false;
                    }
                    this.f9656a.mo2181w().mo2297h();
                    return true;
                default:
                    return false;
            }
        }
    }

    @TargetApi(14)
    protected boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (mo2375f()) {
            return false;
        }
        switch (i) {
            case 24:
            case Calendar.FIELD_COUNT /*25*/:
                if (this.f9656a.mo2182x()) {
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    protected boolean onShowMenu() {
        if (mo2375f() || getPopupCount() > 0 || this.f9663h.m14743a()) {
            return false;
        }
        if (!(this.f9656a.mo2145g() || this.f9656a.mo1992G().m4239l())) {
            ((C1540p) getContext().queryFeature(C1540p.class)).mo2564a(getContext(), UserInput.READING_FAST_OPERATION);
        }
        this.f9658c = true;
        showPopup(this.f9660e);
        UmengManager.get().onEvent("V2_READING_MENU", "Expose");
        dv.m1958e(mo2246c(), null);
        dv.m1954d(mo2245b(), null);
        m13552a(mo2247d(), 0.0f, 1.0f, 200, 200);
        if (this.f9660e instanceof ia) {
            m13552a(((ia) this.f9660e).mo2385d(), 0.0f, 1.0f, 200, 200);
        } else if (this.f9660e instanceof ox) {
            m13552a(((ox) this.f9660e).mo2385d(), 0.0f, 1.0f, 200, 200);
        }
        m13565s();
        this.f9656a.aU();
        return true;
    }

    protected boolean onHideMenu() {
        if (this.f9658c && !this.f9659d) {
            this.f9659d = true;
            this.f9660e.requestDetach();
        }
        return true;
    }

    protected boolean onCheckMenuShowing() {
        return this.f9658c;
    }

    protected boolean onRequestDetach(ActivatedController c0303e) {
        if (!c0303e.contains(this.f9660e)) {
            return super.onRequestDetach(c0303e);
        }
        if (this.f9660e.getContentView().getAnimation() == null) {
            if (mo2380k() && ReaderEnv.get().forHd()) {
                dismissPopup(this.f9661f);
            }
            this.f9656a.aV();
            this.f9660e.dismissAllPopups();
            mo2247d().setVisibility(4);
            if (this.f9660e instanceof ia) {
                ((ia) this.f9660e).mo2385d().setVisibility(4);
            } else if (this.f9660e instanceof ox) {
                ((ox) this.f9660e).mo2385d().setVisibility(4);
            }
            if (mo2245b().getVisibility() == 0) {
                dv.m1961f(mo2245b(), null);
            }
            dv.loadSuccess(mo2246c(), new tc(this));
        }
        return true;
    }

    /* renamed from: a */
    private boolean m13554a(Point point) {
        as aa = this.f9656a.aa();
        for (int i = 0; i < aa.mo1347t(); i++) {
            ab e = aa.mo1315e(i);
            Rect rect = new Rect(aa.mo1326i(i));
            rect.inset(-20, -20);
            if (rect.contains(point.x, point.y)) {
                this.f9656a.aU();
                m13551a(new td(this)).mo2262a(rect, e);
                return true;
            }
        }
        return false;
    }

    /* renamed from: s */
    private void m13565s() {
        getPopupWindow().setShowStatusBar(new af(Boolean.valueOf(true)));
    }

    /* renamed from: a */
    private bb m13551a(Runnable runnable) {
        switch (te.f10967a[this.f9656a.getDocument().mo1231d().ordinal()]) {
            case 1:
                return new age(getActivity(), this.f9656a, runnable);
            case 2:
                return new bg(getActivity(), this.f9656a, runnable);
            default:
                if (this.f9656a.ae().m12453N().equals(AnnotationStyle.BUBBLE)) {
                    return new age(getActivity(), this.f9656a, runnable);
                }
                return new bg(getActivity(), this.f9656a, runnable);
        }
    }
}
