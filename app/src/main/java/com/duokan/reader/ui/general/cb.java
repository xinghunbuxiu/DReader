package com.duokan.reader.ui.general;

import android.view.View;
import android.view.View.OnClickListener;

class cb implements OnClickListener {
    final /* synthetic */ bz a;

    cb(bz bzVar) {
        this.a = bzVar;
    }

    public void onClick(View view) {
        this.a.c();
        this.a.dismiss();
    }
}
