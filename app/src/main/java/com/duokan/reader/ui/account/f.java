package com.duokan.reader.ui.account;

import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.b;
import com.duokan.reader.domain.account.i;

import java.util.Iterator;

class f implements Runnable {
    final /* synthetic */ a a;
    final /* synthetic */ MiAccountAssist b;

    f(MiAccountAssist miAccountAssist, a aVar) {
        this.b = miAccountAssist;
        this.a = aVar;
    }

    public void run() {
        i.f().b(this.a);
        Iterator it = this.b.d.iterator();
        while (it.hasNext()) {
            ((b) it.next()).a(this.a);
        }
        this.b.d.clear();
    }
}
