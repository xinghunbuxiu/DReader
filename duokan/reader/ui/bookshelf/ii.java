package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;

class ii implements OnClickListener {
    final /* synthetic */ int a;
    final /* synthetic */ ic b;

    ii(ic icVar, int i) {
        this.b = icVar;
        this.a = i;
    }

    public void onClick(View view) {
        this.b.requestDetach();
        this.b.s.pushPage(this.b.a(this.b.r[this.a]));
    }
}
