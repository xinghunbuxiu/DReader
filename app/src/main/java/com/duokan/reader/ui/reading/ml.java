package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class ml implements OnClickListener {
    final /* synthetic */ int a;
    final /* synthetic */ mh b;

    ml(mh mhVar, int i) {
        this.b = mhVar;
        this.a = i;
    }

    public void onClick(View view) {
        this.b.e.a(this.a - 1);
    }
}
