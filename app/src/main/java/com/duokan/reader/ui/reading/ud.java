package com.duokan.reader.ui.reading;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.duokan.core.app.e;
import com.duokan.core.app.y;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.ui.general.BookCoverView;

public class ud extends wk {
    private final sh a = ((sh) getContext().queryFeature(sh.class));
    private final View b;
    private final View c;
    private final View d;
    private final TextView e;
    private final View f;
    private final View g;
    private final FrameLayout h;
    private e i = null;

    public ud(y yVar) {
        int i;
        super(yVar);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(this.a.am() ? g.reading__reading_more_horizontal_view : g.reading__reading_more_vertical_view, null);
        viewGroup.setLayoutParams(new LayoutParams(-1, -2));
        setContentView((View) viewGroup);
        this.g = findViewById(f.reading__reading_more_view);
        this.h = (FrameLayout) findViewById(f.reading__reading_more_view__sub_menu_frame);
        c G = this.a.G();
        this.b = findViewById(f.reading__reading_more_view__book_info);
        this.c = this.b.findViewById(f.reading__reading_more_view__book_detail);
        View findViewById = findViewById(f.reading__reading_more_view__split);
        if (G.ai()) {
            this.b.setVisibility(0);
            findViewById.setVisibility(0);
            this.c.setOnClickListener(new ue(this, G));
            BookCoverView bookCoverView = (BookCoverView) this.c.findViewById(f.reading__reading_more_view__book_detail_cover);
            bookCoverView.setCover(G);
            bookCoverView.a();
            ((TextView) this.c.findViewById(f.reading__reading_more_view__book_detail_title)).setText(G.aw());
            ((TextView) this.c.findViewById(f.reading__reading_more_view__book_detail_author)).setText(G.B());
        } else {
            this.b.setVisibility(8);
            findViewById.setVisibility(8);
        }
        this.d = this.b.findViewById(f.reading__reading_more_view__auto_pay);
        View view = this.d;
        if (!this.a.G().k() || this.a.G().aj()) {
            i = 8;
        } else {
            i = 0;
        }
        view.setVisibility(i);
        this.d.setOnClickListener(new ug(this));
        this.f = findViewById(f.reading__reading_more_view__bookmark);
        this.f.setOnClickListener(new uh(this));
        this.e = (TextView) findViewById(f.reading__reading_more_view__rotate);
        this.e.setOnClickListener(new uj(this));
        findViewById(f.reading__reading_more_view__share).setOnClickListener(new ul(this));
        findViewById(f.reading__reading_more_view__settings).setOnClickListener(new uo(this));
    }

    protected void onActive(boolean z) {
        a();
        super.onActive(z);
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
    }

    protected void onDetachFromStub() {
        if (this.i != null) {
            this.i.requestDetach();
            removeSubController(this.i);
            this.h.removeAllViews();
            this.h.setVisibility(8);
            this.g.setVisibility(0);
        }
        super.onDetachFromStub();
    }

    private void a() {
        boolean z = true;
        int i = 0;
        this.d.setSelected(this.a.G().a(true));
        View view = this.f;
        if (this.a.W().size() <= 0) {
            z = false;
        }
        view.setSelected(z);
        TextView textView = this.e;
        if (!this.a.aj() || ReaderEnv.get().forHd()) {
            i = 8;
        }
        textView.setVisibility(i);
        this.e.setText(this.a.am() ? getString(i.reading__reading_more_view__portrait) : getString(i.reading__reading_more_view__landscape));
    }
}
