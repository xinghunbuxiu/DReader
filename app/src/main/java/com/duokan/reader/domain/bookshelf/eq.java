package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.ag;
import java.util.Map;

class eq implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ag f3116a;
    /* renamed from: b */
    final /* synthetic */ Map f3117b;
    /* renamed from: c */
    final /* synthetic */ ee f3118c;

    eq(ee eeVar, ag agVar, Map map) {
        this.f3118c = eeVar;
        this.f3116a = agVar;
        this.f3117b = map;
    }

    public void run() {
        if (this.f3116a != null) {
            this.f3116a.run(this.f3117b);
        }
    }
}
