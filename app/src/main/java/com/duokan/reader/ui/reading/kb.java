package com.duokan.reader.ui.reading;

class kb implements Runnable {
    final /* synthetic */ jz a;

    kb(jz jzVar) {
        this.a = jzVar;
    }

    public void run() {
        GifFrameLoader.a().a(this.a.f, 0, this.a.e.width(), this.a.e.height());
        this.a.k.run();
    }
}
