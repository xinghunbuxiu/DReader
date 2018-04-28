package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.domain.bookshelf.C0800c;

class bi implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ bh f6177a;

    bi(bh bhVar) {
        this.f6177a = bhVar;
    }

    public void onClick(View view) {
        bm bmVar = (bm) view;
        this.f6177a.f6173k.mo1725a((C0800c) bmVar.getItem(), bmVar);
    }
}
