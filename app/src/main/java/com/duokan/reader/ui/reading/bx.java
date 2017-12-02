package com.duokan.reader.ui.reading;

import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.core.app.e;
import com.duokan.core.app.y;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.bookshelf.BookContent;
import com.duokan.reader.domain.bookshelf.BookState;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.it;

class bx extends tc implements it {
    private final View i = findViewById(g.reading__reading_menu_bottom_view_epub__slide_show);
    private final FrameLayout j = ((FrameLayout) findViewById(g.reading__reading_menu_view__comment));
    private final TextView k = ((TextView) findViewById(g.reading__reading_menu_view__comment_count));
    private final ImageView l = ((ImageView) findViewById(g.reading__reading_menu_view__download));
    private final View m = findViewById(g.reading__reading_menu_bottom_view__options__slide_show);
    private final View n = findViewById(g.reading__reading_menu_bottom_view__options);
    private final View o = findViewById(g.reading__reading_menu_bottom_view__brightness);
    private final e p = new wg(getContext());
    private final AnimationDrawable q = ((AnimationDrawable) this.l.getDrawable());
    private final View r = findViewById(g.reading__reading_menu_view__tip);

    public bx(y yVar) {
        super(yVar);
        this.a.setText(j.reading__seek_page_view__comic_next_chapter);
        this.a.setContentDescription(getString(j.reading__seek_page_view__comic_next_chapter));
        this.b.setText(j.reading__seek_page_view__comic_prev_chapter);
        this.b.setContentDescription(getString(j.reading__seek_page_view__comic_prev_chapter));
        this.r.setOnClickListener(new by(this));
        this.j.setOnClickListener(new cc(this));
        this.i.setOnClickListener(new ce(this));
        this.n.setOnClickListener(new cg(this));
        this.m.setOnClickListener(new ch(this));
        this.l.setOnClickListener(new ci(this));
    }

    protected View a() {
        return inflate(h.reading__reading_menu_view_comic, null);
    }

    protected void b() {
        a(new pw(getContext()));
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
        ai.a().a((it) this);
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        ai.a().b((it) this);
    }

    protected void c() {
        int i = 8;
        int i2 = 4;
        super.c();
        c G = this.f.G();
        FrameLayout frameLayout = this.j;
        int i3 = (G == null || !this.f.bn()) ? 4 : 0;
        frameLayout.setVisibility(i3);
        View view = this.r;
        if (G == null || !this.f.bm()) {
            i3 = 4;
        } else {
            i3 = 0;
        }
        view.setVisibility(i3);
        this.i.setSelected(this.f.b(2));
        View view2 = this.i;
        if (this.f.w().c() > 0) {
            i2 = 0;
        }
        view2.setVisibility(i2);
        View view3 = this.m;
        if (this.f.b(2)) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view3.setVisibility(i3);
        view3 = this.n;
        if (this.f.b(2) || (ReaderEnv.get().forHd() && this.f.G().r() == BookContent.VERTICAL_COMIC)) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        view3.setVisibility(i3);
        view2 = this.o;
        if (!this.f.b(2)) {
            i = 0;
        }
        view2.setVisibility(i);
        if (this.c > 99) {
            this.k.setText(j.reading__reading_menu_view__many_comment);
        } else {
            this.k.setText("" + this.c);
        }
        d();
    }

    private void d() {
        c G = this.f.G();
        if (!G.ai() || G.aj()) {
            this.l.setVisibility(8);
        } else if (G.V()) {
            this.l.setVisibility(0);
            if (G.X() || G.W()) {
                this.q.stop();
            } else {
                this.q.start();
            }
        } else {
            if (G.k()) {
                this.l.setVisibility(0);
            } else if (G.i() == BookState.PULLING || G.i() == BookState.CLOUD_ONLY) {
                this.l.setVisibility(0);
            } else {
                this.l.setVisibility(8);
            }
            if (this.q.isRunning()) {
                this.q.stop();
                this.q.unscheduleSelf(null);
            }
        }
    }

    public void a(c cVar) {
        if (!this.f.K() && this.f.G() != null) {
            d();
        }
    }
}
