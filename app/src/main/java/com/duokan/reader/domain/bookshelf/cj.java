package com.duokan.reader.domain.bookshelf;

import java.util.Arrays;

class cj implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ String b;
    final /* synthetic */ bv c;

    cj(bv bvVar, int i, String str) {
        this.c = bvVar;
        this.a = i;
        this.b = str;
    }

    public void run() {
        if (this.c.c.c() && this.a != -1) {
            bu a = this.c.a(this.c.d, this.a, this.b, System.currentTimeMillis());
            this.c.a(Arrays.asList(new bu[]{a}));
        }
    }
}
