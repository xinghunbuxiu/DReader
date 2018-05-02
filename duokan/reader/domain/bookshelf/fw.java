package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.af;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.ConcurrentHashMap;

class fw implements Runnable {
    final /* synthetic */ af a;
    final /* synthetic */ fv b;

    fw(fv fvVar, af afVar) {
        this.b = fvVar;
        this.a = afVar;
    }

    public void run() {
        if (this.b.L == this.a) {
            Object concurrentHashMap = new ConcurrentHashMap();
            for (File name : a.a(this.b.d(), new FileFilter[0])) {
                String name2 = name.getName();
                concurrentHashMap.put(name2, name2);
            }
            this.a.a(concurrentHashMap);
        }
    }
}
