package com.duokan.reader.common.webservices.duokan;

import android.text.TextUtils;

import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.domain.account.ab;
import com.mipay.sdk.Mipay;

import org.json.JSONObject;

import java.util.ArrayList;

public class j extends ad {
    public j(WebSession webSession, ab abVar) {
        super(webSession, abVar);
    }

    public b a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9) {
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
        JSONObject a = a(a(a(true, p.i().o() + "/report_bug/book", (String[]) arrayList.toArray(new String[0]))));
        b bVar = new b();
        a = a.getJSONObject("status");
        bVar.b = a.getInt(Mipay.KEY_CODE);
        bVar.c = a.getString(Mipay.KEY_MESSAGE);
        return bVar;
    }
}
