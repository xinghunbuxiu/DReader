package com.duokan.reader.domain.micloud;

import com.duokan.reader.common.cache.ad;
import com.duokan.reader.common.cache.ah;

class ar implements ad {
    final /* synthetic */ String a;
    final /* synthetic */ aq b;

    ar(aq aqVar, String str) {
        this.b = aqVar;
        this.a = str;
    }

    public boolean a(bi biVar) {
        return biVar.m().equalsIgnoreCase(this.a);
    }

    public ah a() {
        ah ahVar = new ah();
        ahVar.a = "parent_cloud_path =? COLLATE NOCASE";
        ahVar.b = new String[]{this.a};
        return ahVar;
    }
}
