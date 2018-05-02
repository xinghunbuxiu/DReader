package com.duokan.reader.ui.bookshelf;

import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.bookshelf.ai;

class ja implements Runnable {
    final /* synthetic */ iv a;

    ja(iv ivVar) {
        this.a = ivVar;
    }

    public void run() {
        Object obj = (!i.f().b() || ai.a().c().b()) ? null : 1;
        if (obj != null) {
            new ij(this.a.getContext()).a(null);
        }
    }
}
