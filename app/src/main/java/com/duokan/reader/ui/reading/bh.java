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

import com.duokan.c.b;
import com.duokan.c.f;
import com.duokan.c.g;
import com.duokan.core.app.x;
import com.duokan.reader.domain.bookshelf.a;
import com.duokan.reader.domain.bookshelf.ah;
import com.duokan.reader.ui.reading.a.v;
import com.duokan.reader.ui.welcome.DkTipManager.UserInput;
import com.duokan.reader.ui.welcome.p;

public class bh implements v {
    static final /* synthetic */ boolean a = (!bh.class.desiredAssertionStatus());
    private final sh b;
    private final wl c;
    private View d;
    private TextView e;
    private ImageView f;
    private ImageView g;
    private View h;
    private View i;
    private float j;
    private float k;
    private Animation l;
    private Animation m;
    private boolean n = false;
    private boolean o = false;
    private Context p;
    private final Handler q = new Handler(Looper.getMainLooper());
    private final Runnable r = new bi(this);

    public bh(Context context, sh shVar, wl wlVar) {
        this.b = shVar;
        this.c = wlVar;
        this.p = context;
        this.l = AnimationUtils.loadAnimation(context, b.rotate_up);
        this.m = AnimationUtils.loadAnimation(context, b.rotate_down);
        this.l.setDuration(200);
        this.l.setFillAfter(true);
        this.l.setFillEnabled(true);
        this.m.setDuration(200);
        this.m.setFillAfter(true);
        this.m.setFillEnabled(true);
        this.d = this.c.findViewById(g.reading__reading_view__pull_down_background);
        this.i = this.c.findViewById(g.reading__reading_background_view__logo);
        this.g = (ImageView) this.c.findViewById(g.reading__reading_view__bookmark);
        this.h = this.c.findViewById(g.reading__reading_background_view__header);
        this.e = (TextView) this.h.findViewById(g.reading__reading_background_view__bookmark_hint);
        this.f = (ImageView) this.h.findViewById(g.reading__reading_background_view__arrow);
    }

    public void a(MotionEvent motionEvent, MotionEvent motionEvent2) {
        this.b.a(1, 0);
        this.o = e();
        if (this.o) {
            this.d.setVisibility(0);
            this.j = 0.0f;
            this.n = false;
            this.k = (float) (-this.h.getHeight());
            this.m.setDuration(0);
            this.f.startAnimation(this.m);
            c();
            a(this.h, 0.0f, 0.0f, 0.0f, this.k, 0, null);
            a(this.i, 0.0f, 0.0f, (float) this.h.getHeight(), (float) this.h.getHeight(), 0, null);
            h().setIsHideMarkIcon(true);
            if (d()) {
                this.g.setVisibility(0);
            } else {
                this.g.setVisibility(4);
            }
            p pVar = (p) x.a(this.p).queryFeature(p.class);
            if (!a && pVar == null) {
                throw new AssertionError();
            } else if (pVar != null) {
                pVar.a(this.p, UserInput.DO_BOOK_MARK_GESTURE_START);
            }
        }
    }

    public void a(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.o) {
            if (!this.n && this.k >= ((float) i.a(this.p, 4.0f))) {
                this.n = true;
                this.f.startAnimation(this.l);
                c();
            }
            if (this.n && this.k < ((float) i.a(this.p, 4.0f))) {
                this.n = false;
                this.f.startAnimation(this.m);
                this.m.setDuration(200);
                c();
            }
            this.j += f2 / 3.0f;
            this.k += f2 / 3.0f;
            this.j = this.j < 0.0f ? 0.0f : this.j;
            this.k = this.k < ((float) (-this.h.getHeight())) ? (float) (-this.h.getHeight()) : this.k;
            if (!this.n) {
                a(this.h, 0.0f, 0.0f, Math.min(0.0f, this.k), Math.min(0.0f, this.k), 0, null);
            }
            a(this.c.getPagesFrameView(), 0.0f, 0.0f, this.j, this.j, 0, null);
        }
    }

    public void b(MotionEvent motionEvent, MotionEvent motionEvent2) {
        if (this.o) {
            int height = (int) ((this.j / ((float) this.c.getPagesFrameView().getHeight())) * 1000.0f);
            a(this.i, 0.0f, 0.0f, (float) this.h.getHeight(), (float) (this.h.getHeight() / 4), (long) height, null);
            a(this.h, 0.0f, 0.0f, 0.0f, (float) (-this.h.getHeight()), (long) height, null);
            a(this.c.getPagesFrameView(), 0.0f, 0.0f, this.j, 0.0f, (long) height, new bj(this));
        }
    }

    private void a(View view, float f, float f2, float f3, float f4, long j, AnimationListener animationListener) {
        Animation translateAnimation = new TranslateAnimation(f, f2, f3, f4);
        translateAnimation.setDuration(j);
        translateAnimation.setFillAfter(true);
        translateAnimation.setFillEnabled(true);
        translateAnimation.setAnimationListener(animationListener);
        view.startAnimation(translateAnimation);
    }

    private String a() {
        String string;
        if (this.n) {
            string = this.p.getString(j.lift_finger);
        } else {
            string = this.p.getString(j.down_drag);
        }
        if (d()) {
            return string + this.p.getString(j.remove_bookmark);
        }
        return string + this.p.getString(j.add_bookmark);
    }

    private int b() {
        if ((this.n ^ d()) != 0) {
            return f.reading__shared__bookmark_highlight;
        }
        return f.reading__shared__bookmark;
    }

    private void c() {
        this.e.setText(a());
        if (b() == f.reading__shared__bookmark_highlight) {
            this.g.setVisibility(0);
        } else {
            this.g.setVisibility(4);
        }
    }

    private boolean d() {
        return h().g().size() > 0;
    }

    private boolean e() {
        if (this.b.X() == null) {
            this.o = false;
        }
        if (h().getPageDrawable() == null) {
            this.o = false;
        }
        if (this.b.X().g().f()) {
            this.o = false;
        }
        return true;
    }

    private ah f() {
        String str;
        CharSequence g = g();
        if (TextUtils.isEmpty(g)) {
            str = "";
        } else {
            CharSequence charSequence = g;
        }
        ah ahVar = (ah) a.c(null);
        ahVar.b(this.b.G().aF());
        ahVar.a(str);
        ahVar.a(this.b.Z().g());
        ahVar.b(this.b.Z().h());
        return ahVar;
    }

    private String g() {
        String J = this.b.aa().J();
        if (J == null) {
            return null;
        }
        if (J.length() > 100) {
            return J.substring(0, 100);
        }
        return J;
    }

    private gs h() {
        return (gs) this.b.X().d();
    }
}
