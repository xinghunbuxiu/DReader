package com.duokan.reader.domain.document.epub;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

import com.duokan.core.sys.ag;

import java.util.concurrent.Callable;

class bo implements Callable {
    final /* synthetic */ ag a;
    final /* synthetic */ bm b;

    bo(bm bmVar, ag agVar) {
        this.b = bmVar;
        this.a = agVar;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public Bitmap a() {
        Bitmap c = a.c(this.b.e(), this.b.f(), Config.ARGB_8888);
        this.b.a(0, c);
        if (this.a != null) {
            this.a.a(c);
        }
        return c;
    }
}
