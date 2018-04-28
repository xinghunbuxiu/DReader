package com.duokan.reader.ui.bookshelf;

import com.duokan.core.app.C0301c;
import com.duokan.core.app.OnCancelListener;

class gr implements OnCancelListener {
    /* renamed from: a */
    final /* synthetic */ FileScanTask f6526a;

    gr(FileScanTask fileScanTask) {
        this.f6526a = fileScanTask;
    }

    public void onCancel(C0301c c0301c) {
        this.f6526a.cancel(true);
    }
}
