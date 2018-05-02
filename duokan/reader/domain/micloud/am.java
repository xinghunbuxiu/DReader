package com.duokan.reader.domain.micloud;

import com.duokan.reader.common.cache.ae;
import com.duokan.reader.common.cache.ai;

class am implements ae {
    private am() {
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((i) obj, (i) obj2);
    }

    public int a(i iVar, i iVar2) {
        return Long.valueOf(iVar.s()).compareTo(Long.valueOf(iVar2.s()));
    }

    public ai[] toSortOptions() {
        return new ai[]{new ai("work_item_start_time", true)};
    }
}
