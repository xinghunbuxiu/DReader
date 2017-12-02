package com.duokan.reader.ui.a;

import android.view.View;
import android.view.View.OnClickListener;

class f implements OnClickListener {
    final /* synthetic */ a a;

    f(a aVar) {
        this.a = aVar;
    }

    public void onClick(View view) {
        this.a.requestDetach();
    }
}
