package com.duokan.reader.ui.account;

import android.text.TextUtils;

import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.b;
import com.duokan.reader.ui.general.be;

class c implements b {
    final /* synthetic */ MiAccountAssist a;

    c(MiAccountAssist miAccountAssist) {
        this.a = miAccountAssist;
    }

    public void a(a aVar) {
        com.duokan.reader.domain.statistics.dailystats.a.d().b("s");
        if (!this.a.a(aVar, false)) {
            this.a.a(aVar, "");
        }
    }

    public void a(a aVar, String str) {
        if (!TextUtils.isEmpty(str)) {
            be.a(this.a.b, (CharSequence) str, 1).show();
        }
        com.duokan.reader.domain.statistics.dailystats.a.d().b("f");
        this.a.a(aVar, str);
    }
}
