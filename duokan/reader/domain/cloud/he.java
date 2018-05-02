package com.duokan.reader.domain.cloud;

import java.util.Iterator;

class he implements Runnable {
    final /* synthetic */ PersonalPrefs a;

    he(PersonalPrefs personalPrefs) {
        this.a = personalPrefs;
    }

    public void run() {
        Iterator it = this.a.f.iterator();
        while (it.hasNext()) {
            ((hi) it.next()).f();
        }
    }
}
