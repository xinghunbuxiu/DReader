package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.domain.cloud.fl;

class go implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ fz f8616a;

    go(fz fzVar) {
        this.f8616a = fzVar;
    }

    public void onClick(View view) {
        this.f8616a.m11853a("cart");
        fl.m5554a().m5564c();
        this.f8616a.m11862b(false, new gp(this));
    }
}
