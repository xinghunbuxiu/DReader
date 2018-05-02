package com.duokan.reader.ui.bookshelf;

class am implements Runnable {
    final /* synthetic */ ai a;

    am(ai aiVar) {
        this.a = aiVar;
    }

    public void run() {
        this.a.requestDetach();
    }
}
