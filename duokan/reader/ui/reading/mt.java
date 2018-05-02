package com.duokan.reader.ui.reading;

import android.content.Context;

import com.duokan.reader.domain.document.aj;

class mt extends mv {
    final /* synthetic */ mr b;

    mt(mr mrVar, Context context, aj ajVar) {
        this.b = mrVar;
        super(context, ajVar);
    }

    public void a(int i, float f, float f2, float f3) {
        super.a(i, f, f2, f3);
        if (this.b.o()) {
            this.b.c.a(i);
        }
        this.b.a(i);
    }
}
