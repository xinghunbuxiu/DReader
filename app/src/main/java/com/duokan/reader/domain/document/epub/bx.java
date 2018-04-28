package com.duokan.reader.domain.document.epub;

import android.graphics.Bitmap;
import com.duokan.core.sys.UThread;
import com.duokan.core.sys.ag;
import java.util.concurrent.Callable;

class bx implements Callable<Bitmap> {
    /* renamed from: a */
    final /* synthetic */ ag f4616a;
    /* renamed from: b */
    final /* synthetic */ bu f4617b;

    bx(bu buVar, ag agVar) {
        this.f4617b = buVar;
        this.f4616a = agVar;
    }

    public /* synthetic */ Object call() {
        return m6762a();
    }

    /* renamed from: a */
    public Bitmap m6762a() {
        Bitmap bitmap;
        if (this.f4617b.f4594k) {
            bitmap = null;
        } else {
            bitmap = this.f4617b.m6726a(0, 0, this.f4617b.f4590g.f4599c, this.f4617b.f4590g.f4600d, this.f4617b.f4590g.f4599c, this.f4617b.f4590g.f4600d);
        }
        this.f4617b.f4595l.f4524e.m5842c(this.f4617b.f4595l);
        UThread.runOnThread(new by(this, bitmap));
        return bitmap;
    }
}
