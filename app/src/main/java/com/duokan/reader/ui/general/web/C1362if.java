package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.reader.ui.account.ab;

/* renamed from: com.duokan.reader.ui.general.web.if */
class C1362if implements as {
    /* renamed from: a */
    final /* synthetic */ String f7983a;
    /* renamed from: b */
    final /* synthetic */ String f7984b;
    /* renamed from: c */
    final /* synthetic */ String f7985c;
    /* renamed from: d */
    final /* synthetic */ String f7986d;
    /* renamed from: e */
    final /* synthetic */ String[] f7987e;
    /* renamed from: f */
    final /* synthetic */ String[] f7988f;
    /* renamed from: g */
    final /* synthetic */ ie f7989g;

    C1362if(ie ieVar, String str, String str2, String str3, String str4, String[] strArr, String[] strArr2) {
        this.f7989g = ieVar;
        this.f7983a = str;
        this.f7984b = str2;
        this.f7985c = str3;
        this.f7986d = str4;
        this.f7987e = strArr;
        this.f7988f = strArr2;
    }

    /* renamed from: a */
    public void mo1831a() {
        if (this.f7989g.f7982b.f7581b.mShareController != null) {
            this.f7989g.f7982b.f7581b.deactivate(this.f7989g.f7982b.f7581b.mShareController);
            this.f7989g.f7982b.f7581b.removeSubController(this.f7989g.f7982b.f7581b.mShareController);
        }
        new ab(this.f7989g.f7982b.f7581b.getContext(), false, new ig(this)).show();
    }
}
