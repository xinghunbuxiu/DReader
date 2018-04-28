package com.duokan.reader.ui.reading;

import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.BaseActivity;
import com.duokan.core.app.IScreenRotationChangedListener;
import com.duokan.core.ui.C0380do;
import com.duokan.core.ui.di;
import com.duokan.core.ui.dn;
import com.duokan.core.ui.et;
import com.duokan.p024c.C0258j;
import com.duokan.reader.DkApp;
import com.duokan.reader.domain.document.C0908f;
import com.duokan.reader.domain.document.C0932e;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.av;
import com.duokan.reader.ui.general.PagesView;
import java.util.Iterator;
import java.util.LinkedList;

class cq extends ActivatedController implements IScreenRotationChangedListener, acd {
    /* renamed from: a */
    private final su f9949a;
    /* renamed from: b */
    private final PagesView f9950b;
    /* renamed from: c */
    private final di f9951c;
    /* renamed from: d */
    private final acf f9952d;
    /* renamed from: e */
    private final acb f9953e;
    /* renamed from: f */
    private final LinkedList<ace> f9954f = new LinkedList();
    /* renamed from: g */
    private int f9955g = -1;
    /* renamed from: h */
    private int f9956h = -1;
    /* renamed from: i */
    private int f9957i = -1;

    public cq(IFeature mFeature, su suVar, wy wyVar) {
        super(mFeature);
        this.f9949a = suVar;
        this.f9950b = wyVar.getShowingPagesView();
        this.f9951c = new di(getContext());
        this.f9952d = new acf(getContext(), null);
        this.f9952d.setEnabled(false);
        this.f9951c.addView(this.f9952d, new dn(-1, -1, 17));
        this.f9951c.setVisibility(4);
        setContentView(this.f9951c);
        this.f9953e = new cr(this);
        this.f9949a.mo2021a(new cx(this));
        et etVar = new et();
        etVar.m2041a(new da(this));
        etVar.m2046b(this.f9952d);
    }

    /* renamed from: a */
    public void ScreenRotationChanged(int i) {
        if (!DkApp.get().forHd() && this.f9951c.getVisibility() == 0) {
            C0380do b = this.f9951c.m1836b(this.f9952d);
            b.m1858d((float) i);
            this.f9951c.m1835a(this.f9952d, b);
        }
    }

    /* renamed from: a */
    public void mo2286a() {
        as aa = this.f9949a.aa();
        aa.mo1282E();
        int a = this.f9949a.getDocument().mo1247m().mo1253a(aa.mo1332l().mo1198g());
        if (a < 0) {
            a = this.f9949a.getDocument().mo1247m().mo1252a() - 1;
        }
        m13870b(a);
    }

    /* renamed from: b */
    public void m13870b(int i) {
        if (m13863r() != null && !this.f9952d.isEnabled()) {
            this.f9949a.mo2040a(2, 0);
            this.f9955g = i;
            this.f9951c.setVisibility(0);
            this.f9952d.setEnabled(true);
            C0932e a = m13863r().mo1254a(i);
            if (a != null) {
                this.f9949a.aQ();
                this.f9949a.mo2103b(new ct(this, a, i));
            }
        }
    }

    /* renamed from: b */
    public void mo2290b() {
        if (this.f9952d.isEnabled()) {
            this.f9952d.setEnabled(false);
            this.f9949a.mo2024a(m13863r().mo1254a(this.f9955g).mo1429a());
            this.f9949a.mo2103b(new cv(this));
        }
    }

    /* renamed from: c */
    public int mo2291c() {
        return m13863r().mo1252a();
    }

    /* renamed from: d */
    public int mo2293d() {
        return this.f9955g;
    }

    /* renamed from: e */
    public av mo2294e() {
        return m13875d(mo2293d());
    }

    /* renamed from: f */
    public boolean mo2295f() {
        return this.f9951c.getVisibility() == 0;
    }

    /* renamed from: g */
    public void mo2296g() {
        m13868a(this.f9949a.mo2005V() == SlideShowEffect.SIMPLE);
    }

    /* renamed from: a */
    public void m13868a(boolean z) {
        if (this.f9955g - 1 >= 0) {
            int i = this.f9955g;
            this.f9955g = i - 1;
            this.f9952d.m13311a(this.f9953e.mo2303a(this.f9955g), z, null);
            m13852a(i, this.f9955g);
        }
    }

    /* renamed from: h */
    public void mo2297h() {
        m13871b(this.f9949a.mo2005V() == SlideShowEffect.SIMPLE);
    }

    /* renamed from: b */
    public void m13871b(boolean z) {
        if (this.f9955g + 1 < mo2291c()) {
            int i = this.f9955g;
            this.f9955g = i + 1;
            this.f9952d.m13311a(this.f9953e.mo2303a(this.f9955g), z, null);
            m13852a(i, this.f9955g);
        }
    }

    /* renamed from: c */
    public void mo2292c(int i) {
        mo2288a(i, this.f9949a.mo2005V() == SlideShowEffect.SIMPLE);
    }

    /* renamed from: a */
    public void mo2289a(av avVar, boolean z) {
        int a = this.f9949a.getDocument().mo1247m().mo1253a(avVar);
        if (a < 0) {
            a = this.f9949a.getDocument().mo1247m().mo1252a() - 1;
        }
        mo2288a(a, z);
    }

    /* renamed from: a */
    public void mo2288a(int i, boolean z) {
        if (i >= 0 && i < mo2291c()) {
            int i2 = this.f9955g;
            this.f9955g = i;
            this.f9952d.m13311a(this.f9953e.mo2303a(this.f9955g), z, null);
            m13852a(i2, this.f9955g);
        }
    }

    /* renamed from: d */
    public av m13875d(int i) {
        return m13863r().mo1254a(i).mo1429a();
    }

    /* renamed from: i */
    public boolean mo2298i() {
        return (this.f9956h == -1 || this.f9956h == this.f9955g) ? false : true;
    }

    /* renamed from: j */
    public boolean mo2299j() {
        return (this.f9957i == -1 || this.f9957i == this.f9955g) ? false : true;
    }

    /* renamed from: k */
    public void mo2300k() {
        this.f9957i = this.f9955g;
        this.f9956h = -1;
    }

    /* renamed from: l */
    public void mo2301l() {
        if (mo2298i()) {
            int i = this.f9955g;
            mo2288a(this.f9956h, false);
            this.f9957i = i;
            this.f9956h = -1;
        }
    }

    /* renamed from: m */
    public void mo2302m() {
        if (mo2299j()) {
            int i = this.f9955g;
            mo2288a(this.f9957i, false);
            this.f9956h = i;
            this.f9957i = -1;
        }
    }

    /* renamed from: n */
    public boolean m13885n() {
        return this.f9955g == 0;
    }

    /* renamed from: o */
    public boolean m13886o() {
        return this.f9955g == mo2291c() + -1;
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
        ((BaseActivity) getActivity()).addOnScreenRotationChangedListener(this);
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        ((BaseActivity) getActivity()).removeOnScreenRotationChangedListener(this);
    }

    protected boolean onBack() {
        if (!mo2295f()) {
            return false;
        }
        this.f9949a.mo2180v().goHome(null);
        return true;
    }

    /* renamed from: a */
    private void m13852a(int i, int i2) {
        Iterator it = this.f9954f.iterator();
        while (it.hasNext()) {
            ((ace) it.next()).m13301a(i, i2);
        }
    }

    /* renamed from: p */
    private boolean m13861p() {
        if (!m13886o()) {
            return true;
        }
        this.f9949a.mo2180v().prompt(getString(C0258j.reading__shared__reach_last_page));
        return false;
    }

    /* renamed from: q */
    private boolean m13862q() {
        if (!m13885n()) {
            return true;
        }
        this.f9949a.mo2180v().prompt(getString(C0258j.reading__shared__reach_first_page));
        return false;
    }

    /* renamed from: r */
    private C0908f m13863r() {
        return this.f9949a.getDocument().mo1247m();
    }
}
