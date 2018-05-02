package com.duokan.reader.ui.account;

import com.duokan.core.sys.ag;
import com.duokan.reader.common.webservices.duokan.p;
import com.duokan.reader.ui.account.ShareEntranceController.ShareType;

class al implements ag {
    final /* synthetic */ ShareType a;
    final /* synthetic */ ag b;
    final /* synthetic */ ai c;

    al(ai aiVar, ShareType shareType, ag agVar) {
        this.c = aiVar;
        this.a = shareType;
        this.b = agVar;
    }

    public void a(String str) {
        Object a = p.i().a(new String[]{str});
        if (this.a == ShareType.TEXT || this.a == ShareType.COMMENT || this.a == ShareType.NOTE) {
            a = a + "&setDrawable=note";
        }
        this.b.a(a);
        this.c.m = false;
    }
}
