package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;

class gd implements as {
    final /* synthetic */ PageController a;

    gd(PageController cgVar) {
        this.a = cgVar;
    }

    public void a() {
        if (this.a.pageController.mEditFeedController != null) {
            this.a.pageController.mEditFeedController.a();
        }
    }
}
