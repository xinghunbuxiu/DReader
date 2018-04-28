package com.duokan.reader.ui.personal;

import java.util.Comparator;

class es implements Comparator<CustomCloudItem> {
    /* renamed from: a */
    final /* synthetic */ er f8521a;

    es(er erVar) {
        this.f8521a = erVar;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m11771a((CustomCloudItem) obj, (CustomCloudItem) obj2);
    }

    /* renamed from: a */
    public int m11771a(CustomCloudItem customCloudItem, CustomCloudItem customCloudItem2) {
        return Long.valueOf(customCloudItem.m11344f()).compareTo(Long.valueOf(customCloudItem.m11344f())) * -1;
    }
}
