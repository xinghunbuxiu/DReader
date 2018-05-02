package com.duokan.reader.ui.bookshelf;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;

import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.c.j;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;
import com.duokan.reader.ui.general.HeaderView;

public class il extends ActivatedController {
    private final HeaderView a;
    private final ViewGroup b;
    private final TextView c;
    private final TextView d;
    private final ho e;
    private boolean f = false;

    public il(IFeature featrue, ho hoVar) {
        super(featrue);
        this.e = hoVar;
        setContentView(h.bookshelf__web_list_edit_manager_view);
        this.a = (HeaderView) findViewById(g.bookshelf__web_list_edit_manager_view__header);
        this.a.setHasBackButton(false);
        this.a.a(getString(j.general__shared__cancel)).setOnClickListener(new im(this));
        this.c = this.a.b(getString(j.general__shared__select_all));
        this.c.setOnClickListener(new in(this));
        this.b = (ViewGroup) findViewById(g.bookshelf__web_list_edit_manager_view__footer);
        this.d = (TextView) findViewById(g.bookshelf__web_list_edit_manager_view__delete);
        this.d.setOnClickListener(new io(this));
        this.a.setCenterTitle(f());
        CharSequence k = hoVar.k();
        if (!TextUtils.isEmpty(k)) {
            this.d.setText(k);
        }
        c();
    }

    public void a() {
        c();
    }

    public void b() {
        c();
    }

    protected void onActive(boolean z) {
        i();
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
        this.e.f();
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        this.e.h();
    }

    protected boolean onBack() {
        if (!this.f) {
            return super.onBack();
        }
        this.e.b();
        return true;
    }

    public void c() {
        this.d.setEnabled(false);
        if (this.e.e() > 0) {
            this.d.setEnabled(true);
            this.a.setCenterTitle(String.format(g(), new Object[]{Integer.valueOf(this.e.e())}));
        } else {
            this.a.setCenterTitle(f());
        }
        e();
    }

    private void e() {
        if (this.e.g()) {
            this.c.setText(j.general__shared__select_none);
        } else {
            this.c.setText(j.general__shared__select_all);
        }
    }

    private String f() {
        Object i = this.e.i();
        return !TextUtils.isEmpty(i) ? i : getString(j.bookshelf__shared__select_books);
    }

    private String g() {
        Object j = this.e.j();
        return !TextUtils.isEmpty(j) ? j : getString(j.bookshelf__shared__d_books_selected);
    }

    private void h() {
        this.e.a(new ip(this));
    }

    private void i() {
        this.f = true;
        a.a(this.a, 1, 0.0f, 0.0f, -1.0f, 0.0f, 300, Boolean.valueOf(true), null);
        a.a(this.b, 1, 0.0f, 0.0f, 1.0f, 0.0f, 300, Boolean.valueOf(true), null);
    }

    public void d() {
        this.f = false;
        a.a(this.a, 1, 0.0f, 0.0f, 0.0f, -1.0f, 300, Boolean.valueOf(true), new iq(this));
        a.a(this.b, 1, 0.0f, 0.0f, 0.0f, 1.0f, 300, Boolean.valueOf(true), null);
    }
}
