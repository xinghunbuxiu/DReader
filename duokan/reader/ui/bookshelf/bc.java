package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.domain.bookshelf.c;

class bc implements OnClickListener {
    final /* synthetic */ bb a;

    bc(bb bbVar) {
        this.a = bbVar;
    }

    public void onClick(View view) {
        bg bgVar = (bg) view;
        this.a.k.a((c) bgVar.getItem(), bgVar);
    }
}
