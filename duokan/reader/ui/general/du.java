package com.duokan.reader.ui.general;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.duokan.core.app.MyContextWrapper;
import com.duokan.reader.ui.surfing.af;

class du implements OnClickListener {
    final /* synthetic */ TextView a;
    final /* synthetic */ ds b;

    du(ds dsVar, TextView textView) {
        this.b = dsVar;
        this.a = textView;
    }

    public void onClick(View view) {
        int a = this.b.a(this.a);
        if (this.b.b != a) {
            this.b.a(a);
        } else {
            ((af) MyContextWrapper.getFeature(this.b.getContext()).queryFeature(af.class)).k();
        }
    }
}
