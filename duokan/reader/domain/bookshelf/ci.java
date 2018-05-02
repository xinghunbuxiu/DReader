package com.duokan.reader.domain.bookshelf;

import java.util.Arrays;

class ci implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ bv d;

    ci(bv bvVar, int i, String str, String str2) {
        this.d = bvVar;
        this.a = i;
        this.b = str;
        this.c = str2;
    }

    public void run() {
        if (this.d.c.c() && this.a != -1) {
            bu a = this.d.a(this.d.d, this.a, this.b, this.c, System.currentTimeMillis());
            this.d.a(Arrays.asList(new bu[]{a}));
        }
    }
}
