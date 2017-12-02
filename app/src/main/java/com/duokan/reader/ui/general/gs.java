package com.duokan.reader.ui.general;

import android.view.View;
import android.view.View.OnClickListener;

class gs implements OnClickListener {
    final /* synthetic */ gr a;

    gs(gr grVar) {
        this.a = grVar;
    }

    public void onClick(View view) {
        this.a.a.requestBack();
    }
}
