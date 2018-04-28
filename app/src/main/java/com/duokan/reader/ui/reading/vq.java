package com.duokan.reader.ui.reading;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.TextView;
import com.duokan.core.app.IFeature;
import com.duokan.p023b.C0244f;
import com.duokan.p023b.C0245g;

public class vq extends wx {
    /* renamed from: a */
    private final su f11066a;
    /* renamed from: b */
    private final float f11067b = 0.1f;
    /* renamed from: c */
    private final float f11068c = 0.1f;
    /* renamed from: d */
    private final int f11069d = 1;
    /* renamed from: e */
    private final int f11070e;
    /* renamed from: f */
    private final int f11071f;
    /* renamed from: g */
    private final TextView f11072g;
    /* renamed from: h */
    private final View f11073h;
    /* renamed from: i */
    private final View f11074i;
    /* renamed from: j */
    private final TextView f11075j;
    /* renamed from: k */
    private final View f11076k;
    /* renamed from: l */
    private final View f11077l;
    /* renamed from: m */
    private final TextView f11078m;
    /* renamed from: n */
    private final View f11079n;
    /* renamed from: o */
    private final View f11080o;
    /* renamed from: p */
    private final TextView f11081p;
    /* renamed from: q */
    private final View f11082q;
    /* renamed from: r */
    private final View f11083r;
    /* renamed from: s */
    private final TextView f11084s;
    /* renamed from: t */
    private final View f11085t;
    /* renamed from: u */
    private final View f11086u;

    public vq(IFeature mFeature) {
        super(mFeature);
        setContentView(C0245g.reading__reading_custom_typesetting_view);
        this.f11066a = (su) getContext().queryFeature(su.class);
        this.f11072g = (TextView) findViewById(C0244f.reading__custom_typesetting__line_spacing_value);
        this.f11075j = (TextView) findViewById(C0244f.reading__custom_typesetting__paragraph_spacing_value);
        this.f11078m = (TextView) findViewById(C0244f.reading__custom_typesetting__indent_value);
        this.f11081p = (TextView) findViewById(C0244f.reading__custom_typesetting__top_margin_value);
        this.f11084s = (TextView) findViewById(C0244f.reading__custom_typesetting__lateral_margin_value);
        this.f11073h = findViewById(C0244f.reading__custom_typesetting__line_spacing_add);
        this.f11073h.setOnClickListener(new vr(this));
        this.f11074i = findViewById(C0244f.reading__custom_typesetting__line_spacing_reduce);
        this.f11074i.setOnClickListener(new vt(this));
        this.f11076k = findViewById(C0244f.reading__custom_typesetting__paragraph_spacing_add);
        this.f11076k.setOnClickListener(new vu(this));
        this.f11077l = findViewById(C0244f.reading__custom_typesetting__paragraph_spacing_reduce);
        this.f11077l.setOnClickListener(new vv(this));
        this.f11079n = findViewById(C0244f.reading__custom_typesetting__indent_add);
        this.f11079n.setOnClickListener(new vw(this));
        this.f11080o = findViewById(C0244f.reading__custom_typesetting__indent_reduce);
        this.f11080o.setOnClickListener(new vx(this));
        this.f11070e = this.f11066a.ae().m12503g();
        this.f11071f = this.f11066a.ae().m12507h();
        this.f11082q = findViewById(C0244f.reading__custom_typesetting__top_margin_add);
        this.f11082q.setOnClickListener(new vy(this));
        this.f11083r = findViewById(C0244f.reading__custom_typesetting__top_margin_reduce);
        this.f11083r.setOnClickListener(new vz(this));
        this.f11085t = findViewById(C0244f.reading__custom_typesetting__lateral_margin_add);
        this.f11085t.setOnClickListener(new wa(this));
        this.f11086u = findViewById(C0244f.reading__custom_typesetting__lateral_margin_reduce);
        this.f11086u.setOnClickListener(new vs(this));
        m15039a();
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    private void m15039a() {
        if (this.f11066a.mo1992G().ak()) {
            findViewById(C0244f.reading__custom_typesetting_view__indent_panel).setVisibility(8);
        } else {
            findViewById(C0244f.reading__custom_typesetting_view__indent_panel).setVisibility(0);
        }
        this.f11072g.setText(m15038a(this.f11066a.ae().m12525s()));
        this.f11075j.setText(m15038a(this.f11066a.ae().m12526t()));
        this.f11078m.setText(String.format("%d", new Object[]{Integer.valueOf((int) this.f11066a.ae().m12527u())}));
        this.f11081p.setText(m15038a(((float) this.f11066a.ae().m12530x()) / 10.0f));
        this.f11084s.setText(m15038a(((float) this.f11066a.ae().m12528v()) / 10.0f));
        if (VERSION.SDK_INT >= 11) {
            float f;
            float f2 = 0.5f;
            this.f11073h.setAlpha(this.f11066a.ae().f9132f == this.f11066a.ae().m12525s() ? 0.5f : 1.0f);
            View view = this.f11074i;
            if (this.f11066a.ae().f9131e == this.f11066a.ae().m12525s()) {
                f = 0.5f;
            } else {
                f = 1.0f;
            }
            view.setAlpha(f);
            view = this.f11076k;
            if (this.f11066a.ae().f9134h == this.f11066a.ae().m12526t()) {
                f = 0.5f;
            } else {
                f = 1.0f;
            }
            view.setAlpha(f);
            view = this.f11077l;
            if (this.f11066a.ae().f9133g == this.f11066a.ae().m12526t()) {
                f = 0.5f;
            } else {
                f = 1.0f;
            }
            view.setAlpha(f);
            view = this.f11079n;
            if (this.f11066a.ae().f9136j == this.f11066a.ae().m12527u()) {
                f = 0.5f;
            } else {
                f = 1.0f;
            }
            view.setAlpha(f);
            view = this.f11080o;
            if (this.f11066a.ae().f9135i == this.f11066a.ae().m12527u()) {
                f = 0.5f;
            } else {
                f = 1.0f;
            }
            view.setAlpha(f);
            view = this.f11082q;
            if (this.f11071f == this.f11066a.ae().m12530x()) {
                f = 0.5f;
            } else {
                f = 1.0f;
            }
            view.setAlpha(f);
            view = this.f11083r;
            if (this.f11070e == this.f11066a.ae().m12530x()) {
                f = 0.5f;
            } else {
                f = 1.0f;
            }
            view.setAlpha(f);
            view = this.f11085t;
            if (this.f11071f == this.f11066a.ae().m12528v()) {
                f = 0.5f;
            } else {
                f = 1.0f;
            }
            view.setAlpha(f);
            View view2 = this.f11086u;
            if (this.f11070e != this.f11066a.ae().m12528v()) {
                f2 = 1.0f;
            }
            view2.setAlpha(f2);
        }
    }

    /* renamed from: a */
    private String m15038a(float f) {
        float round = ((float) Math.round(f * 10.0f)) / 10.0f;
        if (((float) ((int) round)) == round && ((int) round) == 0) {
            return String.format("%d", new Object[]{Integer.valueOf((int) round)});
        }
        return String.format("%.1f", new Object[]{Float.valueOf(round)});
    }
}
