package com.duokan.reader.domain.document.epub;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.duokan.core.sys.ag;
import com.duokan.reader.common.bitmap.C0544a;
import java.util.concurrent.Callable;

class bo implements Callable<Bitmap> {
    /* renamed from: a */
    final /* synthetic */ ag f4578a;
    /* renamed from: b */
    final /* synthetic */ bm f4579b;

    bo(bm bmVar, ag agVar) {
        this.f4579b = bmVar;
        this.f4578a = agVar;
    }

    public /* synthetic */ Object call() {
        return m6722a();
    }

    /* renamed from: a */
    public Bitmap m6722a() {
        Bitmap c = C0544a.m2447c(this.f4579b.mo1390e(), this.f4579b.mo1391f(), Config.ARGB_8888);
        this.f4579b.mo1400a(0, c);
        if (this.f4578a != null) {
            this.f4578a.run(c);
        }
        return c;
    }
}
