package com.duokan.reader.ui.reading;

import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.bookshelf.BookContent;
import com.duokan.reader.domain.bookshelf.BookState;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.in;

class bz extends tp implements in {
    /* renamed from: i */
    private final View f9915i = findViewById(C0255g.reading__reading_menu_bottom_view_epub__slide_show);
    /* renamed from: j */
    private final FrameLayout f9916j = ((FrameLayout) findViewById(C0255g.reading__reading_menu_view__comment));
    /* renamed from: k */
    private final TextView f9917k = ((TextView) findViewById(C0255g.reading__reading_menu_view__comment_count));
    /* renamed from: l */
    private final ImageView f9918l = ((ImageView) findViewById(C0255g.reading__reading_menu_view__download));
    /* renamed from: m */
    private final View f9919m = findViewById(C0255g.reading__reading_menu_bottom_view__options__slide_show);
    /* renamed from: n */
    private final View f9920n = findViewById(C0255g.reading__reading_menu_bottom_view__options);
    /* renamed from: o */
    private final View f9921o = findViewById(C0255g.reading__reading_menu_bottom_view__brightness);
    /* renamed from: p */
    private final ActivatedController f9922p = new wt(getContext());
    /* renamed from: q */
    private final AnimationDrawable f9923q = ((AnimationDrawable) this.f9918l.getDrawable());
    /* renamed from: r */
    private final View f9924r = findViewById(C0255g.reading__reading_menu_view__tip);

    public bz(IFeature mFeature) {
        super(mFeature);
        this.a.setText(C0258j.reading__seek_page_view__comic_next_chapter);
        this.a.setContentDescription(getString(C0258j.reading__seek_page_view__comic_next_chapter));
        this.b.setText(C0258j.reading__seek_page_view__comic_prev_chapter);
        this.b.setContentDescription(getString(C0258j.reading__seek_page_view__comic_prev_chapter));
        this.f9924r.setOnClickListener(new ca(this));
        this.f9916j.setOnClickListener(new ce(this));
        this.f9915i.setOnClickListener(new cg(this));
        this.f9920n.setOnClickListener(new ci(this));
        this.f9919m.setOnClickListener(new cj(this));
        this.f9918l.setOnClickListener(new ck(this));
    }

    /* renamed from: a */
    protected View mo2256a() {
        return inflate(C0256h.reading__reading_menu_view_comic, null);
    }

    /* renamed from: b */
    protected void mo2253b() {
        mo2248a(new qg(getContext()));
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
        ai.m3980a().m3887a((in) this);
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        ai.m3980a().m3910b((in) this);
    }

    /* renamed from: c */
    protected void mo2249c() {
        int i = 8;
        int i2 = 4;
        super.mo2249c();
        C0800c G = this.f.mo1992G();
        FrameLayout frameLayout = this.f9916j;
        int i3 = (G == null || !this.f.bo()) ? 4 : 0;
        frameLayout.setVisibility(i3);
        View view = this.f9924r;
        if (G == null || !this.f.bn()) {
            i3 = 4;
        } else {
            i3 = 0;
        }
        view.setVisibility(i3);
        this.f9915i.setSelected(this.f.mo2106b(2));
        View view2 = this.f9915i;
        if (this.f.mo2181w().mo2291c() > 0) {
            i2 = 0;
        }
        view2.setVisibility(i2);
        View view3 = this.f9919m;
        if (this.f.mo2106b(2)) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view3.setVisibility(i3);
        view3 = this.f9920n;
        if (this.f.mo2106b(2) || (ReaderEnv.get().forHd() && this.f.mo1992G().m4246r() == BookContent.VERTICAL_COMIC)) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        view3.setVisibility(i3);
        view2 = this.f9921o;
        if (!this.f.mo2106b(2)) {
            i = 0;
        }
        view2.setVisibility(i);
        if (this.c > 99) {
            this.f9917k.setText(C0258j.reading__reading_menu_view__many_comment);
        } else {
            this.f9917k.setText("" + this.c);
        }
        m13841d();
    }

    /* renamed from: d */
    private void m13841d() {
        C0800c G = this.f.mo1992G();
        if (!G.ak() || G.al()) {
            this.f9918l.setVisibility(8);
        } else if (G.m4171X()) {
            this.f9918l.setVisibility(0);
            if (G.m4173Z() || G.m4172Y()) {
                this.f9923q.stop();
            } else {
                this.f9923q.start();
            }
        } else {
            if (G.mo1038k()) {
                this.f9918l.setVisibility(0);
            } else if (G.m4233i() == BookState.PULLING || G.m4233i() == BookState.CLOUD_ONLY) {
                this.f9918l.setVisibility(0);
            } else {
                this.f9918l.setVisibility(8);
            }
            if (this.f9923q.isRunning()) {
                this.f9923q.stop();
                this.f9923q.unscheduleSelf(null);
            }
        }
    }

    /* renamed from: a */
    public void mo1683a(C0800c c0800c) {
        if (!this.f.mo1994K() && this.f.mo1992G() != null) {
            m13841d();
        }
    }
}
