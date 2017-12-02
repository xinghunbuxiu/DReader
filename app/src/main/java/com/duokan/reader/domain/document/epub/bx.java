package com.duokan.reader.domain.document.epub;

import android.graphics.Bitmap;

import com.duokan.core.sys.ag;
import com.duokan.core.sys.t;

import java.util.concurrent.Callable;

class bx implements Callable {
    final /* synthetic */ ag a;
    final /* synthetic */ bu b;

    bx(bu buVar, ag agVar) {
        this.b = buVar;
        this.a = agVar;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public Bitmap a() {
        Bitmap bitmap;
        if (this.b.k) {
            bitmap = null;
        } else {
            bitmap = this.b.a(0, 0, this.b.g.c, this.b.g.d, this.b.g.c, this.b.g.d);
        }
        this.b.l.e.c(this.b.l);
        t.a(new by(this, bitmap));
        return bitmap;
    }
}
