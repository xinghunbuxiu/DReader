package com.duokan.reader.ui.bookshelf;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class kc implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ kb f6707a;

    kc(kb kbVar) {
        this.f6707a = kbVar;
    }

    public void onClick(View view) {
        this.f6707a.getContext().startActivity(new Intent("android.settings.WIFI_SETTINGS"));
    }
}
