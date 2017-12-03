package com.duokan.reader.ui.reading;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;
import com.duokan.core.ui.UTools;
import com.duokan.reader.ReaderEnv;

class uq extends wk {
    private final sh a = ((sh) getContext().queryFeature(sh.class));
    private final ViewGroup b = ((ViewGroup) LayoutInflater.from(getContext()).inflate(g.reading__reading_options_view, null));
    private final LinearLayout c;
    private final View d;
    private final ReadingTheme[] e;
    private final FrameLayout f;
    private final View g;
    private final View h;
    private ActivatedController i;
    private boolean j = true;

    @SuppressLint({"NewApi"})
    public uq(IFeature featrue) {
        super(featrue);
        this.b.setLayoutParams(new LayoutParams(ReaderEnv.get().forHd() ? UTools.closeAnimation(getContext(), 400.0f) : -1, -2));
        setContentView(this.b);
        this.d = findViewById(f.reading__reading_options_view);
        this.f = (FrameLayout) findViewById(f.reading__reading_options_bottom_view__sub_menu_frame);
        this.e = new ReadingTheme[]{ReadingTheme.THEME1, ReadingTheme.THEME14, ReadingTheme.THEME8, ReadingTheme.THEME18};
        this.c = (LinearLayout) findViewById(f.reading__reading_options_view__theme_bar);
        for (int i = 0; i < this.e.length; i++) {
            this.c.addView(a(i));
        }
        findViewById(f.reading__reading_options_view__font).setOnClickListener(new ur(this));
        this.g = findViewById(f.reading__reading_options_view__zoom_out);
        this.g.setOnClickListener(new uv(this));
        this.h = findViewById(f.reading__reading_options_view__zoom_in);
        this.h.setOnClickListener(new uw(this));
        if (this.a.d()) {
            findViewById(f.reading__reading_options_view__chs_to_cht).setOnClickListener(new ux(this));
        } else if (VERSION.SDK_INT >= 11) {
            findViewById(f.reading__reading_options_view__chs_to_cht).setAlpha(0.5f);
        } else {
            findViewById(f.reading__reading_options_view__chs_to_cht).setVisibility(8);
        }
        findViewById(f.reading__reading_options_view__typesetting_tight).setOnClickListener(new uy(this));
        findViewById(f.reading__reading_options_view__typesetting_normal).setOnClickListener(new uz(this));
        findViewById(f.reading__reading_options_view__typesetting_loose).setOnClickListener(new va(this));
        findViewById(f.reading__reading_options_view__typesetting_original).setOnClickListener(new vb(this));
        findViewById(f.reading__reading_options_view__typesetting_custom).setOnClickListener(new vc(this));
        findViewById(f.reading__reading_options_view__more_themes).setOnClickListener(new ut(this));
        if (getContext().getResources().getDisplayMetrics().widthPixels < 720) {
            findViewById(f.reading__reading_options_view__padding_panel).setPadding(UTools.closeAnimation(getContext(), 5.0f), 0, UTools.closeAnimation(getContext(), 5.0f), 0);
        }
        b();
    }

    private final void b() {
        boolean z;
        boolean z2 = true;
        findViewById(f.reading__reading_options_view__chs_to_cht).setSelected(!this.a.T());
        View findViewById = findViewById(f.reading__reading_options_view__typesetting_tight);
        if (this.a.ae().j() == TypesettingStyle.TIGHT) {
            z = true;
        } else {
            z = false;
        }
        findViewById.setSelected(z);
        findViewById = findViewById(f.reading__reading_options_view__typesetting_normal);
        if (this.a.ae().j() == TypesettingStyle.NORMAL) {
            z = true;
        } else {
            z = false;
        }
        findViewById.setSelected(z);
        findViewById = findViewById(f.reading__reading_options_view__typesetting_loose);
        if (this.a.ae().j() == TypesettingStyle.LOOSE) {
            z = true;
        } else {
            z = false;
        }
        findViewById.setSelected(z);
        findViewById = findViewById(f.reading__reading_options_view__typesetting_original);
        if (this.a.ae().j() == TypesettingStyle.ORIGINAL) {
            z = true;
        } else {
            z = false;
        }
        findViewById.setSelected(z);
        findViewById = findViewById(f.reading__reading_options_view__typesetting_custom);
        if (this.a.ae().j() == TypesettingStyle.CUSTOM) {
            z = true;
        } else {
            z = false;
        }
        findViewById.setSelected(z);
        findViewById(f.reading__reading_options_view__chs_to_cht).setSelected(this.a.T());
        ReadingTheme q = this.a.ae().q();
        Boolean valueOf = Boolean.valueOf(false);
        for (int i = 0; i < this.c.getChildCount(); i++) {
            boolean z3;
            if (this.e[i] == q) {
                valueOf = Boolean.valueOf(true);
            }
            View childAt = this.c.getChildAt(i);
            if (this.e[i] == q) {
                z3 = true;
            } else {
                z3 = false;
            }
            childAt.setSelected(z3);
        }
        View findViewById2 = findViewById(f.reading__reading_options_view__more_themes);
        if (valueOf.booleanValue()) {
            z2 = false;
        }
        findViewById2.setSelected(z2);
        c();
    }

    @SuppressLint({"NewApi"})
    private void c() {
        float f = 0.5f;
        if (VERSION.SDK_INT >= 11) {
            this.g.setAlpha(this.a.n() ? 0.5f : 1.0f);
            View view = this.h;
            if (!this.a.m()) {
                f = 1.0f;
            }
            view.setAlpha(f);
        }
    }

    private final acz a(int i) {
        acz com_duokan_reader_ui_reading_acz;
        ReadingPrefs ae = this.a.ae();
        if (ae.a(this.e[i])) {
            com_duokan_reader_ui_reading_acz = new acz(getContext(), ae.c(this.e[i]));
        } else {
            com_duokan_reader_ui_reading_acz = new acz(getContext(), ae.b(this.e[i]));
        }
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2, 0.0f);
        if (this.j) {
            this.j = false;
        } else {
            layoutParams.setMargins(UTools.closeAnimation(getContext(), 15.0f), 0, 0, 0);
            com_duokan_reader_ui_reading_acz.setLayoutParams(layoutParams);
        }
        com_duokan_reader_ui_reading_acz.setOnClickListener(new uu(this, i));
        com_duokan_reader_ui_reading_acz.setContentDescription(getResources().getString(i.reading__reading_options_view__change_theme));
        return com_duokan_reader_ui_reading_acz;
    }

    protected void a(ActivatedController controller, View view) {
        if (!a()) {
            this.i = controller;
            addSubController(this.i);
            this.f.addView(this.i.getContentView(), new FrameLayout.LayoutParams(-1, -2));
            this.f.setVisibility(0);
            this.d.setVisibility(8);
            activate(this.i);
        }
    }

    protected void onDetachFromStub() {
        if (a()) {
            this.i.requestDetach();
            removeSubController(this.i);
            this.f.removeAllViews();
            this.f.setVisibility(8);
            this.d.setVisibility(0);
        }
        super.onDetachFromStub();
    }

    protected boolean a() {
        return this.i != null;
    }
}
