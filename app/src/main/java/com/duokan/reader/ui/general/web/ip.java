package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.af;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.ui.general.jq;
import com.duokan.reader.ui.store.aq;

class ip implements Runnable {
    final /* synthetic */ jq a;
    final /* synthetic */ af b;
    final /* synthetic */ String c;
    final /* synthetic */ int d;
    final /* synthetic */ il e;

    ip(il ilVar, jq jqVar, af afVar, String str, int i) {
        this.e = ilVar;
        this.a = jqVar;
        this.b = afVar;
        this.c = str;
        this.d = i;
    }

    public void run() {
        this.a.dismiss();
        if (this.b.b()) {
            ReaderFeature readerFeature = (ReaderFeature) this.e.b.pageController.getContext().queryFeature(ReaderFeature.class);
            if (((c) this.b.a()).k()) {
                aq.a(readerFeature, (c) this.b.a(), (long) this.d);
            } else {
                readerFeature.openBook((c) this.b.a());
            }
            this.e.b.pageController.web_notifyWeb(this.c, 0, "open", Boolean.valueOf(true));
            return;
        }
        this.e.b.pageController.web_notifyWeb(this.c, 0, "open", Boolean.valueOf(false));
    }
}
