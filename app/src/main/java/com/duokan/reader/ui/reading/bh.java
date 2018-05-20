package com.duokan.reader.ui.reading;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.duokan.common.CommonUtils;
import com.duokan.core.app.AppContext;
import com.duokan.p024c.C0250b;
import com.duokan.p024c.C0254f;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.bookshelf.C0798a;
import com.duokan.reader.domain.bookshelf.ah;
import com.duokan.reader.ui.reading.p054a.C1441v;
import com.duokan.reader.ui.welcome.C1540p;
import com.duokan.reader.ui.welcome.DkTipManager.UserInput;

public class bh implements C1441v {
    /* renamed from: a */
    static final /* synthetic */ boolean f9834a = (!bh.class.desiredAssertionStatus());
    /* renamed from: b */
    private final su f9835b;
    /* renamed from: c */
    private final wy f9836c;
    /* renamed from: d */
    private View f9837d;
    /* renamed from: e */
    private TextView f9838e;
    /* renamed from: f */
    private ImageView f9839f;
    /* renamed from: g */
    private ImageView f9840g;
    /* renamed from: h */
    private View f9841h;
    /* renamed from: i */
    private View f9842i;
    /* renamed from: j */
    private float f9843j;
    /* renamed from: k */
    private float f9844k;
    /* renamed from: l */
    private Animation f9845l;
    /* renamed from: m */
    private Animation f9846m;
    /* renamed from: n */
    private boolean f9847n = false;
    /* renamed from: o */
    private boolean f9848o = false;
    /* renamed from: p */
    private Context f9849p;
    /* renamed from: q */
    private final Handler f9850q = new Handler(Looper.getMainLooper());
    /* renamed from: r */
    private final Runnable f9851r = new bi(this);

    public bh(Context context, su suVar, wy wyVar) {
        this.f9835b = suVar;
        this.f9836c = wyVar;
        this.f9849p = context;
        this.f9845l = AnimationUtils.loadAnimation(context, C0250b.rotate_up);
        this.f9846m = AnimationUtils.loadAnimation(context, C0250b.rotate_down);
        this.f9845l.setDuration(200);
        this.f9845l.setFillAfter(true);
        this.f9845l.setFillEnabled(true);
        this.f9846m.setDuration(200);
        this.f9846m.setFillAfter(true);
        this.f9846m.setFillEnabled(true);
        this.f9837d = this.f9836c.findViewById(C0255g.reading__reading_view__pull_down_background);
        this.f9842i = this.f9836c.findViewById(C0255g.reading__reading_background_view__logo);
        this.f9840g = (ImageView) this.f9836c.findViewById(C0255g.reading__reading_view__bookmark);
        this.f9841h = this.f9836c.findViewById(C0255g.reading__reading_background_view__header);
        this.f9838e = (TextView) this.f9841h.findViewById(C0255g.reading__reading_background_view__bookmark_hint);
        this.f9839f = (ImageView) this.f9841h.findViewById(C0255g.reading__reading_background_view__arrow);
    }

    /* renamed from: a */
    public void mo2278a(MotionEvent motionEvent, MotionEvent motionEvent2) {
        this.f9835b.mo2040a(1, 0);
        this.f9848o = m13787e();
        if (this.f9848o) {
            this.f9837d.setVisibility(0);
            this.f9843j = 0.0f;
            this.f9847n = false;
            this.f9844k = (float) (-this.f9841h.getHeight());
            this.f9846m.setDuration(0);
            this.f9839f.startAnimation(this.f9846m);
            m13782c();
            m13779a(this.f9841h, 0.0f, 0.0f, 0.0f, this.f9844k, 0, null);
            m13779a(this.f9842i, 0.0f, 0.0f, (float) this.f9841h.getHeight(), (float) this.f9841h.getHeight(), 0, null);
            m13792h().setIsHideMarkIcon(true);
            if (m13785d()) {
                this.f9840g.setVisibility(0);
            } else {
                this.f9840g.setVisibility(4);
            }
            C1540p c1540p = (C1540p) AppContext.getAppContext(this.f9849p).queryFeature(C1540p.class);
            if (!f9834a && c1540p == null) {
                throw new AssertionError();
            } else if (c1540p != null) {
                c1540p.mo2564a(this.f9849p, UserInput.DO_BOOK_MARK_GESTURE_START);
            }
        }
    }

    /* renamed from: a */
    public void mo2279a(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.f9848o) {
            if (!this.f9847n && this.f9844k >= ((float) CommonUtils.dip2px(this.f9849p, 4.0f))) {
                this.f9847n = true;
                this.f9839f.startAnimation(this.f9845l);
                m13782c();
            }
            if (this.f9847n && this.f9844k < ((float) CommonUtils.dip2px(this.f9849p, 4.0f))) {
                this.f9847n = false;
                this.f9839f.startAnimation(this.f9846m);
                this.f9846m.setDuration(200);
                m13782c();
            }
            this.f9843j += f2 / 3.0f;
            this.f9844k += f2 / 3.0f;
            this.f9843j = this.f9843j < 0.0f ? 0.0f : this.f9843j;
            this.f9844k = this.f9844k < ((float) (-this.f9841h.getHeight())) ? (float) (-this.f9841h.getHeight()) : this.f9844k;
            if (!this.f9847n) {
                m13779a(this.f9841h, 0.0f, 0.0f, Math.min(0.0f, this.f9844k), Math.min(0.0f, this.f9844k), 0, null);
            }
            m13779a(this.f9836c.getPagesFrameView(), 0.0f, 0.0f, this.f9843j, this.f9843j, 0, null);
        }
    }

    /* renamed from: b */
    public void mo2280b(MotionEvent motionEvent, MotionEvent motionEvent2) {
        if (this.f9848o) {
            int height = (int) ((this.f9843j / ((float) this.f9836c.getPagesFrameView().getHeight())) * 1000.0f);
            m13779a(this.f9842i, 0.0f, 0.0f, (float) this.f9841h.getHeight(), (float) (this.f9841h.getHeight() / 4), (long) height, null);
            m13779a(this.f9841h, 0.0f, 0.0f, 0.0f, (float) (-this.f9841h.getHeight()), (long) height, null);
            m13779a(this.f9836c.getPagesFrameView(), 0.0f, 0.0f, this.f9843j, 0.0f, (long) height, new bj(this));
        }
    }

    /* renamed from: a */
    private void m13779a(View view, float f, float f2, float f3, float f4, long j, AnimationListener animationListener) {
        Animation translateAnimation = new TranslateAnimation(f, f2, f3, f4);
        translateAnimation.setDuration(j);
        translateAnimation.setFillAfter(true);
        translateAnimation.setFillEnabled(true);
        translateAnimation.setAnimationListener(animationListener);
        view.startAnimation(translateAnimation);
    }

    /* renamed from: a */
    private String m13778a() {
        String string;
        if (this.f9847n) {
            string = this.f9849p.getString(C0258j.lift_finger);
        } else {
            string = this.f9849p.getString(C0258j.down_drag);
        }
        if (m13785d()) {
            return string + this.f9849p.getString(C0258j.remove_bookmark);
        }
        return string + this.f9849p.getString(C0258j.add_bookmark);
    }

    /* renamed from: b */
    private int m13780b() {
        if ((this.f9847n ^ m13785d()) != 0) {
            return C0254f.reading__shared__bookmark_highlight;
        }
        return C0254f.reading__shared__bookmark;
    }

    /* renamed from: c */
    private void m13782c() {
        this.f9838e.setText(m13778a());
        if (m13780b() == C0254f.reading__shared__bookmark_highlight) {
            this.f9840g.setVisibility(0);
        } else {
            this.f9840g.setVisibility(4);
        }
    }

    /* renamed from: d */
    private boolean m13785d() {
        return m13792h().m14301g().size() > 0;
    }

    /* renamed from: e */
    private boolean m13787e() {
        if (this.f9835b.mo2007X() == null) {
            this.f9848o = false;
        }
        if (m13792h().getPageDrawable() == null) {
            this.f9848o = false;
        }
        if (this.f9835b.mo2007X().mo2331g().m5817f()) {
            this.f9848o = false;
        }
        return true;
    }

    /* renamed from: f */
    private ah m13789f() {
        String str;
        CharSequence g = m13791g();
        if (TextUtils.isEmpty(g)) {
            str = "";
        } else {
            CharSequence str2 = g;
        }
        ah ahVar = (ah) C0798a.m3712c(null);
        ahVar.m3721b(this.f9835b.mo1992G().aH());
        ahVar.m3719a(str2);
        ahVar.m3718a(this.f9835b.mo2009Z().mo1198g());
        ahVar.m3722b(this.f9835b.mo2009Z().mo1199h());
        return ahVar;
    }

    /* renamed from: g */
    private String m13791g() {
        String I = this.f9835b.aa().mo1286I();
        if (I == null) {
            return null;
        }
        if (I.length() > 100) {
            return I.substring(0, 100);
        }
        return I;
    }

    /* renamed from: h */
    private gx m13792h() {
        return (gx) this.f9835b.mo2007X().mo2328d();
    }
}
