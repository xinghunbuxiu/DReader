package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.TaskHandler;
import com.duokan.reader.ReaderEnv;

class x implements Runnable {
    final /* synthetic */ SearchController a;

    x(SearchController searchController) {
        this.a = searchController;
    }

    public void run() {
        TaskHandler.postTask(new y(this, ReaderEnv.get().getDb().a("search_history")));
    }
}
