package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.document.g;

class tm implements Runnable {
    final /* synthetic */ tl a;

    tm(tl tlVar) {
        this.a = tlVar;
    }

    public void run() {
        if (!this.a.c.f.K()) {
            g b = this.a.b.h().b(this.a.a);
            if (b != null) {
                this.a.c.q.setText(b.e());
            } else {
                this.a.c.q.setText(this.a.c.f.G().aw());
            }
        }
    }
}
