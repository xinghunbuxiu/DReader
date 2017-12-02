package com.duokan.reader.ui.general.web;

import com.duokan.core.app.c;
import com.duokan.core.app.d;

class fd implements d {
    final /* synthetic */ fb a;

    fd(fb fbVar) {
        this.a = fbVar;
    }

    public void onCancel(c cVar) {
        this.a.d.b.b.web_notifyWeb(this.a.c, 2, new Object[0]);
    }
}
