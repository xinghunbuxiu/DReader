package com.duokan.reader.ui.reading;

class kl implements Runnable {
    /* renamed from: a */
    final /* synthetic */ kj f10510a;

    kl(kj kjVar) {
        this.f10510a = kjVar;
    }

    public void run() {
        GifFrameLoader.m12418a().m12423a(this.f10510a.f10503f, 0, this.f10510a.f10502e.width(), this.f10510a.f10502e.height());
        this.f10510a.f10508k.run();
    }
}
