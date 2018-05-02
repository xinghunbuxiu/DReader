package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.domain.bookshelf.c;

class px implements OnClickListener {
    final /* synthetic */ c a;
    final /* synthetic */ pw b;

    px(pw pwVar, c cVar) {
        this.b = pwVar;
        this.a = cVar;
    }

    public void onClick(View view) {
        this.b.a(new py(this));
    }
}
