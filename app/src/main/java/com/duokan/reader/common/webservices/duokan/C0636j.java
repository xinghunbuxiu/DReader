package com.duokan.reader.common.webservices.duokan;

import android.text.TextUtils;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.domain.account.al;
import com.mipay.sdk.Mipay;
import java.util.ArrayList;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.common.webservices.duokan.j */
public class C0636j extends ac {
    public C0636j(WebSession webSession, al alVar) {
        super(webSession, alVar);
    }

    /* renamed from: a */
    public C0621a<Void> m2876a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("app");
        arrayList.add(str);
        arrayList.add("book_id");
        arrayList.add(str2);
        arrayList.add("book_name");
        arrayList.add(str3);
        arrayList.add("revision");
        arrayList.add(str4);
        arrayList.add("position");
        arrayList.add(str5);
        arrayList.add("ref_chapter");
        arrayList.add(str6);
        arrayList.add("reference");
        arrayList.add(str7);
        if (!TextUtils.isEmpty(str8)) {
            arrayList.add("suggestion");
            arrayList.add(str8);
        }
        arrayList.add("convertcht");
        arrayList.add(Boolean.toString(z));
        JSONObject a = m547a(mo376a(m555a(true, C0641o.m2934i().m2988o() + "/report_bug/book", (String[]) arrayList.toArray(new String[0]))));
        C0621a<Void> c0621a = new C0621a();
        a = a.getJSONObject("status");
        c0621a.b = a.getInt(Mipay.KEY_CODE);
        c0621a.c = a.getString(Mipay.KEY_MESSAGE);
        return c0621a;
    }
}
