package com.duokan.reader.ui.general;

class cz implements Runnable {
    /* renamed from: a */
    final /* synthetic */ int f7052a;
    /* renamed from: b */
    final /* synthetic */ cy f7053b;

    cz(cy cyVar, int i) {
        this.f7053b = cyVar;
        this.f7052a = i;
    }

    public void run() {
        this.f7053b.f6454d.setShowingChild(this.f7052a);
    }
}
