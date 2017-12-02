package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

class ks implements OnClickListener {
    final /* synthetic */ TextView a;
    final /* synthetic */ TextView b;
    final /* synthetic */ TextView c;
    final /* synthetic */ ko d;

    ks(ko koVar, TextView textView, TextView textView2, TextView textView3) {
        this.d = koVar;
        this.a = textView;
        this.b = textView2;
        this.c = textView3;
    }

    public void onClick(View view) {
        this.d.m.a(2);
        this.a.setSelected(false);
        this.b.setSelected(false);
        this.c.setSelected(true);
    }
}
