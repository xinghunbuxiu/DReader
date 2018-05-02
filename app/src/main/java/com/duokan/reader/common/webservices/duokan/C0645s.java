package com.duokan.reader.common.webservices.duokan;

import android.text.TextUtils;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.p040a.C0624a;
import com.duokan.reader.domain.account.al;
import java.util.ArrayList;

/* renamed from: com.duokan.reader.common.webservices.duokan.s */
public class C0645s extends ac {
    public C0645s(WebSession webSession, al alVar) {
        super(webSession, alVar);
    }

    /* renamed from: a */
    public void m3006a(String str, int i) {
        mo376a(m562b(true, C0641o.m2934i().m2987n() + "/hs/static/_track_", "adbookshelf", i + ":" + str));
    }

    /* renamed from: a */
    public void m3005a(C0628a c0628a) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("c");
        arrayList.add(c0628a.f2093a);
        arrayList.add("a");
        arrayList.add(c0628a.f2095c);
        arrayList.add("l");
        arrayList.add(c0628a.f2094b);
        arrayList.add("v");
        arrayList.add(String.valueOf(c0628a.f2096d));
        arrayList.add("t");
        arrayList.add(String.valueOf(c0628a.f2097e));
        arrayList.add("f");
        arrayList.add(c0628a.f2098f);
        mo376a(m562b(true, C0641o.m2934i().m2987n() + "/hs/static/_track_", (String[]) arrayList.toArray(new String[0])));
    }

    /* renamed from: e */
    public void m3008e(String str) {
        mo376a(m562b(true, C0641o.m2934i().m2987n() + "/stat/_track_", "page", str));
    }

    /* renamed from: a */
    public void m3007a(String str, String[] strArr, String str2) {
        C0624a b = m562b(true, C0641o.m2934i().m2987n() + "/stat/" + str, strArr);
        if (!TextUtils.isEmpty(str2)) {
            b = m562b(true, b.m2836b() + str2, new String[0]);
        }
        mo376a(b);
    }
}
