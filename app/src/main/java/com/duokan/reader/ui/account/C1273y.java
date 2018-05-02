package com.duokan.reader.ui.account;

import com.duokan.core.sys.ag;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.ui.account.ShareEntranceController.ShareType;

/* renamed from: com.duokan.reader.ui.account.y */
class C1273y implements ag<String> {
    /* renamed from: a */
    final /* synthetic */ ShareType f5995a;
    /* renamed from: b */
    final /* synthetic */ ag f5996b;
    /* renamed from: c */
    final /* synthetic */ C1270v f5997c;

    C1273y(C1270v c1270v, ShareType shareType, ag agVar) {
        this.f5997c = c1270v;
        this.f5995a = shareType;
        this.f5996b = agVar;
    }

    public /* synthetic */ void run(Object obj) {
        m9025a((String) obj);
    }

    /* renamed from: a */
    public void m9025a(String str) {
        Object a = C0641o.m2934i().m2958a(new String[]{str});
        if (this.f5995a == ShareType.TEXT || this.f5995a == ShareType.COMMENT || this.f5995a == ShareType.NOTE) {
            a = a + "&a=note";
        }
        this.f5996b.run(a);
        this.f5997c.f5991m = false;
    }
}
