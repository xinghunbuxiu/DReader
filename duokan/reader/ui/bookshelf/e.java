package com.duokan.reader.ui.bookshelf;

import com.duokan.core.ui.UTools;

class e implements Runnable {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    public void run() {
        if (this.a.a.a != null) {
            this.a.a.a.e();
        }
        UTools.showAnimation(this.a.a.b, new f(this));
    }
}
