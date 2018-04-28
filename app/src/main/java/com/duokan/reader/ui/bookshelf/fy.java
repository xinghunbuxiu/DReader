package com.duokan.reader.ui.bookshelf;

import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.io.C0336a;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.ui.bookshelf.ImportedFileInfo.FileStatus;
import com.duokan.reader.ui.surfing.al;
import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class fy extends ActivatedController {
    /* renamed from: a */
    private int f6473a = 0;
    /* renamed from: b */
    private gf f6474b;
    /* renamed from: c */
    private ha f6475c = null;
    /* renamed from: d */
    private List<ha> f6476d = new LinkedList();
    /* renamed from: e */
    private List<ha> f6477e = new LinkedList();
    /* renamed from: f */
    private final Comparator<ImportedFileInfo> f6478f = new fz(this);

    public fy(IFeature mFeature, Runnable runnable) {
        super(mFeature);
        this.f6474b = new gf(getContext(), m9648b(), runnable);
        setContentView(this.f6474b);
    }

    /* renamed from: a */
    private void m9646a() {
        FileScanTask fileScanTask = new FileScanTask();
        this.f6476d.clear();
        fileScanTask.m9080a(getContext(), new ga(this), (File[]) C0336a.m774a(getContext()).toArray(new File[0]));
        fileScanTask.execute(new String[0]);
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        ((al) getContext().queryFeature(al.class)).mo2558n();
        if (z) {
            m9646a();
        }
    }

    protected void onDeactive() {
        super.onDeactive();
        ((al) getContext().queryFeature(al.class)).mo2557m();
    }

    /* renamed from: b */
    private gd m9648b() {
        return new gc(this);
    }

    /* renamed from: a */
    private void m9647a(List<ha> list) {
        if (list != null && list.size() != 0) {
            for (ha a : list) {
                m9644a(a);
            }
            Collections.sort(list, this.f6478f);
        }
    }

    /* renamed from: a */
    private ha m9644a(ha haVar) {
        if (haVar != null) {
            haVar.m9083a(FileStatus.IMPORTED);
            List<ImportedFileInfo> b = haVar.m9762b();
            for (ImportedFileInfo importedFileInfo : b) {
                if (ai.m3980a().m3920d(importedFileInfo.m9084c()) == null) {
                    importedFileInfo.m9083a(FileStatus.UNSELECTED);
                    haVar.m9083a(FileStatus.UNSELECTED);
                } else {
                    importedFileInfo.m9083a(FileStatus.IMPORTED);
                }
            }
            Collections.sort(b, this.f6478f);
        }
        return haVar;
    }
}
