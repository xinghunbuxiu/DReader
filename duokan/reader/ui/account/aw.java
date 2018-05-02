package com.duokan.reader.ui.account;

import android.view.View;
import android.view.View.OnClickListener;

class aw implements OnClickListener {
    final /* synthetic */ as a;
    final /* synthetic */ au b;

    aw(au auVar, as asVar) {
        this.b = auVar;
        this.a = asVar;
    }

    public void onClick(View view) {
        if (this.a != null) {
            this.a.onChoiced(null);
        }
    }
}
