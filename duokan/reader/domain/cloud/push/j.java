package com.duokan.reader.domain.cloud.push;

import com.duokan.reader.domain.social.message.ax;
import com.duokan.reader.domain.social.message.k;

class j implements ax {
    final /* synthetic */ long a;
    final /* synthetic */ r b;
    final /* synthetic */ b c;

    j(b bVar, long j, r rVar) {
        this.c = bVar;
        this.a = j;
        this.b = rVar;
    }

    public void a(k[] kVarArr, boolean z) {
        this.c.a(this.a, kVarArr, z, this.b);
    }

    public void a(k[] kVarArr, String str) {
        this.c.a(this.a, kVarArr, false, this.b);
    }
}
