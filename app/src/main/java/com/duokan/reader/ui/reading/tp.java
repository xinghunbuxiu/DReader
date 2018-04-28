package com.duokan.reader.ui.reading;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.sys.ah;
import com.duokan.core.ui.dv;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.bookshelf.BookContent;
import com.duokan.reader.domain.document.C0896a;
import com.duokan.reader.domain.document.C0901g;
import com.duokan.reader.domain.document.C0903n;
import com.duokan.reader.domain.document.C0911h;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.p045a.C0904d;
import com.duokan.reader.domain.p041a.C0664a;
import com.duokan.reader.ui.general.DkLabelView;

abstract class tp extends ub {
    /* renamed from: d */
    static final /* synthetic */ boolean f9678d = (!tp.class.desiredAssertionStatus());
    /* renamed from: a */
    protected final DkLabelView f9679a = ((DkLabelView) findViewById(C0255g.reading__reading_menu_bottom_view__go_next_chapter));
    /* renamed from: b */
    protected final DkLabelView f9680b = ((DkLabelView) findViewById(C0255g.reading__reading_menu_bottom_view__go_prev_chapter));
    /* renamed from: c */
    protected int f9681c = 0;
    /* renamed from: i */
    private final View f9682i = findViewById(C0255g.reading__reading_menu_view__top);
    /* renamed from: j */
    private final View f9683j = findViewById(C0255g.reading__reading_menu_bottom_view__main);
    /* renamed from: k */
    private final FrameLayout f9684k = ((FrameLayout) findViewById(C0255g.reading__reading_menu_bottom_view__sub_menu_frame));
    /* renamed from: l */
    private final SeekBar f9685l = ((SeekBar) findViewById(C0255g.reading__reading_menu_bottom_view__seek_bar));
    /* renamed from: m */
    private final ImageView f9686m = ((ImageView) findViewById(C0255g.reading__reading_menu_bottom_view__page_back));
    /* renamed from: n */
    private final ImageView f9687n = ((ImageView) findViewById(C0255g.reading__reading_menu_bottom_view__page_forward));
    /* renamed from: o */
    private final ProgressBar f9688o = ((ProgressBar) findViewById(C0255g.reading__reading_menu_bottom_view__paginating_progress));
    /* renamed from: p */
    private final FrameLayout f9689p = ((FrameLayout) findViewById(C0255g.reading__reading_menu_bottom_view__seek_bar_status));
    /* renamed from: q */
    private final TextView f9690q = ((TextView) findViewById(C0255g.reading__reading_menu_bottom_view__chapter));
    /* renamed from: r */
    private final TextView f9691r = ((TextView) findViewById(C0255g.reading__reading_menu_bottom_view__seek_bar_progress));
    /* renamed from: s */
    private final FrameLayout f9692s = ((FrameLayout) findViewById(C0255g.reading__reading_menu_bottom_view__side_button));
    /* renamed from: t */
    private DkLabelView f9693t;
    /* renamed from: u */
    private ActivatedController f9694u = null;
    /* renamed from: v */
    private ak f9695v = null;

    public tp(IFeature mFeature) {
        super(mFeature);
        findViewById(C0255g.reading__reading_menu_bottom_view__brightness).setOnClickListener(new tq(this));
        this.f9685l.setOnSeekBarChangeListener(new tr(this));
        this.f9686m.setOnClickListener(new ts(this));
        this.f9687n.setOnClickListener(new tt(this));
        this.f9679a.setOnClickListener(new tu(this));
        this.f9680b.setOnClickListener(new tv(this));
    }

    /* renamed from: g */
    public void mo2255g() {
        if (!this.f.mo2009Z().mo1189c()) {
            C0903n document = this.f.getDocument();
            if (!document.mo1242i()) {
                C0911h h = document.mo1240h();
                if (this.f.mo2106b(2)) {
                    C0901g b = h.m6054b(h.mo1267b(this.f.mo2181w().mo2294e()));
                    int i = -1;
                    while (b != null) {
                        i = document.mo1247m().mo1253a(b.mo1203f());
                        if (!f9678d && i < 0) {
                            throw new AssertionError();
                        } else if (i < this.f.mo2181w().mo2293d()) {
                            break;
                        } else {
                            b = h.m6054b(b);
                        }
                    }
                    if (i < 0) {
                        this.f.mo2180v().prompt(getString(C0258j.reading__shared__reach_first_chapter));
                    } else {
                        this.f.mo2181w().mo2300k();
                        this.f.mo2181w().mo2292c(i);
                    }
                    this.f9690q.setText(b.mo1202e());
                    return;
                }
                this.f.mo2040a(1, 0);
                C0901g b2 = h.m6054b(h.mo1267b(this.f.mo2009Z().mo1199h()));
                while (b2 != null && this.f.mo2009Z().m5812a(b2.mo1203f())) {
                    b2 = h.m6054b(b2);
                }
                if (b2 == null) {
                    this.f.mo2180v().prompt(getString(C0258j.reading__shared__reach_first_chapter));
                    return;
                }
                this.f.as();
                this.f.mo2024a(b2.mo1203f());
                this.f9690q.setText(b2.mo1202e());
            }
        }
    }

    /* renamed from: f */
    public void mo2254f() {
        if (!this.f.mo2009Z().mo1189c()) {
            C0903n document = this.f.getDocument();
            if (!document.mo1242i()) {
                C0911h h = document.mo1240h();
                if (this.f.mo2106b(2)) {
                    C0901g a = h.m6047a(h.mo1267b(this.f.mo2181w().mo2294e()));
                    if (a == null) {
                        this.f.mo2180v().prompt(getString(C0258j.reading__shared__reach_last_chapter));
                        return;
                    }
                    int a2 = document.mo1247m().mo1253a(a.mo1203f());
                    if (a2 < 0) {
                        this.f.mo2180v().prompt(getString(C0258j.reading__shared__reach_last_chapter));
                    } else {
                        this.f.mo2181w().mo2300k();
                        this.f.mo2181w().mo2292c(a2);
                    }
                    this.f9690q.setText(a.mo1202e());
                    return;
                }
                this.f.mo2040a(1, 0);
                C0901g a3 = h.m6047a(h.mo1267b(this.f.mo2009Z().mo1198g()));
                while (a3 != null && this.f.mo2009Z().m5812a(a3.mo1203f())) {
                    a3 = h.m6047a(a3);
                }
                if (a3 == null) {
                    this.f.mo2180v().prompt(getString(C0258j.reading__shared__reach_last_chapter));
                    return;
                }
                this.f.as();
                this.f.mo2024a(a3.mo1203f());
                this.f9690q.setText(a3.mo1202e());
            }
        }
    }

    /* renamed from: a */
    public void mo2252a(long j) {
        if (this.f.mo2106b(2)) {
            this.f.mo2181w().mo2300k();
            this.f.mo2181w().mo2292c((int) j);
            return;
        }
        this.f.mo2040a(1, 0);
        this.f.as();
        this.f.mo2141f(j);
        if (this.f.mo1992G().m4246r() == BookContent.AUDIO_TEXT) {
            mo2249c();
        }
    }

    /* renamed from: h */
    protected int m13621h() {
        if (this.f.mo2106b(2)) {
            return this.f.mo2181w().mo2291c();
        }
        return this.f.mo1995L();
    }

    /* renamed from: i */
    protected int m13622i() {
        if (this.f.mo2106b(2)) {
            return this.f.mo2181w().mo2293d();
        }
        return this.f.mo2008Y();
    }

    /* renamed from: j */
    protected boolean m13623j() {
        if (this.f.mo2106b(2)) {
            return this.f.mo2181w().mo2299j();
        }
        return this.f.aq();
    }

    /* renamed from: k */
    protected boolean m13624k() {
        if (this.f.mo2106b(2)) {
            return this.f.mo2181w().mo2298i();
        }
        return this.f.ar();
    }

    /* renamed from: d */
    private void mo2385d() {
        if (this.f.getDocument().m5943n()) {
            this.f9679a.setVisibility(0);
            this.f9680b.setVisibility(0);
            this.f9685l.setVisibility(0);
            this.f9688o.setVisibility(8);
            this.f9685l.setMax(m13621h() - 1);
            if (this.f9693t != null) {
                this.f9693t.setVisibility(0);
            }
            m13603a(m13622i());
            return;
        }
        this.f.mo2034a(new tw(this));
        this.f9685l.setVisibility(8);
        this.f9688o.setVisibility(0);
        this.f9688o.setProgress((int) this.f.getDocument().mo1238g());
        if (this.f9693t != null) {
            this.f9693t.setVisibility(8);
        }
    }

    /* renamed from: a */
    private void m13603a(int i) {
        this.f9685l.setProgress(i);
        this.f9691r.setText(String.format(getContext().getString(C0258j.reading__shared__page_num_with_total_pages), new Object[]{Integer.valueOf(i + 1), Integer.valueOf(m13621h())}));
        C0903n document = this.f.getDocument();
        this.f9695v = document.mo1213a((long) i);
        C0896a c0896a = this.f9695v;
        document.mo1233d(c0896a);
        if (this.f9693t != null) {
            this.f9693t.setText(String.format(getContext().getString(C0258j.reading__shared__page_num_with_total_pages), new Object[]{Integer.valueOf(i + 1), Integer.valueOf(m13621h())}));
        }
        ah.m865a(new ty(this, c0896a, document));
    }

    /* renamed from: a */
    protected void mo2248a(ActivatedController c0303e) {
        if (!mo2251l() && !this.h) {
            this.f9694u = c0303e;
            addSubController(this.f9694u);
            this.f9684k.addView(this.f9694u.getContentView(), new LayoutParams(-1, -2));
            this.f9684k.setVisibility(0);
            activate(this.f9694u);
            this.f9682i.setVisibility(4);
            this.f9683j.setVisibility(4);
            m13628o().setVisibility(4);
            dv.loadSuccess(this.f9683j, null);
            dv.m1961f(this.f9682i, null);
            dv.m1958e(this.f9684k, null);
        }
    }

    /* renamed from: l */
    protected boolean mo2251l() {
        return this.f9694u != null;
    }

    public boolean dismissTopPopup() {
        this.f9694u = null;
        return super.dismissTopPopup();
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            mo2386e();
        }
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
        this.f9692s.setVisibility(0);
        this.f9686m.setVisibility(0);
        this.f9687n.setVisibility(8);
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        if (this.f9694u != null) {
            removeSubController(this.f9694u);
            this.f9684k.removeAllViews();
            this.f9694u = null;
        }
        this.f9682i.setVisibility(0);
        this.f9683j.setVisibility(0);
        this.f9689p.setVisibility(8);
        this.f9684k.setVisibility(8);
        this.f9684k.removeAllViews();
    }

    /* renamed from: c */
    protected void mo2249c() {
        super.mo2249c();
        if ((this.f.getDocument() instanceof C0904d) && this.f9693t == null) {
            this.f9693t = (DkLabelView) findViewById(C0255g.reading__reading_menu_view_pdf__fixed_page_num);
        }
        mo2385d();
    }

    /* renamed from: m */
    protected View m13626m() {
        return this.f9682i;
    }

    /* renamed from: n */
    protected View m13627n() {
        return this.f9683j.getVisibility() == 0 ? this.f9683j : this.f9684k;
    }

    /* renamed from: e */
    private void mo2386e() {
        if (this.f.mo1992G().ak()) {
            C0664a.m3108a().m3114a(this.f.mo1992G().m4156I(), new ua(this));
        }
    }

    /* renamed from: o */
    protected View m13628o() {
        return this.f9692s;
    }

    /* renamed from: b */
    private void m13606b(int i) {
        if (this.f9681c != i) {
            this.f9681c = i;
            if (isActive()) {
                mo2249c();
            }
        }
    }
}
