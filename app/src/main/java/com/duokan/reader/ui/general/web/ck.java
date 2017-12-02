package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.reader.domain.cloud.DkSharedStorageManager;

class ck implements as {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ boolean c;
    final /* synthetic */ cg d;

    ck(cg cgVar, String str, String str2, boolean z) {
        this.d = cgVar;
        this.a = str;
        this.b = str2;
        this.c = z;
    }

    public void a() {
        DkSharedStorageManager.a().a(this.a, this.b, this.c);
    }
}
