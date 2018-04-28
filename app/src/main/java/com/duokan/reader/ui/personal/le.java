package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

class le implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ TextView f8872a;
    /* renamed from: b */
    final /* synthetic */ TextView f8873b;
    /* renamed from: c */
    final /* synthetic */ TextView f8874c;
    /* renamed from: d */
    final /* synthetic */ lc f8875d;

    le(lc lcVar, TextView textView, TextView textView2, TextView textView3) {
        this.f8875d = lcVar;
        this.f8872a = textView;
        this.f8873b = textView2;
        this.f8874c = textView3;
    }

    public void onClick(View view) {
        this.f8875d.f8860n.mo1943a(0);
        this.f8872a.setSelected(true);
        this.f8873b.setSelected(false);
        this.f8874c.setSelected(false);
    }
}
