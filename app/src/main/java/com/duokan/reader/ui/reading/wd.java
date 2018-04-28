package com.duokan.reader.ui.reading;

import android.view.View;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.AppContext;
import com.duokan.core.app.ActivatedController;
import com.duokan.p023b.C0244f;
import com.duokan.p023b.C0245g;
import com.duokan.p023b.C0247i;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.bookshelf.BookFormat;
import com.duokan.reader.ui.general.DkLabelView;
import com.duokan.reader.ui.general.HeaderView;
import com.duokan.reader.ui.general.hp;

public class wd extends ActivatedController {
    /* renamed from: a */
    private final su f11102a = ((su) getContext().queryFeature(su.class));
    /* renamed from: b */
    private final HeaderView f11103b;
    /* renamed from: c */
    private final DkLabelView f11104c;
    /* renamed from: d */
    private final DkLabelView f11105d;
    /* renamed from: e */
    private final DkLabelView f11106e;
    /* renamed from: f */
    private final DkLabelView f11107f;

    public wd(IFeature mFeature) {
        super(mFeature);
        setContentView(C0245g.reading__reading_prefs_view);
        this.f11103b = (HeaderView) findViewById(C0244f.reading__reading_prefs_view__header);
        this.f11103b.setLeftTitle(getString(C0247i.reading__reading_prefs_view__title));
        this.f11104c = (DkLabelView) findViewById(C0244f.reading__reading_prefs_view__anim_name);
        findViewById(C0244f.reading__reading_prefs_view__animations).setOnClickListener(new we(this));
        this.f11107f = (DkLabelView) findViewById(C0244f.reading__reading_prefs_view__annotation_style_name);
        findViewById(C0244f.reading__reading_prefs_view__annotation_style).setOnClickListener(new wl(this));
        this.f11105d = (DkLabelView) findViewById(C0244f.reading__reading_prefs_view__screen_timeout_time);
        findViewById(C0244f.reading__reading_prefs_view__screen).setOnClickListener(new wm(this));
        this.f11106e = (DkLabelView) findViewById(C0244f.reading__reading_prefs_view__left_tap_operation);
        findViewById(C0244f.reading__reading_prefs_view__left_tap).setOnClickListener(new wn(this));
        m15054e();
        View findViewById = findViewById(C0244f.reading__reading_prefs_view__read_last);
        findViewById.setSelected(ReaderEnv.get().getKeepReading());
        findViewById.setOnClickListener(new wo(this));
        findViewById = findViewById(C0244f.reading__reading_prefs_view__volume_key);
        findViewById.setSelected(this.f11102a.mo2182x());
        findViewById.setOnClickListener(new wp(this));
        findViewById = findViewById(C0244f.reading__reading_prefs_view__rapid_slide);
        findViewById.setSelected(this.f11102a.ae().m12447H());
        findViewById.setOnClickListener(new wq(this));
        findViewById = findViewById(C0244f.reading__custom_screen_view__show_system_bar);
        findViewById.setSelected(this.f11102a.ae().m12446G());
        findViewById.setOnClickListener(new wr(this));
        findViewById = findViewById(C0244f.reading__custom_screen_view__show_chapter_name);
        findViewById.setSelected(this.f11102a.ae().m12448I());
        findViewById.setOnClickListener(new ws(this));
        findViewById = findViewById(C0244f.reading__custom_screen_view__show_reading_status);
        findViewById.setSelected(this.f11102a.ae().m12449J());
        findViewById.setOnClickListener(new wf(this));
        if (this.f11102a.mo2145g() || this.f11102a.mo1992G().mo1039q() == BookFormat.SBK) {
            findViewById(C0244f.reading__reading_prefs_view__anim_top_divider).setVisibility(8);
            findViewById(C0244f.reading__reading_prefs_view__animations).setVisibility(8);
            if (this.f11102a.mo2145g()) {
                findViewById(C0244f.reading__reading_prefs_view__normal_pref_panel).setVisibility(8);
            }
        }
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
        ((su) AppContext.getAppContext(getContext()).queryFeature(su.class)).mo2040a(0, 128);
    }

    protected void onDetachFromStub() {
        this.f11102a.aA();
        ((su) AppContext.getAppContext(getContext()).queryFeature(su.class)).mo2040a(128, 0);
    }

    /* renamed from: a */
    private void m15045a() {
        hp hpVar = new hp(getContext());
        hpVar.m9765a(C0247i.reading__reading_prefs_view__animation);
        hpVar.m9769b(C0247i.reading__reading_prefs_view__anim_overlap);
        hpVar.m9769b(C0247i.reading__reading_prefs_view__anim_3d);
        hpVar.m9769b(C0247i.reading__reading_prefs_view__anim_hscroll);
        hpVar.m9769b(C0247i.reading__reading_prefs_view__anim_vscroll);
        hpVar.m9769b(C0247i.reading__reading_prefs_view__anim_fade_in);
        hpVar.m9769b(C0247i.reading__reading_prefs_view__anim_none);
        hpVar.m9767a(new wg(this));
        hpVar.show();
    }

    /* renamed from: b */
    private void m15047b() {
        hp hpVar = new hp(getContext());
        hpVar.m9765a(C0247i.reading__reading_prefs_view__annotation_style);
        hpVar.m9769b(C0247i.reading__reading_prefs_view__annotation_style_bubble);
        hpVar.m9769b(C0247i.reading__reading_prefs_view__annotation_style_note);
        hpVar.m9767a(new wh(this));
        hpVar.show();
    }

    /* renamed from: c */
    private void m15049c() {
        hp hpVar = new hp(getContext());
        hpVar.m9765a(C0247i.reading__reading_prefs_view__left_tap);
        hpVar.m9769b(C0247i.reading__reading_prefs_view__left_tap_backward);
        hpVar.m9769b(C0247i.reading__reading_prefs_view__left_tap_forward);
        hpVar.m9767a(new wi(this));
        hpVar.show();
    }

    /* renamed from: d */
    private void m15051d() {
        hp hpVar = new hp(getContext());
        hpVar.m9765a(C0247i.reading__reading_prefs_view__screen_timeout);
        hpVar.m9769b(C0247i.reading__reading_prefs_view__2min);
        hpVar.m9769b(C0247i.reading__reading_prefs_view__5min);
        hpVar.m9769b(C0247i.reading__reading_prefs_view__10min);
        hpVar.m9769b(C0247i.reading__reading_prefs_view__forever);
        hpVar.m9767a(new wj(this));
        hpVar.show();
    }

    /* renamed from: e */
    private void m15054e() {
        switch (wk.f11114a[this.f11102a.ae().m12452M().ordinal()]) {
            case 1:
                this.f11104c.setText(C0247i.reading__reading_prefs_view__anim_3d);
                break;
            case 2:
                this.f11104c.setText(C0247i.reading__reading_prefs_view__anim_hscroll);
                break;
            case 3:
                this.f11104c.setText(C0247i.reading__reading_prefs_view__anim_vscroll);
                break;
            case 4:
                this.f11104c.setText(C0247i.reading__reading_prefs_view__anim_fade_in);
                break;
            case 5:
                this.f11104c.setText(C0247i.reading__reading_prefs_view__anim_none);
                break;
            default:
                this.f11104c.setText(C0247i.reading__reading_prefs_view__anim_overlap);
                break;
        }
        switch (wk.f11115b[this.f11102a.ae().m12453N().ordinal()]) {
            case 1:
                this.f11107f.setText(C0247i.reading__reading_prefs_view__annotation_style_bubble);
                break;
            default:
                this.f11107f.setText(C0247i.reading__reading_prefs_view__annotation_style_note);
                break;
        }
        if (this.f11102a.aL()) {
            this.f11106e.setText(C0247i.reading__reading_prefs_view__left_tap_forward);
        } else {
            this.f11106e.setText(C0247i.reading__reading_prefs_view__left_tap_backward);
        }
        switch (this.f11102a.ae().m12519m()) {
            case 120000:
                this.f11105d.setText(C0247i.reading__reading_prefs_view__2min);
                return;
            case 600000:
                this.f11105d.setText(C0247i.reading__reading_prefs_view__10min);
                return;
            case Integer.MAX_VALUE:
                this.f11105d.setText(C0247i.reading__reading_prefs_view__forever);
                return;
            default:
                this.f11105d.setText(C0247i.reading__reading_prefs_view__5min);
                return;
        }
    }
}
