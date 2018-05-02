package com.duokan.reader.ui.general.web;

import com.duokan.core.app.c;
import com.duokan.core.app.d;

class ev implements d {
    final /* synthetic */ et a;

    ev(et etVar) {
        this.a = etVar;
    }

    public void onCancel(c cVar) {
        this.a.d.b.pageController.web_notifyWeb(this.a.c, 2, new Object[0]);
    }
}
