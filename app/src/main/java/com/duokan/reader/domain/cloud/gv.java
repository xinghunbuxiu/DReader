package com.duokan.reader.domain.cloud;

import java.util.Iterator;

class gv implements Runnable {
    final /* synthetic */ PersonalPrefs a;

    gv(PersonalPrefs personalPrefs) {
        this.a = personalPrefs;
    }

    public void run() {
        Iterator it = this.a.h.iterator();
        while (it.hasNext()) {
            ((hh) it.next()).e();
        }
    }
}
