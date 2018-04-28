package com.duokan.reader.ui.personal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.reader.domain.cloud.C0840a;
import com.duokan.reader.domain.cloud.DkCloudStoreBook;
import java.util.ArrayList;
import java.util.List;

class me extends kq {
    /* renamed from: h */
    static final /* synthetic */ boolean f8929h = (!mc.class.desiredAssertionStatus());
    /* renamed from: i */
    final /* synthetic */ mc f8930i;
    /* renamed from: j */
    private C0840a f8931j;

    public me(mc mcVar, Context context) {
        this.f8930i = mcVar;
        super(context);
    }

    /* renamed from: a */
    public void m12257a(C0840a c0840a) {
        this.f8931j = c0840a;
        mo1963y();
        m8785a(false);
    }

    /* renamed from: y */
    public void mo1963y() {
        int i = 0;
        if (this.f8931j != null) {
            List arrayList = new ArrayList();
            if (this.f8931j.m5261b() < 1) {
                while (i < this.f8931j.m5266d()) {
                    arrayList.add((DkCloudStoreBook) this.f8931j.m5262b(i));
                    i++;
                }
            } else {
                for (C0840a c0840a : this.f8931j.m5265c()) {
                    for (int i2 = 0; i2 < c0840a.m5266d(); i2++) {
                        arrayList.add((DkCloudStoreBook) c0840a.m5262b(i2));
                    }
                }
            }
            this.f8930i.f8927n = arrayList;
        }
    }

    /* renamed from: e */
    protected void mo1557e(int i) {
    }

    /* renamed from: b */
    protected void mo1555b() {
    }

    /* renamed from: i */
    protected DkCloudStoreBook mo1951i(int i) {
        if (f8929h) {
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: u */
    protected int mo1958u() {
        return 0;
    }

    /* renamed from: x */
    protected boolean mo1961x() {
        return false;
    }

    /* renamed from: f */
    protected View mo1944f(int i, View view, ViewGroup viewGroup) {
        if (f8929h) {
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: h */
    protected Object mo1948h(int i) {
        return this.f8930i.f8927n.get(i);
    }

    /* renamed from: k */
    protected int mo1953k(int i) {
        return this.f8931j == null ? 0 : this.f8931j.m5256a(i).m5266d();
    }

    /* renamed from: w */
    protected int mo1960w() {
        return this.f8931j == null ? 0 : this.f8931j.m5261b();
    }

    /* renamed from: v */
    protected int mo1959v() {
        return this.f8930i.f8927n.size();
    }

    /* renamed from: h */
    protected View mo1947h(int i, View view, ViewGroup viewGroup) {
        int i2;
        DkCloudStoreBook dkCloudStoreBook = (DkCloudStoreBook) this.f8930i.f8927n.get(i);
        int i3 = i;
        for (int i4 = 0; i4 < mo1960w(); i4++) {
            int k = mo1953k(i4);
            if (i3 >= 0 && i3 < k) {
                i2 = i4;
                break;
            }
            i3 -= k;
        }
        i2 = 0;
        View a = this.f8930i.f8926m.m12091a(dkCloudStoreBook, view, viewGroup, this, i2, i3);
        a.setOnClickListener(new mf(this, i2, i3, dkCloudStoreBook));
        a.setOnLongClickListener(new mg(this, i2, i3));
        return a;
    }

    /* renamed from: b */
    protected View mo1962b(View view, ViewGroup viewGroup) {
        if (f8929h) {
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: i */
    protected View mo1950i(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(m12080o()).inflate(C0256h.bookshelf__purchased_second_category_group_title_view, viewGroup, false);
        }
        if (i == 0) {
            view.findViewById(C0255g.f411x554e3102).setVisibility(4);
        } else {
            view.findViewById(C0255g.f411x554e3102).setVisibility(0);
        }
        ((TextView) view.findViewById(C0255g.bookshelf__purchased_second_category_group_title_view__title)).setText(this.f8931j.m5256a(i).m5258a());
        return view;
    }

    /* renamed from: r */
    public List<DkCloudStoreBook> mo1955r() {
        return null;
    }

    /* renamed from: s */
    protected List<DkCloudStoreBook> mo1956s() {
        return null;
    }

    /* renamed from: a */
    public View mo482a(View view, ViewGroup viewGroup) {
        return LayoutInflater.from(m12080o()).inflate(C0256h.bookshelf__shared__empty_view, viewGroup, false);
    }

    /* renamed from: g */
    protected boolean mo1946g(int i) {
        return true;
    }

    /* renamed from: t */
    protected int mo1957t() {
        return 0;
    }

    /* renamed from: j */
    protected DkCloudStoreBook mo1952j(int i) {
        if (f8929h) {
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: g */
    protected View mo1945g(int i, View view, ViewGroup viewGroup) {
        if (f8929h) {
            return null;
        }
        throw new AssertionError();
    }
}
