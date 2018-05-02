package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class xi implements OnClickListener {
    final /* synthetic */ xh a;

    xi(xh xhVar) {
        this.a = xhVar;
    }

    public void onClick(View view) {
        this.a.i.a(this.a.h);
        this.a.requestDetach();
    }
}
