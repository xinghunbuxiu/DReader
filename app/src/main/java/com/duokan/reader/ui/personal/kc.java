package com.duokan.reader.ui.personal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.duokan.core.app.x;
import com.duokan.reader.domain.cloud.DkCloudStoreBook;
import com.duokan.reader.ui.bookshelf.gw;

import java.util.ArrayList;
import java.util.List;

public abstract class kc extends gw {
    public List a = new ArrayList();
    public List c = new ArrayList();
    public List d = new ArrayList();
    protected kf e;
    public boolean f = false;
    public boolean g = false;
    private Context h;
    private final kn i;
    private boolean j = false;

    protected abstract View f(int i, View view, ViewGroup viewGroup);

    protected abstract View g(int i, View view, ViewGroup viewGroup);

    protected abstract View h(int i, View view, ViewGroup viewGroup);

    protected abstract Object h(int i);

    protected abstract View i(int i, View view, ViewGroup viewGroup);

    protected abstract DkCloudStoreBook i(int i);

    protected abstract DkCloudStoreBook j(int i);

    protected abstract int k(int i);

    protected abstract List r();

    protected abstract List s();

    protected abstract int t();

    protected abstract int u();

    protected abstract int v();

    protected abstract int w();

    protected abstract boolean x();

    public kc(Context context) {
        this.h = context;
        this.i = (kn) x.a(this.h).queryFeature(kn.class);
    }

    public int a() {
        int i;
        int i2 = 1;
        int w = w();
        if (y()) {
            i = 1;
        } else {
            i = 0;
        }
        i += w;
        if (!z()) {
            i2 = 0;
        }
        return i + i2;
    }

    public int c() {
        return (v() + u()) + t();
    }

    public int a(int i) {
        if (y() && z()) {
            if (i == 0) {
                return u();
            }
            if (i == 1) {
                return t();
            }
            return k(i - 2);
        } else if (y()) {
            return i == 0 ? u() : k(i - 1);
        } else {
            if (z()) {
                return i == 0 ? t() : k(i - 1);
            } else {
                return k(i);
            }
        }
    }

    public Object d(int i) {
        if (y() && z()) {
            if (i < u()) {
                return i(i);
            }
            if (i < u() + t()) {
                return j(i - u());
            }
            return h((i - u()) - t());
        } else if (y()) {
            return i < u() ? i(i) : h(i - u());
        } else {
            if (z()) {
                return i < t() ? j(i) : h(i - t());
            } else {
                return h(i);
            }
        }
    }

    public View a(int i, View view, ViewGroup viewGroup) {
        if (y() && z()) {
            if (i == 0) {
                return b(view, viewGroup);
            }
            if (i == 1) {
                return e(i, view, viewGroup);
            }
            return i(i - 2, view, viewGroup);
        } else if (y()) {
            return i == 0 ? b(view, viewGroup) : i(i - 1, view, viewGroup);
        } else {
            if (z()) {
                return i == 0 ? e(i, view, viewGroup) : i(i - 1, view, viewGroup);
            } else {
                return i(i, view, viewGroup);
            }
        }
    }

    public View d(int i, View view, ViewGroup viewGroup) {
        if (y() && z()) {
            if (i < u()) {
                return f(i, view, viewGroup);
            }
            if (i < u() + t()) {
                return g(i - u(), view, viewGroup);
            }
            return h((i - u()) - t(), view, viewGroup);
        } else if (y()) {
            return i < u() ? f(i, view, viewGroup) : h(i - u(), view, viewGroup);
        } else {
            if (z()) {
                return i < t() ? g(i, view, viewGroup) : h(i - t(), view, viewGroup);
            } else {
                return h(i, view, viewGroup);
            }
        }
    }

    public boolean n() {
        return this.j;
    }

    public void b(boolean z) {
        this.j = z;
    }

    protected View b(View view, ViewGroup viewGroup) {
        boolean z;
        if (view == null || view.findViewById(f.bookshelf__update_book_group_title_view__upgrade_all) == null) {
            view = LayoutInflater.from(o()).inflate(g.bookshelf__update_book_group_title_view, viewGroup, false);
        }
        ((TextView) view.findViewById(f.bookshelf__update_book_group_title_view__count)).setText(String.format(o().getString(i.bookshelf__shared__update_book_count), new Object[]{Integer.valueOf(u())}));
        View findViewById = view.findViewById(f.bookshelf__update_book_group_title_view__upgrade_all);
        findViewById.setOnClickListener(new kd(this));
        boolean x = x();
        if (x) {
            z = false;
        } else {
            z = true;
        }
        findViewById.setEnabled(z);
        findViewById.setSelected(x);
        return view;
    }

    protected View e(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.findViewById(f.bookshelf__gift_book_group_title_view__text) == null) {
            view = LayoutInflater.from(o()).inflate(g.bookshelf__gift_book_group_title_view, viewGroup, false);
        }
        ((TextView) view.findViewById(f.bookshelf__gift_book_group_title_view__text)).setText(String.format(o().getString(i.bookshelf__shared__gift_book_count), new Object[]{Integer.valueOf(t())}));
        view.findViewById(f.bookshelf__gift_book_group_title_view__top_line).setVisibility(y() ? 0 : 4);
        return view;
    }

    protected Context o() {
        return this.h;
    }

    private boolean y() {
        return u() > 0;
    }

    private boolean z() {
        return t() > 0;
    }

    protected boolean p() {
        return false;
    }

    public void a(kf kfVar) {
        this.e = kfVar;
    }

    public kf q() {
        return this.e;
    }
}
