package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

class dy implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ TextView f10052a;
    /* renamed from: b */
    final /* synthetic */ dg f10053b;

    dy(dg dgVar, TextView textView) {
        this.f10053b = dgVar;
        this.f10052a = textView;
    }

    public void onClick(View view) {
        if (this.f10052a.getMaxLines() != 5) {
            this.f10052a.setMaxLines(5);
        } else {
            this.f10052a.setMaxLines(Integer.MAX_VALUE);
        }
    }
}
