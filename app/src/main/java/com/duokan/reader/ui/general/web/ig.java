package com.duokan.reader.ui.general.web;

import android.text.TextUtils;
import com.duokan.reader.ui.account.ae;
import com.duokan.reader.ui.account.bl;

class ig implements ae {
    /* renamed from: a */
    final /* synthetic */ C1362if f7990a;

    ig(C1362if c1362if) {
        this.f7990a = c1362if;
    }

    public void onChoiced(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f7990a.f7989g.f7982b.f7581b.mShareController = new bl(this.f7990a.f7989g.f7982b.f7581b.getContext(), false, str, this.f7990a.f7983a, this.f7990a.f7984b, this.f7990a.f7985c, this.f7990a.f7986d, this.f7990a.f7987e, this.f7990a.f7988f, null);
            this.f7990a.f7989g.f7982b.f7581b.addSubController(this.f7990a.f7989g.f7982b.f7581b.mShareController);
            this.f7990a.f7989g.f7982b.f7581b.activate(this.f7990a.f7989g.f7982b.f7581b.mShareController);
        }
    }
}
