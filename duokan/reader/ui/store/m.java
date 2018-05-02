package com.duokan.reader.ui.store;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.duokan.c.f;
import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.reader.common.webservices.duokan.u;
import com.duokan.reader.ui.general.bo;
import com.duokan.reader.ui.general.deprecatedDkTextView;

class m extends bo {
    final /* synthetic */ j a;
    final /* synthetic */ l c;

    m(l lVar, j jVar) {
        this.c = lVar;
        this.a = jVar;
    }

    public int c() {
        return this.c.a.b.size();
    }

    public Object d(int i) {
        return this.c.a.b.get(i);
    }

    public View d(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.c.getContext()).inflate(h.store__change_log_item_view, viewGroup, false);
        }
        u uVar = (u) d(i);
        ImageView imageView = (ImageView) view.findViewById(g.store__change_log_item_view__time_line);
        if (i == 0) {
            imageView.setImageDrawable(this.c.getResources().getDrawable(f.store__change_log_view__icon1));
        } else {
            imageView.setImageDrawable(this.c.getResources().getDrawable(f.store__change_log_view__icon2));
        }
        ((TextView) view.findViewById(g.store__change_log_item_view__time)).setText(uVar.b.split(" ")[0]);
        ((deprecatedDkTextView) view.findViewById(g.store__change_log_item_view__detail)).setText(uVar.c);
        return view;
    }

    protected void b() {
        this.c.a.b.clear();
    }

    protected void e(int i) {
        this.c.a.a(this.c.a.b.size());
    }
}
