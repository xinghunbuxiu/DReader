package com.duokan.reader.ui.personal;

import com.duokan.reader.domain.micloud.i;

class ed implements Runnable {
    final /* synthetic */ i a;
    final /* synthetic */ dy b;

    ed(dy dyVar, i iVar) {
        this.b = dyVar;
        this.a = iVar;
    }

    public void run() {
        if (this.b.a.b != null) {
            this.b.a.b.a(this.a, false);
        }
    }
}
