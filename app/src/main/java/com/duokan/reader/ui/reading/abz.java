package com.duokan.reader.ui.reading;

import fi.harism.curl.CurlDirection;

class abz implements Runnable {
    /* renamed from: a */
    final /* synthetic */ aby f9434a;

    abz(aby aby) {
        this.f9434a = aby;
    }

    public void run() {
        this.f9434a.f9433a.f9424a.f9382d.onDragStart(this.f9434a.f9433a.f9427e, CurlDirection.PAGE_UP);
        this.f9434a.f9433a.f9424a.f9387i = null;
    }
}
