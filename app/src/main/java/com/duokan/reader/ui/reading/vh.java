package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class vh implements OnClickListener {
    final /* synthetic */ vd a;

    vh(vd vdVar) {
        this.a = vdVar;
    }

    public void onClick(View view) {
        this.a.a.ae().d(Math.max(this.a.a.ae().g, Math.min(this.a.a.ae().t() + 0.1f, this.a.a.ae().h)));
        this.a.a.ae().Y();
        this.a.a.aB();
        this.a.a();
    }
}
