package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.domain.statistics.C1163a;

class dt implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C1287do f6358a;

    dt(C1287do c1287do) {
        this.f6358a = c1287do;
    }

    public void onClick(View view) {
        C1163a.m8627k().m8655c("bookshelf_menu", "click", "import_local_book");
        this.f6358a.m9491a(new du(this));
        this.f6358a.requestBack();
    }
}
