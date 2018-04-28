package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.domain.statistics.C1163a;

class dv implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C1287do f6360a;

    dv(C1287do c1287do) {
        this.f6360a = c1287do;
    }

    public void onClick(View view) {
        C1163a.m8627k().m8655c("bookshelf_menu", "click", "wifi");
        this.f6360a.m9502a(new jp(this.f6360a.getContext()));
    }
}
