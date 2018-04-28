package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.domain.statistics.C1163a;

class dp implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C1287do f6354a;

    dp(C1287do c1287do) {
        this.f6354a = c1287do;
    }

    public void onClick(View view) {
        C1163a.m8627k().m8655c("bookshelf_menu", "click", "purchase");
        this.f6354a.m9491a(new dq(this));
        this.f6354a.requestBack();
    }
}
