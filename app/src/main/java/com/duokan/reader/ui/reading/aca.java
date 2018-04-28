package com.duokan.reader.ui.reading;

import fi.harism.curl.CurlDirection;

class aca implements Runnable {
    /* renamed from: a */
    final /* synthetic */ aby f9436a;

    aca(aby aby) {
        this.f9436a = aby;
    }

    public void run() {
        this.f9436a.f9433a.f9424a.f9382d.onDragStart(this.f9436a.f9433a.f9427e, CurlDirection.PAGE_DOWN);
        this.f9436a.f9433a.f9424a.f9387i = null;
    }
}
