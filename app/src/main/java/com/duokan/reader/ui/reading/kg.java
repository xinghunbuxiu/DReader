package com.duokan.reader.ui.reading;

class kg extends Thread {
    /* renamed from: a */
    final /* synthetic */ GifFrameLoader f10497a;

    private kg(GifFrameLoader gifFrameLoader) {
        this.f10497a = gifFrameLoader;
    }

    public void run() {
        while (this.f10497a.f9096a) {
            this.f10497a.f9097c.acquireUninterruptibly();
            synchronized (this.f10497a) {
                for (int i = 0; i < this.f10497a.f9098d.size(); i++) {
                    kf kfVar = (kf) this.f10497a.f9098d.get(i);
                    if (kfVar.f10495d == FrameStatus.MARKED && kfVar.f10494c.mo1395j()) {
                        kfVar.f10493b.eraseColor(0);
                        kfVar.f10494c.mo1400a(kfVar.f10492a, kfVar.f10493b);
                        kfVar.f10495d = FrameStatus.READY;
                    }
                }
            }
        }
    }
}
