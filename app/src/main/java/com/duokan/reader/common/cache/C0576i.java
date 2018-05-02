package com.duokan.reader.common.cache;

import android.text.TextUtils;

/* renamed from: com.duokan.reader.common.cache.i */
public class C0576i implements C0575q<String> {
    /* renamed from: a */
    public static final C0576i f1884a = new C0576i();

    /* renamed from: a */
    public /* synthetic */ String mo776a(Object obj) {
        return m2580b((String) obj);
    }

    /* renamed from: b */
    public /* synthetic */ boolean mo777b(Object obj) {
        return m2579a((String) obj);
    }

    /* renamed from: d */
    public /* synthetic */ Object mo778d(String str) {
        return m2582c(str);
    }

    /* renamed from: a */
    public final boolean m2579a(String str) {
        return TextUtils.isEmpty(str);
    }

    /* renamed from: b */
    public final String m2580b(String str) {
        return TextUtils.isEmpty(str) ? "" : str;
    }

    /* renamed from: c */
    public final String m2582c(String str) {
        return TextUtils.isEmpty(str) ? "" : str;
    }
}
