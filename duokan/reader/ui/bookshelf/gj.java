package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;

class gj implements OnClickListener {
    final /* synthetic */ FileScanTask a;

    gj(FileScanTask fileScanTask) {
        this.a = fileScanTask;
    }

    public void onClick(View view) {
        this.a.cancel(true);
    }
}
