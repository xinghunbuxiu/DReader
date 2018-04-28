package com.duokan.reader.ui.general;

import android.content.Context;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.Selection;
import android.text.TextUtils;
import com.duokan.p023b.C0247i;

public class fa {
    /* renamed from: a */
    private final Context f7201a;
    /* renamed from: b */
    private final dp f7202b;
    /* renamed from: c */
    private int f7203c = -1;
    /* renamed from: d */
    private String f7204d;
    /* renamed from: e */
    private dn f7205e;
    /* renamed from: f */
    private dm f7206f;
    /* renamed from: g */
    private ja f7207g;

    public fa(Context context, dp dpVar) {
        this.f7201a = context;
        this.f7202b = dpVar;
        this.f7202b.mo1775d().addTextChangedListener(new fb(this));
        if (this.f7202b.mo1776e() != null) {
            this.f7202b.mo1776e().setVisibility(8);
        }
        this.f7202b.mo1772a().setOnClickListener(new fc(this));
        if (this.f7202b.mo1774c() != null) {
            this.f7202b.mo1774c().setOnClickListener(new fd(this));
        }
    }

    /* renamed from: a */
    public void m10626a() {
        Selection.setSelection(this.f7202b.mo1775d().getEditableText(), this.f7202b.mo1775d().getEditableText().length());
        if (!TextUtils.isEmpty(this.f7204d)) {
            fe feVar = new fe(this);
            this.f7202b.mo1775d().setFilters(new InputFilter[]{feVar});
        }
    }

    /* renamed from: a */
    public void m10630a(String str) {
        this.f7202b.mo1773b().setText(str);
    }

    /* renamed from: a */
    public void m10627a(int i) {
        m10630a(this.f7201a.getResources().getString(i));
    }

    /* renamed from: b */
    public void m10633b(String str) {
        this.f7202b.mo1775d().setHint(str);
    }

    /* renamed from: b */
    public void m10632b(int i) {
        this.f7203c = i;
        this.f7202b.mo1775d().setFilters(new InputFilter[]{new LengthFilter(this.f7203c)});
        if (this.f7202b.mo1776e() != null) {
            this.f7202b.mo1776e().setVisibility(0);
        }
        m10618d();
    }

    /* renamed from: c */
    public void m10635c(String str) {
        if (TextUtils.isEmpty(this.f7204d)) {
            this.f7202b.mo1775d().setText(str);
        } else {
            this.f7202b.mo1775d().setText(this.f7204d + str);
        }
    }

    /* renamed from: b */
    public String m10631b() {
        String obj = this.f7202b.mo1775d().getEditableText().toString();
        if (!TextUtils.isEmpty(this.f7204d)) {
            obj = obj.substring(this.f7204d.length());
        }
        return obj.trim();
    }

    /* renamed from: a */
    public void m10629a(dn dnVar) {
        this.f7205e = dnVar;
    }

    /* renamed from: a */
    public void m10628a(dm dmVar) {
        this.f7206f = dmVar;
    }

    /* renamed from: c */
    public void m10634c() {
        this.f7202b.mo1777f();
        if (this.f7206f != null) {
            this.f7206f.mo1841a();
        }
    }

    /* renamed from: d */
    private void m10618d() {
        if (this.f7202b.mo1776e() != null) {
            this.f7202b.mo1776e().setText(String.valueOf(this.f7203c - this.f7202b.mo1775d().length()));
        }
    }

    /* renamed from: e */
    private void m10621e() {
        m10622f();
        this.f7205e.mo1582a(m10631b(), new ff(this));
    }

    /* renamed from: f */
    private void m10622f() {
        if (this.f7207g == null) {
            this.f7207g = new ja(this.f7201a);
            this.f7207g.setCancelOnBack(false);
            this.f7207g.setCancelOnTouchOutside(false);
            this.f7207g.m10843a(this.f7201a.getString(C0247i.general__shared__saving_changes));
            this.f7207g.show();
        }
    }

    /* renamed from: g */
    private void m10625g() {
        if (this.f7207g != null) {
            this.f7207g.dismiss();
            this.f7207g = null;
        }
    }
}
