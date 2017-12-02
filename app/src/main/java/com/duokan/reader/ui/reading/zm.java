package com.duokan.reader.ui.reading;

import com.duokan.reader.ui.general.ReaderUi;

class zm implements Runnable {
    final /* synthetic */ zk a;

    zm(zk zkVar) {
        this.a = zkVar;
    }

    public void run() {
        ReaderUi.a(this.a.getContext(), this.a.g);
    }
}
