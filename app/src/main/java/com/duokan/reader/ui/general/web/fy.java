package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;

class fy implements as {
    final /* synthetic */ cg a;

    fy(cg cgVar) {
        this.a = cgVar;
    }

    public void a() {
        if (this.a.b.mEditCommentDialog != null) {
            this.a.b.mEditCommentDialog.dismiss();
            this.a.b.mEditCommentDialog = null;
        }
    }
}
