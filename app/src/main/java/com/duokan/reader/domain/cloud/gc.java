package com.duokan.reader.domain.cloud;

import java.util.Iterator;

class gc implements Runnable {
    /* renamed from: a */
    final /* synthetic */ boolean f4034a;
    /* renamed from: b */
    final /* synthetic */ PersonalPrefs f4035b;

    gc(PersonalPrefs personalPrefs, boolean z) {
        this.f4035b = personalPrefs;
        this.f4034a = z;
    }

    public void run() {
        Iterator it = this.f4035b.f3637i.iterator();
        while (it.hasNext()) {
            ((gp) it.next()).mo1707b(this.f4034a);
        }
    }
}
