package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class ew implements OnClickListener {
    final /* synthetic */ et a;

    ew(et etVar) {
        this.a = etVar;
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
