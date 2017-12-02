package com.duokan.reader.ui.personal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.duokan.c.g;
import com.duokan.reader.domain.bookshelf.BookState;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.cloud.DkCloudStoreBook;

import java.util.List;

class kx extends kc {
    final /* synthetic */ ko h;

    kx(ko koVar, Context context) {
        this.h = koVar;
        super(context);
    }

    protected void e(int i) {
        this.h.a((kc) this, false);
    }

    protected void b() {
    }

    protected boolean e() {
        this.h.b((kc) this);
        this.h.a((kc) this, true);
        return true;
    }

    public void h() {
        int k = k();
        if (p()) {
            k -= w();
        }
        for (int i = 0; i < k; i++) {
            if (g(i)) {
                boolean z;
                if (i == k - 1) {
                    z = true;
                } else {
                    z = false;
                }
                a(i, true, z);
            }
        }
    }

    protected DkCloudStoreBook i(int i) {
        return (DkCloudStoreBook) this.c.get(i);
    }

    protected int u() {
        return this.c.size();
    }

    protected int t() {
        return this.d.size();
    }

    protected DkCloudStoreBook j(int i) {
        return (DkCloudStoreBook) this.d.get(i);
    }

    protected View g(int i, View view, ViewGroup viewGroup) {
        int i2 = u() > 0 ? 1 : 0;
        View a = this.h.l.a(j(i), view, viewGroup, this.h.getNormalAdapter(), i2, i);
        a.setOnClickListener(new ky(this, i2, i));
        a.setOnLongClickListener(new kz(this, i2, i));
        return a;
    }

    protected View f(int i, View view, ViewGroup viewGroup) {
        View a = this.h.l.a(i(i), view, viewGroup, this.h.getNormalAdapter(), 0, i);
        a.setOnClickListener(new la(this, i));
        a.setOnLongClickListener(new lb(this, i));
        return a;
    }

    protected boolean x() {
        for (DkCloudStoreBook bookUuid : this.c) {
            c b = ai.a().b(bookUuid.getBookUuid());
            if (b != null) {
                if (b.i() != BookState.UPDATING) {
                }
            }
            return false;
        }
        return true;
    }

    protected Object h(int i) {
        return this.e.a(i);
    }

    protected int k(int i) {
        return this.e.b(i);
    }

    protected int w() {
        return this.e.a();
    }

    protected int v() {
        return this.e.b();
    }

    protected View h(int i, View view, ViewGroup viewGroup) {
        return this.e.a(i, view, viewGroup);
    }

    protected View i(int i, View view, ViewGroup viewGroup) {
        View b = this.e.b(i, view, viewGroup);
        if (b != null) {
            if (u() > 0 || t() > 0) {
                b.findViewById(g.bookshelf__purchased_category_title_view__top_line).setVisibility(0);
            } else {
                b.findViewById(g.bookshelf__purchased_category_title_view__top_line).setVisibility(4);
            }
        }
        return b;
    }

    protected boolean p() {
        return this.h.m != null && this.h.m.a() == 2;
    }

    public View a(View view, ViewGroup viewGroup) {
        return LayoutInflater.from(o()).inflate(h.bookshelf__shared__empty_view, viewGroup, false);
    }

    protected boolean g(int i) {
        return true;
    }

    protected List r() {
        return this.a;
    }

    protected List s() {
        return this.c;
    }
}
