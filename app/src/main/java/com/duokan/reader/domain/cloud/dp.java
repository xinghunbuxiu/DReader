package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.cache.ab;

class dp implements ab {
    /* renamed from: a */
    final /* synthetic */ C0844do f3886a;

    dp(C0844do c0844do) {
        this.f3886a = c0844do;
    }

    /* renamed from: a */
    public void mo1155a(int i) {
        if (i < 1) {
            this.f3886a.clearItems();
            this.f3886a.updateInfo(null);
        }
        if (i < 3) {
            this.f3886a.replaceWithItems(this.f3886a.queryItems());
        }
    }
}
