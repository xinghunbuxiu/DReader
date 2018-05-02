package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.UThread;
import com.duokan.reader.ReaderEnv;

/* renamed from: com.duokan.reader.ui.general.web.u */
class C1375u implements Runnable {
    /* renamed from: a */
    final /* synthetic */ SearchController f8177a;

    C1375u(SearchController searchController) {
        this.f8177a = searchController;
    }

    public void run() {
        UThread.runOnThread(new C1376v(this, ReaderEnv.get().getDb().m630a("search_hotword")));
    }
}
