package com.duokan.reader.ui.reading;

import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;

import com.duokan.core.app.e;
import com.duokan.core.app.y;
import com.duokan.core.ui.BoxView;
import com.duokan.core.ui.dv;
import com.duokan.reader.domain.document.aa;
import com.duokan.reader.domain.document.n;
import com.duokan.reader.domain.document.w;
import com.duokan.reader.domain.document.z;
import com.duokan.reader.ui.general.DkWebListView;
import com.duokan.reader.ui.general.dk;

import java.util.ArrayList;
import java.util.Collections;

abstract class yb extends e implements w {
    static final /* synthetic */ boolean h = (!yb.class.desiredAssertionStatus());
    protected final n a = ((sh) getContext().queryFeature(sh.class)).getDocument();
    protected final yh b;
    protected final EditText c;
    protected final BoxView d;
    protected final DkWebListView e;
    protected int f = -1;
    protected int g = -1;
    private final ArrayList i = new ArrayList();
    private aa j = null;
    private boolean k = false;
    private boolean l = false;

    public yb(y yVar, yh yhVar) {
        super(yVar, g.reading__search_text_view);
        this.b = yhVar;
        this.a.a((w) this);
        this.c = (EditText) findViewById(f.reading__search_text_view__input);
        this.c.addTextChangedListener(new yc(this));
        this.d = (BoxView) findViewById(f.reading__search_text_view__result_box);
        this.e = (DkWebListView) findViewById(f.reading__search_text_view__result_list);
        this.e.setPullDownRefreshEnabled(false);
        this.e.setBackgroundColor(0);
        this.e.setAdapter(new yi());
        this.e.setBackgroundDrawable(new yd(this));
        this.e.setOnItemClickListener(new ye(this));
        this.e.setOnScrollListener(new yf(this));
        getContentView().setLayoutParams(new LayoutParams(dv.b(getContext(), 320.0f), -2));
    }

    public void a() {
        j.a(new yg(this));
    }

    public void a(String str) {
        this.c.getText().clear();
        this.c.getText().append(str);
    }

    public boolean b() {
        if (this.l) {
            return true;
        }
        if (!this.k) {
            return false;
        }
        if (h || this.j != null) {
            this.j = ((sh) getContext().queryFeature(sh.class)).getDocument().a(this.j, 5);
            this.l = true;
            return true;
        }
        throw new AssertionError();
    }

    public z a(int i) {
        if (i < 0 || i >= this.i.size()) {
            return null;
        }
        return (z) this.i.get(i);
    }

    public void a(n nVar) {
    }

    public void b(n nVar) {
    }

    public void c(n nVar) {
    }

    public void d(n nVar) {
    }

    public void e(n nVar) {
    }

    public void f(n nVar) {
    }

    public void a(n nVar, aa aaVar) {
        boolean z = false;
        if (this.j == aaVar) {
            this.l = false;
            Collections.addAll(this.i, this.j.b);
            if (this.j.b.length >= 5) {
                z = true;
            }
            this.k = z;
            c();
        }
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
        this.e.setRowDivider(new dk(this.g));
        c();
    }

    private final void b(String str) {
        Object trim = str.trim();
        if (this.j != null) {
            this.j.a();
            this.j = null;
        }
        this.i.clear();
        this.l = false;
        this.k = false;
        if (!TextUtils.isEmpty(trim)) {
            this.j = this.a.a(null, trim, 5);
            this.l = true;
            this.k = true;
        }
    }

    protected void c() {
        if (this.l) {
            this.e.getAdapter().d();
        } else {
            this.e.getAdapter().a(this.k);
        }
        if (this.j == null) {
            this.d.setVisibility(8);
        } else {
            this.d.setVisibility(0);
        }
        this.e.requestLayout();
    }
}
