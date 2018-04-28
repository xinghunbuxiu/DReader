package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.domain.statistics.C1163a;

class ds implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C1287do f6357a;

    ds(C1287do c1287do) {
        this.f6357a = c1287do;
    }

    public void onClick(View view) {
        C1163a.m8627k().m8655c("bookshelf_menu", "click", "on_shelf_book");
        this.f6357a.f6349b.m9440a(!this.f6357a.f6349b.m9445e());
        this.f6357a.m9501e();
    }
}
