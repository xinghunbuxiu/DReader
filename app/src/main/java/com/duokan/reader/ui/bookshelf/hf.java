package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;

class hf implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ he f6545a;

    hf(he heVar) {
        this.f6545a = heVar;
    }

    public void onClick(View view) {
        if (this.f6545a.f6347g) {
            this.f6545a.requestBack();
        }
    }
}
