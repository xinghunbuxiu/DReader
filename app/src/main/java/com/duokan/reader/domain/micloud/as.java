package com.duokan.reader.domain.micloud;

import com.duokan.reader.common.cache.ae;
import com.duokan.reader.common.cache.ai;

class as implements ae<bi> {
    private as() {
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m8085a((bi) obj, (bi) obj2);
    }

    /* renamed from: a */
    public int m8085a(bi biVar, bi biVar2) {
        return biVar.m8162l().compareTo(biVar2.m8162l());
    }

    public ai[] toSortOptions() {
        return new ai[]{new ai("__ITEM__KEY__", true), new ai("parent_cloud_path", true)};
    }
}
