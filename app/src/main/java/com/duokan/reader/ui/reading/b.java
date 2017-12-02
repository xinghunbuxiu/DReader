package com.duokan.reader.ui.reading;

import android.content.Context;
import android.widget.TextView;

import com.duokan.core.ui.dv;

class b implements Runnable {
    final /* synthetic */ TextView a;
    final /* synthetic */ Context b;
    final /* synthetic */ a c;

    b(a aVar, TextView textView, Context context) {
        this.c = aVar;
        this.a = textView;
        this.b = context;
    }

    public void run() {
        if (this.a.getLineCount() == 1) {
            this.a.setPadding(0, dv.b(this.b, 10.0f), 0, 0);
        }
    }
}
