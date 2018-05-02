package com.duokan.reader.ui.reading;

class ak implements Runnable {
    final /* synthetic */ ai a;

    ak(ai aiVar) {
        this.a = aiVar;
    }

    public void run() {
        this.a.dismissPopup(this.a.c);
        this.a.c = null;
    }
}
