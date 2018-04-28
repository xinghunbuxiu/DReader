package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.ec;
import com.duokan.reader.ui.general.ap;

class cx extends ap {
    /* renamed from: a */
    final /* synthetic */ C0800c f6316a;
    /* renamed from: b */
    final /* synthetic */ ec f6317b;
    /* renamed from: c */
    final /* synthetic */ cw f6318c;

    cx(cw cwVar, Context context, C0800c c0800c, ec ecVar) {
        this.f6318c = cwVar;
        this.f6316a = c0800c;
        this.f6317b = ecVar;
        super(context);
    }

    protected void onOk() {
        super.onOk();
        ai.m3980a().m3922d(this.f6316a);
        this.f6317b.mo1728a(false);
    }

    protected void onCancel() {
        super.onCancel();
        this.f6317b.mo1727a();
    }
}
