package com.duokan.reader.ui.general.web;

class w implements Runnable {
    final /* synthetic */ SearchController a;

    w(SearchController searchController) {
        this.a = searchController;
    }

    public void run() {
        if (!this.a.mLoadingSucceed) {
            this.a.hideWebView();
        }
    }
}
