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

class fc implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ Runnable f6432a;
    /* renamed from: b */
    final /* synthetic */ ey f6433b;

    fc(ey eyVar, Runnable runnable) {
        this.f6433b = eyVar;
        this.f6432a = runnable;
    }

    public void onClick(View view) {
        if (this.f6433b.f6421b.m9599e() > 0) {
            List arrayList = new ArrayList();
            for (ImportedFileInfo importedFileInfo : this.f6433b.f6421b.m9605b()) {
                if (importedFileInfo.m9087f() == FileStatus.SELECTED) {
                    arrayList.add(new File(importedFileInfo.m9084c()));
                }
            }
            ((cz) AppContext.getAppContext(this.f6433b.getContext()).queryFeature(cz.class)).mo1659c(arrayList, this.f6432a, null);
            return;
        }
        be.m10286a(this.f6433b.getContext(), C0258j.bookshelf__shared__unselect_any_books, 0).show();
    }
}
