package com.duokan.reader.ui.reading;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.ui.AnimUtils;
import com.duokan.p023b.C0244f;
import com.duokan.p023b.C0245g;
import com.duokan.p023b.C0247i;
import com.duokan.reader.ReaderEnv;

class vd extends wx {
    /* renamed from: a */
    private final su f11043a = ((su) getContext().queryFeature(su.class));
    /* renamed from: b */
    private final ViewGroup f11044b = ((ViewGroup) LayoutInflater.from(getContext()).inflate(C0245g.reading__reading_options_view, null));
    /* renamed from: c */
    private final LinearLayout f11045c;
    /* renamed from: d */
    private final View f11046d;
    /* renamed from: e */
    private final ReadingTheme[] f11047e;
    /* renamed from: f */
    private final FrameLayout f11048f;
    /* renamed from: g */
    private final View f11049g;
    /* renamed from: h */
    private final View f11050h;
    /* renamed from: i */
    private ActivatedController f11051i;
    /* renamed from: j */
    private boolean f11052j = true;

    @SuppressLint({"NewApi"})
    public vd(IFeature mFeature) {
        super(mFeature);
        this.f11044b.setLayoutParams(new LayoutParams(ReaderEnv.get().forHd() ? AnimUtils.m1932b(getContext(), 400.0f) : -1, -2));
        setContentView(this.f11044b);
        this.f11046d = findViewById(C0244f.reading__reading_options_view);
        this.f11048f = (FrameLayout) findViewById(C0244f.reading__reading_options_bottom_view__sub_menu_frame);
        this.f11047e = new ReadingTheme[]{ReadingTheme.THEME1, ReadingTheme.THEME14, ReadingTheme.THEME8, ReadingTheme.THEME18};
        this.f11045c = (LinearLayout) findViewById(C0244f.reading__reading_options_view__theme_bar);
        for (int i = 0; i < this.f11047e.length; i++) {
            this.f11045c.addView(m15028a(i));
        }
        findViewById(C0244f.reading__reading_options_view__font).setOnClickListener(new ve(this));
        this.f11049g = findViewById(C0244f.reading__reading_options_view__zoom_out);
        this.f11049g.setOnClickListener(new vi(this));
        this.f11050h = findViewById(C0244f.reading__reading_options_view__zoom_in);
        this.f11050h.setOnClickListener(new vj(this));
        if (this.f11043a.mo2133d()) {
            findViewById(C0244f.reading__reading_options_view__chs_to_cht).setOnClickListener(new vk(this));
        } else if (VERSION.SDK_INT >= 11) {
            findViewById(C0244f.reading__reading_options_view__chs_to_cht).setAlpha(0.5f);
        } else {
            findViewById(C0244f.reading__reading_options_view__chs_to_cht).setVisibility(8);
        }
        findViewById(C0244f.reading__reading_options_view__typesetting_tight).setOnClickListener(new vl(this));
        findViewById(C0244f.reading__reading_options_view__typesetting_normal).setOnClickListener(new vm(this));
        findViewById(C0244f.reading__reading_options_view__typesetting_loose).setOnClickListener(new vn(this));
        findViewById(C0244f.reading__reading_options_view__typesetting_original).setOnClickListener(new vo(this));
        findViewById(C0244f.reading__reading_options_view__typesetting_custom).setOnClickListener(new vp(this));
        findViewById(C0244f.reading__reading_options_view__more_themes).setOnClickListener(new vg(this));
        if (getContext().getResources().getDisplayMetrics().widthPixels < 720) {
            findViewById(C0244f.reading__reading_options_view__padding_panel).setPadding(AnimUtils.m1932b(getContext(), 5.0f), 0, AnimUtils.m1932b(getContext(), 5.0f), 0);
        }
        m15030b();
    }

    /* renamed from: b */
    private final void m15030b() {
        boolean z;
        boolean z2 = true;
        findViewById(C0244f.reading__reading_options_view__chs_to_cht).setSelected(!this.f11043a.mo2003T());
        View findViewById = findViewById(C0244f.reading__reading_options_view__typesetting_tight);
        if (this.f11043a.ae().m12514j() == TypesettingStyle.TIGHT) {
            z = true;
        } else {
            z = false;
        }
        findViewById.setSelected(z);
        findViewById = findViewById(C0244f.reading__reading_options_view__typesetting_normal);
        if (this.f11043a.ae().m12514j() == TypesettingStyle.NORMAL) {
            z = true;
        } else {
            z = false;
        }
        findViewById.setSelected(z);
        findViewById = findViewById(C0244f.reading__reading_options_view__typesetting_loose);
        if (this.f11043a.ae().m12514j() == TypesettingStyle.LOOSE) {
            z = true;
        } else {
            z = false;
        }
        findViewById.setSelected(z);
        findViewById = findViewById(C0244f.reading__reading_options_view__typesetting_original);
        if (this.f11043a.ae().m12514j() == TypesettingStyle.ORIGINAL) {
            z = true;
        } else {
            z = false;
        }
        findViewById.setSelected(z);
        findViewById = findViewById(C0244f.reading__reading_options_view__typesetting_custom);
        if (this.f11043a.ae().m12514j() == TypesettingStyle.CUSTOM) {
            z = true;
        } else {
            z = false;
        }
        findViewById.setSelected(z);
        findViewById(C0244f.reading__reading_options_view__chs_to_cht).setSelected(this.f11043a.mo2003T());
        ReadingTheme q = this.f11043a.ae().m12523q();
        Boolean valueOf = Boolean.valueOf(false);
        for (int i = 0; i < this.f11045c.getChildCount(); i++) {
            boolean z3;
            if (this.f11047e[i] == q) {
                valueOf = Boolean.valueOf(true);
            }
            View childAt = this.f11045c.getChildAt(i);
            if (this.f11047e[i] == q) {
                z3 = true;
            } else {
                z3 = false;
            }
            childAt.setSelected(z3);
        }
        View findViewById2 = findViewById(C0244f.reading__reading_options_view__more_themes);
        if (valueOf.booleanValue()) {
            z2 = false;
        }
        findViewById2.setSelected(z2);
        m15032c();
    }

    @SuppressLint({"NewApi"})
    /* renamed from: c */
    private void m15032c() {
        float f = 0.5f;
        if (VERSION.SDK_INT >= 11) {
            this.f11049g.setAlpha(this.f11043a.mo2166n() ? 0.5f : 1.0f);
            View view = this.f11050h;
            if (!this.f11043a.mo2165m()) {
                f = 1.0f;
            }
            view.setAlpha(f);
        }
    }

    /* renamed from: a */
    private final adm m15028a(int i) {
        adm adm;
        ReadingPrefs ae = this.f11043a.ae();
        if (ae.m12475a(this.f11047e[i])) {
            adm = new adm(getContext(), ae.m12484c(this.f11047e[i]));
        } else {
            adm = new adm(getContext(), ae.m12478b(this.f11047e[i]));
        }
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2, 0.0f);
        if (this.f11052j) {
            this.f11052j = false;
        } else {
            layoutParams.setMargins(AnimUtils.m1932b(getContext(), 15.0f), 0, 0, 0);
            adm.setLayoutParams(layoutParams);
        }
        adm.setOnClickListener(new vh(this, i));
        adm.setContentDescription(getResources().getString(C0247i.reading__reading_options_view__change_theme));
        return adm;
    }

    /* renamed from: a */
    protected void m15035a(ActivatedController c0303e, View view) {
        if (!m15036a()) {
            this.f11051i = c0303e;
            addSubController(this.f11051i);
            this.f11048f.addView(this.f11051i.getContentView(), new FrameLayout.LayoutParams(-1, -2));
            this.f11048f.setVisibility(0);
            this.f11046d.setVisibility(8);
            activate(this.f11051i);
        }
    }

    protected void onDetachFromStub() {
        if (m15036a()) {
            this.f11051i.requestDetach();
            removeSubController(this.f11051i);
            this.f11048f.removeAllViews();
            this.f11048f.setVisibility(8);
            this.f11046d.setVisibility(0);
        }
        super.onDetachFromStub();
    }

    /* renamed from: a */
    protected boolean m15036a() {
        return this.f11051i != null;
    }
}
