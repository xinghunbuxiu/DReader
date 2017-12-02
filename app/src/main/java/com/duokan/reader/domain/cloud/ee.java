package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.cache.ab;

class ee implements ab {
    final /* synthetic */ ed a;

    ee(ed edVar) {
        this.a = edVar;
    }

    public void a(int i) {
        if (i < 1) {
            this.a.clearItems();
            this.a.updateInfo(null);
        }
        if (i < 3) {
            this.a.replaceWithItems(this.a.queryItems());
        }
    }
}
