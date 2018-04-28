package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.UThread;
import com.duokan.core.sys.ag;
import com.duokan.reader.domain.document.epub.av;
import java.util.HashMap;
import java.util.List;

class fu implements Runnable {
    /* renamed from: a */
    final /* synthetic */ List f3200a;
    /* renamed from: b */
    final /* synthetic */ ag f3201b;
    /* renamed from: c */
    final /* synthetic */ fp f3202c;

    fu(fp fpVar, List list, ag agVar) {
        this.f3202c = fpVar;
        this.f3200a = list;
        this.f3201b = agVar;
    }

    public void run() {
        HashMap hashMap = new HashMap();
        for (av put : this.f3200a) {
            hashMap.put(put, Integer.valueOf(-1));
        }
        for (av put2 : this.f3200a) {
            int i;
            int i2 = 1000;
            try {
                gt gtVar = (gt) put2;
                i2 = gtVar.m4578b();
                gtVar.m4579c();
                i = i2;
            } catch (InterruptedException e) {
                i = -1;
            } catch (Throwable th) {
                i = i2;
            }
            hashMap.put(put2, Integer.valueOf(i));
        }
        UThread.runOnThread(new fv(this, hashMap));
    }
}
