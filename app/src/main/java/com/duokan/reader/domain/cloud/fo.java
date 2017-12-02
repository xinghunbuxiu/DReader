package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.cache.ab;

class fo implements ab {
    final /* synthetic */ fn a;

    fo(fn fnVar) {
        this.a = fnVar;
    }

    public void a(int i) {
        if (i < 1) {
            this.a.clearItems();
            this.a.updateInfo(null);
            return;
        }
        this.a.replaceWithItems(this.a.queryItems());
        DkUserReadingNotesCacheInfo a = this.a.a();
        a.mReadingNoteCount = -1;
        this.a.updateInfo(a);
    }
}
