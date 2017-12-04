package com.duokan.reader.domain.social.message;

class ae implements Runnable {
    final /* synthetic */ DkMessagesManager a;

    ae(DkMessagesManager dkMessagesManager) {
        this.a = dkMessagesManager;
    }

    public void run() {
        this.a.g.a(this.a);
        this.a.c.add(this.a.h);
        this.a.g();
    }
}
