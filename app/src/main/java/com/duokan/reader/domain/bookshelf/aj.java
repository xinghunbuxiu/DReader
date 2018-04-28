package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.p025a.Permissions;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.common.p038d.C0587a;

class aj implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ai f2765a;

    aj(ai aiVar) {
        this.f2765a = aiVar;
    }

    public void run() {
        new C0587a(new ak(this), 31).m2637a(600000);
        C0559f.m2476b().m2480a(this.f2765a);
        if (C0559f.m2476b().m2486e() && Permissions.getInstance().m834b()) {
            this.f2765a.mo949a(C0559f.m2476b());
        }
    }
}
