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

import com.duokan.c.g;
import com.duokan.core.app.e;
import com.duokan.core.app.y;
import com.duokan.core.sys.af;
import com.duokan.core.ui.dv;
import com.duokan.core.ui.er;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.document.ab;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.au;
import com.duokan.reader.domain.document.z;
import com.duokan.reader.ui.account.ShareEntranceController;
import com.duokan.reader.ui.general.gd;
import com.duokan.reader.ui.general.gi;
import com.duokan.reader.ui.general.hd;
import com.duokan.reader.ui.reading.a.aa;
import com.duokan.reader.ui.reading.a.ad;
import com.duokan.reader.ui.reading.a.ag;
import com.duokan.reader.ui.reading.a.al;
import com.duokan.reader.ui.reading.a.ao;
import com.duokan.reader.ui.reading.a.j;
import com.duokan.reader.ui.reading.a.l;
import com.duokan.reader.ui.reading.a.o;
import com.duokan.reader.ui.reading.a.r;
import com.duokan.reader.ui.reading.a.u;
import com.duokan.reader.ui.welcome.DkTipManager.UserInput;
import com.duokan.reader.ui.welcome.p;

import miuipub.date.Calendar;

abstract class si extends hd {
    protected final sh a;
    protected final wl b;
    protected boolean c = false;
    protected boolean d = false;
    protected final hd e;
    protected final yb f;
    protected ai g = null;
    protected mx h = null;
    private final ss i;
    private final ls j;
    private final View k;
    private int l = -1;
    private int m = 0;
    private ShareEntranceController n = null;
    private TextSelectionController o = null;
    private aar p = null;

    protected abstract hd a();

    protected abstract View b();

    protected abstract View c();

    protected abstract View d();

    public si(y yVar, sh shVar, wl wlVar) {
        super(yVar);
        this.a = shVar;
        this.b = wlVar;
        this.k = this.b.findViewById(g.reading__reading_view__search_panel);
        this.e = a();
        this.f = new xz(getContext(), new sj(this));
        this.i = new ss();
        this.o = new TextSelectionController(yVar, this.a, this.b, this.i);
        this.j = new ls(getContext(), this.a, this.b);
        this.h = new mx(getContext(), this.b);
        this.g = new ai(yVar, this.a, this.b);
        a(new j(this.a));
        this.p = new aar(getContext(), this.a, this.b);
        a(new com.duokan.reader.ui.reading.a.g());
        a(new ag(this.h));
        a(new u(this.a, new bh(getContext(), this.a, this.b)));
        a(new al(this.a));
        a(new ad(this.a));
        a(new ao(this.a));
        a(new o(this.a));
        a(new aa(this.a));
        a(new l(this.a));
        a(new r(this.a));
        a(this.j.b());
        this.b.setReadingGestureListener(this.i);
        h();
        this.k.setOnClickListener(new sl(this));
        this.k.findViewById(g.reading__reading_view__search_prev).setOnClickListener(new sm(this));
        this.k.findViewById(g.reading__reading_view__show_search_bar).setOnClickListener(new sn(this));
        this.k.findViewById(g.reading__reading_view__search_next).setOnClickListener(new so(this));
    }

    public void a(gi giVar) {
    }

    public void o() {
        this.p.a();
    }

    public void a(gd gdVar) {
        this.p.a(gdVar);
    }

    public void a(PageAnimationMode pageAnimationMode) {
        this.p.a(pageAnimationMode);
        this.p.a(this.a.al());
    }

    public void a(Bitmap bitmap) {
        this.p.a(bitmap);
    }

    public boolean b(PointF pointF, Runnable runnable, Runnable runnable2) {
        return this.p.a(pointF, runnable, runnable2);
    }

    public boolean a(PointF pointF, Runnable runnable, Runnable runnable2) {
        return this.p.b(pointF, runnable, runnable2);
    }

    public void a(boolean z) {
        this.p.b(z);
    }

    public void n() {
        this.h.b();
    }

    public boolean m() {
        return this.h.a();
    }

    public void l() {
        this.h.c();
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f.a();
        } else {
            this.f.a(str);
        }
        if (isMenuShowing()) {
            requestHideMenu();
        }
        if (!this.f.isAttached()) {
            showPopup(this.f);
        }
    }

    public boolean k() {
        return isPopup(this.f);
    }

    public void a(er erVar) {
        this.b.a(erVar);
    }

    public er[] a(Class... clsArr) {
        return this.b.a(clsArr);
    }

    public void j() {
        this.h.d();
    }

    public void i() {
        if (this.h.a()) {
            this.h.c();
        } else {
            dismissAllPopups();
        }
    }

    public void h() {
        this.m++;
        if (this.m == 1) {
            this.b.getShowingPagesView().getScrollDetector().a(false);
        }
    }

    public void g() {
        this.m--;
        if (this.m == 0) {
            this.b.getShowingPagesView().getScrollDetector().a(true);
        }
    }

    public boolean f() {
        return this.m > 0;
    }

    public void a(au auVar, Rect rect) {
        this.i.a(auVar, rect);
    }

    public boolean e() {
        return this.i.b;
    }

    private void p() {
        z a = this.f.a(this.l);
        if (a != null) {
            this.a.a(a.a, DecorDrawableStyle.SELECTION_HIGHLIGHT_RECT);
            this.a.d(a.a);
        }
        this.k.setVisibility(0);
        dv.b(this.k, null);
        this.a.a(0, 128);
    }

    private void q() {
        z a = this.f.a(this.l);
        if (a != null) {
            this.a.b(a.a, DecorDrawableStyle.SELECTION_HIGHLIGHT_RECT);
        }
        this.k.setVisibility(8);
        dv.c(this.k, null);
        this.a.a(128, 0);
    }

    private boolean r() {
        return this.k.getVisibility() == 0;
    }

    private void a(View view, float f, float f2, long j, long j2) {
        if (view != null) {
            Animation alphaAnimation = new AlphaAnimation(f, f2);
            alphaAnimation.setDuration(j);
            alphaAnimation.setStartOffset(j2);
            view.startAnimation(alphaAnimation);
        }
    }

    protected void onActive(boolean z) {
        if (z) {
            addSubController(this.o);
            activate(this.o);
            addSubController(this.h);
            activate(this.h);
            addSubController(this.j);
            activate(this.j);
            addSubController(this.g);
            activate(this.g);
            addSubController(this.p);
            activate(this.p);
        }
        g();
    }

    protected void onDeactive() {
        h();
    }

    protected boolean onBack() {
        if (this.a.b(32)) {
            this.a.a(0, 32);
            return true;
        } else if (f()) {
            return true;
        } else {
            if (!r()) {
                return super.onBack();
            }
            q();
            return true;
        }
    }

    protected boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (f() || this.a.b(16)) {
            return false;
        }
        if (this.a.b(1)) {
            switch (i) {
                case 19:
                case 21:
                    this.a.a(null, null);
                    return true;
                case 20:
                case 22:
                    this.a.b(null, null);
                    return true;
                case 24:
                    if (!this.a.x()) {
                        return false;
                    }
                    this.a.a(null, null);
                    return true;
                case Calendar.FIELD_COUNT /*25*/:
                    if (!this.a.x()) {
                        return false;
                    }
                    this.a.b(null, null);
                    return true;
                default:
                    return false;
            }
        } else if (!this.a.b(2)) {
            return false;
        } else {
            switch (i) {
                case 19:
                case 21:
                    this.a.w().g();
                    return true;
                case 20:
                case 22:
                    this.a.w().h();
                    return true;
                case 24:
                    if (!this.a.x()) {
                        return false;
                    }
                    this.a.w().g();
                    return true;
                case Calendar.FIELD_COUNT /*25*/:
                    if (!this.a.x()) {
                        return false;
                    }
                    this.a.w().h();
                    return true;
                default:
                    return false;
            }
        }
    }

    @TargetApi(14)
    protected boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (f()) {
            return false;
        }
        switch (i) {
            case 24:
            case Calendar.FIELD_COUNT /*25*/:
                if (this.a.x()) {
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    protected boolean onShowMenu() {
        if (f() || getPopupCount() > 0 || this.h.a()) {
            return false;
        }
        if (!(this.a.g() || this.a.G().l())) {
            ((p) getContext().queryFeature(p.class)).a(getContext(), UserInput.READING_FAST_OPERATION);
        }
        this.c = true;
        showPopup(this.e);
        dv.e(c(), null);
        dv.d(b(), null);
        a(d(), 0.0f, 1.0f, 200, 200);
        if (this.e instanceof hq) {
            a(((hq) this.e).d(), 0.0f, 1.0f, 200, 200);
        } else if (this.e instanceof on) {
            a(((on) this.e).d(), 0.0f, 1.0f, 200, 200);
        }
        s();
        this.a.aU();
        return true;
    }

    protected boolean onHideMenu() {
        if (this.c && !this.d) {
            this.d = true;
            this.e.requestDetach();
        }
        return true;
    }

    protected boolean onCheckMenuShowing() {
        return this.c;
    }

    protected boolean onRequestDetach(e eVar) {
        if (!eVar.contains(this.e)) {
            return super.onRequestDetach(eVar);
        }
        if (this.e.getContentView().getAnimation() == null) {
            if (k() && ReaderEnv.get().forHd()) {
                dismissPopup(this.f);
            }
            this.a.aV();
            this.e.dismissAllPopups();
            d().setVisibility(4);
            if (this.e instanceof hq) {
                ((hq) this.e).d().setVisibility(4);
            } else if (this.e instanceof on) {
                ((on) this.e).d().setVisibility(4);
            }
            if (b().getVisibility() == 0) {
                dv.f(b(), null);
            }
            dv.g(c(), new sp(this));
        }
        return true;
    }

    private boolean a(Point point) {
        as aa = this.a.aa();
        for (int i = 0; i < aa.t(); i++) {
            ab e = aa.e(i);
            Rect rect = new Rect(aa.i(i));
            rect.inset(-20, -20);
            if (rect.contains(point.x, point.y)) {
                this.a.aU();
                a(new sq(this)).a(rect, e);
                return true;
            }
        }
        return false;
    }

    private void s() {
        getPopupWindow().setShowStatusBar(new af(Boolean.valueOf(true)));
    }

    private bb a(Runnable runnable) {
        switch (sr.a[this.a.getDocument().d().ordinal()]) {
            case 1:
                return new afe(getActivity(), this.a, runnable);
            case 2:
                return new bg(getActivity(), this.a, runnable);
            default:
                if (this.a.ae().N().equals(AnnotationStyle.BUBBLE)) {
                    return new afe(getActivity(), this.a, runnable);
                }
                return new bg(getActivity(), this.a, runnable);
        }
    }
}
