package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class zb implements OnClickListener {
    final /* synthetic */ yr a;

    zb(yr yrVar) {
        this.a = yrVar;
    }

    public void onClick(View view) {
        this.a.D.put("Action1", "CORRECT");
        this.a.F.d();
    }
}
