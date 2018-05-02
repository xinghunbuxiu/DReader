package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

class kr implements OnClickListener {
    final /* synthetic */ TextView a;
    final /* synthetic */ TextView b;
    final /* synthetic */ TextView c;
    final /* synthetic */ ko d;

    kr(ko koVar, TextView textView, TextView textView2, TextView textView3) {
        this.d = koVar;
        this.a = textView;
        this.b = textView2;
        this.c = textView3;
    }

    public void onClick(View view) {
        this.d.m.a(1);
        this.a.setSelected(false);
        this.b.setSelected(true);
        this.c.setSelected(false);
    }
}
