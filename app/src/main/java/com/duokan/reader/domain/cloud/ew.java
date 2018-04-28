package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.cache.ab;

class ew implements ab {
    /* renamed from: a */
    final /* synthetic */ ev f3954a;

    ew(ev evVar) {
        this.f3954a = evVar;
    }

    /* renamed from: a */
    public void mo1155a(int i) {
        if (i < 1) {
            this.f3954a.clearItems();
            this.f3954a.updateInfo(null);
            return;
        }
        this.f3954a.replaceWithItems(this.f3954a.queryItems());
        DkUserReadingNotesCacheInfo a = this.f3954a.m5512a();
        a.mReadingNoteCount = -1;
        this.f3954a.updateInfo(a);
    }
}
