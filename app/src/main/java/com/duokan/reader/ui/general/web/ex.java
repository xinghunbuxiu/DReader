package com.duokan.reader.ui.general.web;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.duokan.c.f;
import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.core.sys.as;

class ex implements as {
    final /* synthetic */ String[] a;
    final /* synthetic */ ew b;

    ex(ew ewVar, String[] strArr) {
        this.b = ewVar;
        this.a = strArr;
    }

    public void a() {
        if (this.b.b.b.mPageHeaderView != null) {
            this.b.b.b.mPageHeaderView.a();
            View inflate = LayoutInflater.from(this.b.b.b.getContext()).inflate(h.store__header_view__right_button_container, this.b.b.b.mPageHeaderView, false);
            ((ImageView) inflate.findViewById(g.store__title_view__right_button)).setImageResource(f.store__shared__more);
            this.b.b.b.mPageHeaderView.a(inflate);
            inflate.setOnClickListener(new ey(this, inflate));
        }
    }
}
