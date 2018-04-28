package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.account.al;
import com.duokan.reader.domain.cloud.PersonalPrefs;

class at implements Runnable {
    /* renamed from: a */
    final /* synthetic */ int f2777a;
    /* renamed from: b */
    final /* synthetic */ ar f2778b;

    at(ar arVar, int i) {
        this.f2778b = arVar;
        this.f2777a = i;
    }

    public void run() {
        if (!this.f2778b.j.m3366b() && PersonalPrefs.m5175a().m5250z()) {
            al alVar = this.f2778b.j;
            if (this.f2777a == 0) {
                new au(this, alVar, alVar).open();
            } else {
                this.f2778b.m3962b(this.f2777a);
            }
        }
    }
}
