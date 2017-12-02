package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.cloud.PersonalPrefs;

class aw implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ aq b;

    aw(aq aqVar, int i) {
        this.b = aqVar;
        this.a = i;
    }

    public void run() {
        if (!this.b.j.b() && PersonalPrefs.a().y()) {
            ab abVar = this.b.j;
            if (this.a == 0) {
                new ax(this, abVar, abVar).open();
            } else {
                this.b.b(this.a);
            }
        }
    }
}
