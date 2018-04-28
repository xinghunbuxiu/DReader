package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.domain.cloud.C0811o;

class hm implements C0811o {
    /* renamed from: a */
    final /* synthetic */ hc f3310a;

    hm(hc hcVar) {
        this.f3310a = hcVar;
    }

    /* renamed from: a */
    public void mo1088a() {
        this.f3310a.f2742f.setPrefLong(PrivatePref.BOOKSHELF, "last_statistics_update_date", System.currentTimeMillis());
        this.f3310a.f2761z = false;
    }

    /* renamed from: a */
    public void mo1089a(String str) {
        this.f3310a.f2761z = false;
    }
}
