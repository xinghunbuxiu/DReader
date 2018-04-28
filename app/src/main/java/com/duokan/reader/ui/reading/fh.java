package com.duokan.reader.ui.reading;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.duokan.common.C0267i;
import com.duokan.core.app.IFeature;
import com.duokan.core.ui.dv;
import com.duokan.p023b.C0243e;
import com.duokan.p023b.C0244f;
import com.duokan.p023b.C0245g;
import com.duokan.reader.ReaderEnv;

public class fh extends wx {
    /* renamed from: a */
    private final su f10141a = ((su) getContext().queryFeature(su.class));
    /* renamed from: b */
    private final ViewGroup f10142b = ((ViewGroup) LayoutInflater.from(getContext()).inflate(C0245g.reading__reading_options_view__custom_themes_list, null));
    /* renamed from: c */
    private final ReadingTheme[] f10143c;
    /* renamed from: d */
    private final LinearLayout f10144d;
    /* renamed from: e */
    private final LinearLayout f10145e;
    /* renamed from: f */
    private final LinearLayout f10146f;

    public fh(IFeature mFeature) {
        int i;
        super(mFeature);
        this.f10142b.setLayoutParams(new LayoutParams(ReaderEnv.get().forHd() ? dv.m1932b(getContext(), 400.0f) : -1, -2));
        setContentView(this.f10142b);
        this.f10143c = new ReadingTheme[]{ReadingTheme.THEME7, ReadingTheme.THEME1, ReadingTheme.THEME2, ReadingTheme.THEME3, ReadingTheme.THEME4, ReadingTheme.THEME6, ReadingTheme.THEME9, ReadingTheme.THEME8, ReadingTheme.THEME10, ReadingTheme.THEME11, ReadingTheme.THEME12, ReadingTheme.THEME17, ReadingTheme.THEME13, ReadingTheme.THEME15, ReadingTheme.THEME14, ReadingTheme.THEME16, ReadingTheme.THEME18};
        this.f10144d = (LinearLayout) findViewById(C0244f.reading__reading_options_view__theme_bar_1);
        for (i = 0; i < 6; i++) {
            this.f10144d.addView(m14054a(i));
        }
        this.f10145e = (LinearLayout) findViewById(C0244f.reading__reading_options_view__theme_bar_2);
        for (i = 6; i < 11; i++) {
            this.f10145e.addView(m14054a(i));
        }
        this.f10145e.addView(m14057b());
        this.f10146f = (LinearLayout) findViewById(C0244f.reading__reading_options_view__theme_bar_vine);
        for (i = 11; i < this.f10143c.length; i++) {
            this.f10146f.addView(m14058b(i));
        }
        m14056a();
    }

    /* renamed from: a */
    private final void m14056a() {
        int i;
        boolean z;
        ReadingTheme q = this.f10141a.ae().m12523q();
        for (i = 0; i < this.f10144d.getChildCount(); i++) {
            boolean z2;
            View childAt = this.f10144d.getChildAt(i);
            if (this.f10143c[i] == q) {
                z2 = true;
            } else {
                z2 = false;
            }
            childAt.setSelected(z2);
        }
        for (i = 0; i < this.f10145e.getChildCount() - 1; i++) {
            childAt = this.f10145e.getChildAt(i);
            if (this.f10143c[i + 6] == q) {
                z2 = true;
            } else {
                z2 = false;
            }
            childAt.setSelected(z2);
        }
        View childAt2 = this.f10145e.getChildAt(this.f10145e.getChildCount() - 1);
        if (q == ReadingTheme.CUSTOM) {
            z = true;
        } else {
            z = false;
        }
        childAt2.setSelected(z);
        for (i = 0; i < this.f10146f.getChildCount(); i++) {
            childAt = this.f10146f.getChildAt(i);
            if (this.f10143c[i + 11] == q) {
                z2 = true;
            } else {
                z2 = false;
            }
            childAt.setSelected(z2);
        }
    }

    /* renamed from: a */
    private final adm m14054a(int i) {
        Drawable drawable;
        if (this.f10143c[i] == ReadingTheme.THEME12) {
            drawable = getResources().getDrawable(C0243e.reading__reading_themes_color__old_night_mode);
        } else {
            drawable = new ColorDrawable(this.f10141a.ae().m12478b(this.f10143c[i]));
        }
        adm adm = new adm(getContext(), drawable);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2, 1.0f);
        int a = C0267i.m598a(getContext(), 8.0f);
        adm.setPadding(a, 0, a, 0);
        adm.setLayoutParams(layoutParams);
        adm.setOnClickListener(new fi(this, i));
        return adm;
    }

    /* renamed from: b */
    private final adm m14058b(int i) {
        adm adm = new adm(getContext(), this.f10141a.ae().m12484c(this.f10143c[i]));
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2, 1.0f);
        int a = C0267i.m598a(getContext(), 8.0f);
        adm.setPadding(a, 0, a, 0);
        adm.setLayoutParams(layoutParams);
        adm.setOnClickListener(new fj(this, i));
        return adm;
    }

    /* renamed from: b */
    private View m14057b() {
        View fdVar = new fd(getContext(), this.f10141a.mo1998O(), this.f10141a.mo1999P());
        int a = C0267i.m598a(getContext(), 8.0f);
        fdVar.setPadding(a, 0, a, 0);
        fdVar.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 1.0f));
        fdVar.setOnClickListener(new fk(this));
        fdVar.setOnLongClickListener(new fl(this));
        return fdVar;
    }
}
