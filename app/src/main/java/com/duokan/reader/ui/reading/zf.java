package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class zf implements OnClickListener {
    final /* synthetic */ yr a;

    zf(yr yrVar) {
        this.a = yrVar;
    }

    public void onClick(View view) {
        this.a.D.put("Action1", "COPY");
        this.a.F.e();
    }
}
