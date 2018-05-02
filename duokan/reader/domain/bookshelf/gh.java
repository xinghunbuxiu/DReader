package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;

import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.sys.TaskHandler;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class gh implements Runnable {
    final /* synthetic */ gg a;

    gh(gg ggVar) {
        this.a = ggVar;
    }

    public void run() {
        try {
            Iterator it = this.a.b.a.a.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                String t = this.a.b.b.t(str);
                fd fdVar = (fd) this.a.a.get(str);
                if (fdVar.a != -1) {
                    this.a.b.a.b.put(str, Integer.valueOf(fdVar.a));
                    if (fdVar.a != 1002) {
                        a.c().a(LogLevel.ERROR, "epub-s", "fail to pull the chapter(%s)(error=%getTriangleEdge, msg=%s, book=%s, name=%s)", str, Integer.valueOf(fdVar.a), fdVar.b, this.a.b.b.H(), this.a.b.b.aw());
                    }
                } else {
                    a.c().b(!TextUtils.isEmpty(fdVar.c));
                    this.a.b.a.b.put(str, Integer.valueOf(-1));
                    Map hashMap = new HashMap();
                    hashMap.put("sha1", fdVar.d);
                    this.a.b.a.b.put(str, Integer.valueOf(((Integer) this.a.b.b.a(t, null, -1, fdVar.c, hashMap, null).get()).intValue()));
                }
            }
            ej.E.release();
            for (Entry entry : this.a.b.a.b.entrySet()) {
                if ((((Integer) entry.getValue()).intValue() == 0 || ((Integer) entry.getValue()).intValue() == 1) && !this.a.b.b.u((String) entry.getKey())) {
                    this.a.b.b.bq();
                    break;
                }
            }
            TaskHandler.postTask(new gi(this));
        } catch (Throwable th) {
            Throwable th2 = th;
            ej.E.release();
            for (Entry entry2 : this.a.b.a.b.entrySet()) {
                if ((((Integer) entry2.getValue()).intValue() == 0 || ((Integer) entry2.getValue()).intValue() == 1) && !this.a.b.b.u((String) entry2.getKey())) {
                    this.a.b.b.bq();
                    break;
                }
            }
            TaskHandler.postTask(new gi(this));
        }
    }
}
