package com.duokan.reader.ui.reading;

import com.duokan.c.j;
import com.duokan.core.app.e;
import com.duokan.core.app.m;
import com.duokan.core.app.s;
import com.duokan.core.app.y;
import com.duokan.core.ui.*;
import com.duokan.core.ui.di;
import com.duokan.core.ui.dn;
import com.duokan.core.ui.et;
import com.duokan.reader.DkApp;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.av;
import com.duokan.reader.domain.document.f;
import com.duokan.reader.ui.general.PagesView;

import java.util.Iterator;
import java.util.LinkedList;

do;

class co extends e implements s, abq {
    private final sh a;
    private final PagesView b;
    private final di c;
    private final abs d;
    private final abo e;
    private final LinkedList f = new LinkedList();
    private int g = -1;
    private int h = -1;
    private int i = -1;

    public co(y yVar, sh shVar, wl wlVar) {
        super(yVar);
        this.a = shVar;
        this.b = wlVar.getShowingPagesView();
        this.c = new di(getContext());
        this.d = new abs(getContext(), null);
        this.d.setEnabled(false);
        this.c.addView(this.d, new dn(-1, -1, 17));
        this.c.setVisibility(4);
        setContentView(this.c);
        this.e = new cp(this);
        this.a.a(new cv(this));
        et etVar = new et();
        etVar.a(new cy(this));
        etVar.b(this.d);
    }

    public void a(int i) {
        if (!DkApp.get().forHd() && this.c.getVisibility() == 0) {
            do b = this.c.b(this.d);
            b.d((float) i);
            this.c.a(this.d, b);
        }
    }

    public void a() {
        as aa = this.a.aa();
        aa.E();
        int a = this.a.getDocument().m().a(aa.l().g());
        if (a < 0) {
            a = this.a.getDocument().m().a() - 1;
        }
        b(a);
    }

    public void b(int i) {
        if (r() != null && !this.d.isEnabled()) {
            this.a.a(2, 0);
            this.g = i;
            this.c.setVisibility(0);
            this.d.setEnabled(true);
            com.duokan.reader.domain.document.e a = r().a(i);
            if (a != null) {
                this.a.aQ();
                this.a.b(new cr(this, a, i));
            }
        }
    }

    public void b() {
        if (this.d.isEnabled()) {
            this.d.setEnabled(false);
            this.a.a(r().a(this.g).a());
            this.a.b(new ct(this));
        }
    }

    public int c() {
        return r().a();
    }

    public int d() {
        return this.g;
    }

    public av e() {
        return d(d());
    }

    public boolean f() {
        return this.c.getVisibility() == 0;
    }

    public void g() {
        a(this.a.V() == SlideShowEffect.SIMPLE);
    }

    public void a(boolean z) {
        if (this.g - 1 >= 0) {
            int i = this.g;
            this.g = i - 1;
            this.d.a(this.e.a(this.g), z, null);
            a(i, this.g);
        }
    }

    public void h() {
        b(this.a.V() == SlideShowEffect.SIMPLE);
    }

    public void b(boolean z) {
        if (this.g + 1 < c()) {
            int i = this.g;
            this.g = i + 1;
            this.d.a(this.e.a(this.g), z, null);
            a(i, this.g);
        }
    }

    public void c(int i) {
        a(i, this.a.V() == SlideShowEffect.SIMPLE);
    }

    public void a(av avVar, boolean z) {
        int a = this.a.getDocument().m().a(avVar);
        if (a < 0) {
            a = this.a.getDocument().m().a() - 1;
        }
        a(a, z);
    }

    public void a(int i, boolean z) {
        if (i >= 0 && i < c()) {
            int i2 = this.g;
            this.g = i;
            this.d.a(this.e.a(this.g), z, null);
            a(i2, this.g);
        }
    }

    public av d(int i) {
        return r().a(i).a();
    }

    public boolean i() {
        return (this.h == -1 || this.h == this.g) ? false : true;
    }

    public boolean j() {
        return (this.i == -1 || this.i == this.g) ? false : true;
    }

    public void k() {
        this.i = this.g;
        this.h = -1;
    }

    public void l() {
        if (i()) {
            int i = this.g;
            a(this.h, false);
            this.i = i;
            this.h = -1;
        }
    }

    public void m() {
        if (j()) {
            int i = this.g;
            a(this.i, false);
            this.h = i;
            this.i = -1;
        }
    }

    public boolean n() {
        return this.g == 0;
    }

    public boolean o() {
        return this.g == c() + -1;
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
        ((m) getActivity()).addOnScreenRotationChangedListener(this);
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        ((m) getActivity()).removeOnScreenRotationChangedListener(this);
    }

    protected boolean onBack() {
        if (!f()) {
            return false;
        }
        this.a.v().goHome(null);
        return true;
    }

    private void a(int i, int i2) {
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            ((abr) it.next()).a(i, i2);
        }
    }

    private boolean p() {
        if (!o()) {
            return true;
        }
        this.a.v().prompt(getString(j.reading__shared__reach_last_page));
        return false;
    }

    private boolean q() {
        if (!n()) {
            return true;
        }
        this.a.v().prompt(getString(j.reading__shared__reach_first_page));
        return false;
    }

    private f r() {
        return this.a.getDocument().m();
    }
}
