package com.duokan.reader.ui.reading;

class aer implements Runnable {
    /* renamed from: a */
    final /* synthetic */ adz f9593a;

    aer(adz adz) {
        this.f9593a = adz;
    }

    public void run() {
        this.f9593a.removeSubController(this.f9593a.f9551k);
        this.f9593a.f9543c.removeView(this.f9593a.f9551k.getContentView());
        this.f9593a.f9551k = null;
    }
}
