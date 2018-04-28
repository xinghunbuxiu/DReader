package com.duokan.reader.domain.micloud;

import com.duokan.reader.common.cache.ae;
import com.duokan.reader.common.cache.ai;

class aw implements ae<C1084z> {
    private aw() {
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m8092a((C1084z) obj, (C1084z) obj2);
    }

    /* renamed from: a */
    public int m8092a(C1084z c1084z, C1084z c1084z2) {
        return Long.valueOf(c1084z.m2304s()).compareTo(Long.valueOf(c1084z2.m2304s()));
    }

    public ai[] toSortOptions() {
        return new ai[]{new ai("work_item_start_time", true)};
    }
}
