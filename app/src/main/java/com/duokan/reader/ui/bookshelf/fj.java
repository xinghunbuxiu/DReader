package com.duokan.reader.ui.bookshelf;

import com.duokan.core.sys.TaskHandler;
import com.duokan.reader.ui.general.dj;

class fj implements dj {
    final /* synthetic */ Runnable a;
    final /* synthetic */ fh b;

    fj(fh fhVar, Runnable runnable) {
        this.b = fhVar;
        this.a = runnable;
    }

    public boolean onBack() {
        TaskHandler.PostTask(this.a);
        return true;
    }
}
