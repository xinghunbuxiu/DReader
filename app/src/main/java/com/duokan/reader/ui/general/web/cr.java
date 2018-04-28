package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.reader.domain.cloud.DkSharedStorageManager;

class cr implements as {
    /* renamed from: a */
    final /* synthetic */ String f7692a;
    /* renamed from: b */
    final /* synthetic */ ci f7693b;

    cr(ci ciVar, String str) {
        this.f7693b = ciVar;
        this.f7692a = str;
    }

    /* renamed from: a */
    public void mo1831a() {
        DkSharedStorageManager.m5016a().m5028b(this.f7692a);
    }
}
