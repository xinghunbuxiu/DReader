package com.duokan.reader.ui.personal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.reader.domain.bookshelf.BookState;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.cloud.DkCloudStoreBook;
import java.util.List;

class ll extends kq {
    /* renamed from: h */
    final /* synthetic */ lc f8888h;

    ll(lc lcVar, Context context) {
        this.f8888h = lcVar;
        super(context);
    }

    /* renamed from: e */
    protected void mo1557e(int i) {
        this.f8888h.m12157a((kq) this, false);
    }

    /* renamed from: b */
    protected void mo1555b() {
    }

    /* renamed from: e */
    protected boolean mo1712e() {
        this.f8888h.m12148b((kq) this);
        this.f8888h.m12157a((kq) this, true);
        return true;
    }

    /* renamed from: h */
    public void mo1949h() {
        int k = mo1867k();
        if (mo1954p()) {
            k -= mo1960w();
        }
        for (int i = 0; i < k; i++) {
            if (mo1946g(i)) {
                boolean z;
                if (i == k - 1) {
                    z = true;
                } else {
                    z = false;
                }
                m9778a(i, true, z);
            }
        }
    }

    /* renamed from: i */
    protected DkCloudStoreBook mo1951i(int i) {
        return (DkCloudStoreBook) this.c.get(i);
    }

    /* renamed from: u */
    protected int mo1958u() {
        return this.c.size();
    }

    /* renamed from: t */
    protected int mo1957t() {
        return this.d.size();
    }

    /* renamed from: j */
    protected DkCloudStoreBook mo1952j(int i) {
        return (DkCloudStoreBook) this.d.get(i);
    }

    /* renamed from: g */
    protected View mo1945g(int i, View view, ViewGroup viewGroup) {
        int i2 = mo1958u() > 0 ? 1 : 0;
        View a = this.f8888h.f8859m.m12091a(mo1952j(i), view, viewGroup, this.f8888h.getNormalAdapter(), i2, i);
        a.setOnClickListener(new lm(this, i2, i));
        a.setOnLongClickListener(new ln(this, i2, i));
        return a;
    }

    /* renamed from: f */
    protected View mo1944f(int i, View view, ViewGroup viewGroup) {
        View a = this.f8888h.f8859m.m12091a(mo1951i(i), view, viewGroup, this.f8888h.getNormalAdapter(), 0, i);
        a.setOnClickListener(new lo(this, i));
        a.setOnLongClickListener(new lp(this, i));
        return a;
    }

    /* renamed from: x */
    protected boolean mo1961x() {
        for (DkCloudStoreBook bookUuid : this.c) {
            C0800c b = ai.m3980a().m3906b(bookUuid.getBookUuid());
            if (b != null) {
                if (b.m4233i() != BookState.UPDATING) {
                }
            }
            return false;
        }
        return true;
    }

    /* renamed from: h */
    protected Object mo1948h(int i) {
        return this.e.mo1873a(i);
    }

    /* renamed from: k */
    protected int mo1953k(int i) {
        return this.e.mo1876b(i);
    }

    /* renamed from: w */
    protected int mo1960w() {
        return this.e.mo1871a();
    }

    /* renamed from: v */
    protected int mo1959v() {
        return this.e.mo1875b();
    }

    /* renamed from: h */
    protected View mo1947h(int i, View view, ViewGroup viewGroup) {
        return this.e.mo1872a(i, view, viewGroup);
    }

    /* renamed from: i */
    protected View mo1950i(int i, View view, ViewGroup viewGroup) {
        View b = this.e.mo1877b(i, view, viewGroup);
        if (b != null) {
            if (mo1958u() > 0 || mo1957t() > 0) {
                b.findViewById(C0255g.bookshelf__purchased_category_title_view__top_line).setVisibility(0);
            } else {
                b.findViewById(C0255g.bookshelf__purchased_category_title_view__top_line).setVisibility(4);
            }
        }
        return b;
    }

    /* renamed from: p */
    protected boolean mo1954p() {
        return this.f8888h.f8860n != null && this.f8888h.f8860n.mo1942a() == 2;
    }

    /* renamed from: a */
    public View mo482a(View view, ViewGroup viewGroup) {
        return LayoutInflater.from(m12080o()).inflate(C0256h.bookshelf__shared__empty_view, viewGroup, false);
    }

    /* renamed from: g */
    protected boolean mo1946g(int i) {
        return true;
    }

    /* renamed from: r */
    protected List<DkCloudStoreBook> mo1955r() {
        return this.a;
    }

    /* renamed from: s */
    protected List<DkCloudStoreBook> mo1956s() {
        return this.c;
    }
}
