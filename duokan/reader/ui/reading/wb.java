package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.ReaderEnv;

class wb implements OnClickListener {
    final /* synthetic */ vq a;

    wb(vq vqVar) {
        this.a = vqVar;
    }

    public void onClick(View view) {
        view.setSelected(!view.isSelected());
        ReaderEnv.get().setKeepReading(view.isSelected());
    }
}
