package com.duokan.reader.domain.plugins.dict;

import android.content.Context;

import com.duokan.reader.ui.general.ap;

import java.io.File;

class e extends ap {
    final /* synthetic */ d a;

    e(d dVar, Context context) {
        this.a = dVar;
        super(context);
    }

    protected void onOk() {
        new File(j.a + File.separator + this.a.a.c()).delete();
        this.a.c.h(this.a.b, 1);
        super.onOk();
    }
}
