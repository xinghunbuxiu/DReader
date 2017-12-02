package com.duokan.reader.domain.store;

import android.view.View;
import android.view.View.OnClickListener;

class t implements OnClickListener {
    final /* synthetic */ r a;

    t(r rVar) {
        this.a = rVar;
    }

    public void onClick(View view) {
        this.a.dismiss();
        this.a.onCancel();
    }
}
