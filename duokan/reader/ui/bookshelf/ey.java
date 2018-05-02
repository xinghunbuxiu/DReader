package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.ui.bookshelf.ImportedFileInfo.FileStatus;

class ey implements OnClickListener {
    final /* synthetic */ int a;
    final /* synthetic */ ex b;

    ey(ex exVar, int i) {
        this.b = exVar;
        this.a = i;
    }

    public void onClick(View view) {
        ImportedFileInfo c = this.b.c(this.a);
        if (c.f() == FileStatus.SELECTED) {
            c.a(FileStatus.UNSELECTED);
        } else {
            c.a(FileStatus.SELECTED);
        }
        this.b.d();
    }
}
