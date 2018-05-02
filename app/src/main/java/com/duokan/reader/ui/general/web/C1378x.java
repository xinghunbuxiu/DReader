package com.duokan.reader.ui.general.web;

/* renamed from: com.duokan.reader.ui.general.web.x */
class C1378x implements Runnable {
    /* renamed from: a */
    final /* synthetic */ SearchController f8182a;

    C1378x(SearchController searchController) {
        this.f8182a = searchController;
    }

    public void run() {
        if (!this.f8182a.mLoadingSucceed) {
            this.f8182a.showHintView();
        }
    }
}
