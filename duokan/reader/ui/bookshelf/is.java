package com.duokan.reader.ui.bookshelf;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class is implements OnClickListener {
    final /* synthetic */ ir a;

    is(ir irVar) {
        this.a = irVar;
    }

    public void onClick(View view) {
        this.a.getContext().startActivity(new Intent("android.settings.WIFI_SETTINGS"));
    }
}
