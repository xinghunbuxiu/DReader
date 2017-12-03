package com.duokan.reader.domain.bookshelf;

import com.duokan.core.diagnostic.LogLevel;

import java.io.File;

class he implements Runnable {
    final /* synthetic */ File a;
    final /* synthetic */ int b;
    final /* synthetic */ hd c;

    he(hd hdVar, File file, int i) {
        this.c = hdVar;
        this.a = file;
        this.b = i;
    }

    public void run() {
        this.a.getParentFile().mkdirs();
        try {
            a.d(this.a);
            b.a(this.c.b.b, this.a, new com.duokan.core.b.a.a().a(this.b).b(131072));
        } catch (Throwable th) {
            com.duokan.core.diagnostic.a.c().a(LogLevel.ERROR, "epub-l", "fail to download the book " + this.c.b.b, th);
        }
    }
}
