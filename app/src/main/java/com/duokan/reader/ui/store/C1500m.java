package com.duokan.reader.ui.store;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.duokan.p024c.C0254f;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.reader.common.webservices.duokan.C0646t;
import com.duokan.reader.ui.general.bo;
import com.duokan.reader.ui.general.deprecatedDkTextView;

/* renamed from: com.duokan.reader.ui.store.m */
class C1500m extends bo {
    /* renamed from: a */
    final /* synthetic */ C1497j f11454a;
    /* renamed from: c */
    final /* synthetic */ C1499l f11455c;

    C1500m(C1499l c1499l, C1497j c1497j) {
        this.f11455c = c1499l;
        this.f11454a = c1497j;
    }

    /* renamed from: c */
    public int mo506c() {
        return this.f11455c.f11450a.f11447b.size();
    }

    /* renamed from: d */
    public Object mo509d(int i) {
        return this.f11455c.f11450a.f11447b.get(i);
    }

    /* renamed from: d */
    public View mo508d(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f11455c.getContext()).inflate(C0256h.store__change_log_item_view, viewGroup, false);
        }
        C0646t c0646t = (C0646t) mo509d(i);
        ImageView imageView = (ImageView) view.findViewById(C0255g.store__change_log_item_view__time_line);
        if (i == 0) {
            imageView.setImageDrawable(this.f11455c.getResources().getDrawable(C0254f.store__change_log_view__icon1));
        } else {
            imageView.setImageDrawable(this.f11455c.getResources().getDrawable(C0254f.store__change_log_view__icon2));
        }
        ((TextView) view.findViewById(C0255g.store__change_log_item_view__time)).setText(c0646t.f2176b.split(" ")[0]);
        ((deprecatedDkTextView) view.findViewById(C0255g.store__change_log_item_view__detail)).setText(c0646t.f2177c);
        return view;
    }

    /* renamed from: b */
    protected void mo1555b() {
        this.f11455c.f11450a.f11447b.clear();
    }

    /* renamed from: e */
    protected void mo1557e(int i) {
        this.f11455c.f11450a.m15397a(this.f11455c.f11450a.f11447b.size());
    }
}
