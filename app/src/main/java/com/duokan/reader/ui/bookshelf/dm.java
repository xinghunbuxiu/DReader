package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;

class dm implements OnClickListener {
    final /* synthetic */ dh a;

    dm(dh dhVar) {
        this.a = dhVar;
    }

    public void onClick(View view) {
        this.a.a(new dn(this));
        this.a.requestBack();
    }
}
