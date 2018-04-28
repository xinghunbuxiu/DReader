package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.cloud.DkSharedStorageManager;
import java.util.concurrent.Callable;

class cq implements Callable<String> {
    /* renamed from: a */
    final /* synthetic */ String f7690a;
    /* renamed from: b */
    final /* synthetic */ ci f7691b;

    cq(ci ciVar, String str) {
        this.f7691b = ciVar;
        this.f7690a = str;
    }

    public /* synthetic */ Object call() {
        return m11066a();
    }

    /* renamed from: a */
    public String m11066a() {
        return DkSharedStorageManager.m5016a().m5023a(this.f7690a);
    }
}
