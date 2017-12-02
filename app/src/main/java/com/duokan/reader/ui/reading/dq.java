package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

class dq implements OnClickListener {
    final /* synthetic */ TextView a;
    final /* synthetic */ de b;

    dq(de deVar, TextView textView) {
        this.b = deVar;
        this.a = textView;
    }

    public void onClick(View view) {
        if (this.a.getMaxLines() != 5) {
            this.a.setMaxLines(5);
        } else {
            this.a.setMaxLines(Integer.MAX_VALUE);
        }
    }
}
