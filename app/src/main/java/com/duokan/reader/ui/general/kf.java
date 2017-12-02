package com.duokan.reader.ui.general;

import android.view.View;
import android.view.View.OnClickListener;

class kf implements OnClickListener {
    final /* synthetic */ jy a;

    kf(jy jyVar) {
        this.a = jyVar;
    }

    public void onClick(View view) {
        this.a.onBack();
    }
}
