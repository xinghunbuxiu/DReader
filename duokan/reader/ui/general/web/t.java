package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.TaskHandler;
import com.duokan.reader.ReaderEnv;

class t implements Runnable {
    final /* synthetic */ SearchController a;

    t(SearchController searchController) {
        this.a = searchController;
    }

    public void run() {
        TaskHandler.postTask(new u(this, ReaderEnv.get().getDb().a("search_hotword")));
    }
}
