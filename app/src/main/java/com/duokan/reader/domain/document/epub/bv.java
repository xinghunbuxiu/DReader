package com.duokan.reader.domain.document.epub;

import android.graphics.Bitmap;
import com.duokan.core.sys.UThread;
import com.duokan.core.sys.ag;
import java.util.concurrent.Callable;

class bv implements Callable<Bitmap> {
    /* renamed from: a */
    final /* synthetic */ ag f4612a;
    /* renamed from: b */
    final /* synthetic */ bu f4613b;

    bv(bu buVar, ag agVar) {
        this.f4613b = buVar;
        this.f4612a = agVar;
    }

    public /* synthetic */ Object call() {
        return m6761a();
    }

    /* renamed from: a */
    public Bitmap m6761a() {
        Bitmap a = this.f4613b.f4594k ? null : this.f4613b.m6726a(this.f4613b.f4591h.left, this.f4613b.f4591h.top, this.f4613b.f4591h.width(), this.f4613b.f4591h.height(), this.f4613b.f4586c.width(), this.f4613b.f4586c.height());
        this.f4613b.f4595l.f4524e.m5842c(this.f4613b.f4595l);
        UThread.runOnThread(new bw(this, a));
        return a;
    }
}
