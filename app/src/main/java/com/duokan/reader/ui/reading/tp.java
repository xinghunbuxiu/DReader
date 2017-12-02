package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class tp implements OnClickListener {
    final /* synthetic */ to a;

    tp(to toVar) {
        this.a = toVar;
    }

    public void onClick(View view) {
        this.a.requestDetach();
    }
}
