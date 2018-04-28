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
import com.duokan.reader.common.webservices.duokan.C0630c;
import com.duokan.reader.domain.audio.AudioPlayer;
import com.duokan.reader.domain.audio.C0774e;
import com.duokan.reader.domain.bookshelf.BookContent;
import com.duokan.reader.domain.bookshelf.BookLimitType;
import com.duokan.reader.domain.bookshelf.BookState;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.in;
import com.duokan.reader.ui.general.ja;

class ia extends py implements in {
    /* renamed from: i */
    private final C0774e f10364i = new ib(this);
    /* renamed from: j */
    private final View f10365j = findViewById(C0255g.reading__reading_menu_bottom_view_epub__slide_show);
    /* renamed from: k */
    private final View f10366k = findViewById(C0255g.reading__reading_menu_view__tip);
    /* renamed from: l */
    private final View f10367l = findViewById(C0255g.reading__reading_menu_view__buy);
    /* renamed from: m */
    private final FrameLayout f10368m = ((FrameLayout) findViewById(C0255g.reading__reading_menu_view__comment));
    /* renamed from: n */
    private final TextView f10369n = ((TextView) findViewById(C0255g.reading__reading_menu_view__comment_count));
    /* renamed from: o */
    private final ImageView f10370o = ((ImageView) findViewById(C0255g.reading__reading_menu_view__download));
    /* renamed from: p */
    private final View f10371p = findViewById(C0255g.reading__reading_menu_bottom_view__options__slide_show);
    /* renamed from: q */
    private final View f10372q = findViewById(C0255g.reading__reading_menu_bottom_view__options);
    /* renamed from: r */
    private final View f10373r = findViewById(C0255g.reading__reading_menu_bottom_view__brightness);
    /* renamed from: s */
    private final View f10374s = findViewById(C0255g.reading__reading_menu_bottom_view__read_mode);
    /* renamed from: t */
    private final ActivatedController f10375t = new wt(getContext());
    /* renamed from: u */
    private final AnimationDrawable f10376u = ((AnimationDrawable) this.f10370o.getDrawable());
    /* renamed from: v */
    private final ImageView f10377v = ((ImageView) findViewById(C0255g.reading__reading_menu_bottom_view_epub__play_audio));

    public ia(IFeature mFeature) {
        super(mFeature);
        this.f10366k.setOnClickListener(new id(this));
        this.f10367l.setOnClickListener(new ih(this));
        this.f10368m.setOnClickListener(new ij(this));
        this.f10365j.setOnClickListener(new il(this));
        this.f10374s.setOnClickListener(new in(this));
        this.f10377v.setOnClickListener(new io(this));
        this.f10371p.setOnClickListener(new ip(this));
        this.f10370o.setOnClickListener(new iq(this));
    }

    /* renamed from: a */
    protected void mo2248a(ActivatedController c0303e) {
        this.f10377v.setVisibility(4);
        super.mo2248a(c0303e);
    }

    /* renamed from: a */
    protected View mo2256a() {
        return inflate(C0256h.reading__reading_menu_view_epub, null);
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
        AudioPlayer.m3613a().m3637a(this.f10364i);
        ai.m3980a().m3887a((in) this);
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        AudioPlayer.m3613a().m3640b(this.f10364i);
        ai.m3980a().m3910b((in) this);
    }

    /* renamed from: c */
    protected void mo2249c() {
        int i = 8;
        int i2 = 0;
        super.mo2249c();
        C0800c G = this.f.mo1992G();
        View view = this.f10367l;
        int i3 = (G == null || !G.ak() || G.mo1038k() || G.al() || G.m4159L() == 0 || G.m4243p() == BookLimitType.NONE) ? 8 : 0;
        view.setVisibility(i3);
        FrameLayout frameLayout = this.f10368m;
        if (G == null || !this.f.bo()) {
            i3 = 4;
        } else {
            i3 = 0;
        }
        frameLayout.setVisibility(i3);
        view = this.f10366k;
        if (G == null || !this.f.bn()) {
            i3 = 4;
        } else {
            i3 = 0;
        }
        view.setVisibility(i3);
        this.f10365j.setSelected(this.f.mo2106b(2));
        View view2 = this.f10365j;
        if (this.f.mo2181w().mo2291c() > 0) {
            i3 = 0;
        } else {
            i3 = 4;
        }
        view2.setVisibility(i3);
        view2 = this.f10371p;
        if (this.f.mo2106b(2)) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view2.setVisibility(i3);
        view2 = this.f10372q;
        if (this.f.mo2106b(2)) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        view2.setVisibility(i3);
        view2 = this.f10373r;
        if (this.f.mo2106b(2)) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        view2.setVisibility(i3);
        View view3 = this.f10374s;
        if (!this.f.mo2106b(2)) {
            i = 0;
        }
        view3.setVisibility(i);
        if (this.c > 99) {
            this.f10369n.setText(C0258j.reading__reading_menu_view__many_comment);
        } else {
            this.f10369n.setText("" + this.c);
        }
        ImageView imageView = this.f10377v;
        if (!mo2386e()) {
            i2 = 4;
        }
        imageView.setVisibility(i2);
        if (mo2386e()) {
            m14427q();
        }
        m14428r();
    }

    /* renamed from: a */
    public void mo1683a(C0800c c0800c) {
        if (!this.f.mo1994K() && this.f.mo1992G() != null) {
            m14428r();
        }
    }

    /* renamed from: p */
    private void m14426p() {
        ja jaVar = new ja(getContext());
        jaVar.show();
        new ic(this, C0630c.f2119a, jaVar).open();
    }

    /* renamed from: q */
    private void m14427q() {
        this.f10377v.setSelected(AudioPlayer.m3613a().m3641b());
        this.f10377v.setVisibility(mo2386e() ? 0 : 4);
    }

    /* renamed from: d */
    protected View mo2385d() {
        return mo2386e() ? this.f10377v : new View(getContext());
    }

    /* renamed from: e */
    protected boolean mo2386e() {
        if (this.f.mo1992G().m4246r() != BookContent.AUDIO_TEXT) {
            return false;
        }
        if ((this.f.aT() || this.f.mo2161k() == null) && !this.f.mo2160j()) {
            return false;
        }
        return true;
    }

    /* renamed from: r */
    private void m14428r() {
        C0800c G = this.f.mo1992G();
        if (!((bm) this.f).h_()) {
            this.f10370o.setVisibility(8);
        } else if (G.m4171X()) {
            this.f10370o.setVisibility(0);
            if (G.m4173Z() || G.m4172Y()) {
                this.f10376u.stop();
            } else {
                this.f10376u.start();
            }
        } else {
            if (G.mo1038k()) {
                this.f10370o.setVisibility(0);
            } else if (G.m4233i() == BookState.PULLING || G.m4233i() == BookState.CLOUD_ONLY) {
                this.f10370o.setVisibility(0);
            } else {
                this.f10370o.setVisibility(8);
            }
            if (this.f10376u.isRunning()) {
                this.f10376u.stop();
                this.f10376u.unscheduleSelf(null);
            }
        }
    }
}
