package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.domain.cloud.p;

class hs implements p {
    final /* synthetic */ hi a;

    hs(hi hiVar) {
        this.a = hiVar;
    }

    public void a() {
        this.a.f.setPrefLong(PrivatePref.BOOKSHELF, "last_statistics_update_date", System.currentTimeMillis());
        this.a.z = false;
    }

    public void a(String str) {
        this.a.z = false;
    }
}
