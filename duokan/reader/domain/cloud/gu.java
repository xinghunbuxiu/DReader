package com.duokan.reader.domain.cloud;

import java.util.Iterator;

class gu implements Runnable {
    final /* synthetic */ PersonalPrefs a;

    gu(PersonalPrefs personalPrefs) {
        this.a = personalPrefs;
    }

    public void run() {
        Iterator it = this.a.g.iterator();
        while (it.hasNext()) {
            ((hg) it.next()).d();
        }
    }
}
