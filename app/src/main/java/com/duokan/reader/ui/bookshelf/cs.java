package com.duokan.reader.ui.bookshelf;

import android.content.Context;

import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.eh;
import com.duokan.reader.ui.general.ap;

class cs extends ap {
    final /* synthetic */ c a;
    final /* synthetic */ eh b;
    final /* synthetic */ cr c;

    cs(cr crVar, Context context, c cVar, eh ehVar) {
        this.c = crVar;
        this.a = cVar;
        this.b = ehVar;
        super(context);
    }

    protected void onOk() {
        super.onOk();
        ai.a().d(this.a);
        this.b.a(false);
    }

    protected void onCancel() {
        super.onCancel();
        this.b.a();
    }
}
