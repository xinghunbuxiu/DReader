package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.UThread;
import com.duokan.core.sys.ag;
import com.duokan.reader.domain.document.epub.av;
import java.util.HashMap;

class fw implements Runnable {
    /* renamed from: a */
    final /* synthetic */ av f3205a;
    /* renamed from: b */
    final /* synthetic */ ag f3206b;
    /* renamed from: c */
    final /* synthetic */ fp f3207c;

    fw(fp fpVar, av avVar, ag agVar) {
        this.f3207c = fpVar;
        this.f3205a = avVar;
        this.f3206b = agVar;
    }

    public void run() {
        int i;
        HashMap hashMap = new HashMap();
        hashMap.put(this.f3205a, Integer.valueOf(-1));
        int i2 = 1000;
        try {
            gt gtVar = (gt) this.f3205a;
            i2 = gtVar.m4578b();
            gtVar.m4579c();
            i = i2;
        } catch (InterruptedException e) {
            i = -1;
        } catch (Throwable th) {
            i = i2;
        }
        hashMap.put(this.f3205a, Integer.valueOf(i));
        UThread.runOnThread(new fx(this, hashMap));
    }
}
