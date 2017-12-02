package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.domain.bookshelf.c;

class ue implements OnClickListener {
    final /* synthetic */ c a;
    final /* synthetic */ ud b;

    ue(ud udVar, c cVar) {
        this.b = udVar;
        this.a = cVar;
    }

    public void onClick(View view) {
        this.b.a(new uf(this));
    }
}
