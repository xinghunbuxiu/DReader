package com.duokan.reader.ui.bookshelf;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ui.general.HeaderView;
import com.duokan.reader.ui.general.p052a.C1317a;

public class jj extends ActivatedController {
    /* renamed from: a */
    private final HeaderView f6664a;
    /* renamed from: b */
    private final ViewGroup f6665b;
    /* renamed from: c */
    private final TextView f6666c;
    /* renamed from: d */
    private final TextView f6667d;
    /* renamed from: e */
    private final hv f6668e;
    /* renamed from: f */
    private boolean f6669f = false;

    public jj(IFeature mFeature, hv hvVar) {
        super(mFeature);
        this.f6668e = hvVar;
        setContentView(C0256h.bookshelf__web_list_edit_manager_view);
        this.f6664a = (HeaderView) findViewById(C0255g.bookshelf__web_list_edit_manager_view__header);
        this.f6664a.setHasBackButton(false);
        this.f6664a.m10144a(getString(C0258j.general__shared__cancel)).setOnClickListener(new jk(this));
        this.f6666c = this.f6664a.m10148b(getString(C0258j.general__shared__select_all));
        this.f6666c.setOnClickListener(new jl(this));
        this.f6665b = (ViewGroup) findViewById(C0255g.bookshelf__web_list_edit_manager_view__footer);
        this.f6667d = (TextView) findViewById(C0255g.bookshelf__web_list_edit_manager_view__delete);
        this.f6667d.setOnClickListener(new jm(this));
        this.f6664a.setCenterTitle(m9869f());
        CharSequence k = hvVar.mo1890k();
        if (!TextUtils.isEmpty(k)) {
            this.f6667d.setText(k);
        }
        m9875c();
    }

    /* renamed from: a */
    public void m9873a() {
        m9875c();
    }

    /* renamed from: b */
    public void m9874b() {
        m9875c();
    }

    protected void onActive(boolean z) {
        m9872i();
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
        this.f6668e.mo1885f();
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        this.f6668e.mo1887h();
    }

    protected boolean onBack() {
        if (!this.f6669f) {
            return super.onBack();
        }
        this.f6668e.mo1880b();
        return true;
    }

    /* renamed from: c */
    public void m9875c() {
        this.f6667d.setEnabled(false);
        if (this.f6668e.mo1884e() > 0) {
            this.f6667d.setEnabled(true);
            this.f6664a.setCenterTitle(String.format(m9870g(), new Object[]{Integer.valueOf(this.f6668e.mo1884e())}));
        } else {
            this.f6664a.setCenterTitle(m9869f());
        }
        m9868e();
    }

    /* renamed from: e */
    private void m9868e() {
        if (this.f6668e.mo1886g()) {
            this.f6666c.setText(C0258j.general__shared__select_none);
        } else {
            this.f6666c.setText(C0258j.general__shared__select_all);
        }
    }

    /* renamed from: f */
    private String m9869f() {
        Object i = this.f6668e.mo1888i();
        return !TextUtils.isEmpty(i) ? i : getString(C0258j.bookshelf__shared__select_books);
    }

    /* renamed from: g */
    private String m9870g() {
        Object j = this.f6668e.mo1889j();
        return !TextUtils.isEmpty(j) ? j : getString(C0258j.bookshelf__shared__d_books_selected);
    }

    /* renamed from: h */
    private void m9871h() {
        this.f6668e.mo1879a(new jn(this));
    }

    /* renamed from: i */
    private void m9872i() {
        this.f6669f = true;
        C1317a.m10195a(this.f6664a, 1, 0.0f, 0.0f, -1.0f, 0.0f, 300, Boolean.valueOf(true), null);
        C1317a.m10195a(this.f6665b, 1, 0.0f, 0.0f, 1.0f, 0.0f, 300, Boolean.valueOf(true), null);
    }

    /* renamed from: d */
    public void m9876d() {
        this.f6669f = false;
        C1317a.m10195a(this.f6664a, 1, 0.0f, 0.0f, 0.0f, -1.0f, 300, Boolean.valueOf(true), new jo(this));
        C1317a.m10195a(this.f6665b, 1, 0.0f, 0.0f, 0.0f, 1.0f, 300, Boolean.valueOf(true), null);
    }
}
