package com.duokan.reader.ui.reading;

import com.duokan.core.sys.ag;
import com.duokan.reader.domain.document.epub.av;

import java.util.Map;

class kr implements ag {
    final /* synthetic */ av a;
    final /* synthetic */ kq b;

    kr(kq kqVar, av avVar) {
        this.b = kqVar;
        this.a = avVar;
    }

    public void a(Map map) {
        this.b.i = false;
        this.b.j = false;
        if (this.b.n == this.a) {
            this.b.n = null;
        }
        if (this.b.b) {
            this.b.c();
        } else {
            this.b.b();
        }
    }
}
