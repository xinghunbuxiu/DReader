package com.duokan.reader.ui.personal;

import com.duokan.core.app.ab;
import com.duokan.core.app.ac;
import com.duokan.reader.domain.cloud.DkCloudStoreBook;

import java.util.ArrayList;
import java.util.List;

class kl implements ac {
    final /* synthetic */ Runnable a;
    final /* synthetic */ kg b;

    kl(kg kgVar, Runnable runnable) {
        this.b = kgVar;
        this.a = runnable;
    }

    public void a(ab abVar) {
        List arrayList = new ArrayList();
        List j = this.b.c.getAdapter().j();
        for (int i = 0; i < j.size(); i++) {
            if (j.get(i) instanceof DkCloudStoreBook) {
                arrayList.add((DkCloudStoreBook) j.get(i));
            }
        }
        this.b.d.a(this.a, arrayList);
    }

    public void b(ab abVar) {
    }
}
