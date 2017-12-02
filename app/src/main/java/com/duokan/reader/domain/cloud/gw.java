package com.duokan.reader.domain.cloud;

import java.util.Iterator;

class gw implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ PersonalPrefs b;

    gw(PersonalPrefs personalPrefs, boolean z) {
        this.b = personalPrefs;
        this.a = z;
    }

    public void run() {
        Iterator it = this.b.i.iterator();
        while (it.hasNext()) {
            ((hj) it.next()).a(this.a);
        }
    }
}
