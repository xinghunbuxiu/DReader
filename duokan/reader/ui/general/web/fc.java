package com.duokan.reader.ui.general.web;

import com.duokan.reader.ui.general.ib;

class fc implements ib {
    final /* synthetic */ fb a;

    fc(fb fbVar) {
        this.a = fbVar;
    }

    public void a(int i) {
        this.a.d.b.pageController.web_notifyWeb(this.a.c, 0, "index", Integer.valueOf(i));
    }
}
