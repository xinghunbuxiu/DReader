package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

class gd implements OnClickListener {
    final /* synthetic */ fl a;

    gd(fl flVar) {
        this.a = flVar;
    }

    public void onClick(View view) {
        this.a.a("book_list");
        this.a.b(false, new ge(this));
    }
}
