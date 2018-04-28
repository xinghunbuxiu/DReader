package com.duokan.reader.ui.general;

import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.ui.er;
import com.duokan.core.ui.et;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.HttpStatus;

public class PagesController extends gs {
    /* renamed from: a */
    private final FrameLayout f6183a;
    /* renamed from: b */
    private final ArrayList<fs> f6184b = new ArrayList();
    /* renamed from: c */
    private final et f6185c;
    /* renamed from: d */
    private View f6186d = null;
    /* renamed from: e */
    private int f6187e = 8;
    /* renamed from: f */
    private int f6188f = 0;
    /* renamed from: g */
    private boolean f6189g = false;

    public enum AnimationType {
        IN,
        OUT,
        UP,
        DOWN
    }

    public PagesController(IFeature mFeature) {
        super(mFeature);
        er fmVar = new fm();
        this.f6185c = new et();
        this.f6185c.m2041a(fmVar);
        this.f6183a = new fi(this, getContext(), fmVar);
        setContentView(this.f6183a);
    }

    /* renamed from: c */
    public final void m9227c(int i) {
        this.f6188f = i;
    }

    /* renamed from: f */
    public final View m9237f() {
        return this.f6186d;
    }

    /* renamed from: a */
    public final void m9216a(View view) {
        if (this.f6186d != null) {
            this.f6183a.removeView(this.f6186d);
            this.f6186d = null;
        }
        if (view != null) {
            this.f6186d = view;
            this.f6183a.addView(view, 0, new LayoutParams(-1, -1));
        }
    }

    /* renamed from: g */
    public final ActivatedController m9239g() {
        if (m9241h() < 1) {
            return null;
        }
        return m9231d(m9241h() - 1);
    }

    /* renamed from: d */
    public final ActivatedController m9231d(int i) {
        if (i < 0 || i >= m9241h()) {
            return null;
        }
        return ((fs) this.f6184b.get(i)).m10670b();
    }

    /* renamed from: d */
    public final ActivatedController m9232d(ActivatedController c0303e) {
        int f = m9236f(c0303e);
        if (f < 1) {
            return null;
        }
        return ((fs) this.f6184b.get(f - 1)).m10670b();
    }

    /* renamed from: e */
    public final ActivatedController m9234e(ActivatedController c0303e) {
        int f = m9236f(c0303e);
        if (f < 0 || f >= m9241h() - 1) {
            return null;
        }
        return ((fs) this.f6184b.get(f + 1)).m10670b();
    }

    /* renamed from: f */
    public final int m9236f(ActivatedController c0303e) {
        for (int i = 0; i < this.f6184b.size(); i++) {
            if (((fs) this.f6184b.get(i)).containsDirectly(c0303e)) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: h */
    public final int m9241h() {
        return this.f6184b.size();
    }

    /* renamed from: e */
    public final void m9235e(int i) {
        this.f6187e = i;
    }

    /* renamed from: c */
    public boolean mo1861c(ActivatedController c0303e) {
        if (m9240g(c0303e) != null) {
            return false;
        }
        m9220a(new fs(this, getContext(), c0303e), null, 0, null);
        return true;
    }

    /* renamed from: c */
    public boolean mo1862c(ActivatedController c0303e, Runnable runnable) {
        if (m9240g(c0303e) != null) {
            return false;
        }
        m9220a(new fs(this, getContext(), c0303e), mo1640a(AnimationType.IN, c0303e), (int) HttpStatus.SC_MULTIPLE_CHOICES, runnable);
        return true;
    }

    /* renamed from: d */
    public boolean mo1863d(ActivatedController c0303e, Runnable runnable) {
        if (m9239g() == c0303e) {
            return false;
        }
        fs g = m9240g(c0303e);
        if (g == null) {
            return false;
        }
        m9219a(g, HttpStatus.SC_MULTIPLE_CHOICES, runnable);
        return true;
    }

    /* renamed from: i */
    public boolean m9242i() {
        if (m9239g() == null) {
            return false;
        }
        m9221a(null, false, 0, null);
        return true;
    }

    /* renamed from: j */
    public boolean m9243j() {
        if (m9239g() == null) {
            return false;
        }
        m9219a(null, 0, null);
        return true;
    }

    /* renamed from: b */
    public boolean m9225b(Runnable runnable) {
        if (m9239g() == null) {
            if (runnable != null) {
                runnable.run();
            }
            return false;
        }
        m9219a(null, HttpStatus.SC_MULTIPLE_CHOICES, runnable);
        return true;
    }

    protected boolean onBack() {
        if (super.onBack() || this.f6189g) {
            return true;
        }
        return mo1641a();
    }

    protected boolean onRequestDetach(ActivatedController c0303e) {
        if (!(c0303e instanceof fs)) {
            return super.onRequestDetach(c0303e);
        }
        if (m9241h() <= this.f6188f) {
            return super.onRequestDetach(c0303e);
        }
        m9219a(m9226c((fs) c0303e), HttpStatus.SC_MULTIPLE_CHOICES, null);
        return true;
    }

    /* renamed from: a */
    private boolean mo1641a() {
        if (m9241h() <= this.f6188f) {
            return false;
        }
        fs k = m9244k();
        if (k == null) {
            return false;
        }
        View contentView = k.getContentView();
        if (this.f6189g || contentView.getAnimation() == null || contentView.getAnimation().hasEnded()) {
            k.requestDetach();
        }
        return true;
    }

    /* renamed from: a */
    protected final void m9220a(fs fsVar, Animation animation, int i, Runnable runnable) {
        fs k = m9244k();
        View contentView = k == null ? this.f6186d : k.getContentView();
        if (contentView != null) {
            ViewCompat.setImportantForAccessibility(contentView, 4);
        }
        View contentView2 = fsVar.getContentView();
        if (contentView2.getLayoutParams() == null) {
            this.f6183a.addView(contentView2, new LayoutParams(-1, -1));
        } else {
            this.f6183a.addView(contentView2);
        }
        this.f6184b.add(fsVar);
        addSubController(fsVar);
        Runnable fjVar = new fj(this, fsVar, k, runnable);
        contentView2.setVisibility(0);
        m9217a(contentView2, animation, i, fjVar);
        if (contentView != null) {
            contentView.setVisibility(this.f6187e);
            if (animation != null) {
                m9217a(contentView, contentView == this.f6186d ? mo1639a(AnimationType.DOWN) : mo1640a(AnimationType.DOWN, k.m10670b()), i, null);
            } else {
                m9217a(contentView, null, 0, null);
            }
        }
    }

    /* renamed from: a */
    protected void mo1971a(int i) {
    }

    /* renamed from: a */
    protected final void m9221a(fs fsVar, boolean z, int i, Runnable runnable) {
        ArrayList arrayList = new ArrayList(this.f6184b.size());
        for (int size = this.f6184b.size() - 1; size >= 0; size--) {
            fs fsVar2 = (fs) this.f6184b.get(size);
            if (fsVar2 == fsVar) {
                break;
            }
            arrayList.add(fsVar2);
        }
        if (arrayList.size() >= 1) {
            fs fsVar3 = (fs) arrayList.get(0);
            View contentView = fsVar3.getContentView();
            View contentView2 = fsVar == null ? this.f6186d : fsVar.getContentView();
            if (contentView2 != null) {
                ViewCompat.setImportantForAccessibility(contentView2, 0);
            }
            Runnable fkVar = new fk(this, fsVar3, contentView, fsVar, arrayList, runnable);
            this.f6189g = (!z ? 1 : 0) | this.f6189g;
            int i2 = 0;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                fs fsVar4 = (fs) arrayList.get(i3);
                Animation a = mo1640a(AnimationType.OUT, fsVar4.m10670b());
                if (this.f6189g) {
                    fkVar.run();
                    this.f6189g = false;
                } else {
                    Runnable runnable2;
                    View contentView3 = fsVar4.getContentView();
                    if (i3 == 0) {
                        runnable2 = fkVar;
                    } else {
                        runnable2 = null;
                    }
                    m9217a(contentView3, a, i, runnable2);
                }
                if ((i2 == 0 && a == null) || this.f6189g) {
                    i2 = 0;
                } else {
                    i2 = 1;
                }
            }
            if (contentView2 != null) {
                contentView2.setVisibility(0);
                if (i2 != 0) {
                    m9217a(contentView2, contentView2 == this.f6186d ? mo1639a(AnimationType.UP) : mo1640a(AnimationType.UP, fsVar.m10670b()), i, null);
                } else {
                    m9217a(contentView2, null, 0, null);
                }
            }
        }
    }

    /* renamed from: a */
    protected final void m9219a(fs fsVar, int i, Runnable runnable) {
        m9221a(fsVar, true, i, runnable);
    }

    /* renamed from: b */
    protected void mo1972b(int i) {
    }

    /* renamed from: a */
    protected final void m9217a(View view, Animation animation, int i, Runnable runnable) {
        if (animation == null) {
            animation = new TranslateAnimation(0.0f, 0.0f, 0.0f, 0.0f);
            animation.setDuration(0);
        } else {
            animation.setDuration((long) i);
        }
        animation.setAnimationListener(new fl(this, runnable));
        view.startAnimation(animation);
    }

    /* renamed from: b */
    protected final void m9224b(fs fsVar) {
        deactivate(fsVar);
        this.f6183a.removeView(fsVar.getContentView());
        removeSubController(fsVar);
        this.f6184b.remove(fsVar);
    }

    /* renamed from: k */
    protected final fs m9244k() {
        if (this.f6184b.size() < 1) {
            return null;
        }
        return (fs) this.f6184b.get(this.f6184b.size() - 1);
    }

    /* renamed from: c */
    protected final fs m9226c(fs fsVar) {
        int d = m9230d(fsVar);
        if (d < 1) {
            return null;
        }
        return (fs) this.f6184b.get(d - 1);
    }

    /* renamed from: d */
    protected final int m9230d(fs fsVar) {
        return this.f6184b.indexOf(fsVar);
    }

    /* renamed from: f */
    protected final fs m9238f(int i) {
        if (i < 0 || i >= this.f6184b.size()) {
            return null;
        }
        return (fs) this.f6184b.get(i);
    }

    /* renamed from: g */
    protected final fs m9240g(ActivatedController c0303e) {
        Iterator it = this.f6184b.iterator();
        while (it.hasNext()) {
            fs fsVar = (fs) it.next();
            if (fsVar.containsDirectly(c0303e)) {
                return fsVar;
            }
        }
        return null;
    }

    /* renamed from: a */
    protected Animation mo1640a(AnimationType animationType, ActivatedController c0303e) {
        return null;
    }

    /* renamed from: a */
    protected Animation mo1639a(AnimationType animationType) {
        return null;
    }

    /* renamed from: a */
    protected void mo1859a(fs fsVar, float f) {
    }

    /* renamed from: a */
    protected boolean mo1860a(fs fsVar) {
        if (fsVar instanceof fs) {
            return true;
        }
        return false;
    }
}
