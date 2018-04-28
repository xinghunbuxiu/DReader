package com.duokan.reader.domain.cloud;

import java.util.Iterator;

class ga implements Runnable {
    /* renamed from: a */
    final /* synthetic */ PersonalPrefs f4032a;

    ga(PersonalPrefs personalPrefs) {
        this.f4032a = personalPrefs;
    }

    public void run() {
        Iterator it = this.f4032a.f3635g.iterator();
        while (it.hasNext()) {
            ((gm) it.next()).mo2527d();
        }
    }
}
