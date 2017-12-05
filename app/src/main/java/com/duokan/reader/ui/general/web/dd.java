package com.duokan.reader.ui.general.web;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;

import com.duokan.core.sys.z;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.User;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.bh;
import com.duokan.reader.domain.account.cf;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.cloud.PersonalPrefs;

import org.json.JSONObject;

import java.util.Map;
import java.util.concurrent.Callable;

class dd implements Callable {
    final /* synthetic */ PageController a;

    dd(PageController cgVar) {
        this.a = cgVar;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public String a() {
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
        jSONObject.put("user_type", "" + PersonalPrefs.a().b());
        jSONObject.put("user_gender", "" + Math.max(0, PersonalPrefs.a().g()));
        jSONObject.put("hidden_channels", PersonalPrefs.a().d());
        jSONObject.put("user_preference", PersonalPrefs.a().e());
        if (!TextUtils.isEmpty(i.f().i())) {
            jSONObject.put("device_hash", i.f().i());
        }
        if (ReaderEnv.get().getBuildName().equals("Reader")) {
            jSONObject.put("_n", "1");
        }
        if (z.a()) {
            jSONObject.put("_m", "1");
        }
        a b = i.f().b(PersonalAccount.class);
        if (!(b == null || b.i())) {
            Map h = b.h();
            if (h != null) {
                for (String str : h.keySet()) {
                    jSONObject.put(str, h.get(str));
                }
            }
            if (b.f() instanceof bh) {
                jSONObject.put("serviceToken", ((bh) b.f()).b);
            }
        }
        cf g = i.f().g();
        if (g != null) {
            Map a = g.a();
            if (a != null) {
                for (String str2 : a.keySet()) {
                    jSONObject.put(str2, a.get(str2));
                }
            }
        }
        try {
            User h2 = i.f().h();
            if (h2 != null) {
                jSONObject.put("nickname", h2.mNickName);
                jSONObject.put("iconUrl", h2.mIconUrl);
            }
        } catch (Throwable th) {
        }
        return jSONObject.toString();
    }
}
