package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;

class fy implements as {
    final /* synthetic */ PageController a;

    fy(PageController cgVar) {
        this.a = cgVar;
    }

    public void a() {
        if (this.a.pageController.mEditCommentDialog != null) {
            this.a.pageController.mEditCommentDialog.dismiss();
            this.a.pageController.mEditCommentDialog = null;
        }
    }
}
