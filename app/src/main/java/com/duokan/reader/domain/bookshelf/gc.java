package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.ag;
import com.duokan.core.sys.TaskHandler;
import com.duokan.reader.domain.document.epub.av;

import java.util.HashMap;

import miuipub.date.Calendar;

class gc implements Runnable {
    final /* synthetic */ av a;
    final /* synthetic */ ag b;
    final /* synthetic */ fv c;

    gc(fv fvVar, av avVar, ag agVar) {
        this.c = fvVar;
        this.a = avVar;
        this.b = agVar;
    }

    public void run() {
        int i;
        HashMap hashMap = new HashMap();
        hashMap.put(this.a, Integer.valueOf(-1));
        int i2 = Calendar.MILLISECOND_OF_SECOND;
        try {
            gz gzVar = (gz) this.a;
            i2 = gzVar.b();
            gzVar.c();
            i = i2;
        } catch (InterruptedException e) {
            i = -1;
        } catch (Throwable th) {
            i = i2;
        }
        hashMap.put(this.a, Integer.valueOf(i));
        TaskHandler.postTask(new gd(this, hashMap));
    }
}
