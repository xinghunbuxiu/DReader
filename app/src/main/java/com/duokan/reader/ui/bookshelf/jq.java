package com.duokan.reader.ui.bookshelf;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class jq implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ jp f6688a;

    jq(jp jpVar) {
        this.f6688a = jpVar;
    }

    public void onClick(View view) {
        this.f6688a.getContext().startActivity(new Intent("android.settings.WIFI_SETTINGS"));
    }
}
