package com.duokan.reader.ui.reading;

class gb implements Runnable {
    final /* synthetic */ float a;
    final /* synthetic */ ga b;

    gb(ga gaVar, float f) {
        this.b = gaVar;
        this.a = f;
    }

    public void run() {
        this.b.f.setMinZoomFactor(this.a);
    }
}
