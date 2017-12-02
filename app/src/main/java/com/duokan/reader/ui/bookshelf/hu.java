package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.core.app.e;
import com.duokan.core.ui.dv;

class hu implements OnClickListener {
    final /* synthetic */ e a;
    final /* synthetic */ hp b;

    hu(hp hpVar, e eVar) {
        this.b = hpVar;
        this.a = eVar;
    }

    public void onClick(View view) {
        dv.c(this.a.getContentView(), new hv(this));
    }
}
