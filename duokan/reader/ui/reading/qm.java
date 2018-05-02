package com.duokan.reader.ui.reading;

class qm implements Runnable {
    final /* synthetic */ qj a;

    qm(qj qjVar) {
        this.a = qjVar;
    }

    public void run() {
        if (!this.a.a.q && this.a.a.J != null) {
            this.a.a.J.j();
        }
    }
}
