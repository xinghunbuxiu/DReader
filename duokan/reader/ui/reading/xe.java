package com.duokan.reader.ui.reading;

import com.duokan.reader.ui.general.FixedPagesView.PageScaleType;

class xe implements Runnable {
    final /* synthetic */ xd a;

    xe(xd xdVar) {
        this.a = xdVar;
    }

    public void run() {
        this.a.a.c.a(PageScaleType.MATCH_INSIDE);
    }
}
