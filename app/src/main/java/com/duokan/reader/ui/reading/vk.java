package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class vk implements OnClickListener {
    final /* synthetic */ vd a;

    vk(vd vdVar) {
        this.a = vdVar;
    }

    public void onClick(View view) {
        this.a.a.ae().e(Math.max(this.a.a.ae().i, Math.min(this.a.a.ae().u() - 1.0f, this.a.a.ae().j)));
        this.a.a.ae().Y();
        this.a.a.aB();
        this.a.a();
    }
}
