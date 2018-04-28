package com.duokan.reader.ui.reading;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.AppContext;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.bookshelf.BookContent;

public class cm extends wx {
    /* renamed from: a */
    private final su f9941a = ((su) getContext().queryFeature(su.class));
    /* renamed from: b */
    private final View f9942b;
    /* renamed from: c */
    private final View f9943c;
    /* renamed from: d */
    private final View f9944d;
    /* renamed from: e */
    private boolean f9945e = false;

    public cm(IFeature mFeature) {
        super(mFeature);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(this.f9941a.am() ? C0256h.reading__comic_option_horizontal_view : C0256h.reading__comic_option_vertical_view, null);
        viewGroup.setLayoutParams(new LayoutParams(-1, -2));
        setContentView((View) viewGroup);
        this.f9942b = findViewById(C0255g.reading__comic_option_view__horizontal);
        this.f9942b.setOnClickListener(new cn(this));
        this.f9943c = findViewById(C0255g.reading__comic_option_view__vertical);
        this.f9943c.setOnClickListener(new co(this));
        this.f9944d = findViewById(C0255g.reading__comic_option_view__landscape);
        this.f9944d.setOnClickListener(new cp(this));
        m13849a();
    }

    protected void onDetachFromStub() {
        if (this.f9945e) {
            this.f9941a.aA();
            ((su) AppContext.getAppContext(getContext()).queryFeature(su.class)).mo2040a(128, 0);
        }
    }

    /* renamed from: a */
    private void m13849a() {
        if (!ReaderEnv.get().forHd()) {
            this.f9944d.setVisibility(0);
        }
        if (this.f9941a.mo1992G().m4246r() == BookContent.VERTICAL_COMIC) {
            this.f9942b.setVisibility(8);
        }
        if (!ReaderEnv.get().forHd() && this.f9941a.am()) {
            this.f9944d.setSelected(true);
        } else if (this.f9942b.getVisibility() == 0 && this.f9941a.mo2004U() == PageAnimationMode.HSCROLL) {
            this.f9942b.setSelected(true);
        } else {
            this.f9943c.setSelected(true);
        }
    }
}
