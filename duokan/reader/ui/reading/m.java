package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class m implements OnClickListener {
    final /* synthetic */ k a;

    m(k kVar) {
        this.a = kVar;
    }

    public void onClick(View view) {
        this.a.b.cancel();
        if (this.a.d != null) {
            this.a.d.a();
        }
    }
}
