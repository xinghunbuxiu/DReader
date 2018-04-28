package com.duokan.reader.ui.reading;

class abl implements Runnable {
    /* renamed from: a */
    final /* synthetic */ abg f9398a;

    abl(abg abg) {
        this.f9398a = abg;
    }

    public void run() {
        if (this.f9398a.f9391a.f9388j != null) {
            this.f9398a.f9391a.f9388j.run();
            this.f9398a.f9391a.f9388j = null;
        }
    }
}
