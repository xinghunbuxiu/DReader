package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.domain.bookshelf.an;

class aw implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ ao f6147a;

    aw(ao aoVar) {
        this.f6147a = aoVar;
    }

    public void onClick(View view) {
        if (this.f6147a.m9151b(this.f6147a.m9158h())) {
            this.f6147a.f6121a.mo1655b(this.f6147a.m9158h().m3763d());
        } else {
            this.f6147a.f6121a.mo1649a((an[]) this.f6147a.f6122b.m9434a(this.f6147a.m9158h()).toArray(new an[0]));
        }
    }
}
