package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class wc implements OnClickListener {
    final /* synthetic */ vq a;

    wc(vq vqVar) {
        this.a = vqVar;
    }

    public void onClick(View view) {
        view.setSelected(!view.isSelected());
        this.a.a.c(view.isSelected());
    }
}
