package com.duokan.reader.ui.reading;

import com.duokan.reader.ui.general.FixedPagesView.PageScaleType;

class xg implements Runnable {
    final /* synthetic */ xf a;

    xg(xf xfVar) {
        this.a = xfVar;
    }

    public void run() {
        this.a.a.c.a(PageScaleType.MATCH_WIDTH);
    }
}
