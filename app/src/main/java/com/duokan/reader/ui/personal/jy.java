package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.domain.bookshelf.ai;

class jy implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ jg f8798a;

    jy(jg jgVar) {
        this.f8798a = jgVar;
    }

    public void onClick(View view) {
        ai.m3980a().mo972a(!view.isSelected());
        this.f8798a.m12047a();
    }
}
