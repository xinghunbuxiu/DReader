package com.duokan.reader.ui.bookshelf;

import com.duokan.core.app.c;
import com.duokan.core.app.d;

class bo implements d {
    final /* synthetic */ bn a;

    bo(bn bnVar) {
        this.a = bnVar;
    }

    public void onCancel(c cVar) {
        this.a.f = true;
        this.a.close();
        this.a.c.dismiss();
    }
}
