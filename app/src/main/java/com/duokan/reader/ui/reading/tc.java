package com.duokan.reader.ui.reading;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.duokan.c.g;
import com.duokan.c.j;
import com.duokan.core.app.e;
import com.duokan.core.app.y;
import com.duokan.core.sys.ah;
import com.duokan.core.ui.dv;
import com.duokan.reader.domain.bookshelf.BookContent;
import com.duokan.reader.domain.document.a;
import com.duokan.reader.domain.document.a.d;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.h;
import com.duokan.reader.domain.document.n;
import com.duokan.reader.ui.general.DkLabelView;

abstract class tc extends to {
    static final /* synthetic */ boolean d = (!tc.class.desiredAssertionStatus());
    protected final DkLabelView a = ((DkLabelView) findViewById(g.reading__reading_menu_bottom_view__go_next_chapter));
    protected final DkLabelView b = ((DkLabelView) findViewById(g.reading__reading_menu_bottom_view__go_prev_chapter));
    protected int c = 0;
    private final View i = findViewById(g.reading__reading_menu_view__top);
    private final View j = findViewById(g.reading__reading_menu_bottom_view__main);
    private final FrameLayout k = ((FrameLayout) findViewById(g.reading__reading_menu_bottom_view__sub_menu_frame));
    private final SeekBar l = ((SeekBar) findViewById(g.reading__reading_menu_bottom_view__seek_bar));
    private final ImageView m = ((ImageView) findViewById(g.reading__reading_menu_bottom_view__page_back));
    private final ImageView n = ((ImageView) findViewById(g.reading__reading_menu_bottom_view__page_forward));
    private final ProgressBar o = ((ProgressBar) findViewById(g.reading__reading_menu_bottom_view__paginating_progress));
    private final FrameLayout p = ((FrameLayout) findViewById(g.reading__reading_menu_bottom_view__seek_bar_status));
    private final TextView q = ((TextView) findViewById(g.reading__reading_menu_bottom_view__chapter));
    private final TextView r = ((TextView) findViewById(g.reading__reading_menu_bottom_view__seek_bar_progress));
    private final FrameLayout s = ((FrameLayout) findViewById(g.reading__reading_menu_bottom_view__side_button));
    private DkLabelView t;
    private e u = null;
    private ak v = null;

    public tc(y yVar) {
        super(yVar);
        findViewById(g.reading__reading_menu_bottom_view__brightness).setOnClickListener(new td(this));
        this.l.setOnSeekBarChangeListener(new te(this));
        this.m.setOnClickListener(new tf(this));
        this.n.setOnClickListener(new tg(this));
        this.a.setOnClickListener(new th(this));
        this.b.setOnClickListener(new ti(this));
    }

    public void g() {
        if (!this.f.Z().c()) {
            n document = this.f.getDocument();
            if (!document.i()) {
                h h = document.h();
                if (this.f.b(2)) {
                    com.duokan.reader.domain.document.g b = h.b(h.b(this.f.w().e()));
                    int i = -1;
                    while (b != null) {
                        i = document.m().a(b.f());
                        if (!d && i < 0) {
                            throw new AssertionError();
                        } else if (i < this.f.w().d()) {
                            break;
                        } else {
                            b = h.b(b);
                        }
                    }
                    if (i < 0) {
                        this.f.v().prompt(getString(j.reading__shared__reach_first_chapter));
                    } else {
                        this.f.w().k();
                        this.f.w().c(i);
                    }
                    this.q.setText(b.e());
                    return;
                }
                this.f.a(1, 0);
                com.duokan.reader.domain.document.g b2 = h.b(h.b(this.f.Z().h()));
                while (b2 != null && this.f.Z().a(b2.f())) {
                    b2 = h.b(b2);
                }
                if (b2 == null) {
                    this.f.v().prompt(getString(j.reading__shared__reach_first_chapter));
                    return;
                }
                this.f.as();
                this.f.a(b2.f());
                this.q.setText(b2.e());
            }
        }
    }

    public void f() {
        if (!this.f.Z().c()) {
            n document = this.f.getDocument();
            if (!document.i()) {
                h h = document.h();
                if (this.f.b(2)) {
                    com.duokan.reader.domain.document.g a = h.a(h.b(this.f.w().e()));
                    if (a == null) {
                        this.f.v().prompt(getString(j.reading__shared__reach_last_chapter));
                        return;
                    }
                    int a2 = document.m().a(a.f());
                    if (a2 < 0) {
                        this.f.v().prompt(getString(j.reading__shared__reach_last_chapter));
                    } else {
                        this.f.w().k();
                        this.f.w().c(a2);
                    }
                    this.q.setText(a.e());
                    return;
                }
                this.f.a(1, 0);
                com.duokan.reader.domain.document.g a3 = h.a(h.b(this.f.Z().g()));
                while (a3 != null && this.f.Z().a(a3.f())) {
                    a3 = h.a(a3);
                }
                if (a3 == null) {
                    this.f.v().prompt(getString(j.reading__shared__reach_last_chapter));
                    return;
                }
                this.f.as();
                this.f.a(a3.f());
                this.q.setText(a3.e());
            }
        }
    }

    public void a(long j) {
        if (this.f.b(2)) {
            this.f.w().k();
            this.f.w().c((int) j);
            return;
        }
        this.f.a(1, 0);
        this.f.as();
        this.f.f(j);
        if (this.f.G().r() == BookContent.AUDIO_TEXT) {
            c();
        }
    }

    protected int h() {
        if (this.f.b(2)) {
            return this.f.w().c();
        }
        return this.f.L();
    }

    protected int i() {
        if (this.f.b(2)) {
            return this.f.w().d();
        }
        return this.f.Y();
    }

    protected boolean j() {
        if (this.f.b(2)) {
            return this.f.w().j();
        }
        return this.f.aq();
    }

    protected boolean k() {
        if (this.f.b(2)) {
            return this.f.w().i();
        }
        return this.f.ar();
    }

    private void d() {
        if (this.f.getDocument().n()) {
            this.a.setVisibility(0);
            this.b.setVisibility(0);
            this.l.setVisibility(0);
            this.o.setVisibility(8);
            this.l.setMax(h() - 1);
            if (this.t != null) {
                this.t.setVisibility(0);
            }
            a(i());
            return;
        }
        this.f.a(new tj(this));
        this.l.setVisibility(8);
        this.o.setVisibility(0);
        this.o.setProgress((int) this.f.getDocument().g());
        if (this.t != null) {
            this.t.setVisibility(8);
        }
    }

    private void a(int i) {
        this.l.setProgress(i);
        this.r.setText(String.format(getContext().getString(j.reading__shared__page_num_with_total_pages), new Object[]{Integer.valueOf(i + 1), Integer.valueOf(h())}));
        n document = this.f.getDocument();
        this.v = document.a((long) i);
        a aVar = this.v;
        document.d(aVar);
        if (this.t != null) {
            this.t.setText(String.format(getContext().getString(j.reading__shared__page_num_with_total_pages), new Object[]{Integer.valueOf(i + 1), Integer.valueOf(h())}));
        }
        ah.a(new tl(this, aVar, document));
    }

    protected void a(e eVar) {
        if (!l() && !this.h) {
            this.u = eVar;
            addSubController(this.u);
            this.k.addView(this.u.getContentView(), new LayoutParams(-1, -2));
            this.k.setVisibility(0);
            activate(this.u);
            this.i.setVisibility(4);
            this.j.setVisibility(4);
            o().setVisibility(4);
            dv.g(this.j, null);
            dv.f(this.i, null);
            dv.e(this.k, null);
        }
    }

    protected boolean l() {
        return this.u != null;
    }

    public boolean dismissTopPopup() {
        this.u = null;
        return super.dismissTopPopup();
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            e();
        }
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
        this.s.setVisibility(0);
        this.m.setVisibility(0);
        this.n.setVisibility(8);
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        if (this.u != null) {
            removeSubController(this.u);
            this.k.removeAllViews();
            this.u = null;
        }
        this.i.setVisibility(0);
        this.j.setVisibility(0);
        this.p.setVisibility(8);
        this.k.setVisibility(8);
        this.k.removeAllViews();
    }

    protected void c() {
        super.c();
        if ((this.f.getDocument() instanceof d) && this.t == null) {
            this.t = (DkLabelView) findViewById(g.reading__reading_menu_view_pdf__fixed_page_num);
        }
        d();
    }

    protected View m() {
        return this.i;
    }

    protected View n() {
        return this.j.getVisibility() == 0 ? this.j : this.k;
    }

    private void e() {
        if (this.f.G().ai()) {
            com.duokan.reader.domain.a.a.a().a(this.f.G().H(), new tn(this));
        }
    }

    protected View o() {
        return this.s;
    }
}
