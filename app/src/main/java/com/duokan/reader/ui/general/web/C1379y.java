package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.UThread;
import com.duokan.reader.ReaderEnv;

/* renamed from: com.duokan.reader.ui.general.web.y */
class C1379y implements Runnable {
    /* renamed from: a */
    final /* synthetic */ SearchController f8183a;

    C1379y(SearchController searchController) {
        this.f8183a = searchController;
    }

    public void run() {
        UThread.runOnThread(new C1380z(this, ReaderEnv.get().getDb().m630a("search_history")));
    }
}
