package com.duokan.reader.ui;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

import com.duokan.core.app.e;
import com.duokan.core.app.y;
import com.duokan.core.ui.dv;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ui.general.PagesController.AnimationType;
import com.duokan.reader.ui.general.fy;
import com.duokan.reader.ui.general.ii;

import org.apache.http.HttpStatus;

public class i extends ii {
    public i(y yVar) {
        super(yVar);
        e(0);
    }

    public boolean a(e eVar) {
        if (g(eVar) != null) {
            return false;
        }
        a(new l(this, getContext(), eVar, ReaderEnv.get().forHd() ? 0.618f : 1.0f), null, 0, null);
        h(h());
        return true;
    }

    public boolean a(e eVar, Runnable runnable) {
        if (g(eVar) != null) {
            return false;
        }
        a(new l(this, getContext(), eVar, ReaderEnv.get().forHd() ? 0.618f : 1.0f), a(AnimationType.IN, eVar), (int) HttpStatus.SC_MULTIPLE_CHOICES, runnable);
        h(h());
        return true;
    }

    public boolean b(e eVar) {
        if (g(eVar) != null) {
            return false;
        }
        a(new o(this, getContext(), eVar, 1.0f), null, 0, null);
        h(h());
        return true;
    }

    public boolean b(e eVar, Runnable runnable) {
        if (g(eVar) != null || !super.c(new o(this, getContext(), eVar, 1.0f), runnable)) {
            return false;
        }
        h(h());
        return true;
    }

    public boolean c(e eVar) {
        if (g(eVar) != null) {
            return false;
        }
        a(new l(this, getContext(), eVar, 1.0f), null, 0, null);
        h(h());
        return true;
    }

    public boolean c(e eVar, Runnable runnable) {
        if (g(eVar) != null) {
            return false;
        }
        a(new l(this, getContext(), eVar, 1.0f), a(AnimationType.IN, eVar), (int) HttpStatus.SC_MULTIPLE_CHOICES, runnable);
        h(h());
        return true;
    }

    public boolean d(e eVar, Runnable runnable) {
        if (!super.d(eVar, runnable)) {
            return false;
        }
        i(e(eVar));
        return true;
    }

    protected boolean onRequestDetach(e eVar) {
        if (eVar instanceof l) {
            i(((fy) eVar).b());
        }
        return super.onRequestDetach(eVar);
    }

    protected Animation a(AnimationType animationType, e eVar) {
        if (!(g(eVar) instanceof o)) {
            return super.a(animationType, eVar);
        }
        switch (k.a[animationType.ordinal()]) {
            case 1:
                return new AlphaAnimation(1.0f, 0.0f);
            default:
                return null;
        }
    }

    protected Animation a(AnimationType animationType) {
        switch (k.a[animationType.ordinal()]) {
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

    protected void a(fy fyVar, float f) {
        super.a(fyVar, f);
        e d = d(fyVar.b());
        if (d == null) {
            g();
            return;
        }
        a(f);
        d.getContentView();
        if (Float.compare(f, 0.0f) == 0) {
            a();
        }
    }

    protected boolean a(fy fyVar) {
        if (fyVar instanceof o) {
            return false;
        }
        return super.a(fyVar);
    }

    private void a(float f) {
        fy l = l();
        if (l != null && !(l instanceof o)) {
            float min = Math.min(1.0f - f, ((l) l).a());
            int i = i() - 2;
            while (i >= 0) {
                float a;
                fy f2 = f(i);
                if (f2 instanceof l) {
                    a = ((l) f2).a();
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
                i--;
                min = a;
            }
        }
    }

    private void h(e eVar) {
        e d = d(eVar);
        if (d != null) {
            dv.a(d.getContentView(), 1.0f, 0.3f, (int) HttpStatus.SC_MULTIPLE_CHOICES, true, new j(this));
        }
    }

    private void a() {
        fy l = l();
        if (l != null) {
            float a = ((l) l).a();
            for (int i = 0; i < i() - 1; i++) {
                fy f = f(i);
                if ((f instanceof l) && Float.compare(((l) f).a(), a) <= 0) {
                    f.getContentView().setVisibility(8);
                }
            }
        }
    }

    private void i(e eVar) {
        float f = 0.0f;
        int f2 = f(eVar);
        while (f2 >= 0) {
            float a;
            fy g = g(d(f2));
            if (g instanceof l) {
                a = ((l) g).a();
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
        e d = d(eVar);
        if (d != null) {
            dv.a(d.getContentView(), 0.3f, 1.0f, (int) HttpStatus.SC_MULTIPLE_CHOICES, false, null);
        }
    }
}
