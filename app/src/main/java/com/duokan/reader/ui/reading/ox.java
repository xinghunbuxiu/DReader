package com.duokan.reader.ui.reading;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.p024c.C0254f;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.reader.ui.general.FixedPagesView.PageScaleType;

class ox extends py {
    /* renamed from: i */
    private final View f10762i = findViewById(C0255g.reading__reading_menu_bottom_view_pdf__mode);
    /* renamed from: j */
    private final View f10763j = findViewById(C0255g.reading__reading_menu_bottom_view__clip);
    /* renamed from: k */
    private final View f10764k = findViewById(C0255g.reading__reading_menu_bottom_view__viewtype);
    /* renamed from: l */
    private final View f10765l = findViewById(C0255g.reading__reading_menu_bottom_view__options);
    /* renamed from: m */
    private final TextView f10766m = ((TextView) findViewById(C0255g.reading__reading_menu_view_pdf__fixed_page_num));
    /* renamed from: n */
    private final ActivatedController f10767n = new xp(getContext());

    public ox(IFeature mFeature) {
        super(mFeature);
        this.f10762i.setOnClickListener(new oy(this));
        this.f10763j.setOnClickListener(new pb(this));
        this.f10764k.setOnClickListener(new pe(this));
    }

    /* renamed from: a */
    protected View mo2256a() {
        return inflate(C0256h.reading__reading_menu_view_pdf, null);
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
        this.f10762i.setSelected(!this.f.mo2145g());
        if (this.f.mo2145g()) {
            this.f10763j.setVisibility(0);
            this.f10765l.setVisibility(8);
            this.f10764k.setVisibility(0);
            ((ImageView) this.f10764k).setImageResource(this.f.mo2095b().m4624e() == PageScaleType.MATCH_INSIDE ? C0254f.reading__reading_menu_bottom_view_pdf__single_page : C0254f.reading__reading_menu_bottom_view_pdf__scroll);
            return;
        }
        this.f10763j.setVisibility(8);
        this.f10765l.setVisibility(0);
        this.f10764k.setVisibility(8);
    }

    /* renamed from: a */
    protected void mo2248a(ActivatedController c0303e) {
        this.f10766m.setVisibility(4);
        super.mo2248a(c0303e);
    }

    /* renamed from: c */
    protected void mo2249c() {
        if (this.f.mo2145g()) {
            this.f10763j.setSelected(!this.f.mo2095b().m4628i());
        }
        super.mo2249c();
    }

    /* renamed from: d */
    protected View mo2385d() {
        return this.f10766m;
    }
}
