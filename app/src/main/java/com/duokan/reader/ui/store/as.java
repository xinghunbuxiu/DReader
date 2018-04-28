package com.duokan.reader.ui.store;

import com.duokan.reader.domain.bookshelf.fp;
import com.duokan.reader.domain.store.C0466h;
import com.duokan.reader.domain.store.DkStoreItem;
import com.duokan.reader.ui.general.ja;

class as implements C0466h {
    /* renamed from: a */
    final /* synthetic */ ja f11326a;
    /* renamed from: b */
    final /* synthetic */ ar f11327b;

    as(ar arVar, ja jaVar) {
        this.f11327b = arVar;
        this.f11326a = jaVar;
    }

    public void onFetchBookDetailOk(DkStoreItem dkStoreItem) {
        Runnable atVar = new at(this, dkStoreItem);
        if (this.f11327b.f11324b.aI()) {
            ((fp) this.f11327b.f11324b).m4405a(new av(this, atVar));
        } else {
            atVar.run();
        }
    }

    public void onFetchBookDetailError(String str) {
        this.f11326a.dismiss();
        C1502o.m15426d(str);
    }
}
