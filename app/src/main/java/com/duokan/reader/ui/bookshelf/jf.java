package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;

class jf implements OnClickListener {
    final /* synthetic */ jd a;

    jf(jd jdVar) {
        this.a = jdVar;
    }

    public void onClick(View view) {
        this.a.requestBack();
    }
}
