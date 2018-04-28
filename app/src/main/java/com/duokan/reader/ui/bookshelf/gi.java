package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.core.app.AppContext;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ui.bookshelf.ImportedFileInfo.FileStatus;
import com.duokan.reader.ui.general.be;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

class gi implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ Runnable f6514a;
    /* renamed from: b */
    final /* synthetic */ gf f6515b;

    gi(gf gfVar, Runnable runnable) {
        this.f6515b = gfVar;
        this.f6514a = runnable;
    }

    public void onClick(View view) {
        if (this.f6515b.f6505d > 0) {
            List arrayList = new ArrayList();
            for (ha b : this.f6515b.f6508g) {
                for (ImportedFileInfo importedFileInfo : b.m9762b()) {
                    if (importedFileInfo.m9087f() == FileStatus.SELECTED) {
                        arrayList.add(new File(importedFileInfo.m9084c()));
                    }
                }
            }
            ((cz) AppContext.getAppContext(this.f6515b.getContext()).queryFeature(cz.class)).mo1659c(arrayList, new gj(this), null);
            return;
        }
        be.m10286a(this.f6515b.getContext(), C0258j.bookshelf__shared__unselect_any_books, 0).show();
    }
}
