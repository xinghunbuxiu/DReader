package com.duokan.reader.ui.personal;

import java.util.Comparator;

class ey implements Comparator {
    final /* synthetic */ ex a;

    ey(ex exVar) {
        this.a = exVar;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((CustomCloudItem) obj, (CustomCloudItem) obj2);
    }

    public int a(CustomCloudItem customCloudItem, CustomCloudItem customCloudItem2) {
        return Long.valueOf(customCloudItem.f()).compareTo(Long.valueOf(customCloudItem.f())) * -1;
    }
}
