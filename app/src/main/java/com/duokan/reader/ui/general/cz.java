package com.duokan.reader.ui.general;

class cz implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ cy b;

    cz(cy cyVar, int i) {
        this.b = cyVar;
        this.a = i;
    }

    public void run() {
        this.b.d.setShowingChild(this.a);
    }
}
