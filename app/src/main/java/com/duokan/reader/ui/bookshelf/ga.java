package com.duokan.reader.ui.bookshelf;

import com.duokan.core.sys.UThread;
import com.duokan.reader.ui.bookshelf.FileScanTask.ErrorCode;
import java.util.List;

class ga implements gt {
    /* renamed from: a */
    final /* synthetic */ fy f6497a;

    ga(fy fyVar) {
        this.f6497a = fyVar;
    }

    /* renamed from: a */
    public void mo1708a(ha haVar) {
        this.f6497a.f6475c = this.f6497a.m9644a(haVar);
        UThread.runOnThread(new gb(this));
    }

    /* renamed from: a */
    public void mo1709a(List<ha> list, ErrorCode errorCode) {
        if (errorCode == ErrorCode.OK || errorCode == ErrorCode.CANCELED) {
            this.f6497a.f6477e.clear();
            this.f6497a.f6477e = list;
            new ge(this.f6497a).execute(new String[0]);
            this.f6497a.f6473a = 0;
            for (ha haVar : this.f6497a.f6477e) {
                this.f6497a.f6473a = haVar.m9760a() + this.f6497a.f6473a;
            }
            return;
        }
        this.f6497a.requestDetach();
    }
}
