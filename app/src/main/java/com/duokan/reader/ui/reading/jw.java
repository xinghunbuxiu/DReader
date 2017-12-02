package com.duokan.reader.ui.reading;

class jw extends Thread {
    final /* synthetic */ GifFrameLoader a;

    private jw(GifFrameLoader gifFrameLoader) {
        this.a = gifFrameLoader;
    }

    public void run() {
        while (this.a.a) {
            this.a.c.acquireUninterruptibly();
            synchronized (this.a) {
                for (int i = 0; i < this.a.d.size(); i++) {
                    jv jvVar = (jv) this.a.d.get(i);
                    if (jvVar.d == FrameStatus.MARKED && jvVar.c.j()) {
                        jvVar.b.eraseColor(0);
                        jvVar.c.a(jvVar.a, jvVar.b);
                        jvVar.d = FrameStatus.READY;
                    }
                }
            }
        }
    }
}
