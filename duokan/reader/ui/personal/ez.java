package com.duokan.reader.ui.personal;

import java.util.Comparator;

class ez implements Comparator {
    final /* synthetic */ eq a;

    ez(eq eqVar) {
        this.a = eqVar;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((CustomCloudItem) obj, (CustomCloudItem) obj2);
    }

    public int a(CustomCloudItem customCloudItem, CustomCloudItem customCloudItem2) {
        return customCloudItem.a(customCloudItem2);
    }
}
