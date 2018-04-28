package com.duokan.reader.domain.account;

import android.content.Context;
import android.text.TextUtils;
import com.duokan.reader.domain.social.p048b.C1135b;
import java.util.HashMap;
import java.util.Map;

public abstract class UserAccount extends C0672a {
    /* renamed from: a */
    public abstract void mo847a(Context context, String str, ba baVar);

    /* renamed from: s */
    public abstract C1135b mo849s();

    /* renamed from: t */
    public abstract void mo850t();

    /* renamed from: u */
    public abstract void mo851u();

    /* renamed from: v */
    public abstract cm mo852v();

    public UserAccount(C0706e c0706e) {
        super(c0706e);
    }

    /* renamed from: a */
    public static Map<String, String> m3175a(String str, String str2) {
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
