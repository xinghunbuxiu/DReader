package com.duokan.reader.ui.general;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;
import com.duokan.core.ui.er;
import com.duokan.core.ui.et;

import org.apache.http.HttpStatus;

import java.util.ArrayList;
import java.util.Iterator;

public class PagesController extends hd {
    private final FrameLayout a;
    private final ArrayList b = new ArrayList();
    private final et c;
    private View d = null;
    private int e = 8;
    private int f = 0;
    private boolean g = false;

    public enum AnimationType {
        IN,
        OUT,
        UP,
        DOWN
    }

    public PagesController(IFeature featrue) {
        super(featrue);
        er fsVar = new fs();
        this.c = new et();
        this.c.a(fsVar);
        this.a = new fo(this, getContext(), fsVar);
        setContentView(this.a);
    }

    public final void c(int i) {
        this.f = i;
    }

    public final View g() {
        return this.d;
    }

    public final void a(View view) {
        if (this.d != null) {
            this.a.removeView(this.d);
            this.d = null;
        }
        if (view != null) {
            this.d = view;
            this.a.addView(view, 0, new LayoutParams(-1, -1));
        }
    }

    public final ActivatedController h() {
        if (i() < 1) {
            return null;
        }
        return d(i() - 1);
    }

    public final ActivatedController d(int i) {
        if (i < 0 || i >= i()) {
            return null;
        }
        return ((fy) this.b.get(i)).b();
    }

    public final ActivatedController d(ActivatedController activatedControllerVar) {
        int f = f(activatedControllerVar);
        if (f < 1) {
            return null;
        }
        return ((fy) this.b.get(f - 1)).b();
    }

    public final ActivatedController e(ActivatedController activatedControllerVar) {
        int f = f(activatedControllerVar);
        if (f < 0 || f >= i() - 1) {
            return null;
        }
        return ((fy) this.b.get(f + 1)).b();
    }

    public final int f(ActivatedController activatedControllerVar) {
        for (int i = 0; i < this.b.size(); i++) {
            if (((fy) this.b.get(i)).containsDirectly(activatedControllerVar)) {
                return i;
            }
        }
        return -1;
    }

    public final int i() {
        return this.b.size();
    }

    public final void e(int i) {
        this.e = i;
    }

    public boolean c(ActivatedController activatedControllerVar) {
        if (g(activatedControllerVar) != null) {
            return false;
        }
        a(new fy(this, getContext(), activatedControllerVar), null, 0, null);
        return true;
    }

    public boolean c(ActivatedController activatedControllerVar, Runnable runnable) {
        if (g(activatedControllerVar) != null) {
            return false;
        }
        a(new fy(this, getContext(), activatedControllerVar), a(AnimationType.IN, activatedControllerVar), (int) HttpStatus.SC_MULTIPLE_CHOICES, runnable);
        return true;
    }

    public boolean d(ActivatedController activatedControllerVar, Runnable runnable) {
        if (h() == activatedControllerVar) {
            return false;
        }
        fy g = g(activatedControllerVar);
        if (g == null) {
            return false;
        }
        a(g, HttpStatus.SC_MULTIPLE_CHOICES, runnable);
        return true;
    }

    public boolean j() {
        if (h() == null) {
            return false;
        }
        a(null, false, 0, null);
        return true;
    }

    public boolean k() {
        if (h() == null) {
            return false;
        }
        a(null, 0, null);
        return true;
    }

    public boolean b(Runnable runnable) {
        if (h() == null) {
            if (runnable != null) {
                runnable.run();
            }
            return false;
        }
        a(null, HttpStatus.SC_MULTIPLE_CHOICES, runnable);
        return true;
    }

    protected boolean onBack() {
        if (super.onBack() || this.g) {
            return true;
        }
        return a();
    }

    protected boolean onRequestDetach(ActivatedController activatedControllerVar) {
        if (!(activatedControllerVar instanceof fy)) {
            return super.onRequestDetach(activatedControllerVar);
        }
        if (i() <= this.f) {
            return super.onRequestDetach(activatedControllerVar);
        }
        a(c((fy) activatedControllerVar), HttpStatus.SC_MULTIPLE_CHOICES, null);
        return true;
    }

    private boolean a() {
        if (i() <= this.f) {
            return false;
        }
        fy l = l();
        if (l == null) {
            return false;
        }
        View contentView = l.getContentView();
        if (this.g || contentView.getAnimation() == null || contentView.getAnimation().hasEnded()) {
            l.requestDetach();
        }
        return true;
    }

    protected final void a(fy fyVar, Animation animation, int i, Runnable runnable) {
        fy l = l();
        View contentView = l == null ? this.d : l.getContentView();
        View contentView2 = fyVar.getContentView();
        if (contentView2.getLayoutParams() == null) {
            this.a.addView(contentView2, new LayoutParams(-1, -1));
        } else {
            this.a.addView(contentView2);
        }
        this.b.add(fyVar);
        addSubController(fyVar);
        Runnable fpVar = new fp(this, fyVar, l, runnable);
        contentView2.setVisibility(0);
        a(contentView2, animation, i, fpVar);
        if (contentView != null) {
            contentView.setVisibility(this.e);
            if (animation != null) {
                a(contentView, contentView == this.d ? a(AnimationType.DOWN) : a(AnimationType.DOWN, l.b()), i, null);
            } else {
                a(contentView, null, 0, null);
            }
        }
    }

    protected void a(int i) {
    }

    protected final void a(fy fyVar, boolean z, int i, Runnable runnable) {
        ArrayList arrayList = new ArrayList(this.b.size());
        for (int size = this.b.size() - 1; size >= 0; size--) {
            fy fyVar2 = (fy) this.b.get(size);
            if (fyVar2 == fyVar) {
                break;
            }
            arrayList.add(fyVar2);
        }
        if (arrayList.size() >= 1) {
            fy fyVar3 = (fy) arrayList.get(0);
            View contentView = fyVar3.getContentView();
            View contentView2 = fyVar == null ? this.d : fyVar.getContentView();
            Runnable fqVar = new fq(this, fyVar3, contentView, fyVar, arrayList, runnable);
            this.g = (!z ? 1 : 0) | this.g;
            int i2 = 0;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                fy fyVar4 = (fy) arrayList.get(i3);
                Animation a = a(AnimationType.OUT, fyVar4.b());
                if (this.g) {
                    fqVar.run();
                    this.g = false;
                } else {
                    Runnable runnable2;
                    View contentView3 = fyVar4.getContentView();
                    if (i3 == 0) {
                        runnable2 = fqVar;
                    } else {
                        runnable2 = null;
                    }
                    a(contentView3, a, i, runnable2);
                }
                if ((i2 == 0 && a == null) || this.g) {
                    i2 = 0;
                } else {
                    i2 = 1;
                }
            }
            if (contentView2 != null) {
                contentView2.setVisibility(0);
                if (i2 != 0) {
                    a(contentView2, contentView2 == this.d ? a(AnimationType.UP) : a(AnimationType.UP, fyVar.b()), i, null);
                } else {
                    a(contentView2, null, 0, null);
                }
            }
        }
    }

    protected final void a(fy fyVar, int i, Runnable runnable) {
        a(fyVar, true, i, runnable);
    }

    protected void b(int i) {
    }

    protected final void a(View view, Animation animation, int i, Runnable runnable) {
        if (animation == null) {
            animation = new TranslateAnimation(0.0f, 0.0f, 0.0f, 0.0f);
            animation.setDuration(0);
        } else {
            animation.setDuration((long) i);
        }
        animation.setAnimationListener(new fr(this, runnable));
        view.startAnimation(animation);
    }

    protected final void b(fy fyVar) {
        deactivate(fyVar);
        this.a.removeView(fyVar.getContentView());
        removeSubController(fyVar);
        this.b.remove(fyVar);
    }

    protected final fy l() {
        if (this.b.size() < 1) {
            return null;
        }
        return (fy) this.b.get(this.b.size() - 1);
    }

    protected final fy c(fy fyVar) {
        int d = d(fyVar);
        if (d < 1) {
            return null;
        }
        return (fy) this.b.get(d - 1);
    }

    protected final int d(fy fyVar) {
        return this.b.indexOf(fyVar);
    }

    protected final fy f(int i) {
        if (i < 0 || i >= this.b.size()) {
            return null;
        }
        return (fy) this.b.get(i);
    }

    protected final fy g(ActivatedController activatedControllerVar) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            fy fyVar = (fy) it.next();
            if (fyVar.containsDirectly(activatedControllerVar)) {
                return fyVar;
            }
        }
        return null;
    }

    protected Animation a(AnimationType animationType, ActivatedController activatedControllerVar) {
        return null;
    }

    protected Animation a(AnimationType animationType) {
        return null;
    }

    protected void a(fy fyVar, float f) {
    }

    protected boolean a(fy fyVar) {
        if (fyVar instanceof fy) {
            return true;
        }
        return false;
    }
}
