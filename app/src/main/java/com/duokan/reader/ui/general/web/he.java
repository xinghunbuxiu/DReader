package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.cloud.PersonalPrefs;
import java.util.concurrent.Callable;

class he implements Callable<Boolean> {
    /* renamed from: a */
    final /* synthetic */ ci f7923a;

    he(ci ciVar) {
        this.f7923a = ciVar;
    }

    public /* synthetic */ Object call() {
        return m11168a();
    }

    /* renamed from: a */
    public Boolean m11168a() {
        return Boolean.valueOf(PersonalPrefs.m5175a().m5249y());
    }
}
