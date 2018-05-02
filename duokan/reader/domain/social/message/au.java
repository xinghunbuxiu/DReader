package com.duokan.reader.domain.social.message;

import com.duokan.reader.common.cache.ae;
import com.duokan.reader.common.cache.ai;

class au implements ae {
    private au() {
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((k) obj, (k) obj2);
    }

    public int a(k kVar, k kVar2) {
        return kVar.b.compareTo(kVar2.b) * -1;
    }

    public ai[] toSortOptions() {
        return new ai[]{new ai("__ITEM__KEY__", false)};
    }
}
