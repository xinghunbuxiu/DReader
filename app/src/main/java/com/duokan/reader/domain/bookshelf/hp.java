package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.ah;

import java.util.concurrent.FutureTask;

class hp implements Runnable {
    final /* synthetic */ FutureTask a;
    final /* synthetic */ BaseConnect b;
    final /* synthetic */ hi c;

    hp(hi hiVar, FutureTask futureTask, BaseConnect ipVar) {
        this.c = hiVar;
        this.a = futureTask;
        this.b = ipVar;
    }

    public void run() {
        try {
            this.a.run();
        } finally {
            ah.a(new hq(this), hi.c);
        }
    }
}
