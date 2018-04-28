package com.duokan.reader.ui.bookshelf;

class cv implements Runnable {
    /* renamed from: a */
    final /* synthetic */ cs f6311a;

    cv(cs csVar) {
        this.f6311a = csVar;
    }

    public void run() {
        if (!this.f6311a.f6299i.hasEnded()) {
            this.f6311a.getChildAt(0).invalidate();
            this.f6311a.invalidate();
            this.f6311a.post(this);
        }
        if (this.f6311a.f6299i.hasEnded() && this.f6311a.f6302l != null) {
            this.f6311a.f6302l.run();
            this.f6311a.f6302l = null;
            this.f6311a.f6298h.setEmpty();
        }
    }
}
