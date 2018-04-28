package com.duokan.reader.ui.personal;

import com.duokan.core.app.ac;
import com.duokan.core.app.ad;
import com.duokan.reader.domain.cloud.DkCloudStoreBook;
import java.util.ArrayList;
import java.util.List;

class ma implements ad {
    /* renamed from: a */
    final /* synthetic */ Runnable f8920a;
    /* renamed from: b */
    final /* synthetic */ ly f8921b;

    ma(ly lyVar, Runnable runnable) {
        this.f8921b = lyVar;
        this.f8920a = runnable;
    }

    /* renamed from: a */
    public void mo1553a(ac acVar) {
        List arrayList = new ArrayList();
        List j = this.f8921b.f8915a.getAdapter().m9788j();
        for (int i = 0; i < j.size(); i++) {
            if (j.get(i) instanceof DkCloudStoreBook) {
                arrayList.add((DkCloudStoreBook) j.get(i));
            }
        }
        this.f8921b.f8917c.mo1935a(new mb(this, arrayList), arrayList);
    }

    /* renamed from: b */
    public void mo1554b(ac acVar) {
    }
}
