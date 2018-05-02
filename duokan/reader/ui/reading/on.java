package com.duokan.reader.ui.reading;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;
import com.duokan.reader.ui.general.FixedPagesView.PageScaleType;

class on extends po {
    private final View i = findViewById(g.reading__reading_menu_bottom_view_pdf__mode);
    private final View j = findViewById(g.reading__reading_menu_bottom_view__clip);
    private final View k = findViewById(g.reading__reading_menu_bottom_view__viewtype);
    private final View l = findViewById(g.reading__reading_menu_bottom_view__options);
    private final TextView m = ((TextView) findViewById(g.reading__reading_menu_view_pdf__fixed_page_num));
    private final ActivatedController n = new xc(getContext());

    public on(IFeature featrue) {
        super(featrue);
        this.i.setOnClickListener(new oo(this));
        this.j.setOnClickListener(new or(this));
        this.k.setOnClickListener(new ou(this));
    }

    protected View a() {
        return inflate(h.reading__reading_menu_view_pdf, null);
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
        this.i.setSelected(!this.f.g());
        if (this.f.g()) {
            this.j.setVisibility(0);
            this.l.setVisibility(8);
            this.k.setVisibility(0);
            ((ImageView) this.k).setImageResource(this.f.b().e() == PageScaleType.MATCH_INSIDE ? f.reading__reading_menu_bottom_view_pdf__single_page : f.reading__reading_menu_bottom_view_pdf__scroll);
            return;
        }
        this.j.setVisibility(8);
        this.l.setVisibility(0);
        this.k.setVisibility(8);
    }

    protected void a(ActivatedController activatedControllerVar) {
        this.m.setVisibility(4);
        super.a(activatedControllerVar);
    }

    protected void c() {
        if (this.f.g()) {
            this.j.setSelected(!this.f.b().i());
        }
        super.c();
    }

    protected View d() {
        return this.m;
    }
}
