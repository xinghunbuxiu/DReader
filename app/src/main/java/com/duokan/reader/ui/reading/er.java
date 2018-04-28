package com.duokan.reader.ui.reading;

import android.graphics.Typeface;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.duokan.core.app.IFeature;
import com.duokan.p023b.C0243e;
import com.duokan.p023b.C0244f;
import com.duokan.p023b.C0245g;
import com.duokan.p023b.C0247i;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.p044b.C0781b;
import com.duokan.reader.domain.p044b.C0792m;
import com.duokan.reader.domain.p044b.C0794o;
import com.duokan.reader.ui.general.HeaderView;
import com.duokan.reader.ui.general.TabView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class er extends eo {
    /* renamed from: a */
    private boolean f10098a = true;
    /* renamed from: b */
    private final su f10099b = ((su) getContext().queryFeature(su.class));
    /* renamed from: c */
    private final HeaderView f10100c = ((HeaderView) findViewById(C0244f.reading__custom_font_list_view__header));
    /* renamed from: d */
    private final TabView f10101d;
    /* renamed from: e */
    private final LinearLayout f10102e;
    /* renamed from: f */
    private final View f10103f;
    /* renamed from: g */
    private final View f10104g;
    /* renamed from: h */
    private final ArrayList<C0792m> f10105h = new ArrayList();
    /* renamed from: i */
    private final boolean f10106i;
    /* renamed from: j */
    private C0794o f10107j = null;
    /* renamed from: k */
    private TextView f10108k = null;

    public er(IFeature mFeature, boolean z) {
        super(mFeature);
        this.f10100c.setLeftTitle(C0247i.reading__custom_font_list_view__dk_title);
        this.f10100c.m10143a(getContext().getResources().getDrawable(C0243e.reading__custom_font_list_view__add_font_dark)).setOnClickListener(new es(this));
        this.f10101d = (TabView) findViewById(C0244f.reading__custom_font_list_view__tab);
        this.f10108k = (TextView) findViewById(C0244f.reading__custom_font_list_view__defautl_font);
        this.f10102e = (LinearLayout) findViewById(C0244f.reading__custom_font_list_view__list);
        this.f10106i = z;
        this.f10103f = findViewById(C0244f.reading__custom_font_list_view__default_panel);
        this.f10104g = findViewById(C0244f.reading__custom_font_list_view__scrollview);
        if (this.f10098a) {
            this.f10101d.m1695a(0);
        } else {
            this.f10101d.m1695a(1);
        }
        m14023d();
        this.f10101d.setOnDelayedSelectionChangeListener(new et(this));
        this.f10103f.setOnClickListener(new eu(this));
    }

    /* renamed from: a */
    public void mo2311a() {
        m14023d();
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        if (this.f10106i) {
            ((su) getContext().queryFeature(su.class)).aA();
        }
    }

    /* renamed from: d */
    private void m14023d() {
        this.f10105h.clear();
        this.f10105h.addAll(Arrays.asList(C0781b.m3667b().m3692e()));
        this.f10108k.setText(this.f10098a ? C0247i.reading__custom_font_list_view__default : C0247i.reading__custom_font_list_view__default_en);
        Collections.sort(this.f10105h, new ev(this));
        Iterator it = this.f10105h.iterator();
        while (it.hasNext()) {
            C0792m c0792m = (C0792m) it.next();
            if (c0792m.m3698b().equals("fzlth.ttf")) {
                this.f10107j = (C0794o) c0792m;
                this.f10105h.remove(this.f10107j);
                break;
            }
        }
        this.f10104g.scrollTo(0, 0);
        this.f10102e.removeAllViewsInLayout();
        LayoutInflater from = LayoutInflater.from(getContext());
        Iterator it2 = this.f10105h.iterator();
        while (it2.hasNext()) {
            c0792m = (C0792m) it2.next();
            if ((this.f10098a || !c0792m.m3699c()) && (!this.f10098a || c0792m.m3699c())) {
                View inflate = from.inflate(C0245g.reading__custom_font_view, this.f10102e, false);
                this.f10102e.addView(inflate);
                inflate.setOnClickListener(new ew(this, (C0794o) c0792m));
            }
        }
        mo2312b();
    }

    /* renamed from: b */
    protected void mo2312b() {
        boolean z = false;
        super.mo2312b();
        this.f10101d.setVisibility(8);
        boolean z2 = false;
        for (int i = 0; i < this.f10102e.getChildCount(); i++) {
            if (m14017a(this.f10102e.getChildAt(i), (C0794o) this.f10105h.get(i))) {
                z2 = true;
            }
        }
        View findViewById = this.f10103f.findViewById(C0244f.reading__custom_font_view__as_default);
        if (this.f10098a) {
            if (this.f10099b.ae().m12461V().equals("FONT_URI_DEFAULT")) {
                z = true;
            }
            findViewById.setSelected(z);
        } else {
            if (this.f10099b.ae().m12462W().equals("FONT_URI_DEFAULT")) {
                z = true;
            }
            findViewById.setSelected(z);
        }
        if (!z2 && this.f10098a) {
            findViewById.setSelected(true);
        }
    }

    /* renamed from: a */
    private boolean m14017a(View view, C0794o c0794o) {
        boolean z = true;
        TextView textView = (TextView) view.findViewById(C0244f.reading__custom_font_view__font_name);
        View findViewById = view.findViewById(C0244f.reading__custom_font_view__as_default);
        try {
            Typeface createFromFile;
            if (c0794o.m3704e()) {
                createFromFile = Typeface.createFromFile(ReaderEnv.get().getSystemFontFileZh());
            } else {
                createFromFile = Typeface.createFromFile(c0794o.m3703d());
            }
            textView.setTypeface(createFromFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        textView.setText(c0794o.mo947a());
        if (c0794o.m3704e()) {
            if (this.f10098a) {
                boolean z2;
                if (this.f10099b.ae().m12461V().equals("FONT_URI_SYSTEM")) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                findViewById.setSelected(z2);
            } else {
                if (!this.f10099b.ae().m12462W().equals("FONT_URI_SYSTEM")) {
                    z = false;
                }
                findViewById.setSelected(z);
            }
        } else if (this.f10098a) {
            if (!this.f10099b.ae().m12461V().equals(Uri.fromFile(c0794o.m3703d()).toString())) {
                z = false;
            }
            findViewById.setSelected(z);
        } else {
            if (!this.f10099b.ae().m12462W().equals(Uri.fromFile(c0794o.m3703d()).toString())) {
                z = false;
            }
            findViewById.setSelected(z);
        }
        return findViewById.isSelected();
    }

    /* renamed from: a */
    private void m14016a(String str) {
        this.f10099b.ae().m12487c(str);
        this.f10099b.aA();
    }

    /* renamed from: b */
    private void m14021b(String str) {
        this.f10099b.ae().m12493d(str);
        this.f10099b.aA();
    }

    /* renamed from: c */
    protected int mo2313c() {
        return C0245g.reading__custom_font_list_view;
    }
}
