package com.duokan.reader.ui.reading;

import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.c.j;
import com.duokan.core.app.y;
import com.duokan.reader.domain.audio.AudioPlayer;
import com.duokan.reader.domain.audio.e;
import com.duokan.reader.domain.bookshelf.BookContent;
import com.duokan.reader.domain.bookshelf.BookLimitType;
import com.duokan.reader.domain.bookshelf.BookState;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.it;
import com.duokan.reader.ui.general.jq;

class hq extends po implements it {
    private final e i = new hr(this);
    private final View j = findViewById(g.reading__reading_menu_bottom_view_epub__slide_show);
    private final View k = findViewById(g.reading__reading_menu_view__tip);
    private final View l = findViewById(g.reading__reading_menu_view__buy);
    private final FrameLayout m = ((FrameLayout) findViewById(g.reading__reading_menu_view__comment));
    private final TextView n = ((TextView) findViewById(g.reading__reading_menu_view__comment_count));
    private final ImageView o = ((ImageView) findViewById(g.reading__reading_menu_view__download));
    private final View p = findViewById(g.reading__reading_menu_bottom_view__options__slide_show);
    private final View q = findViewById(g.reading__reading_menu_bottom_view__options);
    private final View r = findViewById(g.reading__reading_menu_bottom_view__brightness);
    private final View s = findViewById(g.reading__reading_menu_bottom_view__read_mode);
    private final com.duokan.core.app.e t = new wg(getContext());
    private final AnimationDrawable u = ((AnimationDrawable) this.o.getDrawable());
    private final ImageView v = ((ImageView) findViewById(g.reading__reading_menu_bottom_view_epub__play_audio));

    public hq(y yVar) {
        super(yVar);
        this.k.setOnClickListener(new ht(this));
        this.l.setOnClickListener(new hx(this));
        this.m.setOnClickListener(new hz(this));
        this.j.setOnClickListener(new ib(this));
        this.s.setOnClickListener(new id(this));
        this.v.setOnClickListener(new ie(this));
        this.p.setOnClickListener(new if(this));
        this.o.setOnClickListener(new ig(this));
    }

    protected void a(com.duokan.core.app.e eVar) {
        this.v.setVisibility(4);
        super.a(eVar);
    }

    protected View a() {
        return inflate(h.reading__reading_menu_view_epub, null);
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
        AudioPlayer.a().a(this.i);
        ai.a().a((it) this);
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        AudioPlayer.a().b(this.i);
        ai.a().b((it) this);
    }

    protected void c() {
        int i = 8;
        int i2 = 0;
        super.c();
        c G = this.f.G();
        View view = this.l;
        int i3 = (G == null || !G.ai() || G.k() || G.aj() || G.K() == 0 || G.p() == BookLimitType.NONE) ? 8 : 0;
        view.setVisibility(i3);
        FrameLayout frameLayout = this.m;
        if (G == null || !this.f.bn()) {
            i3 = 4;
        } else {
            i3 = 0;
        }
        frameLayout.setVisibility(i3);
        view = this.k;
        if (G == null || !this.f.bm()) {
            i3 = 4;
        } else {
            i3 = 0;
        }
        view.setVisibility(i3);
        this.j.setSelected(this.f.b(2));
        View view2 = this.j;
        if (this.f.w().c() > 0) {
            i3 = 0;
        } else {
            i3 = 4;
        }
        view2.setVisibility(i3);
        view2 = this.p;
        if (this.f.b(2)) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view2.setVisibility(i3);
        view2 = this.q;
        if (this.f.b(2)) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        view2.setVisibility(i3);
        view2 = this.r;
        if (this.f.b(2)) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        view2.setVisibility(i3);
        View view3 = this.s;
        if (!this.f.b(2)) {
            i = 0;
        }
        view3.setVisibility(i);
        if (this.c > 99) {
            this.n.setText(j.reading__reading_menu_view__many_comment);
        } else {
            this.n.setText("" + this.c);
        }
        ImageView imageView = this.v;
        if (!e()) {
            i2 = 4;
        }
        imageView.setVisibility(i2);
        if (e()) {
            q();
        }
        r();
    }

    public void a(c cVar) {
        if (!this.f.K() && this.f.G() != null) {
            r();
        }
    }

    private void p() {
        jq jqVar = new jq(getContext());
        jqVar.show();
        new hs(this, jqVar).open();
    }

    private void q() {
        this.v.setSelected(AudioPlayer.a().b());
        this.v.setVisibility(e() ? 0 : 4);
    }

    protected View d() {
        return e() ? this.v : new View(getContext());
    }

    protected boolean e() {
        if (this.f.G().r() != BookContent.AUDIO_TEXT) {
            return false;
        }
        if ((this.f.aT() || this.f.k() == null) && !this.f.j()) {
            return false;
        }
        return true;
    }

    private void r() {
        c G = this.f.G();
        if (!((bm) this.f).g_()) {
            this.o.setVisibility(8);
        } else if (G.V()) {
            this.o.setVisibility(0);
            if (G.X() || G.W()) {
                this.u.stop();
            } else {
                this.u.start();
            }
        } else {
            if (G.k()) {
                this.o.setVisibility(0);
            } else if (G.i() == BookState.PULLING || G.i() == BookState.CLOUD_ONLY) {
                this.o.setVisibility(0);
            } else {
                this.o.setVisibility(8);
            }
            if (this.u.isRunning()) {
                this.u.stop();
                this.u.unscheduleSelf(null);
            }
        }
    }
}
