package com.duokan.reader.ui.reading;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;

import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;
import com.duokan.core.sys.af;
import com.duokan.core.ui.UTools;
import com.duokan.core.ui.et;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.SystemUiConditioner;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.epub.h;
import com.duokan.reader.domain.document.i;
import com.duokan.reader.ui.general.hd;

public class aq extends hd implements SystemUiConditioner {
    private final sh a = ((sh) getContext().queryFeature(sh.class));
    private final ReaderFeature b = ((ReaderFeature) getContext().queryFeature(ReaderFeature.class));
    private final FrameLayout c;
    private final az d;
    private final ax e;
    private final wl f;
    private final et g;
    private final Drawable h;
    private final int i;
    private final int j;
    private boolean k = false;
    private Bitmap l = null;
    private boolean m = false;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private boolean q = false;
    private int r = 0;
    private float s = 0.0f;
    private float t;
    private ActivatedController u = null;

    public aq(IFeature featrue, wl wlVar) {
        super(featrue);
        this.f = wlVar;
        this.d = new az();
        this.e = new ax();
        this.i = this.a.ab().top + this.a.ac().top;
        this.j = this.a.ab().bottom + this.a.ac().bottom;
        this.t = (float) this.i;
        this.h = getDrawable(f.reading__auto_pagedown_view__line);
        this.c = new ar(this, getContext());
        this.c.setWillNotDraw(false);
        this.c.setVisibility(4);
        setContentView(this.c);
        this.g = new et();
        this.g.a(this.d);
        this.g.a(this.e);
        this.g.b(this.c);
    }

    protected void a(Canvas canvas) {
        canvas.save();
        if (this.o) {
            if (this.r == 0) {
                canvas.clipRect(0.0f, this.t, (float) (this.l.getWidth() / 2), (float) this.l.getHeight());
                canvas.clipRect((float) (this.l.getWidth() / 2), 0.0f, (float) this.l.getWidth(), (float) this.l.getHeight(), Op.UNION);
            } else {
                canvas.clipRect(0, this.l.getHeight(), this.l.getWidth() / 2, this.l.getHeight());
                canvas.clipRect((float) (this.l.getWidth() / 2), this.t, (float) this.l.getWidth(), (float) this.l.getHeight(), Op.UNION);
            }
            canvas.drawBitmap(this.l, 0.0f, 0.0f, null);
            canvas.restore();
            if (this.t < ((float) (this.l.getHeight() - this.j)) && this.t > ((float) (this.i - 1))) {
                if (this.r == 0) {
                    this.h.setBounds(0, (int) this.t, this.l.getWidth() / 2, ((int) this.t) + this.h.getIntrinsicHeight());
                    this.h.draw(canvas);
                    return;
                }
                this.h.setBounds(this.l.getWidth() / 2, (int) this.t, this.l.getWidth(), ((int) this.t) + this.h.getIntrinsicHeight());
                this.h.draw(canvas);
                return;
            }
            return;
        }
        canvas.clipRect(0.0f, this.t, (float) this.l.getWidth(), (float) this.l.getHeight());
        canvas.drawBitmap(this.l, 0.0f, 0.0f, null);
        canvas.restore();
        if (this.t < ((float) (this.l.getHeight() - this.j)) && this.t > ((float) (this.i - 1))) {
            this.h.setBounds(0, (int) this.t, this.l.getWidth(), ((int) this.t) + this.h.getIntrinsicHeight());
            this.h.draw(canvas);
        }
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        ((ReaderFeature) getContext().queryFeature(ReaderFeature.class)).addSystemUiConditioner(this);
        if (this.n) {
            f();
            this.n = false;
        }
    }

    protected void onDeactive() {
        ((ReaderFeature) getContext().queryFeature(ReaderFeature.class)).removeSystemUiConditioner(this);
        if (!this.m) {
            e();
            this.n = true;
        }
        super.onDeactive();
    }

    public void chooseStatusBarStyle(af afVar) {
    }

    public void chooseNavigationBarMode(af afVar) {
    }

    public void chooseNavigationBarColor(af afVar) {
        if (isActive() && this.u != null) {
            afVar.a(Integer.valueOf(-16777216));
        }
    }

    protected boolean onBack() {
        if (super.onBack()) {
            return true;
        }
        if (!d()) {
            return false;
        }
        b();
        return true;
    }

    protected boolean onShowMenu() {
        if (!d() || this.u != null) {
            return false;
        }
        this.u = new al(getContext());
        showPopup(this.u);
        UTools.closeAnimation(this.u.getContentView(), null);
        return true;
    }

    protected boolean onHideMenu() {
        if (this.u == null) {
            return false;
        }
        this.u.requestDetach();
        return true;
    }

    protected boolean onCheckMenuShowing() {
        return this.u != null;
    }

    protected boolean onRequestDetach(ActivatedController activatedControllerVar) {
        if (!activatedControllerVar.contains(this.u)) {
            return super.onRequestDetach(activatedControllerVar);
        }
        if (this.u.getContentView().getAnimation() == null) {
            UTools.showAnimation(this.u.getContentView(), new as(this));
        }
        return true;
    }

    public void a() {
        if (!d()) {
            if (this.a.e(this.a.aa().l())) {
                this.a.v().prompt(getString(j.reading__shared__reach_last_page));
                return;
            }
            this.k = true;
            this.b.setScreenTimeout(Integer.MAX_VALUE);
            this.a.a(1, 4);
            this.a.a(1, 8);
            this.a.i();
            a(this.a.ae().T());
            if (this.a.U() != PageAnimationMode.VSCROLL) {
                this.o = this.a.aa() instanceof i;
                if (this.l != null) {
                    this.l.recycle();
                }
                this.l = a.a(this.a.X().d());
                this.c.setVisibility(0);
                this.a.u();
            }
            this.a.b(new at(this));
        }
    }

    public void b() {
        if (d()) {
            c();
            if (this.a.U() != PageAnimationMode.VSCROLL) {
                this.a.t();
            }
        }
    }

    public void c() {
        if (d()) {
            if (this.u != null) {
                this.u.requestDetach();
            }
            this.k = false;
            this.m = false;
            this.n = false;
            this.o = false;
            this.p = false;
            this.q = false;
            this.r = 0;
            this.o = false;
            if (this.l != null) {
                this.l.recycle();
                this.l = null;
            }
            this.t = (float) this.i;
            this.b.setScreenTimeout(this.a.ae().m());
            this.c.setVisibility(4);
        }
    }

    public boolean d() {
        return this.k;
    }

    public void e() {
        this.m = true;
    }

    public void f() {
        this.m = false;
    }

    public void a(int i) {
        this.s = b(i);
    }

    private void h() {
        if (d()) {
            if (this.a.U() == PageAnimationMode.VSCROLL) {
                if (!(this.m || this.a.bh() || this.a.q())) {
                    this.a.scrollBy(0, (int) this.s);
                }
            } else if (this.t >= ((float) (this.l.getHeight() - this.j))) {
                j();
            } else if (!this.m) {
                this.t += this.s;
                this.c.invalidate();
            }
            t.a(new au(this), 20);
        }
    }

    private void i() {
        if (this.o && this.r == 1) {
            this.r = 0;
            this.t = (float) ((this.l.getHeight() - this.j) - 1);
            this.c.invalidate();
        } else if (!this.p) {
            this.p = true;
            this.a.t();
            ak Z = this.a.Z();
            if (Z instanceof h) {
                Z = ((h) Z).k();
            }
            if (this.a.d(Z)) {
                this.t = (float) this.i;
                this.c.invalidate();
                this.a.u();
                this.p = false;
                this.a.v().prompt(getString(j.reading__shared__reach_first_page));
                return;
            }
            this.a.b(new av(this));
        }
    }

    private void j() {
        if (this.o && this.r == 0) {
            this.r++;
            this.t = (float) this.i;
            this.c.invalidate();
        } else if (this.a.e(this.a.aa().l())) {
            this.a.v().prompt(getString(j.reading__shared__reach_last_page));
            c();
        } else if (!this.q) {
            this.q = true;
            this.a.b(new aw(this));
        }
    }

    private float b(int i) {
        return ((float) ((((double) (((((float) i) / ((float) (((((this.a.getDocument().k().a - this.a.ab().left) - this.a.ab().right) - this.a.ac().left) - this.a.ac().right) / this.a.A()))) / 60.0f) * ((float) this.a.A()))) * Math.max(1.0d, this.a.B())) / 1000.0d)) * 20.0f;
    }

    public void g() {
        b();
    }
}
