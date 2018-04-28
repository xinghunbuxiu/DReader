package com.duokan.reader.ui.personal;

import com.duokan.common.C0259a;
import com.duokan.reader.domain.bookshelf.it;
import com.duokan.reader.domain.bookshelf.jo;
import com.duokan.reader.domain.micloud.C1068i;
import com.duokan.reader.domain.micloud.bj;
import java.util.ArrayList;
import java.util.List;

class eq implements jo {
    /* renamed from: a */
    final /* synthetic */ ek f8516a;

    eq(ek ekVar) {
        this.f8516a = ekVar;
    }

    /* renamed from: a */
    public void mo979a() {
        bj b = it.m4692a().m4725b().m8168b();
        ArrayList arrayList = new ArrayList(it.m4692a().m4730c());
        List<C1068i> d = it.m4692a().m4732d();
        ArrayList arrayList2 = new ArrayList(arrayList.size() + d.size());
        for (C1068i customCloudItem : d) {
            arrayList2.add(new CustomCloudItem(customCloudItem));
        }
        C0259a.m568a(new er(this, arrayList, arrayList2, b), new Void[0]);
    }

    /* renamed from: b */
    private void m11767b() {
        this.f8516a.f8507q = false;
        if (this.f8516a.f8508r) {
            this.f8516a.f8508r = false;
            this.f8516a.m11746g();
        }
    }
}
