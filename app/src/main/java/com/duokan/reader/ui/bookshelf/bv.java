package com.duokan.reader.ui.bookshelf;

import com.duokan.core.app.ag;
import com.duokan.core.app.ah;
import com.duokan.core.sys.UThread;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.ui.general.ap;
import java.util.List;

class bv implements ah {
    /* renamed from: a */
    final /* synthetic */ int f6217a;
    /* renamed from: b */
    final /* synthetic */ ap f6218b;
    /* renamed from: c */
    final /* synthetic */ List f6219c;
    /* renamed from: d */
    final /* synthetic */ Runnable f6220d;
    /* renamed from: e */
    final /* synthetic */ Runnable f6221e;
    /* renamed from: f */
    final /* synthetic */ bp f6222f;

    bv(bp bpVar, int i, ap apVar, List list, Runnable runnable, Runnable runnable2) {
        this.f6222f = bpVar;
        this.f6217a = i;
        this.f6218b = apVar;
        this.f6219c = list;
        this.f6220d = runnable;
        this.f6221e = runnable2;
    }

    /* renamed from: a */
    public void mo1562a(ag agVar) {
        ai.m3980a().m3915b(this.f6219c, this.f6217a >= 0 ? this.f6218b.isChecked(this.f6217a) : false);
        UThread.runOnThread(this.f6220d);
    }

    /* renamed from: b */
    public void mo1567b(ag agVar) {
        UThread.runOnThread(this.f6221e);
    }

    /* renamed from: c */
    public void mo1565c(ag agVar) {
        UThread.runOnThread(this.f6221e);
    }
}
