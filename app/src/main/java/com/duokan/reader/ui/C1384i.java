package com.duokan.reader.ui;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.ui.AnimUtils;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ui.general.fs;
import com.duokan.reader.ui.general.hs;
import org.apache.http.HttpStatus;

/* renamed from: com.duokan.reader.ui.i */
public class C1384i extends hs {
    public C1384i(IFeature mFeature) {
        super(mFeature);
        m9235e(0);
    }

    /* renamed from: a */
    public boolean m11324a(ActivatedController c0303e) {
        if (m9240g(c0303e) != null) {
            return false;
        }
        m9220a(new C1387l(this, getContext(), c0303e, ReaderEnv.get().forHd() ? 0.618f : 1.0f), null, 0, null);
        m11319h(m9239g());
        return true;
    }

    /* renamed from: a */
    public boolean m11325a(ActivatedController c0303e, Runnable runnable) {
        if (m9240g(c0303e) != null) {
            return false;
        }
        m9220a(new C1387l(this, getContext(), c0303e, ReaderEnv.get().forHd() ? 0.618f : 1.0f), mo1640a(AnimationType.IN, c0303e), (int) HttpStatus.SC_MULTIPLE_CHOICES, runnable);
        m11319h(m9239g());
        return true;
    }

    /* renamed from: b */
    public boolean m11327b(ActivatedController c0303e) {
        if (m9240g(c0303e) != null) {
            return false;
        }
        m9220a(new C1390o(this, getContext(), c0303e, 1.0f), null, 0, null);
        m11319h(m9239g());
        return true;
    }

    /* renamed from: b */
    public boolean m11328b(ActivatedController c0303e, Runnable runnable) {
        if (m9240g(c0303e) != null || !super.mo1862c(new C1390o(this, getContext(), c0303e, 1.0f), runnable)) {
            return false;
        }
        m11319h(m9239g());
        return true;
    }

    /* renamed from: c */
    public boolean mo1861c(ActivatedController c0303e) {
        if (m9240g(c0303e) != null) {
            return false;
        }
        m9220a(new C1387l(this, getContext(), c0303e, 1.0f), null, 0, null);
        m11319h(m9239g());
        return true;
    }

    /* renamed from: c */
    public boolean mo1862c(ActivatedController c0303e, Runnable runnable) {
        if (m9240g(c0303e) != null) {
            return false;
        }
        m9220a(new C1387l(this, getContext(), c0303e, 1.0f), mo1640a(AnimationType.IN, c0303e), (int) HttpStatus.SC_MULTIPLE_CHOICES, runnable);
        m11319h(m9239g());
        return true;
    }

    /* renamed from: d */
    public boolean mo1863d(ActivatedController c0303e, Runnable runnable) {
        if (!super.mo1863d(c0303e, runnable)) {
            return false;
        }
        m11320i(m9234e(c0303e));
        return true;
    }

    protected boolean onRequestDetach(ActivatedController c0303e) {
        if (c0303e instanceof C1387l) {
            m11320i(((fs) c0303e).m10670b());
        }
        return super.onRequestDetach(c0303e);
    }

    /* renamed from: a */
    protected Animation mo1640a(AnimationType animationType, ActivatedController c0303e) {
        if (!(m9240g(c0303e) instanceof C1390o)) {
            return super.mo1640a(animationType, c0303e);
        }
        switch (C1386k.f8190a[animationType.ordinal()]) {
            case 1:
                return new AlphaAnimation(1.0f, 0.0f);
            default:
                return null;
        }
    }

    /* renamed from: a */
    protected Animation mo1639a(AnimationType animationType) {
        switch (C1386k.f8190a[animationType.ordinal()]) {
            case 2:
                return new AlphaAnimation(0.3f, 1.0f);
            case 3:
                Animation alphaAnimation = new AlphaAnimation(1.0f, 0.3f);
                alphaAnimation.setFillEnabled(true);
                alphaAnimation.setFillAfter(true);
                return alphaAnimation;
            default:
                return null;
        }
    }

    /* renamed from: a */
    protected void mo1859a(fs fsVar, float f) {
        super.mo1859a(fsVar, f);
        ActivatedController d = m9232d(fsVar.m10670b());
        if (d == null) {
            m9237f();
            return;
        }
        m11315a(f);
        d.getContentView();
        if (Float.compare(f, 0.0f) == 0) {
            m11314a();
        }
    }

    /* renamed from: a */
    protected boolean mo1860a(fs fsVar) {
        if (fsVar instanceof C1390o) {
            return false;
        }
        return super.mo1860a(fsVar);
    }

    /* renamed from: a */
    private void m11315a(float f) {
        fs k = m9244k();
        if (k != null && !(k instanceof C1390o)) {
            float min = Math.min(1.0f - f, ((C1387l) k).m11333a());
            int h = m9241h() - 2;
            while (h >= 0) {
                float a;
                fs f2 = m9238f(h);
                if (f2 instanceof C1387l) {
                    a = ((C1387l) f2).m11333a();
                    if (Float.compare(a, min) >= 0) {
                        f2.getContentView().setVisibility(0);
                        if (Float.compare(1.0f, a) == 0) {
                            return;
                        }
                    } else {
                        a = min;
                    }
                } else {
                    a = min;
                }
                h--;
                min = a;
            }
        }
    }

    /* renamed from: h */
    private void m11319h(ActivatedController c0303e) {
        ActivatedController d = m9232d(c0303e);
        if (d != null) {
            AnimUtils.startAlphaAnimation(d.getContentView(), 1.0f, 0.3f, (int) HttpStatus.SC_MULTIPLE_CHOICES, true, new C1385j(this));
        }
    }

    /* renamed from: a */
    private void m11314a() {
        fs k = m9244k();
        if (k != null) {
            float a = ((C1387l) k).m11333a();
            for (int i = 0; i < m9241h() - 1; i++) {
                fs f = m9238f(i);
                if ((f instanceof C1387l) && Float.compare(((C1387l) f).m11333a(), a) <= 0) {
                    f.getContentView().setVisibility(8);
                }
            }
        }
    }

    /* renamed from: i */
    private void m11320i(ActivatedController c0303e) {
        float f = 0.0f;
        int f2 = m9236f(c0303e);
        while (f2 >= 0) {
            float a;
            fs g = m9240g(m9231d(f2));
            if (g instanceof C1387l) {
                a = ((C1387l) g).m11333a();
                if (Float.compare(a, f) > 0) {
                    g.getContentView().setVisibility(0);
                } else {
                    a = f;
                }
            } else {
                a = f;
            }
            f2--;
            f = a;
        }
        ActivatedController d = m9232d(c0303e);
        if (d != null) {
            AnimUtils.startAlphaAnimation(d.getContentView(), 0.3f, 1.0f, (int) HttpStatus.SC_MULTIPLE_CHOICES, false, null);
        }
    }
}
