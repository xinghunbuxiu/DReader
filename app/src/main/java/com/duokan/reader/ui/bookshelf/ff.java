package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.ui.bookshelf.ImportedFileInfo.FileStatus;

class ff implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ int f6440a;
    /* renamed from: b */
    final /* synthetic */ fe f6441b;

    ff(fe feVar, int i) {
        this.f6441b = feVar;
        this.f6440a = i;
    }

    public void onClick(View view) {
        ImportedFileInfo c = this.f6441b.m9607c(this.f6440a);
        if (c.m9087f() == FileStatus.SELECTED) {
            c.m9083a(FileStatus.UNSELECTED);
        } else {
            c.m9083a(FileStatus.SELECTED);
        }
        this.f6441b.mo1691d();
    }
}
