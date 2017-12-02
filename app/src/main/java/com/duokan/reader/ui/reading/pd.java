package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class pd implements OnClickListener {
    final /* synthetic */ int a;
    final /* synthetic */ pc b;

    pd(pc pcVar, int i) {
        this.b = pcVar;
        this.a = i;
    }

    public void onClick(View view) {
        if (this.b.b == null) {
            this.b.a(this.a);
        }
    }
}
