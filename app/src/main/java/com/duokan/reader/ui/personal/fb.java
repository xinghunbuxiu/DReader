package com.duokan.reader.ui.personal;

import android.content.Context;

import com.duokan.reader.domain.cloud.p;

class fb implements p {
    final /* synthetic */ Context a;
    final /* synthetic */ mp b;
    final /* synthetic */ fa c;

    fb(fa faVar, Context context, mp mpVar) {
        this.c = faVar;
        this.a = context;
        this.b = mpVar;
    }

    public void a() {
        this.c.c(this.a, this.b);
    }

    public void a(String str) {
        this.b.a(str);
    }
}
