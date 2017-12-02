package com.duokan.reader.ui.personal;

import com.duokan.core.app.ab;
import com.duokan.core.app.ac;
import com.duokan.reader.domain.cloud.DkCloudStoreBook;

import java.util.ArrayList;
import java.util.List;

class lm implements ac {
    final /* synthetic */ Runnable a;
    final /* synthetic */ lk b;

    lm(lk lkVar, Runnable runnable) {
        this.b = lkVar;
        this.a = runnable;
    }

    public void a(ab abVar) {
        List arrayList = new ArrayList();
        List j = this.b.a.getAdapter().j();
        for (int i = 0; i < j.size(); i++) {
            if (j.get(i) instanceof DkCloudStoreBook) {
                arrayList.add((DkCloudStoreBook) j.get(i));
            }
        }
        this.b.c.a(new ln(this, arrayList), arrayList);
    }

    public void b(ab abVar) {
    }
}
