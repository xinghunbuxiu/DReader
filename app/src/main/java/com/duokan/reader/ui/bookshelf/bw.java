package com.duokan.reader.ui.bookshelf;

import com.duokan.core.app.ag;
import com.duokan.core.app.ah;
import com.duokan.core.sys.UThread;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.an;
import java.util.List;

class bw implements ah {
    /* renamed from: a */
    final /* synthetic */ List f6223a;
    /* renamed from: b */
    final /* synthetic */ Runnable f6224b;
    /* renamed from: c */
    final /* synthetic */ Runnable f6225c;
    /* renamed from: d */
    final /* synthetic */ bp f6226d;

    bw(bp bpVar, List list, Runnable runnable, Runnable runnable2) {
        this.f6226d = bpVar;
        this.f6223a = list;
        this.f6224b = runnable;
        this.f6225c = runnable2;
    }

    /* renamed from: a */
    public void mo1562a(ag agVar) {
        for (an anVar : this.f6223a) {
            if (anVar instanceof C0800c) {
                ((C0800c) anVar).ah();
            }
        }
        UThread.runOnThread(this.f6224b);
    }

    /* renamed from: b */
    public void mo1567b(ag agVar) {
        UThread.runOnThread(this.f6225c);
    }

    /* renamed from: c */
    public void mo1565c(ag agVar) {
        UThread.runOnThread(this.f6225c);
    }
}
