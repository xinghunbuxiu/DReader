package com.duokan.reader.ui.personal;

import com.duokan.core.app.ac;
import com.duokan.core.app.ad;
import com.duokan.core.ui.BaseDialog;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.social.message.C1148h;
import com.duokan.reader.domain.social.message.C1151k;
import com.duokan.reader.ui.general.ja;
import java.util.ArrayList;
import java.util.List;

class ca implements ad {
    /* renamed from: a */
    final /* synthetic */ Runnable f8389a;
    /* renamed from: b */
    final /* synthetic */ bw f8390b;

    ca(bw bwVar, Runnable runnable) {
        this.f8390b = bwVar;
        this.f8389a = runnable;
    }

    /* renamed from: a */
    public void mo1553a(ac acVar) {
        BaseDialog a = ja.m10832a(this.f8390b.getContext(), "", this.f8390b.getResources().getString(C0258j.personal__message_center_view__deleting), true, true);
        List j = this.f8390b.f8380l.m9788j();
        List arrayList = new ArrayList();
        for (Object next : j) {
            if (next instanceof C1151k) {
                arrayList.add((C1151k) next);
            }
        }
        C1148h.m8567a().m8487a(arrayList, new cb(this, arrayList, a));
    }

    /* renamed from: b */
    public void mo1554b(ac acVar) {
    }
}
