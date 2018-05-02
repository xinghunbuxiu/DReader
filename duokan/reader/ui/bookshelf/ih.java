package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;

class ih implements OnClickListener {
    final /* synthetic */ Runnable a;
    final /* synthetic */ ic b;

    ih(ic icVar, Runnable runnable) {
        this.b = icVar;
        this.a = runnable;
    }

    public void onClick(View view) {
        this.a.run();
    }
}
