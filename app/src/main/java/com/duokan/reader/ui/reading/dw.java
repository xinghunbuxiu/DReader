package com.duokan.reader.ui.reading;

import com.duokan.core.app.AppContext;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.sys.ag;
import com.duokan.reader.domain.statistics.C1163a;

class dw implements ag<String> {
    /* renamed from: a */
    final /* synthetic */ dv f10050a;

    dw(dv dvVar) {
        this.f10050a = dvVar;
    }

    public /* synthetic */ void run(Object obj) {
        m13997a((String) obj);
    }

    /* renamed from: a */
    public void m13997a(String str) {
        ActivatedController commentView$2$1$1$1 = new CommentView$2$1$1$1(this, AppContext.getAppContext(this.f10050a.f10049a.f10048a.getContext()));
        C1163a.m8627k().m8648a("tip", "click", "reading_comment_page_tip_entrance", false);
        this.f10050a.f10049a.f10048a.f9993B.showPopupSmoothly(commentView$2$1$1$1, null);
    }
}
