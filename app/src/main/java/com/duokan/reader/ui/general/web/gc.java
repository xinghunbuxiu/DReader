package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;

class gc implements as {
    final /* synthetic */ cg a;

    gc(cg cgVar) {
        this.a = cgVar;
    }

    public void a() {
        if (this.a.b.mEditFeedController != null) {
            this.a.b.mEditFeedController.requestDetach();
            this.a.b.mEditFeedController = null;
        }
    }
}
