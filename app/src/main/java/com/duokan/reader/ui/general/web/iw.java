package com.duokan.reader.ui.general.web;

import android.text.TextUtils;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.domain.cloud.ft;
import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.domain.store.DkStoreFictionDetail;
import java.util.concurrent.Callable;
import org.json.JSONObject;

class iw implements Callable<Boolean> {
    /* renamed from: a */
    final /* synthetic */ String f8019a;
    /* renamed from: b */
    final /* synthetic */ ci f8020b;

    iw(ci ciVar, String str) {
        this.f8020b = ciVar;
        this.f8019a = str;
    }

    public /* synthetic */ Object call() {
        return m11207a();
    }

    /* renamed from: a */
    public Boolean m11207a() {
        if (TextUtils.isEmpty(this.f8019a)) {
            return Boolean.valueOf(false);
        }
        C0800c a;
        JSONObject jSONObject = new JSONObject(this.f8019a);
        String optString = jSONObject.optString("trace_id");
        if (jSONObject.has("book_id")) {
            a = ai.m3980a().m3875a(new DkStoreBookDetail(jSONObject));
            a.m4235j(optString);
        } else {
            a = ai.m3980a().m3875a(new DkStoreFictionDetail(jSONObject));
            a.m4235j(optString);
        }
        if (a == null) {
            return Boolean.valueOf(false);
        }
        if (!PersonalPrefs.m5175a().m5239o()) {
            ft.m5575a().m5583a(a.ar());
        }
        return Boolean.valueOf(true);
    }
}
