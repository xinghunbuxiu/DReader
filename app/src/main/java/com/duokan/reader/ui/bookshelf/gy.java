package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;

class gy implements OnClickListener {
    final /* synthetic */ gx a;

    gy(gx gxVar) {
        this.a = gxVar;
    }

    public void onClick(View view) {
        if (this.a.g) {
            this.a.requestBack();
        }
    }
}
