package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.c.j;
import com.duokan.core.app.MyContextWrapper;
import com.duokan.reader.ui.bookshelf.ImportedFileInfo.FileStatus;
import com.duokan.reader.ui.general.be;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

class ev implements OnClickListener {
    final /* synthetic */ Runnable a;
    final /* synthetic */ er b;

    ev(er erVar, Runnable runnable) {
        this.b = erVar;
        this.a = runnable;
    }

    public void onClick(View view) {
        if (this.b.b.e() > 0) {
            List arrayList = new ArrayList();
            for (ImportedFileInfo importedFileInfo : this.b.b.b()) {
                if (importedFileInfo.f() == FileStatus.SELECTED) {
                    arrayList.add(new File(importedFileInfo.c()));
                }
            }
            ((cu) MyContextWrapper.getFeature(this.b.getContext()).queryFeature(cu.class)).c(arrayList, this.a, null);
            return;
        }
        be.a(this.b.getContext(), j.bookshelf__shared__unselect_any_books, 0).show();
    }
}
