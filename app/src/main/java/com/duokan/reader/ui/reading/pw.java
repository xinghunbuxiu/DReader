package com.duokan.reader.ui.reading;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.duokan.core.app.e;
import com.duokan.core.app.y;
import com.duokan.core.ui.dv;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.ui.general.BookCoverView;

public class pw extends wk {
    private final sh a = ((sh) getContext().queryFeature(sh.class));
    private final View b;
    private final View c;
    private final View d;
    private final View e;
    private final View f;
    private final FrameLayout g;
    private e h = null;

    public pw(y yVar) {
        int i;
        super(yVar);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(this.a.am() ? h.reading__reading_comic_more_horizontal_view : h.reading__reading_comic_more_vertical_view, null);
        viewGroup.setLayoutParams(new LayoutParams(ReaderEnv.get().forHd() ? dv.b(getContext(), 240.0f) : -1, -2));
        setContentView((View) viewGroup);
        this.f = findViewById(g.reading__reading_comic_more_view);
        this.g = (FrameLayout) findViewById(g.reading__reading_comic_more_view__sub_menu_frame);
        c G = this.a.G();
        this.b = findViewById(g.reading__reading_comic_more_view__book_info);
        this.c = this.b.findViewById(g.reading__reading_comic_more_view__book_detail);
        View findViewById = findViewById(g.reading__reading_comic_more_view__split);
        if (G.ai()) {
            this.b.setVisibility(0);
            findViewById.setVisibility(0);
            this.c.setOnClickListener(new px(this, G));
            BookCoverView bookCoverView = (BookCoverView) this.c.findViewById(g.reading__reading_comic_more_view__book_detail_cover);
            bookCoverView.setCover(G);
            bookCoverView.a();
            ((TextView) this.c.findViewById(g.reading__reading_comic_more_view__book_detail_title)).setText(G.aw());
            ((TextView) this.c.findViewById(g.reading__reading_comic_more_view__book_detail_author)).setText(G.B());
        } else {
            this.b.setVisibility(8);
            findViewById.setVisibility(8);
        }
        this.d = this.b.findViewById(g.reading__reading_comic_more_view__auto_pay);
        View view = this.d;
        if (!this.a.G().k() || this.a.G().aj()) {
            i = 8;
        } else {
            i = 0;
        }
        view.setVisibility(i);
        this.d.setOnClickListener(new pz(this));
        this.e = findViewById(g.reading__reading_comic_more_view__bookmark);
        this.e.setOnClickListener(new qa(this));
        findViewById(g.reading__reading_comic_more_view__share).setOnClickListener(new qc(this));
        findViewById(g.reading__reading_comic_more_view__settings).setOnClickListener(new qf(this));
    }

    protected void onActive(boolean z) {
        a();
        super.onActive(z);
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
    }

    protected void onDetachFromStub() {
        if (this.h != null) {
            this.h.requestDetach();
            removeSubController(this.h);
            this.g.removeAllViews();
            this.g.setVisibility(8);
            this.f.setVisibility(0);
        }
        super.onDetachFromStub();
    }

    private void a() {
        boolean z = true;
        this.d.setSelected(this.a.G().a(true));
        View view = this.e;
        if (this.a.W().size() <= 0) {
            z = false;
        }
        view.setSelected(z);
    }
}
