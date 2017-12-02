package com.duokan.reader.ui.welcome;

class h implements Runnable {
    final /* synthetic */ g a;

    h(g gVar) {
        this.a = gVar;
    }

    public void run() {
        if (this.a.getVisibility() == 0) {
            this.a.a();
        }
    }
}
