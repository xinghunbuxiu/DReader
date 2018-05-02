package com.duokan.reader.domain.micloud;

import com.duokan.reader.common.cache.ae;
import com.duokan.reader.common.cache.ai;

class aw implements ae {
    private aw() {
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((z) obj, (z) obj2);
    }

    public int a(z zVar, z zVar2) {
        return Long.valueOf(zVar.s()).compareTo(Long.valueOf(zVar2.s()));
    }

    public ai[] toSortOptions() {
        return new ai[]{new ai("work_item_start_time", true)};
    }
}
