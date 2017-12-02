package com.duokan.reader.domain.micloud;

import com.duokan.reader.common.cache.ae;
import com.duokan.reader.common.cache.ai;

class as implements ae {
    private as() {
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((bi) obj, (bi) obj2);
    }

    public int a(bi biVar, bi biVar2) {
        return biVar.l().compareTo(biVar2.l());
    }

    public ai[] toSortOptions() {
        return new ai[]{new ai("__ITEM__KEY__", true), new ai("parent_cloud_path", true)};
    }
}
