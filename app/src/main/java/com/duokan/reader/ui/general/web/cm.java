package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.reader.domain.cloud.DkSharedStorageManager;

class cm implements as {
    final /* synthetic */ String a;
    final /* synthetic */ cg b;

    cm(cg cgVar, String str) {
        this.b = cgVar;
        this.a = str;
    }

    public void a() {
        DkSharedStorageManager.a().b(this.a);
    }
}
