package com.duokan.reader.ui.personal;

import com.duokan.core.app.ab;
import com.duokan.core.app.ac;
import com.duokan.core.ui.j;
import com.duokan.reader.domain.social.message.h;
import com.duokan.reader.domain.social.message.k;
import com.duokan.reader.ui.general.jq;

import java.util.ArrayList;
import java.util.List;

class ch implements ac {
    final /* synthetic */ Runnable a;
    final /* synthetic */ cd b;

    ch(cd cdVar, Runnable runnable) {
        this.b = cdVar;
        this.a = runnable;
    }

    public void a(ab abVar) {
        j a = jq.a(this.b.getContext(), "", this.b.getResources().getString(com.duokan.c.j.personal__message_center_view__deleting), true, true);
        List j = this.b.k.j();
        List arrayList = new ArrayList();
        for (Object next : j) {
            if (next instanceof k) {
                arrayList.add((k) next);
            }
        }
        h.a().a(arrayList, new ci(this, arrayList, a));
    }

    public void b(ab abVar) {
    }
}
