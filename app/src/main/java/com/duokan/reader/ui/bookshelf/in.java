package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;

class in implements OnClickListener {
    final /* synthetic */ il a;

    in(il ilVar) {
        this.a = ilVar;
    }

    public void onClick(View view) {
        if (this.a.e.g()) {
            this.a.e.d();
            this.a.c();
            return;
        }
        this.a.e.c();
        this.a.c();
    }
}
