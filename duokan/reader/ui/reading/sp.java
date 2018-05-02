package com.duokan.reader.ui.reading;

class sp implements Runnable {
    final /* synthetic */ si a;

    sp(si siVar) {
        this.a = siVar;
    }

    public void run() {
        this.a.dismissPopup(this.a.e);
        this.a.c = false;
        this.a.d = false;
    }
}
