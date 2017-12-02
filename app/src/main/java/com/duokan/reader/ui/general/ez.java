package com.duokan.reader.ui.general;

class ez implements Runnable {
    final /* synthetic */ ew a;

    ez(ew ewVar) {
        this.a = ewVar;
    }

    public void run() {
        ReaderUi.a(this.a.getContext(), this.a.e);
    }
}
