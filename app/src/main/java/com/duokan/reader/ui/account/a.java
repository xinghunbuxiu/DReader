package com.duokan.reader.ui.account;

import android.text.TextUtils;

import com.duokan.reader.domain.account.b;
import com.duokan.reader.ui.general.be;

class a implements b {
    final /* synthetic */ MiAccountAssist a;

    a(MiAccountAssist miAccountAssist) {
        this.a = miAccountAssist;
    }

    public void a(com.duokan.reader.domain.account.a aVar) {
        if (!this.a.a(aVar, true)) {
            this.a.a(aVar, "");
        }
    }

    public void a(com.duokan.reader.domain.account.a aVar, String str) {
        if (!TextUtils.isEmpty(str)) {
            be.a(this.a.b, (CharSequence) str, 1).show();
        }
        this.a.a(aVar, str);
    }
}
