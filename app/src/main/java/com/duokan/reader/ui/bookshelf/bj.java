package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.duokan.reader.domain.bookshelf.C0800c;

class bj implements OnLongClickListener {
    /* renamed from: a */
    final /* synthetic */ bh f6178a;

    bj(bh bhVar) {
        this.f6178a = bhVar;
    }

    public boolean onLongClick(View view) {
        bm bmVar = (bm) view;
        this.f6178a.f6173k.mo1726a((C0800c) bmVar.getItem(), bmVar, new bk(this), new bl(this));
        return true;
    }
}
