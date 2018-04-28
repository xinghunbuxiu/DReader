package com.duokan.reader.ui.personal;

import java.util.Comparator;

class et implements Comparator<CustomCloudItem> {
    /* renamed from: a */
    final /* synthetic */ ek f8522a;

    et(ek ekVar) {
        this.f8522a = ekVar;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m11772a((CustomCloudItem) obj, (CustomCloudItem) obj2);
    }

    /* renamed from: a */
    public int m11772a(CustomCloudItem customCloudItem, CustomCloudItem customCloudItem2) {
        return customCloudItem.m11336a(customCloudItem2);
    }
}
