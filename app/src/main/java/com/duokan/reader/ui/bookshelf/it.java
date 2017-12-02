package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;

class it implements OnClickListener {
    final /* synthetic */ ir a;

    it(ir irVar) {
        this.a = irVar;
    }

    public void onClick(View view) {
        this.a.requestBack();
    }
}
