package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class ze implements OnClickListener {
    final /* synthetic */ yr a;

    ze(yr yrVar) {
        this.a = yrVar;
    }

    public void onClick(View view) {
        this.a.D.put("Action2", "SHARE");
        this.a.F.b();
    }
}
