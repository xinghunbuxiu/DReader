package com.duokan.reader.ui.personal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.duokan.core.app.AppContext;
import com.duokan.p023b.C0244f;
import com.duokan.p023b.C0245g;
import com.duokan.p023b.C0247i;
import com.duokan.reader.domain.cloud.DkCloudStoreBook;
import com.duokan.reader.ui.bookshelf.hd;
import java.util.ArrayList;
import java.util.List;

public abstract class kq extends hd {
    /* renamed from: a */
    public List<DkCloudStoreBook> f8822a = new ArrayList();
    /* renamed from: c */
    public List<DkCloudStoreBook> f8823c = new ArrayList();
    /* renamed from: d */
    public List<DkCloudStoreBook> f8824d = new ArrayList();
    /* renamed from: e */
    protected kt f8825e;
    /* renamed from: f */
    public boolean f8826f = false;
    /* renamed from: g */
    public boolean f8827g = false;
    /* renamed from: h */
    private Context f8828h;
    /* renamed from: i */
    private final lb f8829i;
    /* renamed from: j */
    private boolean f8830j = false;

    /* renamed from: f */
    protected abstract View mo1944f(int i, View view, ViewGroup viewGroup);

    /* renamed from: g */
    protected abstract View mo1945g(int i, View view, ViewGroup viewGroup);

    /* renamed from: h */
    protected abstract View mo1947h(int i, View view, ViewGroup viewGroup);

    /* renamed from: h */
    protected abstract Object mo1948h(int i);

    /* renamed from: i */
    protected abstract View mo1950i(int i, View view, ViewGroup viewGroup);

    /* renamed from: i */
    protected abstract DkCloudStoreBook mo1951i(int i);

    /* renamed from: j */
    protected abstract DkCloudStoreBook mo1952j(int i);

    /* renamed from: k */
    protected abstract int mo1953k(int i);

    /* renamed from: r */
    protected abstract List<DkCloudStoreBook> mo1955r();

    /* renamed from: s */
    protected abstract List<DkCloudStoreBook> mo1956s();

    /* renamed from: t */
    protected abstract int mo1957t();

    /* renamed from: u */
    protected abstract int mo1958u();

    /* renamed from: v */
    protected abstract int mo1959v();

    /* renamed from: w */
    protected abstract int mo1960w();

    /* renamed from: x */
    protected abstract boolean mo1961x();

    public kq(Context context) {
        this.f8828h = context;
        this.f8829i = (lb) AppContext.getAppContext(this.f8828h).queryFeature(lb.class);
    }

    /* renamed from: a */
    public int mo486a() {
        int i;
        int i2 = 1;
        int w = mo1960w();
        if (mo1963y()) {
            i = 1;
        } else {
            i = 0;
        }
        i += w;
        if (!m12060z()) {
            i2 = 0;
        }
        return i + i2;
    }

    /* renamed from: c */
    public int mo506c() {
        return (mo1959v() + mo1958u()) + mo1957t();
    }

    /* renamed from: a */
    public int mo487a(int i) {
        if (mo1963y() && m12060z()) {
            if (i == 0) {
                return mo1958u();
            }
            if (i == 1) {
                return mo1957t();
            }
            return mo1953k(i - 2);
        } else if (mo1963y()) {
            return i == 0 ? mo1958u() : mo1953k(i - 1);
        } else {
            if (m12060z()) {
                return i == 0 ? mo1957t() : mo1953k(i - 1);
            } else {
                return mo1953k(i);
            }
        }
    }

    /* renamed from: d */
    public Object mo509d(int i) {
        if (mo1963y() && m12060z()) {
            if (i < mo1958u()) {
                return mo1951i(i);
            }
            if (i < mo1958u() + mo1957t()) {
                return mo1952j(i - mo1958u());
            }
            return mo1948h((i - mo1958u()) - mo1957t());
        } else if (mo1963y()) {
            return i < mo1958u() ? mo1951i(i) : mo1948h(i - mo1958u());
        } else {
            if (m12060z()) {
                return i < mo1957t() ? mo1952j(i) : mo1948h(i - mo1957t());
            } else {
                return mo1948h(i);
            }
        }
    }

    /* renamed from: a */
    public View mo488a(int i, View view, ViewGroup viewGroup) {
        if (mo1963y() && m12060z()) {
            if (i == 0) {
                return mo1962b(view, viewGroup);
            }
            if (i == 1) {
                return m12070e(i, view, viewGroup);
            }
            return mo1950i(i - 2, view, viewGroup);
        } else if (mo1963y()) {
            return i == 0 ? mo1962b(view, viewGroup) : mo1950i(i - 1, view, viewGroup);
        } else {
            if (m12060z()) {
                return i == 0 ? m12070e(i, view, viewGroup) : mo1950i(i - 1, view, viewGroup);
            } else {
                return mo1950i(i, view, viewGroup);
            }
        }
    }

    /* renamed from: d */
    public View mo508d(int i, View view, ViewGroup viewGroup) {
        if (mo1963y() && m12060z()) {
            if (i < mo1958u()) {
                return mo1944f(i, view, viewGroup);
            }
            if (i < mo1958u() + mo1957t()) {
                return mo1945g(i - mo1958u(), view, viewGroup);
            }
            return mo1947h((i - mo1958u()) - mo1957t(), view, viewGroup);
        } else if (mo1963y()) {
            return i < mo1958u() ? mo1944f(i, view, viewGroup) : mo1947h(i - mo1958u(), view, viewGroup);
        } else {
            if (m12060z()) {
                return i < mo1957t() ? mo1945g(i, view, viewGroup) : mo1947h(i - mo1957t(), view, viewGroup);
            } else {
                return mo1947h(i, view, viewGroup);
            }
        }
    }

    /* renamed from: n */
    public boolean m12079n() {
        return this.f8830j;
    }

    /* renamed from: b */
    public void mo1755b(boolean z) {
        this.f8830j = z;
    }

    /* renamed from: b */
    protected View mo1962b(View view, ViewGroup viewGroup) {
        boolean z;
        if (view == null || view.findViewById(C0244f.bookshelf__update_book_group_title_view__upgrade_all) == null) {
            view = LayoutInflater.from(m12080o()).inflate(C0245g.bookshelf__update_book_group_title_view, viewGroup, false);
        }
        ((TextView) view.findViewById(C0244f.bookshelf__update_book_group_title_view__count)).setText(String.format(m12080o().getString(C0247i.bookshelf__shared__update_book_count), new Object[]{Integer.valueOf(mo1958u())}));
        View findViewById = view.findViewById(C0244f.bookshelf__update_book_group_title_view__upgrade_all);
        findViewById.setOnClickListener(new kr(this));
        boolean x = mo1961x();
        if (x) {
            z = false;
        } else {
            z = true;
        }
        findViewById.setEnabled(z);
        findViewById.setSelected(x);
        return view;
    }

    /* renamed from: e */
    protected View m12070e(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.findViewById(C0244f.bookshelf__gift_book_group_title_view__text) == null) {
            view = LayoutInflater.from(m12080o()).inflate(C0245g.bookshelf__gift_book_group_title_view, viewGroup, false);
        }
        ((TextView) view.findViewById(C0244f.bookshelf__gift_book_group_title_view__text)).setText(String.format(m12080o().getString(C0247i.bookshelf__shared__gift_book_count), new Object[]{Integer.valueOf(mo1957t())}));
        view.findViewById(C0244f.bookshelf__gift_book_group_title_view__top_line).setVisibility(mo1963y() ? 0 : 4);
        return view;
    }

    /* renamed from: o */
    protected Context m12080o() {
        return this.f8828h;
    }

    /* renamed from: y */
    private boolean mo1963y() {
        return mo1958u() > 0;
    }

    /* renamed from: z */
    private boolean m12060z() {
        return mo1957t() > 0;
    }

    /* renamed from: p */
    protected boolean mo1954p() {
        return false;
    }

    /* renamed from: a */
    public void m12064a(kt ktVar) {
        this.f8825e = ktVar;
    }

    /* renamed from: q */
    public kt m12082q() {
        return this.f8825e;
    }
}
