package com.duokan.reader.ui.general.web;

import com.duokan.reader.ui.general.ey;

class es implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f7796a;
    /* renamed from: b */
    final /* synthetic */ String f7797b;
    /* renamed from: c */
    final /* synthetic */ String f7798c;
    /* renamed from: d */
    final /* synthetic */ C1352a f7799d;
    /* renamed from: e */
    final /* synthetic */ eq f7800e;

    es(eq eqVar, String str, String str2, String str3, C1352a c1352a) {
        this.f7800e = eqVar;
        this.f7796a = str;
        this.f7797b = str2;
        this.f7798c = str3;
        this.f7799d = c1352a;
    }

    public void run() {
        ey eyVar = new ey(this.f7800e.f7793b.f7581b.getContext());
        eyVar.m10591a(this.f7800e.f7793b.f7581b.mPageTitle);
        eyVar.m10593b(this.f7796a);
        eyVar.m10595d(this.f7797b);
        eyVar.m10594c(this.f7798c);
        this.f7800e.f7793b.f7581b.mCallBackSucceed = false;
        eyVar.m10590a(new et(this));
        eyVar.m10589a(new eu(this));
        eyVar.setOnDismissListener(new ev(this));
        eyVar.show();
    }
}
