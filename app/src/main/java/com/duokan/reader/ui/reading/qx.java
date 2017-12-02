package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.bookshelf.jn;
import com.duokan.reader.domain.bookshelf.jo;

class qx implements jn {
    final /* synthetic */ qh a;

    qx(qh qhVar) {
        this.a = qhVar;
    }

    public void a(String str, jo joVar) {
        this.a.runAfterActive(new qy(this, str, this, joVar));
    }
}
