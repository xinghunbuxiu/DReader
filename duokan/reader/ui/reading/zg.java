package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class zg implements OnClickListener {
    final /* synthetic */ yr a;

    zg(yr yrVar) {
        this.a = yrVar;
    }

    public void onClick(View view) {
        this.a.D.put("Action2", "COPY");
        this.a.F.e();
    }
}
