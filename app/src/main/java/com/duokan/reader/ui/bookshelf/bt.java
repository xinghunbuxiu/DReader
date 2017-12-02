package com.duokan.reader.ui.bookshelf;

import com.duokan.core.sys.t;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.ui.general.jq;

class bt implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ jq b;
    final /* synthetic */ bs c;

    bt(bs bsVar, boolean z, jq jqVar) {
        this.c = bsVar;
        this.a = z;
        this.b = jqVar;
    }

    public void run() {
        ai.a().a(this.c.c, this.a);
        t.a(new bu(this));
    }
}
