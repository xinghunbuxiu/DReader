package com.duokan.reader.ui.general;

import android.content.Context;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.Selection;
import android.text.TextUtils;

import com.duokan.b.i;

public class fc {
    private final Context a;
    private final dp b;
    private int c = -1;
    private String d;
    private dn e;
    private dm f;
    private jq g;

    public fc(Context context, dp dpVar) {
        this.a = context;
        this.b = dpVar;
        this.b.d().addTextChangedListener(new fd(this));
        if (this.b.e() != null) {
            this.b.e().setVisibility(8);
        }
        this.b.a().setOnClickListener(new fe(this));
        if (this.b.c() != null) {
            this.b.c().setOnClickListener(new ff(this));
        }
    }

    public void a() {
        Selection.setSelection(this.b.d().getEditableText(), this.b.d().getEditableText().length());
        if (!TextUtils.isEmpty(this.d)) {
            fg fgVar = new fg(this);
            this.b.d().setFilters(new InputFilter[]{fgVar});
        }
    }

    public void a(String str) {
        this.b.b().setText(str);
    }

    public void a(int i) {
        a(this.a.getResources().getString(i));
    }

    public void b(String str) {
        this.b.d().setHint(str);
    }

    public void b(int i) {
        this.c = i;
        this.b.d().setFilters(new InputFilter[]{new LengthFilter(this.c)});
        if (this.b.e() != null) {
            this.b.e().setVisibility(0);
        }
        d();
    }

    public void c(String str) {
        if (TextUtils.isEmpty(this.d)) {
            this.b.d().setText(str);
        } else {
            this.b.d().setText(this.d + str);
        }
    }

    public String b() {
        String obj = this.b.d().getEditableText().toString();
        if (!TextUtils.isEmpty(this.d)) {
            obj = obj.substring(this.d.length());
        }
        return obj.trim();
    }

    public void a(dn dnVar) {
        this.e = dnVar;
    }

    public void a(dm dmVar) {
        this.f = dmVar;
    }

    public void c() {
        this.b.f();
        if (this.f != null) {
            this.f.a();
        }
    }

    private void d() {
        if (this.b.e() != null) {
            this.b.e().setText(String.valueOf(this.c - this.b.d().length()));
        }
    }

    private void e() {
        f();
        this.e.a(b(), new fh(this));
    }

    private void f() {
        if (this.g == null) {
            this.g = new jq(this.a);
            this.g.setCancelOnBack(false);
            this.g.setCancelOnTouchOutside(false);
            this.g.a(this.a.getString(i.general__shared__saving_changes));
            this.g.show();
        }
    }

    private void g() {
        if (this.g != null) {
            this.g.dismiss();
            this.g = null;
        }
    }
}
