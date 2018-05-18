package com.duokan.reader.ui.personal;

import com.duokan.core.app.ac;
import com.duokan.core.app.ad;
import com.duokan.core.ui.BaseDialog;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.cloud.push.C0857b;
import com.duokan.reader.domain.cloud.push.C0876u;
import com.duokan.reader.ui.general.ja;
import java.util.ArrayList;
import java.util.List;

class cr implements ad {
    /* renamed from: a */
    final /* synthetic */ Runnable f8418a;
    /* renamed from: b */
    final /* synthetic */ cm f8419b;

    cr(cm cmVar, Runnable runnable) {
        this.f8419b = cmVar;
        this.f8418a = runnable;
    }

    /* renamed from: a */
    public void mo1553a(ac acVar) {
        BaseDialog a = ja.m10832a(this.f8419b.getContext(), "", this.f8419b.getResources().getString(C0258j.personal__message_push_view__deleting), true, true);
        List j = this.f8419b.getAdapter().m9788j();
        List arrayList = new ArrayList();
        for (Object next : j) {
            if (next instanceof C0876u) {
                arrayList.add((C0876u) next);
            }
        }
        C0857b.m5649a().m5684a(arrayList, new cs(this, arrayList, a));
    }

    /* renamed from: b */
    public void mo1554b(ac acVar) {
    }
}
