package com.duokan.reader.ui.bookshelf;

import com.duokan.core.app.c;
import com.duokan.core.app.d;

class gk implements d {
    final /* synthetic */ FileScanTask a;

    gk(FileScanTask fileScanTask) {
        this.a = fileScanTask;
    }

    public void onCancel(c cVar) {
        this.a.cancel(true);
    }
}
