package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class ya implements OnClickListener {
    final /* synthetic */ xz a;

    ya(xz xzVar) {
        this.a = xzVar;
    }

    public void onClick(View view) {
        this.a.requestDetach();
    }
}
