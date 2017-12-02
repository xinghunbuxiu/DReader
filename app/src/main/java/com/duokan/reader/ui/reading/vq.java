package com.duokan.reader.ui.reading;

import android.view.View;

import com.duokan.b.g;
import com.duokan.b.i;
import com.duokan.core.app.e;
import com.duokan.core.app.x;
import com.duokan.core.app.y;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.bookshelf.BookFormat;
import com.duokan.reader.ui.general.DkLabelView;
import com.duokan.reader.ui.general.HeaderView;
import com.duokan.reader.ui.general.ia;

public class vq extends e {
    private final sh a = ((sh) getContext().queryFeature(sh.class));
    private final HeaderView b;
    private final DkLabelView c;
    private final DkLabelView d;
    private final DkLabelView e;
    private final DkLabelView f;

    public vq(y yVar) {
        super(yVar);
        setContentView(g.reading__reading_prefs_view);
        this.b = (HeaderView) findViewById(f.reading__reading_prefs_view__header);
        this.b.setLeftTitle(getString(i.reading__reading_prefs_view__title));
        this.c = (DkLabelView) findViewById(f.reading__reading_prefs_view__anim_name);
        findViewById(f.reading__reading_prefs_view__animations).setOnClickListener(new vr(this));
        this.f = (DkLabelView) findViewById(f.reading__reading_prefs_view__annotation_style_name);
        findViewById(f.reading__reading_prefs_view__annotation_style).setOnClickListener(new vy(this));
        this.d = (DkLabelView) findViewById(f.reading__reading_prefs_view__screen_timeout_time);
        findViewById(f.reading__reading_prefs_view__screen).setOnClickListener(new vz(this));
        this.e = (DkLabelView) findViewById(f.reading__reading_prefs_view__left_tap_operation);
        findViewById(f.reading__reading_prefs_view__left_tap).setOnClickListener(new wa(this));
        e();
        View findViewById = findViewById(f.reading__reading_prefs_view__read_last);
        findViewById.setSelected(ReaderEnv.get().getKeepReading());
        findViewById.setOnClickListener(new wb(this));
        findViewById = findViewById(f.reading__reading_prefs_view__volume_key);
        findViewById.setSelected(this.a.x());
        findViewById.setOnClickListener(new wc(this));
        findViewById = findViewById(f.reading__reading_prefs_view__rapid_slide);
        findViewById.setSelected(this.a.ae().H());
        findViewById.setOnClickListener(new wd(this));
        findViewById = findViewById(f.reading__custom_screen_view__show_system_bar);
        findViewById.setSelected(this.a.ae().G());
        findViewById.setOnClickListener(new we(this));
        findViewById = findViewById(f.reading__custom_screen_view__show_chapter_name);
        findViewById.setSelected(this.a.ae().I());
        findViewById.setOnClickListener(new wf(this));
        findViewById = findViewById(f.reading__custom_screen_view__show_reading_status);
        findViewById.setSelected(this.a.ae().J());
        findViewById.setOnClickListener(new vs(this));
        if (this.a.g() || this.a.G().q() == BookFormat.SBK) {
            findViewById(f.reading__reading_prefs_view__anim_top_divider).setVisibility(8);
            findViewById(f.reading__reading_prefs_view__animations).setVisibility(8);
            if (this.a.g()) {
                findViewById(f.reading__reading_prefs_view__normal_pref_panel).setVisibility(8);
            }
        }
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
        ((sh) x.a(getContext()).queryFeature(sh.class)).a(0, 128);
    }

    protected void onDetachFromStub() {
        this.a.aA();
        ((sh) x.a(getContext()).queryFeature(sh.class)).a(128, 0);
    }

    private void a() {
        ia iaVar = new ia(getContext());
        iaVar.a(i.reading__reading_prefs_view__animation);
        iaVar.b(i.reading__reading_prefs_view__anim_overlap);
        iaVar.b(i.reading__reading_prefs_view__anim_3d);
        iaVar.b(i.reading__reading_prefs_view__anim_hscroll);
        iaVar.b(i.reading__reading_prefs_view__anim_vscroll);
        iaVar.b(i.reading__reading_prefs_view__anim_fade_in);
        iaVar.b(i.reading__reading_prefs_view__anim_none);
        iaVar.a(new vt(this));
        iaVar.show();
    }

    private void b() {
        ia iaVar = new ia(getContext());
        iaVar.a(i.reading__reading_prefs_view__annotation_style);
        iaVar.b(i.reading__reading_prefs_view__annotation_style_bubble);
        iaVar.b(i.reading__reading_prefs_view__annotation_style_note);
        iaVar.a(new vu(this));
        iaVar.show();
    }

    private void c() {
        ia iaVar = new ia(getContext());
        iaVar.a(i.reading__reading_prefs_view__left_tap);
        iaVar.b(i.reading__reading_prefs_view__left_tap_backward);
        iaVar.b(i.reading__reading_prefs_view__left_tap_forward);
        iaVar.a(new vv(this));
        iaVar.show();
    }

    private void d() {
        ia iaVar = new ia(getContext());
        iaVar.a(i.reading__reading_prefs_view__screen_timeout);
        iaVar.b(i.reading__reading_prefs_view__2min);
        iaVar.b(i.reading__reading_prefs_view__5min);
        iaVar.b(i.reading__reading_prefs_view__10min);
        iaVar.b(i.reading__reading_prefs_view__forever);
        iaVar.a(new vw(this));
        iaVar.show();
    }

    private void e() {
        switch (vx.a[this.a.ae().M().ordinal()]) {
            case 1:
                this.c.setText(i.reading__reading_prefs_view__anim_3d);
                break;
            case 2:
                this.c.setText(i.reading__reading_prefs_view__anim_hscroll);
                break;
            case 3:
                this.c.setText(i.reading__reading_prefs_view__anim_vscroll);
                break;
            case 4:
                this.c.setText(i.reading__reading_prefs_view__anim_fade_in);
                break;
            case 5:
                this.c.setText(i.reading__reading_prefs_view__anim_none);
                break;
            default:
                this.c.setText(i.reading__reading_prefs_view__anim_overlap);
                break;
        }
        switch (vx.b[this.a.ae().N().ordinal()]) {
            case 1:
                this.f.setText(i.reading__reading_prefs_view__annotation_style_bubble);
                break;
            default:
                this.f.setText(i.reading__reading_prefs_view__annotation_style_note);
                break;
        }
        if (this.a.aL()) {
            this.e.setText(i.reading__reading_prefs_view__left_tap_forward);
        } else {
            this.e.setText(i.reading__reading_prefs_view__left_tap_backward);
        }
        switch (this.a.ae().m()) {
            case 120000:
                this.d.setText(i.reading__reading_prefs_view__2min);
                return;
            case 600000:
                this.d.setText(i.reading__reading_prefs_view__10min);
                return;
            case Integer.MAX_VALUE:
                this.d.setText(i.reading__reading_prefs_view__forever);
                return;
            default:
                this.d.setText(i.reading__reading_prefs_view__5min);
                return;
        }
    }
}
