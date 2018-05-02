package com.duokan.reader.ui.bookshelf;

import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.ui.bookshelf.ImportedFileInfo.FileStatus;
import com.duokan.reader.ui.surfing.af;

import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class fr extends ActivatedController {
    private int a = 0;
    private fy b;
    private gt c = null;
    private List d = new LinkedList();
    private List e = new LinkedList();
    private final Comparator f = new fs(this);

    public fr(IFeature featrue, Runnable runnable) {
        super(featrue);
        this.b = new fy(getContext(), b(), runnable);
        setContentView(this.b);
    }

    private void a() {
        FileScanTask fileScanTask = new FileScanTask();
        this.d.clear();
        fileScanTask.a(getContext(), new ft(this), (File[]) a.a(getContext()).toArray(new File[0]));
        fileScanTask.execute(new String[0]);
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        ((af) getContext().queryFeature(af.class)).n();
        if (z) {
            a();
        }
    }

    protected void onDeactive() {
        super.onDeactive();
        ((af) getContext().queryFeature(af.class)).m();
    }

    private fw b() {
        return new fv(this);
    }

    private void a(List list) {
        if (list != null && list.size() != 0) {
            for (gt a : list) {
                a(a);
            }
            Collections.sort(list, this.f);
        }
    }

    private gt a(gt gtVar) {
        if (gtVar != null) {
            gtVar.a(FileStatus.IMPORTED);
            List<ImportedFileInfo> b = gtVar.b();
            for (ImportedFileInfo importedFileInfo : b) {
                if (ai.a().d(importedFileInfo.c()) == null) {
                    importedFileInfo.a(FileStatus.UNSELECTED);
                    gtVar.a(FileStatus.UNSELECTED);
                } else {
                    importedFileInfo.a(FileStatus.IMPORTED);
                }
            }
            Collections.sort(b, this.f);
        }
        return gtVar;
    }
}
