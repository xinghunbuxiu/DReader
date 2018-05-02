package com.duokan.reader.ui.general;

import android.view.View;
import android.view.View.OnClickListener;

class jc implements OnClickListener {
    final /* synthetic */ ja a;

    jc(ja jaVar) {
        this.a = jaVar;
    }

    public void onClick(View view) {
        this.a.requestDetach();
    }
}
