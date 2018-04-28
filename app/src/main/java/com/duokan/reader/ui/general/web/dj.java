package com.duokan.reader.ui.general.web;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.duokan.core.sys.C0373z;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.User;
import com.duokan.reader.domain.account.bd;
import com.duokan.reader.domain.account.cm;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import java.util.Map;
import java.util.concurrent.Callable;
import org.json.JSONObject;

class dj implements Callable<String> {
    /* renamed from: a */
    final /* synthetic */ ci f7730a;

    dj(ci ciVar) {
        this.f7730a = ciVar;
    }

    public /* synthetic */ Object call() {
        return m11084a();
    }

    /* renamed from: a */
    public String m11084a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("device_id", ReaderEnv.get().getDeviceId());
        jSONObject.put("app_id", ReaderEnv.get().getAppId());
        jSONObject.put("build", ReaderEnv.get().getVersionCode());
        jSONObject.put("version_name", ReaderEnv.get().getVersionName());
        jSONObject.put("phone", Build.MODEL);
        jSONObject.put("sys_version", VERSION.RELEASE);
        CharSequence distChannel = ReaderEnv.get().getDistChannel();
        if (!TextUtils.isEmpty(distChannel)) {
            jSONObject.put("ch", distChannel);
        }
        jSONObject.put("api", "2");
        jSONObject.put("user_type", "" + PersonalPrefs.m5175a().m5210b());
        jSONObject.put("user_gender", "" + Math.max(0, PersonalPrefs.m5175a().m5229g()));
        jSONObject.put("hidden_channels", PersonalPrefs.m5175a().m5222d());
        jSONObject.put("user_preference", PersonalPrefs.m5175a().m5225e());
        if (!TextUtils.isEmpty(C0709k.m3476a().m3514i())) {
            jSONObject.put("device_hash", C0709k.m3476a().m3514i());
        }
        if (ReaderEnv.get().getBuildName().equals("Reader")) {
            jSONObject.put("_n", "1");
        }
        if (C0373z.m1052a()) {
            jSONObject.put("_m", "1");
        }
        C0672a b = C0709k.m3476a().m3502b(PersonalAccount.class);
        if (!(b == null || b.mo839i())) {
            Map h = b.mo838h();
            if (h != null) {
                for (String str : h.keySet()) {
                    jSONObject.put(str, h.get(str));
                }
            }
            if (b.mo836f() instanceof bd) {
                jSONObject.put("serviceToken", ((bd) b.mo836f()).f2402b);
            }
        }
        cm g = C0709k.m3476a().m3512g();
        if (g != null) {
            Map a = g.m3446a();
            if (a != null) {
                for (String str2 : a.keySet()) {
                    jSONObject.put(str2, a.get(str2));
                }
            }
        }
        try {
            User h2 = C0709k.m3476a().m3513h();
            if (h2 != null) {
                jSONObject.put("nickname", h2.mNickName);
                jSONObject.put("iconUrl", h2.mIconUrl);
            }
        } catch (Throwable th) {
        }
        return jSONObject.toString();
    }
}
