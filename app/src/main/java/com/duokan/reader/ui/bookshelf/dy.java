package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.domain.statistics.C1163a;
import com.duokan.reader.ui.personal.C1412t;

class dy implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C1287do f6363a;

    dy(C1287do c1287do) {
        this.f6363a = c1287do;
    }

    public void onClick(View view) {
        C1163a.m8627k().m8655c("bookshelf_menu", "click", "bookshelf_style");
        this.f6363a.m9502a(new C1412t(this.f6363a.getContext()));
    }
}
