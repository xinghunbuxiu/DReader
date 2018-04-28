package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.UmengManager;
import com.duokan.reader.domain.account.C0709k;

class gy implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ fz f8626a;

    gy(fz fzVar) {
        this.f8626a = fzVar;
    }

    public void onClick(View view) {
        UmengManager.get().onEvent("V2_PERSONAL_HEADER_BUTTON", "Messages");
        if (C0709k.m3476a().m3507c()) {
            this.f8626a.m11881g(true);
        } else {
            this.f8626a.m11879f(true);
        }
    }
}
