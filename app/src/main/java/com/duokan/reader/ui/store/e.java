package com.duokan.reader.ui.store;

import android.view.View;
import android.view.View.OnClickListener;

class e implements OnClickListener {
    final /* synthetic */ a a;

    e(a aVar) {
        this.a = aVar;
    }

    public void onClick(View view) {
        this.a.requestDetach();
    }
}
