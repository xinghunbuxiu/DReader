package com.duokan.reader.ui.personal;

import com.duokan.core.app.ac;
import com.duokan.core.app.ad;
import com.duokan.reader.domain.cloud.DkCloudStoreBook;
import java.util.ArrayList;
import java.util.List;

class kz implements ad {
    /* renamed from: a */
    final /* synthetic */ Runnable f8848a;
    /* renamed from: b */
    final /* synthetic */ ku f8849b;

    kz(ku kuVar, Runnable runnable) {
        this.f8849b = kuVar;
        this.f8848a = runnable;
    }

    /* renamed from: a */
    public void mo1553a(ac acVar) {
        List arrayList = new ArrayList();
        List j = this.f8849b.f8834c.getAdapter().m9788j();
        for (int i = 0; i < j.size(); i++) {
            if (j.get(i) instanceof DkCloudStoreBook) {
                arrayList.add((DkCloudStoreBook) j.get(i));
            }
        }
        this.f8849b.f8835d.mo1935a(this.f8848a, arrayList);
    }

    /* renamed from: b */
    public void mo1554b(ac acVar) {
    }
}
