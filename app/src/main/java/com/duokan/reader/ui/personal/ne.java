package com.duokan.reader.ui.personal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.duokan.p023b.C0245g;
import com.duokan.reader.domain.cloud.DkCloudStoreBook;
import com.duokan.reader.ui.bookshelf.hd;
import com.duokan.reader.ui.bookshelf.hv;
import java.util.ArrayList;
import java.util.List;

public class ne extends hd {
    /* renamed from: a */
    private final Context f8866a;
    /* renamed from: c */
    private final hv f8867c;
    /* renamed from: d */
    private final ks f8868d;
    /* renamed from: e */
    private List<DkCloudStoreBook> f8869e = new ArrayList();
    /* renamed from: f */
    private String f8870f;

    public ne(Context context, hv hvVar) {
        this.f8866a = context;
        this.f8867c = hvVar;
        this.f8868d = new ks(this.f8866a);
    }

    /* renamed from: a */
    public void m12170a(List<DkCloudStoreBook> list, String str) {
        if (list != this.f8869e) {
            this.f8869e.clear();
        }
        this.f8869e = list;
        this.f8870f = str;
        m8785a(false);
    }

    /* renamed from: a */
    public void m12169a(List<DkCloudStoreBook> list) {
        this.f8869e.removeAll(list);
        m8785a(false);
    }

    /* renamed from: k */
    protected int mo1867k() {
        return 1;
    }

    /* renamed from: f */
    protected int mo1866f(int i) {
        return mo506c();
    }

    /* renamed from: c */
    public int mo506c() {
        return this.f8869e.size();
    }

    /* renamed from: d */
    public Object mo509d(int i) {
        return this.f8869e.get(i);
    }

    /* renamed from: d */
    public View mo508d(int i, View view, ViewGroup viewGroup) {
        View a = this.f8868d.m12092a((DkCloudStoreBook) mo509d(i), view, viewGroup, this, 0, i, this.f8870f);
        a.setOnClickListener(new nf(this, i));
        a.setOnLongClickListener(new ng(this, i));
        return a;
    }

    /* renamed from: a */
    public View mo482a(View view, ViewGroup viewGroup) {
        return LayoutInflater.from(this.f8866a).inflate(C0245g.personal__search_empty_view, viewGroup, false);
    }

    /* renamed from: b */
    protected void mo1555b() {
        this.f8869e.clear();
    }

    /* renamed from: e */
    protected void mo1557e(int i) {
    }
}
