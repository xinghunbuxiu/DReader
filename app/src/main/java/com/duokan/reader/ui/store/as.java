package com.duokan.reader.ui.store;

import com.duokan.reader.domain.bookshelf.fv;
import com.duokan.reader.domain.store.DkStoreItem;
import com.duokan.reader.domain.store.h;
import com.duokan.reader.ui.general.jq;

class as implements h {
    final /* synthetic */ jq a;
    final /* synthetic */ ar b;

    as(ar arVar, jq jqVar) {
        this.b = arVar;
        this.a = jqVar;
    }

    public void onFetchBookDetailOk(DkStoreItem dkStoreItem) {
        Runnable atVar = new at(this, dkStoreItem);
        if (this.b.b.aG()) {
            ((fv) this.b.b).a(new av(this, atVar));
        } else {
            atVar.run();
        }
    }

    public void onFetchBookDetailError(String str) {
        this.a.dismiss();
        o.d(str);
    }
}
