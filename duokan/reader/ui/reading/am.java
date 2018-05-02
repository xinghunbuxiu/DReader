package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class am implements OnClickListener {
    final /* synthetic */ al a;

    am(al alVar) {
        this.a = alVar;
    }

    public void onClick(View view) {
        this.a.requestDetach();
    }
}
