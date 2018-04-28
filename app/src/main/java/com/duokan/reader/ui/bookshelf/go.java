package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;

class go implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ gm f6524a;

    go(gm gmVar) {
        this.f6524a = gmVar;
    }

    public void onClick(View view) {
        if (this.f6524a.f6521b != null) {
            this.f6524a.f6521b.mo1690a((String) view.getTag());
        }
    }
}
