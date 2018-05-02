package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

class ag implements OnClickListener {
    final /* synthetic */ ae a;

    ag(ae aeVar) {
        this.a = aeVar;
    }

    public void onClick(View view) {
        this.a.requestDetach();
    }
}
