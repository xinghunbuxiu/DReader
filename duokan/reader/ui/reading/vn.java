package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class vn implements OnClickListener {
    final /* synthetic */ vd a;

    vn(vd vdVar) {
        this.a = vdVar;
    }

    public void onClick(View view) {
        this.a.a.ae().e(Math.max(this.a.e, Math.min(this.a.a.ae().v() + this.a.a.ae().d, this.a.f)));
        this.a.a.ae().Y();
        this.a.a.aB();
        this.a.a();
    }
}
