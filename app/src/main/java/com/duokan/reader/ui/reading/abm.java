package com.duokan.reader.ui.reading;

class abm implements Runnable {
    /* renamed from: a */
    final /* synthetic */ abg f9399a;

    abm(abg abg) {
        this.f9399a = abg;
    }

    public void run() {
        if (this.f9399a.f9391a.f9387i != null) {
            this.f9399a.f9391a.f9387i.run();
            this.f9399a.f9391a.f9387i = null;
        }
    }
}
