package com.duokan.reader.common.download;

/* renamed from: com.duokan.reader.common.download.m */
class C0603m implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0604n f2015a;
    /* renamed from: b */
    final /* synthetic */ HttpDownloadBlock f2016b;

    C0603m(HttpDownloadBlock httpDownloadBlock, C0604n c0604n) {
        this.f2016b = httpDownloadBlock;
        this.f2015a = c0604n;
    }

    public void run() {
        this.f2015a.f2020d.abort();
    }
}
