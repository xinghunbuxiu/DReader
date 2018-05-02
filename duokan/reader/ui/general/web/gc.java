package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;

class gc implements as {
    final /* synthetic */ PageController a;

    gc(PageController cgVar) {
        this.a = cgVar;
    }

    public void a() {
        if (this.a.pageController.mEditFeedController != null) {
            this.a.pageController.mEditFeedController.requestDetach();
            this.a.pageController.mEditFeedController = null;
        }
    }
}
