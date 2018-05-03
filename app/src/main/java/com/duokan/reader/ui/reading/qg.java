package com.duokan.reader.ui.reading;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.ui.AnimUtils;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.ui.general.BookCoverView;

public class qg extends wx {
    /* renamed from: a */
    private final su f10853a = ((su) getContext().queryFeature(su.class));
    /* renamed from: b */
    private final View f10854b;
    /* renamed from: c */
    private final View f10855c;
    /* renamed from: d */
    private final View f10856d;
    /* renamed from: e */
    private final View f10857e;
    /* renamed from: f */
    private final View f10858f;
    /* renamed from: g */
    private final FrameLayout f10859g;
    /* renamed from: h */
    private ActivatedController f10860h = null;

    public qg(IFeature mFeature) {
        int i;
        super(mFeature);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(this.f10853a.am() ? C0256h.reading__reading_comic_more_horizontal_view : C0256h.reading__reading_comic_more_vertical_view, null);
        viewGroup.setLayoutParams(new LayoutParams(ReaderEnv.get().forHd() ? AnimUtils.m1932b(getContext(), 240.0f) : -1, -2));
        setContentView((View) viewGroup);
        this.f10858f = findViewById(C0255g.reading__reading_comic_more_view);
        this.f10859g = (FrameLayout) findViewById(C0255g.reading__reading_comic_more_view__sub_menu_frame);
        C0800c G = this.f10853a.mo1992G();
        this.f10854b = findViewById(C0255g.reading__reading_comic_more_view__book_info);
        this.f10855c = this.f10854b.findViewById(C0255g.reading__reading_comic_more_view__book_detail);
        View findViewById = findViewById(C0255g.reading__reading_comic_more_view__split);
        if (G.ak()) {
            this.f10854b.setVisibility(0);
            findViewById.setVisibility(0);
            this.f10855c.setOnClickListener(new qh(this, G));
            BookCoverView bookCoverView = (BookCoverView) this.f10855c.findViewById(C0255g.reading__reading_comic_more_view__book_detail_cover);
            bookCoverView.setCover(G);
            bookCoverView.m9919a();
            ((TextView) this.f10855c.findViewById(C0255g.reading__reading_comic_more_view__book_detail_title)).setText(G.ay());
            ((TextView) this.f10855c.findViewById(C0255g.reading__reading_comic_more_view__book_detail_author)).setText(G.m4150C());
        } else {
            this.f10854b.setVisibility(8);
            findViewById.setVisibility(8);
        }
        this.f10856d = this.f10854b.findViewById(C0255g.reading__reading_comic_more_view__auto_pay);
        View view = this.f10856d;
        if (!this.f10853a.mo1992G().mo1038k() || this.f10853a.mo1992G().al()) {
            i = 8;
        } else {
            i = 0;
        }
        view.setVisibility(i);
        this.f10856d.setOnClickListener(new qj(this));
        this.f10857e = findViewById(C0255g.reading__reading_comic_more_view__bookmark);
        this.f10857e.setOnClickListener(new qk(this));
        findViewById(C0255g.reading__reading_comic_more_view__share).setOnClickListener(new qm(this));
        findViewById(C0255g.reading__reading_comic_more_view__settings).setOnClickListener(new qp(this));
    }

    protected void onActive(boolean z) {
        m14927a();
        super.onActive(z);
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
    }

    protected void onDetachFromStub() {
        if (this.f10860h != null) {
            this.f10860h.requestDetach();
            removeSubController(this.f10860h);
            this.f10859g.removeAllViews();
            this.f10859g.setVisibility(8);
            this.f10858f.setVisibility(0);
        }
        super.onDetachFromStub();
    }

    /* renamed from: a */
    private void m14927a() {
        boolean z = true;
        this.f10856d.setSelected(this.f10853a.mo1992G().mo1012a(true));
        View view = this.f10857e;
        if (this.f10853a.mo2006W().size() <= 0) {
            z = false;
        }
        view.setSelected(z);
    }
}
