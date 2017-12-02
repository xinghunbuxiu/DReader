package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class vm implements OnClickListener {
    final /* synthetic */ vd a;

    vm(vd vdVar) {
        this.a = vdVar;
    }

    public void onClick(View view) {
        this.a.a.ae().f(Math.max(this.a.e, Math.min(this.a.a.ae().x() - this.a.a.ae().c, this.a.f)));
        this.a.a.ae().Y();
        this.a.a.aB();
        this.a.a();
    }
}
