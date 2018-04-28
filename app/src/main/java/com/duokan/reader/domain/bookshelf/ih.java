package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.cloud.PersonalPrefs;

class ih implements Runnable {
    /* renamed from: a */
    final /* synthetic */ hc f3350a;

    ih(hc hcVar) {
        this.f3350a = hcVar;
    }

    public void run() {
        if (!this.f3350a.f2746j.m3366b() && PersonalPrefs.m5175a().m5250z()) {
            jx jxVar = new jx();
            jxVar.m4783a();
            de.m4313a().m4342a(jxVar, new ii(this));
        }
    }
}
