package com.duokan.core.ui;

import java.util.Comparator;

class az implements Comparator {
    final /* synthetic */ ay a;

    az(ay ayVar) {
        this.a = ayVar;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((Integer) obj, (Integer) obj2);
    }

    public int a(Integer num, Integer num2) {
        return this.a.z.e(num.intValue(), num2.intValue());
    }
}
