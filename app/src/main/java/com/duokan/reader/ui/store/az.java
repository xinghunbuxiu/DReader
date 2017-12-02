package com.duokan.reader.ui.store;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.common.async.a.a;

class az implements OnClickListener {
    final /* synthetic */ a a;
    final /* synthetic */ ay b;

    az(ay ayVar, a aVar) {
        this.b = ayVar;
        this.a = aVar;
    }

    public void onClick(View view) {
        this.b.dismiss();
        this.a.a(null);
    }
}
