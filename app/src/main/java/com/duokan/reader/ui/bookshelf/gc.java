package com.duokan.reader.ui.bookshelf;

import com.duokan.core.sys.t;

class gc implements Runnable {
    final /* synthetic */ gb a;

    gc(gb gbVar) {
        this.a = gbVar;
    }

    public void run() {
        t.b(this.a.a);
    }
}
