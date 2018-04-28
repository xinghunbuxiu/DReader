package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.domain.statistics.C1163a;

class dw implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C1287do f6361a;

    dw(C1287do c1287do) {
        this.f6361a = c1287do;
    }

    public void onClick(View view) {
        C1163a.m8627k().m8655c("bookshelf_menu", "click", "check_in");
        this.f6361a.m9491a(new dx(this));
        this.f6361a.requestBack();
    }
}
