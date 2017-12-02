package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class xj implements OnClickListener {
    final /* synthetic */ xh a;

    xj(xh xhVar) {
        this.a = xhVar;
    }

    public void onClick(View view) {
        this.a.i.b(this.a.h);
        this.a.requestDetach();
    }
}
