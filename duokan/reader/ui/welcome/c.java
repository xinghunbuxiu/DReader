package com.duokan.reader.ui.welcome;

import java.util.TimerTask;

class c extends TimerTask {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public void run() {
        this.a.c.post(new d(this));
    }
}
