package com.duokan.reader.ui.reading;

import java.util.Arrays;
import java.util.concurrent.Callable;

class aaj implements Callable<Boolean> {
    /* renamed from: a */
    final /* synthetic */ String f9331a;
    /* renamed from: b */
    final /* synthetic */ aah f9332b;

    aaj(aah aah, String str) {
        this.f9332b = aah;
        this.f9331a = str;
    }

    public /* synthetic */ Object call() {
        return m12903a();
    }

    /* renamed from: a */
    public Boolean m12903a() {
        if (this.f9332b.f9329a.f9328c.q) {
            return Boolean.valueOf(false);
        }
        if (this.f9332b.f9329a.f9328c.f9305L.containsKey(this.f9331a)) {
            return Boolean.valueOf(false);
        }
        this.f9332b.f9329a.f9328c.m12873b(Arrays.asList(new String[]{this.f9331a}), new aak(this));
        return Boolean.valueOf(true);
    }
}
