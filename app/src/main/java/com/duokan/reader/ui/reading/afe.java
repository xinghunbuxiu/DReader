package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class afe implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ afd f9629a;

    afe(afd afd) {
        this.f9629a = afd;
    }

    public void onClick(View view) {
        this.f9629a.requestDetach();
    }
}
