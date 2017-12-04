package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.TaskHandler;
import com.duokan.core.sys.ag;
import com.duokan.reader.domain.document.epub.av;

import java.util.HashMap;
import java.util.List;

import miuipub.date.Calendar;

class ga implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ ag b;
    final /* synthetic */ fv c;

    ga(fv fvVar, List list, ag agVar) {
        this.c = fvVar;
        this.a = list;
        this.b = agVar;
    }

    public void run() {
        HashMap hashMap = new HashMap();
        for (av put : this.a) {
            hashMap.put(put, Integer.valueOf(-1));
        }
        for (av put2 : this.a) {
            int i;
            int i2 = Calendar.MILLISECOND_OF_SECOND;
            try {
                gz gzVar = (gz) put2;
                i2 = gzVar.b();
                gzVar.c();
                i = i2;
            } catch (InterruptedException e) {
                i = -1;
            } catch (Throwable th) {
                i = i2;
            }
            hashMap.put(put2, Integer.valueOf(i));
        }
        TaskHandler.postTask(new gb(this, hashMap));
    }
}
