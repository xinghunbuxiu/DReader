package com.duokan.reader.ui.personal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.duokan.c.g;
import com.duokan.reader.domain.cloud.DkCloudStoreBook;
import com.duokan.reader.domain.cloud.a;

import java.util.ArrayList;
import java.util.List;

class lq extends kc {
    static final /* synthetic */ boolean h = (!lo.class.desiredAssertionStatus());
    final /* synthetic */ lo i;
    private a j;

    public lq(lo loVar, Context context) {
        this.i = loVar;
        super(context);
    }

    public void a(a aVar) {
        this.j = aVar;
        y();
        a(false);
    }

    public void y() {
        int i = 0;
        if (this.j != null) {
            List arrayList = new ArrayList();
            if (this.j.b() < 1) {
                while (i < this.j.d()) {
                    arrayList.add((DkCloudStoreBook) this.j.b(i));
                    i++;
                }
            } else {
                for (a aVar : this.j.c()) {
                    for (int i2 = 0; i2 < aVar.d(); i2++) {
                        arrayList.add((DkCloudStoreBook) aVar.b(i2));
                    }
                }
            }
            this.i.m = arrayList;
        }
    }

    protected void e(int i) {
    }

    protected void b() {
    }

    protected DkCloudStoreBook i(int i) {
        if (h) {
            return null;
        }
        throw new AssertionError();
    }

    protected int u() {
        return 0;
    }

    protected boolean x() {
        return false;
    }

    protected View f(int i, View view, ViewGroup viewGroup) {
        if (h) {
            return null;
        }
        throw new AssertionError();
    }

    protected Object h(int i) {
        return this.i.m.get(i);
    }

    protected int k(int i) {
        return this.j == null ? 0 : this.j.a(i).d();
    }

    protected int w() {
        return this.j == null ? 0 : this.j.b();
    }

    protected int v() {
        return this.i.m.size();
    }

    protected View h(int i, View view, ViewGroup viewGroup) {
        int i2;
        DkCloudStoreBook dkCloudStoreBook = (DkCloudStoreBook) this.i.m.get(i);
        int i3 = i;
        for (int i4 = 0; i4 < w(); i4++) {
            int k = k(i4);
            if (i3 >= 0 && i3 < k) {
                i2 = i4;
                break;
            }
            i3 -= k;
        }
        i2 = 0;
        View a = this.i.l.a(dkCloudStoreBook, view, viewGroup, this, i2, i3);
        a.setOnClickListener(new lr(this, i2, i3, dkCloudStoreBook));
        a.setOnLongClickListener(new ls(this, i2, i3));
        return a;
    }

    protected View b(View view, ViewGroup viewGroup) {
        if (h) {
            return null;
        }
        throw new AssertionError();
    }

    protected View i(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(o()).inflate(h.bookshelf__purchased_second_category_group_title_view, viewGroup, false);
        }
        if (i == 0) {
            view.findViewById(g.bookshelf__purchased_second_category_group_title_view__first_line).setVisibility(4);
        } else {
            view.findViewById(g.bookshelf__purchased_second_category_group_title_view__first_line).setVisibility(0);
        }
        ((TextView) view.findViewById(g.bookshelf__purchased_second_category_group_title_view__title)).setText(this.j.a(i).a());
        return view;
    }

    public List r() {
        return null;
    }

    protected List s() {
        return null;
    }

    public View a(View view, ViewGroup viewGroup) {
        return LayoutInflater.from(o()).inflate(h.bookshelf__shared__empty_view, viewGroup, false);
    }

    protected boolean g(int i) {
        return true;
    }

    protected int t() {
        return 0;
    }

    protected DkCloudStoreBook j(int i) {
        if (h) {
            return null;
        }
        throw new AssertionError();
    }

    protected View g(int i, View view, ViewGroup viewGroup) {
        if (h) {
            return null;
        }
        throw new AssertionError();
    }
}
