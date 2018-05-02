package com.duokan.reader.ui.general;

import android.graphics.Bitmap;

import com.duokan.reader.common.cache.b;

class c extends b {
    final /* synthetic */ b c;
    private final com.duokan.reader.common.cache.c d;

    public c(b bVar, d dVar) {
        this.c = bVar;
        super(Math.round(dVar.b().width() * dVar.c()), Math.round(dVar.b().height() * dVar.c()), bVar.a);
        this.d = dVar;
    }

    protected void a(Bitmap bitmap) {
        this.c.a(bitmap, this.d.b(), this.d.c());
    }

    protected void m() {
    }
}
