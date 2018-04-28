package com.duokan.reader.domain.micloud;

import com.duokan.reader.common.cache.ad;
import com.duokan.reader.common.cache.ah;

class ar implements ad<bi> {
    /* renamed from: a */
    final /* synthetic */ String f5199a;
    /* renamed from: b */
    final /* synthetic */ aq f5200b;

    ar(aq aqVar, String str) {
        this.f5200b = aqVar;
        this.f5199a = str;
    }

    /* renamed from: a */
    public boolean m8083a(bi biVar) {
        return biVar.m8163m().equalsIgnoreCase(this.f5199a);
    }

    /* renamed from: a */
    public ah mo1185a() {
        ah ahVar = new ah();
        ahVar.f1867a = "parent_cloud_path =? COLLATE NOCASE";
        ahVar.f1868b = new String[]{this.f5199a};
        return ahVar;
    }
}
