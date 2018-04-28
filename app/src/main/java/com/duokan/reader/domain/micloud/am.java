package com.duokan.reader.domain.micloud;

import com.duokan.reader.common.cache.ae;
import com.duokan.reader.common.cache.ai;

class am implements ae<C1068i> {
    private am() {
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m8064a((C1068i) obj, (C1068i) obj2);
    }

    /* renamed from: a */
    public int m8064a(C1068i c1068i, C1068i c1068i2) {
        return Long.valueOf(c1068i.m2304s()).compareTo(Long.valueOf(c1068i2.m2304s()));
    }

    public ai[] toSortOptions() {
        return new ai[]{new ai("work_item_start_time", true)};
    }
}
