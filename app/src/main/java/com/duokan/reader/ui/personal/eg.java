package com.duokan.reader.ui.personal;

class eg implements Runnable {
    final /* synthetic */ ds a;

    eg(ds dsVar) {
        this.a = dsVar;
    }

    public void run() {
        if (this.a.b != null && this.a.isDelayedRunnableOnActive(this)) {
            this.a.b.i();
        }
    }
}
