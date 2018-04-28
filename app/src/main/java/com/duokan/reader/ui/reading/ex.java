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

public class ex extends eo {
    /* renamed from: a */
    private boolean f10116a = true;
    /* renamed from: b */
    private final su f10117b = ((su) getContext().queryFeature(su.class));
    /* renamed from: c */
    private final HeaderView f10118c = ((HeaderView) findViewById(C0244f.reading__custom_font_list_view__header));
    /* renamed from: d */
    private final TabView f10119d;
    /* renamed from: e */
    private final LinearLayout f10120e;
    /* renamed from: f */
    private final View f10121f;
    /* renamed from: g */
    private final View f10122g;
    /* renamed from: h */
    private final ArrayList<C0792m> f10123h = new ArrayList();
    /* renamed from: i */
    private final boolean f10124i;
    /* renamed from: j */
    private C0794o f10125j = null;
    /* renamed from: k */
    private TextView f10126k = null;

    public ex(IFeature mFeature, boolean z) {
        super(mFeature);
        this.f10118c.setLeftTitle(C0247i.reading__custom_font_list_view__title);
        this.f10118c.m10143a(getContext().getResources().getDrawable(C0243e.reading__custom_font_list_view__add_font_dark)).setOnClickListener(new ey(this));
        this.f10119d = (TabView) findViewById(C0244f.reading__custom_font_list_view__tab);
        this.f10126k = (TextView) findViewById(C0244f.reading__custom_font_list_view__defautl_font);
        this.f10120e = (LinearLayout) findViewById(C0244f.reading__custom_font_list_view__list);
        this.f10124i = z;
        this.f10121f = findViewById(C0244f.reading__custom_font_list_view__default_panel);
        this.f10122g = findViewById(C0244f.reading__custom_font_list_view__scrollview);
        if (this.f10116a) {
            this.f10119d.m1695a(0);
        } else {
            this.f10119d.m1695a(1);
        }
        m14038d();
        this.f10119d.setOnDelayedSelectionChangeListener(new ez(this));
        this.f10121f.setOnClickListener(new fa(this));
    }

    /* renamed from: a */
    public void mo2311a() {
        m14038d();
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        if (this.f10124i) {
            ((su) getContext().queryFeature(su.class)).aA();
        }
    }

    /* renamed from: d */
    private void m14038d() {
        this.f10123h.clear();
        this.f10123h.addAll(Arrays.asList(C0781b.m3667b().m3692e()));
        this.f10126k.setText(this.f10116a ? C0247i.reading__custom_font_list_view__default : C0247i.reading__custom_font_list_view__default_en);
        Collections.sort(this.f10123h, new fb(this));
        Iterator it = this.f10123h.iterator();
        while (it.hasNext()) {
            C0792m c0792m = (C0792m) it.next();
            if (c0792m.m3698b().equals("fzlth.ttf")) {
                this.f10125j = (C0794o) c0792m;
                this.f10123h.remove(this.f10125j);
                break;
            }
        }
        this.f10122g.scrollTo(0, 0);
        this.f10120e.removeAllViewsInLayout();
        LayoutInflater from = LayoutInflater.from(getContext());
        Iterator it2 = this.f10123h.iterator();
        while (it2.hasNext()) {
            c0792m = (C0792m) it2.next();
            if ((this.f10116a || !c0792m.m3699c()) && (!this.f10116a || c0792m.m3699c())) {
                View inflate = from.inflate(C0245g.reading__custom_font_view, this.f10120e, false);
                this.f10120e.addView(inflate);
                inflate.setOnClickListener(new fc(this, (C0794o) c0792m));
            }
        }
        mo2312b();
    }

    /* renamed from: b */
    protected void mo2312b() {
        boolean z = false;
        super.mo2312b();
        boolean z2 = false;
        for (int i = 0; i < this.f10120e.getChildCount(); i++) {
            if (m14032a(this.f10120e.getChildAt(i), (C0794o) this.f10123h.get(i))) {
                z2 = true;
            }
        }
        View findViewById = this.f10121f.findViewById(C0244f.reading__custom_font_view__as_default);
        if (this.f10116a) {
            if (this.f10117b.ae().m12459T().equals("FONT_URI_DEFAULT")) {
                z = true;
            }
            findViewById.setSelected(z);
        } else {
            if (this.f10117b.ae().m12460U().equals("FONT_URI_DEFAULT")) {
                z = true;
            }
            findViewById.setSelected(z);
        }
        if (!z2 && this.f10116a) {
            findViewById.setSelected(true);
        }
    }

    /* renamed from: a */
    private boolean m14032a(View view, C0794o c0794o) {
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
            if (this.f10116a) {
                boolean z2;
                if (this.f10117b.ae().m12459T().equals("FONT_URI_SYSTEM")) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                findViewById.setSelected(z2);
            } else {
                if (!this.f10117b.ae().m12460U().equals("FONT_URI_SYSTEM")) {
                    z = false;
                }
                findViewById.setSelected(z);
            }
        } else if (this.f10116a) {
            if (!this.f10117b.ae().m12459T().equals(Uri.fromFile(c0794o.m3703d()).toString())) {
                z = false;
            }
            findViewById.setSelected(z);
        } else {
            if (!this.f10117b.ae().m12460U().equals(Uri.fromFile(c0794o.m3703d()).toString())) {
                z = false;
            }
            findViewById.setSelected(z);
        }
        return findViewById.isSelected();
    }

    /* renamed from: a */
    private void m14031a(String str) {
        this.f10117b.ae().m12473a(str);
        this.f10117b.aA();
    }

    /* renamed from: b */
    private void m14036b(String str) {
        this.f10117b.ae().m12481b(str);
        this.f10117b.aA();
    }

    /* renamed from: c */
    protected int mo2313c() {
        return C0245g.reading__custom_font_list_view;
    }
}
