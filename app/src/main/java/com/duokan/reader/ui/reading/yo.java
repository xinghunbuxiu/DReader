package com.duokan.reader.ui.reading;

import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.sys.UIdleHandler;
import com.duokan.core.ui.BoxView;
import com.duokan.core.ui.dv;
import com.duokan.p023b.C0244f;
import com.duokan.p023b.C0245g;
import com.duokan.reader.domain.document.C0808w;
import com.duokan.reader.domain.document.C0903n;
import com.duokan.reader.domain.document.C1013z;
import com.duokan.reader.domain.document.aa;
import com.duokan.reader.ui.general.DkWebListView;
import com.duokan.reader.ui.general.dk;
import java.util.ArrayList;
import java.util.Collections;

abstract class yo extends ActivatedController implements C0808w {
    /* renamed from: h */
    static final /* synthetic */ boolean f11200h = (!yo.class.desiredAssertionStatus());
    /* renamed from: a */
    protected final C0903n f11201a = ((su) getContext().queryFeature(su.class)).getDocument();
    /* renamed from: b */
    protected final yu f11202b;
    /* renamed from: c */
    protected final EditText f11203c;
    /* renamed from: d */
    protected final BoxView f11204d;
    /* renamed from: e */
    protected final DkWebListView f11205e;
    /* renamed from: f */
    protected int f11206f = -1;
    /* renamed from: g */
    protected int f11207g = -1;
    /* renamed from: i */
    private final ArrayList<C1013z> f11208i = new ArrayList();
    /* renamed from: j */
    private aa f11209j = null;
    /* renamed from: k */
    private boolean f11210k = false;
    /* renamed from: l */
    private boolean f11211l = false;

    public yo(IFeature mFeature, yu yuVar) {
        super(mFeature, C0245g.reading__search_text_view);
        this.f11202b = yuVar;
        this.f11201a.m5910a((C0808w) this);
        this.f11203c = (EditText) findViewById(C0244f.reading__search_text_view__input);
        this.f11203c.addTextChangedListener(new yp(this));
        this.f11204d = (BoxView) findViewById(C0244f.reading__search_text_view__result_box);
        this.f11205e = (DkWebListView) findViewById(C0244f.reading__search_text_view__result_list);
        this.f11205e.setPullDownRefreshEnabled(false);
        this.f11205e.setBackgroundColor(0);
        this.f11205e.setAdapter(new yv());
        this.f11205e.setBackgroundDrawable(new yq(this));
        this.f11205e.setOnItemClickListener(new yr(this));
        this.f11205e.setOnScrollListener(new ys(this));
        getContentView().setLayoutParams(new LayoutParams(dv.m1932b(getContext(), 320.0f), -2));
    }

    /* renamed from: a */
    public void m15179a() {
        UIdleHandler.addIdleHandler(new yt(this));
    }

    /* renamed from: a */
    public void m15182a(String str) {
        this.f11203c.getText().clear();
        this.f11203c.getText().append(str);
    }

    /* renamed from: b */
    public boolean m15184b() {
        if (this.f11211l) {
            return true;
        }
        if (!this.f11210k) {
            return false;
        }
        if (f11200h || this.f11209j != null) {
            this.f11209j = ((su) getContext().queryFeature(su.class)).getDocument().mo1211a(this.f11209j, 5);
            this.f11211l = true;
            return true;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public C1013z m15178a(int i) {
        if (i < 0 || i >= this.f11208i.size()) {
            return null;
        }
        return (C1013z) this.f11208i.get(i);
    }

    /* renamed from: a */
    public void mo1049a(C0903n c0903n) {
    }

    /* renamed from: b */
    public void mo1051b(C0903n c0903n) {
    }

    /* renamed from: c */
    public void mo1052c(C0903n c0903n) {
    }

    /* renamed from: d */
    public void mo1053d(C0903n c0903n) {
    }

    /* renamed from: e */
    public void mo1054e(C0903n c0903n) {
    }

    /* renamed from: f */
    public void mo1055f(C0903n c0903n) {
    }

    /* renamed from: a */
    public void mo1050a(C0903n c0903n, aa aaVar) {
        boolean z = false;
        if (this.f11209j == aaVar) {
            this.f11211l = false;
            Collections.addAll(this.f11208i, this.f11209j.f4315b);
            if (this.f11209j.f4315b.length >= 5) {
                z = true;
            }
            this.f11210k = z;
            m15185c();
        }
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
        this.f11205e.setRowDivider(new dk(this.f11207g));
        m15185c();
    }

    /* renamed from: b */
    private final void m15174b(String str) {
        Object trim = str.trim();
        if (this.f11209j != null) {
            this.f11209j.m6066a();
            this.f11209j = null;
        }
        this.f11208i.clear();
        this.f11211l = false;
        this.f11210k = false;
        if (!TextUtils.isEmpty(trim)) {
            this.f11209j = this.f11201a.mo1212a(null, trim, 5);
            this.f11211l = true;
            this.f11210k = true;
        }
    }

    /* renamed from: c */
    protected void m15185c() {
        if (this.f11211l) {
            this.f11205e.getAdapter().mo1691d();
        } else {
            this.f11205e.getAdapter().m8785a(this.f11210k);
        }
        if (this.f11209j == null) {
            this.f11204d.setVisibility(8);
        } else {
            this.f11204d.setVisibility(0);
        }
        this.f11205e.requestLayout();
    }
}
