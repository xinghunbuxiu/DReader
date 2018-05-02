package com.duokan.reader.ui.account;

import android.text.TextUtils;

import com.duokan.reader.domain.account.a;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.general.jq;

class b implements com.duokan.reader.domain.account.b {
    final /* synthetic */ jq a;
    final /* synthetic */ MiAccountAssist b;

    b(MiAccountAssist miAccountAssist, jq jqVar) {
        this.b = miAccountAssist;
        this.a = jqVar;
    }

    public void a(a aVar) {
        this.a.dismiss();
        com.duokan.reader.domain.statistics.dailystats.a.d().b("s");
        if (!this.b.a(aVar, false)) {
            this.b.a(aVar, "");
        }
    }

    public void a(a aVar, String str) {
        this.a.dismiss();
        if (!TextUtils.isEmpty(str)) {
            be.a(this.b.b, (CharSequence) str, 1).show();
        }
        com.duokan.reader.domain.statistics.dailystats.a.d().b("HttpLogger");
        this.b.a(aVar, str);
    }
}
