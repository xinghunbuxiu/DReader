package com.duokan.reader.ui.general.web;

import android.text.TextUtils;

import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.domain.cloud.gn;
import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.domain.store.DkStoreFictionDetail;

import org.json.JSONObject;

import java.util.concurrent.Callable;

class ij implements Callable {
    final /* synthetic */ String a;
    final /* synthetic */ cg b;

    ij(cg cgVar, String str) {
        this.b = cgVar;
        this.a = str;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public Boolean a() {
        if (TextUtils.isEmpty(this.a)) {
            return Boolean.valueOf(false);
        }
        c a;
        JSONObject jSONObject = new JSONObject(this.a);
        String optString = jSONObject.optString("trace_id");
        if (jSONObject.has("book_id")) {
            a = ai.a().a(new DkStoreBookDetail(jSONObject));
            a.j(optString);
        } else {
            a = ai.a().a(new DkStoreFictionDetail(jSONObject));
            a.j(optString);
        }
        if (a == null) {
            return Boolean.valueOf(false);
        }
        if (!PersonalPrefs.a().o()) {
            gn.a().a(a.ap());
        }
        return Boolean.valueOf(true);
    }
}
