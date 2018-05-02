package com.duokan.reader.ui.bookshelf;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class je implements OnClickListener {
    final /* synthetic */ jd a;

    je(jd jdVar) {
        this.a = jdVar;
    }

    public void onClick(View view) {
        this.a.getContext().startActivity(new Intent("android.settings.WIFI_SETTINGS"));
    }
}
