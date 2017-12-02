package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class eq implements OnClickListener {
    final /* synthetic */ en a;

    eq(en enVar) {
        this.a = enVar;
    }

    public void onClick(View view) {
        if (this.a.a) {
            this.a.a("FONT_URI_DEFAULT");
        } else {
            this.a.b("FONT_URI_DEFAULT");
        }
        this.a.b();
    }
}
