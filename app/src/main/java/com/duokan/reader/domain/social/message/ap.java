package com.duokan.reader.domain.social.message;

import com.duokan.reader.common.cache.ae;
import com.duokan.reader.common.cache.ai;

class ap implements ae<C1151k> {
    private ap() {
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m8528a((C1151k) obj, (C1151k) obj2);
    }

    /* renamed from: a */
    public int m8528a(C1151k c1151k, C1151k c1151k2) {
        return c1151k.f5555b.compareTo(c1151k2.f5555b) * -1;
    }

    public ai[] toSortOptions() {
        return new ai[]{new ai("__ITEM__KEY__", false)};
    }
}
