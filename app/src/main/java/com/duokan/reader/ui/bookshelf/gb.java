package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.c.j;
import com.duokan.core.app.x;
import com.duokan.reader.ui.bookshelf.ImportedFileInfo.FileStatus;
import com.duokan.reader.ui.general.be;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

class gb implements OnClickListener {
    final /* synthetic */ Runnable a;
    final /* synthetic */ fy b;

    gb(fy fyVar, Runnable runnable) {
        this.b = fyVar;
        this.a = runnable;
    }

    public void onClick(View view) {
        if (this.b.d > 0) {
            List arrayList = new ArrayList();
            for (gt b : this.b.g) {
                for (ImportedFileInfo importedFileInfo : b.b()) {
                    if (importedFileInfo.f() == FileStatus.SELECTED) {
                        arrayList.add(new File(importedFileInfo.c()));
                    }
                }
            }
            ((cu) x.a(this.b.getContext()).queryFeature(cu.class)).c(arrayList, new gc(this), null);
            return;
        }
        be.a(this.b.getContext(), j.bookshelf__shared__unselect_any_books, 0).show();
    }
}
