package com.duokan.reader.domain.document.epub;

import android.graphics.Bitmap;

import com.duokan.core.sys.ag;
import com.duokan.core.sys.TaskHandler;

import java.util.concurrent.Callable;

class bv implements Callable {
    final /* synthetic */ ag a;
    final /* synthetic */ bu b;

    bv(bu buVar, ag agVar) {
        this.b = buVar;
        this.a = agVar;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public Bitmap a() {
        Bitmap a = this.b.k ? null : this.b.a(this.b.h.left, this.b.h.top, this.b.h.width(), this.b.h.height(), this.b.c.width(), this.b.c.height());
        this.b.l.e.c(this.b.l);
        TaskHandler.postTask(new bw(this, a));
        return a;
    }
}
