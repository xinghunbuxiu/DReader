package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.ag;
import java.util.Iterator;

class et implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ev f3127a;
    /* renamed from: b */
    final /* synthetic */ ee f3128b;

    et(ee eeVar, ev evVar) {
        this.f3128b = eeVar;
        this.f3127a = evVar;
    }

    public void run() {
        Iterator it = this.f3127a.f3137f.iterator();
        while (it.hasNext()) {
            ((ag) it.next()).run(Integer.valueOf(this.f3127a.f3139h));
        }
    }
}
