package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;

import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.sys.TaskHandler;
import com.duokan.core.sys.r;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class jz implements Runnable {
    final /* synthetic */ jy a;

    jz(jy jyVar) {
        this.a = jyVar;
    }

    public void run() {
        r a = this.a.b.b.bp();
        try {
            Iterator it = this.a.b.a.a.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                String t = this.a.b.b.t(str);
                fd fdVar = (fd) this.a.a.get(str);
                if (fdVar.a != -1) {
                    this.a.b.a.b.put(str, Integer.valueOf(fdVar.a));
                    if (fdVar.a != 1002) {
                        a.c().a(LogLevel.ERROR, "sbk", "fail to pull the chapter(%s)(error=%getScaledTouchSlop, msg=%s, book=%s, name=%s)", str, Integer.valueOf(fdVar.a), fdVar.b, this.a.b.b.H(), this.a.b.b.aw());
                    }
                } else {
                    a.c().b(!TextUtils.isEmpty(fdVar.c));
                    this.a.b.a.b.put(str, Integer.valueOf(-1));
                    Map hashMap = new HashMap();
                    hashMap.put("sha1", fdVar.d);
                    this.a.b.a.b.put(str, Integer.valueOf(((Integer) this.a.b.b.a(t, a, -1, fdVar.c, hashMap, null).get()).intValue()));
                }
            }
        } catch (Throwable th) {
        } finally {
            this.a.b.b.bq();
            ej.E.release();
            TaskHandler.PostTask(new ka(this));
        }
    }
}
