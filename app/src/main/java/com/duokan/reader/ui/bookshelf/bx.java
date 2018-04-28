package com.duokan.reader.ui.bookshelf;

import com.duokan.core.app.ac;
import com.duokan.core.app.ad;
import com.duokan.core.sys.UThread;
import com.duokan.core.sys.ah;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ui.general.ap;
import com.duokan.reader.ui.general.ja;
import java.util.List;

class bx implements ad {
    /* renamed from: a */
    final /* synthetic */ ap f6227a;
    /* renamed from: b */
    final /* synthetic */ int f6228b;
    /* renamed from: c */
    final /* synthetic */ List f6229c;
    /* renamed from: d */
    final /* synthetic */ Runnable f6230d;
    /* renamed from: e */
    final /* synthetic */ Runnable f6231e;
    /* renamed from: f */
    final /* synthetic */ bp f6232f;

    bx(bp bpVar, ap apVar, int i, List list, Runnable runnable, Runnable runnable2) {
        this.f6232f = bpVar;
        this.f6227a = apVar;
        this.f6228b = i;
        this.f6229c = list;
        this.f6230d = runnable;
        this.f6231e = runnable2;
    }

    /* renamed from: a */
    public void mo1553a(ac acVar) {
        ah.m871b(new by(this, this.f6227a.isChecked(this.f6228b), ja.m10830a(this.f6232f.getContext(), null, this.f6232f.getString(C0258j.importing))));
    }

    /* renamed from: b */
    public void mo1554b(ac acVar) {
        this.f6227a.dismiss();
        UThread.post(this.f6231e);
    }
}
