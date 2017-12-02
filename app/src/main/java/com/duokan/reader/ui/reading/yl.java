package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.UmengManager;

class yl implements OnClickListener {
    final /* synthetic */ yk a;

    yl(yk ykVar) {
        this.a = ykVar;
    }

    public void onClick(View view) {
        UmengManager.get().onEvent("V2_READING_POPMENU", "ShareImage");
        this.a.a.dismiss();
        this.a.d.a(this.a.b, this.a.c);
    }
}
