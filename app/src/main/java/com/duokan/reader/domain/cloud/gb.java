package com.duokan.reader.domain.cloud;

import java.util.Iterator;

class gb implements Runnable {
    /* renamed from: a */
    final /* synthetic */ PersonalPrefs f4033a;

    gb(PersonalPrefs personalPrefs) {
        this.f4033a = personalPrefs;
    }

    public void run() {
        Iterator it = this.f4033a.f3636h.iterator();
        while (it.hasNext()) {
            ((gn) it.next()).mo2554e();
        }
    }
}
