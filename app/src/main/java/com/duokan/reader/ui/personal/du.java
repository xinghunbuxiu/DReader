package com.duokan.reader.ui.personal;

import com.duokan.reader.domain.bookshelf.iz;

class du implements Runnable {
    final /* synthetic */ dt a;

    du(dt dtVar) {
        this.a = dtVar;
    }

    public void run() {
        if (this.a.a.b != null) {
            this.a.a.b.setSpaceQuota(iz.a().b());
        }
    }
}
