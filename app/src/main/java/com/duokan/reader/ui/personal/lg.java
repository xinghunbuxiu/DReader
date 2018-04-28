package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

class lg implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ TextView f8880a;
    /* renamed from: b */
    final /* synthetic */ TextView f8881b;
    /* renamed from: c */
    final /* synthetic */ TextView f8882c;
    /* renamed from: d */
    final /* synthetic */ lc f8883d;

    lg(lc lcVar, TextView textView, TextView textView2, TextView textView3) {
        this.f8883d = lcVar;
        this.f8880a = textView;
        this.f8881b = textView2;
        this.f8882c = textView3;
    }

    public void onClick(View view) {
        this.f8883d.f8860n.mo1943a(2);
        this.f8880a.setSelected(false);
        this.f8881b.setSelected(false);
        this.f8882c.setSelected(true);
    }
}
