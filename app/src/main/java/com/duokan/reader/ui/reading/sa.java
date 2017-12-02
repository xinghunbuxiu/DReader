package com.duokan.reader.ui.reading;

import com.duokan.core.sys.ag;
import com.duokan.reader.domain.document.as;

class sa implements Runnable {
    final /* synthetic */ ag a;
    final /* synthetic */ as b;
    final /* synthetic */ rx c;

    sa(rx rxVar, ag agVar, as asVar) {
        this.c = rxVar;
        this.a = agVar;
        this.b = asVar;
    }

    public void run() {
        this.a.a(this.b);
    }
}
