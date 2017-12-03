package com.duokan.reader.ui.bookshelf;

import com.duokan.core.sys.TaskHandler;
import com.duokan.reader.ui.bookshelf.FileScanTask.ErrorCode;

import java.util.List;

class ft implements gm {
    final /* synthetic */ fr a;

    ft(fr frVar) {
        this.a = frVar;
    }

    public void a(gt gtVar) {
        this.a.c = this.a.a(gtVar);
        TaskHandler.postTask(new fu(this));
    }

    public void a(List list, ErrorCode errorCode) {
        if (errorCode == ErrorCode.OK || errorCode == ErrorCode.CANCELED) {
            this.a.e.clear();
            this.a.e = list;
            new fx(this.a).execute(new String[0]);
            this.a.a = 0;
            for (gt gtVar : this.a.e) {
                this.a.a = gtVar.a() + this.a.a;
            }
            return;
        }
        this.a.requestDetach();
    }
}
