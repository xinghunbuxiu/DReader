package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class vg implements OnClickListener {
    final /* synthetic */ vd a;

    vg(vd vdVar) {
        this.a = vdVar;
    }

    public void onClick(View view) {
        this.a.a.ae().c(Math.max(this.a.a.ae().e, Math.min(this.a.a.ae().s() - 0.1f, this.a.a.ae().f)));
        this.a.a.ae().Y();
        this.a.a.aB();
        this.a.a();
    }
}
