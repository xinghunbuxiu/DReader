package com.duokan.reader.ui.reading;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.sys.UThread;
import com.duokan.core.sys.af;
import com.duokan.core.ui.AnimUtils;
import com.duokan.core.ui.et;
import com.duokan.p024c.C0254f;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.SystemUiConditioner;
import com.duokan.reader.SystemUiMode;
import com.duokan.reader.common.bitmap.C0544a;
import com.duokan.reader.domain.document.C0941i;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.epub.C0940h;
import com.duokan.reader.ui.general.gs;

public class aq extends gs implements SystemUiConditioner {
    /* renamed from: a */
    private final su f9782a = ((su) getContext().queryFeature(su.class));
    /* renamed from: b */
    private final ReaderFeature f9783b = ((ReaderFeature) getContext().queryFeature(ReaderFeature.class));
    /* renamed from: c */
    private final FrameLayout f9784c;
    /* renamed from: d */
    private final az f9785d;
    /* renamed from: e */
    private final ax f9786e;
    /* renamed from: f */
    private final wy f9787f;
    /* renamed from: g */
    private final et f9788g;
    /* renamed from: h */
    private final Drawable f9789h;
    /* renamed from: i */
    private final int f9790i;
    /* renamed from: j */
    private final int f9791j;
    /* renamed from: k */
    private boolean f9792k = false;
    /* renamed from: l */
    private Bitmap f9793l = null;
    /* renamed from: m */
    private boolean f9794m = false;
    /* renamed from: n */
    private boolean f9795n = false;
    /* renamed from: o */
    private boolean f9796o = false;
    /* renamed from: p */
    private boolean f9797p = false;
    /* renamed from: q */
    private boolean f9798q = false;
    /* renamed from: r */
    private int f9799r = 0;
    /* renamed from: s */
    private float f9800s = 0.0f;
    /* renamed from: t */
    private float f9801t;
    /* renamed from: u */
    private ActivatedController f9802u = null;

    public aq(IFeature mFeature, wy wyVar) {
        super(mFeature);
        this.f9787f = wyVar;
        this.f9785d = new az();
        this.f9786e = new ax();
        this.f9790i = this.f9782a.ab().top + this.f9782a.ac().top;
        this.f9791j = this.f9782a.ab().bottom + this.f9782a.ac().bottom;
        this.f9801t = (float) this.f9790i;
        this.f9789h = getDrawable(C0254f.reading__auto_pagedown_view__line);
        this.f9784c = new ar(this, getContext());
        this.f9784c.setWillNotDraw(false);
        this.f9784c.setVisibility(4);
        setContentView(this.f9784c);
        this.f9788g = new et();
        this.f9788g.m2041a(this.f9785d);
        this.f9788g.m2041a(this.f9786e);
        this.f9788g.m2046b(this.f9784c);
    }

    /* renamed from: a */
    protected void m13753a(Canvas canvas) {
        canvas.save();
        if (this.f9796o) {
            if (this.f9799r == 0) {
                canvas.clipRect(0.0f, this.f9801t, (float) (this.f9793l.getWidth() / 2), (float) this.f9793l.getHeight());
                canvas.clipRect((float) (this.f9793l.getWidth() / 2), 0.0f, (float) this.f9793l.getWidth(), (float) this.f9793l.getHeight(), Op.UNION);
            } else {
                canvas.clipRect(0, this.f9793l.getHeight(), this.f9793l.getWidth() / 2, this.f9793l.getHeight());
                canvas.clipRect((float) (this.f9793l.getWidth() / 2), this.f9801t, (float) this.f9793l.getWidth(), (float) this.f9793l.getHeight(), Op.UNION);
            }
            canvas.drawBitmap(this.f9793l, 0.0f, 0.0f, null);
            canvas.restore();
            if (this.f9801t < ((float) (this.f9793l.getHeight() - this.f9791j)) && this.f9801t > ((float) (this.f9790i - 1))) {
                if (this.f9799r == 0) {
                    this.f9789h.setBounds(0, (int) this.f9801t, this.f9793l.getWidth() / 2, ((int) this.f9801t) + this.f9789h.getIntrinsicHeight());
                    this.f9789h.draw(canvas);
                    return;
                }
                this.f9789h.setBounds(this.f9793l.getWidth() / 2, (int) this.f9801t, this.f9793l.getWidth(), ((int) this.f9801t) + this.f9789h.getIntrinsicHeight());
                this.f9789h.draw(canvas);
                return;
            }
            return;
        }
        canvas.clipRect(0.0f, this.f9801t, (float) this.f9793l.getWidth(), (float) this.f9793l.getHeight());
        canvas.drawBitmap(this.f9793l, 0.0f, 0.0f, null);
        canvas.restore();
        if (this.f9801t < ((float) (this.f9793l.getHeight() - this.f9791j)) && this.f9801t > ((float) (this.f9790i - 1))) {
            this.f9789h.setBounds(0, (int) this.f9801t, this.f9793l.getWidth(), ((int) this.f9801t) + this.f9789h.getIntrinsicHeight());
            this.f9789h.draw(canvas);
        }
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        ((ReaderFeature) getContext().queryFeature(ReaderFeature.class)).addSystemUiConditioner(this);
        if (this.f9795n) {
            m13758f();
            this.f9795n = false;
        }
    }

    protected void onDeactive() {
        ((ReaderFeature) getContext().queryFeature(ReaderFeature.class)).removeSystemUiConditioner(this);
        if (!this.f9794m) {
            m13757e();
            this.f9795n = true;
        }
        super.onDeactive();
    }

    public void chooseStatusBarStyle(af<Boolean> afVar) {
    }

    public void chooseNavigationBarMode(af<SystemUiMode> afVar) {
    }

    public void chooseNavigationBarColor(af<Integer> afVar) {
        if (isActive() && this.f9802u != null) {
            afVar.mo975a(Integer.valueOf(-16777216));
        }
    }

    protected boolean onBack() {
        if (super.onBack()) {
            return true;
        }
        if (!m13756d()) {
            return false;
        }
        m13754b();
        return true;
    }

    protected boolean onShowMenu() {
        if (!m13756d() || this.f9802u != null) {
            return false;
        }
        this.f9802u = new al(getContext());
        showPopup(this.f9802u);
        AnimUtils.showAnimation(this.f9802u.getContentView(), null);
        return true;
    }

    protected boolean onHideMenu() {
        if (this.f9802u == null) {
            return false;
        }
        this.f9802u.requestDetach();
        return true;
    }

    protected boolean onCheckMenuShowing() {
        return this.f9802u != null;
    }

    protected boolean onRequestDetach(ActivatedController c0303e) {
        if (!c0303e.contains(this.f9802u)) {
            return super.onRequestDetach(c0303e);
        }
        if (this.f9802u.getContentView().getAnimation() == null) {
            AnimUtils.hideAnimation(this.f9802u.getContentView(), new as(this));
        }
        return true;
    }

    /* renamed from: a */
    public void m13751a() {
        if (!m13756d()) {
            if (this.f9782a.mo2139e(this.f9782a.aa().mo1332l())) {
                this.f9782a.mo2180v().prompt(getString(C0258j.reading__shared__reach_last_page));
                return;
            }
            this.f9792k = true;
            this.f9783b.setScreenTimeout(Integer.MAX_VALUE);
            this.f9782a.mo2040a(1, 4);
            this.f9782a.mo2040a(1, 8);
            this.f9782a.mo2156i();
            m13752a(this.f9782a.ae().m12458S());
            if (this.f9782a.mo2004U() != PageAnimationMode.VSCROLL) {
                this.f9796o = this.f9782a.aa() instanceof C0941i;
                if (this.f9793l != null) {
                    this.f9793l.recycle();
                }
                this.f9793l = C0544a.m2438a(this.f9782a.mo2007X().mo2328d());
                this.f9784c.setVisibility(0);
                this.f9782a.mo2179u();
            }
            this.f9782a.mo2103b(new at(this));
        }
    }

    /* renamed from: b */
    public void m13754b() {
        if (m13756d()) {
            m13755c();
            if (this.f9782a.mo2004U() != PageAnimationMode.VSCROLL) {
                this.f9782a.mo2178t();
            }
        }
    }

    /* renamed from: c */
    public void m13755c() {
        if (m13756d()) {
            if (this.f9802u != null) {
                this.f9802u.requestDetach();
            }
            this.f9792k = false;
            this.f9794m = false;
            this.f9795n = false;
            this.f9796o = false;
            this.f9797p = false;
            this.f9798q = false;
            this.f9799r = 0;
            this.f9796o = false;
            if (this.f9793l != null) {
                this.f9793l.recycle();
                this.f9793l = null;
            }
            this.f9801t = (float) this.f9790i;
            this.f9783b.setScreenTimeout(this.f9782a.ae().m12519m());
            this.f9784c.setVisibility(4);
        }
    }

    /* renamed from: d */
    public boolean m13756d() {
        return this.f9792k;
    }

    /* renamed from: e */
    public void m13757e() {
        this.f9794m = true;
    }

    /* renamed from: f */
    public void m13758f() {
        this.f9794m = false;
    }

    /* renamed from: a */
    public void m13752a(int i) {
        this.f9800s = m13736b(i);
    }

    /* renamed from: h */
    private void m13745h() {
        if (m13756d()) {
            if (this.f9782a.mo2004U() == PageAnimationMode.VSCROLL) {
                if (!(this.f9794m || this.f9782a.bi() || this.f9782a.mo2169q())) {
                    this.f9782a.scrollBy(0, (int) this.f9800s);
                }
            } else if (this.f9801t >= ((float) (this.f9793l.getHeight() - this.f9791j))) {
                m13748j();
            } else if (!this.f9794m) {
                this.f9801t += this.f9800s;
                this.f9784c.invalidate();
            }
            UThread.postDelayed(new au(this), 20);
        }
    }

    /* renamed from: i */
    private void m13747i() {
        if (this.f9796o && this.f9799r == 1) {
            this.f9799r = 0;
            this.f9801t = (float) ((this.f9793l.getHeight() - this.f9791j) - 1);
            this.f9784c.invalidate();
        } else if (!this.f9797p) {
            this.f9797p = true;
            this.f9782a.mo2178t();
            ak Z = this.f9782a.mo2009Z();
            if (Z instanceof C0940h) {
                Z = ((C0940h) Z).m6847k();
            }
            if (this.f9782a.mo2135d(Z)) {
                this.f9801t = (float) this.f9790i;
                this.f9784c.invalidate();
                this.f9782a.mo2179u();
                this.f9797p = false;
                this.f9782a.mo2180v().prompt(getString(C0258j.reading__shared__reach_first_page));
                return;
            }
            this.f9782a.mo2103b(new av(this));
        }
    }

    /* renamed from: j */
    private void m13748j() {
        if (this.f9796o && this.f9799r == 0) {
            this.f9799r++;
            this.f9801t = (float) this.f9790i;
            this.f9784c.invalidate();
        } else if (this.f9782a.mo2139e(this.f9782a.aa().mo1332l())) {
            this.f9782a.mo2180v().prompt(getString(C0258j.reading__shared__reach_last_page));
            m13755c();
        } else if (!this.f9798q) {
            this.f9798q = true;
            this.f9782a.mo2103b(new aw(this));
        }
    }

    /* renamed from: b */
    private float m13736b(int i) {
        return ((float) ((((double) (((((float) i) / ((float) (((((this.f9782a.getDocument().mo1245k().f4330a - this.f9782a.ab().left) - this.f9782a.ab().right) - this.f9782a.ac().left) - this.f9782a.ac().right) / this.f9782a.mo1986A()))) / 60.0f) * ((float) this.f9782a.mo1986A()))) * Math.max(1.0d, this.f9782a.mo1987B())) / 1000.0d)) * 20.0f;
    }

    /* renamed from: g */
    public void m13759g() {
        m13754b();
    }
}
