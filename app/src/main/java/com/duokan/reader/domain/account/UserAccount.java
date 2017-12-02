package com.duokan.reader.domain.account;

import android.content.Context;
import android.text.TextUtils;

import com.duokan.reader.domain.social.b.b;

import java.util.HashMap;
import java.util.Map;

public abstract class UserAccount extends a {
    public abstract void a(Context context, String str, bb bbVar);

    public abstract b s();

    public abstract void t();

    public abstract void u();

    public abstract cf v();

    public UserAccount(e eVar) {
        super(eVar);
    }

    public static Map a(String str, String str2) {
        Map hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("user_id", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("token", str2);
        }
        return hashMap;
    }
}
