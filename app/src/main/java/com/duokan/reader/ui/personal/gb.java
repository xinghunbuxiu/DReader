package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.domain.cloud.gf;

class gb implements OnClickListener {
    final /* synthetic */ fl a;

    gb(fl flVar) {
        this.a = flVar;
    }

    public void onClick(View view) {
        this.a.a("cart");
        gf.a().c();
        this.a.b(false, new gc(this));
    }
}
