package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;

class gq implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ FileScanTask f6525a;

    gq(FileScanTask fileScanTask) {
        this.f6525a = fileScanTask;
    }

    public void onClick(View view) {
        this.f6525a.cancel(true);
    }
}
