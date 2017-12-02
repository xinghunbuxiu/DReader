package com.duokan.reader.ui.bookshelf;

class fu implements Runnable {
    final /* synthetic */ ft a;

    fu(ft ftVar) {
        this.a = ftVar;
    }

    public void run() {
        if (this.a.a.c != null && !this.a.a.d.contains(this.a.a.c)) {
            this.a.a.d.add(this.a.a.c);
            this.a.a.b.a(this.a.a.d);
        }
    }
}
