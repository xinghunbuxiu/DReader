package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class zc implements OnClickListener {
    final /* synthetic */ yr a;

    zc(yr yrVar) {
        this.a = yrVar;
    }

    public void onClick(View view) {
        this.a.D.put("Action2", "CORRECT");
        this.a.F.d();
    }
}
