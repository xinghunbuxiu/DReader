package com.duokan.reader.ui.reading;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.TextView;

import com.duokan.b.f;
import com.duokan.b.g;
import com.duokan.core.app.y;

public class vd extends wk {
    private final sh a;
    private final float b = 0.1f;
    private final float c = 0.1f;
    private final int d = 1;
    private final int e;
    private final int f;
    private final TextView g;
    private final View h;
    private final View i;
    private final TextView j;
    private final View k;
    private final View l;
    private final TextView m;
    private final View n;
    private final View o;
    private final TextView p;
    private final View q;
    private final View r;
    private final TextView s;
    private final View t;
    private final View u;

    public vd(y yVar) {
        super(yVar);
        setContentView(g.reading__reading_custom_typesetting_view);
        this.a = (sh) getContext().queryFeature(sh.class);
        this.g = (TextView) findViewById(f.reading__custom_typesetting__line_spacing_value);
        this.j = (TextView) findViewById(f.reading__custom_typesetting__paragraph_spacing_value);
        this.m = (TextView) findViewById(f.reading__custom_typesetting__indent_value);
        this.p = (TextView) findViewById(f.reading__custom_typesetting__top_margin_value);
        this.s = (TextView) findViewById(f.reading__custom_typesetting__lateral_margin_value);
        this.h = findViewById(f.reading__custom_typesetting__line_spacing_add);
        this.h.setOnClickListener(new ve(this));
        this.i = findViewById(f.reading__custom_typesetting__line_spacing_reduce);
        this.i.setOnClickListener(new vg(this));
        this.k = findViewById(f.reading__custom_typesetting__paragraph_spacing_add);
        this.k.setOnClickListener(new vh(this));
        this.l = findViewById(f.reading__custom_typesetting__paragraph_spacing_reduce);
        this.l.setOnClickListener(new vi(this));
        this.n = findViewById(f.reading__custom_typesetting__indent_add);
        this.n.setOnClickListener(new vj(this));
        this.o = findViewById(f.reading__custom_typesetting__indent_reduce);
        this.o.setOnClickListener(new vk(this));
        this.e = this.a.ae().g();
        this.f = this.a.ae().h();
        this.q = findViewById(f.reading__custom_typesetting__top_margin_add);
        this.q.setOnClickListener(new vl(this));
        this.r = findViewById(f.reading__custom_typesetting__top_margin_reduce);
        this.r.setOnClickListener(new vm(this));
        this.t = findViewById(f.reading__custom_typesetting__lateral_margin_add);
        this.t.setOnClickListener(new vn(this));
        this.u = findViewById(f.reading__custom_typesetting__lateral_margin_reduce);
        this.u.setOnClickListener(new vf(this));
        a();
    }

    @SuppressLint({"NewApi"})
    private void a() {
        if (this.a.G().ai()) {
            findViewById(f.reading__custom_typesetting_view__indent_panel).setVisibility(8);
        } else {
            findViewById(f.reading__custom_typesetting_view__indent_panel).setVisibility(0);
        }
        this.g.setText(a(this.a.ae().s()));
        this.j.setText(a(this.a.ae().t()));
        this.m.setText(String.format("%d", new Object[]{Integer.valueOf((int) this.a.ae().u())}));
        this.p.setText(a(((float) this.a.ae().x()) / 10.0f));
        this.s.setText(a(((float) this.a.ae().v()) / 10.0f));
        if (VERSION.SDK_INT >= 11) {
            float f;
            float f2 = 0.5f;
            this.h.setAlpha(this.a.ae().f == this.a.ae().s() ? 0.5f : 1.0f);
            View view = this.i;
            if (this.a.ae().e == this.a.ae().s()) {
                f = 0.5f;
            } else {
                f = 1.0f;
            }
            view.setAlpha(f);
            view = this.k;
            if (this.a.ae().h == this.a.ae().t()) {
                f = 0.5f;
            } else {
                f = 1.0f;
            }
            view.setAlpha(f);
            view = this.l;
            if (this.a.ae().g == this.a.ae().t()) {
                f = 0.5f;
            } else {
                f = 1.0f;
            }
            view.setAlpha(f);
            view = this.n;
            if (this.a.ae().j == this.a.ae().u()) {
                f = 0.5f;
            } else {
                f = 1.0f;
            }
            view.setAlpha(f);
            view = this.o;
            if (this.a.ae().i == this.a.ae().u()) {
                f = 0.5f;
            } else {
                f = 1.0f;
            }
            view.setAlpha(f);
            view = this.q;
            if (this.f == this.a.ae().x()) {
                f = 0.5f;
            } else {
                f = 1.0f;
            }
            view.setAlpha(f);
            view = this.r;
            if (this.e == this.a.ae().x()) {
                f = 0.5f;
            } else {
                f = 1.0f;
            }
            view.setAlpha(f);
            view = this.t;
            if (this.f == this.a.ae().v()) {
                f = 0.5f;
            } else {
                f = 1.0f;
            }
            view.setAlpha(f);
            View view2 = this.u;
            if (this.e != this.a.ae().v()) {
                f2 = 1.0f;
            }
            view2.setAlpha(f2);
        }
    }

    private String a(float f) {
        float round = ((float) Math.round(f * 10.0f)) / 10.0f;
        if (((float) ((int) round)) == round && ((int) round) == 0) {
            return String.format("%d", new Object[]{Integer.valueOf((int) round)});
        }
        return String.format("%.1f", new Object[]{Float.valueOf(round)});
    }
}
