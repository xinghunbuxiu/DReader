package com.duokan.reader.ui.reading;

import com.duokan.core.app.e;
import com.duokan.core.app.x;
import com.duokan.core.sys.ag;
import com.duokan.reader.domain.statistics.a;

class du implements ag {
    final /* synthetic */ dt a;

    du(dt dtVar) {
        this.a = dtVar;
    }

    public void a(String str) {
        e commentView$2$1$1$1 = new CommentView$2$1$1$1(this, x.a(this.a.a.a.getContext()));
        a.k().a("tip", "click", "reading_comment_page_tip_entrance", false);
        this.a.a.a.A.showPopupSmoothly(commentView$2$1$1$1, null);
    }
}
