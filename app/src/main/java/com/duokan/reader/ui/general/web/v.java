package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.store.k;

class v implements k {
    final /* synthetic */ Runnable a;
    final /* synthetic */ SearchController b;

    v(SearchController searchController, Runnable runnable) {
        this.b = searchController;
        this.a = runnable;
    }

    public void a(String str, String[] strArr) {
        if (this.b.isActive()) {
            this.b.showHint(str, strArr);
        }
        this.a.run();
    }
}
