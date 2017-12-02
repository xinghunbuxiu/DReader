package com.duokan.reader.ui.b;

import com.duokan.reader.domain.social.message.h;

class b implements Runnable {
    final /* synthetic */ h a;
    final /* synthetic */ a b;

    b(a aVar, h hVar) {
        this.b = aVar;
        this.a = hVar;
    }

    public void run() {
        this.a.a(this.b);
    }
}
