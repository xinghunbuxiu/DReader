package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.t;
import com.duokan.reader.ReaderEnv;

class x implements Runnable {
    final /* synthetic */ SearchController a;

    x(SearchController searchController) {
        this.a = searchController;
    }

    public void run() {
        t.a(new y(this, ReaderEnv.get().getDb().a("search_history")));
    }
}
