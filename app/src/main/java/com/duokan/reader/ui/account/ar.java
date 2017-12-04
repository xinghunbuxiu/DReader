package com.duokan.reader.ui.account;

import com.duokan.core.ui.j;
import com.duokan.core.ui.OnDismissListener;

class ar implements OnDismissListener {
    final /* synthetic */ ap a;

    ar(ap apVar) {
        this.a = apVar;
    }

    public void onDismiss(j jVar) {
        this.a.a.onChoiced(this.a.c);
    }
}
