package com.duokan.reader.ui.reading;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.p023b.C0244f;
import com.duokan.p023b.C0245g;
import com.duokan.p023b.C0247i;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.ui.general.BookCoverView;

public class uq extends wx {
    /* renamed from: a */
    private final su f11020a = ((su) getContext().queryFeature(su.class));
    /* renamed from: b */
    private final View f11021b;
    /* renamed from: c */
    private final View f11022c;
    /* renamed from: d */
    private final View f11023d;
    /* renamed from: e */
    private final TextView f11024e;
    /* renamed from: f */
    private final View f11025f;
    /* renamed from: g */
    private final View f11026g;
    /* renamed from: h */
    private final FrameLayout f11027h;
    /* renamed from: i */
    private ActivatedController f11028i = null;

    public uq(IFeature mFeature) {
        int i;
        super(mFeature);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(this.f11020a.am() ? C0245g.reading__reading_more_horizontal_view : C0245g.reading__reading_more_vertical_view, null);
        viewGroup.setLayoutParams(new LayoutParams(-1, -2));
        setContentView((View) viewGroup);
        this.f11026g = findViewById(C0244f.reading__reading_more_view);
        this.f11027h = (FrameLayout) findViewById(C0244f.reading__reading_more_view__sub_menu_frame);
        C0800c G = this.f11020a.mo1992G();
        this.f11021b = findViewById(C0244f.reading__reading_more_view__book_info);
        this.f11022c = this.f11021b.findViewById(C0244f.reading__reading_more_view__book_detail);
        View findViewById = findViewById(C0244f.reading__reading_more_view__split);
        if (G.ak()) {
            this.f11021b.setVisibility(0);
            findViewById.setVisibility(0);
            this.f11022c.setOnClickListener(new ur(this, G));
            BookCoverView bookCoverView = (BookCoverView) this.f11022c.findViewById(C0244f.reading__reading_more_view__book_detail_cover);
            bookCoverView.setCover(G);
            bookCoverView.m9919a();
            ((TextView) this.f11022c.findViewById(C0244f.reading__reading_more_view__book_detail_title)).setText(G.ay());
            ((TextView) this.f11022c.findViewById(C0244f.reading__reading_more_view__book_detail_author)).setText(G.m4150C());
        } else {
            this.f11021b.setVisibility(8);
            findViewById.setVisibility(8);
        }
        this.f11023d = this.f11021b.findViewById(C0244f.reading__reading_more_view__auto_pay);
        View view = this.f11023d;
        if (!this.f11020a.mo1992G().mo1038k() || this.f11020a.mo1992G().al()) {
            i = 8;
        } else {
            i = 0;
        }
        view.setVisibility(i);
        this.f11023d.setOnClickListener(new ut(this));
        this.f11025f = findViewById(C0244f.reading__reading_more_view__bookmark);
        this.f11025f.setOnClickListener(new uu(this));
        this.f11024e = (TextView) findViewById(C0244f.reading__reading_more_view__rotate);
        this.f11024e.setOnClickListener(new uw(this));
        findViewById(C0244f.reading__reading_more_view__share).setOnClickListener(new uy(this));
        findViewById(C0244f.reading__reading_more_view__settings).setOnClickListener(new vb(this));
    }

    protected void onActive(boolean z) {
        m15026a();
        super.onActive(z);
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
    }

    protected void onDetachFromStub() {
        if (this.f11028i != null) {
            this.f11028i.requestDetach();
            removeSubController(this.f11028i);
            this.f11027h.removeAllViews();
            this.f11027h.setVisibility(8);
            this.f11026g.setVisibility(0);
        }
        super.onDetachFromStub();
    }

    /* renamed from: a */
    private void m15026a() {
        boolean z = true;
        int i = 0;
        this.f11023d.setSelected(this.f11020a.mo1992G().mo1012a(true));
        View view = this.f11025f;
        if (this.f11020a.mo2006W().size() <= 0) {
            z = false;
        }
        view.setSelected(z);
        TextView textView = this.f11024e;
        if (!this.f11020a.aj() || ReaderEnv.get().forHd()) {
            i = 8;
        }
        textView.setVisibility(i);
        this.f11024e.setText(this.f11020a.am() ? getString(C0247i.reading__reading_more_view__portrait) : getString(C0247i.reading__reading_more_view__landscape));
    }
}
