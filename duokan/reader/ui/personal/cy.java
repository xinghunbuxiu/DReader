package com.duokan.reader.ui.personal;

import com.duokan.core.app.ab;
import com.duokan.core.app.ac;
import com.duokan.core.ui.j;
import com.duokan.reader.domain.cloud.push.q;
import com.duokan.reader.ui.general.jq;

import java.util.ArrayList;
import java.util.List;

class cy implements ac {
    final /* synthetic */ Runnable a;
    final /* synthetic */ ct b;

    cy(ct ctVar, Runnable runnable) {
        this.b = ctVar;
        this.a = runnable;
    }

    public void a(ab abVar) {
        j a = jq.a(this.b.getContext(), "", this.b.getResources().getString(com.duokan.c.j.personal__message_push_view__deleting), true, true);
        List j = this.b.getAdapter().j();
        List arrayList = new ArrayList();
        for (Object next : j) {
            if (next instanceof q) {
                arrayList.add((q) next);
            }
        }
        b.a().a(arrayList, new cz(this, arrayList, a));
    }

    public void b(ab abVar) {
    }
}
