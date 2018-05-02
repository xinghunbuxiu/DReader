package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;

class di implements OnClickListener {
    final /* synthetic */ dh a;

    di(dh dhVar) {
        this.a = dhVar;
    }

    public void onClick(View view) {
        this.a.a(new dj(this));
        this.a.requestBack();
    }
}
