package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.common.j;

class il implements OnClickListener {
    final /* synthetic */ String a;
    final /* synthetic */ ih b;

    il(ih ihVar, String str) {
        this.b = ihVar;
        this.a = str;
    }

    public void onClick(View view) {
        j.a(this.b.getContext(), this.a);
    }
}
