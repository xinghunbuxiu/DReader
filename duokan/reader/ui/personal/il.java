package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.common.SysTools;

class il implements OnClickListener {
    final /* synthetic */ String a;
    final /* synthetic */ ih b;

    il(ih ihVar, String str) {
        this.b = ihVar;
        this.a = str;
    }

    public void onClick(View view) {
        SysTools.sendMmsSms(this.b.getContext(), this.a);
    }
}
