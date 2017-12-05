package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;

class dl implements as {
    final /* synthetic */ int a;
    final /* synthetic */ String b;
    final /* synthetic */ PageController c;

    dl(PageController cgVar, int i, String str) {
        this.c = cgVar;
        this.a = i;
        this.b = str;
    }

    public void a() {
        if (this.c.pageController.mJsPageStatusCode != this.a) {
            this.c.pageController.mJsPageStatusCode = this.a;
            if (this.c.pageController.mJsPageStatusCode < 0) {
                this.c.pageController.webPageError(true);
            }
        }
        this.c.pageController.onPageCreated(this.a, this.b);
    }
}
