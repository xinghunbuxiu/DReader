package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class n implements OnClickListener {
    final /* synthetic */ k a;

    n(k kVar) {
        this.a = kVar;
    }

    public void onClick(View view) {
        if (this.a.d != null) {
            this.a.d.a(this.a.c.getText().toString());
        }
        this.a.b.dismiss();
    }
}
