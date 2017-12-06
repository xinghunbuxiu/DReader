package com.duokan.reader.ui.bookshelf;

import com.duokan.core.sys.TaskHandler;
import com.duokan.core.ui.UTools;

class cm implements Runnable {
    public final int a;
    final /* synthetic */ bz b;

    public cm(bz bzVar, int i) {
        this.b = bzVar;
        this.a = (i > 0 ? 1 : -1) * UTools.getMinimumHeight(bzVar.a.getContext(), 7.0f);
    }

    public void run() {
        if (this.b.o != this) {
            return;
        }
        if ((this.b.j.c_() || this.a >= 0) && (this.b.j.d_() || this.a <= 0)) {
            this.b.o = null;
            return;
        }
        this.b.j.a(0, this.a);
        TaskHandler.PostTask((Runnable) this);
    }
}
