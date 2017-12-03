package com.duokan.reader.ui.general;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.duokan.core.app.MyContextWrapper;
import com.duokan.reader.ui.surfing.af;

class ip implements OnClickListener {
    final /* synthetic */ TextView a;
    final /* synthetic */ ik b;

    ip(ik ikVar, TextView textView) {
        this.b = ikVar;
        this.a = textView;
    }

    public void onClick(View view) {
        int a = this.b.a(this.a);
        if (this.b.c != a) {
            this.b.b(a);
        } else {
            ((af) MyContextWrapper.getFeature(this.b.getContext()).queryFeature(af.class)).k();
        }
    }
}
