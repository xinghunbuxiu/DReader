package com.duokan.reader.ui.reading;

import java.util.Arrays;
import java.util.concurrent.Callable;

class zw implements Callable {
    final /* synthetic */ String a;
    final /* synthetic */ zu b;

    zw(zu zuVar, String str) {
        this.b = zuVar;
        this.a = str;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public Boolean a() {
        if (this.b.a.c.q) {
            return Boolean.valueOf(false);
        }
        if (this.b.a.c.L.containsKey(this.a)) {
            return Boolean.valueOf(false);
        }
        this.b.a.c.b(Arrays.asList(new String[]{this.a}), new zx(this));
        return Boolean.valueOf(true);
    }
}
