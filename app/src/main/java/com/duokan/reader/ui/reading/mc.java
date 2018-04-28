package com.duokan.reader.ui.reading;

import android.content.res.Configuration;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.reader.domain.document.ah;
import com.duokan.reader.ui.reading.p054a.C1442w;
import com.duokan.reader.ui.reading.p054a.C1445z;

public class mc extends ActivatedController implements C1445z {
    /* renamed from: a */
    private final su f10617a;
    /* renamed from: b */
    private final wy f10618b;
    /* renamed from: c */
    private mh f10619c;
    /* renamed from: d */
    private C1442w f10620d = new C1442w(this);

    public mc(IFeature mFeature, su suVar, wy wyVar) {
        super(mFeature);
        this.f10617a = suVar;
        this.f10618b = wyVar;
        this.f10620d.m1607a(false);
        this.f10617a.mo2033a(new md(this));
    }

    /* renamed from: a */
    public void m14639a(ah ahVar, Rect rect, mg mgVar) {
        if (this.f10619c != null) {
            if (ahVar == this.f10619c.m13679d()) {
                this.f10619c.mo2514c();
                return;
            }
            m14643c();
        }
        this.f10620d.m1607a(true);
        m14635b(ahVar, rect, mgVar);
        if (this.f10619c != null) {
            this.f10618b.addView(this.f10619c.mo2270b(), new LayoutParams(-1, -1));
        }
    }

    /* renamed from: a */
    public boolean m14640a() {
        if (this.f10619c != null) {
            return this.f10619c.mo2271f();
        }
        return false;
    }

    /* renamed from: b */
    public C1442w m14642b() {
        return this.f10620d;
    }

    /* renamed from: c */
    public void m14643c() {
        m14640a();
    }

    protected boolean onBack() {
        return m14640a();
    }

    protected boolean onShowMenu() {
        if (this.f10619c != null) {
            return this.f10619c.mo2273i();
        }
        return false;
    }

    protected boolean onHideMenu() {
        if (this.f10619c != null) {
            return this.f10619c.mo2274j();
        }
        return true;
    }

    protected boolean onCheckMenuShowing() {
        if (this.f10619c != null) {
            return this.f10619c.mo2272h();
        }
        return false;
    }

    protected void onActivityPaused() {
        if (this.f10619c != null) {
            this.f10619c.m13682g();
        }
    }

    protected void onActivityConfigurationChanged(Configuration configuration) {
        if (this.f10619c != null) {
            this.f10619c.mo2267a(configuration);
        }
    }

    /* renamed from: a */
    public boolean mo2269a(View view, PointF pointF) {
        if (this.f10619c != null) {
            return this.f10619c.mo2269a(view, pointF);
        }
        return false;
    }

    /* renamed from: a */
    public void mo2268a(View view, PointF pointF, float f) {
        if (this.f10619c != null) {
            this.f10619c.mo2268a(view, pointF, f);
        }
    }

    /* renamed from: b */
    private void m14635b(ah ahVar, Rect rect, mg mgVar) {
        if (ahVar.mo1413d()) {
            this.f10619c = new C1473y(getActivity(), this.f10617a, ahVar, rect, new me(this, mgVar));
        } else if (ahVar.mo1414e()) {
            this.f10619c = new agh(getActivity(), this.f10617a, ahVar, rect, new mf(this, mgVar));
        }
    }
}
