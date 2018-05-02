package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnLongClickListener;

import com.duokan.reader.domain.bookshelf.c;

class bd implements OnLongClickListener {
    final /* synthetic */ bb a;

    bd(bb bbVar) {
        this.a = bbVar;
    }

    public boolean onLongClick(View view) {
        bg bgVar = (bg) view;
        this.a.k.a((c) bgVar.getItem(), bgVar, new be(this), new bf(this));
        return true;
    }
}
