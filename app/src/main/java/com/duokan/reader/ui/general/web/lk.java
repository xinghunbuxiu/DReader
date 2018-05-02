package com.duokan.reader.ui.general.web;

import android.content.Context;
import com.duokan.reader.ui.general.ap;

class lk extends ap {
    /* renamed from: a */
    final /* synthetic */ Runnable f8151a;
    /* renamed from: b */
    final /* synthetic */ Runnable f8152b;
    /* renamed from: c */
    final /* synthetic */ lj f8153c;

    lk(lj ljVar, Context context, Runnable runnable, Runnable runnable2) {
        this.f8153c = ljVar;
        this.f8151a = runnable;
        this.f8152b = runnable2;
        super(context);
    }

    protected void onOk() {
        super.onOk();
        this.f8151a.run();
    }

    protected void onCancel() {
        super.onCancel();
        this.f8152b.run();
    }
}
