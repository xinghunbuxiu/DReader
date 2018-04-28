package com.duokan.reader.ui.general.web;

import android.content.Intent;
import android.text.TextUtils;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.ad.C0746c;
import com.duokan.reader.domain.ad.C0748e;
import com.duokan.reader.domain.ad.C0750g;
import com.duokan.reader.domain.ad.C0761r;
import com.duokan.reader.domain.ad.C0767x;
import java.util.concurrent.Callable;
import org.json.JSONObject;

class kg implements Callable<Boolean> {
    /* renamed from: a */
    final /* synthetic */ String f8093a;
    /* renamed from: b */
    final /* synthetic */ ci f8094b;

    kg(ci ciVar, String str) {
        this.f8094b = ciVar;
        this.f8093a = str;
    }

    public /* synthetic */ Object call() {
        return m11254a();
    }

    /* renamed from: a */
    public Boolean m11254a() {
        if (!ReaderEnv.get().onMiui()) {
            return Boolean.valueOf(false);
        }
        JSONObject jSONObject = new JSONObject(this.f8093a);
        C0748e a = C0748e.m3555a(jSONObject.getString("item"));
        if (a == null || TextUtils.isEmpty(a.f2533r)) {
            return Boolean.valueOf(false);
        }
        this.f8094b.f7581b.mAdLifecycleManager.m3534b(a.f2533r, new kh(this, jSONObject, a));
        if (Intent.parseUri(new C0746c(this.f8094b.f7581b.getContext()).m3552a(a.f2533r), 0) == null) {
            return Boolean.valueOf(false);
        }
        C0750g.m3561a().m3588b(a);
        if (!C0767x.m3611a(this.f8094b.f7581b.getContext(), a.f2533r)) {
            this.f8094b.f7581b.mAdLifecycleManager.m3528a(a);
            if (this.f8094b.f7581b.mAdSdkService == null) {
                this.f8094b.f7581b.mAdSdkService = new C0761r(this.f8094b.f7581b.mAdLifecycleManager);
            }
            this.f8094b.f7581b.mAdSdkService.m3609a(a);
        }
        return Boolean.valueOf(true);
    }
}
