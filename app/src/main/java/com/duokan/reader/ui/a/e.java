package com.duokan.reader.ui.a;

class e implements Runnable {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    public void run() {
        if (this.a.a.l != null) {
            this.a.a.l.setCancelOnBack(true);
        }
    }
}
