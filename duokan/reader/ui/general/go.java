package com.duokan.reader.ui.general;

import android.view.View;
import android.view.View.OnClickListener;

class go implements OnClickListener {
    final /* synthetic */ bx a;
    final /* synthetic */ gn b;

    go(gn gnVar, bx bxVar) {
        this.b = gnVar;
        this.a = bxVar;
    }

    public void onClick(View view) {
        this.a.cancel();
    }
}
