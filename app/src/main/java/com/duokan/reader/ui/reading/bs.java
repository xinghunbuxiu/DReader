package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class bs implements OnClickListener {
    final /* synthetic */ long a;
    final /* synthetic */ bn b;

    bs(bn bnVar, long j) {
        this.b = bnVar;
        this.a = j;
    }

    public void onClick(View view) {
        this.b.u().d(this.a);
    }
}
