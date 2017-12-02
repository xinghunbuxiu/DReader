package com.duokan.reader.ui.bookshelf;

class cq implements Runnable {
    final /* synthetic */ cn a;

    cq(cn cnVar) {
        this.a = cnVar;
    }

    public void run() {
        if (!this.a.i.hasEnded()) {
            this.a.getChildAt(0).invalidate();
            this.a.invalidate();
            this.a.post(this);
        }
        if (this.a.i.hasEnded() && this.a.l != null) {
            this.a.l.run();
            this.a.l = null;
            this.a.h.setEmpty();
        }
    }
}
