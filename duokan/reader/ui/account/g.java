package com.duokan.reader.ui.account;

import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.b;

import java.util.Iterator;

class g implements Runnable {
    final /* synthetic */ a a;
    final /* synthetic */ String b;
    final /* synthetic */ MiAccountAssist c;

    g(MiAccountAssist miAccountAssist, a aVar, String str) {
        this.c = miAccountAssist;
        this.a = aVar;
        this.b = str;
    }

    public void run() {
        Iterator it = this.c.d.iterator();
        while (it.hasNext()) {
            ((b) it.next()).a(this.a, this.b);
        }
        this.c.d.clear();
    }
}
