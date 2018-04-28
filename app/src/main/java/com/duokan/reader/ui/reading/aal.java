package com.duokan.reader.ui.reading;

import java.util.Arrays;
import java.util.concurrent.Callable;

class aal implements Callable<Boolean> {
    /* renamed from: a */
    final /* synthetic */ String f9334a;
    /* renamed from: b */
    final /* synthetic */ aah f9335b;

    aal(aah aah, String str) {
        this.f9335b = aah;
        this.f9334a = str;
    }

    public /* synthetic */ Object call() {
        return m12905a();
    }

    /* renamed from: a */
    public Boolean m12905a() {
        if (this.f9335b.f9329a.f9328c.q) {
            return Boolean.valueOf(false);
        }
        if (this.f9335b.f9329a.f9328c.f9310Q.containsKey(this.f9334a)) {
            return Boolean.valueOf(false);
        }
        this.f9335b.f9329a.f9328c.m12895a(Arrays.asList(new String[]{this.f9334a}), new aam(this));
        return Boolean.valueOf(true);
    }
}
