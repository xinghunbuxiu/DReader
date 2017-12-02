package com.duokan.reader.ui.general.web;

import com.duokan.reader.ReaderEnv;

class t implements Runnable {
    final /* synthetic */ SearchController a;

    t(SearchController searchController) {
        this.a = searchController;
    }

    public void run() {
        com.duokan.core.sys.t.a(new u(this, ReaderEnv.get().getDb().a("search_hotword")));
    }
}
