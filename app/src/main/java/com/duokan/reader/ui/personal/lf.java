package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

class lf implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ TextView f8876a;
    /* renamed from: b */
    final /* synthetic */ TextView f8877b;
    /* renamed from: c */
    final /* synthetic */ TextView f8878c;
    /* renamed from: d */
    final /* synthetic */ lc f8879d;

    lf(lc lcVar, TextView textView, TextView textView2, TextView textView3) {
        this.f8879d = lcVar;
        this.f8876a = textView;
        this.f8877b = textView2;
        this.f8878c = textView3;
    }

    public void onClick(View view) {
        this.f8879d.f8860n.mo1943a(1);
        this.f8876a.setSelected(false);
        this.f8877b.setSelected(true);
        this.f8878c.setSelected(false);
    }
}
