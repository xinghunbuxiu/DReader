package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.UserAccount;
import java.util.concurrent.Callable;
import org.json.JSONObject;

class di implements Callable<String> {
    /* renamed from: a */
    final /* synthetic */ ci f7729a;

    di(ci ciVar) {
        this.f7729a = ciVar;
    }

    public /* synthetic */ Object call() {
        return m11083a();
    }

    /* renamed from: a */
    public String m11083a() {
        UserAccount d = C0709k.m3476a().m3508d();
        if (d == null || d.mo839i()) {
            return new JSONObject().toString();
        }
        JSONObject a = d.mo849s().m8459a();
        a.remove("user_id");
        return a.toString();
    }
}
