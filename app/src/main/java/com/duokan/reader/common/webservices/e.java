package com.duokan.reader.common.webservices;

import java.util.concurrent.Callable;

class e implements Callable {
    final /* synthetic */ Object a;
    final /* synthetic */ WebSession b;

    e(WebSession webSession, Object obj) {
        this.b = webSession;
        this.a = obj;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public Void a() {
        this.b.onSessionProgressUpdate(this.a);
        return null;
    }
}
