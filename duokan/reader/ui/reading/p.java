package com.duokan.reader.ui.reading;

import com.duokan.core.app.c;
import com.duokan.core.app.d;

class p implements d {
    final /* synthetic */ k a;

    p(k kVar) {
        this.a = kVar;
    }

    public void onCancel(c cVar) {
        if (this.a.d != null) {
            this.a.d.a();
        }
    }
}
