package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.r;
import com.duokan.core.sys.t;
import com.duokan.reader.common.c.f;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class kc implements Runnable {
    final /* synthetic */ kb a;

    kc(kb kbVar) {
        this.a = kbVar;
    }

    public void run() {
        r a = this.a.c.bp();
        try {
            Iterator it = this.a.a.a.iterator();
            while (it.hasNext()) {
                int i;
                String str = (String) it.next();
                km y = this.a.c.y(str);
                if (this.a.b && f.b().c()) {
                    i = 1004;
                } else {
                    Map hashMap = new HashMap();
                    hashMap.put("md5", y.d);
                    i = ((Integer) this.a.c.a(y.b, a, y.e, y.c, hashMap, null).get()).intValue();
                }
                this.a.a.b.put(str, Integer.valueOf(i));
            }
        } catch (Throwable th) {
        } finally {
            this.a.c.bq();
            ej.E.release();
            t.b(new kd(this));
        }
    }
}
