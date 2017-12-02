package com.duokan.reader.ui.reading;

import java.util.Arrays;
import java.util.concurrent.Callable;

class zy implements Callable {
    final /* synthetic */ String a;
    final /* synthetic */ zu b;

    zy(zu zuVar, String str) {
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
        if (this.b.a.c.Q.containsKey(this.a)) {
            return Boolean.valueOf(false);
        }
        this.b.a.c.a(Arrays.asList(new String[]{this.a}), new zz(this));
        return Boolean.valueOf(true);
    }
}
