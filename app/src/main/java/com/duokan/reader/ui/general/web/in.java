package com.duokan.reader.ui.general.web;

import android.text.TextUtils;
import com.duokan.reader.ui.account.ae;
import com.duokan.reader.ui.account.ar;
import com.duokan.reader.ui.account.bu;

class in implements ae {
    /* renamed from: a */
    final /* synthetic */ bu f8004a;
    /* renamed from: b */
    final /* synthetic */ il f8005b;

    in(il ilVar, bu buVar) {
        this.f8005b = ilVar;
        this.f8004a = buVar;
    }

    public void onChoiced(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f8005b.f8002f.f7996b.f7581b.mShareController = new ar(this.f8005b.f8002f.f7996b.f7581b.getContext(), str, this.f8005b.f7999c, this.f8005b.f8000d, this.f8005b.f8001e, this.f8004a);
            this.f8005b.f8002f.f7996b.f7581b.addSubController(this.f8005b.f8002f.f7996b.f7581b.mShareController);
            this.f8005b.f8002f.f7996b.f7581b.activate(this.f8005b.f8002f.f7996b.f7581b.mShareController);
        }
    }
}
