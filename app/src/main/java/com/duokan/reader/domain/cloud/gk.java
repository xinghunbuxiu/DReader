package com.duokan.reader.domain.cloud;

import java.util.Iterator;

class gk implements Runnable {
    /* renamed from: a */
    final /* synthetic */ PersonalPrefs f4060a;

    gk(PersonalPrefs personalPrefs) {
        this.f4060a = personalPrefs;
    }

    public void run() {
        Iterator it = this.f4060a.f3634f.iterator();
        while (it.hasNext()) {
            ((go) it.next()).mo2555f();
        }
    }
}
