package com.duokan.reader.ui.reading;

import com.duokan.core.sys.j;
import com.duokan.reader.domain.bookshelf.jn;
import com.duokan.reader.domain.bookshelf.jo;

class qy implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ jn b;
    final /* synthetic */ jo c;
    final /* synthetic */ qx d;

    qy(qx qxVar, String str, jn jnVar, jo joVar) {
        this.d = qxVar;
        this.a = str;
        this.b = jnVar;
        this.c = joVar;
    }

    public void run() {
        j.a(new qz(this));
    }
}
