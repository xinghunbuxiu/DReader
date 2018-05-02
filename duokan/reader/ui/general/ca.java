package com.duokan.reader.ui.general;

import android.view.View;
import android.view.View.OnClickListener;

class ca implements OnClickListener {
    final /* synthetic */ bz a;

    ca(bz bzVar) {
        this.a = bzVar;
    }

    public void onClick(View view) {
        this.a.cancel();
    }
}
