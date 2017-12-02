package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class zd implements OnClickListener {
    final /* synthetic */ yr a;

    zd(yr yrVar) {
        this.a = yrVar;
    }

    public void onClick(View view) {
        this.a.D.put("Action1", "SHARE");
        this.a.F.b();
    }
}
