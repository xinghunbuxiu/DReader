package com.duokan.reader.domain.bookshelf;

import com.duokan.core.io.C0336a;
import com.duokan.core.sys.af;
import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.ConcurrentHashMap;

class fq implements Runnable {
    /* renamed from: a */
    final /* synthetic */ af f3193a;
    /* renamed from: b */
    final /* synthetic */ fp f3194b;

    fq(fp fpVar, af afVar) {
        this.f3194b = fpVar;
        this.f3193a = afVar;
    }

    public void run() {
        if (this.f3194b.f3186L == this.f3193a) {
            Object concurrentHashMap = new ConcurrentHashMap();
            for (File name : C0336a.m776a(this.f3194b.m4219d(), new FileFilter[0])) {
                String name2 = name.getName();
                concurrentHashMap.put(name2, name2);
            }
            this.f3193a.mo975a(concurrentHashMap);
        }
    }
}
