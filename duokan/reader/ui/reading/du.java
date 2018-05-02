package com.duokan.reader.ui.reading;

import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.MyContextWrapper;
import com.duokan.core.sys.ag;

class du implements ag {
    final /* synthetic */ dt a;

    du(dt dtVar) {
        this.a = dtVar;
    }

    public void a(String str) {
        ActivatedController commentView$2$1$1$1 = new CommentView$2$1$1$1(this, MyContextWrapper.getFeature(this.a.a.a.getContext()));
        a.k().a("tip", "click", "reading_comment_page_tip_entrance", false);
        this.a.a.a.A.showPopupSmoothly(commentView$2$1$1$1, null);
    }
}
